
document.querySelector("form").addEventListener("submit", uploadFiles);

function uploadFiles(event) {
  event.preventDefault();
  const comments = document.querySelector("#comments").value;
  const upfiles = document.querySelector("#upfile").files;

  let formData = new FormData();
  formData.append("comments", comments);
  //console.dir(upfile.files); // 유사배열  
  for (file of upfiles) {
    formData.append("upfile", file);
  }
  const url = "/upload";
  const options = {
    method: "post",
    body: formData
  };

  fetch(url, options) //
    .then(response => response.text())
    .then(message => console.log("파일 업로드 결과: " + message))
    .catch(error => console.log(error));
}

