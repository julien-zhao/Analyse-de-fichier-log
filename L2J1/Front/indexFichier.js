//fonction qui retourne l'url
function getHtmlFichier(position, arrayFichier) {
    if (arrayFichier[position].Url != null) {
        return arrayFichier[position].Url;
    } else {
        return null;
    }
}
//fonction qui permet de créer la liste top Fichier
function regroupInfoFichier(data) {
    //On récupère les données
    const arrayFichier = data;
    //Trier nbFichier.json dans l'ordre décroissant
    arrayFichier.sort(function(a, b) {
        return a.Occ - b.Occ;
    });
    arrayFichier.reverse();
    console.log(arrayFichier);
    //On sélécetionne le ol par l'ID
    //On crée des li puis les insére dans ol par innerHTLM
    const list = document.querySelector('#list_fichier');
    let ligne;
    let compteur = 0;
    for (let i = 0; i < 5; i++) {
        ligne = document.createElement('li');
        let res = getHtmlFichier(i, arrayFichier);
        if (res != null) {
            ligne.innerHTML = res;
            list.appendChild(ligne);
            compteur++;
        }
    }
    for (let i = 0; i < (5 - compteur); i++) {
        ligne = document.createElement('li');
        ligne.innerHTML = "-";
        list.appendChild(ligne);
    }
}
//fonction qui permet de transformer un json en un objet JS et fait appel à la fonction regroupInfoFichier
function loadInfoFichier() {
    //Récupère les données
    var request = new XMLHttpRequest();
    request.open("get", "http://localhost:8080/first/UrlFichier?password=root&login=root", true);
    request.onload = function() {
        try {
            const data = JSON.parse(request.responseText); //JSON --> Object JS
            regroupInfoFichier(data);
        } catch (e) {
            console.warn("Error", e);
            gererErreur(e);
        }
    };
    request.send();
}
//On attends que la page soit entièrement chargée pour appeler le JS
document.addEventListener("DOMContentLoaded", () => {
    loadInfoFichier();
});