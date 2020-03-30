package com.zhzx.ims.service;

import com.zhzx.ims.domain.ImsHome;
import java.util.List;

/**
 * 主页展示Service接口
 * 
 * @author kiver
 * @date 2020-02-21
 */
public interface IImsHomeService 
{
    /**
     * 查询主页展示
     * 
     * @param imsHomeId 主页展示ID
     * @return 主页展示
     */
    public ImsHome selectImsHomeById(Long imsHomeId);

    /**
     * 查询主页展示列表
     * 
     * @param imsHome 主页展示
     * @return 主页展示集合
     */
    public List<ImsHome> selectImsHomeList(ImsHome imsHome);

    /**
     * 新增主页展示
     * 
     * @param imsHome 主页展示
     * @return 结果
     */
    public int insertImsHome(ImsHome imsHome);

    /**
     * 修改主页展示
     * 
     * @param imsHome 主页展示
     * @return 结果
     */
    public int updateImsHome(ImsHome imsHome);

    /**
     * 批量删除主页展示
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteImsHomeByIds(String ids);

    /**
     * 删除主页展示信息
     * 
     * @param imsHomeId 主页展示ID
     * @return 结果
     */
    public int deleteImsHomeById(Long imsHomeId);
}
