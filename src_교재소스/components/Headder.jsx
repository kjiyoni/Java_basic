function Headder({isDark, setIsDark}) {
  return (
    <header className="header" 
    style={{
      backgroundColor: isDark ? 'black' : 'gray',
      color: isDark ? 'white' : 'black',
    }}>
      <h1>환영합니다. 방그리님!</h1>
    </header>
  );
}

export default Headder;