import { createApp } from 'vue'
import { createI18n } from 'vue-i18n'
import { createPinia } from 'pinia'
import IpcRenderer from '@/utils/ipcRenderer'
import {createRouter,createWebHashHistory} from 'vue-router'
import { VueAxios } from './utils/request'

import App from './App.vue'


import Antd from 'ant-design-vue';

import messages from '../languages/langs/index'
import constantRouterMap from '@/config/router.config'

// import 'ant-design-vue/dist/antd.css';
import './assets/css/common.less'

const app = createApp(App)

// 配置多语言
const i18n = createI18n({
    locale: localStorage.lang || 'zh_cn',
    messages,
    silentFallbackWarn: true,
})

// 配置路由
const router = createRouter({
    // 4. 内部提供了 history 模式的实现。为了简单起见，我们在这里使用 hash 模式。
    history: createWebHashHistory(),
    routes: constantRouterMap // `routes: routes` 的缩写
})


app.use(createPinia())
app.use(router)
app.use(Antd)
app.use(i18n)
app.use(IpcRenderer)
app.use(VueAxios)
app.mount('#app')