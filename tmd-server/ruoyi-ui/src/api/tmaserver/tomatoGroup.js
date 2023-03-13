import request from '@/utils/request'

// 查询番茄组列表
export function listTomatoGroup(query) {
  return request({
    url: '/tmaserver/tomatoGroup/list',
    method: 'get',
    params: query
  })
}

// 查询番茄组详细
export function getTomatoGroup(id) {
  return request({
    url: '/tmaserver/tomatoGroup/' + id,
    method: 'get'
  })
}

// 新增番茄组
export function addTomatoGroup(data) {
  return request({
    url: '/tmaserver/tomatoGroup',
    method: 'post',
    data: data
  })
}

// 修改番茄组
export function updateTomatoGroup(data) {
  return request({
    url: '/tmaserver/tomatoGroup',
    method: 'put',
    data: data
  })
}

// 删除番茄组
export function delTomatoGroup(id) {
  return request({
    url: '/tmaserver/tomatoGroup/' + id,
    method: 'delete'
  })
}
