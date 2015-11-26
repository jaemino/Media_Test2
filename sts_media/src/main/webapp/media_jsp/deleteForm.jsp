<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="sts.blog.media.MediaDTO" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Media Delete</title>
<style type="text/css">
*{
  font-family: ;
  font-size: 24px;
}
</style>
<link href="../css/style.css" rel="Stylesheet" type="text/css">
</head>
<body>
 
<DIV class='title'>Delete Media</DIV>
 
<FORM name='frm' method='POST' action='./delete.do' >
  <input type='hidden' name='mediagroupno' value='${dto.mediagroupno }'>
  <input type='hidden' name='mediano' value='${dto.mediano }'>
  
  <DIV class='content'>
    Cannot be restored.<br><br>
    If you want to delete please proceed.<br><br>
  </DIV>   
 
  <DIV class='bottom'>
    <input type='submit' value='Delete'>
    <input type='button' value='List' onclick="location.href='./list.do?mediagroupno=${dto.mediagroupno }'">
  </DIV>
</FORM>
 
</body>
</html>