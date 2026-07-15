DELETE FROM registo_trabalho;
ALTER TABLE registo_trabalho DROP COLUMN IF EXISTS status;
DELETE FROM soldadores;
DELETE FROM equipamentos;
DELETE FROM consumiveis;

INSERT INTO soldadores (soldador_name, password, papel) /* " 1234 */
VALUES ('Pires', '$2a$12$RcB1VelwHyvK6IwoxxuNy.5mD.TNDEjV0b.dJ8AYCykgfilerURpq', 'ADMIN');

INSERT INTO soldadores (soldador_name, password, papel) /* password: Carloss */
VALUES ('Carlos', '$2a$12$OHMDS4iKQRUBhIZQtcUID..KmtdgOG15zqc6RCV27iKy2Qi8I8cwu', 'SOLDADOR');