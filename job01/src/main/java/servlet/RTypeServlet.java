package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReaderTypeDao;
import entity.ReaderType;

public class RTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		System.out.println(path);
		if ("/list".equals(path)) {
			List<ReaderType> list = ReaderTypeDao.selectReaderType();
			request.setAttribute("list", list);
			request.getRequestDispatcher("listRType.jsp").forward(request, response);
		}else if ("/insert".equals(path)) {
			Integer id = Integer.parseInt(request.getParameter("rid"));
			String name = request.getParameter("rname");
			Integer max = Integer.parseInt(request.getParameter("rmax"));
			Integer limit = Integer.parseInt(request.getParameter("limit"));
			Integer flag = ReaderTypeDao.insertReaderType(id, name, max, limit);
			if (flag==1) {
				response.sendRedirect("list.rt");
			}else {
				request.setAttribute("error", "请输入正确的数据");
				request.getRequestDispatcher("addRType.jsp").forward(request, response);
			}
		}else if ("/update".equals(path)) {
			Integer id = Integer.parseInt(request.getParameter("rid"));
			String name = request.getParameter("rname");
			Integer max = Integer.parseInt(request.getParameter("rmax"));
			Integer limit = Integer.parseInt(request.getParameter("limit"));
			Integer flag = ReaderTypeDao.updateReaderType(id, name, max, limit);
			if (flag==1) {
				response.sendRedirect("list.rt");
			}else {
				request.setAttribute("error", "请输入正确的数据");
				request.getRequestDispatcher("addRType.jsp").forward(request, response);
			}
		}else if ("/del".equals(path)) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			Integer flag = ReaderTypeDao.deleteReaderType(id);
			if (flag==1) {
				response.sendRedirect("list.rt");
			} else {
				System.out.println("删除失败");
			}
		}else if ("/listtype".equals(path)) {
			String type = request.getParameter("type");
			List<ReaderType> list = ReaderTypeDao.selectReaderType(type);
			if(!list.isEmpty()){
				request.setAttribute("list", list);
				request.getRequestDispatcher("listRType.jsp").forward(request, response);
			}else {
				response.sendRedirect("list.rt");
			}
			
		}
	}

}
