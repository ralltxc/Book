package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import entity.Book;


public class BooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			String uri = request.getRequestURI();
			String path = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
			if("/list".equals(path)){
				BookDAO dao = new BookDAO();
				try {
					List<Book> books = dao.findAll();
					request.setAttribute("books", books);
					RequestDispatcher rd = request.getRequestDispatcher("Listbooks.jsp");
					rd.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
					request.setAttribute("error", "ϵͳ��æ���Ժ����ԣ�");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			}else if("/add".equals(path)){
				String isbn=request.getParameter("isbn");
				String typeid=request.getParameter("typeid");
				String bookname=request.getParameter("bookname");
				String author=request.getParameter("author");
				String publish=request.getParameter("publish");
				String publishdate=request.getParameter("publishdate");
				String publishtime=request.getParameter("publishtime");
				String unitprice=request.getParameter("unitprice");
				System.out.println(isbn+", "+typeid+", "+bookname+", "+author+", "+", "+publish+", "+publishdate+", "+publishtime+", "+unitprice);
				BookDAO dao = new BookDAO();
				try {
					Book book = new Book();
					book.setIsbn(isbn);
					book.setTypeid(Integer.parseInt(typeid));
					book.setBookname(bookname);
					book.setAuthor(author);
					book.setPublish(publish);
					book.setPublishdate(publishdate);
					book.setPublishtime(Integer.parseInt(publishtime));
					book.setUnitprice(Double.parseDouble(unitprice));
					dao.save(book);
					response.sendRedirect("list.book");
				} catch (Exception e) {
					e.printStackTrace();
					out.println("ϵͳ��æ���Ժ�����");
				}
			
			}else if("/del".equals(path)){
				String isbn = request.getParameter("isbn");
				BookDAO dao = new BookDAO();
				try {
					dao.delete(isbn);
					response.sendRedirect("list.book");
					out.println("ɾ���ɹ�");
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
					out.println("ϵͳ��æ���Ժ�����");
				}
			}else if("/update".equals(path)){
				String isbn=request.getParameter("isbn");
				String typeid=request.getParameter("typeid");
				String bookname=request.getParameter("bookname");
				String author=request.getParameter("author");
				String publish=request.getParameter("publish");
				String publishdate=request.getParameter("publishdate");
				String publishtime=request.getParameter("publishtime");
				String unitprice=request.getParameter("unitprice");
				System.out.println(unitprice);
				BookDAO dao = new BookDAO();
				dao.update(isbn,Integer.parseInt(typeid), bookname, author,publish, publishdate,Integer.parseInt(publishtime), Double.parseDouble(unitprice));
				response.sendRedirect("list.book");
			}
			}

}
