<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="sts.blog.media.MediaDTO" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Media</title>
<style type="text/css">
*{
  font-family: ;
  font-size: 24px;
}
</style>
<link href="../css/style.css" rel="Stylesheet" type="text/css">
</head>
<body>
 
<DIV class='title'>Update Media</DIV>
 
<FORM name='frm' method='POST' action='./update.do'
      enctype='multipart/form-data'>
  <input type='hidden' name='mediagroupno' value='${dto.mediagroupno }'>
  <input type='hidden' name='mediano' value='${dto.mediano }'>
  
  <TABLE align='center' border='1px' cellspacing='0px' cellpadding='5px'>
    <TR>
      <TH>Title</TH>
      <TD><INPUT type='text' name='title' size='50' value='${dto.title }'></TD>    
    </TR>
    <TR>
      <TH>Poster</TH>
      <TD>
      Uploaded Poster name: ${dto.poster }<br>
      <INPUT type='file' name='posterMF' size='50'></TD>    
    </TR>
    <TR>
      <TH>Media File</TH>
      <TD>
      Uploaded File name: ${dto.filename }<br>
      <INPUT type='file' name='filenameMF' size='50'></TD>    
    </TR>    
    
  </TABLE>    
 
  <DIV class='bottom'>
    <input type='submit' value='Update'>
    <input type='button' value='List' onclick="location.href='./list.do?mediagroupno=${dto.mediagroupno }'">
  </DIV>
</FORM>
 
</body>
</html>