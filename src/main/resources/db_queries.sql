-- Procedure Details used in this project.
create or replace PROCEDURE NICK_NAME_PROC (NICK_LIST OUT SYS_REFCURSOR)
AS BEGIN
    OPEN NICK_LIST FOR SELECT "A1"."NICKNAME_ID" "NICKNAME_ID","A1"."NAME" "NAME","A1"."REC_CRE_DATE" "REC_CRE_DATE","A1"."ADDRESS" "ADDRESS" FROM "NICKNAME" "A1";
END;


-- Table Details used.
CREATE TABLE NICKNAME
(
    "NICKNAME_ID"  NUMBER            NOT NULL ENABLE,
    "NAME"         VARCHAR2(20 BYTE) NOT NULL ENABLE,
    "REC_CRE_DATE" TIMESTAMP(6)      NOT NULL ENABLE,
    "ADDRESS"      VARCHAR2(20 BYTE) NOT NULL ENABLE,
    CONSTRAINT "NICKNAME_PK" PRIMARY KEY ("NICKNAME_ID")
);

-- seq
CREATE SEQUENCE  NICKNAME_ID_SEQ  MINVALUE 1 MAXVALUE 999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 ORDER  NOCYCLE  ;

-- Trigger
create or replace TRIGGER NICKNAME_ID_TRG BEFORE
    INSERT ON NICKNAME
    FOR EACH ROW
    WHEN ( NEW.NICKNAME_ID IS NULL )
BEGIN
    :NEW.NICKNAME_ID := NICKNAME_ID_SEQ.NEXTVAL;
END;

-- Inparams Stored Procedure
create or replace PROCEDURE NICK_NAME_PROC_IN (NICK_ID IN INT ,NICK_LIST OUT SYS_REFCURSOR)
AS BEGIN
    OPEN NICK_LIST FOR SELECT NICKNAME_ID, NAME ,REC_CRE_DATE ,ADDRESS FROM NICKNAME where NICKNAME_ID= NICK_ID;
END;