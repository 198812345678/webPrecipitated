package com.corp.will.jetty.jettyContinuation;

import org.eclipse.jetty.continuation.Continuation;
import org.eclipse.jetty.continuation.ContinuationSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * https://examples.javacodegeeks.com/enterprise-java/jetty/jetty-continuations-example/
 * Created by will.wang on 2017/2/25.
 */
public class ContinuationsExampleServlet extends HttpServlet {
    private static final long serialVersionUID = 296854298600785824L;

    /**
     * Default constructor.
     */
    public ContinuationsExampleServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestId = request.getParameter("id");

        Continuation cont = ContinuationSupport.getContinuation(request);

        response.setContentType("text/html");

        response.getWriter().println("Request id is : " + requestId + " start: " + new Date());

        cont.setTimeout(3000);
        cont.suspend();

        response.setContentType("text/html");
        response.getWriter().println("Request id is : " + requestId + " end: " + new Date());
        if(cont.isInitial() != true)
        {
            cont.complete();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
