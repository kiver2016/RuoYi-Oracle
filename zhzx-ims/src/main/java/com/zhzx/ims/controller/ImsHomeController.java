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
import com.zhzx.ims.domain.ImsHome;
import com.zhzx.ims.service.IImsHomeService;
import com.zhzx.common.core.controller.BaseController;
import com.zhzx.common.core.domain.AjaxResult;
import com.zhzx.common.utils.poi.ExcelUtil;
import com.zhzx.common.core.page.TableDataInfo;

/**
 * 主页展示Controller
 * 
 * @author kiver
 * @date 2020-02-21
 */
@Controller
@RequestMapping("/ims/home")
public class ImsHomeController extends BaseController
{
    private String prefix = "ims/home";

    @Autowired
    private IImsHomeService imsHomeService;

    @RequiresPermissions("ims:home:view")
    @GetMapping()
    public String home()
    {
        return prefix + "/home";
    }

    /**
     * 查询主页展示列表
     */
    @RequiresPermissions("ims:home:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ImsHome imsHome)
    {
        startPage();
        List<ImsHome> list = imsHomeService.selectImsHomeList(imsHome);
        return getDataTable(list);
    }
    
    /**
     * 查询主页展示列表
     */
    @RequiresPermissions("ims:home:list")
    @PostMapping("/listhome/{type}")
    @ResponseBody
    public TableDataInfo listhome(ImsHome imsHome,@PathVariable("type") String type)
    {
        startPage();
        imsHome.setImsHomeType(type);
        List<ImsHome> list = imsHomeService.selectImsHomeList(imsHome);
        return getDataTable(list);
    }

    /**
     * 导出主页展示列表
     */
    @RequiresPermissions("ims:home:export")
    @Log(title = "主页展示", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ImsHome imsHome)
    {
        List<ImsHome> list = imsHomeService.selectImsHomeList(imsHome);
        ExcelUtil<ImsHome> util = new ExcelUtil<ImsHome>(ImsHome.class);
        return util.exportExcel(list, "home");
    }

    /**
     * 新增主页展示
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存主页展示
     */
    @RequiresPermissions("ims:home:add")
    @Log(title = "主页展示", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ImsHome imsHome)
    {
        return toAjax(imsHomeService.insertImsHome(imsHome));
    }

    /**
     * 修改主页展示
     */
    @GetMapping("/edit/{imsHomeId}")
    public String edit(@PathVariable("imsHomeId") Long imsHomeId, ModelMap mmap)
    {
        ImsHome imsHome = imsHomeService.selectImsHomeById(imsHomeId);
        mmap.put("imsHome", imsHome);
        return prefix + "/edit";
    }

    /**
     * 修改保存主页展示
     */
    @RequiresPermissions("ims:home:edit")
    @Log(title = "主页展示", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ImsHome imsHome)
    {
        return toAjax(imsHomeService.updateImsHome(imsHome));
    }

    /**
     * 删除主页展示
     */
    @RequiresPermissions("ims:home:remove")
    @Log(title = "主页展示", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(imsHomeService.deleteImsHomeByIds(ids));
    }
    
    @GetMapping("/detail/{imsHomeId}")
    public String detail(@PathVariable("imsHomeId") Long imsHomeId, ModelMap mmap)
    {
		ImsHome imsHome = imsHomeService.selectImsHomeById(imsHomeId);
	    mmap.put("imsHome", imsHome);
        return prefix + "/detail";
    }
}
