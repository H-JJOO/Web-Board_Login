package com.koreait.board3.user;

import com.koreait.board3.MyUtils;
import com.koreait.board3.dao.UserDAO;
import com.koreait.board3.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    //로그인 화면 띄우는 담당
        MyUtils.disForward(req, res, "user/login");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    //로그인 기능 담당
        String uid = req.getParameter("uid");
        String upw = req.getParameter("upw");

        UserVO param = new UserVO();
        param.setUid(uid);
        param.setUpw(upw);

        int result = UserDAO.login(param);

        if (result == 1) {
            //세션 로그인 처리
            param.setUpw(null);//param 에 있는 upw 값 지움, 쓸일없어서 (용량 차지하지 않게)
            HttpSession session = req.getSession();
            session.setAttribute("loginUser", param);
            //iuser, nm, uid
            //session 에서 getAttribute 하면 param 객체 주소값을 받아올수 있다.

            res.sendRedirect("/board/list");
            return;//이거 없으면 안됩니다~
        }
        String err = null;
        switch (result) {
            case 0:
                err = "로그인에 실패하였습니다.";
                break;
            case 2:
                err = "아이디를 확인해 주세요.";
                break;
            case 3:
                err = "비밀번호를 확인해 주세요.";
                break;
        }
        // result 가 1이 아니면
        req.setAttribute("err", err);
        doGet(req, res);
    }
}
