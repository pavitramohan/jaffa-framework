CREATE TABLE J_SOA_EVENT_PARAMS (
        EVENT_ID          VARCHAR(80) NOT NULL,
        NAME          VARCHAR(100) NOT NULL,
        VALUE          VARCHAR(100),
    CONSTRAINT J_SOA_EVENT_PARAMSP1 PRIMARY KEY(EVENT_ID,NAME)
) TYPE=InnoDB
