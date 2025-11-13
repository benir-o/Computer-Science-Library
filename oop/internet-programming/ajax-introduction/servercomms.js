function loadDoc() {
      const xhr = new XMLHttpRequest();
      xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
          if ((xhr.status = 200)) {
            console.log("Ola Benir");
            document.getElementById("demo").innerHTML = xhr.responseText;
          } else {
            alert("An Error Occurred");
          }
        }
      };
      xhr.open("GET", "ajax_info.txt", true);
      xhr.send();
    }