package com.zhzx.ims.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhzx.ims.mapper.OrderManagementMapper;
import com.zhzx.ims.domain.OrderManagement;
import com.zhzx.ims.service.IOrderManagementService;
import com.zhzx.common.core.text.Convert;

/**
 * 订单信息Service业务层处理
 * 
 * @author kiver
 * @date 2019-12-04
 */
@Service
public class OrderManagementServiceImpl implements IOrderManagementService 
{
    @Autowired
    private OrderManagementMapper orderManagementMapper;

    /**
     * 查询订单信息
     * 
     * @param orderManagementId 订单信息ID
     * @return 订单信息
     */
    @Override
    public OrderManagement selectOrderManagementById(Long orderManagementId)
    {
        return orderManagementMapper.selectOrderManagementById(orderManagementId);
    }

    /**
     * 查询订单信息列表
     * 
     * @param orderManagement 订单信息
     * @return 订单信息
     */
    @Override
    public List<OrderManagement> selectOrderManagementList(OrderManagement orderManagement)
    {
        return orderManagementMapper.selectOrderManagementList(orderManagement);
    }

    /**
     * 新增订单信息
     * 
     * @param orderManagement 订单信息
     * @return 结果
     */
    @Override
    public int insertOrderManagement(OrderManagement orderManagement)
    {
        return orderManagementMapper.insertOrderManagement(orderManagement);
    }

    /**
     * 修改订单信息
     * 
     * @param orderManagement 订单信息
     * @return 结果
     */
    @Override
    public int updateOrderManagement(OrderManagement orderManagement)
    {
        return orderManagementMapper.updateOrderManagement(orderManagement);
    }

    /**
     * 删除订单信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOrderManagementByIds(String ids)
    {
        return orderManagementMapper.deleteOrderManagementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订单信息信息
     * 
     * @param orderManagementId 订单信息ID
     * @return 结果
     */
    @Override
    public int deleteOrderManagementById(Long orderManagementId)
    {
        return orderManagementMapper.deleteOrderManagementById(orderManagementId);
    }
}
