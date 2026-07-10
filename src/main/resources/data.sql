DELETE FROM registo_trabalho;
ALTER TABLE registo_trabalho DROP COLUMN IF EXISTS status;ALTER TABLE registo_trabalho DROP COLUMN IF EXISTS status;
DELETE FROM soldadores;
DELETE FROM equipamentos;
DELETE FROM consumiveis;

INSERT INTO soldadores (soldador_name, password, papel)
VALUES ('Pires', '$2a$12$RcB1VelwHyvK6IwoxxuNy.5mD.TNDEjV0b.dJ8AYCykgfilerURpq', 'ADMIN');

INSERT INTO soldadores (soldador_name, password, papel)
VALUES ('Carlos', '$2a$12$03r.ZCWIP0I6UACVdhOGn.pIL6rjqGAyMrZ2cf7d3Wh4ahmqgueUu', 'USER');