<%@ page import="java.util.Random" %>
<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous"/>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="views/style.css">
    <script>
        var stt=0;
        var stt_room = 0;
    </script>
    <title>Demoverse Homepage</title>
    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            background-color: #f1f1f1;
        }

        li a{
            font-size:  24px;
            font-weight: 600;;
            display: block;
            color: #000;
            padding: 8px 16px;
            text-decoration: none;
            width: 1510px;
        }

        /* Change the link color on hover */
        li a:hover {
            background-color: #555;
            color: white;
        }

        div li:hover{
            background-color: #00b8d4;
            color: white;
        }

        /*    banner create room*/
        .open-button {
            background-color: #555;
            color: white;
            padding: 16px 20px;
            border: none;
            cursor: pointer;
            opacity: 0.8;
            position: fixed;
            bottom: 23px;
            right: 28px;
            width: 280px;
        }

        /* The popup form - hidden by default */
        .form-popup {
            display: none;
            position: fixed;
            bottom: 0;
            right: 15px;
            border: 3px solid #f1f1f1;
            z-index: 9;
        }

        /* Add styles to the form container */
        .form-container {
            /*max-width: 300px;*/
            padding: 10px;
            background-color: white;
        }

        /* Full-width input fields */
        .form-container input[type=text], .form-container input[type=password] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            border: none;
            background: #f1f1f1;
        }

        /* When the inputs get focus, do something */
        .form-container input[type=text]:focus, .form-container input[type=password]:focus {
            background-color: #ddd;
            outline: none;
        }

        /* Set a style for the submit/login button */
        .form-container .btn {
            background-color: #04AA6D;
            color: white;
            padding: 16px 20px;
            border: none;
            cursor: pointer;
            width: 100%;
            margin-bottom:10px;
            opacity: 0.8;
        }

        /* Add a red background color to the cancel button */
        .form-container .cancel {
            background-color: red;
        }

        /* Add some hover effects to buttons */
        .form-container .btn:hover, .open-button:hover {
            opacity: 1;
        }
    </style>

</head>
<body style="padding-top: 3.5rem; background-image: url('https://file1.hutech.edu.vn/file/editor/homepage/stories/hinh77-afd/3.jpg')">
<%
    String username = null;
    Cookie[] cookies = request.getCookies();
    for (Cookie c:cookies) {
        if(c.getName().equals("username"))
        {
            username = c.getValue().replace("+"," ");
        }
    }
%>
<nav class="navbar navbar-expand-md fixed-top" style="border-bottom:  10px solid grey; border-left: 5px;border-right: 5px ">
    <a href="home" class="navbar-brand text-dark">Demoverse</a>
    <div class="collapse navbar-collapse" style = "align-items: center;">
        <ul class="display-center " >
            <li style="padding: 0;">
                <button class="btn btn-lg text-light font-weight-bold display-center new-meeting" style="background-color: #5f02ff; " onclick="load_room()">Room List</button>
            </li>
            <li>
                <form action="join" method="get" >
                    <ul class="" style="margin-top: 10px">
                        <span class="material-icons mr-2 ">keyboard</span>
                        <input name="meetingID" type="text" placeholder="Enter a code" style="
                                 margin-top:10px; width: 70%; box-sizing: border-box; " class="enter-code border-2 ">
                        <input style="margin-left: 36px; width: 70%" name="password_room" type="password" placeholder="Enter a password room if it private room">
                        <input class="text-dark btn text-light font-weight-bold cursor-pointer pl-2 join-action " style="background-color: #5f02ff;" type="submit" value="Join">
                    </ul>
                </form>
            </li>
            <li style="padding: 0;">
                <button onclick="openForm()" class="btn btn-lg text-light font-weight-bold display-center new-meeting" style="background-color: #5f02ff;"><span class="material-icons mr-2">video_call</span>Create Room</button>
            </li>
        </ul>
    </div>
    <div class="display-center btn btn-lg " data-id="profile" style="background-color:#5f02ff ;">
        <span class="material-icons mr-2">contacts</span>
        Profile
    </div>
</nav>
<main >

    <div style="position: absolute; left: 10px; top: 130px; text-align: center;">
        <ul>
            <c:forEach var="mainTopic" items="${mainTopics}">
                <li  id="${mainTopic.id_Topic}mt" readonly style="background-color: gray; margin-top: 5px; margin-bottom: 7px;" ><a >${mainTopic.name_Topic}</a></li>
                <div class="${mainTopic.id_Topic}mt mb-3"></div>
                <script>
                    var typeRooms=<%=request.getAttribute("typeRooms")%>;
                    var rooms=<%=request.getAttribute("rooms")%>;
                    $(document).on("click", "#${mainTopic.id_Topic}mt", function ()
                    {
                        var so_Phong=0;
                        typeRooms.forEach(t=>{
                            if(t.id_Topic == ${mainTopic.id_Topic})
                            {
                                var type_room_div = $(".room_all").clone();
                                type_room_div.removeClass("room_all").addClass("lan"+stt);
                                type_room_div.addClass("mb-3");
                                type_room_div.find("label").text(t.room_Type_Name);
                                $(".${mainTopic.id_Topic}mt").append(type_room_div);
                                rooms.forEach(r => {
                                    if(r.id_Type == t.id && r.state )
                                    {
                                        var div_room = $(".catetogory").clone();
                                        div_room.removeClass("catetogory").addClass("btn p-4");
                                        div_room.attr("href", "http://127.0.0.1:3000/index.html?meeting_id="+r.key_Room +"&user_id=<%=username%>");
                                        div_room.find("li").text("Phòng "+so_Phong);
                                        so_Phong++;
                                        $(".lan"+stt).append(div_room);
                                    }
                                })
                            }
                            stt++;
                        })
                    });
                </script>
            </c:forEach>
        </ul>
    </div>
    <div class="room_all" class="mb-3"><label></label><br></div>
    <div style="border: 5px solid black;display: none">
        <nav style="display: flex; position: relative;">
            <ul style="float: left;"  id="main">
                <a class="catetogory">
                    <li  style="border: 1px solid black; display: inline; margin-right: 5px; margin-left: 5px; align-items: center">repacetext</li>
                </a>
            </ul>
        </nav>
    </div>

    <%--    banner--%>
    <%--    <button class="open-button" onclick="openForm()">Open Form</button>--%>

    <div class="form-popup" id="myForm" style="bottom:300px;right: 400px; left: 400px; top: 150px">
        <form action="create_new_meeting" class="form-container" method="post">
            <h1 style="text-align: center; font-weight: bold; color: rgb(200,200,100)">ROOM INFORMATION</h1>

            <label style="text-underline: black"><b>Password for room</b></label>
            <input type="password" placeholder="Enter Password (10<= password <= 100 character)" name="password" minlength="10" && maxlength="100" required>
            <label style="font-weight: bold; text-underline: black" >Choose a type of room:</label>
            <select name="type_room" id="type_room_combobox" style="width: 100%; height: 35px;">
                <c:forEach var="type" items="${typeRooms_combobox}">
                    <option value="${type.id}" >${type.room_Type_Name}</option>
                </c:forEach>
            </select>
            <button type="submit" class="btn">Create</button>
            <button type="button" class="btn cancel" onclick="closeForm()">Cancel</button>
        </form>
    </div>
    <script>
        function openForm() {
            document.getElementById("myForm").style.display = "block";
        }

        function closeForm() {
            document.getElementById("myForm").style.display = "none";
        }
    </script>
</main>
<footer>

</footer>
<script>
    // var divs= $("#danhmuc").clone();
    // $("#2r").append(divs);
</script>
<script>
    $(function(){
        // $(document).on("click", ".join-meeting", function(){
        //     $(".enter-code").focus();
        // })
        // $(document).on("click", ".join-action", function(){
        //     var join_value = $('.enter-code').val();
        // var meetingUrl = window.location.origin+"?meetingID="+join_value;
        // // window.location.replace(meetingUrl);
        <%--            <% response.sendRedirect("http://127.0.0.1:3000/index.html?meetingID=345");%>--%>
//         })
        $(document).on("click", ".new-meeting", function(){
            // window.location = "http://localhost:8080/Demoverse_war_exploded/create_new_meeting";
            document.getElementsByClassName("new_meeting").style.display = "block";
        })

    })
    function load_room()
    {
        window.location = "http://localhost:8080/Demoverse_war_exploded/home"
    }

</script>
</body>
</html>
