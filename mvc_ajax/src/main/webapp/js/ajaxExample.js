// 이벤트 소스에 이벤트 리스너 등록
const buuton = document.querySelector('button');
buuton.addEventListener('click' , event => {
    ajaxRequet();
});

function ajaxRequet() {
    let name = document.querySelector("[type='text']").value;

    // #1. 서버와의 비동기 통신을 위해 XMLHttpRequest 객체 생성
    let request = new XMLHttpRequest();
    // console.dir(request);
    // #2. 요청 초기화
    request.open('get', `/ajax/hello-action?name=${name}`); // get, post. put, delete, header......
    // request.open('post', '/ajax/hello-action'); // get, post. put, delete, header......
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    // 서버로부터 응답메시지 비동기 수신을 위한 이벤트 등록
    request.addEventListener('readystatechange', event =>{
        // console.log('상태값 : ' + request.readyState);
        // console.log("응답텍스트 : " + request.responseText);
        // 모든 데이터 수신 완료
        if(request.readyState === 4) {
            console.log("응답텍스트 : " + request.responseText);
            // 응답 코드별 분기
            if(request.status === 200){
                console.log("응답텍스트 : " + request.responseText);
                showMessage(request.responseText);
            }else if(request.status === 400){
                console.log("잘못된 요청입니다..");
            }else if(request.status === 404){
                console.log("요청하신 페이지지를 찾을 수 없습니다.");
            }else{
                console.log("관리자에게 문의 바랍니다...");
            }
        }else{ // 미수신
            console.log("데이터 수신중.......");
        }
    });
    // #3. 요청 보내기
    //request.send(); 
    request.send(`name=${name}`); 
}

// 수신 메시지 출력
function  showMessage(message) {
    const view = document.querySelector("#message");
    if(view){
        view.innerHTML = message;
    }
}








