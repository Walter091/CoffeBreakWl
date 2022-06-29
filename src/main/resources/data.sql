CREATE TABLE colaborador (
  ID_COLABORADOR INT NOT NULL,
  NOME VARCHAR(45),
  CPF VARCHAR(45),
  IND_OPCOES_CB INT,		
  PRIMARY KEY (ID)
);

INSERT INTO colaborador (ID_COLABORADOR, NOME, CPF, IND_OPCOES_CB)
VALUES (1, "Gaspar","14214477483", 1),
       (2, "Elton", "14210085483",1),
       (3, "Lucini","14214436483", 1),
       (4, "Diogo","14217785483", 1),
       (5, "Daniel","14214185483", 1),
       (6, "Marcos","14214475483", 1),
       (7, "Fernanda","14214485483", 1),
       (8, "Maicon","14214885483", 1),
       (9, "Rafael","14214485483", 0);