<%@ page import="java.util.Random" %>
<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
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
            background-color: lightblue;
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
<body style="padding-top: 3.5rem; ">
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
<nav class="navbar navbar-expand-md fixed-top bg-light" style="  ">
    <a href="home" class="navbar-brand text-dark" style="text-shadow: 0 0 3px #b8daff, 0 0 5px black">Demoverse</a>
    <div class="collapse navbar-collapse navbar-light bg-light" style="">
        <btn style="padding: 0;">
            <button class="btn btn-lg text-light font-weight-bold display-center new-meeting" style="background-color: #00b8d4; " onclick="load_room()">Room List</button>
        </btn>
        <ul class="display-center bg-light" >
            <form action="join" class="bg-light" method="get" style="width: 680px">
                <ul class="" style="margin-top: 10px">
                    <li style="display: inline; ">
                        <span class="material-icons mr-2 ">keyboard</span>
                    </li>
                    <li style="display: inline; ">
                        <input style="width: 35%" name="meetingID" type="text" placeholder="Enter a code"  class="enter-code border-2 " value="">
                    </li>
                    <li style="display: inline; margin-left: 5px; ">
                        <input  name="password_room" type="password" placeholder="Enter password room ">
                    </li>
                    <li style="display: inline; margin-left: 10px; background-color: #00b8d4" class="btn" >
                        <input style="background-color: #00b8d4; border: none" class=" text-light font-weight-bold cursor-pointer pl-2 join-action " type="submit" value="Join">
                    </li>
                   </ul>
            </form>
        </ul>
        <btn style="padding: 0; margin-left: 20px">
            <button onclick="openForm()" class="btn btn-lg text-light font-weight-bold display-center new-meeting" style="background-color: #00b8d4;"><span class="material-icons mr-2">video_call</span>Create Room</button>
        </btn>
    </div>
    <div class="display-center btn btn-lg " data-id="profile" style="background-color:#00b8d4 ;">
        <span class="material-icons mr-2">contacts</span>
        Profile
    </div>
</nav>
<main >
<script>
    let state = true;
    var typeRooms=<%=request.getAttribute("typeRooms")%>;
    var rooms=<%=request.getAttribute("rooms")%>;
    var typeRoom_Loaded = [];
</script>
    <div style="position: absolute; left: 10px; top: 130px; ">
        <ul>
            <c:forEach var="mainTopic" items="${mainTopics}">
                <li  id="${mainTopic.id_Topic}mt" readonly style="background-color: lightgrey; margin-top: 5px; margin-bottom: 7px; " >
                    <a >${mainTopic.name_Topic}</a>
                </li>
                <li class="btn close-${mainTopic.id_Topic}" style="color: black; font-weight: bold; font-size: 16px; display: none;">
                    X
                </li>
                <div class="${mainTopic.id_Topic}mt mb-3 bg-light"></div>
                <script>
                    $(document).on("click", "#${mainTopic.id_Topic}mt", function ()
                    {
                        typeRooms.forEach(t=>{
                            if(!typeRoom_Loaded.find(e => e == t.id))
                            {
                                if(t.id_Topic == ${mainTopic.id_Topic})
                                {
                                    typeRoom_Loaded.push(t.id);
                                    var type_room_div = $(".room_all").clone();
                                    type_room_div.removeClass("room_all").addClass("lan"+stt);
                                    type_room_div.addClass("mb-3");
                                    type_room_div.find("label").text(t.room_Type_Name);
                                    $(".${mainTopic.id_Topic}mt").append(type_room_div);
                                    var so_Phong=0;
                                    rooms.forEach(r => {
                                        if(r.id_Type == t.id && r.state )
                                        {
                                            var div_room = $(".catetogory").clone();
                                            div_room.removeClass("catetogory").addClass("btn p-4 m-2 border-2 border-warning");
                                            div_room.attr("href", "http://127.0.0.1:3000/index.html?meeting_id="+r.key_Room +"&user_id=<%=username%>");
                                            div_room.find("li").text("Phòng "+so_Phong);
                                            so_Phong++;
                                            $(".lan"+stt).append(div_room);
                                        }
                                    })
                                }
                                stt++;
                            }
                        })
                        let name_elenment = "" + ${mainTopic.id_Topic} + "mt";
                        $("." + name_elenment).attr("style","display: block");
                        $(".close-" +${mainTopic.id_Topic}).attr("style","display: flex");
                    });
                </script>
                    <script>
                        $(document).on("click", ".close-${mainTopic.id_Topic}", function () {
                                let name_elenment = "" + ${mainTopic.id_Topic} + "mt";
                                $("." + name_elenment).attr("style","display: none");
                                $(this).attr("style","display: none");

                        });
                    </script>
            </c:forEach>
        </ul>
    </div>
    <div class="room_all" class="mb-3"><label></label><br></div>
    <div style="border: 5px solid black;display: none">
        <nav style="display: flex; position: relative;">
            <ul style="float: left;"  id="main">
                <a class="catetogory" style="width: 169px; height: 90px; background-image: url('public/Assets/images/img.png'); background-size: 169px">
                    <li  style=" display: inline; margin-right: 5px; margin-left: 5px; font-weight: bolder; color: black ">replacetext</li>
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
            <button style="width: 50%; float: left" type="submit" class="btn">Create</button>
            <button style="width: 50%; float: left" type="button" class="btn cancel" onclick="closeForm()">Cancel</button>
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
