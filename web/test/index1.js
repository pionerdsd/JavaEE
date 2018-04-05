function checkbox(form) {

    var check = form.check;
    for (var i = 0; i<check.length; i++){
        if (check[i].checked){
            i++;
            alert(i + " is checked!");
        }
    }

}