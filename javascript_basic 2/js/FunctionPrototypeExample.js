// 전역 함수 선언
function doTask() {
  // console.log("어떤일을 합니다...");
  console.dir(this);
  console.log(`이름 : ${this.name}, 나이 : ${this.age}`);
}

// 객체 생성
let person = {
  name : '김기정',
  age : 30,
  doTeach : function () {
    console.log("프로그래밍을 강의합니다..");
  }
}
// 함수 직접 호출
doTask();

// 함수 간접 호출
// doTask.call();
doTask.call(person);


// 특정객체에 동적 속성 추가 기능
function addAttribute(key , value) {
  this[key] = value;
}

addAttribute('name', '김기정');
addAttribute('age', 30);

console.dir(window);

let user = {};
// addAttribute.call(user, 'name', '김기정');
// addAttribute.call(user, 'age', 30);
// addAttribute.apply(user, ['name', '김기정']);
// addAttribute.apply(user, ['age', 30]);
let addProperty = addAttribute.bind(user);
addProperty('name', '김기정');
addProperty('age', 30);

console.dir(user);

let array = [6, 2, 9, 1];

for (const key in array) {
  if (Object.hasOwnProperty.call(array, key)) {
    const value = array[key];
    console.log(value);
    
  }
}




