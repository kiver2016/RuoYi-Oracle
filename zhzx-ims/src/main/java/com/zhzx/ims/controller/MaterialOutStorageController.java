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
import com.zhzx.ims.domain.MaterialOutStorage;
import com.zhzx.ims.service.IMaterialOutStorageService;
import com.zhzx.common.core.controller.BaseController;
import com.zhzx.common.core.domain.AjaxResult;
import com.zhzx.common.utils.poi.ExcelUtil;
import com.zhzx.common.core.page.TableDataInfo;

/**
 * 材料出库信息Controller
 * 
 * @author kiver
 * @date 2019-11-27
 */
@Controller
@RequestMapping("/ims/materialOutStorage")
public class MaterialOutStorageController extends BaseController
{
    private String prefix = "ims/materialOutStorage";

    @Autowired
    private IMaterialOutStorageService materialOutStorageService;

    @RequiresPermissions("ims:materialOutStorage:view")
    @GetMapping()
    public String materialOutStorage()
    {
        return prefix + "/materialOutStorage";
    }

    /**
     * 查询材料出库信息列表
     */
    @RequiresPermissions("ims:materialOutStorage:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MaterialOutStorage materialOutStorage)
    {
        startPage();
        List<MaterialOutStorage> list = materialOutStorageService.selectMaterialOutStorageList(materialOutStorage);
        return getDataTable(list);
    }

    /**
     * 导出材料出库信息列表
     */
    @RequiresPermissions("ims:materialOutStorage:export")
    @Log(title = "材料出库信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MaterialOutStorage materialOutStorage)
    {
        List<MaterialOutStorage> list = materialOutStorageService.selectMaterialOutStorageList(materialOutStorage);
        ExcelUtil<MaterialOutStorage> util = new ExcelUtil<MaterialOutStorage>(MaterialOutStorage.class);
        return util.exportExcel(list, "materialOutStorage");
    }

    /**
     * 新增材料出库信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存材料出库信息
     */
    @RequiresPermissions("ims:materialOutStorage:add")
    @Log(title = "材料出库信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MaterialOutStorage materialOutStorage)
    {
        return toAjax(materialOutStorageService.insertMaterialOutStorage(materialOutStorage));
    }

    /**
     * 修改材料出库信息
     */
    @GetMapping("/edit/{materialOutId}")
    public String edit(@PathVariable("materialOutId") Long materialOutId, ModelMap mmap)
    {
        MaterialOutStorage materialOutStorage = materialOutStorageService.selectMaterialOutStorageById(materialOutId);
        mmap.put("materialOutStorage", materialOutStorage);
        return prefix + "/edit";
    }

    /**
     * 修改保存材料出库信息
     */
    @RequiresPermissions("ims:materialOutStorage:edit")
    @Log(title = "材料出库信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MaterialOutStorage materialOutStorage)
    {
        return toAjax(materialOutStorageService.updateMaterialOutStorage(materialOutStorage));
    }

    /**
     * 删除材料出库信息
     */
    @RequiresPermissions("ims:materialOutStorage:remove")
    @Log(title = "材料出库信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(materialOutStorageService.deleteMaterialOutStorageByIds(ids));
    }
}
