USE englishvalidation;
INSERT INTO user
VALUES('segreteria@unisa.it','Segreteria','Studenti','M','4bb47fd2a6c598d2a52ef7de3473fd3ea8401a9b','1'); 

INSERT INTO user
VALUES('fferrucci@unisa.it','Filomena','Ferrucci','M','4bb47fd2a6c598d2a52ef7de3473fd3ea8401a9b','2');

INSERT INTO STATE 
VALUES (1,'Parzialmente Completata');
INSERT INTO STATE 
VALUES (2,'In elaborazione dalla Segreteria');
INSERT INTO STATE 
VALUES (3,'In elaborazione dall&quot; Amministratore');
INSERT INTO STATE 
VALUES (4,'Accettata e In elaborazione dal Consiglio Didattico');
INSERT INTO STATE 
VALUES (5,'Rifiutata e In elaborazione dal Consiglio Didattico');
INSERT INTO STATE 
VALUES (6,'Conclusa e Accettata');
INSERT INTO STATE 
VALUES (7,'Conclusa e Rifiutata');

INSERT INTO SYSTEM_ATTRIBUTE
VALUES('request-partially-completed', '1','fferrucci@unisa.it');
INSERT INTO SYSTEM_ATTRIBUTE
VALUES('request-working-secretary', '2','fferrucci@unisa.it');
INSERT INTO SYSTEM_ATTRIBUTE
VALUES('request-working-admin', '3','fferrucci@unisa.it');
INSERT INTO SYSTEM_ATTRIBUTE
VALUES('request-working-educational-advice-1', '4','fferrucci@unisa.it');
INSERT INTO SYSTEM_ATTRIBUTE
VALUES('request-working-educational-advice-2', '5','fferrucci@unisa.it');
INSERT INTO SYSTEM_ATTRIBUTE
VALUES('request-accepted', '6','fferrucci@unisa.it');
INSERT INTO SYSTEM_ATTRIBUTE
VALUES('request-refused', '7','fferrucci@unisa.it');

INSERT INTO SYSTEM_ATTRIBUTE
VALUES('request-number-max-upload', '2','fferrucci@unisa.it');
INSERT INTO SYSTEM_ATTRIBUTE
VALUES('request-allowed-extension-upload', '.pdf','fferrucci@unisa.it');
INSERT INTO SYSTEM_ATTRIBUTE
VALUES('request-matriculation-year-range', '5','fferrucci@unisa.it');
INSERT INTO SYSTEM_ATTRIBUTE
VALUES('request-min-cfu', '1','fferrucci@unisa.it');
INSERT INTO SYSTEM_ATTRIBUTE
VALUES('request-max-cfu', '12','fferrucci@unisa.it');
INSERT INTO SYSTEM_ATTRIBUTE
VALUES('request-upload-path', '//home//vale//newWorkspace//EV_EnglishValidation//uploads//','fferrucci@unisa.it');

INSERT INTO ENTE
VALUES ('1', '','Cambridge Assessment English','', 1);
INSERT INTO ENTE
VALUES ('2', '','City and Guilds (Pitman)','', 1);
INSERT INTO ENTE
VALUES ('3', '','Edexcel /Pearson Ltd','', 1);
INSERT INTO ENTE
VALUES ('4', '','Educational Testing Service (ETS)','', 1);
INSERT INTO ENTE
VALUES ('5', '','English Speaking Board (ESB)','', 1);
INSERT INTO ENTE
VALUES ('6', '','International English Language Testing System (IELTS)','', 1);
INSERT INTO ENTE
VALUES ('7', '','Pearson - LCCI','', 1);
INSERT INTO ENTE
VALUES ('8', '','Pearson - EDI','', 1);
INSERT INTO ENTE
VALUES ('9', '','Trinity College London (TCL)','', 1);
INSERT INTO ENTE
VALUES ('10', '','Department of English, Faculty of Arts - University of Malta','', 1);
INSERT INTO ENTE
VALUES ('11', '','NQAI - ACELS','', 1);
INSERT INTO ENTE
VALUES ('12', '','Ascentis','', 1);
INSERT INTO ENTE
VALUES ('13', '','AIM Awards','', 1);
INSERT INTO ENTE
VALUES ('14', '','Learning Resource Network (LRN)','', 1);
INSERT INTO ENTE
VALUES ('15', '','British Institutes','', 1);
INSERT INTO ENTE
VALUES ('16', '','Gatehouse Awards Ltd','', 1);
INSERT INTO ENTE
VALUES ('17', '','LanguageCert','', 1);
