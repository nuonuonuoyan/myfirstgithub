package com.yunsi.web;

import com.yunsi.domain.User;
import com.yunsi.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过表单中输入框的name属性接收三个参数;loginname,password和randCode(验证码)
        String loginname = request.getParameter("loginName");
        String password = request.getParameter("password");
        String randCode = request.getParameter("randCode");

        System.out.println(randCode);

        //获取session对象
        HttpSession session = request.getSession();
        //从session对象中获取网页生成的验证码
        //Object引用指向字符串，可以调用toString方法把Object转型成String类型，相当于在前面加（String）
        String rand = session.getAttribute("rand").toString();
        //判断验证码是否成功生成
        if(rand=="null"){
            request.setAttribute("msg","验证码生成失败");
            request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request,response);
            return;
        }
        //如果通过上面的验证，将网页生成的验证码和用户传入的验证码相比较(不区分大小写)
        if(!rand.equalsIgnoreCase(randCode)){
            request.setAttribute("msg","验证码错误");
            request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request,response);
            return;
        }
        //查询用户记录是否存在
        User user = new User();
        user.setUsername(loginname);
        user.setPassword(password);
        UserService service = new UserService();
        User user2 = service.login(user);//根据用户传来的参数new一个User对象进行查询，并把查询结果返回给user2
        if(null==user2){
            request.setAttribute("msg","用户名或密码错误");
            request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request,response);
            return;
        }else {
            request.setAttribute("msg","登录成功");
            request.getRequestDispatcher("WEB-INF/jsp/faceCheck.jsp").forward(request,response);
            return;
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
