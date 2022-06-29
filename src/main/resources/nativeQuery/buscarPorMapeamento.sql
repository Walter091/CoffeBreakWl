SELECT ID_COLABORADOR as "id", NOME as "Nome", CPF as "CPF" FROM colaborador
WHERE 1=1
AND {{item}} = :{{item}}
