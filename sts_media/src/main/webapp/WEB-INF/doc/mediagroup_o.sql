INSERT INTO mediagroup(mediagroupno, title)
VALUES((SELECT NVL(MAX(mediagroupno), 0)+1 as mediagroupno FROM mediagroup), '2010 Drive 擠學');
 
INSERT INTO mediagroup(mediagroupno, title)
VALUES((SELECT NVL(MAX(mediagroupno), 0)+1 as mediagroupno FROM mediagroup), '2011 Drive 擠學');
 
INSERT INTO mediagroup(mediagroupno, title)
VALUES((SELECT NVL(MAX(mediagroupno), 0)+1 as mediagroupno FROM mediagroup), '2012 Drive 擠學');
 
SELECT mediagroupno, title
FROM mediagroup
ORDER BY mediagroupno ASC;
 
 MEDIAGROUPNO TITLE
 ------------ -------------
            1 2010 Drive 擠學
            2 2011 Drive 擠學
            3 2012 Drive 擠學
            
機筍            
UPDATE mediagroup
SET title=?, poster=?, filename=?, filesize=?
WHERE mediano=? 

1) 餉薯
DELETE FROM mediagroup
WHERE mediagroupno = 1;