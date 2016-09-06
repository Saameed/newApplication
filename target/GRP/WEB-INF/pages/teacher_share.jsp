<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>share</title>

    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/css/bootstrap.css">
    <link rel="stylesheet" href="../../resources/css/style.css">
    <link rel="stylesheet" href="../../resources/css/jquery.dataTable.css">

    <script src="../../resources/js/main.js" type="text/javascript"></script>
    <script src="../../resources/js/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="../../resources/js/jquery.min.js" type="text/javascript"></script>
    <script src="../../resources/js/jquery-ui.js" type="text/javascript"></script>
    <script src="../../resources/js/bootstrap.min.js" type="text/javascript"></script>

    <script type="text/javascript">

        $(function () {

            $("#search_group").click(function () {

                getStudentListforTeacher_Share($('select option:selected').val());
            });

        });
    </script>
    <style>

        .generic-container {
            margin-bottom: 25px;
            padding: 10px;
            border-radius: 4px;
            box-shadow: 0 0 40px black;
        }

    </style>

</head>
<body>

<div class="container-fluid generic-container" style="box-shadow: 0 0 25px black;">

    <div class="col-md-3" id="nnese">
        <label style="margin: auto;">Mövcud qruplariniz ...</label>
    </div>

    <c:if test="${!empty groups}">

        <div class="col-md-4" id="nese">
            <select class="form-control">
                <option value="">Qrup seçin...</option>
                <c:forEach items="${groups}" var="sub">
                    <option value="${sub.parentLesson.groups.id}">${sub.parentLesson.groups.name}</option>
                </c:forEach>
            </select>
        </div>

    </c:if>

    <div class="col-md-3" id="cc"></div>

    <div class="col-md-2">

        <input type="button" class="btn btn-primary" id="search_group" value="Axtar"
               style="width: 100%">

    </div>

</div>
<div id="teacher_share_students_div"></div>

</body>
</html>
