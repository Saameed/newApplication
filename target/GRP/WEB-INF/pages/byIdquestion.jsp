<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2016-08-24
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question</title>

    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/css/bootstrap.css">
    <link rel="stylesheet" href="../../resources/css/style.css">
    <link rel="stylesheet" href="../../resources/css/jquery.dataTable.css">

    <script src="../../resources/js/main.js" type="text/javascript"></script>
    <script src="../../resources/js/jquery.min.js" type="text/javascript"></script>
    <script src="../../resources/js/bootstrap.min.js" type="text/javascript"></script>

    <script type="text/javascript">

        $(function () {


            let url = new URL('http://localhost:8084/blog/question?id=1'); // window.location
            let params = new URLSearchParams(url.search.slice(1));
            alert(params.get('id'));


            $("#add_answer").click(function () {

                var userName = $("#userName_id").val();
                var email = $("#email_id").val();
                var description = $("#description_id").val();

                $.ajax({
                    url: "/blog/add-answer",
                    data: "userName=" + userName + "&email=" + email + "&description=" + description,
                    dataType: "html",
                    type: "POST",

                    success: function (data) {
                        location.reload();
                    }
                });
            });
        });

    </script>

    <style>
        .generic-container {
            margin-bottom: 25px;
            padding: 10px;
            border-radius: 4px;
            box-shadow: 0 0 8px black;
        }
    </style>

</head>
<body>

<div class="container-fluid" style="height: 100%">

    <div class="row generic-container">

        <p style="color: #00AB66;font-style: italic;font-weight: bold;">Hörmətli istifadəçi əgər verdiyiniz sualin
            cavabı sizə aydın deyilsə və ya
            sualla bağlı hər hansı əlavəniz varsa,səyfənin aşağı hissesində müvafiq yerdən,
            yeni sual əlavə edən zaman istifadə etdiyiniz emaili istifadə etmək şərti ilə əlavənizi yazıb bizə göndərə
            bilərsiniz.</p>

    </div>

    <c:if test="${! empty question_title}">
        <h4><a href="/blog/welcome"><span class="label label-default"> << Geri qayıt </span></a></h4>
        <h5 style="text-align: center"><p class=""> ${question_title}</p></h5>
        <h4 style="text-align: center;font-weight: bold;"><p class=""> ${question_text}</p></h4>
    </c:if>

    <div class="col-md-1"></div>

    <div class="col-md-10">

        <br>
        <table class="table" id="Tables-laboratory">
            <thead>
            <tr>
                <td><h3 style="color: #005f81">Cavablar </h3></td>
            </tr>
            </thead>

            <tbody>
            <c:if test="${!empty answers}">
                <c:forEach items="${answers}" var="answers">
                    <tr>
                        <td>${answers.description}</td>
                        <td>Tarix: ${answers.date}</td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
    </div>
    <div class="col-md-1"></div>
    <hr style="color: #005f81;width: 100%;">


</div>
<div class="col-md-12" style="box-shadow: 0 0 15px black;">
    <div class="col-md-6" style="height: 150px">
        <div class="form-group">
            <label for="userName_id">Full Name:</label>
            <input type="text" class="form-control" name="userName" id="userName_id">
        </div>
        <div class="form-group">
            <label for="email_id">Email:</label>
            <input type="text" class="form-control" name="email" id="email_id">
        </div>

    </div>
    <div class="col-md-6">
        <div class="form-group">
            <label for="description_id">Answer Text:</label>
            <textarea class="form-control" rows="5" id="description_id"></textarea>
        </div>
        <input type="button" class="btn btn-default" value="add answer" id="add_answer">
    </div>
</div>

</body>
</html>
