--	ID, NAME, MONEY
CREATE TABLE TBL_USER(
	USER_ID NUMBER,
	USER_NAME VARCHAR2(255),
	USER_MONEY NUMBER
);

-- SEQUENCE 자동으로 1씩 증가하는 값
-- SEQUENCE의 목적
CREATE SEQUENCE USER_SEQ;
DROP SEQUENCE USER_SEQ;

SELECT * FROM TBL_USER;

-- ALTER 
-- 컬럼추가 ADD
ALTER TABLE TBL_USER ADD USER_ADDRESS VARCHAR2(255);

-- 컬럼의 타입변경 MODIFY
ALTER TABLE TBL_USER MODIFY USER_ADDRESS NUMBER;

-- 컬럼의 이름변경 RENAME COLUMN ~ TO
ALTER TABLE TBL_USER RENAME COLUMN USER_ADDRESS TO USER_PHONE;

SELECT * FROM TBL_USER;

-- 컬럼삭제 DROP
ALTER TABLE TBL_USER DROP COLUMN USER_PHONE;


-- DDL 실습(30분)
-- 테이블 생성(CREATE) PERSON
-- 컬럼 ID, NAME, USEREMAIL, ADDRESS, COMPANY
-- 타입 정수, 문자열, 문자열, 문자열, 문자열

CREATE TABLE TBL_PERSON(
	PERSON_ID NUMBER,
	PERSON_NAME VARCHAR2(255),
	PERSON_USER_EMAIL VARCHAR2(255),
	PERSON_ADDRESS VARCHAR2(255),
	PERSON_COMPANY VARCHAR2(255)
);

SELECT * FROM TBL_PERSON;

-- 컬럼을 수정(ALTER)
-- USEREMAIL 이름을 EMAIL로 변경
ALTER TABLE TBL_PERSON RENAME COLUMN PERSON_USER_EMAIL TO PERSON_EMAIL;

-- COMPANY 타입을 실수로 변경
ALTER TABLE TBL_PERSON MODIFY PERSON_COMPANY FLOAT;

-- CITY 컬럼이 문자열 추가
ALTER TABLE TBL_PERSON ADD PERSON_CITY VARCHAR2(255);

-- ADDRESS 컬럼을 삭제
ALTER TABLE TBL_PERSON DROP COLUMN PERSON_ADDRESS;

-- 테이블을 삭제(DROP)
-- 모두 완료되면 테이블 삭제
DROP TABLE TBL_PERSON;


---------------------------------------------------------------

-- MEMBER, CAR
-- 차주인이 누구인지
CREATE TABLE TBL_MEMBER(
	ID NUMBER,
	MEMBER_NAME VARCHAR(255),
	MEMBER_AGE NUMBER,
	CONSTRAINT PK_MEMBER PRIMARY KEY(ID)
);

CREATE TABLE TBL_CAR(
	ID NUMBER,
	MEMBER_ID NUMBER,
	CAR_BRAND VARCHAR2(255),
	CAR_COLOR VARCHAR2(255),
	CAR_PRICE NUMBER,
	CAR_RELEASE_DATE DATE,
	CONSTRAINT FK_CAR_MEMBER FOREIGN KEY(MEMBER_ID)
	REFERENCES TBL_MEMBER(ID)
);


-------------------------------------------------------
-- COMPANY(회사) PK
-- 이름, 전화번호
CREATE TABLE TBL_COMPANY(
	ID NUMBER,
	COMPANY_NAME VARCHAR2(255),
	COMPANY_PHONE VARCHAR2(255),
	CONSTRAINT PK_COMPANY PRIMARY KEY(ID)
);

-- ADVER(광고) FK
-- 이름, 컨텐츠
CREATE TABLE TBL_ADVER(
	ID NUMBER,
	COMPANY_ID NUMBER,
	ADVER_NAME VARCHAR2(255),
	ADVER_CONTENT VARCHAR2(255),
	CONSTRAINT PK_ADVER PRIMARY KEY(ID),
	CONSTRAINT FK_ADVER_COMPANY FOREIGN KEY(COMPANY_ID)
	REFERENCES TBL_COMPANY(ID)
);

-------------------------------------------------------------

-- 요구사항
-- 상품 판매자(TBL_SELLER)가 상품 구매자(TBL_BUYER)에게
-- 배송할 수 있는 배송기능(TBL_DELEVERY)이 필요해요.

CREATE TABLE TBL_PRODUCT(
	ID NUMBER,
	PRODUT_DRINK VARCHAR2(255) NOT NULL UNIQUE,
	PRODUCT_TYPE VARCHAR2(255),
	CONSTRAINT PK_PRODUCT PRIMARY KEY(ID)
);


-- 판매자 : 음료, 음료 종류, 음료수 크기, 만든 날짜
CREATE TABLE TBL_SELLER(
	ID NUMBER,
	PRODUCT_ID NUMBER,
	SELLER_DRINK VARCHAR2(255) NOT NULL,
	SELLER_TYPE VARCHAR2(255) UNIQUE,
	SELLER_VOLUME NUMBER DEFAULT '1.5',
	SELLER_MAKE_DAY TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT PK_SELLER PRIMARY KEY(ID),
	CONSTRAINT FK_SELLER_PRODUCT FOREIGN KEY(PRODUCT_ID)
	REFERENCES TBL_PRODUCT(ID)
);

-- 구매자 : 이름, 전화번호, 주소
CREATE TABLE TBL_BUYER(
	ID NUMBER,
	BUYER_NAME VARCHAR2(255),
	BUYER_PHONE VARCHAR2(255),
	BUYER_ADDRESS VARCHAR2(255),
	CONSTRAINT PK_BUYER PRIMARY KEY(ID)
);

CREATE TABLE TBL_DELEVERY(
	ID NUMBER,
	BUYER_ID NUMBER,
	SELLER_ID NUMBER,
	CONSTRAINT PK_DELEVERY PRIMARY KEY(ID),
	CONSTRAINT FK_DELEVERY_BUYER FOREIGN KEY(BUYER_ID)
	REFERENCES TBL_BUYER(ID),
	CONSTRAINT FK_DELEVERY_SELLER FOREIGN KEY(SELLER_ID)
	REFERENCES TBL_SELLER(ID)
);















































