const url = "http://localhost:8080/task/user/2";

function hideLoader() {
    document.getElementById("loading").style.display = "none";
}

function show(tasks) {
    let tab = ` 
        <thead>
            <th scope="col">#</th>
            <th scope="col">Description</th>
            <th scope="col">Username</th>
            <th scope="col">user id</th>
        </thead>`;

    for (let ts of tasks) {
        tab += `
            <tr>
                <td scope="row">${ts.id}</td>
                <td scope="row">${ts.description}</td>
                <td scope="row">${ts.user.username}</td>
                <td scope="row">${ts.user.id}</td>
            </tr>
        `;         
    }
    document.getElementById("tasks").innerHTML = tab;
}


async function getAPI(url) {
    const response = await fetch(url, {
        method: "GET"
    })

    var data = await response.json();
    console.log(data);
    if(response) 
        hideLoader();
    show(data);
    
}

getAPI(url);