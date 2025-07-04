// Fetch API를 이용한 비동기 통신
const buton = document.querySelector('button');

buton.addEventListener('click' , event => {
	requestBooks();
});

function requestBooks(){
	fetch("http://localhost/books.jsp")//
		.then(response => response.json())
		.then(object => {
			showMessage(object);
		});
}


function showMessage(object) {
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


