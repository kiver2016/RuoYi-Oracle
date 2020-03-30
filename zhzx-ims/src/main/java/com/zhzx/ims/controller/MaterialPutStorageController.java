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
import com.zhzx.ims.domain.MaterialPutStorage;
import com.zhzx.ims.service.IMaterialPutStorageService;
import com.zhzx.ims.service.IMaterialPutStorageSubService;
import com.zhzx.ims.service.IMaterialStorageInfoService;
import com.zhzx.common.core.controller.BaseController;
import com.zhzx.common.core.domain.AjaxResult;
import com.zhzx.common.utils.poi.ExcelUtil;
import com.zhzx.common.core.page.TableDataInfo;

/**
 * 材料入库信息Controller
 * 
 * @author kiver
 * @date 2019-11-27
 */
@Controller
@RequestMapping("/ims/materialPutStorage")
public class MaterialPutStorageController extends BaseController
{
    private String prefix = "ims/materialPutStorage";

    @Autowired
    private IMaterialPutStorageService materialPutStorageService;
    @Autowired
    private IMaterialPutStorageSubService materialPutStorageSubService;
    @Autowired
    private IMaterialStorageInfoService materialStorageInfoService;
    
    @RequiresPermissions("ims:materialPutStorage:view")
    @GetMapping()
    public String materialPutStorage()
    {
        return prefix + "/materialPutStorage";
    }

    /**
     * 查询材料入库信息列表
     */
    @RequiresPermissions("ims:materialPutStorage:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MaterialPutStorage materialPutStorage)
    {
        startPage();
        List<MaterialPutStorage> list = materialPutStorageService.selectMaterialPutStorageList(materialPutStorage);
        return getDataTable(list);
    }

    /**
     * 导出材料入库信息列表
     */
    @RequiresPermissions("ims:materialPutStorage:export")
    @Log(title = "材料入库信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MaterialPutStorage materialPutStorage)
    {
        List<MaterialPutStorage> list = materialPutStorageService.selectMaterialPutStorageList(materialPutStorage);
        ExcelUtil<MaterialPutStorage> util = new ExcelUtil<MaterialPutStorage>(MaterialPutStorage.class);
        return util.exportExcel(list, "materialPutStorage");
    }

    /**
     * 新增材料入库信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存材料入库信息
     */
    @RequiresPermissions("ims:materialPutStorage:add")
    @Log(title = "材料入库信息", businessType = BusinessType.INSERT)
    @PostMapping("/add/{parentId}")
    @ResponseBody
    public AjaxResult addSave(MaterialPutStorage materialPutStorage,String parentId)
    {
    	int i = materialPutStorageService.insertMaterialPutStorage(materialPutStorage);
    	materialPutStorageSubService.BatchupdateMaterialPutStorageSub(parentId,materialPutStorage);
        return toAjax(i);
    }

    /**
     * 修改材料入库信息
     */
    @GetMapping("/edit/{materialPutId}")
    public String edit(@PathVariable("materialPutId") Long materialPutId, ModelMap mmap)
    {
        MaterialPutStorage materialPutStorage = materialPutStorageService.selectMaterialPutStorageById(materialPutId);
        mmap.put("materialPutStorage", materialPutStorage);
        return prefix + "/edit";
    }

    /**
     * 修改保存材料入库信息
     */
    @RequiresPermissions("ims:materialPutStorage:edit")
    @Log(title = "材料入库信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MaterialPutStorage materialPutStorage)
    {
    	int i = materialPutStorageService.updateMaterialPutStorage(materialPutStorage);
    	materialPutStorageSubService.BatchupdateMaterialPutStorageSub(materialPutStorage.getMaterialPutId()+"",materialPutStorage);
        return toAjax(i);
    }
    
    /**
     * 确认材料入库信息
     */
    @GetMapping("/confirmPutIn/{materialPutId}")
    public String confirmPutIn(@PathVariable("materialPutId") Long materialPutId, ModelMap mmap)
    {
        MaterialPutStorage materialPutStorage = materialPutStorageService.selectMaterialPutStorageById(materialPutId);
        mmap.put("materialPutStorage", materialPutStorage);
        return prefix + "/confirmPutIn";
    }

    /**
     * 确认保存材料入库信息
     */
    @RequiresPermissions("ims:materialPutStorage:edit")
    @Log(title = "材料入库信息确认", businessType = BusinessType.UPDATE)
    @PostMapping("/confirmPutIn")
    @ResponseBody
    public AjaxResult confirmPutInSave(MaterialPutStorage materialPutStorage)
    {
    	int i = materialPutStorageService.updateMaterialPutStorage(materialPutStorage);
    	materialStorageInfoService.savePutStorage(materialPutStorage);
        return toAjax(i);
    }

    /**
     * 删除材料入库信息
     */
    @RequiresPermissions("ims:materialPutStorage:remove")
    @Log(title = "材料入库信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
    	materialPutStorageSubService.deleteMaterialPutStorageSubByParentIds(ids);
        return toAjax(materialPutStorageService.deleteMaterialPutStorageByIds(ids));
    }
    
    /**
     * 查看详细
     */
    @GetMapping("/detail/{materialPutId}")
    public String detail(@PathVariable("materialPutId") Long materialPutId, ModelMap mmap)
    {
        MaterialPutStorage materialPutStorage = materialPutStorageService.selectMaterialPutStorageById(materialPutId);
        mmap.put("materialPutStorage", materialPutStorage);
        return prefix + "/detail";
    }
}
