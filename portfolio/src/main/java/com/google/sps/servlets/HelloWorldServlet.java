package com.google.sps.servlets;

import java.io.IOException;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    private static final long serialVersionUID = 7526472295622776147L;  // unique id

    @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    //make arraylist with unique greetings  
    ArrayList<String> greets = new ArrayList<>();
    greets.add("Hello");
    greets.add("Bonjour");
    greets.add("Konnichiwa");
    greets.add("Guten Tag");
    greets.add("Hola");
    greets.add("Namaste");
    greets.add("Hi");

    String json = convertToJsonUsingGson(greets);

    // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }
  
  /**
   * Converts an ArrayList into a JSON string using the Gson library. Note: We first added
   * the Gson library dependency to pom.xml.
   */
  private String convertToJsonUsingGson(ArrayList<String> greets) {
    Gson gson = new Gson();
    String json = gson.toJson(greets);
    return json;
  }

}
