package com.st.system.mapper;

import java.util.List;
import com.st.system.domain.StSensor;

/**
 * sensorMapper接口
 * 
 * @author brovast
 * @date 2024-12-09
 */
public interface StSensorMapper 
{
    /**
     * 查询sensor
     * 
     * @param id sensor主键
     * @return sensor
     */
    public StSensor selectStSensorById(Long id);

    /**
     * 查询sensor列表
     * 
     * @param stSensor sensor
     * @return sensor集合
     */
    public List<StSensor> selectStSensorList(StSensor stSensor);

    /**
     * 新增sensor
     * 
     * @param stSensor sensor
     * @return 结果
     */
    public int insertStSensor(StSensor stSensor);

    /**
     * 修改sensor
     * 
     * @param stSensor sensor
     * @return 结果
     */
    public int updateStSensor(StSensor stSensor);

    /**
     * 删除sensor
     * 
     * @param id sensor主键
     * @return 结果
     */
    public int deleteStSensorById(Long id);

    /**
     * 批量删除sensor
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStSensorByIds(Long[] ids);
}
