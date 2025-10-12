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
 * Servlet implementation class BoardDetailController
 */
@WebServlet("/detail.bo")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Member loginMember = (Member) session.getAttribute("loginMember");
		int boardDetailNo = Integer.parseInt(request.getParameter("bno"));

		Board b = new BoardService().selctdetail(boardDetailNo);

		if (loginMember != null && loginMember.getMemberId().equals(b.getBoardWriter())) {
			request.setAttribute("isWriter", true);
		}

		if (b != null) {
			request.setAttribute("b", b);
			request.getRequestDispatcher("/views/board/detailView.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "게시물을 불러오는데 실패하였습니다.");
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
