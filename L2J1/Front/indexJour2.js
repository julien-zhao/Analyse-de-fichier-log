function nbJour(data) {
    const context = document.getElementById('g_jour').getContext('2d');
    const arrayData = data;
    //console.log(arrayData);
    //Trier arrayData par date
    arrayData.sort(function(a, b) {
        /*On crée les objets date pour les trier plus facilement*/
        let dateA = new Date(a.date)
        let dateB = new Date(b.date)
        return dateA - dateB
    });
    //console.log(arrayData);
    //les dates
    let key = [];
    for (let i = 0; i < arrayData.length; i++) {
        key.push(arrayData[i].date.substring(5));
    }
    //console.log(key);
    //pour inverser le mois et le jour
    for (let i = 0; i < key.length; i++) {
        let month = key[i].substring(0, 2);
        let day = key[i].substring(3, 5);
        //console.log(day);
        key[i] = day + "/" + month;
    }
    /*les occurrences*/
    let value = [];
    for (let i = 0; i < arrayData.length; i++) {
        value.push(arrayData[i].occ);
    }
    let conData = {
        labels: key,
        datasets: [{
            data: value,
            fill: false,
            borderColor: '#82a2cf',
            tension: 0.2
        }]
    }
    let options = {
        plugins: {
            legend: {
                display: false
            },
            title: {
                display: true,
                text: 'Nombre d\'utilisateurs par jour (7 derniers jours)'
            }
        }
    }
    let config = {
        type: 'line',
        data: conData,
        options: options
    }
    let gJour = new Chart(context, config);
}
function loadInfoJour(url) {
    //Récupère les données
    let request = new XMLHttpRequest();
    request.open("GET", url, true);
    request.onload = function() {
        try {
            const data = JSON.parse(request.responseText); //JSON --> Object JS
            nbJour(data);
        } catch (e) {
            console.warn("Error");
            gererErreur(e);
        }
    };
    request.send();
}
//On attends que la page soit entièrement chargée pour appeler le JS
window.addEventListener('load', () => {
    loadInfoJour("http://localhost:8080/first/Date?password=root&login=root", );
})