package com.servlet;

import com.dao.CategoryDao;
import com.dao.ProductDao;
import com.model.CategoryEntity;
import com.model.ProductEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet",urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {
    CategoryDao catedao= new CategoryDao();
    ProductDao productDao = new ProductDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CategoryEntity> listcate = catedao.listCate();
        List<ProductEntity> listproduct = productDao.getlistProductHome();
        request.setAttribute("categorys", listcate);
        request.setAttribute("products",listproduct);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
