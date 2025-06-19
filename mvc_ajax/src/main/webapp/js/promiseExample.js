
function doAsyncTask(resolve, reject){
	let serverMessage = "서버로부터 수신한 데이터";
	//let serverMessage = undefined;
	if(serverMessage){
		// promise에게 데이터 전달
		resolve(serverMessage);
	}else{
		reject("데이터 수신 실패...");		
	}
}
//doAsyncTask();
new Promise(doAsyncTask)
	.then(message => alert(message))
	.catch(error => alert(error));





















