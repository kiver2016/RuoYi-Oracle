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
import com.zhzx.ims.domain.MaterialStorageInfo;
import com.zhzx.ims.service.IMaterialStorageInfoService;
import com.zhzx.common.core.controller.BaseController;
import com.zhzx.common.core.domain.AjaxResult;
import com.zhzx.common.utils.poi.ExcelUtil;
import com.zhzx.common.core.page.TableDataInfo;

/**
 * 库存信息Controller
 * 
 * @author kiver
 * @date 2019-12-06
 */
@Controller
@RequestMapping("/ims/materialStorageInfo")
public class MaterialStorageInfoController extends BaseController
{
    private String prefix = "ims/materialStorageInfo";

    @Autowired
    private IMaterialStorageInfoService materialStorageInfoService;

    @RequiresPermissions("ims:materialStorageInfo:view")
    @GetMapping()
    public String materialStorageInfo()
    {
        return prefix + "/materialStorageInfo";
    }

    /**
     * 查询库存信息列表
     */
    @RequiresPermissions("ims:materialStorageInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MaterialStorageInfo materialStorageInfo)
    {
        startPage();
        List<MaterialStorageInfo> list = materialStorageInfoService.selectMaterialStorageInfoList(materialStorageInfo);
        return getDataTable(list);
    }

    /**
     * 导出库存信息列表
     */
    @RequiresPermissions("ims:materialStorageInfo:export")
    @Log(title = "库存信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MaterialStorageInfo materialStorageInfo)
    {
        List<MaterialStorageInfo> list = materialStorageInfoService.selectMaterialStorageInfoList(materialStorageInfo);
        ExcelUtil<MaterialStorageInfo> util = new ExcelUtil<MaterialStorageInfo>(MaterialStorageInfo.class);
        return util.exportExcel(list, "materialStorageInfo");
    }

    /**
     * 新增库存信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存库存信息
     */
    @RequiresPermissions("ims:materialStorageInfo:add")
    @Log(title = "库存信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MaterialStorageInfo materialStorageInfo)
    {
        return toAjax(materialStorageInfoService.insertMaterialStorageInfo(materialStorageInfo));
    }

    /**
     * 修改库存信息
     */
    @GetMapping("/edit/{materialStorageInfoId}")
    public String edit(@PathVariable("materialStorageInfoId") Long materialStorageInfoId, ModelMap mmap)
    {
        MaterialStorageInfo materialStorageInfo = materialStorageInfoService.selectMaterialStorageInfoById(materialStorageInfoId);
        mmap.put("materialStorageInfo", materialStorageInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存库存信息
     */
    @RequiresPermissions("ims:materialStorageInfo:edit")
    @Log(title = "库存信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MaterialStorageInfo materialStorageInfo)
    {
        return toAjax(materialStorageInfoService.updateMaterialStorageInfo(materialStorageInfo));
    }

    /**
     * 删除库存信息
     */
    @RequiresPermissions("ims:materialStorageInfo:remove")
    @Log(title = "库存信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(materialStorageInfoService.deleteMaterialStorageInfoByIds(ids));
    }
}
