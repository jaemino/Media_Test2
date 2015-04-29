<%@ page contentType="text/html; charset=UTF-8" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Media group</title>
<style type="text/css">
*{
  font-family: ;
  font-size: 24px;
}
</style>
<link href="../css/style.css" rel="Stylesheet" type="text/css">
</head>
<body>
 
<DIV class='title'>Update Media group</DIV>
 
<FORM name='frm' method='POST' action='./update.do'>
  <input type='hidden' name='mediagroupno' value='${dto.mediagroupno }'>
 
  <TABLE align='center' border='1px' cellspacing='0px' cellpadding='5px'>
    <TR>
      <TH>Media group title</TH>
      <TD><INPUT type='text' name='title' size='50' value='${dto.title }'></TD>    
    </TR>
  </TABLE>    
 
  <DIV class='bottom'>
    <input type='submit' value='Update'>
    <input type='button' value='Media group List' onclick="location.href='./list.do'">
  </DIV>
</FORM>
 
</body>
</html>