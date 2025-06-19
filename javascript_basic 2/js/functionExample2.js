// 중첩(Helper)함수 정의
function  main() {
  console.log("주기능입니다....");

  function helper(num) {
   return  Math.pow(num, 2);    
  }

  let x = 10;
  let reult = helper(x);
  console.log(reult);
}

main();

//helper();
