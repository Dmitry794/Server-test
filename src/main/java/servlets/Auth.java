package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/oauth/v2/token")
public class Auth extends HttpServlet{
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
/*
{
  "access_token": "91936764-c2f7-4c1a-9b93-fc0ba36f3d29",
  "token_type": "Bearer",
  "expires_in": 8640000,
  "refresh_token": "7ad571a4-fa36-4a2c-a6f0-5398c3afefa2",
  "scope": "MeterIT"
}
 */
    String token = "{\n" +
      "  \"access_token\": \"91936764-c2f7-4c1a-9b93-fc0ba36f3d29\",\n" +
      "  \"token_type\": \"Bearer\",\n" +
      "  \"expires_in\": 8640000,\n" +
      "  \"refresh_token\": \"7ad571a4-fa36-4a2c-a6f0-5398c3afefa2\",\n" +
      "  \"scope\": \"MeterIT\"\n" +
      "}";
    response.setContentType("application/json");
    PrintWriter out = response.getWriter();
    out.print(token);


  }
}
