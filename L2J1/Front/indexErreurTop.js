//fonction qui retourne l'erreur
function getHtmlError(position, arrayError) {
    return arrayError[position][0];
}

//fonction qui permet de créer la liste top erreur
function regroupInfoError(data) {
    //Object --> Array
    let arrayError = [];
    for (let key in data) {
        arrayError.push([key, data[key]]);
    }
    //console.log(arrayError)

    //Trier ErreurTop.json dans l'ordre décroissant
    arrayError.sort(function(a, b) {
        return a[1] - b[1];
    });
    arrayError.reverse();
    //console.log(arrayError)

    //On sélécetionne le ol par l'ID
    //On crée des li puis les insére dans ol par innerHTLM
    const list = document.querySelector('#list_error');
    let ligne;
    for (let i = 0; i < 5; i++) {
        ligne = document.createElement('li');
        ligne.innerHTML = getHtmlError(i, arrayError);
        list.appendChild(ligne);
    }

}

//fonction qui permet de transformer un json en un objet JS et fait appel à la fonction regroupInfoError
function loadInfoErreurTop() {
    //on utilise XMLHttpRequest pour récupérer le json
    var request = new XMLHttpRequest();
    request.open("get", "http://localhost:8080/first/DiffError?password=root&login=root", true);

    request.onload = function() {
        try {
            const data = JSON.parse(request.responseText); //JSON --> Object JS
            regroupInfoError(data);
        } catch (e) {
            console.warn("Error", e);
        }
    };

    request.send();
}

//On attends que la page soit entièrement chargée pour appeler le JS
document.addEventListener("DOMContentLoaded", () => {
    loadInfoErreurTop();
});



