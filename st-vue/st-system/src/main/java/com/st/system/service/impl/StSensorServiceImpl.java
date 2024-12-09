package com.st.system.service.impl;

import java.util.List;
import com.st.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.st.system.mapper.StSensorMapper;
import com.st.system.domain.StSensor;
import com.st.system.service.IStSensorService;

/**
 * sensorService业务层处理
 * 
 * @author brovast
 * @date 2024-12-09
 */
@Service
public class StSensorServiceImpl implements IStSensorService 
{
    @Autowired
    private StSensorMapper stSensorMapper;

    /**
     * 查询sensor
     * 
     * @param id sensor主键
     * @return sensor
     */
    @Override
    public StSensor selectStSensorById(Long id)
    {
        return stSensorMapper.selectStSensorById(id);
    }

    /**
     * 查询sensor列表
     * 
     * @param stSensor sensor
     * @return sensor
     */
    @Override
    public List<StSensor> selectStSensorList(StSensor stSensor)
    {
        return stSensorMapper.selectStSensorList(stSensor);
    }

    /**
     * 新增sensor
     * 
     * @param stSensor sensor
     * @return 结果
     */
    @Override
    public int insertStSensor(StSensor stSensor)
    {
        stSensor.setCreateTime(DateUtils.getNowDate());
        return stSensorMapper.insertStSensor(stSensor);
    }

    /**
     * 修改sensor
     * 
     * @param stSensor sensor
     * @return 结果
     */
    @Override
    public int updateStSensor(StSensor stSensor)
    {
        stSensor.setUpdateTime(DateUtils.getNowDate());
        return stSensorMapper.updateStSensor(stSensor);
    }

    /**
     * 批量删除sensor
     * 
     * @param ids 需要删除的sensor主键
     * @return 结果
     */
    @Override
    public int deleteStSensorByIds(Long[] ids)
    {
        return stSensorMapper.deleteStSensorByIds(ids);
    }

    /**
     * 删除sensor信息
     * 
     * @param id sensor主键
     * @return 结果
     */
    @Override
    public int deleteStSensorById(Long id)
    {
        return stSensorMapper.deleteStSensorById(id);
    }
}
