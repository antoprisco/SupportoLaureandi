CREATE TABLE SKILL (
ID_SKILL int(20) not null,
NOME varchar(50) not null,
TIPO int(20) not null,
LIVELLO int(20) not null,
primary key(ID_SKILL)
);

CREATE TABLE REQUEST_OU (
FK_ID_SKILL int(20) not null,
FK_EMAIL varchar(50) not null,
foreign key(FK_EMAIL) references USER(EMAIL),
foreign key(FK_ID_SKILL) references SKILL(ID_SKILL)
);