// 여러 학생 목록 관리 객체
function StudentRepository() {
  // this = {};
  // this.students = new Array();
  this.students = [];

  this.addStudent = function (student) {
    this.students.push(student);
  }

  this.getStudents = function () {
    return this.students;
  }

  // 학번으로 학생 검색
  this.findBySsn = function (ssn) {
    // 구현하세요...
    for (const student of this.students) {
      if (student.ssn === ssn) {
        return student;
      }
    }
    return undefined;
  }

  // 이름으로 학생 검색
  this.findByName = function (name) {
    // 구현하세요...
    let list = [];
    for (const student of this.students) {
      if (student.name === name) {
        list.push(student);
      }
    }
    return list;
  }

  // 학번으로 학생 삭제
  this.removeBySsn = function (ssn) {
    // 구현하세요...
    for (let i = 0; i < this.students.length; i++) {
      if (this.students[i].ssn === ssn) {
        // delete this.students[i]; 위험한 삭제
        this.students.splice(i, 1);
        return true;
      }
    }
    return false;
  }

  // 평균 범위로 검색
  this.findByRange = function (start, end) {
    let list = [];
    for (let student of this.students) {
      if (student.getAverage() >= start && student.getAverage() <= end) {
        list.push(student);
      }
    }
    return list;
  }

  // return this;
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

console.clear();

// 이름으로 검색 테스트
const findStudents = studentRepository.findByName('최기정');
if (findStudents.length !== 0) {
  for (const student of findStudents) {
    console.log(student);
  }
} else {
  console.log('이름에 해당하는 학생 없시유...');
}

console.clear();

// 학번으로 삭제 테스트
let removed = studentRepository.removeBySsn(12);
if (removed) {
  console.log('삭제 완료!');
} else {
  console.log('삭제하고자 하는 학생이 존재하지 않습니다.');
}

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

