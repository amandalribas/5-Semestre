create sequence seq_test
start with 1
increment by 1
cache 10
noorder;

select seq_test.nextval from dual;

-- Se iniciio com currval (valor atual local): ORA-08002: sequence SEQ_TEST.CURRVAL is not yet defined in this session
select seq_test.currval from dual;

create sequence seq_test_2
start with 1
increment by 1
cache 10
order;

create table tabela_sequencias(
    id_no_order integer default seq_test.nextval,
    id_order integer default seq_test_2.nextval
);

insert into tabela_sequencias values(default,default);

select * from tabela_sequencias;

delete from tabela_sequencias where id_no_order=5;



