// submit 이벤트 처리
// document.querySelector('form').addEventListener();
document.memberRegister.addEventListener('submit', sendServer);

// 이메일 선택 입력 이벤트 처리
document.memberRegister.emailaddress.addEventListener('change', event => {
  const emailDns = document.memberRegister['email_dns'];
  const options = event.target.options;
  emailDns.value = options[options.selectedIndex].value;
});

// 파일 선택 이벤트 처리
document.memberRegister.picture.addEventListener('change', event => {
  let fileList = event.target.files;
  let fileInfo;
  for (const file of fileList) {
    fileInfo = `파일명: ${file.name}, 파일크기: ${file.size}, 파일종류: ${file.type}, 변경날짜: ${file.lastModifiedDate}`;
  }
  document.querySelector('figure').innerHTML = fileInfo;
});

// 서버 데이터 전송
function sendServer(event) {
  // 기본 이벤트 해제
  event.preventDefault();
  const uname = document.memberRegister.uname.value;
  const uid = document.memberRegister.uid.value;
  const upassword = document.memberRegister.upassword.value;
  const reupassword = document.memberRegister['re-upassword'].value;

  // #1. 유효성 검증 (입력여부 확인)
  if(!Validator.hasText(uname)){
    alert('이름을 입력하여 주세요.');
    return;
  }
  if(!Validator.hasText(uid)){
    alert('아이디를 입력하여 주세요.');
    return;
  }
  if(!Validator.hasText(upassword)){
    alert('비밀번호를 입력하여 주세요.');
    return;
  }
  if(!Validator.hasText(reupassword)){
    alert('비밀번호 확인을 입력하여 주세요.');
    return;
  }
  // 나머지 폼 요소는 편의상 생략

  // #2. 유효성 검증 (입력 형식 확인)
  if(!Validator.isName(uname)){
    alert('이름은 2~5자 사이어야 합니다.');
    return;
  }
  if(!Validator.isId(uid)){
    alert('아이디는 숫자로 시작할 수 없으며,\n영어/숫자로 6 ~ 20자 사이어야 합니다');
    return;
  }
  if(!Validator.isPassword(upassword)){
    alert('비밀번호는 숫자 4자리로 입력하여야 합니다.');
    return;
  }
  if(!Validator.isPassword(reupassword)){
    alert('비밀번호 확인은 숫자 4자리로 입력하여야 합니다.');
    return;
  }
  if(!Validator.isEquals(upassword, reupassword)){
    alert('비밀번호와 비밀번호 확인은 같아야 합니다.');
    return;
  }

  if(!Validator.isSelected(document.memberRegister.job)){
    alert('직업을 선택하여 주세요.');
    return;
  }
  
  if(!Validator.isChecked(document.querySelectorAll('[name=interest]'))){
    alert('관심분야를 선택하여 주세요.');
    return;
  }

  if(document.memberRegister.picture.files.length === 0){
    alert('파일을 선택하여 주세요.');
    return;
  }

  // 데이터 검증이 완료되면 서버로 전송
  document.memberRegister.submit();

}
