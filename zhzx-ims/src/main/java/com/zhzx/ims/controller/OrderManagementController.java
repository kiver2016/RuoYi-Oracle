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
import com.zhzx.ims.domain.OrderManagement;
import com.zhzx.ims.service.IOrderManagementService;
import com.zhzx.ims.service.IOrderManagementSubService;
import com.zhzx.common.core.controller.BaseController;
import com.zhzx.common.core.domain.AjaxResult;
import com.zhzx.common.utils.poi.ExcelUtil;
import com.zhzx.common.core.page.TableDataInfo;

/**
 * 订单信息Controller
 * 
 * @author kiver
 * @date 2019-12-04
 */
@Controller
@RequestMapping("/ims/management")
public class OrderManagementController extends BaseController
{
    private String prefix = "ims/management";

    @Autowired
    private IOrderManagementService orderManagementService;
    @Autowired
    private IOrderManagementSubService orderManagementSubService;

    @RequiresPermissions("ims:management:view")
    @GetMapping()
    public String management()
    {
        return prefix + "/management";
    }

    /**
     * 查询订单信息列表
     */
    @RequiresPermissions("ims:management:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OrderManagement orderManagement)
    {
        startPage();
        List<OrderManagement> list = orderManagementService.selectOrderManagementList(orderManagement);
        return getDataTable(list);
    }

    /**
     * 导出订单信息列表
     */
    @RequiresPermissions("ims:management:export")
    @Log(title = "订单信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OrderManagement orderManagement)
    {
        List<OrderManagement> list = orderManagementService.selectOrderManagementList(orderManagement);
        ExcelUtil<OrderManagement> util = new ExcelUtil<OrderManagement>(OrderManagement.class);
        return util.exportExcel(list, "management");
    }

    /**
     * 新增订单信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存订单信息
     */
    @RequiresPermissions("ims:management:add")
    @Log(title = "订单信息", businessType = BusinessType.INSERT)
    @PostMapping("/add/{parentId}")
    @ResponseBody
    public AjaxResult addSave(OrderManagement orderManagement,String parentId)
    {
    	int i = orderManagementService.insertOrderManagement(orderManagement);
    	orderManagementSubService.batchUpdateOrderManagementSub(orderManagement.getOrderManagementId(),parentId);
        return toAjax(i);
    }

    /**
     * 修改订单信息
     */
    @GetMapping("/edit/{orderManagementId}")
    public String edit(@PathVariable("orderManagementId") Long orderManagementId, ModelMap mmap)
    {
        OrderManagement orderManagement = orderManagementService.selectOrderManagementById(orderManagementId);
        mmap.put("orderManagement", orderManagement);
        return prefix + "/edit";
    }

    /**
     * 修改保存订单信息
     */
    @RequiresPermissions("ims:management:edit")
    @Log(title = "订单信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OrderManagement orderManagement)
    {
        return toAjax(orderManagementService.updateOrderManagement(orderManagement));
    }

    /**
     * 删除订单信息
     */
    @RequiresPermissions("ims:management:remove")
    @Log(title = "订单信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(orderManagementService.deleteOrderManagementByIds(ids));
    }
    
    /**
     * 查看订单信息
     */
    @GetMapping("/detail/{orderManagementId}")
    public String detail(@PathVariable("orderManagementId") Long orderManagementId, ModelMap mmap)
    {
        OrderManagement orderManagement = orderManagementService.selectOrderManagementById(orderManagementId);
        mmap.put("orderManagement", orderManagement);
        return prefix + "/detail";
    }

}
