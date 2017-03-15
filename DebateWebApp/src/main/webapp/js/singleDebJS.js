/* 
 *  Copyright 2017 SarahBoka
 */

$(document).ready(function(){
//    loadDebates(); 
    
    $('#challenge').click(function(event){
        
        event.preventDefault();
        var contentData = tinyMCE.get('add-rebuttal-content');
        $.ajax({
            url: 'rebuttal',
            type: 'POST',
            data: JSON.stringify({
                content: contentData.getContent(),
                user: 'smoothDeb',
                type: 'challenge',
                position: false
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status){
            window.location.reload(true);
//            $("#validationErrors").hide();
//            loadDebates();
            window.onbeforeunload = function() {};
            
            $('#add-rebuttal-content').val('');
//            }).error(function (data, status) {
//                var errorDiv = $("#validationErrors");
//                errorDiv.empty();
//                $.each(data.responseJSON.fieldErrors, function (index, validationError) {
//                    errorDiv.append(validationError.message);
//                    errorDiv.append("<br>");
//                    errorDiv.show();
//                });
        });
    });
    
    $("#edit-modal").on('show.bs.modal', function(event){
        var element = $(event.relatedTarget);
        var id = element.data('debate-id');
        getDebateEditDetails(id);
    });
    
    $("#edit-debate").click(function(event){
        event.preventDefault();
        editDebate();
    });
    
    $("#delete-debate").click(function(event){
        event.preventDefault();
        deleteDebate();
    });
    
});

function getDebateEditDetails(id){
    $.ajax({
        url: 'debate/'+id,
        type: 'GET',
        headers: {
            'Accept': 'application/json'
        }
    }).success(function(debate){
        $("#edit-debate-id").text(debate.id);
        $("#edit-debate-resolution").val(debate.resolution);
        $("#edit-debate-status").val(debate.status);
        $("#edit-debate-date").val(debate.date);
        $("#edit-debate-aff-user").val(debate.affirmativeUser);
        $("#edit-debate-neg-user").val(debate.negativeUser);
        $("#edit-debate-content").val(debate.content);
        $("#edit-category").val(debate.category);
        
    });
}

function editDebate(){
    var id = $("#edit-debate-id").text();
    var res = $("#edit-debate-resolution").val();
    var status = $("#edit-debate-status").val();
    var date = $("#edit-debate-date").val();
    var affUser = $("#edit-debate-aff-user").val();
    var negUser = $("#edit-debate-neg-user").val();
    var content = $("#edit-debate-content").val();
    var cat = $("#edit-debate-category").val();
    
    $.ajax({
        url: 'debate/' + id,
        type: 'PUT',
        headers:{
            'Content-type': 'application/json'
        },
        'dataType' : 'json',
        data: JSON.stringify({
            id: id,
            resolution: res,
            status: status,
            date: date,
            affirmativeUser: affUser,
            negativeUser: negUser,
            content: content,
            category: cat
        })
    }).success(function(data){
        window.location.reload(true);
    });
}

function deleteDebate(){
    var id = $("#edit-debate-id").text();
    
    $.ajax({
        url: 'debate/' +id,
        type: 'DELETE'
    }).success(function(){
       
//        loadDebates();
        window.location.reload(true);
        window.history.back();
        window.location.reload(true);
        //reload doesn't work when back is used
        //so deleted item still appears in home list until page is manually refreshed
    });
}

function publishDebate(){
    
}

function unpublishDebate(){
    
}