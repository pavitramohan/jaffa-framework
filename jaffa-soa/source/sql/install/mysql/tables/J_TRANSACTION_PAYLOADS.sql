CREATE TABLE J_TRANSACTION_PAYLOADS (
        ID          VARCHAR(80) NOT NULL,
        EXTERNAL_MESSAGE          LONGBLOB,
        INTERNAL_MESSAGE          LONGBLOB,
        INTERNAL_MESSAGE_CLASS          TEXT,
    CONSTRAINT J_TRANSACTION_PAYLOADSP1 PRIMARY KEY(ID)
) TYPE=InnoDB
