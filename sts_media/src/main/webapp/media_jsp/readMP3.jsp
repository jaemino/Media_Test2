<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="sts.blog.media.MediaDTO" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
*{
  font-family: ;
  font-size: 24px;
}
</style>
<link href="../css/style.css" rel="Stylesheet" type="text/css">
</head>
<body>
 
<DIV class='title'>MP3 Player</DIV>
 
<DIV class='content'>
  ${dto.title }<br><br>
  <IMG src='./storage/${dto.poster }' width='500px'><br>
  <audio controls autoplay id="audio1" src="./storage/${dto.filename }" />
</DIV>
 
<FORM name='frm' method='POST' action=''>
 
  <DIV class='bottom'>
    <input type='button' value='Update' 
           onclick="location.href='./update.do?mediano=${dto.mediano }'">
    <input type='button' value='List' 
           onclick="location.href='./list.do?mediagroupno=${dto.mediagroupno }'">
  </DIV>
</FORM>
 
</body>
</html>