import { defineStore } from 'pinia'

export const useHttpServerConfigStore = defineStore('httpServerConfig', () => {

    const config = {
        enable: false,
        server: ''
    }

    function setConfig(newConfig: any) {
        config.enable = newConfig.enable;
        config.server = newConfig.server;
    }

    return { config, setConfig }
})