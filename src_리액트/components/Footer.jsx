import { useContext } from "react";
import { ThemeContext } from "../ContextExampleApp";

function Footer() {
  const {isDark, setIsDark} = useContext(ThemeContext);
  
  const toggleTheme = () => {
    setIsDark(!isDark);
  }
  
  return (
    <footer className="footer" 
    style={{
      backgroundColor: isDark ? 'black' : 'gray'
    }}>
      <button className="button" onClick={toggleTheme}>Dark Mode</button>
    </footer>
  );
}

export default Footer;