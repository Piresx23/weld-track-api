DELETE FROM registo_trabalho;
ALTER TABLE registo_trabalho DROP COLUMN IF EXISTS status;ALTER TABLE registo_trabalho DROP COLUMN IF EXISTS status;
DELETE FROM soldadores;
DELETE FROM equipamentos;
DELETE FROM consumiveis;

INSERT INTO soldadores (soldador_name, password, papel)
VALUES ('Pires', '$2a$12$gLhbZ8gHV83s7aJFHtDnq.PNckk8sRdDQK3Jwtn0nSLxHhOg716s6', 'ADMIN');

INSERT INTO soldadores (soldador_name, password, papel)
VALUES ('Carlos', '$2a$12$03r.ZCWIP0I6UACVdhOGn.pIL6rjqGAyMrZ2cf7d3Wh4ahmqgueUu', 'USER');