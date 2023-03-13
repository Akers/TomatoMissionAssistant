'use strict';

const _ = require('lodash');
const path = require('path');
const fs = require('fs');
const { exec } = require('child_process');
const { Controller, Utils } = require('ee-core');
const electronApp = require('electron').app;
const { dialog, shell, BrowserView,
    Notification, powerMonitor, screen, nativeTheme } = require('electron');
const dayjs = require('dayjs');

let myTimer = null;
let browserViewObj = null;
let notificationObj = null;

/**
 * 窗口操作接口
 * @class
 */
class WindowController extends Controller {
    constructor(ctx) {
        super(ctx);
    }
    // 退出应用
    async quit() {
        electronApp.quit()
    }
    // 关闭当前窗口
    async close() {
        this.app.electron.mainWindow.close();
    }
    // 最小化当前窗口
    async minimize() {
        this.app.electron.mainWindow.minimize();
    
    }
    // 最前端
    async setOnTop() {
        this.app.electron.mainWindow.setAlwaysOnTop(true, 'pop-up-menu');
    }
    // 取消最前端
    async cancelOnTop() {
        this.app.electron.mainWindow.setAlwaysOnTop(false);
    }
}

WindowController.toString = () => '[class WindowController]';
module.exports = WindowController;