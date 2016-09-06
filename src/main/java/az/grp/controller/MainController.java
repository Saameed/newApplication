package az.grp.controller;

import az.grp.dao.BaseDAO;
import az.grp.model.dao.*;
import az.grp.util.JSONUtil;
import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class MainController {

    @Autowired
    BaseDAO baseDAO;


    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap map) {

        List<Student> students = baseDAO.find(Student.class, "id", 1);
        int group_id = 0;
        for (Student st : students) {
            group_id = st.getGroups().getId();
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("groups.id", group_id);
        List<Lesson> lessons = baseDAO.find(Lesson.class, params);
        map.put("lessons", lessons);

        return "summary";
    }

    @RequestMapping(value = "/students-summary-lab", method = RequestMethod.POST)
    public String Summary(@Param SumLabWO sumLabWO, HttpServletRequest request, ModelMap map) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("lesson.id", sumLabWO.getLesson_id());
        params.put("students.id", 1);

       /* Student profilde headerde radio ve selectbox un melumatlarini menimsetmek ucun*/
        List<Student> students = baseDAO.find(Student.class, "id", 1);
        int group_id = 0;
        for (Student st : students) {
            group_id = st.getGroups().getId();
        }
        Map<String, Object> val = new HashMap<String, Object>();
        val.put("groups.id", group_id);
        List<Lesson> lessons = baseDAO.find(Lesson.class, val);
        map.put("lessons", lessons);

        if (sumLabWO.getSummaryStatus_id() == null || sumLabWO.getLesson_id() == null) {
            return "summary";
        }
        if (sumLabWO.getSummaryStatus_id() == 1) {

            List<Summary> summarys = baseDAO.find(Summary.class, params);
            request.setAttribute("summary", summarys);
            return "summaryList";
        }
        if (sumLabWO.getSummaryStatus_id() == 2) {

            List<Laboratory> labs = baseDAO.find(Laboratory.class, params);
            request.setAttribute("labs", labs);
            return "laboratoryList";
        }

        return "summary";
    }


    @RequestMapping(value = "/getSummaryById")
    @ResponseBody
    public String SummaryById(@RequestParam int id, ModelMap map) {

        Summary summaryById = baseDAO.findWithParams(Summary.class, "id", id);
        map.put("summaryById", summaryById);
        return JSONUtil.convertObjectToJSON(summaryById);
    }


    @RequestMapping(value = "/getLaboratoryById")
    @ResponseBody
    public String LaboratoryById(@RequestParam int id, ModelMap map) {

        Laboratory laboratoryById = baseDAO.findWithParams(Laboratory.class, "id", id);
        return JSONUtil.convertObjectToJSON(laboratoryById);
    }


    @RequestMapping(value = "/update-summary", method = RequestMethod.POST)
    @ResponseBody
    public String updateSummaryDoc_Path(@RequestParam int id, HttpServletResponse response) {
        try {
            //todo - delete server file
            Summary summary = baseDAO.findWithParams(Summary.class, "id", id);
            SummaryStatus st = new SummaryStatus();
            st.setId((long) 1);
            summary.setDocPath("");
            summary.setSummaryStatus(st);
            baseDAO.update(summary);
            response.sendRedirect("/");

        } catch (Exception e) {
            e.printStackTrace();
            return "Error update ";
        }
        return "success update";
    }

    @RequestMapping(value = "/update-laboratory", method = RequestMethod.POST)
    @ResponseBody
    public String updateLabDoc_Path(@RequestParam int id) {
        try {
            //todo - delete server file
            Laboratory lab = baseDAO.findWithParams(Laboratory.class, "id", id);
            SummaryStatus st = new SummaryStatus();
            st.setId((long) 1);
            lab.setDocPath("");
            lab.setLaboratoryStatus(st);
            baseDAO.update(lab);

        } catch (Exception e) {
            e.printStackTrace();
            return " update is failure";
        }
        return "success";
    }


      /*Teacher Profile*/

    @RequestMapping(value = "/teacherProfile")
    public String teacher(ModelMap map) {

        try {
            Map<String, Object> params = new HashMap<>();
            params.put("email", "xezail@gmail.com");
            params.put("password", "123456");

            Teacher tr = baseDAO.findWithParams(Teacher.class, params);
            map.addAttribute("teacher_name", tr.getName());
            map.addAttribute("teacher_surname", tr.getSurname());
            map.addAttribute("teacher_id", tr.getId());


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "TeacherProfile";
    }


    int globalSubLessonTypeId;

    @RequestMapping(value = "/getSubLessonByTypeId", method = RequestMethod.POST)
    @ResponseBody
    public String groupListBySub_Lesson_TypeId(@RequestParam(value = "id") int id,
                                               @RequestParam(value = "sub_lesson_typeId") int sub_lesson_typeId) {

        globalSubLessonTypeId = sub_lesson_typeId;

        Map<String, Object> params = new HashMap<>();
        params.put("teacher.id", id);
        params.put("subLessonType.id", sub_lesson_typeId);
        List<SubLesson> subLessons = baseDAO.find(SubLesson.class, params);

        return JSONUtil.convertArrayToJSON(subLessons);

    }


    @RequestMapping(value = "/group/equals", method = RequestMethod.POST)
    // for teacherProfile equals groups by summary_lab status
    @ResponseBody
    public String EqualsGroupsbyStatus_id(@RequestParam(value = "sub_lesson_typeId") int sub_lesson_typeId) {

        List<Double> array1 = new ArrayList();

        if (sub_lesson_typeId == 1) { //summary_List
            array1.clear();
            List<Summary> summaryList = baseDAO.find(Summary.class, "summaryStatus.id", Long.parseLong("2"));
            for (Summary sm : summaryList) {
                array1.add(Double.parseDouble(sm.getLesson().getGroups().getName()));
            }
        }
        if (sub_lesson_typeId == 2) { //laboratory_List
            array1.clear();
            List<Laboratory> labList = baseDAO.find(Laboratory.class, "laboratoryStatus.id", Long.parseLong("2"));
            for (Laboratory lb : labList) {
                array1.add(Double.parseDouble(lb.getGroups().getName()));
            }
        }

        // Tekrarlanan group-lari array-dan silirem
        if (!array1.equals(null) && !array1.equals("")) {

            for (int i = 0; i < array1.size(); i++) {
                for (int j = 0; j < array1.size(); j++) {
                    if (i != j) {
                        if (array1.get(i).equals((array1.get(j)))) {
                            array1.remove(j);
                        }
                    }
                }
            }
        }
        return JSONUtil.convertObjectToJSON(array1);

    }


    int globalLessonId;

    @RequestMapping(value = "/getStudentByGroupId")
    @ResponseBody
    public String getStudentByGroupId(@RequestParam(value = "groupid") int groupid,
                                      @RequestParam(value = "lessonid") int lessonid) {

        globalLessonId = lessonid;

        List<Student> students = baseDAO.find(Student.class, "groups.id", groupid);
        return JSONUtil.convertArrayToJSON(students);
    }


    @RequestMapping(value = "/equals-students", method = RequestMethod.POST)
    @ResponseBody
    public String EqualsStudentbySumOrLabStatus_id(@RequestParam(value = "groupid") int groupid,
                                                   @RequestParam(value = "lessonid") int lessonid, ModelMap map) {

        List<Integer> students_array = new ArrayList();
        Map<String, Object> params = new HashMap<>();

        if (globalSubLessonTypeId == 1) {

            students_array.clear();
            params.put("summaryStatus.id", Long.parseLong("2"));
            params.put("lesson.id", lessonid);
            // params.put("lesson.groups.id", globGroup_id);
            List<Summary> summaryList = baseDAO.find(Summary.class, params);
            for (Summary sm : summaryList) {
                students_array.add(sm.getStudents().getId());
            }
        } else if (globalSubLessonTypeId == 2) {

            students_array.clear();
            params.put("laboratoryStatus.id", Long.parseLong("2"));
            params.put("lesson.id", lessonid);
            // params.put("lesson.groups.id", globGroup_id);
            List<Laboratory> labList = baseDAO.find(Laboratory.class, params);
            for (Laboratory lb : labList) {
                students_array.add(lb.getStudents().getId());
            }
        }
        // Tekrarlanan group-lari array-dan silirem
        if (!students_array.equals(null) && !students_array.equals("")) {
            for (int i = 0; i < students_array.size(); i++) {
                for (int j = 0; j < students_array.size(); j++) {
                    if (i != j) {
                        if (students_array.get(i).equals((students_array.get(j)))) {
                            students_array.remove(j);
                        }
                    }
                }
            }
        }

        return JSONUtil.convertObjectToJSON(students_array);
    }


    @RequestMapping(value = "/show-summaryORlab-byteacher/{studentid}")
    public String TeachershowSummary(@PathVariable int studentid, ModelMap map, HttpServletRequest request) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("lesson.id", globalLessonId);
        params.put("students.id", studentid);

        if (globalSubLessonTypeId == 1) {

            List<Summary> summarys = baseDAO.find(Summary.class, params);
            Student student = baseDAO.findWithParams(Student.class, "id", studentid);
            request.setAttribute("summary", summarys);
            map.addAttribute("student", student);
            return "forTeacherProfileSummary";
        }
        if (globalSubLessonTypeId == 2) {

            List<Laboratory> laboratories = baseDAO.find(Laboratory.class, params);
            Student student = baseDAO.findWithParams(Student.class, "id", studentid);
            map.addAttribute("student", student);
            request.setAttribute("lab", laboratories);
            return "forTeacherProfileLaboratory";
        }

        return "";
    }


    @RequestMapping(value = "/save_summary_or_lab_byteacher", method = RequestMethod.POST)
    @ResponseBody
    public String TeacherUpdateStudentSummaryOrLabStatus(@RequestParam(value = "summaryOrLabId") int summaryOrLabId,
                                                         @RequestParam(value = "summaryStatusId") int summaryStatusId) {

        try {
            if (globalSubLessonTypeId == 1) {   // mesgele - muhazire
                Summary summary = baseDAO.findWithParams(Summary.class, "id", summaryOrLabId);
                SummaryStatus st = new SummaryStatus();
                st.setId((long) summaryStatusId);
                summary.setSummaryStatus(st);
                baseDAO.update(summary);
            }
            if (globalSubLessonTypeId == 2) {  // laboratoriya
                Laboratory lab = baseDAO.findWithParams(Laboratory.class, "id", summaryOrLabId);
                SummaryStatus st = new SummaryStatus();
                st.setId((long) summaryStatusId);
                lab.setLaboratoryStatus(st);
                baseDAO.update(lab);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "update failed";
        }
        return "update success";
    }

    // Teacher share students
    int globalTeacher_id;

    @RequestMapping("/teacher-share-page/{teacher_id}")
    public String WelcomeTeacher_SharePage(@PathVariable int teacher_id, ModelMap map) {

        Map<String, Object> params = new HashMap<>();
        params.put("teacher.id", teacher_id);
        List<SubLesson> subLessons = baseDAO.find(SubLesson.class, params);
        globalTeacher_id = teacher_id;

        for (int i = 0; i < subLessons.size(); i++) {
            for (int j = 0; j < subLessons.size(); j++) {
                if (i != j) {
                    if (subLessons.get(i).getParentLesson().getGroups().getName().equals(
                            (subLessons.get(j).getParentLesson().getGroups().getName()))) {
                        subLessons.remove(j);
                    }
                }
            }
        }
        map.put("groups", subLessons);
        return "teacher_share";
    }


    @RequestMapping(value = "/teacher-share-page/find-students", method = RequestMethod.POST)
    public String as(@RequestParam int group_id, HttpServletRequest request) {

        List<Student> students = baseDAO.find(Student.class, "groups.id", group_id);
        request.setAttribute("students", students);
        return "teacher_share_students";
    }


    @RequestMapping(value = "/teacher-share-page/send-students", method = RequestMethod.POST)
    @ResponseBody
    public String Teacher_share_student_file(@RequestParam String text1,
                                             @RequestParam String text2, @RequestParam("file") MultipartFile file) {

        String[] val = text2.split(",");
        Teacher_share teacher_share = new Teacher_share();
        Student student = new Student();
        Teacher teacher = new Teacher();
        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "teacher_shareFile");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + file.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                teacher.setId(globalTeacher_id);
                for (int i = 0; i < val.length; i++) {
                    student.setId(Integer.parseInt(val[i]));
                    teacher_share.setFilePath("C:\\apache-tomcat-7.0.63\\teacher_shareFile\\" + file.getOriginalFilename());
                    teacher_share.setDescription(text1);
                    teacher_share.setStudents(student);
                    teacher_share.setTeachers(teacher);
                    teacher_share.setStatus(1);
                    baseDAO.save(teacher_share);
                }

            } else {

                if (!text2.equals("") && !text1.equals("")) {
                    teacher.setId(globalTeacher_id);
                    for (int i = 0; i < val.length; i++) {
                        student.setId(Integer.parseInt(val[i]));
                        teacher_share.setDescription(text1);
                        teacher_share.setStudents(student);
                        teacher_share.setTeachers(teacher);
                        teacher_share.setStatus(1);
                        baseDAO.save(teacher_share);
                    }
                }
                if (text2.equals("") || text1.equals("")) {
                    return "errorr";
                }

            }
            return "share is successfully";
        } catch (Exception e) {
            return "share is failed  " + e.getMessage();
        }

    }


}