<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="az.grp.model.dao.BlogQuestion" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Blog page</title>

    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/css/bootstrap.css">
    <link rel="stylesheet" href="../../resources/css/style.css">
    <link rel="stylesheet" href="../../resources/css/jquery.dataTable.css">

    <script src="../../resources/js/main.js" type="text/javascript"></script>
    <script src="../../resources/js/jquery.min.js" type="text/javascript"></script>
    <script src="../../resources/js/bootstrap.min.js" type="text/javascript"></script>

    <script type="text/javascript">

        <%List<BlogQuestion> questions = (List<BlogQuestion>) request.getAttribute("questions");%>
        $(function () {

            <%for (int i =0;i<questions.size();i++) {%>
            $('#Tables-laboratory tr#id<%=i%>').click(function () {
                $(this).css('background-color', "lightblue");
                setTimeout(function () {
                    $('#Tables-laboratory tr#id<%=i%>').css('background-color', "white");
                }, 500)


                ($('#dataTables-example #takeQuestionId<%=i%>').text());
            });
            <%}%>

            $("#addQuestion").click(function () {
                $("#addQuestionModal").modal('show');
            });


            $("#OK").click(function () {

                var fullName = $("#fullName_id").val();
                var email = $("#email_id").val();
                var title = $("#title_id").val();
                var text = $("#textarea_id").val();

                alert(fullName + email + title + text);

                $.ajax({
                    url: "/blog/add-question",
                    data: "fullName=" + fullName + "&email=" + email + "&title=" + title + "&text=" + text,
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
            /*background-color: #EAE7E7;*/
            border-radius: 4px;
            box-shadow: 0 0 10px black;
        }

    </style>
</head>
<body>
<div class="container-fluid" style="height: 100%;">

    <div class="row"style="">
        <div class="col-md-4">
            <img src="../../resources/wordFile/image/blog-image/adnsu.png" style="width: 100%
            ;float: left" class="img-responsive">
            <br> <br>
            <a href="/"><img src="../../resources/wordFile/image/blog-image/bloglogoo.png"
                             style="width: 100%;height: 180px;float: left"
                             class="img-responsive"></a>
        </div>
        <div class="col-md-8" style="">
            <h5 style="margin: 87px 0 0 0px"><p style="text-align: center;color: grey;font-style: italic">Hörmətli istifadəçi,suallarınız 24 iş
                saatı ərzində cavablandırılacaq.Sualınıza uyğun
                cavablar, həmçinin sizin email adresinizə göndəriləcəkdir. </p></h5> <br><br>

            <input type="button" class="btn btn-primary" value="Sual ver" id="addQuestion"style="width: 50%;float: right;margin:
            75px 0 0 0px" >
        </div>
    </div>

    <div class="col-md-1"></div>
    <div class="table-responsive col-md-10" style="">

        <table class="table" id="Tables-laboratory">
            <thead>
            <tr>
                <td><h3 style="color: #005f81">Suallar</h3></td>
            </tr>
            </thead>

            <% int i = 0;
                for (BlogQuestion bq : questions) { %>

            <tbody>

            <tr id="id<%=i%>">

                <td style="color: #005f81"><a href="/blog/questionby-id/<%=bq.getId()%>"
                                              style="color: #005f81"><%=bq.getTitle()%>
                </a></td>
                <td>Tarix: <%=bq.getCreated()%>
                </td>
                <td style="display: none" id="takeQuestionId<%=i%>"><%=bq.getId()%>
                </td>
            </tr>
            </tbody>
            <%i++;%>
            <%}%>
        </table>
    </div>
    <div class="col-md-1"></div>

    <div class="modal fade" id="addQuestionModal">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <div>
                        <h4 class="modal-title" style="color: #005f81">Yeni sual əlavə et </h4>
                        <h4 class="modal-title" id="Lab_Modal_id" style="color: #005f81"></h4>
                        <h4 class="modal-title" id="labName" style="color: #005f81"></h4>
                    </div>
                </div>

                <div class="modal-body" id="modalbody">
                    <br>

                    <div class="container-fluid bd-example-row">

                        <div class="col-md-6" style="">
                            <div class="form-group">
                                <label for="fullName_id">Adınız və Soyadınız:</label>
                                <input type="text" class="form-control" name="fullName" id="fullName_id" path="aa">
                            </div>

                            <div class="form-group">
                                <label for="email_id">Email:</label>
                                <input type="text" class="form-control" name="email" id="email_id">
                            </div>

                            <div class="form-group">
                                <label for="email_id">Sualin Başligı:</label>
                                <input type="text" class="form-control" name="title" id="title_id">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="textarea_id">Sualın məzmunu :</label>
                                <textarea class="form-control" rows="5" id="textarea_id" name="text"></textarea>
                            </div>
                        </div>


                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal" id="OK">Bəli</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <%--modal--%>

</div>

</body>
</html>
