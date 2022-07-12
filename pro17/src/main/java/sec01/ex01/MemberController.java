package sec01.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
//@WebServlet("/mem.do")
public class MemberController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   MemberDAO memberDAO;
   
   public void init(ServletConfig config) throws ServletException {
      memberDAO = new MemberDAO();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //get 방식으로 와도 handle로 가고
      doHandle(request,response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // post 방식으로 와도 handle로 가도록 함
      doHandle(request,response);
   }
   private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8"); // 
      response.setContentType("text/html; charset=UTF-8");
      List membersList = memberDAO.listMembers();
      request.setAttribute("membersList", membersList);
      RequestDispatcher dispatch = request.getRequestDispatcher("test01/listMembers.jsp");
      dispatch.forward(request, response);
   }
}