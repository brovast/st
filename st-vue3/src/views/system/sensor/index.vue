<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="sensor型号" prop="sensorModel">
        <el-input
          v-model="queryParams.sensorModel"
          placeholder="请输入sensor型号"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="sensor厂家" prop="sensorManufacturer">
        <el-input
          v-model="queryParams.sensorManufacturer"
          placeholder="请输入sensor厂家"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="镜头尺寸" prop="resolutionDiagonai">
        <el-input
          v-model="queryParams.resolutionDiagonai"
          placeholder="请输入镜头尺寸"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="像素大小" prop="resolutionPixelsize">
        <el-input
          v-model="queryParams.resolutionPixelsize"
          placeholder="请输入像素大小"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="像素" prop="sensorPixel">
        <el-input
          v-model="queryParams.sensorPixel"
          placeholder="请输入像素"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
        <el-button icon="Refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="Plus"
          @click="handleAdd"
          v-hasPermi="['system:sensor:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="Edit"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:sensor:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="Delete"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:sensor:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="Download"
          @click="handleExport"
          v-hasPermi="['system:sensor:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="sensorList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="" align="center" prop="id" />
      <el-table-column label="sensor型号" align="center" prop="sensorModel" />
      <el-table-column label="sensor厂家" align="center" prop="sensorManufacturer" />
      <el-table-column label="CRA" align="center" prop="cra" />
      <el-table-column label="Package" align="center" prop="package" />
      <el-table-column label="DieSizeL" align="center" prop="dieSizeL" />
      <el-table-column label="dieSizeW" align="center" prop="dieSizeW" />
      <el-table-column label="dieSizeH" align="center" prop="dieSizeH" />
      <el-table-column label="imageAreaSizeL" align="center" prop="imageAreaSizeL" />
      <el-table-column label="imageAreaSizeW" align="center" prop="imageAreaSizeW" />
      <el-table-column label="bondindPadOpenL" align="center" prop="bondindPadOpenL" />
      <el-table-column label="bondingPadOpenW" align="center" prop="bondingPadOpenW" />
      <el-table-column label="ois" align="center" prop="ois" />
      <el-table-column label="interface" align="center" prop="interface" />
      <el-table-column label="isi23c" align="center" prop="isi23c" />
      <el-table-column label="dataFormat" align="center" prop="dataFormat" />
      <el-table-column label="usei2cSlaveid" align="center" prop="usei2cSlaveid" />
      <el-table-column label="supportI2cSlaveid" align="center" prop="supportI2cSlaveid" />
      <el-table-column label="powersupplyAvdd" align="center" prop="powersupplyAvdd" />
      <el-table-column label="powersupplyDvdd" align="center" prop="powersupplyDvdd" />
      <el-table-column label="powersupplyDovdd" align="center" prop="powersupplyDovdd" />
      <el-table-column label="resolutionMega" align="center" prop="resolutionMega" />
      <el-table-column label="resolutionHv" align="center" prop="resolutionHv" />
      <el-table-column label="镜头尺寸" align="center" prop="resolutionDiagonai" />
      <el-table-column label="像素大小" align="center" prop="resolutionPixelsize" />
      <el-table-column label="powermax" align="center" prop="powermax" />
      <el-table-column label="framerate" align="center" prop="framerate" />
      <el-table-column label="sensorHbm" align="center" prop="sensorHbm" />
      <el-table-column label="sensorCdm" align="center" prop="sensorCdm" />
      <el-table-column label="remark" align="center" prop="remark" />
      <el-table-column label="像素" align="center" prop="sensorPixel" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:sensor:edit']">修改</el-button>
          <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['system:sensor:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      v-model:page="queryParams.pageNum"
      v-model:limit="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改sensor对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="sensorRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="sensor型号" prop="sensorModel">
          <el-input v-model="form.sensorModel" placeholder="请输入sensor型号" />
        </el-form-item>
        <el-form-item label="sensor厂家" prop="sensorManufacturer">
          <el-input v-model="form.sensorManufacturer" placeholder="请输入sensor厂家" />
        </el-form-item>
        <el-form-item label="" prop="cra">
          <el-input v-model="form.cra" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="" prop="package">
          <el-input v-model="form.package" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="" prop="dieSizeL">
          <el-input v-model="form.dieSizeL" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="" prop="dieSizeW">
          <el-input v-model="form.dieSizeW" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="" prop="dieSizeH">
          <el-input v-model="form.dieSizeH" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="" prop="imageAreaSizeL">
          <el-input v-model="form.imageAreaSizeL" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="" prop="imageAreaSizeW">
          <el-input v-model="form.imageAreaSizeW" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="" prop="bondindPadOpenL">
          <el-input v-model="form.bondindPadOpenL" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="" prop="bondingPadOpenW">
          <el-input v-model="form.bondingPadOpenW" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="" prop="ois">
          <el-input v-model="form.ois" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="" prop="interface">
          <el-input v-model="form.interface" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="" prop="isi23c">
          <el-input v-model="form.isi23c" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="" prop="dataFormat">
          <el-input v-model="form.dataFormat" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="" prop="usei2cSlaveid">
          <el-input v-model="form.usei2cSlaveid" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="" prop="supportI2cSlaveid">
          <el-input v-model="form.supportI2cSlaveid" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="" prop="powersupplyAvdd">
          <el-input v-model="form.powersupplyAvdd" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="" prop="powersupplyDvdd">
          <el-input v-model="form.powersupplyDvdd" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="" prop="powersupplyDovdd">
          <el-input v-model="form.powersupplyDovdd" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="" prop="resolutionMega">
          <el-input v-model="form.resolutionMega" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="" prop="resolutionHv">
          <el-input v-model="form.resolutionHv" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="镜头尺寸" prop="resolutionDiagonai">
          <el-input v-model="form.resolutionDiagonai" placeholder="请输入镜头尺寸" />
        </el-form-item>
        <el-form-item label="像素大小" prop="resolutionPixelsize">
          <el-input v-model="form.resolutionPixelsize" placeholder="请输入像素大小" />
        </el-form-item>
        <el-form-item label="" prop="powermax">
          <el-input v-model="form.powermax" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="" prop="framerate">
          <el-input v-model="form.framerate" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="" prop="sensorHbm">
          <el-input v-model="form.sensorHbm" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="" prop="sensorCdm">
          <el-input v-model="form.sensorCdm" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="像素" prop="sensorPixel">
          <el-input v-model="form.sensorPixel" placeholder="请输入像素" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup name="Sensor">
import { listSensor, getSensor, delSensor, addSensor, updateSensor } from "@/api/system/sensor";

const { proxy } = getCurrentInstance();

const sensorList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    sensorModel: null,
    sensorManufacturer: null,
    resolutionDiagonai: null,
    resolutionPixelsize: null,
    sensorPixel: null
  },
  rules: {
    sensorModel: [
      { required: true, message: "sensor型号不能为空", trigger: "blur" }
    ],
    sensorManufacturer: [
      { required: true, message: "sensor厂家不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询sensor列表 */
function getList() {
  loading.value = true;
  listSensor(queryParams.value).then(response => {
    sensorList.value = response.rows;
    total.value = response.total;
    loading.value = false;
  });
}

// 取消按钮
function cancel() {
  open.value = false;
  reset();
}

// 表单重置
function reset() {
  form.value = {
    id: null,
    sensorModel: null,
    sensorManufacturer: null,
    cra: null,
    package: null,
    dieSizeL: null,
    dieSizeW: null,
    dieSizeH: null,
    imageAreaSizeL: null,
    imageAreaSizeW: null,
    bondindPadOpenL: null,
    bondingPadOpenW: null,
    ois: null,
    interface: null,
    isi23c: null,
    dataFormat: null,
    usei2cSlaveid: null,
    supportI2cSlaveid: null,
    powersupplyAvdd: null,
    powersupplyDvdd: null,
    powersupplyDovdd: null,
    resolutionMega: null,
    resolutionHv: null,
    resolutionDiagonai: null,
    resolutionPixelsize: null,
    powermax: null,
    framerate: null,
    sensorHbm: null,
    sensorCdm: null,
    createTime: null,
    updateTime: null,
    createBy: null,
    updateBy: null,
    remark: null,
    sensorPixel: null
  };
  proxy.resetForm("sensorRef");
}

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
function resetQuery() {
  proxy.resetForm("queryRef");
  handleQuery();
}

// 多选框选中数据
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加sensor";
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const _id = row.id || ids.value
  getSensor(_id).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改sensor";
  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["sensorRef"].validate(valid => {
    if (valid) {
      if (form.value.id != null) {
        updateSensor(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addSensor(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          getList();
        });
      }
    }
  });
}

/** 删除按钮操作 */
function handleDelete(row) {
  const _ids = row.id || ids.value;
  proxy.$modal.confirm('是否确认删除sensor编号为"' + _ids + '"的数据项？').then(function() {
    return delSensor(_ids);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {});
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('system/sensor/export', {
    ...queryParams.value
  }, `sensor_${new Date().getTime()}.xlsx`)
}

getList();
</script>
