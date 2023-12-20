$(document).ready(function(){

    var pstatus = $('#pstatus').val()
        if (pstatus == 'dashboard') {
            isiDashboard()
        }

        if (pstatus == 'pageObat') {
             isiTabelObat()
        }


    $('#obatButton').click(function () {
        $.ajax({
            url: "http://localhost/obat",
            type: 'GET',
            success: function (data) {
                window.open('/obat', '_self')
            }
        })
    })

    $('#beranda').click(function () {
        $.ajax({
            url: "http://localhost/dashboard",
            type: 'GET',
            success: function (data) {
                window.open('/dashboard', '_self')
            }
        })
    })

    function isiDashboard(){
        $.ajax({
            url: 'http://localhost/getapotek',
            type: 'GET',
            success: function (data) {
                var txt=''
                for(i = 0; i < data.length ; i ++){
                    txt += '<div class="col-sm-6">'
                    txt += '<div class="card mb-4" style="width: 32rem;">'
                    txt += '<img src="'+data[i].image_path+'" width="300" height="200" class="card-img-top" alt="...">'
                    txt += '<div class="card-body">'
                    txt += '<h5 class="card-title">'+data[i].nama+'</h5>'
                    txt += '<p class="card-text">'+data[i].alamat+'</p>'
                    txt += '<a href="#" class="btn btn-primary">Lokasi</a> </div> </div> </div>'
                }
                $('#isiDash').html(txt)
            }
        })
    }

    function isiTabelObat(){
            $.ajax({
                url: 'http://localhost/getobat',
                type: 'GET',
                success: function (data) {
                    var txt=''
                    txt+='<table class="table table-hover table-bordered"><thead class="table-dark"><tr>'
                    txt+='<td>Nama</td><td>Kategori</td><td>Deskripsi</td><td>Action</td> '
                    txt+='</tr></thead>'
                    txt+='<tbody>'
                    for(i = 0; i < data.length ; i ++){
                        txt+='<tr>'
                        txt+='<td>'+data[i].name+'</td>'
                        txt+='<td>'+data[i].category+'</td>'
                        txt+='<td>'+data[i].description+'</td>'
                        txt+='<td><button type="button" name="'+data[i].id+'" class="edtObat btn btn-warning"> '
                        txt+='<i class="bi bi-pencil-square"></i>'
                        txt+='</button>  |  '
                        txt+='<button type="button" name="'+data[i].id+'" class="dltObat btn btn-danger">'
                        txt+='<i class="bi bi-trash-fill"></i>'
                        txt+='</button></td>'
                        txt+='</tr>'
                    }
                    txt+='</tbody></table>'
                    $('#isiTabelObat').html(txt)

                    $('.edtObat').click(function(){
                        editId = $(this).attr('name')
                        //sesion storage
                        sessionStorage.setItem('editIds', editId)
                        bukaObatEdit()
                    })

                    $('.dltObat').click(function(){
                        deleteId = $(this).attr('name')
                        //sesion storage
                        sessionStorage.setItem('deleteIds', deleteId)
                        bukaObatDelete()
                    })
                }


            })
    }
//------------------- Delete Obat -----------------------\\
    function bukaObatDelete(){
        $.ajax({
            url     :'http://localhost/obatdelete',
            type    :'GET',
            dataType:'html',
            success:function(data){
                $('#modalDelete').modal('show')
                $('.idModalTitle').html('Hapus Obat')
                $('.isiModalDelete').html(data)
                hapusObat()
            }
        })
    }
    function hapusObat() {
        var deleteIds = sessionStorage.getItem('deleteIds')
        $.ajax({
            url: 'http://localhost/getobatbyid/' + deleteIds,
            type: 'GET',
            success: function (data) {
                $('.inputDelete').eq(0).val(data.name)
                $('.inputDelete').eq(1).val(data.category)
                $('.inputDelete').eq(2).val(data.description)
            }
        })
    }

    $('#obatBtnDelete').click(function(){
        var ids = sessionStorage.getItem('deleteIds')
        $.ajax({
            url:'http://localhost/deleteobat/'+ids,
            type:'DELETE',
            success:function(data){
                  isiTabelObat()
                  $('#modalDelete').modal('hide')
            }
        })

    })

    $('#deleteBatal').click(function(){
        $('#modalDelete').modal('hide')
        isiTabelObat()
    })

//------------------- Edit Obat --------------------------\\
    function bukaObatEdit(){
        $.ajax({
            url     :'http://localhost/obatupdate',
            type    :'GET',
            dataType:'html',
            success:function(data){
                $('#modalUpdate').modal('show')
                $('.idModalTitle').html('Update Obat')
                $('.isiModalUpdate').html(data)
                editObat()
            }
        })
    }

    function editObat() {
        var editIds = sessionStorage.getItem('editIds')
        $.ajax({
            url: 'http://localhost/getobatbyid/' + editIds,
            type: 'GET',
            success: function (data) {
                $('.inputUpdate').eq(0).val(data.name)
                $('.inputUpdate').eq(1).val(data.category)
                $('.inputUpdate').eq(2).val(data.description)
            }
        })
    }

    $('#obatBtnUpdate').click(function(){
        var ids = sessionStorage.getItem('editIds')
        var obj = {}
        obj.name = $('.inputUpdate').eq(0).val()
        obj.category = $('.inputUpdate').eq(1).val()
        obj.description = $('.inputUpdate').eq(2).val()
        var dJson = JSON.stringify(obj)
        $.ajax({
            url:'http://localhost/updateobat/'+ids,
            type:'PUT',
            contentType:'application/json',
            data:dJson,
            success:function(data){
                  isiTabelObat()
                  $('#modalUpdate').modal('hide')
            }
        })

    })

    $('#updateBatal').click(function(){
        $('#modalUpdate').modal('hide')
        isiTabelObat()
    })

// -----------------  Menambahkan Obat --------------------- \\

    $('#obatAdd').click(function(){
       $.ajax({
           url     :'http://localhost/obatadd',
           type    :'GET',
           dataType:'html',
           success:function(data){
                $('#modalAdd').modal('show')
                $('.isiModal').html(data)
                $('.idModalTitle').html('Tambahkan Obat')
           }
       })
    })

    $('#obatBtnAdd').click(function(){
       var obj = {}
       obj.name = $('.input').eq(0).val()
       obj.category = $('.input').eq(1).val()
       obj.description = $('.input').eq(2).val()
       var dJson = JSON.stringify(obj)
       $.ajax({
         url:'http://localhost/addobat',
         type:'POST',
         contentType:'application/json',
         data:dJson,
         success:function(data){
            isiTabelObat()
            $('#modalAdd').modal('hide')
         }
       })


    })

    $('#addBatal').click(function(){
        $('#modalAdd').modal('hide')
        isiTabelObat()
    })


//------------------------------ refresh page obat ------------------------ \\
    $('#refreshData').click(function(){
        isiTabelObat()
    })

})