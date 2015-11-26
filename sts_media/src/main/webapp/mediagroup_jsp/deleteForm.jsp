<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="sts.blog.mediagroup.MediagroupDTO" %>

 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Media group</title>
<style type="text/css">
*{
  font-family: ;
  font-size: 24px;
}
</style>
<link href="../css/style.css" rel="Stylesheet" type="text/css">
</head>
<body>
 
<DIV class='title'>Delete Media group</DIV>
 
<FORM name='frm' method='POST' action='./delete.do'>
  <input type='hidden' name='mediagroupno' value='${dto.mediagroupno }'>
 
    <div class='content'>
      Do you want to delete the media group? <br><br>
      All media related are being erased. <br><br>
    </div> 
 
  <DIV class='bottom'>
    <input type='submit' value='Delete'>
    <input type='button' value='Media group List' onclick="location.href='./list.do'">
  </DIV>
</FORM>
 
</body>
</html>