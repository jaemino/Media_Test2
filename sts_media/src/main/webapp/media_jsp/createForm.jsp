<%@ page contentType="text/html; charset=UTF-8" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Media Upload</title>
<style type="text/css">
*{
  font-family: gulim;
  font-size: 20px;
}
</style>
<link href="../css/style.css" rel="Stylesheet" type="text/css">
</head>
<body>
 
<DIV class='title'>Media Upload</DIV>
 
<FORM name='frm' method='POST' action='./create.do'
      enctype='multipart/form-data'>
  <input type='hidden' name='mediagroupno' value='${mediagroupno }'>
  
  <TABLE align='center' border='1px' cellspacing='0px' cellpadding='5px'>
    <TR>
      <TH>Title</TH>
      <TD><INPUT type='text' name='title' size='50' value='mp3'></TD>    
    </TR>
    <TR>
      <TH>Poster</TH>
      <TD><INPUT type='file' name='posterMF' size='50'></TD>    
    </TR>
    <TR>
      <TH>Media file</TH>
      <TD><INPUT type='file' name='filenameMF' size='50'></TD>    
    </TR>    
    
  </TABLE>    
 
  <DIV class='bottom'>
    <input type='submit' value='Submit'>
    <input type='button' value='List' onclick="location.href='./list.do?mediagroupno=${mediagroupno }'">
  </DIV>
</FORM>
 
</body>
</html>