<%@ page contentType="text/html; charset=UTF-8" %> 
<% request.setCharacterEncoding("utf-8"); %> 
 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title>Create Media group</title> 
<style type="text/css"> 
*{ 
  font-family: gulim; 
  font-size: 20px; 
} 
</style> 
<link href="../css/style.css" rel="Stylesheet" type="text/css">
</head> 
<body>
 
<DIV class="title">Create Media group</DIV>
 
<FORM name='frm' method='POST' action='./create.do'>
  <TABLE class='table'>
    <TR>
      <TH>Media group name</TH>
      <TD><input type='text' name='title' size='50' value=''></TD>
    </TR>
  </TABLE>
  
  <DIV class='bottom'>
    <input type='submit' value='Submit'>
    <input type='button' value='Media group List' onclick="location.href='./list.do'">
  </DIV>
</FORM>
 
</body> 
</html> 