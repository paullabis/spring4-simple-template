--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: account; Type: TABLE; Schema: public; Owner: mzl; Tablespace: 
--

CREATE TABLE account (
    id bigint NOT NULL,
    created timestamp without time zone,
    email character varying(255),
    password character varying(255),
    role character varying(255)
);


ALTER TABLE public.account OWNER TO mzl;

--
-- Name: category; Type: TABLE; Schema: public; Owner: mzl; Tablespace: 
--

CREATE TABLE category (
    id bigint NOT NULL,
    description character varying(255),
    name character varying(255)
);


ALTER TABLE public.category OWNER TO mzl;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: mzl
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO mzl;

--
-- Name: product; Type: TABLE; Schema: public; Owner: mzl; Tablespace: 
--

CREATE TABLE product (
    id bigint NOT NULL,
    available boolean NOT NULL,
    description character varying(255),
    name character varying(255),
    price double precision NOT NULL,
    category_id bigint
);


ALTER TABLE public.product OWNER TO mzl;

--
-- Name: account_pkey; Type: CONSTRAINT; Schema: public; Owner: mzl; Tablespace: 
--

ALTER TABLE ONLY account
    ADD CONSTRAINT account_pkey PRIMARY KEY (id);


--
-- Name: category_pkey; Type: CONSTRAINT; Schema: public; Owner: mzl; Tablespace: 
--

ALTER TABLE ONLY category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);


--
-- Name: product_pkey; Type: CONSTRAINT; Schema: public; Owner: mzl; Tablespace: 
--

ALTER TABLE ONLY product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- Name: uk_q0uja26qgu1atulenwup9rxyr; Type: CONSTRAINT; Schema: public; Owner: mzl; Tablespace: 
--

ALTER TABLE ONLY account
    ADD CONSTRAINT uk_q0uja26qgu1atulenwup9rxyr UNIQUE (email);


--
-- Name: fk_rlaghtegr0yx2c1q1s6nkqjlh; Type: FK CONSTRAINT; Schema: public; Owner: mzl
--

ALTER TABLE ONLY product
    ADD CONSTRAINT fk_rlaghtegr0yx2c1q1s6nkqjlh FOREIGN KEY (category_id) REFERENCES category(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

