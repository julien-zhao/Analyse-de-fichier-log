
//fonction qui permet de créer le graphe Device
function device(data) {
    //On récupère le nombre de mobile avec map 
    var nbMobile = data.map(function(elem) {
        return elem.Nb_Mobile;
    });
    //On récupère le nombre de pc avec map
    var nbPc = data.map(function(elem) {
        return elem.Nb_Pc;
    });
    //On crée le graphe avec Chart.js
    //On sélécetionne le canvas concernant par l'ID 
    const ctx = document.getElementById("g_device").getContext("2d");
    //On utilise les données récupérées par map 
    let conData = {
        labels: ["PC", "MOBILE"],
        datasets: [{
            label: "Appareil",
            backgroundColor: ['#d3717e', '#82b9d1'],
            data: [nbPc, nbMobile],
        }]
    }
    //Les options
    let options = {
        responsive: true,
        plugins: {
            title: {
                display: true,
                text: 'Device'
            }
        }
    }
    //graphe de type donut
    const config = {
        type: "doughnut",
        data: conData,
        options: options
    }
    const devPie = new Chart(ctx, config);
}
//fonction qui permet de transformer un json en un objet JS et fait appel à la fonction device
function loadInfoDevice(url) {
    //on utilise XMLHttpRequest pour récupérer le json
    let request = new XMLHttpRequest();
    request.open("GET", url, true);
    request.send();
    request.onload = function() {
        try {
            const data = JSON.parse(request.responseText); //JSON --> Object JS
            device(data); //Appelle la fonction device pour créer le graphe à partir des données de JSON
        } catch (e) {
            console.warn("Error", e);
            gererErreur(e);
            //window.alert("L'erreur \"" + e + "\" est survenue lors du chargement de la page...");
        }
    };
}
//On attends que la page soit entièrement chargée pour appeler le JS
window.addEventListener('load', () => {
    loadInfoDevice("http://localhost:8080/first/OS?password=root&login=root");
})
//Traiter les erreurs
function gererErreur(e) {
    const chg = document.getElementById("contenu");
    const chgCarte = document.getElementById("carte");
    let message = document.createElement('p');
    message.classList.add('message-error')
    message.innerHTML = "L'erreur \"" + e + "\" est survenue lors du chargement de la page..."
    chg.innerHTML = ""
    chg.appendChild(message)
    chgCarte.innerHTML = ""
}