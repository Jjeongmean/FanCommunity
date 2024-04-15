DROP TABLE USERtable;
DROP SEQUENCE user_seq;
DROP TABLE USERtable CASCADE CONSTRAINTS;

-- USERtable 테이블 생성
CREATE TABLE USERtable (
    user_id NUMBER PRIMARY KEY,
    name VARCHAR2(255) NOT NULL,
    email VARCHAR2(255) NOT NULL,
    password VARCHAR2(255) NOT NULL,
    reg_date DATE NOT NULL
);

-- user_seq 시퀀스 생성
CREATE SEQUENCE user_seq
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    MAXVALUE 99999
    NOCYCLE
    NOCACHE
    NOORDER;

-- 데이터 삽입 쿼리 수정
INSERT INTO USERtable VALUES (user_seq.nextval, '최승철', 'coups@google.com', '0808', sysdate);
INSERT INTO USERtable VALUES (user_seq.nextval, '윤정한', 'hani@google.com', '1004', sysdate);
INSERT INTO USERtable VALUES (user_seq.nextval, '홍지수', 'acoustic@google.com', '1230', sysdate);
INSERT INTO USERtable VALUES (user_seq.nextval, '문준휘', 'junhui@google.com', '0610', sysdate);
INSERT INTO USERtable VALUES (user_seq.nextval, '권순영', 'ho5hi@google.com', '0615', sysdate);
INSERT INTO USERtable VALUES (user_seq.nextval, '전원우', 'eveyone_woo@google.com', '0717', sysdate);
INSERT INTO USERtable VALUES (user_seq.nextval, '이지훈', 'woozi@google.com', '1122', sysdate);
INSERT INTO USERtable VALUES (user_seq.nextval, '서명호', 'minghao@google.com', '1107', sysdate);
INSERT INTO USERtable VALUES (user_seq.nextval, '김민규', 'min9yu@google.com', '0406', sysdate);
INSERT INTO USERtable VALUES (user_seq.nextval, '이석민', 'dkisdk@google.com', '0218', sysdate);
INSERT INTO USERtable VALUES (user_seq.nextval, '부승관', 'feat.dino@google.com', '0116', sysdate);
INSERT INTO USERtable VALUES (user_seq.nextval, '최한솔', 'vernon@google.com', '0218', sysdate);
INSERT INTO USERtable VALUES (user_seq.nextval, '이찬', 'feat.dino@google.com', '0211', sysdate);

--UPDATE USERtable SET name = '최승철' WHERE name = '승철';
--UPDATE USERtable SET name = '전원우' WHERE name = '원우';
--UPDATE USERtable SET name = '이석민' WHERE name = '캐럿바라기';
--UPDATE USERtable SET name = '이찬' WHERE name = '막내의신';

COMMIT;

SELECT * FROM USERtable;

DROP TABLE Profile;
DROP SEQUENCE Profile_seq;
DROP TABLE Profile CASCADE CONSTRAINTS;

 CREATE TABLE Profile (
    profile_id NUMBER PRIMARY KEY NOT NULL,
    profile_name VARCHAR(255) NOT NULL,
    back_no VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    state NUMBER DEFAULT 1,
    reg_date DATE NOT NULL,
    update_date DATE,
    user_no NUMBER NOT NULL,
    hashtag_name VARCHAR(255) NOT NULL,
    CONSTRAINT FK_user_no FOREIGN KEY (user_no) REFERENCES UserTable(user_id)
    --CONSTRAINT FK_hashtag_name FOREIGN KEY (hashtag_name) REFERENCES hashtag(hashtag_name)
);

-- profile_seq 시퀀스 생성
CREATE SEQUENCE profile_seq
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    MAXVALUE 99999
    NOCYCLE
    NOCACHE
    NOORDER;

SELECT * FROM Profile;

--INSERT INTO Profile (profile_id, profile_name, back_no, birth_date, reg_date, update_date, user_no, hashtag_name
--VALUES (profile_seq.nextval, '프로필1', '12345', '1990-01-01', sysdate, sysdate, 1, SEVENTEEN);

INSERT INTO Profile (profile_id, profile_name, back_no, birth_date, reg_date, update_date, user_no, hashtag_name)
VALUES (profile_seq.nextval, '총괄리더', '00808', '1995-08-08', sysdate, null, 1, 'SEVENTEEN');

INSERT INTO Profile (profile_id, profile_name, back_no, birth_date, reg_date, update_date, user_no, hashtag_name)
VALUES (profile_seq.nextval, '정한', '01004', '1995-10-24', sysdate, null, 2, '세븐틴');

INSERT INTO Profile (profile_id, profile_name, back_no, birth_date, reg_date, update_date, user_no, hashtag_name)
VALUES (profile_seq.nextval, '조슈아', '01230', '1995-12-30', sysdate, null, 3, '17_IS_RIGHT_HERE');

INSERT INTO Profile (profile_id, profile_name, back_no, birth_date, reg_date, update_date, user_no, hashtag_name)
VALUES (profile_seq.nextval, '준', '00610', '1996-06-10', sysdate, null, 4, '세븐틴');

INSERT INTO Profile (profile_id, profile_name, back_no, birth_date, reg_date, update_date, user_no, hashtag_name)
VALUES (profile_seq.nextval, '호시', '00615', '1996-06-15', sysdate, null, 5, 'SEVENTEEN' );

INSERT INTO Profile (profile_id, profile_name, back_no, birth_date, reg_date, update_date, user_no, hashtag_name)
VALUES (profile_seq.nextval, '원우', '0717', '1996-07-17', sysdate, null, 6, '세븐틴');

INSERT INTO Profile (profile_id, profile_name, back_no, birth_date, reg_date, update_date, user_no, hashtag_name)
VALUES (profile_seq.nextval, '뉴우지', '1112', '1996-11-22', sysdate, null, 7, 'SEVENTEEN');

INSERT INTO Profile (profile_id, profile_name, back_no, birth_date, reg_date, update_date, user_no, hashtag_name)
VALUES (profile_seq.nextval, 'THE 8', '1107', '1997-11-07', sysdate, null, 8, '17_IS_RIGHT_HERE');

INSERT INTO Profile (profile_id, profile_name, back_no, birth_date, reg_date, update_date, user_no, hashtag_name)
VALUES (profile_seq.nextval, '27살김민규', '0406', '1997-04-06', sysdate, null, 9, '세븐틴');

INSERT INTO Profile (profile_id, profile_name, back_no, birth_date, reg_date, update_date, user_no, hashtag_name)
VALUES (profile_seq.nextval, '캐럿바라기', '0218', '1997-02-18', sysdate, null, 10, '17_IS_RIGHT_HERE');

INSERT INTO Profile (profile_id, profile_name, back_no, birth_date, reg_date, update_date, user_no, hashtag_name)
VALUES (profile_seq.nextval, '승관', '0116', '1998-01-16', sysdate, null, 11, '세븐틴');

INSERT INTO Profile (profile_id, profile_name, back_no, birth_date, reg_date, update_date, user_no, hashtag_name)
VALUES (profile_seq.nextval, '켄다마 기네스 기록 보유자 될 뻔', '0218', '1998-02-18', sysdate, null, 12, '17_IS_RIGHT_HERE');

INSERT INTO Profile (profile_id, profile_name, back_no, birth_date, reg_date, update_date, user_no, hashtag_name)
VALUES (profile_seq.nextval, '막내의신', '0211', '1999-02-11', sysdate, null, 13, '세븐틴');

DROP TABLE post;
DROP SEQUENCE post_seq;
DROP TABLE post CASCADE CONSTRAINTS;


CREATE TABLE post (
    post_id NUMBER PRIMARY KEY,
    profile_name VARCHAR2(255) NOT NULL, -- 프로필 이름 열 유지
    title VARCHAR2(255) NOT NULL,
    content CLOB NOT NULL,
    user_id NUMBER NOT NULL,
    write_date DATE NOT NULL,
    update_date DATE,
    likes NUMBER NOT NULL,
    hashtag_code VARCHAR2(255) NOT NULL,
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES USERtable(user_id)
);


-- post_seq 시퀀스 생성
CREATE SEQUENCE post_seq
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    MAXVALUE 99999
    NOCYCLE
    NOCACHE
    NOORDER;


INSERT INTO post (post_id, profile_name ,title, content, user_id, write_date, likes, hashtag_code)
VALUES (post_seq.nextval, '뉴우지', '김밍구우우', '추카햐ㅏㅏㅏ', 7, sysdate, 11122, '#');

INSERT INTO post (post_id, profile_name ,title, content, user_id, write_date, likes, hashtag_code)
VALUES (post_seq.nextval, '막내의신', '생', '축🖤', 13, sysdate, 10211, '#');

INSERT INTO post (post_id, profile_name ,title, content, user_id, write_date, likes, hashtag_code)
VALUES (post_seq.nextval, '27살김민규' ,'캐럿들', '굿나잇🖤', 9, sysdate, 10406, '#');

INSERT INTO post (post_id, profile_name ,title, content, user_id, write_date, likes, hashtag_code)
VALUES (post_seq.nextval, '원우' ,'캐럿들', '오늘 하루 잘 보내고 있나요?', 6, sysdate, 10717, '#');

INSERT INTO post (post_id, profile_name ,title, content, user_id, write_date, likes, hashtag_code)
VALUES (post_seq.nextval, '켄다마 기네스 기록 보유자 될 뻔', '민규형', '햎벌!', 12, sysdate, 10218, '#');

INSERT INTO post (post_id, profile_name ,title, content, user_id, write_date, likes, hashtag_code)
VALUES (post_seq.nextval, '캐럿바라기', '내 친구', '전화안받아', 10, sysdate, 10218, '#');

INSERT INTO post (post_id, profile_name ,title, content, user_id, write_date, likes, hashtag_code)
VALUES (post_seq.nextval, '호시', '오', '이거 너무 좋다', 5, sysdate, 10615, '#');

INSERT INTO post (post_id, profile_name ,title, content, user_id, write_date, likes, hashtag_code)
VALUES (post_seq.nextval, '승관', '캐럿들', '오늘 수고 많았어요!', 11, sysdate, 10116, '#');

INSERT INTO post (post_id, profile_name ,title, content, user_id, write_date, likes, hashtag_code)
VALUES (post_seq.nextval, '켄다마 기네스 기록 보유자 될 뻔', '생딸기우유', '맛있다', 12, sysdate, 10218, '#');

INSERT INTO post (post_id, profile_name ,title, content, user_id, write_date, likes, hashtag_code)
VALUES (post_seq.nextval, '총괄리더', '너무 늦은', '출사', 1, sysdate, 10808, '#');

INSERT INTO post (post_id, profile_name ,title, content, user_id, write_date, likes, hashtag_code)
VALUES (post_seq.nextval, '캐럿바라기', '아침 8시 운동 난 해냈다. 너무 대견하다 나 자신💪', '건강하게 운동하면 정신이 맑아져서 좋은 것 같아요 ㅎㅎ 캐럿들도 오운완 하자😉', 10, sysdate, 10218, '#');

INSERT INTO post (post_id, profile_name ,title, content, user_id, write_date, likes, hashtag_code)
VALUES (post_seq.nextval, '캐럿바라기', '부석순이들', '간다👍', 10, sysdate, 10218, '#');

INSERT INTO post (post_id, profile_name ,title, content, user_id, write_date, likes, hashtag_code)
VALUES (post_seq.nextval, '승관', '럿들아 다녀오마 ㅎ', '아 웅🖤', 11, sysdate, 10116, '#');

INSERT INTO post (post_id, profile_name ,title, content, user_id, write_date, likes, hashtag_code)
VALUES (post_seq.nextval, '정한',  '와 오늘 12시간잠ㅠ', '어제 너무힝두렀더ㅠ', 2, sysdate, 11004, '#');

INSERT INTO post (post_id, profile_name ,title, content, user_id, write_date, likes, hashtag_code)
VALUES (post_seq.nextval, '캐럿바라기', '잘', '도착했습니다 ㅎㅎ', 10, sysdate, 10218, '#');

INSERT INTO post (post_id, profile_name ,title, content, user_id, write_date, likes, hashtag_code)
VALUES (post_seq.nextval, '총괄리더', '나두 취미 찾아서...', '야구 팬이 되어볼까 해', 1, sysdate, 10808, '#');

INSERT INTO post (post_id, profile_name ,title, content, user_id, write_date, likes, hashtag_code)
VALUES (post_seq.nextval, '총괄리더', 'ㅇ ...ㅏ', '나중에 야구 보러만 갈게', 1, sysdate, 10808, '#');

INSERT INTO post (post_id, profile_name ,title, content, user_id, write_date, likes, hashtag_code)
VALUES (post_seq.nextval, '호시', 'ㅂ', 'ㅂㅅ', 5, sysdate, 10615, '#');


COMMIT;
SELECT * FROM post;

SELECT post_id, title, content, user_id, write_date, update_date, likes, hashtag_code
        FROM post
        WHERE profile_name = '정한';

DROP TABLE hashtag;
DROP SEQUENCE hashtag_seq;

-- hashtag 테이블 생성
CREATE TABLE hashtag (
    hashtag_id NUMBER PRIMARY KEY, -- 해시태그 고유 ID, 시퀀스를 이용하여 자동 증가
    hashtag_code VARCHAR2(255) NOT NULL,
    hashtag_name VARCHAR2(255) NOT NULL,
    post_id NUMBER, -- post_id 열 추가
    CONSTRAINT FK_post_id FOREIGN KEY (post_id) REFERENCES post(post_id)
);

-- hashtag_seq 시퀀스 생성
CREATE SEQUENCE hashtag_seq
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    MAXVALUE 99999
    NOCYCLE
    NOCACHE
    NOORDER;

-- 데이터 삽입 쿼리 수정
INSERT INTO hashtag (hashtag_id, hashtag_code, hashtag_name, post_id) VALUES (hashtag_seq.nextval, '#', 'SEVENTEEN', 1);
INSERT INTO hashtag (hashtag_id, hashtag_code, hashtag_name, post_id) VALUES (hashtag_seq.nextval, '#', '세븐틴', 2);
INSERT INTO hashtag (hashtag_id, hashtag_code, hashtag_name, post_id) VALUES (hashtag_seq.nextval, '#', '17_IS_RIGHT_HERE', 3);

-- 테이블 조회
SELECT * FROM hashtag;

 SELECT USER_ID,name, email
        FROM USERTABLE
        WHERE USER_ID = 1;

        SELECT post_id, title, content, user_id, write_date, update_date, likes, hashtag_code
        FROM post
        WHERE post_id = 1;

       SELECT post_id, title, content, user_id, write_date, update_date, likes, hashtag_code
        FROM post;


 DROP TABLE ProfileCategory;
DROP SEQUENCE ProfileCategory_seq;
DROP TABLE ProfileCategory CASCADE CONSTRAINTS;


 CREATE TABLE ProfileCategory (
 	profileCategory_no number PRIMARY KEY,
    category_name VARCHAR(255) NOT NULL
	);
CREATE SEQUENCE ProfileCategory_seq
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    MAXVALUE 99999
    NOCYCLE
    NOCACHE
    NOORDER;

INSERT INTO ProfileCategory (profileCategory_no, category_name)
VALUES (1, '피드');

INSERT INTO ProfileCategory (profileCategory_no, category_name)
VALUES (2, '아티스트');

INSERT INTO ProfileCategory (profileCategory_no, category_name)
VALUES (3, '미디어');

INSERT INTO ProfileCategory (profileCategory_no, category_name)
VALUES (4, '라이브');

INSERT INTO ProfileCategory (profileCategory_no, category_name)
VALUES (5, '샵');

SELECT * FROM  ProfileCategory;

DROP TABLE Profile CASCADE CONSTRAINTS;
DROP TABLE Profile;
DROP SEQUENCE profile_seq;




select profileCategory_no, category_name
        from profileCategory;

select profile_id,
               profile_name,
               back_no,
               birth_date,
               reg_date,
               update_date,
               user_no,
               hashtag_name
        from profile
        where user_no = 1
        order by back_no;

       SELECT * FROM PROFILE;




 update post set likes = likes + 1 where post_id = 1;

               SELECT post_id, title, content, user_id, write_date, update_date, likes, hashtag_code
        FROM post;


       SELECT * FROM post;


      SELECT * FROM (
        SELECT rownum rnum,  DATA .* from
        (    SELECT p.POST_ID , p.title, p.CONTENT, p.USER_ID,
        TO_CHAR(p.WRITE_DATE, 'YYYY-MM-DD') WRITE_DATE,
        TO_CHAR(P.UPDATE_DATE, 'YYYY-MM-DD')  UPDATE_DATE,
        P.likes, p.hashtag_code , h.hashtag_name
        FROM post p, hashtag h
        WHERE p.hashtag_code = h.hashtag_code
        AND p.USER_ID = 1
        AND p.title LIKE '%' || '' || '%'
        ORDER BY p.POST_ID DESC) DATA
        )

            WHERE rnum >= 1 AND rnum <= 3;
