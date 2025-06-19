// 표준 내장 함수
// const yn = confirm('너 바보냐?');
// if(yn){
//   console.log('응 바보군...');
// }else{
//   console.log('거짓말이군..');
// }

// setTimeout(() => console.log('1초후 실행되었습니다..'), 2000);

// let second = 1;
// let timer = setInterval(() => {
//  document.write(`<h3>${second}초</h3>`);
//   second++;
// }, 1000);

// // 10초후 타이머 제거
// setTimeout(() => {
//   clearTimeout(timer);
// }, 10000);

let money = '100원';
money = parseInt(money);
console.log(money + 100);

let reult = 1000/'김기정';
if(isNaN(reult)){
  console.log('헐~~~~~');
}
