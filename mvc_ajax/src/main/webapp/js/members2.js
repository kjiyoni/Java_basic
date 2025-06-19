showList();

function memberList() {
    const url = "/members.jsp";
	let promise = fetch(url);
	return promise.then(response => response.json());
}

// 수신 결과 출력
async function  showList() {
	let array = await memberList();
    const view = document.querySelector("#result");
    if(array){
		array.forEach(member => {
	 		console.log(member);
	 		// 돔 처리는 여러분이 하세요...
	 	});
     }
}





