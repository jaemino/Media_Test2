<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="sts.blog.media.MediaDTO" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
*{
  font-family: gulim;
  font-size: 20px;
}
</style>
<link href="../css/style.css" rel="Stylesheet" type="text/css">
</head>
<body>
 
<DIV class='title'>List</DIV>
 
<FORM name='frm' method='POST' action=''>
  <TABLE align='center' border='1px' cellspacing='0px' cellpadding='5px'>
    <TR>
      <TH>Media Number</TH>
      <TH>Poster</TH>
      <TH>Title</TH>
      <TH>Date of upload</TH>
      <TH>Media File</TH>
      <TH>Action</TH>
    </TR>
    <%
    ArrayList list = (ArrayList)request.getAttribute("list");
    for(int i=0; i<list.size(); i++){
      MediaDTO dto = (MediaDTO)list.get(i);
      int mediano = dto.getMediano();
    %>
    <TR>
      <TD><%=mediano %></TD>
      <TD><%=dto.getPoster() %></TD>
      <TD><A href='./read.do?mediano=<%=mediano %>'><%=dto.getTitle() %></A></TD>
      <TD><%=dto.getRdate() %></TD>
      <TD><%=dto.getFilename() %> (<%=dto.getFilesize() %>)</TD>
      <TD>
        <input type='button' value='Update' onclick="location.href='./update.do?mediano=<%=mediano %>&mediagroupno=${mediagroupno }'">
        <input type='button' value='Delete' onclick="location.href='./delete.do?mediano=<%=mediano %>&mediagroupno=${mediagroupno }'">  
      </TD>
    </TR>
    <%
    }
    %>
  </TABLE>
 
  <DIV class='bottom'> 
    <input type='button' value='Upload' onclick="location.href='./create.do?mediagroupno=${mediagroupno }'">
    <input type='button' value='Mediagroup List' onclick="location.href='../mediagroup/list.do'">
  </DIV>
</FORM>
 
</body>
</html>