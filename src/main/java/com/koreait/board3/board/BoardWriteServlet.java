package com.koreait.board3.board;

import com.koreait.board3.MyUtils;
import com.koreait.board3.dao.BoardDAO;
import com.koreait.board3.model.BoardVO;
import com.koreait.board3.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/board/write")
public class BoardWriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (MyUtils.isLogOut(req)) {
            res.sendRedirect("/board/list");
            return;
        }
        MyUtils.disForward(req, res, "board/write");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String title = req.getParameter("title");
        String ctnt = req.getParameter("ctnt");

        HttpSession session = req.getSession();
        UserVO loginUser = (UserVO)session.getAttribute("loginUser");

        BoardVO param = new BoardVO();

        param.setTitle(title);
        param.setCtnt(ctnt);
        param.setWriter(loginUser.getIuser());

        int result = BoardDAO.insBoard(param);

        switch (result) {
            case 1:
                res.sendRedirect("/board/list");
                break;
            case 0:
                req.setAttribute("err", "글쓰기 등록을 실패햐였습니다.");
                doGet(req, res);
                break;
        }


    }
}
