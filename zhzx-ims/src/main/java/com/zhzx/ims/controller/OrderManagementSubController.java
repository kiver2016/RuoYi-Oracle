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
import com.zhzx.ims.domain.OrderManagementSub;
import com.zhzx.ims.service.IOrderManagementSubService;
import com.zhzx.common.core.controller.BaseController;
import com.zhzx.common.core.domain.AjaxResult;
import com.zhzx.common.utils.poi.ExcelUtil;
import com.zhzx.common.core.page.TableDataInfo;

/**
 * 订单信息子Controller
 * 
 * @author kiver
 * @date 2019-12-04
 */
@Controller
@RequestMapping("/ims/orderManagementSub")
public class OrderManagementSubController extends BaseController
{
    private String prefix = "ims/orderManagementSub";

    @Autowired
    private IOrderManagementSubService orderManagementSubService;

    @RequiresPermissions("ims:orderManagementSub:view")
    @GetMapping()
    public String orderManagementSub()
    {
        return prefix + "/orderManagementSub";
    }

    /**
     * 查询订单信息子列表
     */
    @RequiresPermissions("ims:orderManagementSub:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OrderManagementSub orderManagementSub)
    {
        startPage();
        List<OrderManagementSub> list = orderManagementSubService.selectOrderManagementSubList(orderManagementSub);
        return getDataTable(list);
    }

    /**
     * 导出订单信息子列表
     */
    @RequiresPermissions("ims:orderManagementSub:export")
    @Log(title = "订单信息子", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OrderManagementSub orderManagementSub)
    {
        List<OrderManagementSub> list = orderManagementSubService.selectOrderManagementSubList(orderManagementSub);
        ExcelUtil<OrderManagementSub> util = new ExcelUtil<OrderManagementSub>(OrderManagementSub.class);
        return util.exportExcel(list, "orderManagementSub");
    }

    /**
     * 新增订单信息子
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") String parentId,ModelMap modelMap)
    {
    	modelMap.put("parentId", parentId);
        return prefix + "/add";
    }

    /**
     * 新增保存订单信息子
     */
    @RequiresPermissions("ims:orderManagementSub:add")
    @Log(title = "订单信息子", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OrderManagementSub orderManagementSub)
    {
        return toAjax(orderManagementSubService.insertOrderManagementSub(orderManagementSub));
    }

    /**
     * 修改订单信息子
     */
    @GetMapping("/edit/{orderManagementSubId}")
    public String edit(@PathVariable("orderManagementSubId") Long orderManagementSubId, ModelMap mmap)
    {
        OrderManagementSub orderManagementSub = orderManagementSubService.selectOrderManagementSubById(orderManagementSubId);
        mmap.put("orderManagementSub", orderManagementSub);
        return prefix + "/edit";
    }

    /**
     * 修改保存订单信息子
     */
    @RequiresPermissions("ims:orderManagementSub:edit")
    @Log(title = "订单信息子", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OrderManagementSub orderManagementSub)
    {
        return toAjax(orderManagementSubService.updateOrderManagementSub(orderManagementSub));
    }

    /**
     * 删除订单信息子
     */
    @RequiresPermissions("ims:orderManagementSub:remove")
    @Log(title = "订单信息子", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(orderManagementSubService.deleteOrderManagementSubByIds(ids));
    }
}
