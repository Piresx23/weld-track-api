DELETE FROM soldadores;

INSERT INTO soldadores (soldador_name, password, papel)
VALUES ('Joao', '$2a$10$tJ0p/5XqB5jJ5QyGz5H5UuD5XQ5Wk3Pj8Z4o4n4i/wW/yYjJp7.y2', 'ADMIN');

INSERT INTO soldadores (soldador_name, password, papel)
VALUES ('Carlos', '$2a$10$iN.6gq1p1c2Vz5S6vO.2/.w/v1W5E1T1uU/7S6L1K1f/1z4h1t1s1', 'USER');