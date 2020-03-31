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
import com.zhzx.common.core.controller.BaseController;
import com.zhzx.common.core.domain.AjaxResult;
import com.zhzx.common.core.page.TableDataInfo;
import com.zhzx.common.enums.BusinessType;
import com.zhzx.common.utils.poi.ExcelUtil;
import com.zhzx.ims.domain.MaterialDeliveryList;
import com.zhzx.ims.service.IMaterialAuxiliaryListService;
import com.zhzx.ims.service.IMaterialDeliveryListService;
import com.zhzx.ims.service.IMaterialMainListService;

/**
 * 送货清单Controller
 * 
 * @author kiver
 * @date 2019-11-27
 */
@Controller
@RequestMapping("/ims/materialDeliveryList")
public class MaterialDeliveryListController extends BaseController
{
    private String prefix = "ims/materialDeliveryList";

    @Autowired
    private IMaterialDeliveryListService materialDeliveryListService;
    @Autowired
    private IMaterialAuxiliaryListService materialAuxiliaryListService;
    @Autowired
    private IMaterialMainListService materialMainListService;
    
    @RequiresPermissions("ims:materialDeliveryList:view")
    @GetMapping()
    public String materialDeliveryList()
    {
        return prefix + "/materialDeliveryList";
    }

    /**
     * 查询送货清单列表
     */
    @RequiresPermissions("ims:materialDeliveryList:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MaterialDeliveryList materialDeliveryList)
    {
        startPage();
        List<MaterialDeliveryList> list = materialDeliveryListService.selectMaterialDeliveryListList(materialDeliveryList);
        return getDataTable(list);
    }

    /**
     * 导出送货清单列表
     */
    @RequiresPermissions("ims:materialDeliveryList:export")
    @Log(title = "送货清单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MaterialDeliveryList materialDeliveryList)
    {
        List<MaterialDeliveryList> list = materialDeliveryListService.selectMaterialDeliveryListList(materialDeliveryList);
        ExcelUtil<MaterialDeliveryList> util = new ExcelUtil<MaterialDeliveryList>(MaterialDeliveryList.class);
        return util.exportExcel(list, "materialDeliveryList");
    }

    /**
     * 新增送货清单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存送货清单
     */
    @RequiresPermissions("ims:materialDeliveryList:add")
    @Log(title = "送货清单", businessType = BusinessType.INSERT)
    @PostMapping("/add/{parentId}")
    @ResponseBody
    public AjaxResult addSave(MaterialDeliveryList materialDeliveryList,String parentId)
    {
    	int i = materialDeliveryListService.insertMaterialDeliveryList(materialDeliveryList);
    	materialMainListService.BatchupdateMaterialMainList(materialDeliveryList.getDeliveryListId(),parentId);
    	materialAuxiliaryListService.BatchupdateMaterialAuxiliaryList(materialDeliveryList.getDeliveryListId(),parentId);
        return toAjax(i);
    }

    /**
     * 修改送货清单
     */
    @GetMapping("/edit/{deliveryListId}")
    public String edit(@PathVariable("deliveryListId") Long deliveryListId, ModelMap mmap)
    {
        MaterialDeliveryList materialDeliveryList = materialDeliveryListService.selectMaterialDeliveryListById(deliveryListId);
        mmap.put("materialDeliveryList", materialDeliveryList);
        return prefix + "/edit";
    }

    /**
     * 修改保存送货清单
     */
    @RequiresPermissions("ims:materialDeliveryList:edit")
    @Log(title = "送货清单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MaterialDeliveryList materialDeliveryList)
    {
        return toAjax(materialDeliveryListService.updateMaterialDeliveryList(materialDeliveryList));
    }
    
    /**
     * 确认产品出库
     */
    @GetMapping("/confirmPutOut/{deliveryListId}")
    public String confirmPutOut(@PathVariable("deliveryListId") Long deliveryListId, ModelMap mmap)
    {
        MaterialDeliveryList materialDeliveryList = materialDeliveryListService.selectMaterialDeliveryListById(deliveryListId);
        mmap.put("materialDeliveryList", materialDeliveryList);
        return prefix + "/confirmOut";
    }

    /**
     *保存产品出库信息，并且将商品出库
     */
    @RequiresPermissions("ims:materialDeliveryList:edit")
    @Log(title = "送货清单", businessType = BusinessType.UPDATE)
    @PostMapping("/confirmPutOut")
    @ResponseBody
    public AjaxResult confirmPutOutSave(MaterialDeliveryList materialDeliveryList)
    {
    	int i = materialDeliveryListService.updateMaterialDeliveryList(materialDeliveryList);
    	boolean isSuccess = materialDeliveryListService.updateMaterialStorageInfo(materialDeliveryList);//是否出库成功
    	materialDeliveryListService.updateMaterialOutStorage(materialDeliveryList);
        return toAjax(i);
    }

    /**
     * 删除送货清单
     */
    @RequiresPermissions("ims:materialDeliveryList:remove")
    @Log(title = "送货清单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(materialDeliveryListService.deleteMaterialDeliveryListByIds(ids));
    }
    
    /**
     * 查看详细
     */
    @GetMapping("/detail/{deliveryListId}")
    public String detail(@PathVariable("deliveryListId") Long deliveryListId, ModelMap mmap)
    {
    	MaterialDeliveryList materialDeliveryList = materialDeliveryListService.selectMaterialDeliveryListById(deliveryListId);
    	mmap.put("materialDeliveryList", materialDeliveryList);
        return prefix + "/detail";
    }
}
