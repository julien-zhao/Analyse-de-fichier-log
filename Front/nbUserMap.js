function loadInfoMap(url) {
    let request = new XMLHttpRequest();
    request.open("GET", url, true);
    request.onreadystatechange = function() {
        try {
            if (this.readyState == 4 && this.status == 200) {
                const data = JSON.parse(this.responseText);
                replaceLink(data);
                sum(data);
            }
        } catch (e) {
            console.log("Error", e);
            gererErreur(e);
        }
    }
    request.send();
}
window.addEventListener('load', () => {
    loadInfoMap("http://localhost:8080/first/Country?password=root&login=root");
})
function replaceLink(data) {
    var total = sum(data);
    for (let key in data) {
        var abbrCountry = document.getElementsByClassName("land");
        for (let i = 0; i < abbrCountry.length; i++) {
            var nameCountry = abbrCountry[i].getAttribute("title");
            if (key === nameCountry) {
                var aTag = document.getElementsByTagName("a");
                for (let j = 0; j < aTag.length; j++) {
                    var titleTag = aTag[j].getAttribute("xlink:title");
                    var percent = " (" + (data[key] * 100) / total + "%)";
                    if (nameCountry === titleTag) {
                        var addNbrUsers = titleTag + " : " + data[key] + " utilisateurs" + percent;
                        var newAtag = document.createElement("a");
                        aTag[j].setAttribute("xlink:title", addNbrUsers);
                        aTag.innerHTML = newAtag;
                    }
                }
            }
        }
    }
};
function sum(data) {
    var sum = 0;
    for (let key in data) {
        sum += data[key];
    }
    return sum;
}