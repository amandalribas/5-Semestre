create SEQUENCE seq_teste
increment by -2
minvalue 0
maxvalue 100
start with 100
cache 5;

drop SEQUENCE seq_teste;

select nextval('seq_teste');

select currval('seq_teste');


