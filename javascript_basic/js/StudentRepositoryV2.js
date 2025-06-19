// 여러 학생 목록 관리 객체
function StudentRepository() {
  // this = {};
  // this.students = new Array();
  this.students = [];
  // return this;
}

StudentRepository.prototype.addStudent = function (student) {
  this.students.push(student);
}

StudentRepository.prototype.getStudents = function () {
  return this.students;
}

// 학번으로 학생 검색
StudentRepository.prototype.findBySsn = function (ssn) {
  return this.students.find(student => student.ssn === ssn ? true : false);
}

// 이름으로 학생 검색
StudentRepository.prototype.findByName = function (name) {
  return this.students.filter(student => student.name === name ? true : false);
}

// 학번으로 학생 삭제
StudentRepository.prototype.removeBySsn = function (ssn) {
  let deleted = false;
  // 구현하세요...
  this.students.forEach((student, index) => {
    if (student.ssn === ssn) {
      this.students.splice(index, 1);
      deleted = true;
    }
  });
  return deleted;
}

// 평균 범위로 검색
StudentRepository.prototype.findByRange = function (start, end) {
  let list = [];
  this.students.forEach(student => {
    if(student.getAverage() >= start && student.getAverage() <= end){
      list.push(student);
    }
  });
  return list;
}
// ?? 정렬하여 전체 검색
StudentRepository.prototype.findAllbySort = function (fn) {
  return this.students.sort(fn);
}

// 임시 테스트
let studentRepository = new StudentRepository();
studentRepository.addStudent(new Student(10, '김기정', 90, 80, 60));
studentRepository.addStudent(new Student(11, '최기정', 100, 90, 90));
studentRepository.addStudent(new Student(12, '박기정', 92, 82, 80));
studentRepository.addStudent(new Student(13, '최기정', 95, 85, 88));

let allList = studentRepository.getStudents();
for (const student of allList) {
  console.log(student.toString());
}

console.clear();

// 학번으로 검색 테스트
const findStudent = studentRepository.findBySsn(11);
if (findStudent !== undefined) {
  console.log(findStudent);
} else {
  console.log('학번에 해당하는 학생 없시유...');
}

console.log('-----------------------------------------------');

// console.clear();

// 이름으로 검색 테스트
const findStudents = studentRepository.findByName('최기정');
if (findStudents.length !== 0) {
  for (const student of findStudents) {
    console.log(student);
  }
} else {
  console.log('이름에 해당하는 학생 없시유...');
}

// console.clear();
console.log('-----------------------------------------------');

// 학번으로 삭제 테스트
console.log("삭제 테스트");
let removed = studentRepository.removeBySsn(12);
if (removed) {
  console.log('삭제 완료!');
} else {
  console.log('삭제하고자 하는 학생이 존재하지 않습니다.');
}
console.log('-----------------------------------------------');

console.log(studentRepository.getStudents());



// console.clear();

// 평균 범위로 검색 테스트
let rangeList = studentRepository.findByRange(80, 90);
for (const student of rangeList) {
  console.log(student.toString());
}

console.log("======================================");

// 전체 목록
allList = studentRepository.getStudents();
for (const student of allList) {
  console.log(student.toString());
}

console.log("============= 정렬 테스트 ====================");
// 평균 내림차순으로 정렬하여 목록 보여주고 싶다...
let sortedList = studentRepository.findAllbySort((student1, student2) => student1.getAverage() - student2.getAverage());
sortedList.forEach(student => {
  console.log(student.toString());
});


