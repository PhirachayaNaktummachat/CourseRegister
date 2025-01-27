let rowCounter = 1;

function addRow() {
    const table = document.querySelector('table');
    if (rowCounter < 10) {
        const newRow = table.insertRow(table.rows.length);

        newRow.insertCell(0).textContent = ++rowCounter;
        for (let i = 1; i < 7; i++) {
            const cell = newRow.insertCell(i);
            const input = document.createElement('input');
            input.type = i === 7 ? 'checkbox' : 'text'; // Set input type to 'checkbox' for the last column
            input.name = i === 7 ? `checkbox_${rowCounter}` : `column_${rowCounter}_${i}`;
            cell.appendChild(input);
        }
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