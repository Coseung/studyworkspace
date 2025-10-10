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
 * Servlet implementation class BoardInsertController
 */
@WebServlet("/insert.bo")
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertController() {
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


		Board b = Board.insertCreateMember(boardType, categoryNo, title, content, loginMember.getMemberNo());
		int result = new BoardService().insertBoard(b);

		if (result > 0) { // 가입성공
			request.getSession().setAttribute("alertMsg", "성공적으로 게시판등록이 완료되었습니다..");

			response.sendRedirect(request.getContextPath() + "/list.bo");

		} else { // 가입실패
			request.setAttribute("errorMsg", "게시판등록에 실패하였습니다.");
			request.getRequestDispatcher("views/common/error.jsp");
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
