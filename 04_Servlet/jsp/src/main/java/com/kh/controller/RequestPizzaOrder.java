package com.kh.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class RequestPizzaOrder
 */
@WebServlet("/confirmPizza.do")
public class RequestPizzaOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestPizzaOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String message = request.getParameter("message");
		String pizza = request.getParameter("pizza");
		String[] pizzatopping = request.getParameterValues("topping");
		String[] sides = request.getParameterValues("side");
		String pay = request.getParameter("payment");
		
		int price =0;
		switch(pizza){
		case "콤비네이션": price +=20000; break;
		case "치즈피자":
		case "포테이토피자": price += 23000; break;
		default: price+= 25000; break;
			
		}
		if( pizzatopping != null) {
			for(String topping : pizzatopping) {
				switch(topping) {
				case "베이컨":
				case "파인애플": price += 3000; break;
				
				case "치즈크러스트":
				case "치즈바이트": price += 2000;break;
				
				default: price += 1000;
				}
			}
		}
		
		if(sides != null) {
			for(String side : sides) {
				switch(side) {
				case "환타":
				case "콜라" : price +=3000; break;
				case "핫소스": 
				case "파마산":
				case "피클" : price+= 2000; break;
				default : price += 1000; break;
				}
			}
		}
		
		
		request.setAttribute("userName", name);
		request.setAttribute("phone", phone);
		request.setAttribute("address", address);
		request.setAttribute("message", message);
		request.setAttribute("pizza", pizza);
		request.setAttribute("pizzatopping", pizzatopping );
		request.setAttribute("sides", sides);
		request.setAttribute("pay", pay);
		request.setAttribute("price", price);
		
		RequestDispatcher view = request.getRequestDispatcher("/pizza/pizzaOrderResult.jsp");
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
