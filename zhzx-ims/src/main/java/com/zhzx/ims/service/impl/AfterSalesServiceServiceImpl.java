package com.zhzx.ims.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhzx.ims.mapper.AfterSalesServiceMapper;
import com.zhzx.ims.domain.AfterSalesService;
import com.zhzx.ims.service.IAfterSalesServiceService;
import com.zhzx.common.core.text.Convert;

/**
 * 售后服务记录Service业务层处理
 * 
 * @author kiver
 * @date 2019-11-27
 */
@Service
public class AfterSalesServiceServiceImpl implements IAfterSalesServiceService 
{
    @Autowired
    private AfterSalesServiceMapper afterSalesServiceMapper;

    /**
     * 查询售后服务记录
     * 
     * @param afterSalesServiceId 售后服务记录ID
     * @return 售后服务记录
     */
    @Override
    public AfterSalesService selectAfterSalesServiceById(Long afterSalesServiceId)
    {
        return afterSalesServiceMapper.selectAfterSalesServiceById(afterSalesServiceId);
    }

    /**
     * 查询售后服务记录列表
     * 
     * @param afterSalesService 售后服务记录
     * @return 售后服务记录
     */
    @Override
    public List<AfterSalesService> selectAfterSalesServiceList(AfterSalesService afterSalesService)
    {
        return afterSalesServiceMapper.selectAfterSalesServiceList(afterSalesService);
    }

    /**
     * 新增售后服务记录
     * 
     * @param afterSalesService 售后服务记录
     * @return 结果
     */
    @Override
    public int insertAfterSalesService(AfterSalesService afterSalesService)
    {
        return afterSalesServiceMapper.insertAfterSalesService(afterSalesService);
    }

    /**
     * 修改售后服务记录
     * 
     * @param afterSalesService 售后服务记录
     * @return 结果
     */
    @Override
    public int updateAfterSalesService(AfterSalesService afterSalesService)
    {
        return afterSalesServiceMapper.updateAfterSalesService(afterSalesService);
    }

    /**
     * 删除售后服务记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAfterSalesServiceByIds(String ids)
    {
        return afterSalesServiceMapper.deleteAfterSalesServiceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除售后服务记录信息
     * 
     * @param afterSalesServiceId 售后服务记录ID
     * @return 结果
     */
    @Override
    public int deleteAfterSalesServiceById(Long afterSalesServiceId)
    {
        return afterSalesServiceMapper.deleteAfterSalesServiceById(afterSalesServiceId);
    }
}
