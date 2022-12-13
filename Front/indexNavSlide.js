//Fonction qui permet l'animation de barre navigateur 
const navSlide = () => {

    const menuButton = document.querySelector('.menu-button');
    const navElements = document.querySelector(".navbar-elements");

    menuButton.addEventListener('click', () => {
        //Nav Animation
        navElements.classList.toggle('nav-slide');

        //Menu Button Animation
        menuButton.classList.toggle('changeToggle');
    });
}

navSlide();