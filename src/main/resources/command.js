(async function deletePhoto(id) {
    await fetch('http://localhost:8080/photoz/' + id, {
        method: "DELETE"
    })})("5");

(async function createPhoto() {
    let photo = {"fileName": "hello.jgp"};
    await fetch('http://localhost:8080/photoz/', {
        method: "POST",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
        body: JSON.stringify(photo)
    }).then( result => result.text()).then(text => alert(text));
    })();
