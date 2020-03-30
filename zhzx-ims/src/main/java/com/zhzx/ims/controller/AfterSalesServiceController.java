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
import com.zhzx.ims.domain.AfterSalesService;
import com.zhzx.ims.service.IAfterSalesServiceService;
import com.zhzx.common.core.controller.BaseController;
import com.zhzx.common.core.domain.AjaxResult;
import com.zhzx.common.utils.poi.ExcelUtil;
import com.zhzx.common.core.page.TableDataInfo;

/**
 * 售后服务记录Controller
 * 
 * @author kiver
 * @date 2019-11-27
 */
@Controller
@RequestMapping("/ims/afterSales")
public class AfterSalesServiceController extends BaseController
{
    private String prefix = "ims/afterSales";

    @Autowired
    private IAfterSalesServiceService afterSalesServiceService;

    @RequiresPermissions("ims:afterSales:view")
    @GetMapping()
    public String afterSales()
    {
        return prefix + "/afterSales";
    }

    /**
     * 查询售后服务记录列表
     */
    @RequiresPermissions("ims:afterSales:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AfterSalesService afterSalesService)
    {
        startPage();
        List<AfterSalesService> list = afterSalesServiceService.selectAfterSalesServiceList(afterSalesService);
        return getDataTable(list);
    }
    /**
     * 顾客信息中查询售后服务记录列表
     */
    @RequiresPermissions("ims:afterSales:list")
    @PostMapping("/customerlist/{customerName}/{customerAddress}")
    @ResponseBody
    public TableDataInfo customerlist(@PathVariable("customerName") String customerName,@PathVariable("customerAddress") String customerAddress,AfterSalesService afterSalesService)
    {
        startPage();
        afterSalesService.setAddress(customerAddress);
        afterSalesService.setCustomer(customerName);
        List<AfterSalesService> list = afterSalesServiceService.selectAfterSalesServiceList(afterSalesService);
        return getDataTable(list);
    }
    /**
     * 导出售后服务记录列表
     */
    @RequiresPermissions("ims:afterSales:export")
    @Log(title = "售后服务记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AfterSalesService afterSalesService)
    {
        List<AfterSalesService> list = afterSalesServiceService.selectAfterSalesServiceList(afterSalesService);
        ExcelUtil<AfterSalesService> util = new ExcelUtil<AfterSalesService>(AfterSalesService.class);
        return util.exportExcel(list, "afterSales");
    }

    /**
     * 新增售后服务记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存售后服务记录
     */
    @RequiresPermissions("ims:afterSales:add")
    @Log(title = "售后服务记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AfterSalesService afterSalesService)
    {
        return toAjax(afterSalesServiceService.insertAfterSalesService(afterSalesService));
    }

    /**
     * 修改售后服务记录
     */
    @GetMapping("/edit/{afterSalesServiceId}")
    public String edit(@PathVariable("afterSalesServiceId") Long afterSalesServiceId, ModelMap mmap)
    {
        AfterSalesService afterSalesService = afterSalesServiceService.selectAfterSalesServiceById(afterSalesServiceId);
        mmap.put("afterSalesService", afterSalesService);
        return prefix + "/edit";
    }

    /**
     * 修改保存售后服务记录
     */
    @RequiresPermissions("ims:afterSales:edit")
    @Log(title = "售后服务记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AfterSalesService afterSalesService)
    {
        return toAjax(afterSalesServiceService.updateAfterSalesService(afterSalesService));
    }

    /**
     * 删除售后服务记录
     */
    @RequiresPermissions("ims:afterSales:remove")
    @Log(title = "售后服务记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(afterSalesServiceService.deleteAfterSalesServiceByIds(ids));
    }
    /**
     * c查看售后服务记录
     */
    @GetMapping("/detail/{afterSalesServiceId}")
    public String detail(@PathVariable("afterSalesServiceId") Long afterSalesServiceId, ModelMap mmap)
    {
        AfterSalesService afterSalesService = afterSalesServiceService.selectAfterSalesServiceById(afterSalesServiceId);
        mmap.put("afterSalesService", afterSalesService);
        return prefix + "/detail";
    }
}
