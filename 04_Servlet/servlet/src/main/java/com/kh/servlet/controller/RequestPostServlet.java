package com.kh.servlet.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.String;

/**
 * Servlet implementation class RequestPostServlet
 */
@WebServlet("/posttest.do")
public class RequestPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST요청이나 GET요청에 대해서 동일하게 응답을 하겠다.
		//GET과 POST를 정하기 이전에 특정 url로 요청이 되었다는 것은 특정 기능을 수행하겠다는 의 미 
		//결과는 같은 페이지를 출력, 응답하는 입장에서 다르게 코드를 작성할 이유가 없다.
		String name = request.getParameter("name"); //최지원 | ""
		String gender = request.getParameter("gender"); // M | F | null
		int age = Integer.parseInt(request.getParameter("age")); // "55"-> 55 | ""
		String city = request.getParameter("city"); // "경기" | "서울" | "대구"등...
		double height = Double.parseDouble(request.getParameter("height")); // "180.0" -> 180.0
		
		//체크박스와같이 여러개의 값을 추출하고자할 때
		String[] foods = request.getParameterValues("food"); //["한식", "일식"] || null
		
		System.out.println("name : " + name);
		System.out.println("gender : " + gender);
		System.out.println("age : " + age);
		System.out.println("city : " + city);
		System.out.println("height : " + height);
		System.out.println("foods : " + String.join(", ", foods));
		
		
		//응답페이지를 만드는 과정을 jsp에게 위임
		//단, 응답화면에서 필요로하는 데이터들을 차곡차곡담아서 전달해줘야한다.
		//데이터들을 담기위한 공간 == request의 attribute영역
		//request.setAttribute("키", 값)
		
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("city", city);
		request.setAttribute("height", height);
		request.setAttribute("gender", gender);
		request.setAttribute("foods", foods);
		
		//서블릿에서 다른 리소스(jsp, 또다른 서블릿)로 요청을 전달(포워드)하거나 
		//기존응답에 내용을 추가할 수 있게 해주는 객체 
		RequestDispatcher view = request.getRequestDispatcher("/views/responsePage.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
