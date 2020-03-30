package com.zhzx.ims.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhzx.ims.mapper.OrderManagementSubMapper;
import com.zhzx.ims.domain.OrderManagementSub;
import com.zhzx.ims.service.IOrderManagementSubService;
import com.zhzx.common.core.text.Convert;

/**
 * 订单信息子Service业务层处理
 * 
 * @author kiver
 * @date 2019-12-04
 */
@Service
public class OrderManagementSubServiceImpl implements IOrderManagementSubService 
{
    @Autowired
    private OrderManagementSubMapper orderManagementSubMapper;

    /**
     * 查询订单信息子
     * 
     * @param orderManagementSubId 订单信息子ID
     * @return 订单信息子
     */
    @Override
    public OrderManagementSub selectOrderManagementSubById(Long orderManagementSubId)
    {
        return orderManagementSubMapper.selectOrderManagementSubById(orderManagementSubId);
    }

    /**
     * 查询订单信息子列表
     * 
     * @param orderManagementSub 订单信息子
     * @return 订单信息子
     */
    @Override
    public List<OrderManagementSub> selectOrderManagementSubList(OrderManagementSub orderManagementSub)
    {
        return orderManagementSubMapper.selectOrderManagementSubList(orderManagementSub);
    }

    /**
     * 新增订单信息子
     * 
     * @param orderManagementSub 订单信息子
     * @return 结果
     */
    @Override
    public int insertOrderManagementSub(OrderManagementSub orderManagementSub)
    {
        return orderManagementSubMapper.insertOrderManagementSub(orderManagementSub);
    }

    /**
     * 修改订单信息子
     * 
     * @param orderManagementSub 订单信息子
     * @return 结果
     */
    @Override
    public int updateOrderManagementSub(OrderManagementSub orderManagementSub)
    {
        return orderManagementSubMapper.updateOrderManagementSub(orderManagementSub);
    }

    /**
     * 删除订单信息子对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOrderManagementSubByIds(String ids)
    {
        return orderManagementSubMapper.deleteOrderManagementSubByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订单信息子信息
     * 
     * @param orderManagementSubId 订单信息子ID
     * @return 结果
     */
    @Override
    public int deleteOrderManagementSubById(Long orderManagementSubId)
    {
        return orderManagementSubMapper.deleteOrderManagementSubById(orderManagementSubId);
    }

	@Override
	public void batchUpdateOrderManagementSub(Long orderManagementId, String parentId) {
		OrderManagementSub orderManagementSub = new OrderManagementSub();
		orderManagementSub.setParentId(parentId);
		List<OrderManagementSub> list = orderManagementSubMapper.selectOrderManagementSubList(orderManagementSub);
		for (OrderManagementSub orderManagementSub2 : list) {
			orderManagementSub2.setParentId(orderManagementId+"");
			orderManagementSubMapper.updateOrderManagementSub(orderManagementSub2);
		}
	}
}
