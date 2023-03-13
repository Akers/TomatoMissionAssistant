import request from '@/utils/request'

// 查询番茄配置列表
export function listTotamoConfig(query) {
  return request({
    url: '/tmaserver/totamoConfig/list',
    method: 'get',
    params: query
  })
}

// 查询番茄配置详细
export function getTotamoConfig(id) {
  return request({
    url: '/tmaserver/totamoConfig/' + id,
    method: 'get'
  })
}

// 新增番茄配置
export function addTotamoConfig(data) {
  return request({
    url: '/tmaserver/totamoConfig',
    method: 'post',
    data: data
  })
}

// 修改番茄配置
export function updateTotamoConfig(data) {
  return request({
    url: '/tmaserver/totamoConfig',
    method: 'put',
    data: data
  })
}

// 删除番茄配置
export function delTotamoConfig(id) {
  return request({
    url: '/tmaserver/totamoConfig/' + id,
    method: 'delete'
  })
}
