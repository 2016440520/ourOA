CREATE TABLE `user` ( 
  `user_id` int(15) NOT NULL COMMENT '主键',
  `username` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `password` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `sex` enum('F','M') COLLATE utf8_bin NOT NULL COMMENT '性别',
  `age` int(2) NOT NULL COMMENT '年龄',
  `born` varchar(30) NOT NULL COMMENT '出生年月',
  `department_id` int(15) NOT NULL COMMENT '部门ID',
  `introduction` varchar(100) COLLATE utf8_bin COMMENT '个人介绍',
  `telephone` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '电话号码',
  `email` varchar(40) COLLATE utf8_bin NOT NULL COMMENT '邮箱',
  `address` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '住址'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';


ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id` );
  
CREATE TABLE IF NOT EXISTS `role` (
  `role_id` int(15) NOT NULL COMMENT '主键',
  `role_name` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '角色名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色表';

ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` int(15) NOT NULL COMMENT '主键',
  `role_id` int(15) NOT NULL COMMENT '主键',
  `role_name` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '角色名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户角色表';

ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id` ,`role_id`);
  
CREATE TABLE IF NOT EXISTS `permission` (
  `permission_id` int(15) NOT NULL COMMENT '主键',
  `permission_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '权限名称',
  `resource_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '资源名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='权限表';

ALTER TABLE `permission`
  ADD PRIMARY KEY (`permission_id`);

CREATE TABLE IF NOT EXISTS `role_permission` (
  `role_id` int(15) NOT NULL COMMENT '角色ID',
  `permission_id` int(15) NOT NULL COMMENT '权限ID',
  `permission_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '权限名称',
  `resource_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '资源名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色权限表';

ALTER TABLE `role_permission` 
  ADD PRIMARY KEY (`role_id` ,`permission_id` );


CREATE TABLE `message` (
  `message_id` int(15) NOT NULL COMMENT '主键',
  `address_id` int(15) NOT NULL COMMENT '发件人ID',
  `address_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '发送用户姓名',
  `title` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '标题',
  `content` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '内容',
  `date` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '发送日期',
  `isSend` bool NOT NULL COMMENT '是否已读',
  `isRead` bool NOT NULL COMMENT '是否发送',
  `receiver_id` int(15) COLLATE utf8_bin NOT NULL COMMENT '接收人ID',
  `receiver_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '接收人姓名',
  `addressDelete` bool NOT NULL COMMENT '发送人删除',
  `receiverDelete` bool NOT NULL COMMENT '接收人删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='消息表';


ALTER TABLE `message`
  ADD PRIMARY KEY (`message_id`);



CREATE TABLE `document` (
  `document_id` int(15) NOT NULL COMMENT '主键',
  `document_name` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '文件名',
  `url` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '文件地址'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='文件表';

ALTER TABLE `document`
  ADD PRIMARY KEY (`document_id`);


CREATE TABLE `book` (
	`book_id` INT(15) NOT NULL COMMENT '主键',
	`room_id` INT(15) NOT NULL COMMENT '被预约会议室ID',
	`user_id` INT(15) NOT NULL COMMENT '预约人ID',
	`bookstate` VARCHAR(20) NOT NULL COMMENT '预约状态' COLLATE 'utf8_bin',
	`srarttime` VARCHAR(20) NOT NULL COMMENT '开始时间' COLLATE 'utf8_bin',
	`endetime` VARCHAR(20) NOT NULL COMMENT '结束时间' COLLATE 'utf8_bin'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='预定表';

ALTER TABLE `book` 
  ADD PRIMARY KEY (`book_id`);

CREATE TABLE `meeting` (
	`meeting_id` INT(15) NOT NULL COMMENT '主键',
	`user_id` INT(15) NOT NULL COMMENT '发起人ID',
	`room_id` INT(15) NOT NULL COMMENT '会议室ID',
	`theme` VARCHAR(20) NOT NULL COMMENT '会议主题' COLLATE 'utf8_bin',
	`srarttime` VARCHAR(20) NOT NULL COMMENT '会议开始时间' COLLATE 'utf8_bin',
	`record` VARCHAR(200) NOT NULL COMMENT '会议记录' COLLATE 'utf8_bin',
	`endetime` VARCHAR(20) NOT NULL COMMENT '会议结束时间' COLLATE 'utf8_bin'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='会议表';

ALTER TABLE `meeting` 
  ADD PRIMARY KEY (`meeting_id`);

CREATE TABLE `querymeeting` (
	`id` INT(15) NOT NULL COMMENT '主键',
	`meeting_id` INT(15) NOT NULL COMMENT '会议ID',
	`user_id` INT(15) NOT NULL COMMENT '参与人ID'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='会议查询表';

ALTER TABLE `querymeeting` 
  ADD PRIMARY KEY (`id`);

CREATE TABLE `meetingroom` (
	`meetingroom_id` INT(15) NOT NULL COMMENT '主键',
	`account` INT(15) NOT NULL COMMENT '可容纳人数',
	`location` VARCHAR(50) NOT NULL COMMENT '地点' COLLATE 'utf8_bin',
	`use_account` VARCHAR(20) NOT NULL COMMENT '使用次数' COLLATE 'utf8_bin',
	`device_condition` VARCHAR(50) NOT NULL COMMENT '设备情况' COLLATE 'utf8_bin',
	`isFree` TINYINT(1) NOT NULL COMMENT '是否空闲',
	`isBook` TINYINT(1) NOT NULL COMMENT '是否预约'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='会议室表';

ALTER TABLE `meetingroom` 
  ADD PRIMARY KEY (`meetingroom_id`);