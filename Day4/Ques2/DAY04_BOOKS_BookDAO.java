import java.sql.*;
import java.util.*;

public class BookDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/day04books";
    private String jdbcUser = "root";
    private String jdbcPass = "";

    public BookDAO() {}

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPass);
    }

    public List<Book> listAll() throws SQLException {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Book b = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getDouble("price"));
                list.add(b);
            }
        }
        return list;
    }

    public Book get(int id) throws SQLException {
        String sql = "SELECT * FROM books WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getDouble("price"));
            }
        }
        return null;
    }

    public void insert(Book b) throws SQLException {
        String sql = "INSERT INTO books (title, author, price) VALUES (?,?,?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getTitle()); ps.setString(2, b.getAuthor()); ps.setDouble(3, b.getPrice());
            ps.executeUpdate();
        }
    }

    public void update(Book b) throws SQLException {
        String sql = "UPDATE books SET title=?, author=?, price=? WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getTitle()); ps.setString(2, b.getAuthor()); ps.setDouble(3, b.getPrice()); ps.setInt(4, b.getId());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM books WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id); ps.executeUpdate();
        }
    }
}
