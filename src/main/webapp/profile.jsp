<%@ page import="com.Demoverse.Entities.Users" %>
<%
    Users user = (Users) request.getAttribute("user");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lập trình web - design UI</title>
    <link rel="stylesheet" href="public/Assets/css/profile.css">
</head>
<body>
<button onclick="back()">Back</button>
<script>
    function back()
    {
        window.location.href = "home";
    }
</script>
    <form action="update-info" method="get" >
        <div id="head">
            <div id="update">
                <input type="submit" value="Cập nhật" style="border: none">
            </div>
            <div id="head-img">
                <img src="public/Assets/images/avartar.png">
            </div>
            <div id="hoten" >
                <input type="text" size="18"  value="<%=user.getUsername()%>" name="hoten">
            </div>
        </div>
        <div id="content">
            <div>
                <label>Email:</label>
                <input type="text" value="<%=user.getEmail()%>" size="30" readonly name="email">
            </div>
            <hr>
            <div>
                <label>Introduce:</label>
                <textarea name="introduce">
                    <%=user.getIntroduce()%>
                </textarea>
            </div>
        </div>
    </form>
</body>
</html>
