class Validator {

  static hasText(value) {
    if (value == undefined || value.length === 0) {
      return false;
    }
    return true;
  }

  /**
   * 이름은 한글 또는 영어로 2 ~ 5 글자로 구성
   * @param {string} name 
   * @returns 유효한 형식이면 true, 아니면 false 반환
   */
  static isName(name) {
    let regex = /^[가-힣a-zA-Z]{2,5}$/;
    return regex.test(name);
  }

  /**
   * 아이디는 영어 또는 숫자로 6 ~ 20 글자로 구성, 첫글자는 숫자 안됨
   * @param {string} id 
   * @returns 유효한 형식이면 true, 아니면 false 반환
   */
  static isId(id) {
    let regex = /^[A-Za-z]{1}[A-Za-z0-9]{5,19}$/;
    return regex.test(id);
  }

  /**
   * 비밀번호는 숫자 4자리로 구성
   * @param {number} password 
   * @returns 
   */
  static isPassword(password) {
    let regex = /^[0-9]{4}$/ ;
    return regex.test(password);
  }

  static isEquals(value1, value2) {
    return value1 === value2;
  }

  static isSelected(select){
    return select.options.selectedIndex !== 0;
  }

  static isChecked(checkboxs){
    let checked = false;
    checkboxs.forEach(checkbox => {
      if(checkbox.checked){
        checked = true;
      }
    });
    return checked;
  }

}