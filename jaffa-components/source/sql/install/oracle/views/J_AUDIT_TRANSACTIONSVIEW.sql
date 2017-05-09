CREATE OR REPLACE VIEW J_AUDIT_TRANSACTIONS$VIEW (
  TRANSACTION_ID,
  PROCESS_NAME,
  SUB_PROCESS_NAME,
  REASON,
  CREATED_BY,
  CREATED_ON,
  OBJECT_ID,
  OBJECT_NAME,
  CHANGE_TYPE,
  FIELD_ID,
  FIELD_NAME,
  FROM_VALUE,
  TO_VALUE,
  CHANGED,
  FLEX,
  OVERFLOW_FLAG,
  MULTILINE_HTML_FLAG,
  PK
) AS
SELECT A.*, CAST(SYS_GUID() AS VARCHAR2(32)) PK FROM (
(SELECT
  A.TRANSACTION_ID,
  A.PROCESS_NAME,
  A.SUB_PROCESS_NAME,
  A.REASON,
  A.CREATED_BY,
  A.CREATED_ON,
  B.OBJECT_ID,
  B.OBJECT_NAME,
  B.CHANGE_TYPE,
  C.FIELD_ID,
  C.FIELD_NAME,
  C.FROM_VALUE,
  C.TO_VALUE,
  C.CHANGED,
  C.FLEX,
  C.OVERFLOW_FLAG,
  C.MULTILINE_HTML_FLAG
  FROM
J_AUDIT_TRANSACTIONS A, J_AUDIT_TRANSACTION_OBJECTS B, J_AUDIT_TRANSACTION_FIELDS C
WHERE
  A.TRANSACTION_ID = B.TRANSACTION_ID
  AND B.OBJECT_ID = C.OBJECT_ID)) A
/
