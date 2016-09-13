/*var key = 0;
 var values;
 var name;
 var surname;
 var studentTicketNo;
 var studentMobileNumber;
 var userMobileNumber;
 var email;
 var password;
 var repeatPassword;
 var tot = 0;
 var amount = 0;
 var userCode = "";



 alIdClick();

 $(".input-keyup").keyup(function () {
 if (key == 1) {
 registerFormCheckPlaceHolder();
 }
 });

 $("input[name='check']").click(function () {
 calculator();
 registerFormCheckPlaceHolder();
 });

 $("#saveButtonModalId").click(function () {
 registerCallBackAjax();
 });

 $("#save").click(function () {

 $("#modalPaymentAmountPId").text("Sizin �d?y?c?yiniz m?bl?? " + amount + " azn");
 $("#modalPaymentAmountPId").css({
 'color': 'green'
 });
 $("#modalBodyRegisterDivId").hide();
 $("#modalBodyPaymentDivId").show(500);

 });

 $("#monthlyInputId").keyup(function () {
 if (values != "") {
 calculator();
 }
 });

 $("#payButtonModalId").click(function () {
 // todo ondenis getpaymenturl
 pay();
 });

 });

 function registerFormCheckPlaceHolder() {
 key = 1;

 name = $("#name").val();
 if (name.trim() == "") {
 $("#namePId").show(1000);
 } else {
 $("#namePId").hide(1000);
 }


 surname = $("#surname").val();
 if (surname.trim() == "") {
 $("#surnamePId").show(1000);
 } else {
 $("#surnamePId").hide(1000);
 }

 studentTicketNo = $("#studentTicketNo").val();
 if (studentTicketNo.trim() == "") {
 $("#studentTicketNoPId").show(1000);
 } else {
 $("#studentTicketNoPId").hide(1000);
 }

 studentMobileNumber = $("#studentMobileNumber").val();
 if (studentMobileNumber.trim() == "") {
 $("#studentMobileNumberPId").show(1000);
 } else {
 $("#studentMobileNumberPId").hide(1000);
 }

 userMobileNumber = $("#userMobileNumber").val();
 if (userMobileNumber.trim() == "") {
 $("#userMobileNumberPId").show(1000);
 } else {
 $("#userMobileNumberPId").hide(1000);
 }

 email = $("#email").val();
 if (email.trim() == "") {
 $("#emailPId").show(1000);
 } else {
 $("#emailPId").hide(1000);
 }

 password = $("#password").val();
 if (password.trim() == "") {
 $("#passwordPId").show(1000);
 } else {
 $("#passwordPId").hide(1000);
 }

 repeatPassword = $("#repeatPassword").val();
 if (repeatPassword.trim() == "") {
 $("#repeatPasswordPId").show(1000);
 } else {
 $("#repeatPasswordPId").hide(1000);
 }

 values = new Array();
 $.each($("input[name='check']:checked"), function () {
 values.push($(this).attr("datavalue"));
 });

 if (values == "") {
 $("#valuesPId").show(1000);
 } else {
 $("#valuesPId").hide(1000);
 }
 }

 function registerFormCheckNotNull() {

 registerFormCheckPlaceHolder();

 if (name != null && surname != null && studentTicketNo != null
 && studentMobileNumber != null && email != null && password != null
 && repeatPassword != null && userMobileNumber != null && values != null
 && name.trim() != "" && surname.trim() != ""
 && studentTicketNo.trim() != "" && studentMobileNumber.trim() != ""
 && email.trim() != "" && password.trim() != ""
 && repeatPassword.trim() != "" && userMobileNumber.trim() != ""
 && values != "") {
 var json = {
 "name": name,
 "checkboxs": values.toString(),
 "surname": surname,
 "studentTicketNo": studentTicketNo,
 "studentMobileNumber": studentMobileNumber,
 "userMobileNumber": userMobileNumber,
 "email": email,
 "password": password,
 "repeatPassword": repeatPassword
 };

 registerAjax(json);
 } else {
 registerFormCheckPlaceHolder();
 }

 }


 function registerAjax(json) {
 $.ajax({
 url: 'register',
 contentType: "application/json; charset=utf-8",
 data: JSON.stringify(json),
 type: "POST",
 dataType: "json",
 success: function (data) {
 //   alert(data.error);
 if (data.success == "true") {
 userCode = data.user_code;
 $("#registerModalHeaderId").text("Success");
 $("#registerModalHeaderId").css("color", "green");
 $("#registerModalBodyId").text(data.phone + "  nomreye kod gonderilmisdir kodu buraya daxil edin");
 $("#registerModalBodyId").css("color", "green");
 $("#modalInputId").show();
 $("#saveButtonModalId").show();

 } else {

 // todo register generation code change while user change see the code part islenenden sonra deactiv et
 $("#modalBodyPaymentDivId").hide();
 $("#modalBodyRegisterDivId").show();
 $("#registerModalHeaderId").text("Sehv");
 $("#registerModalHeaderId").css("color", "red");
 $("#registerModalBodyId").text(data.error);
 $("#registerModalBodyId").css("color", "red");
 $("#saveButtonModalId").hide();
 $("#payButtonModalId").hide();
 $("#modalInputId").hide();

 }

 $("#registerModalId").modal('show');
 }
 });
 }

 function calculator() {
 var monthlyInputId = $("#monthlyInputId").val();
 var arr = [];

 if (monthlyInputId.trim() == "") {
 monthlyInputId = $("#monthlyInputId").attr("placeholder");
 }

 if (monthlyInputId != $("#monthlyInputId").attr("placeholder")) {

 arr = $("input[name='check']:checked");
 tot = 0;
 amount = 0;
 for (var i = 0; i < arr.length; i++) {
 if (parseInt(arr[i].value)) {
 tot += parseInt(arr[i].value);
 amount = parseInt(tot) * parseInt(monthlyInputId);
 }
 }
 } else {
 arr = $("input[name='check']:checked");
 tot = 0;
 monthlyInputId = 1;
 for (var i = 0; i < arr.length; i++) {
 if (parseInt(arr[i].value)) {
 tot += parseInt(arr[i].value);
 amount = parseInt(tot) * parseInt(monthlyInputId);
 }
 }

 }
 document.getElementById('calcId').value = amount + " azn";

 }

 function modal() {
 $("#registerModalHeaderId").text("Header");
 $("#registerModalHeaderId").css("color", "red");
 $("#registerModalBodyId").text("Body");
 $('#registerModalId').modal('show');

 }

 function registerCallBackAjax() {

 // todo burda contenttype sil ajaxda apiye produces mediatype json at test ele datatype nedi contentyp nedi ordada
 var regKey = $("#modalInputId").val();

 var json = {
 "regKey": regKey
 };

 $.ajax({
 url: 'registerCallBack',
 contentType: "application/json; charset=utf-8",
 data: JSON.stringify(json),
 dataType: 'json',
 type: 'POST',
 success: function (data) {
 if (data.success == "true") {
 $("#registerModalHeaderId").text("Sifre Tesdiqlendi");
 $("#registerModalHeaderId").css("color", "green");

 $("#modalPaymentAmountPId").text("Sizin odeyeceyiniz mebleg " + amount + " Azn");

 $("#modalPaymentAmountPId").css({
 'color': 'green'
 });

 //todo p leri show ele ikiinci div deki utf 8 duzelt

 $("#modalBodyRegisterDivId").hide();
 $("#modalBodyPaymentDivId").show();

 // button
 $("#saveButtonModalId").hide();
 $("#payButtonModalId").show();

 } else {
 //   alert("else" + data.success);
 $("#modalBodyPaymentDivId").hide();
 $("#registerModalBodyId").text(data.error);
 $("#registerModalBodyId").css("color", "red");
 $("#registerModalHeaderId").text("Sehv");
 $("#registerModalHeaderId").css("color", "red");
 }
 }
 });
 }

 function aaaa() {
 $("#registerModalId").modal('show');
 $("#modalPaymentAmountPId").text("Sizin �d??????????????????????p�p� m?bl?? azn");
 function encode_utf8() {
 return unescape(encodeURIComponent("sd"));
 }
 }

 function pay() {

 var monthlyInputId = $("#monthlyInputId").val();
 var studentTicketNo = $("#studentTicketNo").val();
 var bind = document.getElementById('cardSaveCheckbox').checked;
 //   alert("aa " + values);

 var json = {
 "amount": amount,
 "user_code": userCode,
 "bind": bind,
 "count": parseInt(monthlyInputId),
 "types": values,
 "studentTicketNo": parseInt(studentTicketNo)
 };

 // todo loading bar set

 $.ajax({
 url: 'payment/pay',
 data: JSON.stringify(json),
 contentType: "application/json; charset=utf-8",
 dataType: 'json',
 type: 'post',
 success: function (data) {
 if (data.success == true) {
 location.href = data.url;

 // todo loading bar hide
 } else {
 alert(data.errors);
 // todo too hide :)
 }
 }
 });

 }
 function alIdClick() {
 $("#alId1").click(function () {
 document.getElementById('checkId1').checked = "checked";
 });

 $("#alId2").click(function () {
 document.getElementById('checkId2').checked = "checked";
 });

 $("#alId3").click(function () {
 document.getElementById('checkId3').checked = "checked";
 });

 $("#alId4").click(function () {
 document.getElementById('checkId4').checked = "checked";
 });

 }

 function startTimer(duration, display, type) {
 var timer = duration, minutes, seconds;
 setInterval(function () {
 minutes = parseInt(timer / 60, 10)
 seconds = parseInt(timer % 60, 10);

 minutes = minutes < 10 ? "0" + minutes : minutes;
 seconds = seconds < 10 ? "0" + seconds : seconds;

 display.textContent = minutes + ":" + seconds;
 timer--;
 if (timer < 0) {
 timer = duration;
 }

 if (timer < 200 && type == 2) {
 $('#prononcationDiv').attr('style', 'background-color:red !important');
 }

 if (timer < 200 && type == 1) {
 $('#nowLessonDiv').attr('style', 'background-color:greenyellow !important');
 }

 if (timer == 0) {
 duration = 0;
 location.reload();
 }
 }, 1000);
 }

 function timer(fiveMinutes) {
 window.onload = function () {
 fiveMinutes = (fiveMinutes - 1) * 60 + (60 - new Date().getSeconds());
 display = document.querySelector('#timer');
 startTimer(fiveMinutes, display, 1);
 }
 }

 function timerPrononciation(fiveMinutes) {
 window.onload = function () {
 fiveMinutes = (fiveMinutes - 1) * 60 + (60 - new Date().getSeconds());
 display = document.querySelector('#timerPrononciation');
 startTimer(fiveMinutes, display, 2);
 }
 }

 function calculatePrononciation(minute) {
 var c = 0;
 //alert(minute);

 /!*
 minute = minute +13;
 *!/

 if (minute < 45) {
 c = 45 - minute;
 timer(c);
 }
 else if (45 <= minute && minute < 50) {
 c = 50 - minute;
 timerPrononciation(c);
 }
 else if (50 <= minute && minute < 95) {
 c = 95 - minute;
 timer(c);
 }

 }*/


function getStudentPointByLessonId(lessonId) {

    $("#dataTables").dataTable().fnDestroy();
    $('#dataTables').DataTable({
        "processing": true,
        "scrollX": true,
        "ajax": {
            "url": "getStudentPointById/" + lessonId,

            "dataSrc": function (json) {
                // balance = json.balance;
                // $("#balance").html("<i class='money icon'></i>" + balance/100 + " AZN");
                return json.data;
            },
        },
        "columns": [
            {"data": "lesson.name"},
            {"data": "created"},
            {"data": "daily"}
        ]
    });

}

function getLessonListByParentId(lessonId) {
    $.ajax({
        url: 'getLessonByParentLessonId/' + lessonId,
        type: 'Get',
        success: function (returnedData) {
            var posts = JSON.parse(returnedData);
            var out = "";
            var i;
            for (i = 0; i < posts.length; i++) {
                out += '<li  class = "liClass" value="' + posts[i].id + '"><a href="#" class="kl">' +
                    posts[i].name + '</a></li>';
            }
            document.getElementById("paginationChildLessonId").innerHTML = out;

            $('#paginationChildLessonId li').on('click', function () {
                // your function`
                var lessonChildId = this.value;
                getStudentPointByLessonId(lessonChildId);
            });
        }
    });

}

function signin() {

    var userName = $("#userNameId").val();
    var password = $("#loginButtonId").val();

    var json = {
        "userCode": userName,
        "password": password
    }

    if (userName.trim() == '' || password.trim() == '')
        alert('Please Enter Valid User Name/Password')
    else {

        $.ajax({
            url: 'signin',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(json),
            dataType: 'json',
            type: 'POST',
            success: function (data) {
                alert(data);
            }

        });
    }

}

// for Student Profile
function showSummary_OrLab(lesson_id, summaryStatus_id) {

    $.ajax({
        url: "students-summary-lab",
        data: "lesson_id=" + lesson_id + "&summaryStatus_id=" + summaryStatus_id,
        dataType: "html",
        type: "POST",

        success: function (data) {

            $("#summaryListDiv").html(data);
        }
    });

}


function SummaryById(id) {

    $.ajax({
        url: "getSummaryById",
        data: "id=" + id,
        dataType: "json",
        type: "POST",
        success: function (data) {
            //$("#Modal_Id").text(data.id);
            $("#summaryId").text(data.id);
            $("#formSummaryId").val(data.id);
            $("#doc_path").text(data.docPath);
            $("#summaryName").text(data.name);
            $("#modalSummaryByID").modal('show');

            if (data.docPath != "" && data.docPath != null) {

                $("#img_summary").show();
                $("#submit_summary").hide();
            } else {

                $("#img_summary").hide();
                $("#submit_summary").show();
            }

            if (data.docPath == "" || data.docPath == null) {
                $("#delete_summary").hide();
            } else {
                $("#delete_summary").show();
            }
        }

    });

}

function LaboratoryById(id) {

    $.ajax({
        url: "getLaboratoryById",
        data: "id=" + id,
        dataType: "json",
        type: "POST",
        success: function (data) {
            $("#Lab_Modal_id").text(data.number);
            $("#formLabId").val(data.id);
            $("#doc_path").text(data.docPath);
            $("#labName").text(data.labName);
            $("#modalLaboratoryByID").modal('show');

            if (data.docPath != "" && data.docPath != null) {

                $("#img_Lab").show();
                $("#Lab_submit").hide();
            } else {

                $("#img_Lab").hide();
                $("#Lab_submit").show();
            }

            if (data.docPath == "" || data.docPath == null) {
                $("#delete_Lab").hide();
            } else {
                $("#delete_Lab").show();
            }
        }

    });


}


function updateSummaryDoc_Path(id) {

    $.ajax({
        url: "update-summary",
        data: "id=" + id,
        dataType: "text",
        type: "POST",
        success: function (data) {
            location.reload();
        }
    });

}

function updateLaboratoryDoc_Path(id) {

    $.ajax({
        url: "update-laboratory",
        data: "id=" + id,
        dataType: "text",
        type: "POST",
        success: function (data) {
            location.reload();
        }
    });

}

// end student profile


// Teacher Profile
function showStudentByGroupId(groupid, lessonid, sub_lesson_typeId) {

    var dey;  // birinci ajax status_id ye gore telebeleri qaytarir
    $.ajax({
        url: "equals-students",
        data: "groupid=" + groupid + "&lessonid=" + lessonid + "&sub_lesson_typeId=" + sub_lesson_typeId,
        dataType: "json",
        type: "POST",
        success: function (data1) {
            //alert(data1)
            dey = data1;
        }
    });

    // lessonid ni paginatondan secib gonderirem bu metodun daxiline sonra Controllerde deyisene mneimsedirem..

    var dey_1;
    $.ajax({
        url: "getStudentByGroupId",
        data: "groupid=" + groupid + "&lessonid=" + lessonid,
        dataType: "json",
        type: "POST",
        success: function (data) {

            var out = ' <thead>'
                + ' <tr id="trId">'
                + ' <th>studentId</th>'
                + ' <th>FullName.</th>'
                + ' <th>Telephone.</th> '
                + ' <th>Dob.</th> '
                + ' <th>Speciality code.</th>'
                + ' <th>Action.</th>'
                + ' <th>icon.</th>'
                + '</tr>'
                + ' </thead>';

            document.getElementById("example").innerHTML = out;
            $('#example').show();
            $("#example").dataTable().fnDestroy();
            $('#example').dataTable({
                "data": data,
                "columns": [
                    {"data": "id"},
                    {"data": "fullName"},
                    {"data": "phoneNumber"},
                    {"data": "dob"},
                    {"data": "specialtyCode"},
                    {
                        "mData": null,
                        "bSortable": false,
                        "render": function (data) {
                            return '<a href="/show-summaryORlab-byteacher/id=' + data.id + '&type=' + sub_lesson_typeId + '">' + '<input type="button" value="Neticeye bax" class="btn btn-default">' + '</a>';
                        },
                    },
                    {
                        "data": "id",
                        "render": function (data) {

                            if (dey != "") {
                                var s;
                                for (s = 0; s < dey.length; s++) {
                                    return (data == dey[s] ) ? '<img src="../../resources/wordFile/image/check-student.png" style="width: 30px">' : '';
                                }
                            }
                            if (dey == "") {
                                return ''
                            }
                        }
                    },
                ],
            });
        }
    });
}


function showGroupBySub_Lesson_TypeId(teacher_id, sub_lesson_typeId) {

    var dey;
    // birinci ajax status_id ye gore serbest_is lab veren qruplari qaytarir
    $.ajax({
        url: "group/equals",
        data: "sub_lesson_typeId=" + sub_lesson_typeId,
        dataType: "json",
        type: "POST",
        success: function (data1) {
            // alert(data1)
            dey = data1;
        }
    });


    $.ajax({
        url: "getSubLessonByTypeId",
        data: "id=" + teacher_id + "&sub_lesson_typeId=" + sub_lesson_typeId,
        dataType: "json",
        type: "POST",
        success: function (data) {

            var returnData = data;
            var out = ' <li class="page-item disabled">'
                + ' <a class="page-link" href="#" tabindex="-1" aria-label="Previous">'
                + '  <span aria-hidden="true">&laquo;</span>'
                + '  <span class="sr-only">Previous</span>'
                + '  </a>'
                + '  </li> ';

            var i, j;
            for (i = 0; i < returnData.length; i++) {

                out += '<li  class = "page-item" value=""><a href="javascript:showStudentByGroupId(' + returnData[i].parentLesson.groups.id + " ," + returnData[i].parentLesson.id + " , " + sub_lesson_typeId + ')" class="page-link">' +
                    returnData[i].parentLesson.name + " -- " + returnData[i].parentLesson.groups.name + '</a></li>';

                for (j = 0; j < dey.length; j++) {
                    if (returnData[i].parentLesson.groups.name == dey[j]) {

                        out += '<li  class = "page-item" value=""> ' +
                            '<span aria-hidden="true">' +
                            '<img src="../../resources/wordFile/image/check.jpg" style="width: 22px;"></span>' +
                            '</li>';
                    }
                }
            }
            out += '<li class="page-item"> '
                + ' <a class="page-link" href="#" aria-label="Next"> '
                + ' <span aria-hidden="true">&raquo;</span> '
                + '<span class="sr-only">Next</span> '
                + '</a>'
                + '</li>';
            document.getElementById("Pagination_GroupBySubLessonTypeId").innerHTML = out;
        }
    });

}


function TeacherSaveStudentSummaryOrLabStatus(summaryOrLabId, summaryStatusId, sub_LessonType_id) {

    $.ajax({
        url: "/save_summary_or_lab_byteacher",
        data: "summaryOrLabId=" + summaryOrLabId + "&summaryStatusId=" + summaryStatusId + "&sub_LessonType_id=" + sub_LessonType_id,
        dataType: "text",
        type: "POST",
        success: function (data) {
            location.reload();
        }
    });

}

function getStudentListforTeacher_Share(group_id) {

    $.ajax({
        url: "/teacher-share-page/find-students",
        data: "group_id=" + group_id,
        dataType: "text",
        type: "POST",
        success: function (data) {
            $("#teacher_share_students_div").html(data);
        }
    });

}