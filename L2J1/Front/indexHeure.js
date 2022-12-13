//fonction qui permet de créer le graphe Heure
function nbHeure(data) {
    //On crée le graphe avec Chart.js
    //On sélécetionne le canvas concernant par l'ID 
    let context = document.getElementById('g_heure').getContext('2d');
    //On récupère les données avec un array
    let arrayData = [];
    for (let key in data) {
        arrayData.push([key, data[key]]);
    }
    //console.log(arrayData)
    //On sépare les clés et les valeurs
    let key = [];
    let value = [];
    for (i = 0; i < arrayData.length; i++) {
        key.push(arrayData[i][0] + "H");
        value.push(arrayData[i][1]);
    }
    //On utilise les données récupérées
    let conData = {
        labels: key,
        datasets: [{
            data: value,
            fill: false,
            borderColor: '#d3717e',
            tension: 0.1
        }]
    }
    let options = {
        plugins: {
            legend: {
                display: false
            },
            title: {
                display: true,
                text: 'Nombre d\'utilisateurs par heure'
            }
        }
    }
    var config = {
        type: 'line',
        data: conData,
        options: options
    }
    var gHeure = new Chart(context, config);
}
//fonction qui permet de transformer un json en un objet JS et fait appel à la fonction nbHeure
function loadInfoHeure(url) {
    //on utilise XMLHttpRequest pour récupérer le json
    var request = new XMLHttpRequest();
    request.open("GET", url, true);
    request.onload = function() {
        try {
            const data = JSON.parse(request.responseText); //JSON --> Object JS
            //Appelle la fonction nbHeure pour créer le graphe à partir des données de JSON
            nbHeure(data);
        } catch (e) {
            console.warn("Error", e);
            gererErreur(e);
        }
    };
    request.send();
}
//On attends que la page soit entièrement chargée pour appeler le JS
window.addEventListener('load', () => {
    loadInfoHeure("http://localhost:8080/first/Heure?password=root&login=root");
})