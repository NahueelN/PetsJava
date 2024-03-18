

-- insertar los usuarios
INSERT INTO usuario (nombre, contrasena) VALUES ('nahuel', '1234');
INSERT INTO usuario (nombre, contrasena) VALUES ('user', '$2a$12$SlpV8ZblK/SXq1i5wHF67O5sZt9XduojXyBfQkry317PXAlAlhF8u');


-- insertar datos de ejemplos en la tabla dueños
insert into duenio (nombre,direccion) values ('nahuel','calle 123');
insert into duenio (nombre,direccion) values ('matias','avenida 123');
insert into duenio (nombre,direccion) values ('alan','calle 321');
insert into duenio (nombre,direccion) values ('pedri','avenida 1234');



-- insertar datos de ejemplos en la tabla mascotas


INSERT INTO mascota (nombre,especie,edad,duenio_id) VALUES ('roco','perro',2,1);
INSERT INTO mascota (nombre,especie,edad,duenio_id) VALUES ('bondiola','gato',12,3);
INSERT INTO mascota (nombre,especie,edad,duenio_id) VALUES ('black','perro',2,4);
INSERT INTO mascota (nombre,especie,edad,duenio_id) VALUES ('cesar','girafa',2,2);