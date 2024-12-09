import request from '@/utils/request'

// 查询sensor列表
export function listSensor(query) {
  return request({
    url: '/system/sensor/list',
    method: 'get',
    params: query
  })
}

// 查询sensor详细
export function getSensor(id) {
  return request({
    url: '/system/sensor/' + id,
    method: 'get'
  })
}

// 新增sensor
export function addSensor(data) {
  return request({
    url: '/system/sensor',
    method: 'post',
    data: data
  })
}

// 修改sensor
export function updateSensor(data) {
  return request({
    url: '/system/sensor',
    method: 'put',
    data: data
  })
}

// 删除sensor
export function delSensor(id) {
  return request({
    url: '/system/sensor/' + id,
    method: 'delete'
  })
}
