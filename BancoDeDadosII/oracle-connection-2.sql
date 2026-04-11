create synonym seq_test for SYS.seq_test;
create synonym tabela_sequencias for SYS.tabela_sequencias;


select seq_test.nextval from dual;

select seq_test.currval from dual;


select * from tabela_sequencias;

insert into tabela_sequencias values(default,default);

