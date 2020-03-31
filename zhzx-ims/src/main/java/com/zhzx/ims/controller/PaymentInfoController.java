package com.zhzx.ims.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhzx.common.annotation.Log;
import com.zhzx.common.core.controller.BaseController;
import com.zhzx.common.core.domain.AjaxResult;
import com.zhzx.common.core.page.TableDataInfo;
import com.zhzx.common.enums.BusinessType;
import com.zhzx.common.utils.poi.ExcelUtil;
import com.zhzx.ims.domain.ContractInfo;
import com.zhzx.ims.domain.PaymentInfo;
import com.zhzx.ims.service.IContractInfoService;
import com.zhzx.ims.service.IPaymentInfoService;

/**
 * 付款信息Controller
 * 
 * @author kiver
 * @date 2019-12-04
 */
@Controller
@RequestMapping("/ims/paymentInfo")
public class PaymentInfoController extends BaseController
{
    private String prefix = "ims/paymentInfo";

    @Autowired
    private IPaymentInfoService paymentInfoService;
    @Autowired
    private IContractInfoService contractInfoService;
    @RequiresPermissions("ims:paymentInfo:view")
    @GetMapping()
    public String paymentInfo()
    {
        return prefix + "/paymentInfo";
    }

    /**
     * 查询付款信息列表
     */
    @RequiresPermissions("ims:paymentInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PaymentInfo paymentInfo)
    {
        startPage();
        List<PaymentInfo> list = paymentInfoService.selectPaymentInfoList(paymentInfo);
        return getDataTable(list);
    }
    /**
     * 查询付款信息列表
     */
    @RequiresPermissions("ims:paymentInfo:list")
    @PostMapping("/customerlist/{customerName}/{customerPhone}/{customerAddress}")
    @ResponseBody
    public TableDataInfo customerlist(@PathVariable("customerName") String customerName,@PathVariable("customerPhone") String customerPhone,@PathVariable("customerAddress") String customerAddress,PaymentInfo paymentInfo)
    {
    	startPage();
    	ContractInfo contractInfo = new ContractInfo();
        contractInfo.setCustomer(customerName);
     	contractInfo.setPhone(customerPhone);
     	contractInfo.setAddress(customerAddress);
        List<ContractInfo> ContractInfolist = contractInfoService.selectContractInfoCustomerList(contractInfo);
        if (ContractInfolist!=null && ContractInfolist.size()>0) {
        	paymentInfo.setParentId(ContractInfolist.get(0).getContractInfoId()+"");
 		}else {
 			paymentInfo.setParentId("你是什么都查不出来的！！");
 		}
    	List<PaymentInfo> list = paymentInfoService.selectPaymentInfoList(paymentInfo);
    	return getDataTable(list);
    }

    /**
     * 导出付款信息列表
     */
    @RequiresPermissions("ims:paymentInfo:export")
    @Log(title = "付款信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PaymentInfo paymentInfo)
    {
        List<PaymentInfo> list = paymentInfoService.selectPaymentInfoList(paymentInfo);
        ExcelUtil<PaymentInfo> util = new ExcelUtil<PaymentInfo>(PaymentInfo.class);
        return util.exportExcel(list, "paymentInfo");
    }

    /**
     * 新增付款信息
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") String parentId,ModelMap modelMap)
    {
    	modelMap.put("parentId", parentId);
        return prefix + "/add";
    }

    /**
     * 新增保存付款信息
     */
    @RequiresPermissions("ims:paymentInfo:add")
    @Log(title = "付款信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PaymentInfo paymentInfo)
    {
        return toAjax(paymentInfoService.insertPaymentInfo(paymentInfo));
    }

    /**
     * 修改付款信息
     */
    @GetMapping("/edit/{paymentInfoId}")
    public String edit(@PathVariable("paymentInfoId") Long paymentInfoId, ModelMap mmap)
    {
        PaymentInfo paymentInfo = paymentInfoService.selectPaymentInfoById(paymentInfoId);
        mmap.put("paymentInfo", paymentInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存付款信息
     */
    @RequiresPermissions("ims:paymentInfo:edit")
    @Log(title = "付款信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PaymentInfo paymentInfo)
    {
        return toAjax(paymentInfoService.updatePaymentInfo(paymentInfo));
    }

    /**
     * 删除付款信息
     */
    @RequiresPermissions("ims:paymentInfo:remove")
    @Log(title = "付款信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(paymentInfoService.deletePaymentInfoByIds(ids));
    }
}
