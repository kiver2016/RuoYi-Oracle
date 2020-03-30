package com.zhzx.ims.mapper;

import com.zhzx.ims.domain.OrderManagement;
import java.util.List;

/**
 * 订单信息Mapper接口
 * 
 * @author kiver
 * @date 2019-12-04
 */
public interface OrderManagementMapper 
{
    /**
     * 查询订单信息
     * 
     * @param orderManagementId 订单信息ID
     * @return 订单信息
     */
    public OrderManagement selectOrderManagementById(Long orderManagementId);

    /**
     * 查询订单信息列表
     * 
     * @param orderManagement 订单信息
     * @return 订单信息集合
     */
    public List<OrderManagement> selectOrderManagementList(OrderManagement orderManagement);

    /**
     * 新增订单信息
     * 
     * @param orderManagement 订单信息
     * @return 结果
     */
    public int insertOrderManagement(OrderManagement orderManagement);

    /**
     * 修改订单信息
     * 
     * @param orderManagement 订单信息
     * @return 结果
     */
    public int updateOrderManagement(OrderManagement orderManagement);

    /**
     * 删除订单信息
     * 
     * @param orderManagementId 订单信息ID
     * @return 结果
     */
    public int deleteOrderManagementById(Long orderManagementId);

    /**
     * 批量删除订单信息
     * 
     * @param orderManagementIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteOrderManagementByIds(String[] orderManagementIds);
}
