class MissionInfo {
    // 任务名称
    name: string = "";
    // 任务标识
    id: string = '';
    // 任务已完结标志
    finished: boolean = false;
    // 任务番茄数
    tomatoes: number = 1;
    // 已完成番茄数
    finishedTomatoes: number = 0;
    // 任务激活标志
    activated: boolean = false;
}

export default MissionInfo;