function deleteCate(cateId) {
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then(function () {
        $.ajax({
            url: "category",
            method: "post",
            dataType: "json",
            data: {
                Action: "delete",
                CateId: cateId
            },
            success : function(data){
                if(data)
                Swal.fire(
                    'Deleted!',
                    'Your file has been deleted.',
                    'success'
                )

            }
        });
        location.reload();
    })
}
$('#exampleModal').on('shown.bs.modal', function () {
    $('#exampleModal').trigger('focus')
})
// create category
function CreateCateory(){
    cateurl = document.getElementById('CateImage').value;
    catename = document.getElementById('CateName').value;
    catetitle = document.getElementById('CateTitle').value;
    $.ajax({
        url: "category",
        method: "post",
        dataType: "json",
        data: {
            Action: "create",
            CateName: catename,
            CateTitle: catetitle,
            CateUrl: cateurl
        },
        success : function(data){
            // if(data)
                Swal.fire(
                    'Thành công!',
                    'Your file has been deleted.',
                    'success'
                )
            alert(data);
        }
    });
    location.reload();
}
// upate  cate


$('#updateCateModal').on('shown.bs.modal', function () {
    $('#updateCateModal').trigger('focus')

});

function viewCate(id){

    document.getElementById("CateNameED").value  = document.getElementById('name_'+id).innerText;
    document.getElementById("CateTitleED").value = document.getElementById("title_"+id).innerText;
    document.getElementById("CateImageED").value = document.getElementById("image_"+id).innerText;
    document.getElementById("updatecateid").innerHTML = id;
}

function UpdateCateory(){
    cateurl = document.getElementById('CateImageED').value;
    catename = document.getElementById('CateNameED').value;
    catetitle = document.getElementById('CateTitleED').value;
    cateid =document.getElementById("updatecateid").innerText;
    $.ajax({
        url: "category",
        method: "post",
        dataType: "json",
        data: {
            Action: "update",
            CateId: cateid,
            CateName: catename,
            CateTitle: catetitle,
            CateUrl: cateurl
        },
        success : function(data){
            if(data)
            Swal.fire(
                'Thành công!',
                'Your file has been deleted.',
                'success'
            )
        }
    });
    resp.sendRedirect("TestExecutionESO.jsp");
}