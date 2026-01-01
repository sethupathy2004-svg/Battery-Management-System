let batteries = [];

function addBattery() {
    let name = document.getElementById("name").value;
    let type = document.getElementById("type").value;
    let voltage = document.getElementById("voltage").value;
    let capacity = document.getElementById("capacity").value;

    if (name === "" || type === "") {
        alert("Please fill all fields");
        return;
    }

    let battery = {
        name: name,
        type: type,
        voltage: voltage,
        capacity: capacity
    };

    batteries.push(battery);
    displayBatteries();
    clearFields();
}

function displayBatteries() {
    let table = document.getElementById("batteryTable");
    table.innerHTML = "";

    batteries.forEach(b => {
        let row = `
            <tr>
                <td>${b.name}</td>
                <td>${b.type}</td>
                <td>${b.voltage}</td>
                <td>${b.capacity}</td>
            </tr>`;
        table.innerHTML += row;
    });
}

function clearFields() {
    document.getElementById("name").value = "";
    document.getElementById("type").value = "";
    document.getElementById("voltage").value = "";
    document.getElementById("capacity").value = "";
}
