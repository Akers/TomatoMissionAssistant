import request from '@/utils/request'

// 查询任务指派列表
export function listMissionAssigned(query) {
  return request({
    url: '/tmaserver/missionAssigned/list',
    method: 'get',
    params: query
  })
}

// 查询任务指派详细
export function getMissionAssigned(id) {
  return request({
    url: '/tmaserver/missionAssigned/' + id,
    method: 'get'
  })
}

// 新增任务指派
export function addMissionAssigned(data) {
  return request({
    url: '/tmaserver/missionAssigned',
    method: 'post',
    data: data
  })
}

// 修改任务指派
export function updateMissionAssigned(data) {
  return request({
    url: '/tmaserver/missionAssigned',
    method: 'put',
    data: data
  })
}

// 删除任务指派
export function delMissionAssigned(id) {
  return request({
    url: '/tmaserver/missionAssigned/' + id,
    method: 'delete'
  })
}
