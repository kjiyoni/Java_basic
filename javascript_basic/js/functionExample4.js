// 콜백함수는 왜 써야 하나?
function calculate(fn, a, b){
  // 데이터 처리
  return fn(a, b);
}

let num1 = 300, num2 = 500;

let result = calculate(function (x, y){
  return x + y;
}, num1, num2);
console.log(result);

result = calculate((x, y)=> x+y , num1, num2);
console.log(result);

result = calculate(function(x, y){
  return x * y;
}, num1, num2);
console.log(result);

// 즉시호출
(function doTask() {
  console.log("나는 즉시 호출됩니다...");
})();

