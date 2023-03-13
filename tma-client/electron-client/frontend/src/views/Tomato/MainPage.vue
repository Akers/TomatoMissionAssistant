<template>
<div id="app-tomato-main">

    <div class="timer-container">
        <TomatoTimer :value="data.restSecondsOrigin" :auto-count-down="true" :type="data.timerType" :now="data.restSeconds" 
        :size="225" :duration="3000" 
            @count-down-finished="onCountDownFinished"
            @timer-finished="onTimerFinished"
            @timer-paused="onTimerPaused"
            @timer-resumed="onTimerResumed"
            @timer-started="onTimerStarted"
        />
    </div>
    <span class="fenge"></span>
    <!-- 任务列表容器 -->
    <div class="mission-list-container">
        <MissionList />
    </div>
</div>
</template>
<script lang="ts" setup>
    import {reactive} from 'vue'
    import TomatoTimer from '@/components/TomatoTimer.vue';
    import MissionList from '@/components/MissionList/MissionList.vue'

    const TIMER_TYPE_FOCUS = 'FOCUS';
    const TIMER_TYPE_SHORTBREAK = 'SHORTBREAK';
    const TIMER_TYPE_LONGBREAK = 'LONGBREAK';

    const data = reactive({
        percent: 100,
        // 剩余时间
        restSecondsOrigin: 30,
        restSeconds: 1500,
        // 计时类型
        timerType: TIMER_TYPE_FOCUS
    }) 
    
    // 当前计时完成
    function onCountDownFinished() {
        console.log("onCountDownFinished");
    }
    // 开始当前计时
    function onTimerStarted() {
        console.log("onTimerStarted");
    } 
    // 计时器已暂停
    function onTimerPaused() {
        console.log("onTimerPaused");
    } 
    // 计时重新开始，pausedTime为暂停时长
    function onTimerResumed(pausedTime : number) {
        console.log("onTimerResumed, pausedTime: %d", pausedTime);
    }
    // 当前计时已完结，overTime为超时时间  
    function onTimerFinished(overTime : number) {
        console.log("onTimerFinished, overTime: %d", overTime);
    }  
 
</script>
<style lang="less" scoped>

#app-tomato-main {
    width: @win-width;
    height: 430px;
    display: flex;
    .timer-container {
        width: 360px;
        padding-top: 70px;
    }
    .fenge {
        padding: 0;
        margin: 20px 0 0 0;
        border-left: 1px solid @sub-text-color;
        
    }
    .mission-list-container {
        width: @win-width - 360px;
    }
}
</style>
  