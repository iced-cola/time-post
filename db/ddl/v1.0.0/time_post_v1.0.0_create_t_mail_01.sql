# 创建用户表
DROP TABLE IF EXISTS `time_post`.`t_user`;
CREATE TABLE `time_post`.`t_user`
(
    `id`           VARCHAR(32) NOT NULL COMMENT '主键id',
    `user_id`      VARCHAR(20) NOT null COMMENT '用户id',
    `role`         VARCHAR(15) NOT NULL COMMENT '用户角色',
    `username`     VARCHAR(30) NOT NULL COMMENT '用户昵称',
    `password`     VARCHAR(30) NOT NULL COMMENT '登录密码',
    `mail_address` VARCHAR(50) COMMENT '邮箱地址',
    `signature`    VARCHAR(255) COMMENT '个性签名',
    `last_login`   DATE COMMENT '最后登录日期',
    `create_time`  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_by`    VARCHAR(30) NOT NULL COMMENT '创建者',
    `update_time`  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `update_by`    VARCHAR(30) NOT NULL COMMENT '更新者',
    PRIMARY KEY `pk_id` (`id`),
    UNIQUE KEY `uk_user_id` (`user_id`),
    INDEX `ix_user_id` (`user_id`),
    INDEx `ix_username` (`username`)
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8 COMMENT '用户信息表';

# 创建
DROP TABLE IF EXISTS `t_mail`;
CREATE TABLE `time_post`.`t_mail`
(
    `id`          VARCHAR(32) NOT NULL COMMENT '主键id',
    `user_id`     VARCHAR(20) NOT NULL COMMENT '创建人',
    `receiver`    VARCHAR(50) NOT NULL COMMENT '收件邮箱',
    `subject`     VARCHAR(255) COMMENT '邮件标题',
    `content`     VARCHAR(2000) COMMENT '邮件内容',
    `send_date`   DATETIME COMMENT '预定发送时间',
    `is_public`   VARCHAR(1)  NOT NULL COMMENT '是否公开',
    `create_time` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_by`   VARCHAR(30) NOT NULL COMMENT '创建者',
    `update_time` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `update_by`   VARCHAR(30) NOT NULL COMMENT '更新者',
    PRIMARY KEY `pk_id` (`id`),
    INDEX `ix_user_id` (`user_id`),
    INDEX `ix_send_date` (`send_date`)
) ENGINE = InnoDB
  DEFAULT CHARSET UTF8 COMMENT '邮件信息表';


# 发送结果记录表
DROP TABLE IF EXISTS `time_post`.`send_log`;
CREATE TABLE `time_post`.`send_log`
(
    `id`          VARCHAR(32) NOT NULL COMMENT '主键id',
    `mail_id`     VARCHAR(32) NOT NULL COMMENT '关联t_mail表id',
    `send_result` VARCHAR(30) COMMENT '发送结果',
    `create_time` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_by`   VARCHAR(30) NOT NULL COMMENT '创建者',
    `update_time` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `update_by`   VARCHAR(30) NOT NULL COMMENT '更新者',
    PRIMARY KEY `pk_id` (`id`),
    INDEX `ix_mail_id` (`mail_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET UTF8 COMMENT '邮件发送结果记录表';

