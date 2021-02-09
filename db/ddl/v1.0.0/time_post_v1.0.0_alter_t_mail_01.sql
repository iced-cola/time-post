# 修改t_mail表的索引名称

alter table time_post.t_mail rename index ix_send_date to idx_send_date;

alter table time_post.t_mail rename index ix_user_id to idx_user_id;

# 重命名t_mail表的字段
alter table t_mail
    change send_date send_date date not null comment '预定发送日期';


alter table t_mail
    change is_public is_public char(1) default 'N' comment '是否公开';