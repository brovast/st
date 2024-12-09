<template>
  <div class="home-page">
    <el-row>
      <el-col :span="24">
        <h1 class="title">光学选型系统</h1>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :xs="24" :sm="12" :md="8">
        <el-card class="module-card">
          <template v-slot:header>
            <div class="clearfix">
              <span>光学选型</span>
            </div>
          </template>
          <div class="body">
            <p>选择合适的光学组件</p>
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="12" :md="8">
        <el-card class="module-card">
          <template v-slot:header>
            <div class="clearfix">
              <span>光学数据库维护</span>
            </div>
          </template>
          <div class="body">
            <ul>
              <li>传感器</li>
              <li>镜头</li>
              <li>马达</li>
              <li>驱动</li>
              <li>存储器</li>
            </ul>
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="12" :md="8">
        <el-card class="module-card">
          <template v-slot:header>
            <div class="clearfix">
              <span>CRA计算</span>
            </div>
          </template>
          <div class="body">
            <p>计算CRA值</p>
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="12" :md="8">
        <el-card class="module-card">
          <template v-slot:header>
            <div class="clearfix">
              <span>搭配计算</span>
            </div>
          </template>
          <div class="body">
            <p>计算组件搭配</p>
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="12" :md="8">
        <el-card class="module-card">
          <template v-slot:header>
            <div class="clearfix">
              <span>行程计算</span>
            </div>
          </template>
          <div class="body">
            <p>计算行程</p>
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="12" :md="8">
        <el-card class="module-card">
          <template v-slot:header>
            <div class="clearfix">
              <span>图纸检查</span>
            </div>
          </template>
          <div class="body">
            <p>检查图纸</p>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: 'HomePage',
};
</script>

<style scoped>
.home-page {
  padding: 20px;
  background-color: #f5f5f5;
}

.title {
  text-align: center;
  margin-bottom: 20px;
  font-size: 24px;
  color: #333;
}

.module-card {
  margin-bottom: 20px;
  border-radius: 8px;
  overflow: hidden;
  transition: box-shadow 0.3s;
}

.module-card:hover {
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.el-card__header {
  font-weight: bold;
  background-color: #409eff;
  color: white;
  padding: 10px;
  border-bottom: 1px solid #e0e0e0;
}

.body {
  padding: 20px;
  background-color: white;
}

.body p, .body ul {
  margin: 0;
  color: #666;
}

.body ul {
  padding-left: 20px;
}

.body ul li {
  list-style-type: disc;
}
</style>