import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "InscriptionServlet",urlPatterns = "/inscription")
public class InscriptionServlet extends HttpServlet {
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        con = ConnectionManager.getConnection();
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int r ;
        try {
            r = stmt.executeUpdate("insert into users (id,nom,email,pass) VALUES (NULL ,"+nom+","+email+","+pass+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //rs = stmt.executeQuery(sql);


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h1>Inscription effectué </h1>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
