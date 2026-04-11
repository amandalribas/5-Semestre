--Verificando se as conexões são distintas:
SELECT pg_backend_pid();

--Após usar nextval na conexão 0, testando aqui:
select nextval('seq_teste');

--Se eu começo utilizando currval: currval of sequence "seq_teste" is not yet defined in this session 
select currval('seq_teste');


drop SEQUENCE seq_exercicio;


