<%@ page contentType="text/html; charset=UTF-8" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alert</title>
<style type="text/css">
*{
  font-family: ;
  font-size: 24px;
}
</style>
<link href="../css/style.css" rel="Stylesheet" type="text/css">
</head>
<body>
<div style="text-align: center; font-size: 2em;">Alert</div>
  
<div style="width: 100%; text-align: center; margin: 0 auto; font-size: 20px">
  <DL>
    <DD> ${msg1 != null ? img : "" } ${msg1}
    <DD> ${msg2 != null ? img : "" } ${msg2}
    <DD> ${msg3 != null ? img : "" } ${msg3}
    <DD> ${msg4 != null ? img : "" } ${msg4}
    <DD> ${msg5 != null ? img : "" } ${msg5}
  </DL>
  
 <br><br>
  ${link1 } ${link2 } ${link3 } ${link4 } ${link5 }
  
</div>
</body>
</html>