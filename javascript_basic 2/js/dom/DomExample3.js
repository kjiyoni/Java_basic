// 속성 제어하기
let aElement = document.querySelector('a');
let value = aElement.getAttribute('href');
console.log(value);
aElement.setAttribute('href', 'https://www.google.com');

// 노드 생성 및 연결
// let liE = document.createElement('li');
// let text = document.createTextNode('졸지마');
// liE.appendChild(text);
// document.querySelector('ol').appendChild(liE);

document.querySelector('ol').innerHTML = '<b>졸지마</b>';
console.log(document.querySelector('ol').innerText);

function show() {
  let div = '<div>댓글 내용입니다...<div>';
  let article = document.querySelector('article');
  article.innerHTML = div;
}


