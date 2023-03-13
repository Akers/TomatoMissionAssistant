import type { AxiosInstance } from "axios"
import type { App } from "vue"

const VueAxios = {
  vm: {},
  // eslint-disable-next-line no-unused-vars
  install(app : App, instance : AxiosInstance) {
    if (!instance) {
      // eslint-disable-next-line no-console
      console.error('You have to install axios')
      return
    }

    app.config.globalProperties.axios = instance;
    app.config.globalProperties.$http = instance;
  }
}

export {
  VueAxios
}
