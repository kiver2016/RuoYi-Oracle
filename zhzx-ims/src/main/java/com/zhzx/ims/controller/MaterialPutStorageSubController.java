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
import com.zhzx.ims.domain.MaterialPutStorageSub;
import com.zhzx.ims.service.IMaterialPutStorageSubService;
import com.zhzx.common.core.controller.BaseController;
import com.zhzx.common.core.domain.AjaxResult;
import com.zhzx.common.utils.poi.ExcelUtil;
import com.zhzx.common.core.page.TableDataInfo;

/**
 * 材料入库信息子Controller
 * 
 * @author kiver
 * @date 2019-11-27
 */
@Controller
@RequestMapping("/ims/materialPutStorageSub")
public class MaterialPutStorageSubController extends BaseController
{
    private String prefix = "ims/materialPutStorageSub";

    @Autowired
    private IMaterialPutStorageSubService materialPutStorageSubService;

    @RequiresPermissions("ims:materialPutStorageSub:view")
    @GetMapping()
    public String materialPutStorageSub()
    {
        return prefix + "/materialPutStorageSub";
    }

    /**
     * 查询材料入库信息子列表
     */
    @RequiresPermissions("ims:materialPutStorageSub:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MaterialPutStorageSub materialPutStorageSub)
    {
        startPage();
        List<MaterialPutStorageSub> list = materialPutStorageSubService.selectMaterialPutStorageSubList(materialPutStorageSub);
        return getDataTable(list);
    }

    /**
     * 导出材料入库信息子列表
     */
    @RequiresPermissions("ims:materialPutStorageSub:export")
    @Log(title = "材料入库信息子", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MaterialPutStorageSub materialPutStorageSub)
    {
        List<MaterialPutStorageSub> list = materialPutStorageSubService.selectMaterialPutStorageSubList(materialPutStorageSub);
        ExcelUtil<MaterialPutStorageSub> util = new ExcelUtil<MaterialPutStorageSub>(MaterialPutStorageSub.class);
        return util.exportExcel(list, "materialPutStorageSub");
    }

    /**
     * 新增材料入库信息子
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId")String parentId, ModelMap modelMap)
    {
    	modelMap.put("parent_Id", parentId);
        return prefix + "/add";
    }

    /**
     * 新增保存材料入库信息子
     */
    @RequiresPermissions("ims:materialPutStorageSub:add")
    @Log(title = "材料入库信息子", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MaterialPutStorageSub materialPutStorageSub)
    {
        return toAjax(materialPutStorageSubService.insertMaterialPutStorageSub(materialPutStorageSub));
    }

    /**
     * 修改材料入库信息子
     */
    @GetMapping("/edit/{materialPutSubId}")
    public String edit(@PathVariable("materialPutSubId") Long materialPutSubId, ModelMap mmap)
    {
        MaterialPutStorageSub materialPutStorageSub = materialPutStorageSubService.selectMaterialPutStorageSubById(materialPutSubId);
        mmap.put("materialPutStorageSub", materialPutStorageSub);
        return prefix + "/edit";
    }

    /**
     * 修改保存材料入库信息子
     */
    @RequiresPermissions("ims:materialPutStorageSub:edit")
    @Log(title = "材料入库信息子", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MaterialPutStorageSub materialPutStorageSub)
    {
        return toAjax(materialPutStorageSubService.updateMaterialPutStorageSub(materialPutStorageSub));
    }

    /**
     * 删除材料入库信息子
     */
    @RequiresPermissions("ims:materialPutStorageSub:remove")
    @Log(title = "材料入库信息子", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(materialPutStorageSubService.deleteMaterialPutStorageSubByIds(ids));
    }
}
