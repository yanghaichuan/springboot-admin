var modal = {
    doPost:function (url,data,callback) {
        $.ajax({
            url:url,
            data:data,
            type:"POST",
            dataType:"json",
            success:function(data){
                callback(data)
            },
            error:function(data){

            }
        });
    }
}