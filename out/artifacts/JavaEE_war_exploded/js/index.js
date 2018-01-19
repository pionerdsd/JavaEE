

function main(form) {
    if (testLogin(form)&&testEmail(form)&&testPassword(form)&&testPol(form)&&testCheck(form)){
        return true;
    }
    return false;
}


function testLogin(form){
    var login = form.newLogin.value;
    if(!/^.{5,15}$/.test(login)){
        alert("Логин должен состоять из 5-15 символов!");
        return false;
    }
    return true;
}

function testPasswordOnly(form){
    var password = form.newPassword.value;

    if(!/^(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/.test(password)){
        alert("Пароль не подходит!");
        return false;
    }
       return true;
}


function testPassword(form){
    var password = form.newPassword.value;
    var repeatPassword = form.ConfirmPassword.value;
    if(!/^(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/.test(password)){
        alert("Пароль не подходит!");
        return false;
    }
    if(password != repeatPassword){
        alert("Пароли не совпадают!");
        return false;
    }
    return true;
}


function testPol(form){
    var pol = form.pol.value;
    if(pol == ""){
        alert("Choose your gender please!");
        return false;
    }
    return true;
}


function testEmail(form){
    var email = form.email.value;

    if(email == ""){
        alert("Insert your Email!");
        return false;
    }
    return true;
}



function testCheck(form){
    var check = form.check;
    var bol = false;
    for(var i = 0; i < check.length; i++){
        if(check[i].checked){
            bol = true;
            break;
        }
    }
    if(bol){
        return true;
    }
    alert("Выберите хоть один check");
    return false;
}

function changeColor(ob){
    var ChangeButtonColor = document.getElementById("ChangeButtonColor6");
    var TextArea = document.getElementById("comment");
    //var ChangeButtonColor = ob.form.glyphicon1;
    //var TextArea = ob.form.area1;
    if (ob.checked) {

        ChangeButtonColor.style.color="red";
        TextArea.disabled=false;
    } else {
        ChangeButtonColor.style.color="black";
        TextArea.disabled=true;
        TextArea.value=" ";

    }

    function dataB(ob) {
        if (ob.checked) {
            alert("start");
        }
        else {
            alert("stop");
        }

    }



}

