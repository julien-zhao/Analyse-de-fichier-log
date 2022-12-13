function getHtmlIpInfo(position, arrayIp) {
    let ip = arrayIp[position].IP;
    let occu = arrayIp[position].Occu;
    let connexion = arrayIp[position].DerniereConnexion;
    let nav = arrayIp[position].Navigateur;
    let site = arrayIp[position].DerniereSiteConsulte;
    let pays = arrayIp[position].Pays;
    let ville = arrayIp[position].Ville;
    return "<span class=\"keys\">IP :</span> " + ip + "<br><br><span class=\"keys\">Occurence : </span>" + occu + "<br><br><span class=\"keys\">Dernière heure de connexion : </span>" + connexion + "<br><br><span class=\"keys\">Navigateur : </span>" + nav + "<br><br><span class=\"keys\">Dernier site consulté : </span>" + site + "<br><br><span class=\"keys\">Pays : </span>" + pays + "<br><br><span class=\"keys\">Ville : </span>" + ville;
}
function getHtmlIp(position, arrayError) {
    return arrayError[position].IP;
}
function regroupInfoMore(data) {
    //Object --> Array
    let arrayIp = data;
    //Trier ErreurTop.json dans l'ordre décroissant
    arrayIp.sort(function(a, b) {
        return a[0] - b[0];
    });
    const list = document.querySelector('#list_ip');
    let ligne;
    for (let i = 0; i < 5; i++) {
        ligne = document.createElement('li');
        ligne.innerHTML = getHtmlIp(i, arrayIp);
        list.appendChild(ligne);
    }
    const list1 = document.querySelector('#container_more1');
    list1.innerHTML = getHtmlIpInfo(0, arrayIp);
    const list2 = document.querySelector('#container_more2');
    list2.innerHTML = getHtmlIpInfo(1, arrayIp);
    const list3 = document.querySelector('#container_more3');
    list3.innerHTML = getHtmlIpInfo(2, arrayIp);
    const list4 = document.querySelector('#container_more4');
    list4.innerHTML = getHtmlIpInfo(3, arrayIp);
    const list5 = document.querySelector('#container_more5');
    list5.innerHTML = getHtmlIpInfo(4, arrayIp);
    /*
    for (let i = 0; i < 5; i++) {
        let list = document.querySelector('.container-more' + i);
        list.innerHTML = arrayIp[i];
    }
*/
}
function loadInfoIpMore() {
    //Récupère les données
    var request = new XMLHttpRequest();
    request.open("get", "http://localhost:8080/first/PersonneTop5?password=root&login=root", true);
    request.onload = function() {
        try {
            const data = JSON.parse(request.responseText); //JSON --> Object JS
            regroupInfoMore(data);
        } catch (e) {
            console.warn("Error", e);
            gererErreur(e);
        }
    };
    request.send();
}
//On attends que la page soit entièrement chargée pour appeler le JS
document.addEventListener("DOMContentLoaded", () => {
    loadInfoIpMore();
});