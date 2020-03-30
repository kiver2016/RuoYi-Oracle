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
import com.zhzx.ims.domain.MaterialInfo;
import com.zhzx.ims.service.IMaterialInfoService;
import com.zhzx.common.core.controller.BaseController;
import com.zhzx.common.core.domain.AjaxResult;
import com.zhzx.common.utils.poi.ExcelUtil;
import com.zhzx.common.core.page.TableDataInfo;

/**
 * 产品信息Controller
 * 
 * @author kiver
 * @date 2019-11-27
 */
@Controller
@RequestMapping("/ims/materialinfo")
public class MaterialInfoController extends BaseController
{
    private String prefix = "ims/materialinfo";

    @Autowired
    private IMaterialInfoService materialInfoService;

    @RequiresPermissions("ims:materialinfo:view")
    @GetMapping()
    public String materialinfo()
    {
        return prefix + "/materialinfo";
    }

    /**
     * 查询产品信息列表
     */
    @RequiresPermissions("ims:materialinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MaterialInfo materialInfo)
    {
        startPage();
        List<MaterialInfo> list = materialInfoService.selectMaterialInfoList(materialInfo);
        return getDataTable(list);
    }

    /**
     * 导出产品信息列表
     */
    @RequiresPermissions("ims:materialinfo:export")
    @Log(title = "产品信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MaterialInfo materialInfo)
    {
        List<MaterialInfo> list = materialInfoService.selectMaterialInfoList(materialInfo);
        ExcelUtil<MaterialInfo> util = new ExcelUtil<MaterialInfo>(MaterialInfo.class);
        return util.exportExcel(list, "materialinfo");
    }

    /**
     * 新增产品信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存产品信息
     */
    @RequiresPermissions("ims:materialinfo:add")
    @Log(title = "产品信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MaterialInfo materialInfo)
    {
        return toAjax(materialInfoService.insertMaterialInfo(materialInfo));
    }

    /**
     * 修改产品信息
     */
    @GetMapping("/edit/{materialId}")
    public String edit(@PathVariable("materialId") Long materialId, ModelMap mmap)
    {
        MaterialInfo materialInfo = materialInfoService.selectMaterialInfoById(materialId);
        mmap.put("materialInfo", materialInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存产品信息
     */
    @RequiresPermissions("ims:materialinfo:edit")
    @Log(title = "产品信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MaterialInfo materialInfo)
    {
        return toAjax(materialInfoService.updateMaterialInfo(materialInfo));
    }

    /**
     * 删除产品信息
     */
    @RequiresPermissions("ims:materialinfo:remove")
    @Log(title = "产品信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(materialInfoService.deleteMaterialInfoByIds(ids));
    }
}
