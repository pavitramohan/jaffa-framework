CREATE TABLE ZZ_JUT_ASSET (
    ASSET_TK            BIGINT CONSTRAINT ZZ_JUT_ASSETP1 PRIMARY KEY,
    ASSET_ID            VARCHAR(50),
    PART                VARCHAR(50),
    CUSTODIAN           VARCHAR(50),
    CONDITION           VARCHAR(20),
    CREATED_DATETIME    TIMESTAMP,
    QTY                 BIGINT,
    KEY_REF             VARCHAR(50)
)