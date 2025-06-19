-- #1 Account ���� DB�� ���� ���̺� ����(����)

CREATE TABLE account (
    accountnum   VARCHAR2(10),
    passwd       NUMBER(10) NOT NULL,
    accountowner VARCHAR2(10) NOT NULL,
    restmoney    NUMBER(30) NOT NULL,
    borrowmoney  NUMBER(30)
);

DROP TABLE account;

-- #2 NOT NULL ���������� ������ �������� �߰�
ALTER TABLE account ADD (
    CONSTRAINT accountnum_pk PRIMARY KEY ( accountnum )
);
    
-- #3 ������ ���Ǽ��� ���� �������� Ȱ��ȭ/��Ȱ��ȭ 
ALTER TABLE account DISABLE CONSTRAINT accountnum_pk;

--�ٽ� �����Ҷ� �������� Ȱ��ȭ
--ALTER TABLE account ENABLE CONSTRAINT accountnum_pk;

--���¹�ȣ �ڵ� ������ ���� ������ ����
CREATE SEQUENCE accountnum_seq START WITH 1000 INCREMENT BY 1;

DROP SEQUENCE accountnum_seq;

-- #4 ���̵����� �߰�, ����, ����
DESC account;

SELECT COUNT(*) cnt
FROM account;

SELECT
    accountnum,
    accountowner,
    passwd,
    restmoney,
    borrowmoney
FROM
    account
GROUP BY
    accountnum,
    accountowner,
    passwd,
    restmoney,
    borrowmoney
ORDER BY accountnum;


--���� ������ ����
INSERT INTO account (accountnum, accountowner, passwd, restmoney) 
VALUES ( accountnum_seq.NEXTVAL, '�����', 1111, 1000000);
INSERT INTO account (accountnum, accountowner, passwd, restmoney) 
VALUES ( accountnum_seq.NEXTVAL, 'ȫ����', 1111, 1000000);
INSERT INTO account (accountnum, accountowner, passwd, restmoney) 
VALUES ( accountnum_seq.NEXTVAL, '������', 1111, 1000000);
INSERT INTO account (accountnum, accountowner, passwd, restmoney) 
VALUES ( accountnum_seq.NEXTVAL, '������', 1111, 1000000);
INSERT INTO account (accountnum, accountowner, passwd, restmoney) 
VALUES ( accountnum_seq.NEXTVAL, '������', 1111, 1000000);
INSERT INTO account (accountnum, accountowner, passwd, restmoney, borrowmoney) 
VALUES ( accountnum_seq.NEXTVAL, '������', 1111, 1000000, 10000000);
INSERT INTO account (accountnum, accountowner, passwd, restmoney, borrowmoney) 
VALUES ( accountnum_seq.NEXTVAL, '������', 1111, 1000000, 10000000);
INSERT INTO account (accountnum, accountowner, passwd, restmoney) 
VALUES ( accountnum_seq.NEXTVAL, '������', 1111, 1000000);

-- �� ����
DELETE FROM account
WHERE
    accountowner LIKE '%��%';

-- �� ����
UPDATE account
SET
    accountnum = 1000
WHERE
    accountowner = 'ȫ����';

COMMIT;

ROLLBACK;