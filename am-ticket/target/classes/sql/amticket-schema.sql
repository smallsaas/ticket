SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `tk_ticket_strategy`;
-- `tk_ticket_strategy工单策略表`
CREATE TABLE `tk_ticket_strategy` (
 `id` BIGINT(20) NOT NULL,
 `name` varchar(26) DEFAULT NULL COMMENT '策略名称',
 `execute_department_id` BIGINT COMMENT '执行部门ID',
 `execute_department_name` VARCHAR(50) COMMENT '执行部门',
 `type_id` bigint(20) DEFAULT NULL COMMENT '工单类型',
 `type_name` varchar(26) DEFAULT NULL COMMENT '类型名称',
 `practices` VARCHAR(50)  COMMENT '作业方式',
 `is_cyclicity` smallint(5)  not null default '0' COMMENT '是否为周期性，默认1为周期性，0为非周期性',
 `practices_step` text DEFAULT NULL COMMENT '检修方式及步骤',
 `content` text DEFAULT NULL COMMENT '备注',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tk_ticket_plan`;
-- `tk_ticket_plan工单计划表`
CREATE TABLE `tk_ticket_plan` (
 `id` BIGINT(20) NOT NULL,
 `applicant_id` BIGINT(20) COMMENT '申请人ID',
 `applicant` VARCHAR(50) COMMENT '申请人',
 `number` VARCHAR(50)  COMMENT '单号',
 `apply_time` DATETIME DEFAULT NULL COMMENT '申请时间',
 `status` VARCHAR(20) NOT NULL COMMENT '单据状态',
 `executor_id` BIGINT(20) COMMENT '执行人ID',
 `executor` VARCHAR(50) COMMENT '执行人',
 `plan_start_time` DATETIME DEFAULT NULL COMMENT '计划开始时间',
 `plan_end_time` DATETIME DEFAULT NULL COMMENT '计划结束时间',
 `process_instance_id` BIGINT(20) COMMENT '流程实例ID',
 `strategy_id` BIGINT(20) DEFAULT NULL COMMENT '策略ID',
 `strategy_name` varchar(26) DEFAULT NULL COMMENT '策略名称',
 `lifecycle` VARCHAR(50) DEFAULT NULL COMMENT '执行周期',
 `name` varchar(50) DEFAULT NULL COMMENT '工单计划名称',
 `plan_department_id` BIGINT(20) DEFAULT NULL COMMENT '计划部门ID',
 `plan_department_name` VARCHAR(50) DEFAULT NULL COMMENT ')计划部门名称',
 `execute_department_id` BIGINT COMMENT '执行部门ID',
 `execute_department_name` VARCHAR(50) COMMENT '执行部门',
 `fault_ticket_id` BIGINT(20) DEFAULT NULL COMMENT '故障单ID',
 `fault_ticket_number` VARCHAR(50)  COMMENT '故障单编号',
 `fault_name` varchar(20) DEFAULT NULL COMMENT '故障名称',
 `type_id` bigint(20) DEFAULT NULL COMMENT '工单类型',
 `type_name` varchar(26) DEFAULT NULL COMMENT '类型名称',
 `practices` text  COMMENT '检修内容',
 `practices_step` text DEFAULT NULL COMMENT '检修方式及步骤',
 `content` text DEFAULT NULL COMMENT '备注',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tk_ticket_plan_item`;
-- `tk_ticket_plan_item计划工单项`
CREATE TABLE `tk_ticket_plan_item` (
 `id` BIGINT(20) NOT NULL,
 `ticket_id` BIGINT(20) NOT NULL,
 `equipment_id` BIGINT(20) NOT NULL,
 `equipment_number` VARCHAR(50) COMMENT '模版编码',
 `equipment_code` VARCHAR(50) COMMENT '设备编码',
 `equipment_name` VARCHAR(50) COMMENT '设备名称',
 `equipment_unit` VARCHAR(20) COMMENT '计量单位',
 `equipment_spec` VARCHAR(20) COMMENT '规格型号',
 `warehouse_id` BIGINT(20) COMMENT '仓库ID',
 `warehouse_name` VARCHAR(50) COMMENT '仓库',
 `wh_warehouse_area_id` BIGINT(20) COMMENT '库区ID',
 `wh_warehouse_area_name` VARCHAR(50) COMMENT '库区',
 `wh_warehouse_slot_id` BIGINT(20) COMMENT '储位ID',
 `wh_warehouse_slot_name` VARCHAR(50) COMMENT '储位',
 PRIMARY KEY (`id`),
 FOREIGN KEY (`ticket_id`) REFERENCES `tk_ticket_plan` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tk_ticket_execution`;
-- `tk_ticket_execution执行工单`
CREATE TABLE `tk_ticket_execution` (
 `id` BIGINT(20) NOT NULL,
 `ticket_plan_used` int default 1 COMMENT '关联计划单/故障单',  /*二选一： 0 关联故障单 1 关联计划单*/
 `applicant_id` BIGINT(20) COMMENT '申请人ID',
 `applicant` VARCHAR(50) COMMENT '申请人',
 `number` VARCHAR(50)  COMMENT '单号',
 `apply_time` DATETIME DEFAULT NULL COMMENT '申请时间',
 `status` VARCHAR(20) NOT NULL COMMENT '单据状态',
 `executor_id` BIGINT(20) COMMENT '执行人ID',
 `executor` VARCHAR(50) COMMENT '执行人',
 `execute_time` DATETIME DEFAULT NULL COMMENT '执行时间',
 `process_instance_id` BIGINT(20) COMMENT '流程实例ID',
 `plan_id` BIGINT(20) DEFAULT NULL COMMENT '计划单ID',
 `plan_name` varchar(26) DEFAULT NULL COMMENT '计划单名称',
 `plan_number` VARCHAR(50) COMMENT '计划单号',
 `strategy_id` BIGINT(20) DEFAULT NULL COMMENT '策略ID',
 `strategy_name` varchar(26) DEFAULT NULL COMMENT '策略名称',
 `lifecycle` VARCHAR(50) DEFAULT NULL COMMENT '执行周期',
 `name` varchar(50) DEFAULT NULL COMMENT '工单名称',
 `plan_department_id` BIGINT(20) DEFAULT NULL COMMENT '计划部门ID',
 `plan_department_name` VARCHAR(50) DEFAULT NULL COMMENT '计划部门名称',
 `execute_department_id` BIGINT COMMENT '执行部门ID',
 `execute_department_name` VARCHAR(50) COMMENT '执行部门',
 `fault_ticket_id` BIGINT(20) DEFAULT NULL COMMENT '故障单ID',
 `fault_ticket_number` VARCHAR(50)  COMMENT '故障单编号',
 `fault_name` varchar(20) DEFAULT NULL COMMENT '故障名称',
 `type_id` bigint(26) DEFAULT NULL COMMENT '工单类型',
 `type_name` varchar(26) DEFAULT NULL COMMENT '类型名称',
 `practices_step` text DEFAULT NULL COMMENT '检修方式及步骤',
 `content` text DEFAULT NULL COMMENT '备注',
  `result` text DEFAULT NULL COMMENT '执行结果',
 `procedure` text DEFAULT NULL COMMENT '检修过程',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tk_ticket_acceptance`;
CREATE TABLE `tk_ticket_acceptance` (
 `id` BIGINT(20) NOT NULL,
 `execution_id` BIGINT(20) NOT NULL COMMENT '执行工单id',
 `execution_name` VARCHAR(26) COMMENT '执行工单名称',
 `execution_number` VARCHAR(50) COMMENT '执行工单号',
 `applicant_id` BIGINT(20) COMMENT '申请人ID',
 `applicant` VARCHAR(50) COMMENT '申请人',
 `number` VARCHAR(50)  COMMENT '单号',
 `apply_time` DATETIME DEFAULT NULL COMMENT '申请时间',
 `status` VARCHAR(20) NOT NULL COMMENT '单据状态',
 `executor_id` BIGINT(20) COMMENT '执行人ID',
 `executor` VARCHAR(50) COMMENT '执行人',
 `execute_time` DATETIME DEFAULT NULL COMMENT '执行时间',
 `process_instance_id` BIGINT(20) COMMENT '流程实例ID',
 `strategy_id` BIGINT(20) DEFAULT NULL COMMENT '策略ID',
 `strategy_name` varchar(26) DEFAULT NULL COMMENT '策略名称',
 `lifecycle` VARCHAR(50) DEFAULT NULL COMMENT '执行周期',
 `name` varchar(50) DEFAULT NULL COMMENT '工单名称',
 `plan_department_id` BIGINT(20) DEFAULT NULL COMMENT '计划部门ID',
 `plan_department_name` VARCHAR(50) DEFAULT NULL COMMENT ')计划部门名称',
 `execute_department_id` BIGINT COMMENT '执行部门ID',
 `execute_department_name` VARCHAR(50) COMMENT '执行部门',
 `fault_ticket_id` BIGINT(20) DEFAULT NULL COMMENT '故障单ID',
 `fault_ticket_number` VARCHAR(50)  COMMENT '故障单编号',
 `fault_name` varchar(20) DEFAULT NULL COMMENT '故障名称',
 `type_id` bigint(26) DEFAULT NULL COMMENT '工单类型',
 `type_name` varchar(26) DEFAULT NULL COMMENT '类型名称',
 `practices` text  COMMENT '检修内容',
 `practices_step` text DEFAULT NULL COMMENT '检修方式及步骤',
 `content` text DEFAULT NULL COMMENT '备注',
 `inspector_id` BIGINT(20) DEFAULT NULL ,
 `inspector_name` varchar(26) DEFAULT NULL COMMENT ')验收人',
 `check_department_id` BIGINT(20) DEFAULT NULL ,
 `check_department_name` VARCHAR(50) DEFAULT NULL COMMENT '验收部门名称',
 `check_time` datetime DEFAULT NULL COMMENT '验收时间',
 `result` text DEFAULT NULL COMMENT '验收结果',
 `note` text DEFAULT NULL COMMENT '备注',
 PRIMARY KEY (`id`),
 FOREIGN KEY (`execution_id`) REFERENCES `tk_ticket_execution` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tk_ticket_execution_item`;
CREATE TABLE `tk_ticket_execution_item` (
  `id` bigint(20) NOT NULL,
  `ticket_id` bigint(20) NOT NULL,
  `equipment_id` bigint(20) NOT NULL,
  `equipment_number` varchar(50) DEFAULT NULL COMMENT '模版编码',
  `equipment_code` varchar(50) DEFAULT NULL COMMENT '设备编码',
  `equipment_name` varchar(50) DEFAULT NULL COMMENT '设备名称',
  `equipment_unit` varchar(20) DEFAULT NULL COMMENT '计量单位',
  `equipment_spec` varchar(20) DEFAULT NULL COMMENT '规格型号',
  `warehouse_id` bigint(20) DEFAULT NULL COMMENT '仓库ID',
  `warehouse_name` varchar(50) DEFAULT NULL COMMENT '仓库',
  `wh_warehouse_area_id` bigint(20) DEFAULT NULL COMMENT '库区ID',
  `wh_warehouse_area_name` varchar(50) DEFAULT NULL COMMENT '库区',
  `wh_warehouse_slot_id` bigint(20) DEFAULT NULL COMMENT '储位ID',
  `wh_warehouse_slot_name` varchar(50) DEFAULT NULL COMMENT '储位',
  `index_num` smallint DEFAULT 1 COMMENT '对接维修的备件',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`ticket_id`) REFERENCES `tk_ticket_execution` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tk_ticket_acceptance_item`;
CREATE TABLE `tk_ticket_acceptance_item` (
  `id` bigint(20) NOT NULL,
  `ticket_id` bigint(20) NOT NULL,
  `equipment_id` bigint(20) NOT NULL,
  `equipment_number` varchar(50) DEFAULT NULL COMMENT '模版编码',
  `equipment_code` varchar(50) DEFAULT NULL COMMENT '设备编码',
  `equipment_name` varchar(50) DEFAULT NULL COMMENT '设备名称',
  `equipment_unit` varchar(20) DEFAULT NULL COMMENT '计量单位',
  `equipment_spec` varchar(20) DEFAULT NULL COMMENT '规格型号',
  `warehouse_id` bigint(20) DEFAULT NULL COMMENT '仓库ID',
  `warehouse_name` varchar(50) DEFAULT NULL COMMENT '仓库',
  `wh_warehouse_area_id` bigint(20) DEFAULT NULL COMMENT '库区ID',
  `wh_warehouse_area_name` varchar(50) DEFAULT NULL COMMENT '库区',
  `wh_warehouse_slot_id` bigint(20) DEFAULT NULL COMMENT '储位ID',
  `wh_warehouse_slot_name` varchar(50) DEFAULT NULL COMMENT '储位',
  `index_num` smallint(5) not null DEFAULT 1 COMMENT '对接维修的备件',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`ticket_id`) REFERENCES `tk_ticket_acceptance` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tk_ticket_execution_replace_item`;
-- `tk_ticket_execution_replace_item执行工单替代项`
CREATE TABLE `tk_ticket_execution_replace_item` (
 `id` BIGINT(20) NOT NULL,
 `ticket_id` BIGINT(20) NOT NULL,
 `equipment_id` BIGINT(20) NOT NULL,
 `equipment_number` VARCHAR(50) COMMENT '模版编码',
 `equipment_code` VARCHAR(50) COMMENT '设备编码',
 `equipment_name` VARCHAR(50) COMMENT '设备名称',
 `equipment_unit` VARCHAR(20) COMMENT '计量单位',
 `equipment_spec` VARCHAR(20) COMMENT '规格型号',
 `warehouse_id` BIGINT(20) COMMENT '仓库ID',
 `warehouse_name` VARCHAR(50) COMMENT '仓库',
 `wh_warehouse_area_id` BIGINT(20) COMMENT '库区ID',
 `wh_warehouse_area_name` VARCHAR(50) COMMENT '库区',
 `wh_warehouse_slot_id` BIGINT(20) COMMENT '储位ID',
 `wh_warehouse_slot_name` VARCHAR(50) COMMENT '储位',
 PRIMARY KEY (`id`),
 FOREIGN KEY (`ticket_id`) REFERENCES `tk_ticket_plan` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

