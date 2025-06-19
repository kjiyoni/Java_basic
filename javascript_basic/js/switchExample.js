let score = prompt('점수를 입력하세요', 0);
let number = score/10;
number = Math.floor(number);
switch (number) {
  case 10:
  case 9: console.log('수'); break;
  case 8: console.log('우'); break;
  case 7: console.log('미'); break;
  case 6: console.log('양'); break;
  default: console.log('가'); 
}