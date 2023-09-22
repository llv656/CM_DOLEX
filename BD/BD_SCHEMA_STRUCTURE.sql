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
