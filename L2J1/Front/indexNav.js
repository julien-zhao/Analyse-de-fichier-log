Chart.defaults.font.size = 15;
Chart.defaults.font.family = "'Rajdhani', sans-serif";
Chart.defaults.color = '#162b54'
Chart.defaults.font.title = 20;
function navigateur(data) {
    //Object --> Array pour un ordre fixe/décroissant
    let arrayData = data;
    arrayData.sort(function(a, b) {
        return a.occ - b.occ;
    });
    arrayData.reverse();
    console.log(arrayData);
    //Création de key qui contient les clés (nom des navigateurs)
    //Création de value qui contient les valeurs (nb de navigateurs)
    let key = [];
    let value = [];
    for (i = 0; i < arrayData.length; i++) {
        key.push(arrayData[i].Nav);
        value.push(arrayData[i].occ);
    }
    for (i = 0; i < key.length; i++) {
        key[i] = key[i].replaceAll('_', ' ');
    }
    //console.log(key);
    let context = document.getElementById('g_nav').getContext('2d')
    let conData = {
        labels: key,
        datasets: [{
            label: 'Points',
            backgroundColor: ['#d3717e', '#82b9d1', '#abe09d', '#b495db', '#d9bb8f', '#5c6094'],
            data: value
        }]
    }
    let options = {
        indexAxis: 'y',
        responsive: true,
        plugins: {
            legend: {
                display: false,
            },
            title: {
                display: true,
                text: 'Navigateur'
            }
        }
    }
    let config = {
            type: 'bar',
            data: conData,
            options: options
        }
        //if l'instance est déjà crée, alors il faut détruire 
    let gNav = new Chart(context, config);
}
function loadInfoNav(url) {
    //Récupère les données
    let request = new XMLHttpRequest();
    request.open("GET", url, true);
    request.onload = function() {
        try {
            const data = JSON.parse(request.responseText); //JSON --> Object JS
            navigateur(data);
        } catch (e) {
            console.warn("Error", e);
            gererErreur(e);
        }
    };
    request.send();
}
//On attends que la page soit entièrement chargée pour appeler le JS
window.addEventListener('load', () => {
    loadInfoNav("http://localhost:8080/first/Navi?password=root&login=root");
})
/*
setInterval(function() {
    loadInfoNav("Navigateur.json");
}, 5000);
*/