<template>
  <div>
    <el-form ref="st_sensor" :model="formData" :rules="rules" size="default" label-width="100px">
      <el-form-item label="像素/Pixel" prop="Pixel">
        <el-input v-model="formData.Pixel" type="text" placeholder="请输入像素/Pixel" clearable
          :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="Sensor型号" prop="Sensor型号">
        <el-input v-model="formData.Sensor型号" type="text" placeholder="请输入Sensor型号" clearable
          :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="Sensor厂商" prop="Sensor厂商">
        <el-input v-model="formData.Sensor厂商" type="text" placeholder="请输入Sensor型号Sensor厂商" clearable
          :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="CRA" prop="CRA">
        <el-input v-model="formData.CRA" type="text" placeholder="请输入Sensor型号CRA" clearable
          :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="Package" prop="Package">
        <el-input v-model="formData.Package" type="text" clearable :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="Die_Size_L" prop="Die_Size_L">
        <el-input v-model="formData.Die_Size_L" type="text" placeholder="请输入Sensor型号Die_Size_L" clearable
          :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="Die_Size_W" prop="Die_Size_W">
        <el-input v-model="formData.Die_Size_W" type="text" placeholder="请输入Sensor型号Die_Size_W" clearable
          :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="Die_Size_H" prop="Die_Size_H">
        <el-input v-model="formData.Die_Size_H" type="text" placeholder="请输入Sensor型号Die_Size_H" clearable
          :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="成像区尺寸_L" prop="成像区尺寸_L">
        <el-input v-model="formData.成像区尺寸_L" type="text" placeholder="请输入Sensor型号成像区尺寸_L" clearable
          :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="成像区尺寸_W" prop="成像区尺寸_W">
        <el-input v-model="formData.成像区尺寸_W" type="text" placeholder="请输入Sensor型号成像区尺寸_W" clearable
          :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="Bonding_Pad_Open_size_L" prop="Bonding_Pad_Open_size_L">
        <el-input v-model="formData.Bonding_Pad_Open_size_L" type="text" placeholder="Bonding_Pad_Open_size_L"
          clearable :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="Bonding_Pad_Open_size_W" prop="Bonding_Pad_Open_size_W">
        <el-input v-model="formData.Bonding_Pad_Open_size_W" type="text"
          placeholder="请输入Bonding_Pad_Open_size_W" clearable :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="是否支持OISEN" prop="是否支持OISEN">
        <el-select v-model="formData.是否支持OISEN" placeholder="请选择是否支持OISEN" clearable :style="{width: '100%'}">
          <el-option v-for="(item, index) in 是否支持OISENOptions" :key="index" :label="item.label"
            :value="item.value" :disabled="item.disabled"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="Interface" prop="Interface">
        <el-input v-model="formData.Interface" type="text" placeholder="Interface" clearable
          :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="I2C/I3C是否可兼容" prop="I2C/I3C是否可兼容">
        <el-select v-model="formData.I2C/I3C是否可兼容" placeholder="请选择I2C/I3C是否可兼容" clearable
          :style="{width: '100%'}">
          <el-option v-for="(item, index) in I2C/I3C是否可兼容Options" :key="index" :label="item.label"
            :value="item.value" :disabled="item.disabled"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="Data format" prop="Data_format">
        <el-input v-model="formData.Data_format" type="text" placeholder="请输入Data format" clearable
          :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="此项目使用I2C Slave ID" prop="use_I2C_Slave_ID">
        <el-input v-model="formData.use_I2C_Slave_ID" type="textarea" placeholder="请输入此项目使用I2C Slave ID"
          :autosize="{minRows: 4, maxRows: 4}" :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="可支持I2C Slave ID" prop="I2C_Slave_ID">
        <el-input v-model="formData.I2C_Slave_ID" type="textarea" placeholder="请输入可支持I2C Slave ID"
          :autosize="{minRows: 4, maxRows: 4}" :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="AVDD" prop="AVDD">
        <el-input v-model="formData.AVDD" type="text" placeholder="请输入AVDD" clearable
          :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="DVDD" prop="DVDD">
        <el-input v-model="formData.DVDD" type="text" placeholder="请输入DVDD" clearable
          :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="DOVDD" prop="DOVDD">
        <el-input v-model="formData.DOVDD" type="text" placeholder="请输入DOVDD" clearable
          :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="Mega" prop="Mega">
        <el-input v-model="formData.Mega" type="text" placeholder="请输入Mega" clearable
          :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="H*V" prop="H*V">
        <el-input v-model="formData.H*V" type="text" placeholder="请输入H*V" clearable
          :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="DiagoNAl" prop="DiagoNAl">
        <el-input v-model="formData.DiagoNAl" type="text" placeholder="请输入DiagoNAl" clearable
          :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="pixel size" prop="pixel_size">
        <el-input v-model="formData.pixel_size" type="text" placeholder="请输入pixel size" clearable
          :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="最大功耗" prop="最大功耗">
        <el-input v-model="formData.最大功耗" type="text" placeholder="请输入最大功耗" clearable
          :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="Frame Rate@full resolution" prop="Frame_Rate_full_resolution">
        <el-input v-model="formData.Frame_Rate_full_resolution" type="text"
          placeholder="请输入Frame Rate@full resolution" clearable :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="HBM" prop="HBM">
        <el-input v-model="formData.HBM" type="text" placeholder="请输入HBM" clearable
          :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="CDM" prop="CDM">
        <el-input v-model="formData.CDM" type="text" placeholder="请输入CDM" clearable
          :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm">提交</el-button>
        <el-button @click="resetForm">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script setup>
import {
  ElMessage
}
from 'element-plus'
const st_sensor = ref()
const data = reactive({
  formData: {
    Pixel: undefined,
    Sensor型号: undefined,
    Sensor厂商: undefined,
    CRA: undefined,
    Package: undefined,
    Die_Size_L: undefined,
    Die_Size_W: undefined,
    Die_Size_H: undefined,
    成像区尺寸_L: undefined,
    成像区尺寸_W: undefined,
    Bonding_Pad_Open_size_L: undefined,
    Bonding_Pad_Open_size_W: undefined,
    是否支持OISEN: '是',
    Interface: undefined,
    I2C / I3C是否可兼容: undefined,
    Data_format: undefined,
    use_I2C_Slave_ID: undefined,
    I2C_Slave_ID: undefined,
    AVDD: undefined,
    DVDD: undefined,
    DOVDD: undefined,
    Mega: undefined,
    H * V: undefined,
    DiagoNAl: undefined,
    pixel_size: undefined,
    最大功耗: undefined,
    Frame_Rate_full_resolution: undefined,
    HBM: undefined,
    CDM: undefined,
  },
  rules: {
    Pixel: [{
      required: true,
      message: '请输入像素/Pixel',
      trigger: 'blur'
    }],
    Sensor型号: [{
      required: true,
      message: '请输入Sensor型号',
      trigger: 'blur'
    }],
    Sensor厂商: [{
      required: true,
      message: '请输入Sensor型号Sensor厂商',
      trigger: 'blur'
    }],
    CRA: [{
      required: true,
      message: '请输入Sensor型号CRA',
      trigger: 'blur'
    }],
    Package: [{
      required: true,
      message: '',
      trigger: 'blur'
    }],
    Die_Size_L: [{
      required: true,
      message: '请输入Sensor型号Die_Size_L',
      trigger: 'blur'
    }],
    Die_Size_W: [{
      required: true,
      message: '请输入Sensor型号Die_Size_W',
      trigger: 'blur'
    }],
    Die_Size_H: [{
      required: true,
      message: '请输入Sensor型号Die_Size_H',
      trigger: 'blur'
    }],
    成像区尺寸_L: [{
      required: true,
      message: '请输入Sensor型号成像区尺寸_L',
      trigger: 'blur'
    }],
    成像区尺寸_W: [{
      required: true,
      message: '请输入Sensor型号成像区尺寸_W',
      trigger: 'blur'
    }],
    Bonding_Pad_Open_size_L: [{
      required: true,
      message: 'Bonding_Pad_Open_size_L',
      trigger: 'blur'
    }],
    Bonding_Pad_Open_size_W: [{
      required: true,
      message: '请输入Bonding_Pad_Open_size_W',
      trigger: 'blur'
    }],
    是否支持OISEN: [{
      required: true,
      message: '请选择是否支持OISEN',
      trigger: 'change'
    }],
    Interface: [{
      required: true,
      message: 'Interface',
      trigger: 'blur'
    }],
    I2C / I3C是否可兼容: [{
      required: true,
      message: '请选择I2C/I3C是否可兼容',
      trigger: 'change'
    }],
    Data_format: [{
      required: true,
      message: '请输入Data format',
      trigger: 'blur'
    }],
    use_I2C_Slave_ID: [{
      required: true,
      message: '请输入此项目使用I2C Slave ID',
      trigger: 'blur'
    }],
    I2C_Slave_ID: [{
      required: true,
      message: '请输入可支持I2C Slave ID',
      trigger: 'blur'
    }],
    AVDD: [{
      required: true,
      message: '请输入AVDD',
      trigger: 'blur'
    }],
    DVDD: [{
      required: true,
      message: '请输入DVDD',
      trigger: 'blur'
    }],
    DOVDD: [{
      required: true,
      message: '请输入DOVDD',
      trigger: 'blur'
    }],
    Mega: [{
      required: true,
      message: '请输入Mega',
      trigger: 'blur'
    }],
    H * V: [{
      required: true,
      message: '请输入H*V',
      trigger: 'blur'
    }],
    DiagoNAl: [{
      required: true,
      message: '请输入DiagoNAl',
      trigger: 'blur'
    }],
    pixel_size: [{
      required: true,
      message: '请输入pixel size',
      trigger: 'blur'
    }],
    最大功耗: [{
      required: true,
      message: '请输入最大功耗',
      trigger: 'blur'
    }],
    Frame_Rate_full_resolution: [{
      required: true,
      message: '请输入Frame Rate@full resolution',
      trigger: 'blur'
    }],
    HBM: [{
      required: true,
      message: '请输入HBM',
      trigger: 'blur'
    }],
    CDM: [{
      required: true,
      message: '请输入CDM',
      trigger: 'blur'
    }],
  }
})
const {
  formData,
  rules
} = toRefs(data)
const 是否支持OISENOptions = ref([{
  "label": "是",
  "value": 1
}, {
  "label": "否",
  "value": 2
}])
const I2C / I3C是否可兼容Options = ref([{
  "label": "是",
  "value": 1
}, {
  "label": "否",
  "value": 2
}])
/**
 * @name: 表单提交
 * @description: 表单提交方法
 * @return {*}
 */
function submitForm() {
  st_sensor.value.validate((valid) => {
    if (!valid) return
    // TODO 提交表单
  })
}
/**
 * @name: 表单重置
 * @description: 表单重置方法
 * @return {*}
 */
function resetForm() {
  st_sensor.value.resetFields()
}

</script>
<style>
</style>
