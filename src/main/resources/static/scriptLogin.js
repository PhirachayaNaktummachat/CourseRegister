function login(event) {
    event.preventDefault() //the page do not refresh
    let username = document.getElementById("username").value
    let password = document.getElementById("password").value
    console.log(username)
    console.log(password)

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");
    myHeaders.append("Application-Key", "TUf783ab7684acf1b8912e1f6649c57f6907e3e78c2fe7a35d46325733ca97eeffde1d615d3999188d8b26b7e3b28d61b5");
    //TU token form Tu official-website
    var raw = JSON.stringify({
        "UserName": username,
        "PassWord": password
    });

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    //TU API
    fetch("https://restapi.tu.ac.th/api/v1/auth/Ad/verify", requestOptions)
        .then(response => {
            if (!response.ok) {
                throw new Error('Bad Request');
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            alert("login success!");
            window.location.href = "mainpage2.html"; //go to next html page
        })
        .catch(error => {
            console.log('Error:', error);
            alert("invalid username or password");
        });

}

