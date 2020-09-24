INSERT INTO apiprofesional.tipo (id, nombre, descripcion, vigente) VALUES (1, 'DOCTOR', 'ESPECIALISTA EN MEDICINA', TRUE);
INSERT INTO apiprofesional.tipo (id, nombre, descripcion, vigente) VALUES (2, 'KINESIOLOGO', 'ESPECIALISTA EN REHABILITACION', TRUE);
INSERT INTO apiprofesional.tipo (id, nombre, descripcion, vigente) VALUES (3, 'PSICOLOGO', 'ESPECIALISTA EN PROBLEMAS MENTALES', TRUE);
INSERT INTO apiprofesional.tipo (id, nombre, descripcion, vigente) VALUES (4, 'ENFERMERA', 'ESPECIALISTA EN ASISTENCIA DE PACIENTES', TRUE);

INSERT INTO apiprofesional.profesional (id, nombres, apellido_paterno, apellido_materno, experiencia, vigente, id_tipo, fecha_nacimiento) VALUES (1, 'CRISTIAN ANDRES', 'VERA', 'SALAMANCA', 3, TRUE, 1, '1992-05-07');
INSERT INTO apiprofesional.profesional (id, nombres, apellido_paterno, apellido_materno, experiencia, vigente, id_tipo, fecha_nacimiento) VALUES (2, 'TANIA YANELA', 'RIQUELME', 'SAN MARTIN', 4, TRUE, 2, '1986-07-13');
INSERT INTO apiprofesional.profesional (id, nombres, apellido_paterno, apellido_materno, experiencia, vigente, id_tipo, fecha_nacimiento) VALUES (3, 'FABIAN ALEJANDRO', 'VERA', 'SALAMANCA', 2, TRUE, 3, '1996-03-24');
INSERT INTO apiprofesional.profesional (id, nombres, apellido_paterno, apellido_materno, experiencia, vigente, id_tipo, fecha_nacimiento) VALUES (4, 'MARIA DE LOS ANGELES', 'RIOS', 'SALAMANCA', 6, TRUE, 4, '1993-08-09');