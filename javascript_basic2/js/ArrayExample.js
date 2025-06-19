// let array = new Array();
let array = [];
array.push(10);
array.push('김기정바보');
array.push(new Student(10, '김기정', 50, 40, 30));
array.push(new Student(11, '박상훈', 90, 100, 95));
array.unshift(new Student(12, '이희영', 90, 100, 95));

for (const value of array) {
  console.log(value);
}

console.log(array[0]);
// console.dir(array);
console.log(array.length);

// delete array[0];
array.shift();
// array.pop();
console.dir(array);

