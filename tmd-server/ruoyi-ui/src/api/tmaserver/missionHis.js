import request from '@/utils/request'

// 查询任务历史列表
export function listMissionHis(query) {
  return request({
    url: '/tmaserver/missionHis/list',
    method: 'get',
    params: query
  })
}

// 查询任务历史详细
export function getMissionHis(id) {
  return request({
    url: '/tmaserver/missionHis/' + id,
    method: 'get'
  })
}

// 新增任务历史
export function addMissionHis(data) {
  return request({
    url: '/tmaserver/missionHis',
    method: 'post',
    data: data
  })
}

// 修改任务历史
export function updateMissionHis(data) {
  return request({
    url: '/tmaserver/missionHis',
    method: 'put',
    data: data
  })
}

// 删除任务历史
export function delMissionHis(id) {
  return request({
    url: '/tmaserver/missionHis/' + id,
    method: 'delete'
  })
}
