<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 28.07.2015
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Summary Pages</title>
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
        $(document).ready(function () {

            $("#img").hide();


            $("#searchStudent_summary_or_lab").click(function () {

                //var summaryStatusId;
                //var lesson_id = $('select option:selected').val();

                $("#formlesson_id").val($('select option:selected').val());
                if ($("#rd1").is(":checked")) {
                    // summaryStatusId = 1;   // yeni mesgele-serbest_is
                    $("#formsummaryStatus_id").val(1);
                    //showSummary_OrLab(lesson_id, summaryStatusId);
                }

                if ($("#rd2").is(":checked")) {
                    // summaryStatusId = 2;    // yeni laboratoriya
                    // showSummary_OrLab(lesson_id, summaryStatusId);
                    $("#formsummaryStatus_id").val(2);
                }

            });

        });


    </script>
    <style>

        .generic-container {
            margin-bottom: 25px;
            padding: 10px;
            background-color: #EAE7E7;
            border-radius: 4px;
            box-shadow: 0 0 40px black;
        }

    </style>
</head>
<body>

<div class="container-fluid">

    <div class="container-fluid generic-container" style="box-shadow: 0 0 40px black;">

        <div class="col-md-3" id="nnese">
            <label style="margin: auto;">Mövcud fənnləriniz..</label>
        </div>

        <c:if test="${!empty lessons}">
            <div class="col-md-4" id="nese">
                <select class="form-control">
                    <option value="">Fənn seçin...</option>
                    <c:forEach items="${lessons}" var="lesson">
                        <option value="${lesson.id}">${lesson.name}</option>
                    </c:forEach>
                </select>
            </div>
        </c:if>

        <div class="col-md-3" id="nese">

            <label class="radio-inline"><input type="radio" name="optradio" id="rd1">Sərbəst iş</label>&nbsp;&nbsp;
            <label class="radio-inline"><input type="radio" name="optradio" id="rd2">Laboratoriya</label>

        </div>

        <div class="col-md-2">
            <form action="/students-summary-lab" method="post">
                <%-- Formla gondermek ucun p tag larina value ni menimsedrem--%>
                <input type="text" name="lesson_id" id="formlesson_id" style="display: none">

                <input type="text" name="summaryStatus_id" id="formsummaryStatus_id" style="display: none">

                <input type="submit" class="btn btn-primary" id="searchStudent_summary_or_lab" value="Axtar"
                       style="width: 100%">
            </form>
        </div>

    </div>

    <br><br>

    <div id="summaryListDiv"></div>


</div>
</body>
</html>
