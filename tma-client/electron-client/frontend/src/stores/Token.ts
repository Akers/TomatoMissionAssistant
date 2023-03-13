import { defineStore } from 'pinia'

export const useTokenStore = defineStore('token', () => {

    let token = "";
    let lastUpdated = 0;

    function setToken(newToken : string) {
        lastUpdated = Date.parse(new Date().toString());
        token = newToken;
    }

    return { token, lastUpdated, setToken }
})