// 일반함수
function generalDoTask() {
    return "일반함수입니다..";    
}
console.log(generalDoTask());

// 비동기 함수
async function asyncDoTask() {
    const message = "서버로부터 받은 데이터";
    return message;
}

async function some() {
    let message = await asyncDoTask();
    console.log(message);
}

some();





