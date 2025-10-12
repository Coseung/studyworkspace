package com.kh.jsp.controller.board;

import java.io.IOException;

import com.kh.board.model.vo.Board;
import com.kh.board.service.BoardService;
import com.kh.jsp.model.vo.Member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class BoardUpdateInsertController
 */
@WebServlet("/updateinsert.bo")
public class BoardUpdateInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		Member loginMember = (Member) session.getAttribute("loginMember");
		int boardType = 1; // 일반 게시글 일때 어떤방식으로 가져와야하는지 모르겠어서 하드코딩
		int categoryNo = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int boardDetailNo = Integer.parseInt(request.getParameter("bno"));

		Board b = Board.updateBoard(boardDetailNo, boardType, categoryNo, title, content);

		int result = new BoardService().updateBoard(b);
		if (result > 0) {
			request.getSession().setAttribute("alertMsg", "게시글 수정 성공");
			response.sendRedirect(request.getContextPath() + "/detail.bo?bno=" + b.getBoardNo());
		} else {

			request.setAttribute("errorMsg", "게시글 수정 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
