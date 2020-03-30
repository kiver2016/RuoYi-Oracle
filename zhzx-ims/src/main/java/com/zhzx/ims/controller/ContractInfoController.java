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
import com.zhzx.ims.domain.ContractInfo;
import com.zhzx.ims.domain.MaterialDeliveryList;
import com.zhzx.ims.service.IContractInfoService;
import com.zhzx.ims.service.IContractMaterialInfoService;
import com.zhzx.ims.service.IPaymentInfoService;
import com.zhzx.common.core.controller.BaseController;
import com.zhzx.common.core.domain.AjaxResult;
import com.zhzx.common.utils.poi.ExcelUtil;
import com.zhzx.common.core.page.TableDataInfo;

/**
 * 合同信息Controller
 * 
 * @author kiver
 * @date 2019-12-04
 */
@Controller
@RequestMapping("/ims/contractInfo")
public class ContractInfoController extends BaseController
{
    private String prefix = "ims/contractInfo";

    @Autowired
    private IContractInfoService contractInfoService;
    
    @Autowired
    private IContractMaterialInfoService contractMaterialInfoService;
    
    @Autowired
    private IPaymentInfoService paymentInfoService;

    @RequiresPermissions("ims:contractInfo:view")
    @GetMapping()
    public String contractInfo()
    {
        return prefix + "/contractInfo";
    }

    /**
     * 查询合同信息列表
     */
    @RequiresPermissions("ims:contractInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ContractInfo contractInfo)
    {
        startPage();
        List<ContractInfo> list = contractInfoService.selectContractInfoList(contractInfo);
        return getDataTable(list);
    }
    /**
     * 查询合同信息列表
     */
    @RequiresPermissions("ims:contractInfo:list")
    @PostMapping("/customerlist/{customerName}/{customerPhone}/{customerAddress}")
    @ResponseBody
    public TableDataInfo customerlist(@PathVariable("customerName") String customerName,@PathVariable("customerPhone") String customerPhone,@PathVariable("customerAddress") String customerAddress,ContractInfo contractInfo)
    {
    	startPage();
    	contractInfo.setCustomer(customerName);
    	contractInfo.setPhone(customerPhone);
    	contractInfo.setAddress(customerAddress);
    	List<ContractInfo> list = contractInfoService.selectContractInfoCustomerList(contractInfo);
    	return getDataTable(list);
    }

    /**
     * 导出合同信息列表
     */
    @RequiresPermissions("ims:contractInfo:export")
    @Log(title = "合同信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ContractInfo contractInfo)
    {
        List<ContractInfo> list = contractInfoService.selectContractInfoList(contractInfo);
        ExcelUtil<ContractInfo> util = new ExcelUtil<ContractInfo>(ContractInfo.class);
        return util.exportExcel(list, "contractInfo");
    }

    /**
     * 新增合同信息-顾客信息表
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") String parentId,ModelMap modelMap)
    {
    	modelMap.put("parentId", parentId);
        return prefix + "/add";
    }
    
    /**
     * 新增合同信息-顾客信息表
     */
    @GetMapping("/add")
    public String addNew()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存合同信息
     */
    @RequiresPermissions("ims:contractInfo:add")
    @Log(title = "合同信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ContractInfo contractInfo)
    {
    	int i = contractInfoService.insertContractInfo(contractInfo);
    	contractMaterialInfoService.batchUpdateContractMaterialInfoByParentId(contractInfo.getContractInfoId(),contractInfo.getParentId());
    	paymentInfoService.batchUpdatePaymentInfoByParentId(contractInfo.getContractInfoId(),contractInfo.getParentId());
        return toAjax(i);
    }

    /**
     * 修改合同信息
     */
    @GetMapping("/edit/{contractInfoId}")
    public String edit(@PathVariable("contractInfoId") Long contractInfoId, ModelMap mmap)
    {
        ContractInfo contractInfo = contractInfoService.selectContractInfoById(contractInfoId);
        mmap.put("contractInfo", contractInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存合同信息
     */
    @RequiresPermissions("ims:contractInfo:edit")
    @Log(title = "合同信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ContractInfo contractInfo)
    {
        return toAjax(contractInfoService.updateContractInfo(contractInfo));
    }

    /**
     * 删除合同信息
     */
    @RequiresPermissions("ims:contractInfo:remove")
    @Log(title = "合同信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(contractInfoService.deleteContractInfoByIds(ids));
    }
    /**
     * 查看详细
     */
    @GetMapping("/detail/{contractInfoId}")
    public String detail(@PathVariable("contractInfoId") Long contractInfoId, ModelMap mmap)
    {
    	ContractInfo contractInfo = contractInfoService.selectContractInfoById(contractInfoId);
    	mmap.put("contractInfo", contractInfo);
        return prefix + "/detail";
    }
}
