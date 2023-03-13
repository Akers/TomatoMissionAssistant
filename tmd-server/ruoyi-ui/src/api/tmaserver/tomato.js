import request from '@/utils/request'

// 查询番茄计时列表
export function listTomato(query) {
  return request({
    url: '/tmaserver/tomato/list',
    method: 'get',
    params: query
  })
}

// 查询番茄计时详细
export function getTomato(id) {
  return request({
    url: '/tmaserver/tomato/' + id,
    method: 'get'
  })
}

// 新增番茄计时
export function addTomato(data) {
  return request({
    url: '/tmaserver/tomato',
    method: 'post',
    data: data
  })
}

// 修改番茄计时
export function updateTomato(data) {
  return request({
    url: '/tmaserver/tomato',
    method: 'put',
    data: data
  })
}

// 删除番茄计时
export function delTomato(id) {
  return request({
    url: '/tmaserver/tomato/' + id,
    method: 'delete'
  })
}
