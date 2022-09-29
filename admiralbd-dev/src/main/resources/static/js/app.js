let departureWaySelect = document.getElementsByName('departureWay')[0];
let consignorsSelect = document.getElementsByName('consignor')[0];

function setDisableSelects(flag) {
    departureWaySelect.disabled = flag;
    consignorsSelect.disabled = flag;
}

async function addConsignorsToSelect() {


    setDisableSelects(true);

    let defaultOption = document.createElement('option');
    defaultOption.selected;
    defaultOption.innerHTML = 'Выберите грузоотправителя';
    consignorsSelect.innerHTML = '';
    consignorsSelect.appendChild(defaultOption);

    let departureWay = departureWaySelect.options[departureWaySelect.selectedIndex].value;

    let url = "api/departures/consignors?departureWay=" + departureWay;
    let response = await fetch(url);

    if (response.ok) {
        let json = await response.json();
        json.forEach(element => {
            let option = document.createElement('option');
            option.value = element;
            option.innerHTML = element;
            consignorsSelect.appendChild(option);
        });
    } else {
        alert("Ошибка HTTP: " + response.status);
    }

    let n = consignorsSelect.childElementCount
    for (let i = 1; i < n; i++) {
        let hr = document.createElement('hr');
        consignorsSelect.insertBefore(hr, consignorsSelect[consignorsSelect.length - i]);
    }

    setDisableSelects(false);
}

departureWaySelect.onchange = addConsignorsToSelect;

// Рисуем линии в departureWaySelect
let n = departureWaySelect.childElementCount
for (let i = 1; i < n; i++) {
    let hr = document.createElement('hr');
    departureWaySelect.insertBefore(hr, departureWaySelect[departureWaySelect.length - i]);
}


 addConsignorsToSelect();
