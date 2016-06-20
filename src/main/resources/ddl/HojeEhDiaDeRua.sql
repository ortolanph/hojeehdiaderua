--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: diaderua; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA diaderua;


ALTER SCHEMA diaderua OWNER TO postgres;

SET search_path = diaderua, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: Festividade; Type: TABLE; Schema: diaderua; Owner: postgres; Tablespace:
--

CREATE TABLE "Festividade" (
    fest_id integer NOT NULL,
    fest_dia smallint NOT NULL,
    fest_mes smallint NOT NULL,
    fest_festividade character varying(255) NOT NULL,
    fest_fonte character varying(255)
);


ALTER TABLE diaderua."Festividade" OWNER TO postgres;

--
-- Name: LogradouroData; Type: TABLE; Schema: diaderua; Owner: postgres; Tablespace:
--

CREATE TABLE "LogradouroData" (
    loda_id integer NOT NULL,
    loda_dia smallint NOT NULL,
    loda_mes smallint NOT NULL,
    loda_cidade character varying(255) NOT NULL,
    loda_uf character(2) NOT NULL
);


ALTER TABLE diaderua."LogradouroData" OWNER TO postgres;

--
-- Name: seq_festividade; Type: SEQUENCE; Schema: diaderua; Owner: postgres
--

CREATE SEQUENCE seq_festividade
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE diaderua.seq_festividade OWNER TO postgres;

--
-- Name: seq_logdata; Type: SEQUENCE; Schema: diaderua; Owner: postgres
--

CREATE SEQUENCE seq_logdata
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE diaderua.seq_logdata OWNER TO postgres;

--
-- Name: Festividade_pkey; Type: CONSTRAINT; Schema: diaderua; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY "Festividade"
    ADD CONSTRAINT "Festividade_pkey" PRIMARY KEY (fest_id);


--
-- Name: LogradouroData_pkey; Type: CONSTRAINT; Schema: diaderua; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY "LogradouroData"
    ADD CONSTRAINT "LogradouroData_pkey" PRIMARY KEY (loda_id);


--
-- PostgreSQL database dump complete
--