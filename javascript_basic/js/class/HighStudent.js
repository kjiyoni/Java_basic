import { Student } from "./Student.js";

export
class HighStudent extends Student {
  constructor(ssn, name, korean, english, math, age){
    //this = {};
    super(ssn, name, korean, english, math);
    this.age = age;
  }
  // 편의상 setter/getter 생략

  // 메소드 오버라이딩
  toString() {
    return super.toString() + `\t ${this.age}`;
  }
}

// let highStudent = new HighStudent(10, '김기정', 90, 80, 50, 30);
// console.log(highStudent.toString());

// let string = new String("문자열");