$(".menu > ul >").click(function (e) {
  //remove active from already active
  $(this).siblings().removeClass("active");
  //add active to clicked
  $(this).toggleClass("active");
  //if has sub menu open it
  $(this).find("ul").slideToggle();
  //close other sub menu if any open
  $(this).siblings().find("ul").slideUp();
  //remove active class of sub menu items
  $(this).siblings().find("ul").find("li").removeClass("active");
});

//Document Attachment Page
let fileInput = document.getElementById("file-input");
let fileList = document.getElementById("files-list");
let numOfFiles = document.getElementById("num-of-files");

fileInput.addEventListener("change", () => {
  fileList.innerHTML = "";
  numOfFiles.textContent = `${fileInput.files.length} Files Selected`;

  if (fileInput.files.length > 5) {
    alert("Please select up to 5 files.");
    fileInput.value = "";
    numOfFiles.textContent = "No Files Chosen";
  } else {

    for (const file of fileInput.files) {
      if (file.type === "image/jpeg" || file.type === "application/pdf") {
        let reader = new FileReader();
        let listItem = document.createElement("li");
        let fileName = file.name;
        let fileSize = (file.size / 1024).toFixed(1);

        if (fileSize <= 100) {
          listItem.innerHTML = `<p>${fileName}</p><p>${fileSize}KB</p>`;

          if (fileSize >= 1024) {
            fileSize = (fileSize / 1024).toFixed(1);
            listItem.innerHTML = `<p>${fileName}</p><p>${fileSize}MB</p>`;
          }

          fileList.appendChild(listItem);
        } else {
          alert(`File size exceeds 100 KB: ${file.name}. Please choose a smaller file.`);
          fileInput.value = "";
          numOfFiles.textContent = "No Files Chosen";
          fileList.innerHTML = "";
          break;
        }
      } else {
        alert(`Invalid file type: ${file.name}. Please choose a .jpg or .pdf file.`);
        fileInput.value = "";
        numOfFiles.textContent = "No Files Chosen";
        fileList.innerHTML = "";
        break;
      }
    }
  }
});

document.getElementById('backButton').addEventListener('click', function () {
  window.history.back();
});

let complete = document.getElementById("complete");

function openComplete() {
  complete.classList.add("open-complete");
}

function closeComplete() {
  complete.classList.remove("open-complete");
}

document.getElementById('okButton').addEventListener('click', function () {
  window.location.href = "mainpage2.html";
});





