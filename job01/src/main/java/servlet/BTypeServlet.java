package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookTypeDao;
import entity.Booktype;

public class BTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		System.out.println(path);
		if("/list".equals(path)){
			List<Booktype> list = BookTypeDao.selectBookType();
			request.setAttribute("list", list);
			request.getRequestDispatcher("listBookType.jsp").forward(request, response);
		}else if ("/insert".equals(path)) {
			Integer id = Integer.parseInt(request.getParameter("tid"));
			String tname = request.getParameter("tname");
			Integer nInteger = BookTypeDao.insertBookType(id, tname);
			if (nInteger==1) {
				response.sendRedirect("list.bt");
			}else {
				request.setAttribute("error", "请输入正确的数据");
				request.getRequestDispatcher("addBType.jsp").forward(request, response);
			}
		}else if ("/update".equals(path)){
			Integer id = Integer.parseInt(request.getParameter("tid"));
			String tname = request.getParameter("tname");
			Integer nInteger = BookTypeDao.updateBookType(id, tname);
			if (nInteger==1) {
				response.sendRedirect("list.bt");
			}else {
				request.setAttribute("error", "请输入正确的数据");
				request.getRequestDispatcher("updateBType.jsp").forward(request, response);
			}
		}else if ("/del".equals(path)) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			Integer n = BookTypeDao.deleteBookType(id);
			if (n>0) {
				response.sendRedirect("list.bt");
			}
		}else if ("/listtype".equals(path)) {
			String type = request.getParameter("type");
			List<Booktype> list = BookTypeDao.selectBookType(type);
			if (!list.isEmpty()) {
				request.setAttribute("list", list);
				request.getRequestDispatcher("listBookType.jsp").forward(request, response);
			}else {
				response.sendRedirect("list.bt");
			}
			
		}
	}

}
