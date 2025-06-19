console.dir(window.document.firstChild);
console.dir(document.firstElementChild);
console.dir(document.firstElementChild.constructor);

// #1. 돔트리 계층 구조로 검색
// Node의 공통 속성 3개
console.log(document.firstElementChild.nodeType === Node.ELEMENT_NODE);
console.log(document.firstElementChild.nodeName);
console.log(document.firstElementChild.nodeValue);

// body 요소 접근
console.log(document.firstElementChild.lastElementChild.nodeName); 


// #2. get메드로 특정 요소 접근
let pArray = document.getElementsByTagName('p');
console.log(pArray.length);
// 리턴타입은 배열이 아니고 유사배열입니다...
console.log(pArray.constructor);
for (const element of pArray) {
  console.log(element.nodeName);
}

let pElement = document.getElementById('myP');
console.dir(pElement);

let htmlCollection = document.getElementsByClassName('container');
console.dir(htmlCollection);

console.clear();

// #3. CSS 선택자를 이용한 검색
// console.dir(document.querySelector('p'));
//  console.dir(document.querySelectorAll('p'));
let nodeList = document.querySelectorAll('p');
nodeList.forEach(element => {
  console.log(element.nodeName);
});

let pEl= document.querySelector('#myP');
console.log(pEl.nodeName);

let textNode = pEl.firstChild;
console.log(textNode.nodeName);
console.log(textNode.nodeValue);
// alert(textNode.nodeValue);

console.log(document.querySelector('.container').firstChild.nodeValue);

console.log(document.querySelector('li:first-child').firstChild.data);
console.log(document.querySelector('li:last-child').firstChild.data);
let list = document.querySelectorAll('li:nth-child(2n+1)');
list.forEach(element => {
  console.log(element.firstChild.nodeValue);
});



