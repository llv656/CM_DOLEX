\c BDDOLEX

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
