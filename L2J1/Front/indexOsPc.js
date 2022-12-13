function osPc(data) {
    const ctx = document.getElementById("g_osPc").getContext("2d");
    let nbLinux = data.map(function(elem) {
        return elem.Nb_Linux;
    });
    let nbWindows = data.map(function(elem) {
        return elem.Nb_Windows;
    });
    let nbMacOS = data.map(function(elem) {
        return elem.Nb_Mac;
    });
    let nbOther = data.map(function(elem) {
        return elem.Nb_autre_OS_PC;
    });
    let conData = {
        labels: ["Linux", "Windows", "Mac", "Other"],
        datasets: [{
            label: "os_pc",
            backgroundColor: ['#d3717e', '#82b9d1', '#abe09d', '#b495db'],
            data: [nbLinux, nbWindows, nbMacOS, nbOther]
        }]
    }
    let options = {
        responsive: true,
        plugins: {
            title: {
                display: true,
                text: 'OS PC'
            }
        }
    }
    const config = {
        type: 'doughnut',
        data: conData,
        options: options
    }
    const devBar = new Chart(ctx, config);
}
function loadInfoOsPc(url) {
    //Récupère les données
    let request = new XMLHttpRequest();
    request.open("GET", url, true);
    request.onload = function() {
        try {
            const data = JSON.parse(request.responseText); //JSON --> Object JS
            osPc(data);
        } catch (e) {
            console.warn("Error", e);
            gererErreur(e);
        }
    };
    request.send();
}
//On attends que la page soit entièrement chargée pour appeler le JS
window.addEventListener('load', () => {
    loadInfoOsPc("http://localhost:8080/first/PC?password=root&login=root");
})