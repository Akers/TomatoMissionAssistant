import request from '@/utils/request'

// 查询中断列表
export function listInterrupt(query) {
  return request({
    url: '/tmaserver/interrupt/list',
    method: 'get',
    params: query
  })
}

// 查询中断详细
export function getInterrupt(id) {
  return request({
    url: '/tmaserver/interrupt/' + id,
    method: 'get'
  })
}

// 新增中断
export function addInterrupt(data) {
  return request({
    url: '/tmaserver/interrupt',
    method: 'post',
    data: data
  })
}

// 修改中断
export function updateInterrupt(data) {
  return request({
    url: '/tmaserver/interrupt',
    method: 'put',
    data: data
  })
}

// 删除中断
export function delInterrupt(id) {
  return request({
    url: '/tmaserver/interrupt/' + id,
    method: 'delete'
  })
}
