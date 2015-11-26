<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="sts.blog.mediagroup.MediagroupDTO" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Media group List</title>
<style type="text/css">
*{
  font-family: gulim;
  font-size: 20px;
}
</style>
<link href="../css/style.css" rel="Stylesheet" type="text/css">
</head>
<body>
 
<DIV class='title'>Media group List</DIV>
 
<FORM name='frm' method='POST' action=''>
  <TABLE width='50%' align='center' border='1px' cellspacing='0px' cellpadding='5px'>
    <TR>
      <TH>Media group Number</TH>
      <TH>Media group name</TH>
      <TH>Action</TH>
    </TR>
    <%
    ArrayList list = (ArrayList)request.getAttribute("list");
    for(int i=0; i<list.size(); i++){
      MediagroupDTO dto = (MediagroupDTO)list.get(i);
    %>
    <TR>
      <TD><%=dto.getMediagroupno() %></TD>
      <TD><A href='../media/list.do?mediagroupno=<%=dto.getMediagroupno() %>'><%=dto.getTitle() %></A></TD>
      <TD>
        <input type='button' value='Update' onclick="location.href='./update.do?mediagroupno=<%=dto.getMediagroupno() %>'">
        <input type='button' value='Delete' onclick="location.href='./delete.do?mediagroupno=<%=dto.getMediagroupno() %>'">
      </TD>
    </TR>
    <%
    }
    %>
  </TABLE>
 
  <DIV class='bottom'>
    <input type='button' value='Create Media group' onclick="location.href='./create.do'">
  </DIV>
</FORM>
 
</body>
</html>