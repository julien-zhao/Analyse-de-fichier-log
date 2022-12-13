function osMobile(data) {
    //graph1 est un element canva, on peut recuperer le 2D
    const ctx = document.getElementById("g_osMobile").getContext("2d");
    let other = data.map(function(elem) {
        return elem.nb_autre_OS_Mobile;
    });
    //console.log(other);
    let android = data.map(function(elem) {
        return elem.nb_Android;
    });
    //console.log(android);
    let ios = data.map(function(elem) {
        return elem.nb_IOS;
    });
    //console.log(ios);
    let conData = {
        labels: ["Android", "iOS", "Other"],
        datasets: [{
            label: "Other",
            backgroundColor: ['#d3717e', '#82b9d1', '#abe09d'],
            data: [android, ios, other]
        }]
    }
    let options = {
        responsive: true,
        plugins: {
            title: {
                display: true,
                text: 'OS Mobile'
            }
        }
    }
    const config = {
        type: "doughnut",
        data: conData,
        options: options
    }
    const devDonut = new Chart(ctx, config);
}
function loadInfoOsMobile(url) {
    //Récupère les données
    let request = new XMLHttpRequest();
    request.open("GET", url, true);
    request.onload = function() {
        try {
            const data = JSON.parse(request.responseText); //JSON --> Object JS
            osMobile(data);
        } catch (e) {
            console.warn("Error");
            gererErreur(e);
        }
    };
    request.send();
}
//On attends que la page soit entièrement chargée pour appeler le JS
window.addEventListener('load', () => {
    loadInfoOsMobile("http://localhost:8080/first/Mobile?password=root&login=root");
})