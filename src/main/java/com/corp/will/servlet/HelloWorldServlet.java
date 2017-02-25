package com.corp.will.servlet;

import org.eclipse.jetty.continuation.Continuation;
import org.eclipse.jetty.continuation.ContinuationSupport;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by will.wang on 2015/12/7.
 */
public class HelloWorldServlet extends HttpServlet {

    private static final long serialVersionUID = 117443433919583159L;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        final Continuation continuation = ContinuationSupport
//                .getContinuation(req);
//        continuation.isInitial();
        resp.setContentType("text/html");
        resp.getWriter().write("hello");
        resp.getWriter().flush();
        System.out.println("hello world!");
    }
}
