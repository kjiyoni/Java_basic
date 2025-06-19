// 이벤트 소스에 이벤트 리스너 등록
const buuton = document.querySelector('button');
buuton.addEventListener('click' , event => {
    memberRegister();
});

function memberRegister() {
    const name = "김기정";
    const id = "bangry";
    const passwd = "1111";
    const email = "bangry@gmail.com";
    
    const member = {
		name,
		id,
		passwd,
		email
	};
	    
    const url = "/member-register.jsp";
    
    const options = {
		method : "post",
		headers : {
			"Content-Type" : "application/x-www-form-urlencoded"
		},
		body : JSON.stringify(member)
	}
	
	fetch(url, options)
		.then(reponse =>reponse.json())
		.then(result =>{
			showResult(result)
			//console.dir(result);
		});
		//.catch(error => alert(error));
}

// 수신 결과 출력
function  showResult(result) {
    const view = document.querySelector("#result");
    if(view){
		if(result.result){
			view.innerHTML = result.message;	
		}else{
			view.innerHTML = "회원 등록이 실패하였습니다..";
		}
    }
}





