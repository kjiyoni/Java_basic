// 함수 리터럴 표현식
// 익명 함수
let myFunction = function (meessage) {
  console.log(meessage);
}

function doTask(fn) {
  let some = '할렐우야...';
  // 콜백함수...............
  fn(some);
}

// 함수 호출
myFunction('함수 리터럴 표현식입니다..');

doTask(myFunction);