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
import com.zhzx.ims.domain.MaterialInstallInfo;
import com.zhzx.ims.service.IMaterialInstallInfoService;
import com.zhzx.common.core.controller.BaseController;
import com.zhzx.common.core.domain.AjaxResult;
import com.zhzx.common.utils.poi.ExcelUtil;
import com.zhzx.common.core.page.TableDataInfo;

/**
 * 安装信息Controller
 * 
 * @author kiver
 * @date 2019-11-27
 */
@Controller
@RequestMapping("/ims/materialInstallInfo")
public class MaterialInstallInfoController extends BaseController
{
    private String prefix = "ims/materialInstallInfo";

    @Autowired
    private IMaterialInstallInfoService materialInstallInfoService;

    @RequiresPermissions("ims:materialInstallInfo:view")
    @GetMapping()
    public String materialInstallInfo()
    {
        return prefix + "/materialInstallInfo";
    }

    /**
     * 查询安装信息列表
     */
    @RequiresPermissions("ims:materialInstallInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MaterialInstallInfo materialInstallInfo)
    {
        startPage();
        List<MaterialInstallInfo> list = materialInstallInfoService.selectMaterialInstallInfoList(materialInstallInfo);
        return getDataTable(list);
    }
    /**
     * 顾客信息中查询安装信息列表
     */
    @RequiresPermissions("ims:materialInstallInfo:list")
    @PostMapping("/customerlist/{customerName}/{customerAddress}")
    @ResponseBody
    public TableDataInfo customerlist(@PathVariable("customerName") String customerName,@PathVariable("customerAddress") String customerAddress,MaterialInstallInfo materialInstallInfo)
    {
        startPage();
        materialInstallInfo.setCustomer(customerName);
        materialInstallInfo.setAddress(customerAddress);
        List<MaterialInstallInfo> list = materialInstallInfoService.selectMaterialInstallInfoList(materialInstallInfo);
        return getDataTable(list);
    }
    /**
     * 导出安装信息列表
     */
    @RequiresPermissions("ims:materialInstallInfo:export")
    @Log(title = "安装信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MaterialInstallInfo materialInstallInfo)
    {
        List<MaterialInstallInfo> list = materialInstallInfoService.selectMaterialInstallInfoList(materialInstallInfo);
        ExcelUtil<MaterialInstallInfo> util = new ExcelUtil<MaterialInstallInfo>(MaterialInstallInfo.class);
        return util.exportExcel(list, "materialInstallInfo");
    }

    /**
     * 新增安装信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存安装信息
     */
    @RequiresPermissions("ims:materialInstallInfo:add")
    @Log(title = "安装信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MaterialInstallInfo materialInstallInfo)
    {
        return toAjax(materialInstallInfoService.insertMaterialInstallInfo(materialInstallInfo));
    }

    /**
     * 修改安装信息
     */
    @GetMapping("/edit/{materialInstallInfoId}")
    public String edit(@PathVariable("materialInstallInfoId") Long materialInstallInfoId, ModelMap mmap)
    {
        MaterialInstallInfo materialInstallInfo = materialInstallInfoService.selectMaterialInstallInfoById(materialInstallInfoId);
        mmap.put("materialInstallInfo", materialInstallInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存安装信息
     */
    @RequiresPermissions("ims:materialInstallInfo:edit")
    @Log(title = "安装信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MaterialInstallInfo materialInstallInfo)
    {
        return toAjax(materialInstallInfoService.updateMaterialInstallInfo(materialInstallInfo));
    }

    /**
     * 删除安装信息
     */
    @RequiresPermissions("ims:materialInstallInfo:remove")
    @Log(title = "安装信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(materialInstallInfoService.deleteMaterialInstallInfoByIds(ids));
    }
    /**
     * 查看安装信息
     */
    @GetMapping("/detail/{materialInstallInfoId}")
    public String detail(@PathVariable("materialInstallInfoId") Long materialInstallInfoId, ModelMap mmap)
    {
        MaterialInstallInfo materialInstallInfo = materialInstallInfoService.selectMaterialInstallInfoById(materialInstallInfoId);
        mmap.put("materialInstallInfo", materialInstallInfo);
        return prefix + "/detail";
    }
}
