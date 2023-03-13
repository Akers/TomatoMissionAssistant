import request from '@/utils/request'

// 查询任务列表
export function listMission(query) {
  return request({
    url: '/tmaserver/mission/list',
    method: 'get',
    params: query
  })
}

// 查询任务详细
export function getMission(id) {
  return request({
    url: '/tmaserver/mission/' + id,
    method: 'get'
  })
}

// 新增任务
export function addMission(data) {
  return request({
    url: '/tmaserver/mission',
    method: 'post',
    data: data
  })
}

// 修改任务
export function updateMission(data) {
  return request({
    url: '/tmaserver/mission',
    method: 'put',
    data: data
  })
}

// 删除任务
export function delMission(id) {
  return request({
    url: '/tmaserver/mission/' + id,
    method: 'delete'
  })
}
