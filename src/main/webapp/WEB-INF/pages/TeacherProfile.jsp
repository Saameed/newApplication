<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Teacher Profile</title>

    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/css/bootstrap.css">
    <link rel="stylesheet" href="../../resources/css/style.css">
    <link rel="stylesheet" href="../../resources/css/jquery.dataTable.css">

    <script src="../../resources/js/main.js" type="text/javascript"></script>
    <script src="../../resources/js/jquery.min.js" type="text/javascript"></script>
    <script src="../../resources/js/jquery-1.12.3.js" type="text/javascript"></script>
    <script src="../../resources/js/jquery.dataTablee.min.js" type="text/javascript"></script>
    <script src="../../resources/js/bootstrap.min.js" type="text/javascript"></script>
    <script type="text/javascript">

        $(document).ready(function () {

            var sub_lesson_typeId;

            $("#muhazire").click(function () {
                sub_lesson_typeId = 1;   // muhazire - mesgele..
                showGroupBySub_Lesson_TypeId(${teacher_id}, sub_lesson_typeId);

            });

            $("#laboratoriya").click(function () {
                sub_lesson_typeId = 2;   // laboratoriya..
                showGroupBySub_Lesson_TypeId(${teacher_id}, sub_lesson_typeId);
            });

        });

    </script>

</head>
<body>
<div class="container-fluid">

    <c:if test="${! empty teacher_name}">
        <a href="/teacher-share-page/${teacher_id} "> <input type="button" value=" share with student >> " class="btn btn-default"
                                              style="height: 42px;float: left" id="send_student"> </a>

        <div class="row" style="width: 100%">
            <h4 style="float: right">Hər vaxtiniz xeir <span
                    class="label label-default"> ${teacher_name} ${teacher_surname}</span></h4>
        </div>
        <br>
    </c:if>


    <div class="container">
        <div class="col-md-6"><input type="button" value="Muhazirə dediyiniz qruplariniz" class="btn btn-primary"
                                     style="width: 100%;height: 42px" id="muhazire"></div>
        <div class="col-md-2"></div>
        <div class="col-md-6"><input type="button" value="Laboratriya dediyiniz qruplariniz" class="btn btn-primary"
                                     style="width: 100%;height: 42px" id="laboratoriya"></div>
        <br><br>

        <%-- Bootstrap pagination --> Main.js(getSubLessonByTypeId) --%>
        <nav aria-label="...">
            <ul class="pagination" id="Pagination_GroupBySubLessonTypeId"></ul>
        </nav>


    </div>

    <br><br>
    <table id="example" class="display" cellspacing="0" width="100%" style="">

    </table>


</div>
</body>
</html>
