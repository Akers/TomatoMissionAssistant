import type { App } from "vue";

const { ipcRenderer: ipc } = ((window as any).require && (window as any).require('electron')) || (window as any).electron || {}

/**
 * 发送异步消息（invoke/handle 模型）
 * @param channel
 * @param param
 * @returns {Promise}
 */
const invoke = (channel: string, ...param: any[]) => {
  const message = ipc.invoke(channel, param);
  return message;
}

/**
 * 发送同步消息（send/on 模型）
 * @param channel
 * @param param
 * @returns {Any}
 */
const sendSync = (channel: string, ...param: any[]) => {
  const message = ipc.sendSync(channel, param);
  return message;
}

export default {
  install(app : App) {
    app.config.globalProperties.$ipc = ipc // 全局注入ipc
    app.config.globalProperties.$ipcInvoke = invoke
    app.config.globalProperties.$ipcSendSync = sendSync
  }
}
