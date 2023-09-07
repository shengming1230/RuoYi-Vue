import request from '@/utils/request'

// 查询指令基本信息列表
export function listInfo(query) {
  return request({
    url: '/example/info/list',
    method: 'get',
    params: query
  })
}

// 查询指令基本信息详细
export function getInfo(id) {
  return request({
    url: '/example/info/' + id,
    method: 'get'
  })
}

// 新增指令基本信息
export function addInfo(data) {
  return request({
    url: '/example/info',
    method: 'post',
    data: data
  })
}

// 修改指令基本信息
export function updateInfo(data) {
  return request({
    url: '/example/info',
    method: 'put',
    data: data
  })
}

// 删除指令基本信息
export function delInfo(id) {
  return request({
    url: '/example/info/' + id,
    method: 'delete'
  })
}
