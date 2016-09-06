<%@ page import="az.grp.model.dao.Laboratory" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Laboratory</title>
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/css/jquery.dataTable.css">

    <script type="text/javascript" src="../../resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="../../resources/js/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="../../resources/js/main.js"></script>
    <script type="text/javascript" src="../../resources/js/jquery.dataTablee.min.js"></script>
    <script type="text/javascript" src="../../resources/js/bootstrap.min.js"></script>


    <script type="text/javascript">

        $(function () {
            <% List<Laboratory> labs = (List<Laboratory>) request.getAttribute("labs");%>


            <%for (int i =0;i<labs.size();i++) {%>

            var summaryStatus = $("#dataTables-example #summaryStatus<%=i%>").text();

            <% if( labs.get(i).getLaboratoryStatus().getName().equals("Qebul edilib")) {%>
            $("#img1<%=i%>").show();
            <%}%>

            <% if( labs.get(i).getLaboratoryStatus().getName().equals("Yoxlanilmayib")) {%>
            $("#img3<%=i%>").show();
            <%}%>

            <% if( labs.get(i).getLaboratoryStatus().getName().equals("Qebul edilmeyib")) {%>
            $("#img2<%=i%>").show();
            <%}%>

            <%}%>

            <%for (int i =0;i<labs.size();i++) {%>
            $('#dataTables-example tr#id<%=i%>').click(function () {
                $(this).css('background-color', "lightblue");
                setTimeout(function () {
                    $('#dataTables-example tr#id<%=i%>').css('background-color', "white");
                }, 500)

                LaboratoryById($('#dataTables-example #summaryId<%=i%>').text());
            });
            <%}%>

            $("#searchStudent_summary_or_lab").click(function () {

                $("#formlesson_id").val($('select option:selected').val());
                if ($("#rd1").is(":checked")) {

                    $("#formsummaryStatus_id").val(1);
                }
                if ($("#rd2").is(":checked")) {

                    $("#formsummaryStatus_id").val(2);
                }
            });

            $("#delete_Lab").click(function () {
                $("#deleteModalLab").modal('show');
            });

            $("#OK_Lab").click(function () {
                updateLaboratoryDoc_Path($("#formLabId").val());
            });


            $('#dataTables-example').dataTable();
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
<div id="container" class="container-fluid">

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
    <br>

    <table class="display" id="dataTables-example">

        <% int i = 0;
            for (Laboratory lb : labs) { %>

        <tr id="id<%=i%>" style="height: 65px">
            <td id="summaryId<%=i%>"><%=lb.getId()%>
            </td>
            <td><%=lb.getLabName()%>
            </td>
            <td id="summaryStatus<%=i%>" style="display: none"><%=lb.getLaboratoryStatus().getName() %>
            </td>
            <td><img src="../../resources/wordFile/image/images.jpg" style="width: 60px;display: none" id="img1<%=i%>">
                <img src="../../resources/wordFile/image/images%20(1).jpg" style="width: 54px;display: none"
                     id="img2<%=i%>">
                <img src="../../resources/wordFile/image/images%20(2).jpg" style="width: 64px;display: none"
                     id="img3<%=i%>"></td>
        </tr>
        <%i++;%>
        <%}%>
    </table>

    <%--Bootstrap Modal Laboratory--%>


    <div class="modal fade" id="modalLaboratoryByID">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <div>
                        <h4 class="modal-title" style="color: #005f81">Laboratoriya işi </h4>
                        <h4 class="modal-title" id="Lab_Modal_id" style="color: #005f81"></h4>
                        <h4 class="modal-title" id="labName" style="color: #005f81"></h4>
                    </div>
                </div>

                <div class="modal-body" id="modalLaboratory">
                    <br>

                    <div class="container-fluid bd-example-row">
                        <div class="col-md-5 generic-container">
                            <form method="POST" action="/upload/uploadLaboratory" enctype="multipart/form-data">
                                <p style="font-style: italic">Fayl seçin: </p><input type="file" name="file"
                                                                                     id="file_Lab"
                                                                                     class="btn btn-default">
                                <input type="text" name="id" id="formLabId" style="display: none"><br>
                                <input type="submit" value="Upload  file" class="btn btn-primary" id="Lab_submit"
                                       style="display: none">
                            </form>
                        </div>
                        <div class="col-md-1"></div>
                        <div class="col-md-4">
                            <img class="img-responsive" id="img_Lab" src="../../resources/wordFile/image/images.png"
                                 style="margin: auto;width: 50%">
                        </div>
                        <div class="col-md-2">
                            <input type="button" value="Delete file" id="delete_Lab" class="btn btn-default"/>
                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <%--modal--%>


    <div class="modal fade" id="deleteModalLab">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">Modal title</h4>
                </div>
                <div class="modal-body">
                    <p>Laboratoriya işini silməyə əminsizmi..?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Xeyr</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal" id="OK_Lab">Bəli</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->

</div>
</body>
</html>
