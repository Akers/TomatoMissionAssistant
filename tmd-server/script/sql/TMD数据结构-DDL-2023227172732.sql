DROP TABLE IF EXISTS tmd_mission;
CREATE TABLE tmd_mission(
    `id` VARCHAR2(32) NOT NULL   COMMENT '主键' ,
    `version` VARCHAR2(32)    COMMENT '乐观锁' ,
    `create_by` VARCHAR2(32)    COMMENT '创建人' ,
    `create_time` DATE    COMMENT '创建时间' ,
    `update_by` VARCHAR2(32)    COMMENT '更新人' ,
    `update_time` DATE    COMMENT '更新时间' ,
    `team_id` VARCHAR2(255)    COMMENT '团队id' ,
    `mission_duration` INT    COMMENT '任务预估工期（小时）' ,
    `mission_name` VARCHAR2(255)    COMMENT '任务名称' ,
    `mission_type` VARCHAR2(255)    COMMENT '任务类型' ,
    `mission_status` VARCHAR2(255)    COMMENT '任务状态' ,
    `mission_desc` VARCHAR2(900)    COMMENT '任务描述' ,
    `parent_id` VARCHAR2(32)    COMMENT '父级任务id' ,
    `mission_id` VARCHAR2(32) NOT NULL   COMMENT '任务ID;创建任务时生成，修改任务时不变' ,
    PRIMARY KEY (id)
)  COMMENT = '任务表';

DROP TABLE IF EXISTS tmd_team;
CREATE TABLE tmd_team(
    `id` VARCHAR2(32)    COMMENT '主键' ,
    `version` VARCHAR2(32)    COMMENT '乐观锁' ,
    `create_by` VARCHAR2(32)    COMMENT '创建人' ,
    `create_time` DATE    COMMENT '创建时间' ,
    `update_by` VARCHAR2(32)    COMMENT '更新人' ,
    `update_time` DATE    COMMENT '更新时间' ,
    `team_name` VARCHAR2(255)    COMMENT '团队名称' ,
    `dept_id` VARCHAR2(255)    COMMENT '机构id' ,
    `team_desc` VARCHAR2(255)    COMMENT '团队介绍' 
)  COMMENT = '团队表';

DROP TABLE IF EXISTS tmd_mission_his;
CREATE TABLE tmd_mission_his(
    `id` VARCHAR2(32) NOT NULL   COMMENT '主键' ,
    `version` VARCHAR2(32)    COMMENT '乐观锁' ,
    `create_by` VARCHAR2(32)    COMMENT '创建人' ,
    `create_time` DATE    COMMENT '创建时间' ,
    `update_by` VARCHAR2(32)    COMMENT '更新人' ,
    `update_time` DATE    COMMENT '更新时间' ,
    `team_id` VARCHAR2(255)    COMMENT '团队id' ,
    `mission_duration` INT    COMMENT '任务预估工期（小时）' ,
    `mission_name` VARCHAR2(255)    COMMENT '任务名称' ,
    `mission_type` VARCHAR2(255)    COMMENT '任务类型' ,
    `mission_status` VARCHAR2(255)    COMMENT '任务状态' ,
    `mission_desc` VARCHAR2(900)    COMMENT '任务描述' ,
    `parent_id` VARCHAR2(32)    COMMENT '父级任务id' ,
    `mission_id` VARCHAR2(32) NOT NULL   COMMENT '任务ID;创建任务时生成，修改任务时不变' ,
    PRIMARY KEY (id)
)  COMMENT = '任务表历史表';

DROP TABLE IF EXISTS tmd_mission_assigned;
CREATE TABLE tmd_mission_assigned(
    `id` VARCHAR2(32) NOT NULL   COMMENT '主键' ,
    `version` VARCHAR2(32)    COMMENT '乐观锁' ,
    `create_by` VARCHAR2(32)    COMMENT '创建人' ,
    `create_time` DATE    COMMENT '创建时间' ,
    `update_by` VARCHAR2(32)    COMMENT '更新人' ,
    `update_time` DATE    COMMENT '更新时间' ,
    `user_id` VARCHAR2(32)    COMMENT '用户ID' ,
    `mission_id` VARCHAR2(32)    COMMENT '任务ID;tmd_mission表的mission_id' ,
    `assign_time` VARCHAR2(32)    COMMENT '指派时间;指派任务时间' ,
    PRIMARY KEY (id)
)  COMMENT = '任务指派表';

DROP TABLE IF EXISTS tmd_tomato;
CREATE TABLE tmd_tomato(
    `id` VARCHAR2(32)    COMMENT '主键' ,
    `version` VARCHAR2(32)    COMMENT '乐观锁' ,
    `create_by` VARCHAR2(32)    COMMENT '创建人' ,
    `create_time` DATE    COMMENT '创建时间' ,
    `update_by` VARCHAR2(32)    COMMENT '更新人' ,
    `update_time` DATE    COMMENT '更新时间' ,
    `group_id` VARCHAR2(32)    COMMENT '番茄组ID' ,
    `user_id` VARCHAR2(32)    COMMENT '用户ID' ,
    `focus_time` INT    COMMENT '实际消耗专注时长;专注工作时间' ,
    `sort` INT    COMMENT '在番茄组中的排序' ,
    `break_time` INT    COMMENT '实际休息时长' ,
    `mission_id` VARCHAR2(255)    COMMENT '任务ID' ,
    `break_type` VARCHAR2(1)    COMMENT '休息类型;1--短休息；2--长休息' ,
    `tomato_config_id` VARCHAR2(32)    COMMENT '番茄配置ID' ,
    `focus_time_cofniged` INT    COMMENT '配置的专注工作时间' ,
    `break_time_configed` INT    COMMENT '配置的休息时长' ,
    `is_last` VARCHAR2(1)    COMMENT '是否组组里的最后一轮' 
)  COMMENT = '番茄计时表';

DROP TABLE IF EXISTS tmd_tomato_group;
CREATE TABLE tmd_tomato_group(
    `id` VARCHAR2(32)    COMMENT '主键' ,
    `version` VARCHAR2(32)    COMMENT '乐观锁' ,
    `create_by` VARCHAR2(32)    COMMENT '创建人' ,
    `create_time` DATE    COMMENT '创建时间' ,
    `update_by` VARCHAR2(32)    COMMENT '更新人' ,
    `update_time` DATE    COMMENT '更新时间' ,
    `break_time` INT    COMMENT '长休息时间' ,
    `tomatoes` INT    COMMENT '番茄数量' ,
    `user_id` VARCHAR2(32)    COMMENT '用户ID' ,
    `mission_id` VARCHAR2(32)    COMMENT '任务ID' 
)  COMMENT = '番茄组表';

DROP TABLE IF EXISTS tmd_interrupt;
CREATE TABLE tmd_interrupt(
    `id` VARCHAR2(32)    COMMENT '主键' ,
    `version` VARCHAR2(32)    COMMENT '乐观锁' ,
    `create_by` VARCHAR2(32)    COMMENT '创建人' ,
    `create_time` DATE    COMMENT '创建时间' ,
    `update_by` VARCHAR2(32)    COMMENT '更新人' ,
    `update_time` DATE    COMMENT '更新时间' ,
    `user_id` VARCHAR2(32)    COMMENT '用户ID' ,
    `tomato_id` VARCHAR2(32)    COMMENT '中断关联的番茄id' ,
    `start_time` DATE    COMMENT '中断开始时间' ,
    `end_time` DATE    COMMENT '中断结束时间' ,
    `interrupted_time` INT    COMMENT '中断时长' ,
    `interrupt_type` VARCHAR2(1)    COMMENT '中断类型;1--专注工作中断；2--短休息中断；3--长休息中断' 
)  COMMENT = '中断表';

DROP TABLE IF EXISTS tmd_totamo_config;
CREATE TABLE tmd_totamo_config(
    `id` VARCHAR2(32) NOT NULL   COMMENT '主键' ,
    `version` VARCHAR2(32)    COMMENT '乐观锁' ,
    `create_by` VARCHAR2(32)    COMMENT '创建人' ,
    `create_time` DATE    COMMENT '创建时间' ,
    `update_by` VARCHAR2(32)    COMMENT '更新人' ,
    `update_time` DATE    COMMENT '更新时间' ,
    `config_id` VARCHAR2(32)    COMMENT '配置id' ,
    `timer_focus` INT    COMMENT '专注时间定时' ,
    `timer_short_break` INT    COMMENT '短休息时间定时' ,
    `timer_long_break` INT    COMMENT '长休息时间定时' ,
    `timer_rounds` INT    COMMENT '每组包含番茄数' ,
    `user_id` VARCHAR2(32)    COMMENT '用户id' ,
    PRIMARY KEY (id)
)  COMMENT = '番茄配置表';

