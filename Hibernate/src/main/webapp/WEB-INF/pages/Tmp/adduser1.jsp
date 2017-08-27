<%@page import="net.proselyte.hibernate.HelloController"%>
<jsp:useBean id="u" class="net.proselyte.hibernate.annotations.Developer"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
int i = HelloController.class.(u);
if(i>0){
response.sendRedirect("adduser-success.jsp");
}else{
response.sendRedirect("adduser-error.jsp");
}
%>