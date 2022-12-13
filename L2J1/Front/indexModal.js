/*
openModal.forEach(mod => {
    mod.addEventListener('click', () => {
        const modal = document.querySelector(mod.dataset.modalSel)
            //console.log(modal)
        backgr.classList.add('active')
        modal.classList.add('active')
    })
})

closeModal.forEach(mod => {
    mod.addEventListener('click', () => {
        const modal = mod.closest('.modal')
        backgr.classList.remove('active')
        modal.classList.remove('active')
    })
})
*/
let text1 = "<div class=\"text\"><div class=\"title-main\">Our work</div><br>Notre projet consiste à créer une application Web capable d’analyser régulièrement et de stocker les informations des utilisateurs. Parmi ces informations, on retrouvera l’adresse IP à l’origine de la demande/requête du serveur, le type de la demande, le statut code HTTP de la ressource demandée, la date et l’heure à laquelle la demande a été faite ainsi que d’autres informations. Cette application Web pourra supporter des données lourdes afin de les traiter et d’afficher ses statistiques.<br><br><span class=\"role\">Back-end :</span><br>Réaliser des fichiers format json qui répondent aux fonctionnalités définis. Recevoir une requête demandée par le client, effectuer le traitement puis renvoyer le résultat par l'intermédiaire d’un serveur http en utilisant un programmed’exécution (Servlet).<br><br><span class=\"role\">Front-end :</span><br>Récupérer les données réalisées par le Back-end (sous format . json) avec la méthode AJAX pour une application plus rapide et efficace. A partir de ces données, on crée des représentations sous forme de diagramme et/ou graphiques pour les afficher avec HTML, CSS et Javascript.</div>"
let text2 = "<div class=\"text\"><div class=\"title-main\">Help</div><br><span class=\"role\">Front-end</span><br>Nayoung KWON <span class=\"email\">nayoungkwonn@gmail.com</span><br>Aaishah HULKHOREE <span class=\"email\">hulkhoreea@gmail.com</span><br><br><br><span class=\"role\">Back-end</span><br> Julien ZHAO <span class=\"email\">julienzhaox@gmail.com</span><br> Mohamed AZZAOUI <span class=\"email\">azzaoui.mohamed27@gmail.com</span></div><br>"
let text3 = "<div class=\"text\"><div class=\"title-main\">About</div><br>Etudiants en deuxième année de licence Informatique et applications à l'Université Paris Cité, nous avons réalisé le projet L2J1."

if (window.matchMedia("(min-width: 768px)").matches) {

    const openModal = document.querySelectorAll('.show-button')
    const closeModal = document.querySelectorAll('.close-button')
    const backgr = document.getElementById('backgr')

    openModal.forEach(mod => {
        mod.addEventListener('click', () => {
            const modal = document.querySelector(mod.dataset.modalSel)

            backgr.classList.add('active')
            modal.classList.add('active')
        })
    })

    closeModal.forEach(mod => {
        mod.addEventListener('click', () => {
            const modal = mod.closest('.modal')
            backgr.classList.remove('active')
            modal.classList.remove('active')
        })
    })
} else {

    document.getElementById("modal_butt").onclick = function() {
        const chg = document.getElementById("contenu")
        const chgCarte = document.getElementById("carte")
        chg.innerHTML = text1
        chgCarte.innerHTML = ""
    }

    document.getElementById("modal2_butt").onclick = function() {
        const chg = document.getElementById("contenu")
        const chgCarte = document.getElementById("carte")
        chg.innerHTML = text3
        chgCarte.innerHTML = ""
    }

    document.getElementById("modal3_butt").onclick = function() {
        const chg = document.getElementById("contenu")
        const chgCarte = document.getElementById("carte")
        chg.innerHTML = text2
        chgCarte.innerHTML = ""
    }


}