'use strict';

const { Controller, Utils } = require('ee-core');
const dayjs = require('dayjs');

/**
 * 任务操作接口
 * @class
 */
class MissionController extends Controller {
    constructor(ctx) {
        super(ctx);
    }
    
}

MissionController.toString = () => '[class MissionController]';
module.exports = MissionController;