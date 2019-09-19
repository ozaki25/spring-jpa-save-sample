delete from tel_data;
delete from tel_group;

insert into tel_data (id, user_name, tel_no, mail_addr, group_id) values (1, 'テスト1', '0123-456-789', 'test@test.com', 1), (2, 'テスト2', '0123-456-789', 'test@test.com', 1), (3, 'テスト3', '0123-456-789', 'test@test.com', 2);
insert into tel_group (group_id, group_name) values (1, 'グループ1'), (2, 'グループ2');
