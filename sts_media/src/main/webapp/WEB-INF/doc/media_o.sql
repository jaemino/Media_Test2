1) 테이블 삭제
DROP TABLE reply;
DROP TABLE media;
DROP TABLE mediagroup;
 
 
2) mp3, mp4 그룹핑 테이블
CREATE TABLE mediagroup(
  mediagroupno NUMBER(7)     NOT NULL PRIMARY KEY, -- 그룹 번호
  title        VARCHAR2(100) NOT NULL -- 그룹 제목
);
 
 
3) 데이터 테이블
CREATE TABLE media(
  mediano      NUMBER(7)     NOT NULL PRIMARY KEY, -- 미디어 번호
  title        VARCHAR2(300) NOT NULL,             -- 제목
  rdate        DATE          NOT NULL,             -- 등록일
  poster                     VARCHAR2(50) DEFAULT 'poster.jpg' NOT NULL, -- 포스터
  filename                   VARCHAR2(100) NOT NULL,  -- 파일명
  filesize                   NUMBER(10)   DEFAULT 0 NOT NULL,   -- 파일 사이즈
  mview                      CHAR(1)      DEFAULT 'Y' NOT NULL, -- 출력 모드
  mediagroupno               NUMBER(7)    NULL       -- 그룹 번호
);
 
 
4) 댓글 테이블
CREATE TABLE reply(
  replyno      NUMBER(10)    NOT NULL PRIMARY KEY, -- 댓글 번호
  content      VARCHAR2(300) NOT NULL,             -- 댓글 내용 
  passwd       VARCHAR2(15)  NOT NULL,             -- 패스워드  
  rdate        Date          NOT NULL,             -- 등록일
  mediano      NUMBER(7)     NULL                  -- 미디어 번호
);

1. 등록
INSERT INTO media(mediano, 
           title, rdate, poster, filename, filesize, mview, mediagroupno)
VALUES((SELECT NVL(MAX(mediano), 0)+1 as mediano FROM media),
           'LaSong - 비', sysdate, 'poster.jpg', 'lasong.mp3', 15000, 'Y', 1);
 
INSERT INTO media(mediano, 
           title, rdate, poster, filename, filesize, mview, mediagroupno)
VALUES((SELECT NVL(MAX(mediano), 0)+1 as mediano FROM media),
           'LaSong - 비', sysdate, 'poster.jpg', 'lasong.mp3', 15000, 'Y', 1);
 
INSERT INTO media(mediano, 
           title, rdate, poster, filename, filesize, mview, mediagroupno)
VALUES((SELECT NVL(MAX(mediano), 0)+1 as mediano FROM media),
           'LaSong - 비', sysdate, 'poster.jpg', 'lasong.mp3', 15000, 'Y', 1);
 
 
2. 목록
SELECT mediano, title, rdate, poster, filename, filesize, mview, mediagroupno
FROM media
ORDER BY mediano DESC;
 
 MEDIANO TITLE      RDATE                 POSTER     FILENAME   FILESIZE MVIEW MEDIAGROUPNO
 ------- ---------- --------------------- ---------- ---------- -------- ----- ------------
       1 LaSong - 비 2014-04-17 18:33:43.0 poster.jpg lasong.mp3    15000 Y                1
       2 LaSong - 비 2014-04-17 18:34:08.0 poster.jpg lasong.mp3    15000 Y                1
       3 LaSong - 비 2014-04-17 18:34:10.0 poster.jpg lasong.mp3    15000 Y                1
 
3. 조회
SELECT mediano, title, rdate, poster, filename, filesize, mview, mediagroupno
FROM media
WHERE mediano=1;
 
 MEDIANO TITLE      RDATE                 POSTER     FILENAME   FILESIZE MVIEW MEDIAGROUPNO
 ------- ---------- --------------------- ---------- ---------- -------- ----- ------------
       1 LaSong - 비 2014-04-17 18:33:43.0 poster.jpg lasong.mp3    15000 Y                1
       

4. 수정       
UPDATE media
SET title=?, poster=?, filename=?, filesize=?
WHERE mediano=?        
       
5. 삭제
DELETE FROM media
WHERE mediano=?
       