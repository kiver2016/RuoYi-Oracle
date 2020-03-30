package com.zhzx.ims.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhzx.ims.mapper.PaymentInfoMapper;
import com.zhzx.ims.domain.PaymentInfo;
import com.zhzx.ims.service.IPaymentInfoService;
import com.zhzx.common.core.text.Convert;

/**
 * 付款信息Service业务层处理
 * 
 * @author kiver
 * @date 2019-12-04
 */
@Service
public class PaymentInfoServiceImpl implements IPaymentInfoService 
{
    @Autowired
    private PaymentInfoMapper paymentInfoMapper;

    /**
     * 查询付款信息
     * 
     * @param paymentInfoId 付款信息ID
     * @return 付款信息
     */
    @Override
    public PaymentInfo selectPaymentInfoById(Long paymentInfoId)
    {
        return paymentInfoMapper.selectPaymentInfoById(paymentInfoId);
    }

    /**
     * 查询付款信息列表
     * 
     * @param paymentInfo 付款信息
     * @return 付款信息
     */
    @Override
    public List<PaymentInfo> selectPaymentInfoList(PaymentInfo paymentInfo)
    {
        return paymentInfoMapper.selectPaymentInfoList(paymentInfo);
    }

    /**
     * 新增付款信息
     * 
     * @param paymentInfo 付款信息
     * @return 结果
     */
    @Override
    public int insertPaymentInfo(PaymentInfo paymentInfo)
    {
        return paymentInfoMapper.insertPaymentInfo(paymentInfo);
    }

    /**
     * 修改付款信息
     * 
     * @param paymentInfo 付款信息
     * @return 结果
     */
    @Override
    public int updatePaymentInfo(PaymentInfo paymentInfo)
    {
        return paymentInfoMapper.updatePaymentInfo(paymentInfo);
    }

    /**
     * 删除付款信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePaymentInfoByIds(String ids)
    {
        return paymentInfoMapper.deletePaymentInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除付款信息信息
     * 
     * @param paymentInfoId 付款信息ID
     * @return 结果
     */
    @Override
    public int deletePaymentInfoById(Long paymentInfoId)
    {
        return paymentInfoMapper.deletePaymentInfoById(paymentInfoId);
    }

	@Override
	public void batchUpdatePaymentInfoByParentId(Long customerInfoId, String parentId) {
		PaymentInfo paymentInfo = new PaymentInfo();
		paymentInfo.setParentId(parentId);
		List<PaymentInfo> list = paymentInfoMapper.selectPaymentInfoList(paymentInfo);
		for (PaymentInfo paymentInfo2 : list) {
			paymentInfo2.setParentId(customerInfoId+"");
			paymentInfoMapper.updatePaymentInfo(paymentInfo2);
		}
	}
}
