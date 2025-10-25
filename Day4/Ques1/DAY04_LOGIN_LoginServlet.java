import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/day04db";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginid = req.getParameter("loginid");
        String password = req.getParameter("password");
        String error = null;

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS)) {
            String sql = "SELECT password, name FROM users WHERE loginid = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, loginid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String pw = rs.getString("password");
                if (pw.equals(password)) {
                    HttpSession session = req.getSession();
                    session.setAttribute("user", rs.getString("name"));
                    resp.sendRedirect("welcome.jsp");
                    return;
                } else {
                    error = "Invalid credentials";
                }
            } else {
                error = "User not found";
            }
        } catch (SQLException e) {
            error = "DB error: " + e.getMessage();
        }
        req.setAttribute("error", error);
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
