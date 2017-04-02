package com.gxhdx.controller;

import com.gxhdx.entity.Constants;
import com.gxhdx.entity.Student;
import com.gxhdx.service.StudentService;
import com.gxhdx.support.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/3/30/030.
 */
@Controller
@RequestMapping("/portal")
public class LoginController {

    @Autowired
    private StudentService studentService;

//    @Autowired
//    private AcademyService academyService;

    @ResponseBody
    @RequestMapping("/login")
    public Object login(HttpServletRequest request, HttpServletResponse response,Student student,Model model) {
        if (isValid(student)) {
            HttpSession  httpSession =request.getSession();
            httpSession.setAttribute(Constants.USER_NAME_KEY,student.getStudentName());
//            request.getSession().setAttribute(Constants.STUDENTNAME_KEY, student.getStudentName());
        } else {
            return new Result(false, student);
        }
        return new Result(true, student);
    }

//    @RequestMapping("/login")
//    public String login(HttpServletRequest request, HttpServletResponse response) {
//        // HttpSession session = request.getSession();
//        // session.invalidate();
//        // response.addHeader("x-frame-options", "DENY");
//        return "common/login";
//    }
    @ResponseBody
    @RequestMapping("/register")
    public Object register(HttpServletRequest request, HttpServletResponse response, Student student, Model model) {
        try {
            student = studentService.saveOrUpdate(student);
            HttpSession  httpSession =request.getSession();
            httpSession.setAttribute(Constants.USER_NAME_KEY,student.getStudentName());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, student);
        }
        return new Result(true, student);
    }

    @ResponseBody
    @RequestMapping("/logout")
    public Object logout(HttpServletRequest request, HttpServletResponse response,HttpSession httpSession){

        httpSession.invalidate();
        return new Result(true,"注销成功！！！");
    }

//    @ResponseBody
//    @RequestMapping("/getAcademy")
//    public Object getAcademy(){
//        List<Academy> academylist = academyService.findAll();
//        return academylist;
//    }

    public boolean isValid(Student student) {
        List<Student> list = studentService.findAll();
        if (student != null) {
            for(int i=0; i<list.size(); i++){
                if (student.getStudentName().equals(list.get(i).getStudentName())
                        && student.getPassword().equals(list.get(i).getPassword())){
                    return true;
                }
            }
        }
        return false;
    }
}
