SET FOREIGN_KEY_CHECKS=0;

INSERT INTO `perm_group` (`id`, `name`, `identifier`) VALUES
('942975580924825601', '工单管理', 'ticket.management');

INSERT INTO `perm` (`id`, `groupid`, `name`, `identifier`) VALUES
('942975621899022338', '942975580924825601', '查看工单列表', 'tickets.view'),
('942975621899022339', '942975580924825601', '查看工单', 'ticket.view'),
('942975621899022340', '942975580924825601', '添加工单', 'ticket.save'),
('942975621899022341', '942975580924825601', '修改工单', 'ticket.update'),
('942975621899022342', '942975580924825601', '删除工单', 'ticket.delete'),
('942975621899022343', '942975580924825601', '关联删除工单', 'ticket.items.delete');

-- INSERT INTO `perm_group` (`id`, `name`, `identifier`) VALUES
-- ('928494720543571981', 'TicketAcceptanceItem模块', 'TicketAcceptanceItem.management');
--
-- INSERT INTO `perm` (`id`, `groupid`, `name`, `identifier`) VALUES
-- ('928494720543571978', '928494720543571981', '查看TicketAcceptanceItem', 'TicketAcceptanceItem.view'),
-- ('928494720543571979', '928494720543571981', '更新TicketAcceptanceItem', 'TicketAcceptanceItem.update'),
-- ('928494720543571980', '928494720543571981', '删除TicketAcceptanceItem', 'TicketAcceptanceItem.delete');
-- INSERT INTO `perm_group` (`id`, `name`, `identifier`) VALUES
-- ('928494720543571977', 'TicketAcceptance模块', 'TicketAcceptance.management');
--
-- INSERT INTO `perm` (`id`, `groupid`, `name`, `identifier`) VALUES
-- ('928494720543571974', '928494720543571977', '查看TicketAcceptance', 'TicketAcceptance.view'),
-- ('928494720543571975', '928494720543571977', '更新TicketAcceptance', 'TicketAcceptance.update'),
-- ('928494720543571976', '928494720543571977', '删除TicketAcceptance', 'TicketAcceptance.delete');
-- INSERT INTO `perm_group` (`id`, `name`, `identifier`) VALUES
-- ('928494720556154884', 'TicketExecutionItem模块', 'TicketExecutionItem.management');
--
-- INSERT INTO `perm` (`id`, `groupid`, `name`, `identifier`) VALUES
-- ('928494720556154881', '928494720556154884', '查看TicketExecutionItem', 'TicketExecutionItem.view'),
-- ('928494720556154882', '928494720556154884', '更新TicketExecutionItem', 'TicketExecutionItem.update'),
-- ('928494720556154883', '928494720556154884', '删除TicketExecutionItem', 'TicketExecutionItem.delete');
-- INSERT INTO `perm_group` (`id`, `name`, `identifier`) VALUES
-- ('928494720543571985', 'TicketExecution模块', 'TicketExecution.management');
--
-- INSERT INTO `perm` (`id`, `groupid`, `name`, `identifier`) VALUES
-- ('928494720543571982', '928494720543571985', '查看TicketExecution', 'TicketExecution.view'),
-- ('928494720543571983', '928494720543571985', '更新TicketExecution', 'TicketExecution.update'),
-- ('928494720543571984', '928494720543571985', '删除TicketExecution', 'TicketExecution.delete');
-- INSERT INTO `perm_group` (`id`, `name`, `identifier`) VALUES
-- ('928494720556154888', 'TicketItem模块', 'TicketItem.management');
--
-- INSERT INTO `perm` (`id`, `groupid`, `name`, `identifier`) VALUES
-- ('928494720556154885', '928494720556154888', '查看TicketItem', 'TicketItem.view'),
-- ('928494720556154886', '928494720556154888', '更新TicketItem', 'TicketItem.update'),
-- ('928494720556154887', '928494720556154888', '删除TicketItem', 'TicketItem.delete');
-- INSERT INTO `perm_group` (`id`, `name`, `identifier`) VALUES
-- ('928494720556154896', 'TicketOrderItem模块', 'TicketOrderItem.management');
--
-- INSERT INTO `perm` (`id`, `groupid`, `name`, `identifier`) VALUES
-- ('928494720556154893', '928494720556154896', '查看TicketOrderItem', 'TicketOrderItem.view'),
-- ('928494720556154894', '928494720556154896', '更新TicketOrderItem', 'TicketOrderItem.update'),
-- ('928494720556154895', '928494720556154896', '删除TicketOrderItem', 'TicketOrderItem.delete');
-- INSERT INTO `perm_group` (`id`, `name`, `identifier`) VALUES
-- ('928494720556154892', 'TicketOrder模块', 'TicketOrder.management');
--
-- INSERT INTO `perm` (`id`, `groupid`, `name`, `identifier`) VALUES
-- ('928494720556154889', '928494720556154892', '查看TicketOrder', 'TicketOrder.view'),
-- ('928494720556154890', '928494720556154892', '更新TicketOrder', 'TicketOrder.update'),
-- ('928494720556154891', '928494720556154892', '删除TicketOrder', 'TicketOrder.delete');
-- INSERT INTO `perm_group` (`id`, `name`, `identifier`) VALUES
-- ('928494720543571973', 'Ticket模块', 'Ticket.management');
--
-- INSERT INTO `perm` (`id`, `groupid`, `name`, `identifier`) VALUES
-- ('928494720543571970', '928494720543571973', '查看Ticket', 'Ticket.view'),
-- ('928494720543571971', '928494720543571973', '更新Ticket', 'Ticket.update'),
-- ('928494720543571972', '928494720543571973', '删除Ticket', 'Ticket.delete');
-- INSERT INTO `perm_group` (`id`, `name`, `identifier`) VALUES
-- ('928494720556154904', 'TicketPlanItem模块', 'TicketPlanItem.management');
--
-- INSERT INTO `perm` (`id`, `groupid`, `name`, `identifier`) VALUES
-- ('928494720556154901', '928494720556154904', '查看TicketPlanItem', 'TicketPlanItem.view'),
-- ('928494720556154902', '928494720556154904', '更新TicketPlanItem', 'TicketPlanItem.update'),
-- ('928494720556154903', '928494720556154904', '删除TicketPlanItem', 'TicketPlanItem.delete');
-- INSERT INTO `perm_group` (`id`, `name`, `identifier`) VALUES
-- ('928494720556154900', 'TicketPlan模块', 'TicketPlan.management');
--
-- INSERT INTO `perm` (`id`, `groupid`, `name`, `identifier`) VALUES
-- ('928494720556154897', '928494720556154900', '查看TicketPlan', 'TicketPlan.view'),
-- ('928494720556154898', '928494720556154900', '更新TicketPlan', 'TicketPlan.update'),
-- ('928494720556154899', '928494720556154900', '删除TicketPlan', 'TicketPlan.delete');
-- INSERT INTO `perm_group` (`id`, `name`, `identifier`) VALUES
-- ('928494720556154908', 'TicketStrategy模块', 'TicketStrategy.management');
--
-- INSERT INTO `perm` (`id`, `groupid`, `name`, `identifier`) VALUES
-- ('928494720556154905', '928494720556154908', '查看TicketStrategy', 'TicketStrategy.view'),
-- ('928494720556154906', '928494720556154908', '更新TicketStrategy', 'TicketStrategy.update'),
-- ('928494720556154907', '928494720556154908', '删除TicketStrategy', 'TicketStrategy.delete');
-- INSERT INTO `perm_group` (`id`, `name`, `identifier`) VALUES
-- ('928494720556154912', 'TicketType模块', 'TicketType.management');
--
-- INSERT INTO `perm` (`id`, `groupid`, `name`, `identifier`) VALUES
-- ('928494720556154909', '928494720556154912', '查看TicketType', 'TicketType.view'),
-- ('928494720556154910', '928494720556154912', '更新TicketType', 'TicketType.update'),
-- ('928494720556154911', '928494720556154912', '删除TicketType', 'TicketType.delete');
--
--INSERT INTO `perm_group` (`id`, `name`, `identifier`) VALUES
--('969060507955982341', 'TicketExecutionReplaceItem模块', 'TicketExecutionReplaceItem.management');
--
--INSERT INTO `perm` (`id`, `groupid`, `name`, `identifier`) VALUES
--('969060507955982338', '969060507955982341', '查看TicketExecutionReplaceItem', 'TicketExecutionReplaceItem.view'),
--('969060507955982339', '969060507955982341', '更新TicketExecutionReplaceItem', 'TicketExecutionReplaceItem.update'),
--('969060507955982340', '969060507955982341', '删除TicketExecutionReplaceItem', 'TicketExecutionReplaceItem.delete');