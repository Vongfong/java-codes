package com.dragon.book.servletandjsp.chapter3.com.example.web;

import com.dragon.book.servletandjsp.chapter3.com.example.model.BeerExpert;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

/**
 * User: dengshenyan
 * Time: 2018-04-26 16:59
 */
public class BeerSelect extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Beer Selection Advice <br>");
        String c = request.getParameter("color");

        BeerExpert be = new BeerExpert();
        List result = be.getBrands(c);
//        Iterator iterator = result.iterator();
//        if (iterator.hasNext()) {
//            out.println("<br> Got beer color " + iterator.next());
//        }

        request.setAttribute("styles", result);
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response); // 转发请求和响应到JSP页面
    }

}
