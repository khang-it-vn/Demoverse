<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous"/>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="views/style.css">
    <title>Demoverse Homepage</title>
</head>
<body style="padding-top: 3.5rem;">
<nav class="navbar navbar-expand-md fixed-top">
    <a href="#" class="navbar-brand text-dark">Demoverse</a>
    <div class="collapse navbar-collapse" style = "align-items: center;">
            <ul class="display-center " >
                <li style="padding: 0;">
                    <button class="btn btn-lg text-light font-weight-bold display-center new-meeting" style="background-color: #5f02ff;">Room List</button>
                </li>
               <form action="join" method="get" >
                     <li class="btn-lg btn-group-lg" style="margin-top: 10px">
                         <span class="material-icons mr-2 ">keyboard</span>
                         <input name="meetingID" type="text" placeholder="Enter a code" style="
                         margin-top:10px; width: 70%; box-sizing: border-box; " class="enter-code border-2 ">
                         <input class="text-dark btn text-light font-weight-bold cursor-pointer pl-2 join-action " style="background-color: #5f02ff;" type="submit" value="Join">
                     </li>
               </form>
                <li style="padding: 0;">
                    <button class="btn btn-lg text-light font-weight-bold display-center new-meeting" style="background-color: #5f02ff;"><span class="material-icons mr-2">video_call</span>Create Room</button>
                </li>
            </ul>
    </div>
    <div class="display-center btn btn-lg " data-id="profile" style="background-color:#5f02ff ;">
        <span class="material-icons mr-2">contacts</span>
        Profile
    </div>
</nav>
<main>

</main>
<footer>

</footer>
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
            var eight_d_value = Math.floor(Math.random()*100000000);
            var meetingUrl = window.location.origin+"?meetingID="+eight_d_value;
            window.location.replace(meetingUrl);
        })

    })
</script>
</body>
</html>
