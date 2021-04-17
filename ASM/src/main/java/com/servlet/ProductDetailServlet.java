package com.servlet;

import com.dao.ProductDao;
import com.model.ProductEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductDetailServlet",urlPatterns = {"/product_detail"})
public class ProductDetailServlet extends HttpServlet {
    ProductDao productDao = new ProductDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String prstr = request.getParameter("id");
        int prid = 0;
        if(prstr != null){
            prid =  Integer.parseInt(prstr) ;
        }
        ProductEntity product = productDao.producDetail(prid);
        request.setAttribute("product",product);
        request.getRequestDispatcher("product_detail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
