package com.zhzx.ims.mapper;

import com.zhzx.ims.domain.PaymentInfo;
import java.util.List;

/**
 * 付款信息Mapper接口
 * 
 * @author kiver
 * @date 2019-12-04
 */
public interface PaymentInfoMapper 
{
    /**
     * 查询付款信息
     * 
     * @param paymentInfoId 付款信息ID
     * @return 付款信息
     */
    public PaymentInfo selectPaymentInfoById(Long paymentInfoId);

    /**
     * 查询付款信息列表
     * 
     * @param paymentInfo 付款信息
     * @return 付款信息集合
     */
    public List<PaymentInfo> selectPaymentInfoList(PaymentInfo paymentInfo);

    /**
     * 新增付款信息
     * 
     * @param paymentInfo 付款信息
     * @return 结果
     */
    public int insertPaymentInfo(PaymentInfo paymentInfo);

    /**
     * 修改付款信息
     * 
     * @param paymentInfo 付款信息
     * @return 结果
     */
    public int updatePaymentInfo(PaymentInfo paymentInfo);

    /**
     * 删除付款信息
     * 
     * @param paymentInfoId 付款信息ID
     * @return 结果
     */
    public int deletePaymentInfoById(Long paymentInfoId);

    /**
     * 批量删除付款信息
     * 
     * @param paymentInfoIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePaymentInfoByIds(String[] paymentInfoIds);
}
