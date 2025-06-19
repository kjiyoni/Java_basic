// 전역변수 선언
let global = "전역변수입니다..";

console.log(sum(900, 200));

// 사용자 정의 함수
function sum(x, y) {
  return x + y;
}

function printGugudan() {
  document.write('<h2>for문을 이용한 구구단 출력</h2>');
  document.write("<table border='1'>");
  for (let i = 2; i <= 9; i++) {
    document.write("<tr>");
    for (let j = 1; j <= 9; j++) {
      document.write(`<td>${i} * ${j} = ${i * j}</td>`);
    }
    document.write("</tr>");
  }
  document.write("</table>");
}

function doTask() {
  let some = 100;
  let i = 0;
  for (i = 0; i < 10; i++) {
    console.log(i);
  }
  console.log(i);
  // return undefied;
}

// 디폴트 파라메터
function sendMessage(message = "헐....."){
  console.log(message + "를 서버에 전달합니다....");
}

// Rest Parameter(비정형 인자)
function sum(...nums) {
  let result = 0;
  for (const num of nums) {
    result += num;    
  }
  return result;
}
sum(1);
sum(1, 2);
sum(1, 2, 3);

const res = sum(1, 2, 3, 4, 1000, 4354454, 454545454, 545454);
console.log(res);



sendMessage("김기정 바보");
sendMessage();

// 함수 호출
let result = sum(10, 5);
console.log(result);
printGugudan();

// 함수 호출 시, 정의된 매개변수와 전달인자의 개수가 일치하지 않더라도 호출이 가능하다.
result = sum(10);
console.log(result);

let reslut = doTask();
console.log(reslut);
