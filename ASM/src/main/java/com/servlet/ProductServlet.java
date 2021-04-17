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

@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {
    ProductDao productDao = new ProductDao();
    CategoryDao catedao= new CategoryDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String catestr = request.getParameter("cateid");
        int cateid = 0;
        if(catestr != null){
            cateid =  Integer.parseInt(catestr) ;
        }
        List<CategoryEntity> listcate = catedao.listCate();
        List<ProductEntity> listproduct = productDao.getlistProduct(cateid);
        request.setAttribute("categorys", listcate);
        request.setAttribute("products",listproduct);
        request.getRequestDispatcher("product.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
