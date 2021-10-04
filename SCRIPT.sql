/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     1/10/2021 1:27:54 a.�m.                      */
/*==============================================================*/

create sequence S_EDUCACION_BASICA;

create sequence S_GRADO;

/*==============================================================*/
/* Table: COMPETENCIA                                           */
/*==============================================================*/
create table COMPETENCIA 
(
   COM_ORAL             VARCHAR2(10)        
      constraint CKC_COM_ORAL_COMPETEN check (COM_ORAL is null or (COM_ORAL in ('Regular','Bien','muy bien'))),
   COM_ESCRITA          VARCHAR2(10)        
      constraint CKC_COM_ESCRITA_COMPETEN check (COM_ESCRITA is null or (COM_ESCRITA in ('Regular','Bien','muy bien'))),
   COM_LECTORA          VARCHAR2(10)        
      constraint CKC_COM_LECTORA_COMPETEN check (COM_LECTORA is null or (COM_LECTORA in ('Regular','Bien','muy bien'))),
   COM_CODIGO           NUMBER               not null,
   IDI_CODIGO           NUMBER,
   constraint PK_COMPETENCIA primary key (COM_CODIGO)
);

/*==============================================================*/
/* Table: DEPARTAMENTO                                          */
/*==============================================================*/
create table DEPARTAMENTO 
(
   DEP_CODIGO           NUMBER               not null,
   PAI_CODIGO           NUMBER               not null,
   DEP_NOMBRE           VARCHAR2(20)         not null,
   constraint PK_DEPARTAMENTO primary key (DEP_CODIGO)
);

/*==============================================================*/
/* Index: TIENE_FK                                              */
/*==============================================================*/
create index TIENE_FK on DEPARTAMENTO (
   PAI_CODIGO ASC
);

/*==============================================================*/
/* Table: EDUCACION_BASICA                                      */
/*==============================================================*/
create table EDUCACION_BASICA 
(
   EDB_CODIGO           NUMBER(6)            not null,
   EDB_TITULO_OBTENIDO  VARCHAR2(30)         not null,
   EDB_FECHA_GRADO      DATE,
   EDN_NIVEL_MAXIMO_OBTENIDO VARCHAR2(10)        
      constraint CKC_EDN_NIVEL_MAXIMO__EDUCACIO check (EDN_NIVEL_MAXIMO_OBTENIDO is null or (EDN_NIVEL_MAXIMO_OBTENIDO in ('primaria ','Secundaria','Media'))),
   constraint PK_EDUCACION_BASICA primary key (EDB_CODIGO)
);

/*==============================================================*/
/* Table: EMPRESA                                               */
/*==============================================================*/
create table EMPRESA 
(
   EMP_CODIGO           NUMBER               not null,
   MUN_CODIGO           NUMBER               not null,
   EMP_RAZONSOCIAL      VARCHAR2(50)         not null,
   EMP_TIPO             VARCHAR2(10)         not null
      constraint CKC_EMP_TIPO_EMPRESA check (EMP_TIPO in ('Publica','Privada')),
   EMP_DIRECCION        VARCHAR2(50)         not null,
   EMP_TELEFONO         NUMBER               not null,
   EMP_CORREO_ELECTRONICO VARCHAR2(20)         not null,
   constraint PK_EMPRESA primary key (EMP_CODIGO)
);

/*==============================================================*/
/* Index: SE_UBICA_FK                                           */
/*==============================================================*/
create index SE_UBICA_FK on EMPRESA (
   MUN_CODIGO ASC
);

/*==============================================================*/
/* Table: EXPERIENCIA                                           */
/*==============================================================*/
create table EXPERIENCIA 
(
   EMP_CODIGO           NUMBER               not null,
   PER_NUMEROIDENTIFICACION NUMBER(15)           not null,
   FECHA_INGRESO        DATE                 not null,
   FECHA_EGRESO         DATE,
   ACTUAL               VARCHAR2(10)        
      constraint CKC_ACTUAL_EXPERIEN check (ACTUAL is null or (ACTUAL in ('si','no'))),
   CARGO                VARCHAR2(30),
   DEPENDENCIA          VARCHAR2(20),
   constraint PK_EXPERIENCIA primary key (EMP_CODIGO, PER_NUMEROIDENTIFICACION)
);

/*==============================================================*/
/* Index: EXPERIENCIA_FK                                        */
/*==============================================================*/
create index EXPERIENCIA_FK on EXPERIENCIA (
   PER_NUMEROIDENTIFICACION ASC
);

/*==============================================================*/
/* Table: GRADO                                                 */
/*==============================================================*/
create table GRADO 
(
   GRA_CODIGO           NUMBER(6)            not null,
   PRO_CODIGO_SNIES     NUMBER(20)           not null,
   PER_NUMEROIDENTIFICACION NUMBER(15)           not null,
   GRA_NO_SEMES_APROB   NUMBER(12)           not null,
   GRA_ESTADO_GRADO     VARCHAR2(10)         not null
      constraint CKC_GRA_ESTADO_GRADO_GRADO check (GRA_ESTADO_GRADO in ('si','no')),
   GRA_FECHA_GRADO      DATE                 not null,
   GRA_NO_TARJETA_P     NUMBER,
   constraint PK_GRADO primary key (GRA_CODIGO)
);

/*==============================================================*/
/* Index: REGISTRA_FK                                           */
/*==============================================================*/
create index REGISTRA_FK on GRADO (
   PRO_CODIGO_SNIES ASC
);

/*==============================================================*/
/* Index: OBTIENE_FK                                            */
/*==============================================================*/
create index OBTIENE_FK on GRADO (
   PER_NUMEROIDENTIFICACION ASC
);

/*==============================================================*/
/* Table: IDIOMA                                                */
/*==============================================================*/
create table IDIOMA 
(
   IDI_CODIGO           NUMBER               not null,
   PER_NUMEROIDENTIFICACION NUMBER(15)           not null,
   IDI_NOMBRE           VARCHAR2(20)         not null,
   constraint PK_IDIOMA primary key (IDI_CODIGO)
);

/*==============================================================*/
/* Index: HABLA_FK                                              */
/*==============================================================*/
create index HABLA_FK on IDIOMA (
   PER_NUMEROIDENTIFICACION ASC
);

/*==============================================================*/
/* Table: MUNICIPIO                                             */
/*==============================================================*/
create table MUNICIPIO 
(
   MUN_CODIGO           NUMBER               not null,
   DEP_CODIGO           NUMBER               not null,
   MUN_NOMBRE           VARCHAR2(20)         not null,
   constraint PK_MUNICIPIO primary key (MUN_CODIGO)
);

/*==============================================================*/
/* Index: PERTENECE_FK                                          */
/*==============================================================*/
create index PERTENECE_FK on MUNICIPIO (
   DEP_CODIGO ASC
);

/*==============================================================*/
/* Table: PAIS                                                  */
/*==============================================================*/
create table PAIS 
(
   PAI_CODIGO           NUMBER               not null,
   PAI_NOMBRE           VARCHAR2(20)         not null,
   constraint PK_PAIS primary key (PAI_CODIGO)
);

/*==============================================================*/
/* Table: PERSONA                                               */
/*==============================================================*/
create table PERSONA 
(
   PER_PRIMER_NOMBRE    VARCHAR2(20)         not null,
   PER_TELEFONO         NUMBER               not null,
   PER_SEGUNDO_NOMBRE   VARCHAR2(20),
   PER_PRIMER_APELLIDO  VARCHAR2(20)         not null,
   PER_SEGUNDO_APELLIDO VARCHAR2(20),
   PER_NUMEROIDENTIFICACION NUMBER(15)           not null,
   MUN_CODIGO           NUMBER               not null,
   MUN_MUN_CODIGO       NUMBER               not null,
   EDB_CODIGO           INTEGER              not null,
   PER_TIPO_IDENTIFICACION VARCHAR2(10)         not null
      constraint CKC_PER_TIPO_IDENTIFI_PERSONA check (PER_TIPO_IDENTIFICACION in ('CC','CE','PASS')),
   PER_SEXO             VARCHAR2(10)         not null
      constraint CKC_PER_SEXO_PERSONA check (PER_SEXO in ('hombre','mujer')),
   PER_N_LIBRETA_MILITAR NUMBER(20),
   PER_CLASE_LM         VARCHAR2(10),
   PER_DM_LIBRETA       VARCHAR2(20),
   PER_DIRECCION_CORRESPONDENCIA VARCHAR2(50)         not null,
   PER_FECHA_NACIMIENTO DATE                 not null,
   PER_MAIL             VARCHAR2(30),
   constraint PK_PERSONA primary key (PER_NUMEROIDENTIFICACION)
);

/*==============================================================*/
/* Index: RESIDE_FK                                             */
/*==============================================================*/
create index RESIDE_FK on PERSONA (
   MUN_CODIGO ASC
);

/*==============================================================*/
/* Index: NACE_FK                                               */
/*==============================================================*/
create index NACE_FK on PERSONA (
   MUN_MUN_CODIGO ASC
);

/*==============================================================*/
/* Index: CURSA_FK                                              */
/*==============================================================*/
create index CURSA_FK on PERSONA (
   EDB_CODIGO ASC
);

/*==============================================================*/
/* Table: PROGRAMA                                              */
/*==============================================================*/
create table PROGRAMA 
(
   PRO_CODIGO_SNIES     NUMBER(20)           not null,
   UNI_CODIGO_IES       NUMBER(20)           not null,
   PRO_MODALIDADEDUCATIVA VARCHAR2(10)         not null
      constraint CKC_PRO_MODALIDADEDUC_PROGRAMA check (PRO_MODALIDADEDUCATIVA in ('TC','TL','TE','UN','ES','MG','DOC')),
   PRO_TITULO           VARCHAR2(50),
   PRO_NO_SEMESTRES_APROBADO NUMBER(1),
   constraint PK_PROGRAMA primary key (PRO_CODIGO_SNIES)
);

/*==============================================================*/
/* Index: OFRECE_FK                                             */
/*==============================================================*/
create index OFRECE_FK on PROGRAMA (
   UNI_CODIGO_IES ASC
);

/*==============================================================*/
/* Table: UNIVERSIDAD                                           */
/*==============================================================*/
create table UNIVERSIDAD 
(
   UNI_CODIGO_IES       NUMBER(20)           not null,
   UNI_NOMBRE           VARCHAR2(50)         not null,
   constraint PK_UNIVERSIDAD primary key (UNI_CODIGO_IES)
);

alter table COMPETENCIA
   add constraint FK_COMPETEN_ADQUIERE_IDIOMA foreign key (IDI_CODIGO)
      references IDIOMA (IDI_CODIGO);

alter table DEPARTAMENTO
   add constraint FK_DEPARTAM_TIENE_PAIS foreign key (PAI_CODIGO)
      references PAIS (PAI_CODIGO);

alter table EMPRESA
   add constraint FK_EMPRESA_SE_UBICA_MUNICIPI foreign key (MUN_CODIGO)
      references MUNICIPIO (MUN_CODIGO);

alter table EXPERIENCIA
   add constraint FK_EXPERIEN_EXPERIENC_PERSONA foreign key (PER_NUMEROIDENTIFICACION)
      references PERSONA (PER_NUMEROIDENTIFICACION);

alter table EXPERIENCIA
   add constraint FK_EXPERIEN_EXPERIENC_EMPRESA foreign key (EMP_CODIGO)
      references EMPRESA (EMP_CODIGO);

alter table GRADO
   add constraint FK_GRADO_OBTIENE_PERSONA foreign key (PER_NUMEROIDENTIFICACION)
      references PERSONA (PER_NUMEROIDENTIFICACION);

alter table GRADO
   add constraint FK_GRADO_REGISTRA_PROGRAMA foreign key (PRO_CODIGO_SNIES)
      references PROGRAMA (PRO_CODIGO_SNIES);

alter table IDIOMA
   add constraint FK_IDIOMA_HABLA_PERSONA foreign key (PER_NUMEROIDENTIFICACION)
      references PERSONA (PER_NUMEROIDENTIFICACION);

alter table MUNICIPIO
   add constraint FK_MUNICIPI_PERTENECE_DEPARTAM foreign key (DEP_CODIGO)
      references DEPARTAMENTO (DEP_CODIGO);

alter table PERSONA
   add constraint FK_PERSONA_CURSA_EDUCACIO foreign key (EDB_CODIGO)
      references EDUCACION_BASICA (EDB_CODIGO);

alter table PERSONA
   add constraint FK_PERSONA_NACE_MUNICIPI foreign key (MUN_MUN_CODIGO)
      references MUNICIPIO (MUN_CODIGO);

alter table PERSONA
   add constraint FK_PERSONA_RESIDE_MUNICIPI foreign key (MUN_CODIGO)
      references MUNICIPIO (MUN_CODIGO);

alter table PROGRAMA
   add constraint FK_PROGRAMA_OFRECE_UNIVERSI foreign key (UNI_CODIGO_IES)
      references UNIVERSIDAD (UNI_CODIGO_IES);

