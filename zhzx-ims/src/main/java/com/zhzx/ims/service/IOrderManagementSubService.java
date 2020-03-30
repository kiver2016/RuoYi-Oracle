package com.zhzx.ims.service;

import com.zhzx.ims.domain.OrderManagementSub;
import java.util.List;

/**
 * 订单信息子Service接口
 * 
 * @author kiver
 * @date 2019-12-04
 */
public interface IOrderManagementSubService 
{
    /**
     * 查询订单信息子
     * 
     * @param orderManagementSubId 订单信息子ID
     * @return 订单信息子
     */
    public OrderManagementSub selectOrderManagementSubById(Long orderManagementSubId);

    /**
     * 查询订单信息子列表
     * 
     * @param orderManagementSub 订单信息子
     * @return 订单信息子集合
     */
    public List<OrderManagementSub> selectOrderManagementSubList(OrderManagementSub orderManagementSub);

    /**
     * 新增订单信息子
     * 
     * @param orderManagementSub 订单信息子
     * @return 结果
     */
    public int insertOrderManagementSub(OrderManagementSub orderManagementSub);

    /**
     * 修改订单信息子
     * 
     * @param orderManagementSub 订单信息子
     * @return 结果
     */
    public int updateOrderManagementSub(OrderManagementSub orderManagementSub);

    /**
     * 批量删除订单信息子
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOrderManagementSubByIds(String ids);

    /**
     * 删除订单信息子信息
     * 
     * @param orderManagementSubId 订单信息子ID
     * @return 结果
     */
    public int deleteOrderManagementSubById(Long orderManagementSubId);

	public void batchUpdateOrderManagementSub(Long orderManagementId, String parentId);
}
