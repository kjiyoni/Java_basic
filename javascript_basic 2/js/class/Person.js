
class Person {
  
  // 정적 속성(static)
  static commonAttribute = "공통속성";
  // 정정 메소드
  static commonMethod(){
    console.log("공통 메소드입니다..");
  }
  
  constructor(name, age){
    // this = {};
    this.name = name;
    this.age = age;
    // return this;
  }
  // setter/getter
  get name(){
    return this._name;
  }
  set name(name){
    // 데이터 유효성 검증
    if(name === undefined){
      throw new Error('이름은 반드시 입력하여야 합니다.');
    }
    this._name = name;
  }

  get age(){
    return this._age;
  }

  set age(age){
    if(age < 10 || age > 100){
      throw new Error("나이는 10 ~ 100사이여야 한다 띠바야~~~");
    }
    this._age = age;
  }

  showInfo(){
    console.log(`이름: ${this.name}, 나이: ${this.age}`);
  }
}

let person = new Person('김기정', 30);
person.name = '강기정';
console.log(person.name);
console.log(person.age);
person.showInfo();

try{
  // person.name = undefined;
  person.age = 900;
}catch(e){
  alert(e.message);
}
person.showInfo();

console.log(Person.commonAttribute);
Person.commonMethod();

//person.commonMethod(); error
