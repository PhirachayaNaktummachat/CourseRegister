let rowCounter = 1;

function addRow() {
    const table = document.querySelector('table');
    if (rowCounter < 10) {
        const newRow = table.insertRow(table.rows.length);

        // Populate the new row with values similar to the first row
        newRow.insertCell(0).textContent = ++rowCounter;

        // Add select element in the first column
        const select1 = document.createElement('select');
        const option1_1 = document.createElement('option');
        option1_1.value = 'เพิ่ม';
        option1_1.text = 'เพิ่ม';
        const option1_2 = document.createElement('option');
        option1_2.value = 'ถอน';
        option1_2.text = 'ถอน';
        select1.appendChild(option1_1);
        select1.appendChild(option1_2);
        newRow.insertCell(1).appendChild(select1);

        // Add input elements in columns 2 to 7
        for (let i = 2; i < 8; i++) {
            const cell = newRow.insertCell(i);
            const input = document.createElement('input');
            input.type = 'text';
            input.value = '';
            cell.appendChild(input);
        }

        // Add select element in the last column
        const select2 = document.createElement('select');
        const option2_1 = document.createElement('option');
        option2_1.value = 'true';
        option2_1.text = 'อนุญาต';
        const option2_2 = document.createElement('option');
        option2_2.value = 'false';
        option2_2.text = 'ไม่อนุญาต';
        select2.appendChild(option2_1);
        select2.appendChild(option2_2);
        newRow.insertCell(8).appendChild(select2);
    } else {
        alert("ไม่สามารถเพิ่มแถวเพิ่มเติมได้ เกิน 10 แถว");
    }
}

function deleteRow() {
    const table = document.querySelector('table');
    if (table.rows.length > 1) {
        table.deleteRow(table.rows.length - 1);
        rowCounter--;
    }
}

// ชั้นปี
document.addEventListener("DOMContentLoaded", function () {
    const numb = document.getElementById("numb");
    const submitButton = document.getElementById("submit");

    submitButton.addEventListener("click", function (event) {
        if (numb.value === "") {
            alert("กรุณาเลือกชั้นปี");

            event.preventDefault();
        }
    });
});

//สาขา
document.addEventListener("DOMContentLoaded", function () {
    const secSelect = document.getElementById("sec");
    const submitButton = document.getElementById("submit");

    submitButton.addEventListener("click", function (event) {
        if (secSelect.value === "") {
            alert("กรุณาเลือกสาขา");

            event.preventDefault();
        }
    });
});

document.getElementById('form').addEventListener('submit', (event) => {
    event.preventDefault();
    const form = document.getElementById('form');
    const data = new FormData(form);
    const datasend = {};

    data.forEach((value, key) => {
        datasend[key] = value;
    });

    const list = []
    const dataContainer = document.getElementById('tad');
    const child = dataContainer.querySelectorAll('tr');
    child.forEach((v, k) => {
        if (k < 1) return;
        let arr = [];
        v.querySelectorAll('input').forEach((v, k) => {
            arr.push(v)
        })

        const subject = {
            "addordrop": v.querySelector('select').value,
            "subjectCode": arr[0].value,
            "subjectName": arr[1].value,
            "subjectSection": arr[2].value,
            "subjectDate": arr[3].value,
            "subjectCredit": arr[4].value,
            "subjectTeacher": arr[5].value,
            "subjectTeacherCheck": true
        };
        list.push(subject)
    })

    datasend['subject'] = list;

    console.log(datasend);




    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: JSON.stringify(datasend),
        redirect: 'follow'
    };

    fetch("http://localhost:8080/api/req/create", requestOptions)// ส่งข้อมูลไปยัง URL ที่กำหนด
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
});
