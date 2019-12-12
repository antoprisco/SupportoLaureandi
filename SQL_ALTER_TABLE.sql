USE englishvalidation;

ALTER TABLE REQUEST 
ADD foreign key(FK_USER) references USER(EMAIL);

ALTER TABLE REQUEST 
ADD foreign key(FK_STATE) references STATE(ID_STATE);

ALTER TABLE REQUEST 
ADD foreign key(FK_CERTIFIER) references ENTE(ID_ENTE);

ALTER TABLE ATTACHED
ADD foreign key(FK_REQUEST) references REQUEST(ID_REQUEST);

ALTER TABLE ATTACHED
ADD foreign key(FK_USER) references USER(EMAIL);
