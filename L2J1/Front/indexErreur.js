
//fonction qui permet de créer le graphe Erreur
function nbErreur(data) {
    //On crée le graphe avec Chart.js
    //On sélécetionne le canvas concernant par l'ID 
    let context = document.getElementById('g_erreur').getContext('2d');
    //On récupère le nombre d'erreur en utilisant un array
    let arrayError = [];
    for (let key in data) {
        arrayError.push([key, data[key]]);
    }
    //On sépare les clés et les valeurs
    let key = [];
    let value = [];
    for (i = 0; i < arrayError.length; i++) {
        key.push(arrayError[i][0]);
        value.push(arrayError[i][1]);
    }
    //On utilise les données récupérées
    let conData = {
        labels: key,
        datasets: [{
            data: value,
            backgroundColor: ['#82b9d1', '#d3717e']
        }]
    }
    //Les options 
    let options = {
        responsive: true,
        plugins: {
            title: {
                display: true,
                text: 'Nombre d\'erreur par jour'
            }
        }
    }
    //Le graphe de type donut
    let config = {
        type: 'doughnut',
        data: conData,
        options: options
    }
    let gErreur = new Chart(context, config);
}
//fonction qui permet de transformer un json en un objet JS et fait appel à la fonction nbErreur
function loadInfoErreur(url) {
    //on utilise XMLHttpRequest pour récupérer le json
    let request = new XMLHttpRequest();
    request.open("GET", url, true);
    request.onload = function() {
        try {
            const data = JSON.parse(request.responseText); //JSON --> Object JS
            nbErreur(data); //Appelle la fonction device pour créer le graphe à partir des données de JSON
        } catch (e) {
            console.warn(e);
            gererErreur(e);
        }
    };
    request.send();
}
//On attends que la page soit entièrement chargée pour appeler le JS
window.addEventListener('load', () => {
    loadInfoErreur("http://localhost:8080/first/Erreur?password=root&login=root");
})