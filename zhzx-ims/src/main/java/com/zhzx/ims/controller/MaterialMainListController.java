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
import com.zhzx.ims.domain.MaterialMainList;
import com.zhzx.ims.service.IMaterialMainListService;
import com.zhzx.common.core.controller.BaseController;
import com.zhzx.common.core.domain.AjaxResult;
import com.zhzx.common.utils.poi.ExcelUtil;
import com.zhzx.common.core.page.TableDataInfo;

/**
 * 送货清单主材Controller
 * 
 * @author kiver
 * @date 2019-11-27
 */
@Controller
@RequestMapping("/ims/materialMainList")
public class MaterialMainListController extends BaseController
{
    private String prefix = "ims/materialMainList";

    @Autowired
    private IMaterialMainListService materialMainListService;

    @RequiresPermissions("ims:materialMainList:view")
    @GetMapping()
    public String materialMainList()
    {
        return prefix + "/materialMainList";
    }

    /**
     * 查询送货清单主材列表
     */
    @RequiresPermissions("ims:materialMainList:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MaterialMainList materialMainList)
    {
        startPage();
        List<MaterialMainList> list = materialMainListService.selectMaterialMainListList(materialMainList);
        return getDataTable(list);
    }

    /**
     * 导出送货清单主材列表
     */
    @RequiresPermissions("ims:materialMainList:export")
    @Log(title = "送货清单主材", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MaterialMainList materialMainList)
    {
        List<MaterialMainList> list = materialMainListService.selectMaterialMainListList(materialMainList);
        ExcelUtil<MaterialMainList> util = new ExcelUtil<MaterialMainList>(MaterialMainList.class);
        return util.exportExcel(list, "materialMainList");
    }

    /**
     * 新增送货清单主材
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable String parentId,ModelMap modelMap)
    {
    	modelMap.put("parentId", parentId);
        return prefix + "/add";
    }

    /**
     * 新增保存送货清单主材
     */
    @RequiresPermissions("ims:materialMainList:add")
    @Log(title = "送货清单主材", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MaterialMainList materialMainList)
    {
        return toAjax(materialMainListService.insertMaterialMainList(materialMainList));
    }

    /**
     * 修改送货清单主材
     */
    @GetMapping("/edit/{materialMainId}")
    public String edit(@PathVariable("materialMainId") Long materialMainId, ModelMap mmap)
    {
        MaterialMainList materialMainList = materialMainListService.selectMaterialMainListById(materialMainId);
        mmap.put("materialMainList", materialMainList);
        return prefix + "/edit";
    }

    /**
     * 修改保存送货清单主材
     */
    @RequiresPermissions("ims:materialMainList:edit")
    @Log(title = "送货清单主材", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MaterialMainList materialMainList)
    {
        return toAjax(materialMainListService.updateMaterialMainList(materialMainList));
    }

    /**
     * 删除送货清单主材
     */
    @RequiresPermissions("ims:materialMainList:remove")
    @Log(title = "送货清单主材", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(materialMainListService.deleteMaterialMainListByIds(ids));
    }
}
