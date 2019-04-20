//Modal for home-page start
const modal = document.getElementById('about-modal');
const btn = document.getElementById("about-me-modal");
const span = document.getElementsByClassName("close")[0];

btn.onclick = () => {
    modal.style.display = "block";
}

span.onclick = () => {
    modal.style.display = "none";
}

window.onclick = event => {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
//Modal for home-page end