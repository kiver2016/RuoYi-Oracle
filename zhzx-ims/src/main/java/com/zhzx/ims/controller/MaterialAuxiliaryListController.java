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
import com.zhzx.ims.domain.MaterialAuxiliaryList;
import com.zhzx.ims.service.IMaterialAuxiliaryListService;
import com.zhzx.common.core.controller.BaseController;
import com.zhzx.common.core.domain.AjaxResult;
import com.zhzx.common.utils.poi.ExcelUtil;
import com.zhzx.common.core.page.TableDataInfo;

/**
 * 送货清单辅材Controller
 * 
 * @author ruoyi
 * @date 2019-11-27
 */
@Controller
@RequestMapping("/ims/materialAuxiliaryList")
public class MaterialAuxiliaryListController extends BaseController
{
    private String prefix = "ims/materialAuxiliaryList";

    @Autowired
    private IMaterialAuxiliaryListService materialAuxiliaryListService;

    @RequiresPermissions("ims:materialAuxiliaryList:view")
    @GetMapping()
    public String materialAuxiliaryList()
    {
        return prefix + "/materialAuxiliaryList";
    }

    /**
     * 查询送货清单辅材列表
     */
    @RequiresPermissions("ims:materialAuxiliaryList:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MaterialAuxiliaryList materialAuxiliaryList)
    {
        startPage();
        List<MaterialAuxiliaryList> list = materialAuxiliaryListService.selectMaterialAuxiliaryListList(materialAuxiliaryList);
        return getDataTable(list);
    }

    /**
     * 导出送货清单辅材列表
     */
    @RequiresPermissions("ims:materialAuxiliaryList:export")
    @Log(title = "送货清单辅材", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MaterialAuxiliaryList materialAuxiliaryList)
    {
        List<MaterialAuxiliaryList> list = materialAuxiliaryListService.selectMaterialAuxiliaryListList(materialAuxiliaryList);
        ExcelUtil<MaterialAuxiliaryList> util = new ExcelUtil<MaterialAuxiliaryList>(MaterialAuxiliaryList.class);
        return util.exportExcel(list, "materialAuxiliaryList");
    }

    /**
     * 新增送货清单辅材
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable String parentId,ModelMap modelMap)
    {
    	modelMap.put("parentId", parentId);
        return prefix + "/add";
    }

    /**
     * 新增保存送货清单辅材
     */
    @RequiresPermissions("ims:materialAuxiliaryList:add")
    @Log(title = "送货清单辅材", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MaterialAuxiliaryList materialAuxiliaryList)
    {
        return toAjax(materialAuxiliaryListService.insertMaterialAuxiliaryList(materialAuxiliaryList));
    }

    /**
     * 修改送货清单辅材
     */
    @GetMapping("/edit/{materialAuxiliaryId}")
    public String edit(@PathVariable("materialAuxiliaryId") Long materialAuxiliaryId, ModelMap mmap)
    {
        MaterialAuxiliaryList materialAuxiliaryList = materialAuxiliaryListService.selectMaterialAuxiliaryListById(materialAuxiliaryId);
        mmap.put("materialAuxiliaryList", materialAuxiliaryList);
        return prefix + "/edit";
    }

    /**
     * 修改保存送货清单辅材
     */
    @RequiresPermissions("ims:materialAuxiliaryList:edit")
    @Log(title = "送货清单辅材", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MaterialAuxiliaryList materialAuxiliaryList)
    {
        return toAjax(materialAuxiliaryListService.updateMaterialAuxiliaryList(materialAuxiliaryList));
    }

    /**
     * 删除送货清单辅材
     */
    @RequiresPermissions("ims:materialAuxiliaryList:remove")
    @Log(title = "送货清单辅材", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(materialAuxiliaryListService.deleteMaterialAuxiliaryListByIds(ids));
    }
}
