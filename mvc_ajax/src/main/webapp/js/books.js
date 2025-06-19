const buton = document.querySelector('button');
buton.addEventListener('click' , event => {
   //getBooks();
   new Promise(getBooks)
	.then(message => JSON.parse(message))
	.then(object => showMessage(object))
	.catch(error => alert(error))
	.finally(() => {
		console.log('정상처리든 아니든 항상 실행');
	});
});
	
function getBooks(resolve, reject) {
    let request = new XMLHttpRequest();
    request.open('get', `/books.jsp`);
    request.addEventListener('readystatechange', event =>{
        if(request.readyState === 4) {
            if(request.status === 200){
				resolve(request.responseText);
            }else{
				reject(request.status);
            }
        }else{ 
            console.log("데이터 수신중.......");
        }
    });
    request.send(); 
}





function  showMessage(object) {
	//console.dir(object);
	// 테이블로 동적 출력
    const tbody = document.querySelector("#books");
    if(tbody){
		let list = '';
		object.books.forEach((book)=>{
			//console.log(book);
			list += `<tr>
		               <td>${book.title}</td>
		               <td>${book.author}</td>
		               <td>${book.publisher}</td>
		               <td>${book.kind}</td>
		               <td>${book.price}</td>
		            </tr>`;
		});
		//console.log(list);
		tbody.innerHTML = list;
    }
}


