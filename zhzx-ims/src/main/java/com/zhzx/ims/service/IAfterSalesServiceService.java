package com.zhzx.ims.service;

import com.zhzx.ims.domain.AfterSalesService;
import java.util.List;

/**
 * 售后服务记录Service接口
 * 
 * @author kiver
 * @date 2019-11-27
 */
public interface IAfterSalesServiceService 
{
    /**
     * 查询售后服务记录
     * 
     * @param afterSalesServiceId 售后服务记录ID
     * @return 售后服务记录
     */
    public AfterSalesService selectAfterSalesServiceById(Long afterSalesServiceId);

    /**
     * 查询售后服务记录列表
     * 
     * @param afterSalesService 售后服务记录
     * @return 售后服务记录集合
     */
    public List<AfterSalesService> selectAfterSalesServiceList(AfterSalesService afterSalesService);

    /**
     * 新增售后服务记录
     * 
     * @param afterSalesService 售后服务记录
     * @return 结果
     */
    public int insertAfterSalesService(AfterSalesService afterSalesService);

    /**
     * 修改售后服务记录
     * 
     * @param afterSalesService 售后服务记录
     * @return 结果
     */
    public int updateAfterSalesService(AfterSalesService afterSalesService);

    /**
     * 批量删除售后服务记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAfterSalesServiceByIds(String ids);

    /**
     * 删除售后服务记录信息
     * 
     * @param afterSalesServiceId 售后服务记录ID
     * @return 结果
     */
    public int deleteAfterSalesServiceById(Long afterSalesServiceId);
}
