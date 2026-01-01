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
function calculateSOC() {
    let voltage = document.getElementById("measuredVoltage").value;
    let ratedVoltage = document.getElementById("ratedVoltage").value;

    if (voltage === "" || ratedVoltage === "") {
        alert("Enter voltage values");
        return;
    }

    fetch(`http://localhost:8080/battery/soc?voltage=${voltage}&ratedVoltage=${ratedVoltage}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById("socResult").innerText =
                "State of Charge (SOC): " + data.toFixed(2) + "%";
        })
        .catch(error => {
            console.error(error);
            alert("Backend not running");
        });
}

