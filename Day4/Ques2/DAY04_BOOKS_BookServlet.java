import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/books")
public class BookServlet extends HttpServlet {
    private BookDAO dao = new BookDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            if (action == null) action = "list";
            switch(action) {
                case "new":
                    req.getRequestDispatcher("book-form.jsp").forward(req, resp); break;
                case "insert":
                    insert(req, resp); break;
                case "edit":
                    showEditForm(req, resp); break;
                case "update":
                    update(req, resp); break;
                case "delete":
                    delete(req, resp); break;
                default:
                    list(req, resp); break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<Book> list = dao.listAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("book-list.jsp").forward(req, resp);
    }

    private void insert(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        double price = Double.parseDouble(req.getParameter("price"));
        dao.insert(new Book(0, title, author, price));
        resp.sendRedirect("books");
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Book b = dao.get(id);
        req.setAttribute("book", b);
        req.getRequestDispatcher("book-form.jsp").forward(req, resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        double price = Double.parseDouble(req.getParameter("price"));
        dao.update(new Book(id, title, author, price));
        resp.sendRedirect("books");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        dao.delete(id);
        resp.sendRedirect("books");
    }
}
