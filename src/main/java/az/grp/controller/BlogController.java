package az.grp.controller;

import az.grp.dao.BaseDAO;
import az.grp.model.dao.BlogAnswer;
import az.grp.model.dao.BlogQuestion;
import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Hp on 2016-08-24.
 */
@Controller
@RequestMapping("/blog")
public class BlogController {


    @Autowired
    BaseDAO baseDAO;


    @RequestMapping(value = "/welcome")
    public String WelcomeBlog(HttpServletRequest request) {

        Map<String, Object> params = new HashMap<>();
        params.put("status", 2);
        List<BlogQuestion> questionList = baseDAO.find_OrderDesc(BlogQuestion.class, params);
        request.setAttribute("questions", questionList);

        return "welcome_blog";
    }


    @RequestMapping(value = "/add-question", method = RequestMethod.POST)
    @ResponseBody
    public String Add_Question(@Param BlogQuestion bq) {

        System.out.println("AAAAAAAAAAAA = " + bq.getFullName());

        BlogQuestion blog = new BlogQuestion();
        blog.setFullName(bq.getFullName());
        blog.setEmail(bq.getEmail());
        blog.setTitle(bq.getTitle());
        blog.setText(bq.getText());
        blog.setStatus(1);
        blog.setCreated(new Date());
        try {

            baseDAO.save(blog);

        } catch (Exception e) {
            e.printStackTrace();
            return "Add question is failed";
        }

        return "successfuly";
    }


    long question_id;

    @RequestMapping(value = "/questionby-id/{questionid}")
    public String QuestionById(@PathVariable long questionid, ModelMap map) {


        BlogQuestion questionList = baseDAO.findWithParams(BlogQuestion.class, "id", questionid /*Long.parseLong("1")*/);
        map.put("question_text", questionList.getText());
        map.put("question_title", questionList.getTitle());
        question_id = questionList.getId();


        Map<String, Object> params = new HashMap<>();
        params.put("question.id", questionid);
        List<BlogAnswer> answers = baseDAO.find_OrderDesc(BlogAnswer.class, params);
        map.put("answers", answers);

        return "byIdquestion";
    }


    @RequestMapping(value = "/add-answer", method = RequestMethod.POST)
    @ResponseBody
    public String Add_Answer(@Param BlogAnswer ba) {


        BlogAnswer blog = new BlogAnswer();
        BlogQuestion blogQuestion = new BlogQuestion();
        blogQuestion.setId(question_id);
        blog.setQuestion(blogQuestion);
        blog.setEmail(ba.getEmail());
        blog.setUserName(ba.getUserName());
        blog.setDescription(ba.getDescription());
        blog.setStatus(1);
        blog.setDate(new Date());
        try {

            baseDAO.save(blog);

        } catch (Exception e) {
            e.printStackTrace();
            return "Add answer is failed";
        }

        return "successfuly";
    }

}
