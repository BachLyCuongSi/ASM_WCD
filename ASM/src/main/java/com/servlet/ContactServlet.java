package com.servlet;

import com.dao.ContactDao;
import com.model.ContactEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ContactServlet", urlPatterns = {"/contact"})
public class ContactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("contact.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactEntity contact = new ContactEntity();
        contact.setName(request.getParameter("name"));
        contact.setEmail(request.getParameter("email"));
        contact.setSubject(request.getParameter("subject"));
        contact.setMessage(request.getParameter("message"));

        ContactDao dao = new ContactDao();
        dao.insertContact(contact);
        request.getRequestDispatcher("contact.jsp").forward(request,response);
    }
}
