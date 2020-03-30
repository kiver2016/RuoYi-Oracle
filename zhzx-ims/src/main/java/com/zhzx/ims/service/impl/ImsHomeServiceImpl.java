package com.zhzx.ims.service.impl;

import java.util.List;
import com.zhzx.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhzx.ims.mapper.ImsHomeMapper;
import com.zhzx.ims.domain.ImsHome;
import com.zhzx.ims.service.IImsHomeService;
import com.zhzx.common.core.text.Convert;

/**
 * 主页展示Service业务层处理
 * 
 * @author kiver
 * @date 2020-02-21
 */
@Service
public class ImsHomeServiceImpl implements IImsHomeService 
{
    @Autowired
    private ImsHomeMapper imsHomeMapper;

    /**
     * 查询主页展示
     * 
     * @param imsHomeId 主页展示ID
     * @return 主页展示
     */
    @Override
    public ImsHome selectImsHomeById(Long imsHomeId)
    {
        return imsHomeMapper.selectImsHomeById(imsHomeId);
    }

    /**
     * 查询主页展示列表
     * 
     * @param imsHome 主页展示
     * @return 主页展示
     */
    @Override
    public List<ImsHome> selectImsHomeList(ImsHome imsHome)
    {
        return imsHomeMapper.selectImsHomeList(imsHome);
    }

    /**
     * 新增主页展示
     * 
     * @param imsHome 主页展示
     * @return 结果
     */
    @Override
    public int insertImsHome(ImsHome imsHome)
    {
        imsHome.setCreateTime(DateUtils.getNowDate());
        return imsHomeMapper.insertImsHome(imsHome);
    }

    /**
     * 修改主页展示
     * 
     * @param imsHome 主页展示
     * @return 结果
     */
    @Override
    public int updateImsHome(ImsHome imsHome)
    {
        imsHome.setUpdateTime(DateUtils.getNowDate());
        return imsHomeMapper.updateImsHome(imsHome);
    }

    /**
     * 删除主页展示对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteImsHomeByIds(String ids)
    {
        return imsHomeMapper.deleteImsHomeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除主页展示信息
     * 
     * @param imsHomeId 主页展示ID
     * @return 结果
     */
    @Override
    public int deleteImsHomeById(Long imsHomeId)
    {
        return imsHomeMapper.deleteImsHomeById(imsHomeId);
    }
}
