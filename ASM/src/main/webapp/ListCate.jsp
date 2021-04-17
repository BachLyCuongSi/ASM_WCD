<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 4/15/2021
  Time: 6:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="lscate" value="${requestScope.lscate}" />
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<%--    bootrap--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<%--    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>--%>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.all.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/ajax.js" type="text/javascript"></script>
<%--    <script src="js/sweetaler2.js" ></script>--%>
    <link rel="stylesheet" href="css/sweetaler2.css">

</head>
<body>
<h1>Category</h1>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
    Create category
</button>
<table class="w3-table w3-striped">
    <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Title</th>
    <th>Image</th>
    <th>Action</th>
  </tr>
  <c:forEach var="cate" items="${lscate}">
  <tr>
      <td>${cate.id}</td>
      <td id="name_${cate.id}">${cate.name}</td>
      <td id="title_${cate.id}">${cate.title}</td>
      <td id="image_${cate.id}">${cate.url_image}</td>
      <td>
          <a data-toggle="modal" data-target="#updateCateModal" onclick="viewCate(${cate.id})" />  Edit  </a>
             |
          <a onclick="deleteCate(${cate.id})" class="delete" > Delete  </a>
      </td>
  </tr>
  </c:forEach>


</table>




<!-- Modal create-->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Create Category</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group row">
                        <label for="CateName" class="col-sm-4 col-form-label">Category Name</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="CateName" placeholder="Category Name" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="CateTitle" class="col-sm-4 col-form-label">Category Title</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="CateTitle" placeholder="Category title" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="CateImage" class="col-sm-4 col-form-label">Url Image</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="CateImage" placeholder="Category Image" required>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="CreateCateory()">Save changes</button>
            </div>
        </div>
    </div>
</div>

<%--//   modal edit--%>
<div class="modal fade" id="updateCateModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" >Update Category</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group row">
                        <h1 id="updatecateid" hidden="hidden"></h1>
                        <label for="CateNameED" class="col-sm-4 col-form-label">Category Name</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="CateNameED"  required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="CateTitleED" class="col-sm-4 col-form-label">Category Title</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="CateTitleED" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="CateImageED" class="col-sm-4 col-form-label">Url Image</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="CateImageED"  required>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="UpdateCateory()">Save changes</button>
            </div>
        </div>
    </div>
</div>
</form>
</body>
</html>
