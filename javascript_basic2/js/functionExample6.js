//  함수를 맹그는 방법 3가지
// #1. 함수 선언식
// #2. 함수 표현식
// #3. Function 생성자 함수를 이용한 동적 함수 생성

// 스트립트 준비단계에서 하는 동작
// function Function(){
//   //-----
// }
// 자바스크립트 표준 내장객체는 Function 생성자 함수에 의해 동적 생성된다.
// let Object = new Function('~~~~~');
// let String = new Function('~~~~~');
// let Date = new Function('~~~~~');
// let Number = new Function('~~~~~');
// let Boolean = new Function('~~~~~');

// 나도 동적으로 함수 함 맹글어 봐야지~~~
let sum = new Function('x', 'y', 'return x + y');
let result = sum(10, 20);
console.log(result);





