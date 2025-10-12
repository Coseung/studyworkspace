package com.kh.jsp.controller.board;

import java.io.IOException;
import java.util.ArrayList;

import com.kh.board.model.vo.Category;
import com.kh.board.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class BoardEnrollFormController
 */
@WebServlet("/enrollForm.bo")
public class BoardEnrollFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardEnrollFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Category> list = new BoardService().selectCategoryList();
		HttpSession session = request.getSession();


		if (session.getAttribute("loginMember") == null) {
			session.setAttribute("alertMsg", "글쓰고싶으면 로그인을하시오.");
			response.sendRedirect(request.getContextPath());
		} else {
			if (list.isEmpty()) {
				session.setAttribute("alertMsg", "카테고리가 없어요.");
				request.getRequestDispatcher("views/common/error.jsp").forward(request, response);

			} else {
//				Member loginMember = (Member) session.getAttribute("loginMember");

				request.setAttribute("CategoryList", list);
				request.getRequestDispatcher("/views/board/enrollForm.jsp").forward(request, response);
		}


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
