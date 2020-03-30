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
import com.zhzx.common.enums.BusinessType;
import com.zhzx.ims.domain.CustomerInfo;
import com.zhzx.ims.service.IContractInfoService;
import com.zhzx.ims.service.IContractMaterialInfoService;
import com.zhzx.ims.service.ICustomerInfoService;
import com.zhzx.ims.service.IPaymentInfoService;
import com.zhzx.common.core.controller.BaseController;
import com.zhzx.common.core.domain.AjaxResult;
import com.zhzx.common.utils.poi.ExcelUtil;
import com.zhzx.common.core.page.TableDataInfo;

/**
 * 客户信息Controller
 * 
 * @author kiver
 * @date 2019-12-04
 */
@Controller
@RequestMapping("/ims/customerInfo")
public class CustomerInfoController extends BaseController
{
    private String prefix = "ims/customerInfo";

    @Autowired
    private ICustomerInfoService customerInfoService;
    @Autowired
    private IContractInfoService contractInfoService;
    @Autowired
    private IContractMaterialInfoService contractMaterialInfoService;
    @Autowired
    private IPaymentInfoService paymentInfoService;
    

    @RequiresPermissions("ims:customerInfo:view")
    @GetMapping()
    public String customerInfo()
    {
        return prefix + "/customerInfo";
    }

    /**
     * 查询客户信息列表
     */
    @RequiresPermissions("ims:customerInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CustomerInfo customerInfo)
    {
        startPage();
        List<CustomerInfo> list = customerInfoService.selectCustomerInfoList(customerInfo);
        return getDataTable(list);
    }

    /**
     * 导出客户信息列表
     */
    @RequiresPermissions("ims:customerInfo:export")
    @Log(title = "客户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CustomerInfo customerInfo)
    {
        List<CustomerInfo> list = customerInfoService.selectCustomerInfoList(customerInfo);
        ExcelUtil<CustomerInfo> util = new ExcelUtil<CustomerInfo>(CustomerInfo.class);
        return util.exportExcel(list, "customerInfo");
    }

    /**
     * 新增客户信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存客户信息
     */
    @RequiresPermissions("ims:customerInfo:add")
    @Log(title = "客户信息", businessType = BusinessType.INSERT)
    @PostMapping("/add/{parentId}")
    @ResponseBody
    public AjaxResult addSave(CustomerInfo customerInfo,String parentId)
    {
    	int i = customerInfoService.insertCustomerInfo(customerInfo);
    	contractInfoService.batchUpdateContractInfoByParentId(customerInfo.getCustomerInfoId(),parentId);
    	contractMaterialInfoService.batchUpdateContractMaterialInfoByParentId(customerInfo.getCustomerInfoId(),parentId);
    	paymentInfoService.batchUpdatePaymentInfoByParentId(customerInfo.getCustomerInfoId(),parentId);
        return toAjax(i);
    }

    /**
     * 修改客户信息
     */
    @GetMapping("/edit/{customerInfoId}")
    public String edit(@PathVariable("customerInfoId") Long customerInfoId, ModelMap mmap)
    {
        CustomerInfo customerInfo = customerInfoService.selectCustomerInfoById(customerInfoId);
        mmap.put("customerInfo", customerInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存客户信息
     */
    @RequiresPermissions("ims:customerInfo:edit")
    @Log(title = "客户信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CustomerInfo customerInfo)
    {
        return toAjax(customerInfoService.updateCustomerInfo(customerInfo));
    }

    /**
     * 删除客户信息
     */
    @RequiresPermissions("ims:customerInfo:remove")
    @Log(title = "客户信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(customerInfoService.deleteCustomerInfoByIds(ids));
    }
    /**
     * 客户信息详细
     */
    @GetMapping("/detail/{customerInfoId}")
    public String detail(@PathVariable("customerInfoId") Long customerInfoId, ModelMap mmap)
    {
        CustomerInfo customerInfo = customerInfoService.selectCustomerInfoById(customerInfoId);
        mmap.put("customerInfo", customerInfo);
        return prefix + "/detail";
    }
}
