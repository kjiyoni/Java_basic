memberList();

function memberList() {
    const url = "/members.jsp";
	fetch(url)
		.then(reponse =>reponse.json())
		.then(array =>{
			//console.dir(array);
			showList(array)
			//console.dir(result);
		});
		//.catch(error => alert(error));
}

// 수신 결과 출력
function  showList(array) {
    //const view = document.querySelector("#result");
    if(array){
		array.forEach(member => {
			console.log(member);
			// 돔 처리는 여러분이 하세요...
		});
    }
}





