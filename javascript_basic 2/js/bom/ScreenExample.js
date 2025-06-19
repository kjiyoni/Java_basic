function openWindowCenter(url, name,  width, height){
  const left  = (screen.availWidth - width) / 2;
  const top = (screen.availHeight - height) / 2;
  const option = `left=${left}, height=${top}, width=${width}, height=${height}`
   open(url, name, option);
}

openWindowCenter('../../hello.html', '', 300, 200);