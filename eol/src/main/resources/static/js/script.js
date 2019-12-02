$(document).ready(function () {
    const lang = {
        "sEmptyTable": "Nenhum registro encontrado",
        "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
        "sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
        "sInfoFiltered": "(Filtrados de _MAX_ registros)",
        "sInfoPostFix": "",
        "sInfoThousands": ".",
        "sLengthMenu": "_MENU_ resultados por página",
        "sLoadingRecords": "Carregando...",
        "sProcessing": "Processando...",
        "sZeroRecords": "Nenhum registro encontrado",
        "sSearch": "Pesquisar",
        "oPaginate": {
            "sNext": "Próximo",
            "sPrevious": "Anterior",
            "sFirst": "Primeiro",
            "sLast": "Último"
        },
        "oAria": {
            "sSortAscending": ": Ordenar colunas de forma ascendente",
            "sSortDescending": ": Ordenar colunas de forma descendente"
        },
        "select": {
            "rows": {
                "_": "Selecionado %d linhas",
                "0": "Nenhuma linha selecionada",
                "1": "Selecionado 1 linha"
            }
        }
    }



    $(".menu").toggleClass("menu-open");
    $(".navbar-toggler").on("click", function () {
        $(".menu").toggleClass("menu-open");

    })

    let fillTable = function (id_table) {
        const dataObject = [
            { id: 1, name: 'A' },
            { id: 2, name: 'B' },
            { id: 3, name: 'C' }
        ];
        const dataSet = [];
        $.each(dataObject, function (index, data) {
            dataSet.push([data.id, data.name]);
        });

        $(id_table).DataTable({
            data: dataSet,
            language: lang,
            columns: [
                { title: 'ID' },
                { title: 'Nome' }
            ]
        });
    };
    fillTable("#table_1");
    fillTable("#table_2");
    fillTable("#table_3");

});