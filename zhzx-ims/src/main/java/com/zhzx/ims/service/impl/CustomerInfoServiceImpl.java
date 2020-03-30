package com.zhzx.ims.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhzx.ims.mapper.CustomerInfoMapper;
import com.zhzx.ims.domain.CustomerInfo;
import com.zhzx.ims.service.ICustomerInfoService;
import com.zhzx.common.core.text.Convert;

/**
 * 客户信息Service业务层处理
 * 
 * @author kiver
 * @date 2019-12-04
 */
@Service
public class CustomerInfoServiceImpl implements ICustomerInfoService 
{
    @Autowired
    private CustomerInfoMapper customerInfoMapper;

    /**
     * 查询客户信息
     * 
     * @param customerInfoId 客户信息ID
     * @return 客户信息
     */
    @Override
    public CustomerInfo selectCustomerInfoById(Long customerInfoId)
    {
        return customerInfoMapper.selectCustomerInfoById(customerInfoId);
    }

    /**
     * 查询客户信息列表
     * 
     * @param customerInfo 客户信息
     * @return 客户信息
     */
    @Override
    public List<CustomerInfo> selectCustomerInfoList(CustomerInfo customerInfo)
    {
        return customerInfoMapper.selectCustomerInfoList(customerInfo);
    }

    /**
     * 新增客户信息
     * 
     * @param customerInfo 客户信息
     * @return 结果
     */
    @Override
    public int insertCustomerInfo(CustomerInfo customerInfo)
    {
        return customerInfoMapper.insertCustomerInfo(customerInfo);
    }

    /**
     * 修改客户信息
     * 
     * @param customerInfo 客户信息
     * @return 结果
     */
    @Override
    public int updateCustomerInfo(CustomerInfo customerInfo)
    {
        return customerInfoMapper.updateCustomerInfo(customerInfo);
    }

    /**
     * 删除客户信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCustomerInfoByIds(String ids)
    {
        return customerInfoMapper.deleteCustomerInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除客户信息信息
     * 
     * @param customerInfoId 客户信息ID
     * @return 结果
     */
    @Override
    public int deleteCustomerInfoById(Long customerInfoId)
    {
        return customerInfoMapper.deleteCustomerInfoById(customerInfoId);
    }
}
