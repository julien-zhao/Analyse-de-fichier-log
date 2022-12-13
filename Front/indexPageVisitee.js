function getHtmlPage(position, arrayError) {
    return arrayError[position][0];
}
function regroupInfoPage(data) {
    //Object --> Array
    let arrayPage = [];
    for (let key in data) {
        arrayPage.push([key, data[key]]);
    }
    //console.log(arrayPage)
    //Trier ErreurTop.json dans l'ordre décroissant
    arrayPage.sort(function(a, b) {
        return a[1] - b[1];
    });
    arrayPage.reverse();
    //console.log(arrayIp)
    const list = document.querySelector('#list_page');
    let ligne;
    for (let i = 0; i < 5; i++) {
        ligne = document.createElement('li');
        ligne.innerHTML = getHtmlPage(i, arrayPage);
        list.appendChild(ligne);
    }
}
function loadInfoPageTop() {
    //Récupère les données
    var request = new XMLHttpRequest();
    request.open("get", "http://localhost:8080/first/Url?password=root&login=root", true);
    request.onload = function() {
        try {
            const data = JSON.parse(request.responseText); //JSON --> Object JS
            regroupInfoPage(data);
        } catch (e) {
            console.warn("Error", e);
            gererErreur(e);
        }
    };
    request.send();
}
//On attends que la page soit entièrement chargée pour appeler le JS
document.addEventListener("DOMContentLoaded", () => {
    loadInfoPageTop();
});