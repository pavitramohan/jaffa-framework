CREATE TABLE "J_SOA_EVENT_PARAMS"(
        "EVENT_ID"          VARCHAR2(80) NOT NULL,
        "NAME"          VARCHAR2(100) NOT NULL,
        "VALUE"          VARCHAR2(100),
    CONSTRAINT "J_SOA_EVENT_PARAMSP1" PRIMARY KEY("EVENT_ID","NAME")
)
/
