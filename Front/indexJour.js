function SplitLastDate(lastDate) {
    const date = lastDate.split('-');
    return date;
}

//Pour formatter les dates
function formatDate(date) {
    let dd = date.getDate();
    let mm = date.getMonth() + 1;
    //let yyyy = date.getFullYear();
    if (dd < 10) { dd = '0' + dd }
    if (mm < 10) { mm = '0' + mm }
    date = dd + '/' + mm;
    return date
}

//Pour récupérer les 7 derniers jours
function Last7Days(lastDate) {
    let date = SplitLastDate(lastDate);
    let result = [];
    for (let i = 0; i < 7; i++) {
        let d = new Date(date[2], (date[1] - 1), date[0]);
        d.setDate(d.getDate(lastDate) - i);
        result.push(formatDate(d))
    }
    //return (result.join(','));
    //console.log(result);
    return result;
}


function nbJour(data, lastDate) {

    const context = document.getElementById('g_jour').getContext('2d');

    let arrayData = [];
    for (let key in data) {
        arrayData.push([key, data[key]]);
    }

    let key = Last7Days(lastDate).reverse();
    let value = [];
    for (let i = 0; i < arrayData.length; i++) {
        value.push(arrayData[i][1]);
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

function loadInfoDate(url, urlDate) {
    //Récupère les données

    let request = new XMLHttpRequest();
    request.open("GET", urlDate, true);

    request.onload = function() {
        try {
            const date = JSON.parse(request.responseText); //JSON --> Object JS
            loadInfoJour(url, date["Last_date"]);
        } catch (e) {
            console.warn("Error");
        }
    };

    request.send();
}


function loadInfoJour(url, lastDate) {
    //Récupère les données

    let request = new XMLHttpRequest();
    request.open("GET", url, true);

    request.onload = function() {
        try {
            const data = JSON.parse(request.responseText); //JSON --> Object JS
            nbJour(data, lastDate);
        } catch (e) {
            console.warn("Error");
        }
    };

    request.send();
}

//On attends que la page soit entièrement chargée pour appeler le JS
window.addEventListener('load', () => {
    loadInfoDate("nbJour.json", "lastDate.json");
})