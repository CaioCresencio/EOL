$(document).ready(function () {
    $(".menu").toggleClass("menu-open");
    $(".navbar-toggler").on("click", function () {
        $(".menu").toggleClass("menu-open");
    })

    const fillTable1 = function (id_table) {
        $.get("list_os/getOsDelayed", function(data){
              // console.log(data)
              $(`${id_table} tbody tr`).remove();
               $.each(data, function(index,value){
                      $(`${id_table} tbody`).append(`<tr>
                        <td>${value.id}</td>
                        <td>${value.typeOrder}</td>
                        <td>${value.client.name}</td>
                        <td>${value.installer.name}</td>
                        <td>${value.assignment_date}</td>
                      </tr>
                      `)
                })
        });
    };

    const fillTable2 = function (id_table) {
        $.get("list_os/getUserDto", function(data){
               console.log(data)
               $(`${id_table} tbody tr`).remove();
               $.each(data, function(index,value){
                      $(`${id_table} tbody`).append(`<tr>
                          <td>${value.user.id}</td>
                         <td>${value.user.name}</td>
                         <td>${value.ammount}</td>
                      </tr>
                      `)
                })
        });
    };

     const fillTable3 = function (id_table) {
            $.get("list_os/getFinishOsDESC", function(data){
                   console.log(data)
                   $(`${id_table} tbody tr`).remove();
                   $.each(data, function(index,value){
                        $(`${id_table} tbody`).append(`<tr>
                            <td>${value.user.id}</td>
                            <td>${value.user.name}</td>
                            <td>${value.ammount}</td>
                          </tr>
                                               `)
                    })
            });
        };

    fillTable1("#table_1");
    fillTable2("#table_2");
    fillTable3("#table_3");


    $("#bt_table3").on("click", function () {
        fillTable3("#table_3");
    })
    $("#bt_table2").on("click", function () {
        fillTable2("#table_2");
    })
    $("#bt_table1").on("click", function () {
        fillTable1("#table_1");
    })







});