<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Students course</title>

    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/css/bootstrap.css">
    <link rel="stylesheet" href="../../resources/css/jquery.dataTable.css">

    <script src="../../resources/js/main.js" type="text/javascript"></script>
    <script src="../../resources/js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="../../resources/js/jquery.dataTablee.min.js"></script>
    <script src="../../resources/js/bootstrap.min.js" type="text/javascript"></script>
    <script type="text/javascript">

        $(function () {


        });

    </script>

</head>
<body>

<div class="container-fluid">
    <table class="table" id="Tables-laboratory">
        <thead>
        <tr>
            <td><h3 style="color: #005f81">Tələbə </h3></td>
            <td><h3 style="color: #005f81">İxtisasin kodu </h3></td>
            <td><h3 style="color: #005f81">Tel </h3></td>
            <td><h3 style="color: #005f81">Kurs </h3></td>
        </tr>
        </thead>

        <tbody>
        <c:if test="${!empty course}">
            <c:forEach items="${course}" var="course">
                <tr>
                    <td>${course.fullName}</td>
                    <td>${course.specialtyCode}</td>
                    <td>${course.phoneNumber}</td>
                    <td>HeadStart MMC </td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
</div>

</body>
</html>
