import axios from 'axios'
import {useTokenStore} from '../stores/Token'
import notification from 'ant-design-vue/es/notification'
import { VueAxios } from './axios'
import type { App } from 'vue';

// 创建 axios 实例
const request = axios.create({
  // API 请求的默认前缀
  baseURL: import.meta.env.VUE_APP_API_BASE_URL,
  timeout: 60000, // 请求超时时间
  //headers: {'Content-Type': 'multipart/form-data'}
})

// 异常拦截处理器
const errorHandler = (error : any) => {
  if (error.response) {
    const data = error.response.data
    if (error.response.status === 403) {
      notification.error({
        message: 'Forbidden',
        description: data.message
      })
    }
    if (error.response.status === 401 && !(data.result && data.result.isLogin)) {
      notification.error({
        message: 'Unauthorized',
        description: 'Authorization verification failed'
      })
    }
  }
  return Promise.reject(error)
}

// request interceptor
request.interceptors.request.use(config => {
  const tokenStore = useTokenStore();
  const token = tokenStore.token
  // 如果 token 存在
  // 让每个请求携带自定义 token 请根据实际情况自行修改
  if (token) {
    config.headers['Access-Token'] = token
  }
  return config
}, errorHandler)

// response interceptor
request.interceptors.response.use((response) => {
  return response.data
}, errorHandler)

const installer = {
  vm: {},
  install (app : App) {
    app.use(VueAxios, request)
  }
}

export default request

export {
  installer as VueAxios,
  request as axios
}
