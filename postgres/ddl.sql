-- Table: public.member

-- DROP TABLE public.member;

CREATE TABLE public.member
(
    seq bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    id character varying(20) COLLATE pg_catalog."default" NOT NULL,
    password character varying(200) COLLATE pg_catalog."default" NOT NULL,
    name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    regdate timestamp without time zone NOT NULL DEFAULT LOCALTIMESTAMP,
    editdate timestamp without time zone NOT NULL DEFAULT LOCALTIMESTAMP,
    role integer NOT NULL DEFAULT 0,
    CONSTRAINT member_pkey PRIMARY KEY (seq),
    CONSTRAINT member_ukey UNIQUE (id)
)

    TABLESPACE pg_default;

ALTER TABLE public.member
    OWNER to postgres;

-- Table: public.board

-- DROP TABLE public.board;

CREATE TABLE public.board
(
    idx bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    title character varying(200) COLLATE pg_catalog."default" NOT NULL,
    content text COLLATE pg_catalog."default" NOT NULL,
    writedate timestamp without time zone NOT NULL DEFAULT now(),
    editdate timestamp without time zone NOT NULL DEFAULT now(),
    readcount integer NOT NULL DEFAULT 0,
    writer bigint,
    delflag boolean DEFAULT false,
    CONSTRAINT board_pkey PRIMARY KEY (idx)
)

    TABLESPACE pg_default;

ALTER TABLE public.board
    OWNER to postgres;