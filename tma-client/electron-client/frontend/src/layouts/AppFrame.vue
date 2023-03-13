<template>
  <a-layout id="app-layout-frame">
    <a-layout-header class="layout-header">
      <a-row>
        <a-col :span="1"><menu-unfold-outlined :style="{ fontSize: '20px', lineHeight: '35px' }" /></a-col>
        <a-col :span="21">
          <h1 class="title-content">{{ $t('logistics.TMA') }}</h1>
        </a-col>
        <a-col :span="1"><minus-outlined :style="{ fontSize: '20px', lineHeight: '35px' }" @click="minimizeWindow" /></a-col>
        <a-col :span="1"><close-outlined :style="{ fontSize: '20px', lineHeight: '35px' }" @click="closeWindow" /></a-col>
      </a-row>
    </a-layout-header>
    <a-layout-content class="layout-content">
      <router-view />
    </a-layout-content>
  </a-layout>
</template>
<script lang="ts" setup>
import {
  MenuUnfoldOutlined,
  MinusOutlined,
  CloseOutlined,
} from '@ant-design/icons-vue';
import { getCurrentInstance } from "vue";
import {ipcApiRoute} from "@/api/main";

const {
  appContext: {
    config: {
      globalProperties: { $ipc },
    },
  },
} = getCurrentInstance()!


function closeWindow() {
  $ipc.send(ipcApiRoute.quitApp);
}

function minimizeWindow() {
  $ipc.send(ipcApiRoute.minimizeWindow);
}

</script>

<style lang="less" scoped>
@import url('../assets/css/common.less');

// 嵌套
#app-layout-frame {
  height: 100%;
  width: @win-width;
  height: @win-height;
  text-align: center;
  background-color: @bg-color;
  // box-shadow:8px 8px 10px grey;
  border-radius: 6px;

  .layout-header {
    -webkit-app-region: drag;
    border-top-right-radius: 6px;
    border-top-left-radius: 6px;
    width: 100%;
    height: 35px;
    background-color: @bg-color;
    padding: 0;

    .ant-col {
      line-height: 35px;
    }

    .anticon {
      font-size: 20px;
      color: @win-title-toolbar-color;
    }

    h1 {
      background-color: @bg-color;
      color: @win-title-color;
      height: 35px;
      line-height: 35px;
      font-size: 20px;
      margin: 0;
    }
  }

  .layout-content {
    //background-color: #fff;
    padding: 0;
  }
}</style>
