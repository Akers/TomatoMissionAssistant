<template>
    <div id="mission-list-wrapper">
        <div v-if="isMissionListEmpty" class="mission-empty">
            <p class="remind">还没有任务哦，赶快添加一个吧~</p>
            <div class="btn add-mission"><plus-circle-outlined @click="editMissionInfo('')" /></div>
        </div>
        <ul class="mission-list" v-else>
            <li class="mission-item" v-for="mission in missionList" v-bind:key="mission.id">
                <a-row>
                    <a-col :span="2" class="mission-status-icon">
                        <check-circle-outlined v-if="mission.finished == true" />
                        <clock-circle-outlined v-else/>
                    </a-col>
                    <a-col :span="22" class="mission-name">{{ mission.name }}</a-col>
                </a-row>
                <a-row>
                    <a-col :span="11"></a-col>
                    <a-col :span="11"></a-col>
                    <a-col  :span="2">{{ mission.finishedTomatoes }}/{{ mission.tomatoes }}</a-col>
                </a-row>
            </li>
        </ul>
        <a-modal v-model:visible="editMissionVisible" title="Basic Modal">
            <template #footer>
                <a-button key="back" @click="editMissionCancel">取消</a-button>
                <a-button key="submit" type="primary" :loading="modalLoading" @click="editMissionSubmit">保存</a-button>
            </template>
            <a-form :model="editingMissionInfo" name="basic" :label-col="{ span: 4 }" :wrapper-col="{ span: 20 }"
                autocomplete="off" @finish="onFinish" @finishFailed="onFinishFailed">
                <a-form-item label="名称" name="name" :rules="[{ required: true, message: '请输入任务名称' }]">
                    <a-input v-model:value="editingMissionInfo.name" />
                </a-form-item>
                <a-form-item label="分配番茄" name="tomatoes" :rules="[{ required: true, message: '请选择任务所需番茄轮数' }]">
                    <a-row>
                        <a-col :span="12">
                            <a-slider v-model:value="editingMissionInfo.tomatoes" :min="1" :max="48" />
                        </a-col>
                        <a-col :span="4">
                            <a-input-number v-model:value="editingMissionInfo.tomatoes" :min="1" :max="48"
                                style="margin-left: 16px" />
                        </a-col>
                    </a-row>
                </a-form-item>
            </a-form>
        </a-modal>
    </div>
</template>

<script setup lang="ts">
import { reactive, computed, ref } from 'vue'
import MissionInfo from './MissionInfo';
import { PlusCircleOutlined, CheckCircleOutlined, ClockCircleOutlined } from '@ant-design/icons-vue';

const missionList = reactive<MissionInfo[]>([]);
const editingMissionInfo = ref<MissionInfo>(new MissionInfo);
const editMissionVisible = ref(false);
const modalLoading = ref(false);

const isMissionListEmpty = computed(() => {
    return missionList.length <= 0;
});

function editMissionInfo(id: string) {

    if (id != null && id != '') {
        // 修改
    } else {
        editingMissionInfo.value = new MissionInfo();
    }

    editMissionVisible.value = true;
}

/**
 * 取消任务编辑
 */
function editMissionCancel() {

}

/**
 * 保存任务编辑
 */
function editMissionSubmit() {
    modalLoading.value = true;
    saveMission(editingMissionInfo.value).then((savedMissionInfo) => {
        console.info("savedMissionInfo: %o", savedMissionInfo);
        // 保存接口调用
        if (editingMissionInfo.value.id != null && editingMissionInfo.value.id != '') {
            // 更新列表数据
            missionList.forEach(element => {
                if (element.id == savedMissionInfo.id) {
                    Object.assign(element, savedMissionInfo);
                }
            });
            
        } else {
            missionList.push(savedMissionInfo);
        }
        modalLoading.value = false;
        editMissionVisible.value = false;
    }).catch(() => {
        // 异常处理
    });
}

/**
 * 保存任务
 */
function saveMission(missionInfo : MissionInfo):Promise<MissionInfo> {
    return new Promise((resolve, reject) => {
        resolve(missionInfo);
    });
}

const onFinish = (values: any) => {
    console.log('Success:', values);
};

const onFinishFailed = (errorInfo: any) => {
    console.log('Failed:', errorInfo);
};
</script>

<style lang="less" scoped>
#mission-list-wrapper {
    .mission-list {
        list-style-type: none;
        padding-left: 25px;
        margin: 20px 0;
        .mission-item {
            text-align: left;
            width: 350px;
        }
    }
    .mission-empty {
        margin-top: 150px;

        .remind {
            color: @sub-text-color;
            font-size: 20px;
            margin-bottom: 15px;
        }

        .add-mission {
            color: @sub-text-color;
            font-size: 30px;
        }
    }
}
</style>