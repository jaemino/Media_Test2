<%@ page contentType="text/html; charset=UTF-8" %>
 
<%@ page import="www.utility.Utility" %>
 
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
<%
String msg1 = (String)request.getAttribute("msg1");
String msg2 = (String)request.getAttribute("msg2");
String msg3 = (String)request.getAttribute("msg3");
String msg4 = (String)request.getAttribute("msg4");
String msg5 = (String)request.getAttribute("msg5");
 
String link1 = (String)request.getAttribute("link1");
String link2 = (String)request.getAttribute("link2");
String link3 = (String)request.getAttribute("link3");
String link4 = (String)request.getAttribute("link4");
String link5 = (String)request.getAttribute("link5");
 
out.println("<DL>");
if (msg1 != null){  // 메시지가 있는지 검사
  out.println("<DD> <img src='"+Utility.getRoot()+"/mediagroup/images/bu01.png'> " + msg1);  
}
if (msg2 != null){
  out.println("<DD> <img src='"+Utility.getRoot()+"/mediagroup/images/bu01.png'> " + msg2);  
}
if (msg3 != null){
  out.println("<DD> <img src='"+Utility.getRoot()+"/mediagroup/images/bu01.png'> " + msg3);  
}
if (msg4 != null){
  out.println("<DD> <img src='"+Utility.getRoot()+"/mediagroup/images/bu01.png'> " + msg4);  
}
if (msg5 != null){
  out.println("<DD> <img src='"+Utility.getRoot()+"/mediagroup/images/bu01.png'> " + msg5);  
}
 
out.println("</DL>");
 
out.println("<br><br>");
if (link1 != null){  // 링크나 버튼이 있는지 검사
  out.println(link1);  
}
if (link2 != null){ 
  out.println(link2);  
}
if (link3 != null){ 
  out.println(link3);  
}
if (link4 != null){ 
  out.println(link4);  
}
if (link5 != null){ 
  out.println(link5);  
}
 
%>
</div>
</body>
</html>