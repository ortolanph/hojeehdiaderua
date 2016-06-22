--  Cria schema de banco de dados

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

CREATE SCHEMA diaderua;

ALTER SCHEMA diaderua OWNER TO postgres;

SET search_path = diaderua, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

CREATE TABLE diaderua.festividade (
    fest_id integer NOT NULL,
    fest_dia smallint NOT NULL,
    fest_mes smallint NOT NULL,
    fest_festividade character varying(255) NOT NULL,
    fest_fonte character varying(255)
);


ALTER TABLE diaderua.festividade OWNER TO postgres;

CREATE TABLE diaderua.logradourodata (
    loda_id integer NOT NULL,
    loda_dia smallint NOT NULL,
    loda_mes smallint NOT NULL,
    loda_cidade character varying(255) NOT NULL,
    loda_uf character(2) NOT NULL
);


ALTER TABLE diaderua.logradourodata OWNER TO postgres;

CREATE SEQUENCE diaderua.seq_festividade
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE diaderua.seq_festividade OWNER TO postgres;

CREATE SEQUENCE diaderua.seq_logdata
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE diaderua.seq_logdata OWNER TO postgres;

ALTER TABLE ONLY diaderua.festividade
    ADD CONSTRAINT festividade_pkey PRIMARY KEY (fest_id);

ALTER TABLE ONLY diaderua.logradourodata
    ADD CONSTRAINT logradourodata_pkey PRIMARY KEY (loda_id);
