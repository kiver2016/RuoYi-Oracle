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
import com.zhzx.ims.domain.ContractMaterialInfo;
import com.zhzx.ims.service.IContractInfoService;
import com.zhzx.ims.service.IContractMaterialInfoService;
import com.zhzx.common.core.controller.BaseController;
import com.zhzx.common.core.domain.AjaxResult;
import com.zhzx.common.utils.poi.ExcelUtil;
import com.zhzx.common.core.page.TableDataInfo;

/**
 * 合同产品及送货信息Controller
 * 
 * @author kiver
 * @date 2019-12-04
 */
@Controller
@RequestMapping("/ims/contractMaterialInfo")
public class ContractMaterialInfoController extends BaseController
{
    private String prefix = "ims/contractMaterialInfo";

    @Autowired
    private IContractMaterialInfoService contractMaterialInfoService;
    @Autowired
    private IContractInfoService contractInfoService;
    @RequiresPermissions("ims:contractMaterialInfo:view")
    @GetMapping()
    public String contractMaterialInfo()
    {
        return prefix + "/contractMaterialInfo";
    }

    /**
     * 查询合同产品及送货信息列表
     */
    @RequiresPermissions("ims:contractMaterialInfo:list")
    @PostMapping("/customerlist/{customerName}/{customerPhone}/{customerAddress}")
    @ResponseBody
    public TableDataInfo customerlist(@PathVariable("customerName") String customerName,@PathVariable("customerPhone") String customerPhone,@PathVariable("customerAddress") String customerAddress,ContractMaterialInfo contractMaterialInfo)
    {
        startPage();
        ContractInfo contractInfo = new ContractInfo();
        contractInfo.setCustomer(customerName);
    	contractInfo.setPhone(customerPhone);
    	contractInfo.setAddress(customerAddress);
        List<ContractInfo> ContractInfolist = contractInfoService.selectContractInfoCustomerList(contractInfo);
        if (ContractInfolist!=null &&ContractInfolist.size()>0) {
        	contractMaterialInfo.setParentId(ContractInfolist.get(0).getContractInfoId()+"");
		}else {
			contractMaterialInfo.setParentId("你是什么都查不出来的！！");
		}
        List<ContractMaterialInfo> list = contractMaterialInfoService.selectContractMaterialInfoList(contractMaterialInfo);
        return getDataTable(list);
    }

    /**
     * 查询合同产品及送货信息列表
     */
    @RequiresPermissions("ims:contractMaterialInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ContractMaterialInfo contractMaterialInfo)
    {
        startPage();
        List<ContractMaterialInfo> list = contractMaterialInfoService.selectContractMaterialInfoList(contractMaterialInfo);
        return getDataTable(list);
    }
    /**
     * 导出合同产品及送货信息列表
     */
    @RequiresPermissions("ims:contractMaterialInfo:export")
    @Log(title = "合同产品及送货信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ContractMaterialInfo contractMaterialInfo)
    {
        List<ContractMaterialInfo> list = contractMaterialInfoService.selectContractMaterialInfoList(contractMaterialInfo);
        ExcelUtil<ContractMaterialInfo> util = new ExcelUtil<ContractMaterialInfo>(ContractMaterialInfo.class);
        return util.exportExcel(list, "contractMaterialInfo");
    }

    /**
     * 新增合同产品及送货信息
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") String parentId,ModelMap modelMap)
    {
    	modelMap.put("parentId", parentId);
        return prefix + "/add";
    }

    /**
     * 新增保存合同产品及送货信息
     */
    @RequiresPermissions("ims:contractMaterialInfo:add")
    @Log(title = "合同产品及送货信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ContractMaterialInfo contractMaterialInfo)
    {
        return toAjax(contractMaterialInfoService.insertContractMaterialInfo(contractMaterialInfo));
    }

    /**
     * 修改合同产品及送货信息
     */
    @GetMapping("/edit/{contractMaterialInfoId}")
    public String edit(@PathVariable("contractMaterialInfoId") Long contractMaterialInfoId, ModelMap mmap)
    {
        ContractMaterialInfo contractMaterialInfo = contractMaterialInfoService.selectContractMaterialInfoById(contractMaterialInfoId);
        mmap.put("contractMaterialInfo", contractMaterialInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存合同产品及送货信息
     */
    @RequiresPermissions("ims:contractMaterialInfo:edit")
    @Log(title = "合同产品及送货信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ContractMaterialInfo contractMaterialInfo)
    {
        return toAjax(contractMaterialInfoService.updateContractMaterialInfo(contractMaterialInfo));
    }

    /**
     * 删除合同产品及送货信息
     */
    @RequiresPermissions("ims:contractMaterialInfo:remove")
    @Log(title = "合同产品及送货信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(contractMaterialInfoService.deleteContractMaterialInfoByIds(ids));
    }
}
