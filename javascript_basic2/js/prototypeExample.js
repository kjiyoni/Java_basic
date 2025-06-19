// console.clear();

console.dir(Student); // 최상위 객체는 Function 프로토타입 객체
console.dir(student1); // 최상위 객체는 Object 프로토타입 객체

let string = new String("김기정입다.");
console.dir(string);
console.dir(String);

let array = [5, 3, 6];
console.dir(array);

//  객체 리터럴 표현식을 이용한 객체 즉시 생성
let person = {
  name : '김기정',
  age : 30,
  doTeach : function(){
    console.log('프로그램 강의합니다...');
  }
};

console.log(person.constructor === Object);
console.dir(person);
console.dir(person.hasOwnProperty('name'));

