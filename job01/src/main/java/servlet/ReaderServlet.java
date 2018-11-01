package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReaderDao;
import entity.Reader;

public class ReaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/html;charset=utf-8");
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		System.out.println(path);
		
		if ("/list".equals(path)) {
			//1.将reader表中的所有用户信息查询出来
			ReaderDao read = new ReaderDao();
			try {
				List<Reader> reader = read.findAll();
				//2.依据查询到的用户信息，输出表格
				/*
				 * 转发
				 * 1.绑定数据到request对象上
				 */
				request.setAttribute("read", reader);
				/*
				 * 2.获得转发器
				 */
				RequestDispatcher rd = request.getRequestDispatcher("listReader.jsp");
				/*
				 * 3.转发
				 */
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				//绑定数据
				request.setAttribute("error", "系统繁忙，稍后重试");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			} 
		}else if ("/add".equals(path)) {
			// 读取用户信息
			String readerid = request.getParameter("readerid");
			int type = Integer.parseInt(request.getParameter("type"));
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String sex = request.getParameter("sex");
			String phone = request.getParameter("phone");
			String dept = request.getParameter("dept");
			String regdate = request.getParameter("regdate");
			
			System.out.println(readerid+","+type+","+name+","+age+","+sex+","+phone+","+dept+","+regdate);
			// 将用户信息插入到数据库
			ReaderDao dao = new ReaderDao();
			try {

				// 判断是否存在
				if ("".equals(readerid) || "".equals(name)) {
					// 添加失败
					request.setAttribute("add_failed", "读者编号或姓名不能为空");
					request.getRequestDispatcher("addReader.jsp").forward(request, response);
				} else {
					Reader read = new Reader();
					read.setReaderid(readerid);
					read.setType(type);
					read.setName(name);
					read.setAge(age);
					if ("m".equals(sex)) {
						read.setSex("男");
					}else {
						read.setSex("女");
					}
					read.setPhone(phone);
					read.setDept(dept);
					read.setRegedate(regdate);
					dao.save(read); 
					// 添加成功重定向到用户列表
					response.sendRedirect("list.reader");
				}

			} catch (Exception e) {
				e.printStackTrace();

			}
		}else if ("/del".equals(path)) {
			//读取要删除的用户id
			String id = request.getParameter("readerid");
			//删除指定id的用户
			ReaderDao read = new ReaderDao();
			try {
				read.delete(id);
				response.sendRedirect("list.reader");
			}catch(Exception e){
				e.printStackTrace();
				request.setAttribute("error", "系统繁忙，稍后重试");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}else if ("/update".equals(path)) {
			//读取要修改的用户信息
			String id = request.getParameter("readerid");
			System.out.println(request.getParameter("type"));
			Integer type = Integer.parseInt(request.getParameter("type"));
			
			String name = request.getParameter("name");
			Integer age = Integer.parseInt(request.getParameter("age"));
			String sex = request.getParameter("sex");
			String phone = request.getParameter("phone");
			String dept = request.getParameter("dept");
			String reg = request.getParameter("regdate");
			
			ReaderDao read = new ReaderDao();
			try {
				read.update(id, type, name, age, sex, phone, dept, reg);
				response.sendRedirect("list.reader");
			}catch(Exception e){
				e.printStackTrace();
				request.setAttribute("error", "系统繁忙，稍后重试");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
	}

}
