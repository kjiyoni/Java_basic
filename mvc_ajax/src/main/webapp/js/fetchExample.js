// 이벤트 소스에 이벤트 리스너 등록
const buuton = document.querySelector('button');
buuton.addEventListener('click' , event => {
    request();
});

function request() {
    const name = document.querySelector("[type='text']").value;
    //const url = `/hello-view.jsp?name=${name}`;
    const url = "/hello-view.jsp";
    
    const options = {
		method : "post",
		headers : {
			"Content-Type" : "application/x-www-form-urlencoded"
		},
		body : `name=${name}`
	}
	
	fetch(url, options)
		.then(reponse =>reponse.text())
		.then(message =>showMessage(message))
		.catch(error => alert(error));
}

// 수신 메시지 출력
function  showMessage(message) {
    const view = document.querySelector("#message");
    if(view){
        view.innerHTML = message;
    }
}








