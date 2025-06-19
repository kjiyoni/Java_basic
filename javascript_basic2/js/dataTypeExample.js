// 템플릿 스트링
let name = '김기정';
let message = `템플릿 스트링 ${name}`;
console.log(message);

// typeof 연산자
let age = 10;
console.log(typeof age);
console.log(typeof message);

// 특수 숫자리터럴(키워드)
console.log(10/0);
console.log('나는 김기정입니다'/10);

// 논리형
let flag = false;
let flag2 = NaN;
if(flag2){
  console.log('참입니다...');
}

// 자바스크립트는 자동형변환이 엄청 많이 발생한다..
console.log(1000 * '10');
console.log('1000' * '10');
