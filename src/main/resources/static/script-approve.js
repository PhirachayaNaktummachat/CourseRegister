
let complete = document.getElementById("complete");

function openComplete() {
  complete.classList.add("open-complete");
}

function closeComplete() {
  complete.classList.remove("open-complete");
}

document.getElementById('okButton').addEventListener('click', function () {
  window.location.href = 'home_prof.html';
});