import { Student, yyy } from "./Student.js";
import { HighStudent} from "./HighStudent.js";

let student = new Student(10, '김기정', 90, 80, 50);
console.log(student.toString())

let highStudent = new HighStudent(10, '김기정', 90, 80, 50, 30);
console.log(highStudent.toString());

yyy();

