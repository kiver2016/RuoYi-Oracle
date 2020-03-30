package com.zhzx.ims.statistics;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhzx.common.annotation.Log;
import com.zhzx.common.core.controller.BaseController;
import com.zhzx.common.enums.BusinessType;

/**
 * 统计报表Controller
 * 
 * @author kiver
 * @date 2020年2月29日 20:39:03
 */
@Controller
@RequestMapping("/ims/report")
public class ReportController extends BaseController
{
    private String prefix = "ims/report";

    /**
      * 订单付款统计
     */
    @RequiresPermissions("ims:report:orderpayment")
    @Log(title = "订单付款统计", businessType = BusinessType.OTHER)
    @GetMapping("/orderpayment")
    public String orderpayment()
    {
        return prefix + "/orderpayment";
    }
    /**
     * 2、	安装费用统计
     */
    @RequiresPermissions("ims:report:installcost")
    @Log(title = "安装费用统计", businessType = BusinessType.OTHER)
    @GetMapping("/installcost")
    public String installcost()
    {
    	return prefix + "/installcost";
    }
    /**
     * 3、	按合同统计客户收款情况
     */
    @RequiresPermissions("ims:report:contractpayment")
    @Log(title = "按合同统计客户收款情况", businessType = BusinessType.OTHER)
    @GetMapping("/contractpayment")
    public String contractpayment()
    {
    	return prefix + "/contractpayment";
    }
    /**
     * 4、	按顾客统计收款情况
     */
    @RequiresPermissions("ims:report:customerpayment")
    @Log(title = "按顾客统计收款情况", businessType = BusinessType.OTHER)
    @GetMapping("/customerpayment")
    public String customerpayment()
    {
    	return prefix + "/customerpayment";
    }
    /**
     * 5、	售员业绩统计 
     */
    @RequiresPermissions("ims:report:saleach")
    @Log(title = "售员业绩统计 ", businessType = BusinessType.OTHER)
    @GetMapping("/saleach")
    public String saleach()
    {
    	return prefix + "/saleach";
    }
}
