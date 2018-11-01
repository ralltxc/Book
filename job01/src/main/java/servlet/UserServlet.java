package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entity.Users;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/html;charset=utf-8");
		
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		
		if ("/login".equals(path)) {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			Users u = UserDao.check(username, password);
			if(u!=null){
				
				HttpSession session = request.getSession();
				
				session.setAttribute("user", u);
				
				response.sendRedirect("list.user");
			}else{
				request.setAttribute("login_failed", "用户名或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else if ("/list".equals(path)) {
			List<Users> users=UserDao.selectUser();
			request.setAttribute("users", users);
			
			request.getRequestDispatcher("listUser.jsp").forward(request, response);
		}else if ("/insert".equals(path)) {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			int flag=UserDao.insertUser(username, password);
			if(flag==1){
				response.sendRedirect("list.user");
			}else {
				request.setAttribute("error", "�û����Ѵ���");
				request.getRequestDispatcher("insertUser.jsp").forward(request, response);
			}
		}else if ("/update".equals(path)) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			String password = request.getParameter("password");
			
			Integer flag=UserDao.updateUserPWD(id, password);
			if(flag==1){
				response.sendRedirect("list.user");
			}else {
				request.setAttribute("falied", "系统繁忙，请稍后重试");
				request.getRequestDispatcher("failed.jsp").forward(request, response);
			}
		}else if ("/delete".equals(path)){
			Integer id = Integer.parseInt(request.getParameter("id"));
			Integer flag=UserDao.deleteUserPWD(id);
			
			if(flag==1){
				response.sendRedirect("list.user");
			}else {
				request.setAttribute("failed", "系统繁忙，请稍后重试");
				request.getRequestDispatcher("failed.jsp").forward(request, response);
			}
		}
	}

}
