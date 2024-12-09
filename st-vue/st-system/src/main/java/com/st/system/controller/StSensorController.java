package com.st.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.st.common.annotation.Log;
import com.st.common.core.controller.BaseController;
import com.st.common.core.domain.AjaxResult;
import com.st.common.enums.BusinessType;
import com.st.system.domain.StSensor;
import com.st.system.service.IStSensorService;
import com.st.common.utils.poi.ExcelUtil;
import com.st.common.core.page.TableDataInfo;

/**
 * sensorController
 * 
 * @author brovast
 * @date 2024-12-09
 */
@RestController
@RequestMapping("/system/sensor")
public class StSensorController extends BaseController
{
    @Autowired
    private IStSensorService stSensorService;

    /**
     * 查询sensor列表
     */
    @PreAuthorize("@ss.hasPermi('system:sensor:list')")
    @GetMapping("/list")
    public TableDataInfo list(StSensor stSensor)
    {
        startPage();
        List<StSensor> list = stSensorService.selectStSensorList(stSensor);
        return getDataTable(list);
    }

    /**
     * 导出sensor列表
     */
    @PreAuthorize("@ss.hasPermi('system:sensor:export')")
    @Log(title = "sensor", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StSensor stSensor)
    {
        List<StSensor> list = stSensorService.selectStSensorList(stSensor);
        ExcelUtil<StSensor> util = new ExcelUtil<StSensor>(StSensor.class);
        util.exportExcel(response, list, "sensor数据");
    }

    /**
     * 获取sensor详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:sensor:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(stSensorService.selectStSensorById(id));
    }

    /**
     * 新增sensor
     */
    @PreAuthorize("@ss.hasPermi('system:sensor:add')")
    @Log(title = "sensor", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StSensor stSensor)
    {
        return toAjax(stSensorService.insertStSensor(stSensor));
    }

    /**
     * 修改sensor
     */
    @PreAuthorize("@ss.hasPermi('system:sensor:edit')")
    @Log(title = "sensor", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StSensor stSensor)
    {
        return toAjax(stSensorService.updateStSensor(stSensor));
    }

    /**
     * 删除sensor
     */
    @PreAuthorize("@ss.hasPermi('system:sensor:remove')")
    @Log(title = "sensor", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stSensorService.deleteStSensorByIds(ids));
    }
}
