- ��ȸ
SELECT replyno, content, passwd, rdate, mediano
FROM reply
WHERE replyno = 1;

- �н����� �˻�
SELECT COUNT(replyno) as cnt
FROM reply
WHERE replyno=1 AND passwd='1234';

- ����
UPDATE reply
SET content = ''
WHERE replyno = 1;

- ��� ���
SELECT replyno, content, passwd, rdate, mediano
FROM reply
WHERE mediano = 10
ORDER BY replyno DESC;

- ���� ó��