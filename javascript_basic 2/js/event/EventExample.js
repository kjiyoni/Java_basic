// 이벤트 소스에 이벤트 리스너 등록
// function eventListener(event) {
//   console.log('왜 눌렀냐???????');
// }
document.querySelector('button').addEventListener('click', (event) => {
  console.dir(event);
  if (event.ctrlKey) {
    event.target.style.backgroundColor = 'blue';
    console.log('왜 눌렀냐???????')
  }
});

document.querySelector('button').addEventListener('mouseenter', event => {
  console.dir(this);
  event.target.style.backgroundColor = 'yellow';
});

document.querySelector('button').addEventListener('mouseleave', event => {
  event.target.style.backgroundColor = '';
});

function serverSend(message) {
  console.log(message + '를 서버에 전송합니다..');
}

let input = document.querySelector('[type=text]');
input.addEventListener('keypress', event => {
  // console.log(input.value);
  if (event.keyCode === 13) {
    const message = event.target.value;
    serverSend(message);
    event.target.value = '';
  }
});

console.dir(document.frm.search);
document.frm.search.addEventListener('change', event => {
  console.dir(event.target.options);
  let options = event.target.options;
  let selectValue = options[options.selectedIndex].value;
  console.log(selectValue);
});

document.frm.search.addEventListener('change', event => {
  let options = document.querySelectorAll('option');
  options.forEach(function (element) {
    if(element.selected){
      console.log(element.value);
    }    
  });
});
