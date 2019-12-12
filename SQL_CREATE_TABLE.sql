DROP DATABASE IF EXISTS englishvalidation;
CREATE DATABASE englishvalidation COLLATE 'utf8_general_ci';
USE englishvalidation;

CREATE TABLE USER (
EMAIL varchar(50) not null,
NAME varchar(50) not null,
SURNAME varchar(50) not null,
SEX char not null,
PASSWORD varchar(50) not null,
USER_TYPE tinyint(1) not null,
primary key (EMAIL)
);

CREATE TABLE SYSTEM_ATTRIBUTE (
SLUG varchar(50) not null, 
VALUE varchar(100) not null, 
FK_USER varchar(50) not null,
primary key (SLUG),
foreign key (FK_USER) references USER(EMAIL)
);


CREATE TABLE REQUEST (
ID_REQUEST int(20) not null AUTO_INCREMENT,
CERTIFICATE_SERIAL VARCHAR(50) not null,
LEVEL varchar(7) not null,
RELEASE_DATE date not null, 
EXPIRY_DATE date not null, 
YEAR year not null, 
REQUESTED_CFU tinyint(2) not null, 
SERIAL int(10) not null, 
VALIDATED_CFU tinyint(2) not null, 
FK_USER varchar(50) not null,
FK_CERTIFIER int(20) not null, 
FK_STATE int(20) not null, 
primary key(ID_REQUEST)
);

CREATE TABLE ATTACHED (
ID_ATTACHED int(20) not null AUTO_INCREMENT,
FILENAME varchar(50) not null,
FK_REQUEST int(20) not null,
FK_USER varchar(50) not null,
primary key(ID_ATTACHED)
);


CREATE TABLE ENTE (
ID_ENTE int(20) not null AUTO_INCREMENT,
EMAIL varchar(50) not null,
NAME varchar(100) not null,
SITE varchar(50) not null,
STATO TINYINT not null DEFAULT 0,
primary key (ID_ENTE)
);

CREATE TABLE STATE (
ID_STATE int(20) not null AUTO_INCREMENT, 
DESCRIPTION varchar(100) not null,
primary key (ID_STATE)
);
