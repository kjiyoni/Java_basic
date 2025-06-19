// 이벤트 소스에 이벤트 리스너 등록
document.querySelector('#id').addEventListener('input' , event => {
    let inputId= event.target.value;
    idCheck(inputId);
    //console.log(inputId);
    //memberRegister();
});

function idCheck(inputId) {
    const url = `/ajax/member/idcheck?id=${inputId}`;
	fetch(url)
		.then(reponse =>reponse.json())
		.then(result =>{
			showResult(result)
		});
		//.catch(error => alert(error));
}

// 수신 결과 출력
function  showResult(result) {
    const view = document.querySelector("#result");
    if(view){
		if(result){
			view.innerHTML = "사용 불가능허유....";	
		}else{
			view.innerHTML = "사용 가능허유....";
		}
    }
}





