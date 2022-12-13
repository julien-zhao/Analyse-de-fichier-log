function regroupInfoMeta(data) {
    let nbLine = data.map(function(elem) {
        return elem.Nb_line;
    });
    let size = data.map(function(elem) {
        return elem.Size_octets;
    });
    let ip = data.map(function(elem) {
        return elem.Ip_unique;
    });
    let lastDate = data.map(function(elem) {
        return elem.Dernier_date;
    });
    //console.log(nbLine);
    //console.log(size);
    const list = document.querySelector('#list_meta');
    let ligne = document.createElement('li');
    ligne.innerHTML = "Nombre de connexions : " + nbLine;
    list.appendChild(ligne);
    let ligne2 = document.createElement('li');
    ligne2.innerHTML = "Taille du fichier : " + size + " octets";
    list.appendChild(ligne2);
    let ligne3 = document.createElement('li');
    ligne3.innerHTML = "IP unique : " + ip;
    list.appendChild(ligne3);
    let ligne4 = document.createElement('li');
    ligne4.innerHTML = "Dernière date de connexion : " + lastDate;
    list.appendChild(ligne4);
}
function loadInfoMeta() {
    //Récupère les données
    var request = new XMLHttpRequest();
    request.open("get", "http://localhost:8080/first/meta?password=root&login=root", true);
    request.onload = function() {
        try {
            const data = JSON.parse(request.responseText); //JSON --> Object JS
            regroupInfoMeta(data);
        } catch (e) {
            console.warn("Error", e);
        }
    };
    request.send();
}
//On attends que la page soit entièrement chargée pour appeler le JS
document.addEventListener("DOMContentLoaded", () => {
    loadInfoMeta();
});