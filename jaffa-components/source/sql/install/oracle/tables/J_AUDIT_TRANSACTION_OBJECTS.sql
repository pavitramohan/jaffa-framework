CREATE TABLE "J_AUDIT_TRANSACTION_OBJECTS"(
        "OBJECT_ID"          VARCHAR2(80) NOT NULL,
        "TRANSACTION_ID"          VARCHAR2(80) NOT NULL,
        "OBJECT_NAME"          VARCHAR2(80) NOT NULL,
        "CHANGE_TYPE"          VARCHAR2(1),
    CONSTRAINT "J_AUDIT_TRANSACTION_OBJECTSP1" PRIMARY KEY("OBJECT_ID")
)
/
