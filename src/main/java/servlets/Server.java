package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

@WebServlet("/info")
public class Server extends HttpServlet {
    private static int count;
    private static String name;
    private static int timeout;
    private static int code;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        count++;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String nameParam = request.getParameter("name");
        if (nameParam != null){
            name = nameParam;
        }

        if (request.getParameter("timeout") != null){
            timeout = Integer.parseInt(request.getParameter("timeout"));
        }

        if (request.getParameter("code") != null){
            code = Integer.parseInt(request.getParameter("code"));
        }
        out.println("<center><h1>Server Start Page</h1><br>");
        out.println("<h2>Timeout: "+timeout+"</h2></center>");
        //out.println("<h2>Count: " + count + "</h2>");
        //out.println("<h2>Name: " + name + "</h2></center>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            TimeUnit.SECONDS.sleep(timeout);
            response.setStatus(code);
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.println("{\"Result\":\"OK\"}");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
