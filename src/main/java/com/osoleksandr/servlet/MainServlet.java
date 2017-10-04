package com.osoleksandr.servlet;

import com.osoleksandr.model.Category;
import com.osoleksandr.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().equals("/home") && request.getMethod().equals("GET")) {
            request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
        }
        if (request.getRequestURI().equals("/categories") && request.getMethod().equals("GET")) {
            List<Category> categoryList = new ArrayList<>();
            request.setAttribute("categoryAtt", categoryList);
            String sql = "SELECT * FROM CATEGORIES";
            try {
                Statement statement = connection().createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    String name = resultSet.getString("CATEGORY_NAME");
                    String description = resultSet.getString("DESCRIPTION");
                    Category category = new Category(name, description);
                    categoryList.add(category);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("/WEB-INF/views/categories.jsp").forward(request, response);
        }
        if (request.getRequestURI().equals("/registration") && request.getMethod().equals("GET")) {
            request.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(request, response);
        }
        if (request.getRequestURI().equals("/registration") && request.getMethod().equals("POST")) {
            String username = request.getParameter("userName");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            User user = new User(username, password, email);
            String sql = "INSERT INTO USERS (USERNAME, PASSWORD, EMAIL) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection().prepareStatement(sql);
                preparedStatement.setString(1, user.getUserName());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
        }
    }

    public static Connection connection() {
        Connection result = null;
        try {
            Class.forName("org.h2.Driver");
            result = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
