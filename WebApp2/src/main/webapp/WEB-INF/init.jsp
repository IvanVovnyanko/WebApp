<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Text Adventure</title>
</head>
<body>
<h1>Initializing...</h1>
<%-- Here you can include a loading animation or any other content --%>
<%
    // Redirect to the play page after initialization
    response.sendRedirect(request.getContextPath() + "/play");
%>
</body>
</html>
