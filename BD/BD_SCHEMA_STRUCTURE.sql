/*
SCRIPT 1, Ejecutar antes de crear las tablas con el ORM
*/
\c BDMONCAYO

create database "BDDOLEX"
    with
    owner = bmx_root
    encoding = 'UTF8'
    lc_collate = 'en_US.utf8'
    lc_ctype = 'en_US.utf8'
    tablespace = pg_default
    connection limit = -1
    is_template = false;

\c BDDOLEX

create schema cmdolex
    authorization bmx_root;


/*
SCRIPT 2, Ejecutar despues de crear las tablas con el ORM
*/
\c BDDOLEX

alter table cmdolex.tb_citas
    add constraint fk_tb_citas_01 
    foreign key (ci_doctor_id)
    references cmdolex.tb_doctores (ci_doctor_id)
        on update cascade
        on delete cascade;
alter table cmdolex.tb_citas
    add constraint fk_tb_citas_02 
    foreign key (ci_configuracion_tiempo_cita_id)
    references cmdolex.tb_configuracion_tiempo_cita (ci_configuracion_tiempo_cita_id)
        on update cascade
        on delete cascade;
        
alter table cmdolex.tb_horarios_x_dia
    add constraint fk_tb_horarios_x_dia_01 
    foreign key (ci_dia_id)
    references cmdolex.tb_dias (ci_dia_id)
        on update cascade
        on delete cascade;


/*
SCRIPT 3, Ejecutar despues de crear las tablas con el ORM 
*/

--REGISTROS CATALOGO TB_DOCTORES
insert into cmdolex.tb_doctores
    (
        ci_doctor_id,
        cs_nombre,
        cs_apellido_paterno,
        cs_apellido_materno,
        cs_telefono,
        cts_fecha_registro
    ) values(1, 'Mario', 'Alcazar', 'Fernandez', '6566812123', current_timestamp);
    
insert into cmdolex.tb_doctores
    (
        ci_doctor_id,
        cs_nombre,
        cs_apellido_paterno,
        cs_apellido_materno,
        cs_telefono,
        cts_fecha_registro
    ) values(2, 'Esmeralda', 'Martinez', 'Hernandez', '6566812120', current_timestamp);
    
insert into cmdolex.tb_doctores
    (
        ci_doctor_id,
        cs_nombre,
        cs_apellido_paterno,
        cs_apellido_materno,
        cs_telefono,
        cts_fecha_registro
    ) values(3, 'Cesar', 'Ruiz', 'Gutierrez', '6566812125', current_timestamp);
    
insert into cmdolex.tb_doctores
    (
        ci_doctor_id,
        cs_nombre,
        cs_apellido_paterno,
        cs_apellido_materno,
        cs_telefono,
        cts_fecha_registro
    ) values(4, 'Maria', 'Orlan', 'Garcia', '6566812128', current_timestamp);
    
insert into cmdolex.tb_doctores
    (
        ci_doctor_id,
        cs_nombre,
        cs_apellido_paterno,
        cs_apellido_materno,
        cs_telefono,
        cts_fecha_registro
    ) values(5, 'Rubi', 'Lorenzo', 'Martinez', '6566812128', current_timestamp);
    
insert into cmdolex.tb_doctores
    (
        ci_doctor_id,
        cs_nombre,
        cs_apellido_paterno,
        cs_apellido_materno,
        cs_telefono,
        cts_fecha_registro
    ) values(6, 'Ximena', 'Carreon', 'Gonzalez', '6566812130', current_timestamp);

--REGISTROS ESTATICOS TB_DIAS
insert into cmdolex.tb_dias
    (
        ci_dia_id,
        cs_descripcion,
        cts_fecha_registro
    ) values(1, 'LUNES', current_timestamp);
    
insert into cmdolex.tb_dias
    (
        ci_dia_id,
        cs_descripcion,
        cts_fecha_registro
    ) values(2, 'MARTES', current_timestamp);
    
insert into cmdolex.tb_dias
    (
        ci_dia_id,
        cs_descripcion,
        cts_fecha_registro
    ) values(3, 'MIERCOLES', current_timestamp);
    
insert into cmdolex.tb_dias
    (
        ci_dia_id,
        cs_descripcion,
        cts_fecha_registro
    ) values(4, 'JUEVES', current_timestamp);
    
insert into cmdolex.tb_dias
    (
        ci_dia_id,
        cs_descripcion,
        cts_fecha_registro
    ) values(5, 'VIERNES', current_timestamp);
    
insert into cmdolex.tb_dias
    (
        ci_dia_id,
        cs_descripcion,
        cts_fecha_registro
    ) values(6, 'SABADO', current_timestamp);
    
insert into cmdolex.tb_dias
    (
        ci_dia_id,
        cs_descripcion,
        cts_fecha_registro
    ) values(7, 'DOMINGO', current_timestamp);


--REGISTROS ESTATICOS DE CONFIGURACION DE HORARIO X DIA
insert into cmdolex.tb_horarios_x_dia
    (
        ci_horario_id,
        ci_dia_id,
        ct_hora_inicio,
        ct_hora_fin,
        cts_fecha_registro
    ) values(1, 1, '10:00:00', '17:00:00', current_timestamp);
    
insert into cmdolex.tb_horarios_x_dia
    (
        ci_horario_id,
        ci_dia_id,
        ct_hora_inicio,
        ct_hora_fin,
        cts_fecha_registro
    ) values(2, 2, '10:00:00', '17:00:00', current_timestamp);

insert into cmdolex.tb_horarios_x_dia
    (
        ci_horario_id,
        ci_dia_id,
        ct_hora_inicio,
        ct_hora_fin,
        cts_fecha_registro
    ) values(3, 3, '10:00:00', '17:00:00', current_timestamp);
    
insert into cmdolex.tb_horarios_x_dia
    (
        ci_horario_id,
        ci_dia_id,
        ct_hora_inicio,
        ct_hora_fin,
        cts_fecha_registro
    ) values(4, 4, '10:00:00', '17:00:00', current_timestamp);
    
insert into cmdolex.tb_horarios_x_dia
    (
        ci_horario_id,
        ci_dia_id,
        ct_hora_inicio,
        ct_hora_fin,
        cts_fecha_registro
    ) values(5, 5, '10:00:00', '17:00:00', current_timestamp);
    
insert into cmdolex.tb_horarios_x_dia
    (
        ci_horario_id,
        ci_dia_id,
        ct_hora_inicio,
        ct_hora_fin,
        cts_fecha_registro
    ) values(6, 6, '10:00:00', '17:00:00', current_timestamp);
    
insert into cmdolex.tb_horarios_x_dia
    (
        ci_horario_id,
        ci_dia_id,
        ct_hora_inicio,
        ct_hora_fin,
        cts_fecha_registro
    ) values(7, 7, '10:00:00', '17:00:00', current_timestamp);

--REGISTROS ESTATICOS DE CONFIGURACION TIEMPO CITA
INSERT INTO cmdolex.tb_configuracion_tiempo_cita
    (
        ci_configuracion_tiempo_cita_id, 
        ci_minutos_cita,
        cb_estatus,
        cts_fecha_registro
    ) VALUES (1, 60, true, current_timestamp);