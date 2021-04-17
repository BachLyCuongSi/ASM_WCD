package com.servlet;

import com.dao.CategoryDao;
import com.model.CategoryEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", urlPatterns = {"/category"})
public class CategoryServlet extends HttpServlet {
    CategoryDao dao = new CategoryDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<CategoryEntity> lscate = dao.listCategory();
        request.setAttribute("lscate",lscate);
        request.getRequestDispatcher("ListCate.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("Action");
        switch (action){
            case "delete":
                System.out.println("Delete cate");
                String cateid = request.getParameter("CateId");
                if(cateid != null){
                    int id = Integer.parseInt(cateid);
                    dao.deleteCate(id);
                }
                break;
            case "create":
                CategoryEntity cate = new CategoryEntity();
                cate.setName(request.getParameter("CateName"));
                cate.setTitle(request.getParameter("CateTitle"));
                cate.setUrl_image(request.getParameter("CateUrl"));
                dao.insertCategory(cate);
                break;
            case "update":
                System.out.println("update category");
                CategoryEntity cateupdate = new CategoryEntity();
                cateupdate.setId(Integer.parseInt(request.getParameter("CateId")));
                cateupdate.setName(request.getParameter("CateName"));
                cateupdate.setTitle(request.getParameter("CateTitle"));
                cateupdate.setUrl_image(request.getParameter("CateUrl"));
                dao.updateCate(cateupdate);
                break;
            default:
                break;
        }

        doGet(request,response);
    }


}
