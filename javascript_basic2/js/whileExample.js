let i = 1, reslut = 0;
while (i <= 100) {
  reslut += i;
  i++;
}
console.log(reslut);

reslut = 0;
for (let i = 1; i <= 100; i++) {
  reslut += i;
}
console.log(reslut);

// 동적 구구단 출력
document.write("<h2 class='w-50 m-auto'>for문을 이용한 구구단 출력</h2>");
document.write("<table class='w-50 m-auto table table-dark table-striped table-hover'>");
for (let i = 2; i <= 9; i++) {
  document.write("<tr>");
  for (let j = 1; j <= 9; j++) {
    document.write(`<td>${i} * ${j} = ${i*j}</td>`);
  }
  document.write("</tr>");
}
document.write("</table>");
  
  

