- 조회
SELECT replyno, content, passwd, rdate, mediano
FROM reply
WHERE replyno = 1;

- 패스워드 검사
SELECT COUNT(replyno) as cnt
FROM reply
WHERE replyno=1 AND passwd='1234';

- 수정
UPDATE reply
SET content = ''
WHERE replyno = 1;

- 목록 출력
SELECT replyno, content, passwd, rdate, mediano
FROM reply
WHERE mediano = 10
ORDER BY replyno DESC;

- 수정 처리