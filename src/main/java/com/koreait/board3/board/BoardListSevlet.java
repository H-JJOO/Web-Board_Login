package com.koreait.board3.board;

import com.koreait.board3.MyUtils;
import com.koreait.board3.dao.BoardDAO;
import com.koreait.board3.model.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/board/list")
public class BoardListSevlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<BoardVO> list = BoardDAO.selBoardList();

        req.setAttribute("data", list);

        MyUtils.disForward(req, res, "board/list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
