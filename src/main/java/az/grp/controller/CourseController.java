package az.grp.controller;

import az.grp.dao.BaseDAO;
import az.grp.model.dao.StudentsCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Hp on 2016-09-12.
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    BaseDAO baseDAO;


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String SaveStudentCourse(@RequestBody StudentsCourse course, ModelMap map) {
        try {

            course.setUserName(course.getUserName());
            course.setFullName(course.getFullName());
            course.setSpecialtyCode(course.getSpecialtyCode());
            course.setCours(course.getCours());
            course.setPhoneNumber(course.getPhoneNumber());
            course.setStatus(1);
            baseDAO.save(course);
        } catch (Exception ex) {
            return "error";
        }
        return "course save successfully completed";
    }


    @RequestMapping(value = "/show")
    public String showStudentCourse(ModelMap map) {

        List<StudentsCourse> coursList = baseDAO.find(StudentsCourse.class, null, null);
        map.put("course", coursList);
        return "showstudentcours";
    }

}
