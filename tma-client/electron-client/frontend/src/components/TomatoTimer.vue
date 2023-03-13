<template>
    <div class="circle-main">
        <!-- 倒计时显示 -->
        <div class="circle-main-box" :style="[{ 'width': size + 'px', 'height': size + 'px' }]">
            <svg :width="size" :height="size" class="circle">
                <circle :r="radius" :cx="cx" :cy="cy" fill="transparent" class="timer-bg" :stroke-width="strokeBgWidth" />
                <circle :r="radius" :cx="cx" :cy="cy" fill="transparent" :class="timerFgClass" :stroke-width="strokeWidth"
                    stroke-linecap="round" :stroke-dasharray="circumference" :stroke-dashoffset="progress" />
            </svg>
            <span class="time-remaining" :style="[{ 'font-size': size * .25 + 'px' }]">{{ timeRemaining }}</span>
            <span class="time-type" :style="[{ 'font-size': size * .1 + 'px' }]">{{ statusText }}</span>
        </div>
        <!-- 倒计时控制 -->
        <div class="timer-toolbox">
            <div class="btn-circle"
                @mouseenter="statusBtnEnter" 
                @mouseleave="statusBtnLeave"
                @click="statusBtnClick"
                >
                <caret-right-outlined :style="data.statusBtnStyle" v-if="TIMER_STAUTS_STOPPED == data.status || TIMER_STAUTS_PAUSED == data.status" />
                <pause-outlined :style="data.statusBtnStyle" v-if="TIMER_STAUTS_RUNNING == data.status" />
                <step-forward-outlined :style="data.statusBtnStyle" v-if="TIMER_STAUTS_COUNTDOWN_FINISHED == data.status" />
            </div>
        </div>
    </div>
</template>

<script setup lang="ts">
import {
    CaretRightOutlined,
    PauseOutlined,
    StepForwardOutlined
} from '@ant-design/icons-vue';
import { reactive, computed, onMounted, defineEmits } from 'vue'

const TIMER_TYPE_FOCUS = 'FOCUS';
const TIMER_TYPE_SHORTBREAK = 'SHORTBREAK';
const TIMER_TYPE_LONGBREAK = 'LONGBREAK';
// 计时器状态：已经停止
const TIMER_STAUTS_STOPPED = 0;
// 计时器状态：计时中
const TIMER_STAUTS_RUNNING = 1;
// 计时器状态：暂停
const TIMER_STAUTS_PAUSED = 2;
// 计时器状态：计时器已完结
const TIMER_STAUTS_COUNTDOWN_FINISHED = 3;
// 计时器状态：已完结
const TIMER_STAUTS_FINISHED = 4;


const data = reactive({
    countDown: 0,
    status: TIMER_STAUTS_STOPPED,
    // 已暂停时长
    pausedTime: 0,
    // 阶段超额时长
    overTime: 0,
    statusBtnStyle: {
        fontSize: '20px',
        lineHeight: '50px',
        color: '#f5f1ea',
    },
    countDownInterval: -1,
    pausedTimeInterval: -1,
    overTimeInterval: -1,
})

const props = defineProps({
    // 总时间（秒）
    value: {
        type: [Number],
        default: 0
    },
    // 当前时间（秒）
    now: {
        type: [Number],
        default: 0
    },
    type: {
        type: [String],
        default: 'FOCUS'
    },
    autoCountDown: {
        type: [Boolean],
        default: false,
    },
    started: {
        type: [Boolean],
        default: false,
    },
    // 尺寸
    size: {
        type: [Number],
        default: 120
    },
    // 边框粗细
    strokeWidth: {
        type: [Number],
        default: 10
    },
    // 动画执行时间
    duration: {
        type: [String, Number],
        default: 1000
    }
})

// 定义事件
// const emit = defineEmits([
//     'countDownFinished' // 当前计时完成
//     , 'timerStarted' // 开始当前计时
//     , 'timerPaused' // 计时器已暂停
//     , 'timerResumed' // 计时重新开始
//     , 'timerFinished' // 当前计时已完结
// ]);

const emit = defineEmits<{
  (e: 'countDownFinished'): void // 当前计时完成
  (e: 'timerStarted'): void // 开始当前计时
  (e: 'timerPaused'): void // 计时器已暂停
  (e: 'timerResumed', pausedTime : number): void // 计时重新开始，pausedTime为暂停时长
  (e: 'timerFinished', overTime : number): void // 当前计时已完结，overTime为超时时间
}>()


const timeRemaining = computed(() => {

    if (TIMER_STAUTS_PAUSED == data.status) {
        // 计算分钟
        let minutes = Math.floor(data.pausedTime / 60);
        // 计算秒
        let seconds = Math.floor(data.pausedTime % 60);

        return `${minutes >= 10 ? minutes : '0' + minutes}:${seconds >= 10 ? seconds : '0' + seconds}`;
    } else if (TIMER_STAUTS_COUNTDOWN_FINISHED == data.status) {
        // 计算分钟
        let minutes = Math.floor(data.overTime / 60);
        // 计算秒
        let seconds = Math.floor(data.overTime % 60);

        return `${minutes >= 10 ? minutes : '0' + minutes}:${seconds >= 10 ? seconds : '0' + seconds}`;
    } else {
        // 计算分钟
        let minutes = Math.floor(nowSecond.value / 60);
        // 计算秒
        let seconds = Math.floor(nowSecond.value % 60);

        return `${minutes >= 10 ? minutes : '0' + minutes}:${seconds >= 10 ? seconds : '0' + seconds}`;
    }

    
});
// 圆心x轴坐标
const cx = computed(() => {
    return props.size / 2;
});
// 圆心y轴坐标  
const cy = computed(() => {
    return props.size / 2;
});
// 半径
const radius = computed(() => {
    return (props.size - props.strokeWidth) / 2;
});
const nowSecond = computed(() => {
    if (props.autoCountDown) {
        return props.value - data.countDown;
    } else {
        return props.now;
    }
});
// 圆周长
const circumference = computed(calCircumference);
// 进度长度  
const progress = computed(() => {
    // console.log(((props.value - props.now) / props.value));
    // return ((props.value - props.now) / props.value) * calCircumference();
    return (1 - (nowSecond.value / props.value)) * calCircumference();
});
// 边框背景宽度
const strokeBgWidth = computed(() => {
    return props.strokeWidth - 8;
});
// 状态文案
const statusText = computed(() => {
    switch(data.status) {
        // 计时器状态：暂停
        case TIMER_STAUTS_PAUSED:
            return '暂停中'
        case TIMER_STAUTS_COUNTDOWN_FINISHED:
            return '已结束'
        default:
            switch(props.type) {
                case TIMER_TYPE_FOCUS:
                    return '专注工作';
                case TIMER_TYPE_SHORTBREAK:
                    return '短休息';
                case TIMER_TYPE_LONGBREAK:
                    return '长休息';
                default:
                    return '专注工作';
            }
    }
});


const timerFgClass = computed(() => {
    let c = 'timer-fg ';
    switch(props.type) {
        case TIMER_TYPE_FOCUS:
            c += "focus"
            break;
        case TIMER_TYPE_SHORTBREAK:
            c += "shortbreak"
            break;
        case TIMER_TYPE_LONGBREAK:
            c += "longbreak"
            break;
        default:
            c += "focus"
    }
    return c;
});

function calCircumference() {
    return 2 * Math.PI * radius.value;
}

// 进入状态按钮事件
function statusBtnEnter() {
    data.statusBtnStyle.color = '#05eb8b';
}
// 离开状态按钮事件
function statusBtnLeave() {
    data.statusBtnStyle.color = '#f5f1ea';
}
// 点击状态按钮
function statusBtnClick() {
    switch(data.status) {
        case TIMER_STAUTS_RUNNING:
            // 计时状态：暂停计时
            data.status = TIMER_STAUTS_PAUSED;
            // 停止主计时，并开始计算暂停时长
            stopCountDownInterval();
            
            emit('timerPaused');
            break;
        case TIMER_STAUTS_PAUSED:
            // 暂停状态：继续计时
            clearInterval(data.pausedTimeInterval);
            data.status = TIMER_STAUTS_RUNNING;
            newCountDownInterval();
            emit('timerResumed', data.pausedTime);
            data.pausedTime = 0;
            break;
        case TIMER_STAUTS_COUNTDOWN_FINISHED:
            // 计时结束状态：停止超时计时，提交计时完结事件
            clearInterval(data.overTimeInterval);
            emit('timerFinished', data.overTime);
            data.overTime = 0;
            break;
        case TIMER_STAUTS_STOPPED:
        default:
            // 停止状态：开始计时
            emit('timerStarted');
            data.countDown = 0;
            data.overTime = 0;
            data.pausedTime = 0;
            data.status = TIMER_STAUTS_RUNNING;
            newCountDownInterval();
    }
}
// 开始新计时
function newCountDownInterval() {
    // 每秒更新
    data.countDownInterval = setInterval(() => {
        data.countDown += 1;
        if (data.countDown == props.value) {
            emit('countDownFinished');
            data.status = TIMER_STAUTS_COUNTDOWN_FINISHED;
            stopCountDownInterval();
        }
    }, 1000);
}

// 停止计时
function stopCountDownInterval() {
    clearInterval(data.countDownInterval);
    if (data.status == TIMER_STAUTS_COUNTDOWN_FINISHED) {
        // 如果当前状态是 TIMER_STAUTS_COUNTDOWN_FINISHED 开始 overTime计时
        data.overTime = 0;
        data.overTimeInterval = setInterval(() => {
            data.overTime += 1;
        }, 1000);
    }
    
    if (data.status == TIMER_STAUTS_PAUSED) {
        // 如果当前状态是 TIMER_STAUTS_PAUSED 开始 pausedTime计时
        data.pausedTime = 0;
        data.pausedTimeInterval = setInterval(() => {
            data.pausedTime += 1;
        }, 1000);
    }
}

onMounted(() => {
    // 如果是countDown模式，定义一个定时器
    if (props.started) {
        data.countDown = 0;
        newCountDownInterval();
    }
});
</script>

<style lang="less" scoped>
@import url(../assets/font/font.css);

.circle-main {
    
    .btn-circle {
        border-radius: 50%;
        border: solid 2px @focus-text-color;
        width: 50px;
        height: 50px;
        text-align: center;
        padding-top: 2px;
        padding-left: 3px;
        margin:0 auto;
    }
    .btn-circle:hover {
        background-color: #3c4356;
    }

    .circle-main-box {
        position: relative;
        display: block;
        margin: 0 auto;
        .circle {
            transform: rotate(-90deg);
            .timer-fg.focus {
                stroke: @timer-focuesd-front-color
            }
            .timer-fg.shortbreak {
                stroke: @timer-shortbreak-front-color
            }
            .timer-fg.longbreak {
                stroke: @timer-longbreak-front-color
            }
            .timer-bg {
                stroke: @timer-bg-color
            }
        }
        
    }

    .time-remaining {
        width: 100px;
        height: 100px;
        position: absolute;
        left: 50%;
        top: 43%;
        margin-left: -50px;
        margin-top: -50px;
        align-items: center;
        justify-content: center;
        display: flex;
        font-family: HarmonyOSSansSCThin;
        font-size: 20px;
        // color: #333;
        color: @main-text-color;
        user-select: none;
    }
    .time-type {
        width: 100px;
        height: 100px;
        position: absolute;
        left: 50%;
        top: 68%;
        margin-left: -50px;
        margin-top: -50px;
        align-items: center;
        justify-content: center;
        display: flex;
        font-family: HarmonyOSSansSCThin;
        font-size: 20px;
        // color: #333;
        color: @main-text-color;
        user-select: none;
    }
    .timer-toolbox {
        width: 100%;
        height: 50px;
        margin-top: 20px;
    }

}
</style>