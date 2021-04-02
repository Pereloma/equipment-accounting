function addEquipmentFunction() {
    var table = document.getElementById("equipmentList");

    let i = 0;

    var temp = table.lastElementChild.firstElementChild.firstElementChild.id.substring(13).replace(".name", "");
    var idOld = "equipmentList" + temp;
    var nameOld = "equipmentList[" + temp + "]";
    temp = Number(temp) + 1;
    var idNew = "equipmentList" + temp;
    var nameNew = "equipmentList[" + temp + "]";

    temp = table.lastElementChild.cloneNode(true);

    var elementChildrens = temp.children;
    for (i=0; i < elementChildrens.length; i++) {
        elementChildrens[i].firstElementChild.id = elementChildrens[i].firstElementChild.id.replace(idOld,idNew);
        elementChildrens[i].firstElementChild.name = elementChildrens[i].firstElementChild.name.replace(nameOld,nameNew);
        if(i<3)
            elementChildrens[i].firstElementChild.value="";
    }

    table.appendChild(temp);

}
function removeElement(id){
    if (document.getElementById("equipmentList").children.length <= 2){
        alert("приемная наклодная должна содержать хотябы 1 элемент")
    }
    else {
        var removeElem = document.getElementById(id).parentElement.parentElement;
        removeElem.remove();

        var elementChildrens = document.getElementById("equipmentList").children;
        for (i=1; i < elementChildrens.length; i++) {
            var elementChildrensChildrens = elementChildrens[i].children;
            for (let j = 0; j < elementChildrensChildrens.length-1; j++) {
                var dd = elementChildrensChildrens[j].firstElementChild.id.indexOf(".");
                elementChildrensChildrens[j].firstElementChild.id = "equipmentList"+ (i-1) + elementChildrensChildrens[j].firstElementChild.id.substring(dd);
                dd = elementChildrensChildrens[j].firstElementChild.name.indexOf("].");
                elementChildrensChildrens[j].firstElementChild.name = "equipmentList["+ (i-1) + elementChildrensChildrens[j].firstElementChild.name.substring(dd);
            }
        }
    }

}
