<%@ page import="az.grp.model.dao.Summary" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sum Page</title>

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
        <% List<Summary> summarys = (List<Summary>) request.getAttribute("summary");%>

        $(function () {

            <% for(int i=0;i<summarys.size();i++) { %>

            <%if(summarys.get(i).getSummaryStatus().getId() == 3){%>
            $('#checkOk<%=i%>').prop('checked', true);
            <%}%>

            <%if(summarys.get(i).getSummaryStatus().getId() == 4){%>
            $('#checkNo<%=i%>').prop('checked', true);
            <%}%>

            <%if(!summarys.get(i).getDocPath().equalsIgnoreCase("") && summarys.get(i).getDocPath() != null){%>
            $("#img<%=i%>").show();
            <%}%>

            <%if(summarys.get(i).getDocPath().equalsIgnoreCase("") || summarys.get(i).getDocPath() == null){%>
            $('#lbcheckNo<%=i%>').hide();
            $('#lbcheckOk<%=i%>').hide();
            <%}%>

            <%}%>


            $("#Yadda_saxla").click(function () {

                <% for(int i=0;i<summarys.size();i++) { %>
                summaryId = $('#Tables-summary  #takesummaryId<%=i%>').text();

                if ($('#checkNo<%=i%>').prop('checked') == false && $('#checkOk<%=i%>').prop('checked') == false) {
                    <%if(!summarys.get(i).getDocPath().equalsIgnoreCase("") && summarys.get(i).getDocPath() != null){%>
                    summaryStatus = 2;    // summaryStatus_id ni 2 edirik
                    TeacherSaveStudentSummaryOrLabStatus(summaryId, summaryStatus);
                    <%}%>

                }

                if ($('#checkNo<%=i%>').is(':checked') && $('#checkOk<%=i%>').is(':checked')) {
                    $('#checkNo<%=i%>').prop('checked', false);
                    $('#checkOk<%=i%>').prop('checked', false);
                }

                if ($('#checkOk<%=i%>').is(':checked')) {  //checkOk click olunanda bazaya qebul edilib kimi dusecey
                    <%if(!summarys.get(i).getDocPath().equalsIgnoreCase("") && summarys.get(i).getDocPath() != null){%>
                    summaryStatus = 3; // --> yeni qebul edilib
                    TeacherSaveStudentSummaryOrLabStatus(summaryId, summaryStatus);
                    <%}%>
                }

                else if ($('#checkNo<%=i%>').is(':checked')) {  //checkNo eksine
                    <%if(!summarys.get(i).getDocPath().equalsIgnoreCase("") && summarys.get(i).getDocPath() != null){%>
                    summaryStatus = 4;  // --> yeni qebul edilmeyib
                    TeacherSaveStudentSummaryOrLabStatus(summaryId, summaryStatus);
                    <%}%>
                }

                <%}%>
            });


        });
    </script>

</head>
<body>
<div class="container-fluid">

    <c:if test="${! empty student}">
        <div class="row" style="width: 100%">
            <h4 style="float: right"><span
                    class="label label-default"> ${student.fullName} serbest isler</span></h4>
        </div>
        <br>
    </c:if>

    <br>

    <input type="button" value="Yadda saxla" id="Yadda_saxla" class="btn btn-block"> <br>

    <div class="table-responsive " style="">
        <table id="Tables-summary" class="table">

            <% int i = 0;
                for (Summary sm : summarys) {%>

            <tbody>
            <tr>
                <td><%=i%>
                </td>
                <td><%=sm.getName() %>
                </td>
                <td style="display: none" id="takesummaryId<%=i%>"><%=sm.getId() %>
                </td>
                <td><a href="" rel="case">
                    <input type="button" class="btn btn-default" value="open document" id="open_document"></a></td>
                <td><label class="checkbox-inline" id="lbcheckOk<%=i%>"><input type="checkbox" id="checkOk<%=i%>">Qebul
                    edirəm</label>
                    <label class="checkbox-inline" id="lbcheckNo<%=i%>"><input type="checkbox" id="checkNo<%=i%>">Qəbul
                        etmirəm</label>
                </td>
                <td><img src="../../resources/wordFile/image/images.png" id="img<%=i%>" class="img-responsive"
                         style="display: none;height:45px"></td>
            </tr>
            </tbody>
            <%i++;%>
            <%}%>

        </table>
    </div>
</div>
</body>
</html>
