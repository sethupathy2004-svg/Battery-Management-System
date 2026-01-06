function calculateSOC() {
    let voltage = document.getElementById("voltage").value;
    let ratedVoltage = document.getElementById("ratedVoltage").value;

    fetch(`/battery/soc?voltage=${voltage}&ratedVoltage=${ratedVoltage}`)
        .then(res => res.text())
        .then(data => {
            document.getElementById("result").innerText =
                "SOC: " + data + "%";
        });
}

//  1.SAVE
function saveBattery() {
    let battery = {
        name: document.getElementById("name").value,
        voltage: document.getElementById("voltage").value,
        ratedVoltage: document.getElementById("ratedVoltage").value
    };

    fetch("/battery/add", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(battery)
    })
    .then(res => res.json())
    .then(data => {
        alert("Battery Saved with ID: " + data.id);
    });
}

// 2️.FETCH
function loadBatteries() {
    fetch("/battery/all")
        .then(res => res.json())
        .then(data => {
            let list = document.getElementById("batteryList");
            list.innerHTML = "";
            data.forEach(b => {
                let li = document.createElement("li");
                li.innerText = b.name + " | " + b.voltage + "/" + b.ratedVoltage;
                list.appendChild(li);
            });
        });
}
