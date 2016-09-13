<%@ page import="az.grp.model.dao.Student" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2016-09-04
  Time: 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/css/bootstrap.css">
    <link rel="stylesheet" href="../../resources/css/style.css">
    <link rel="stylesheet" href="../../resources/css/jquery.dataTable.css">

    <script src="../../resources/js/main.js" type="text/javascript"></script>
    <script src="../../resources/js/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="../../resources/js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="../../resources/js/jquery.dataTablee.min.js"></script>

    <script type="text/javascript">
        <% List<Student> students = (List<Student>) request.getAttribute("students");%>
        $(function () {

            $("#gonder").click(function () {

                var arr = new Array();
                <% for(int i=0;i<students.size();i++) { %>
                if ($('#studentCekId<%=i%>').is(':checked')) {
                    students_id = $('#dataTables-example  #student_id<%=i%>').text();
                    arr.push(students_id);
                }
                <%}%>
                $("#students_idtextarea").val(arr);
            });

            $('#checkOk').on('click', function () {

                if ($("#checkOk").is(':checked')) {
                    <%  for(int i=0;i<students.size();i++) { %>
                    $('#studentCekId<%=i%>').prop('checked', true);
                    <%}%>
                }
                 else{
                    <%  for(int i=0;i<students.size();i++) { %>
                    $('#studentCekId<%=i%>').prop('checked', false);
                    <%}%>
                }

            });

            $("#dataTables-example").dataTable();
        });

    </script>

</head>
<body>
<br>

<div class="row">
    <form action="/teacher-share-page/send-students" method="post" enctype="multipart/form-data">
        <div class="col-md-4">
            <div class="form-group">
                <label for="file">Fayl secin:</label>
                <input type="file" class="form-control" name="file" id="file" path="aa">
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-group">
                <label for="textarea_id">Məzmun :</label>
                <textarea class="form-control" rows="5" id="textarea_id" name="text1"></textarea>
            </div>
        </div>

        <div class="col-md-4">
            <br><br>
            <textarea class="form-control" rows="5" id="students_idtextarea" name="text2"
                      style="display: none"></textarea>
            <input type="submit" class="btn btn-default" id="gonder" value="Gonder"
                   style="width: 100%">
        </div>
    </form>
</div>

<div class="table-responsive" style="">
    <table class="table" id="dataTables-example">
        <thead>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td><%--<input type="button" class="btn btn-default" id="selectAll" value="Hər birini işarələ">--%>
                <label class="checkbox-inline" id="lbcheckOk"><input type="checkbox" id="checkOk">Hamısını
                    isarəleə</label></td>
        </tr>
        </thead>
        <% int i = 0;
            for (Student st : students) { %>

        <tr id="id<%=i%>" style="height: 65px">
            <td><%=i + 1%></td>
            <td><%=st.getFullName() %></td>
            <td><%=st.getPhoneNumber() %></td>
            <td id="student_id<%=i%>" style="display: none"><%=st.getId()%></td>
            <td><label class="checkbox-inline" id="lbcheck<%=i%>"><input type="checkbox"
                                                                         id="studentCekId<%=i%>"></label></td>
        </tr>
        <%i++;%>
        <%}%>
    </table>
</div>
</body>
</html>
