import { createContext, useContext, useState } from 'react';
import './App.css';
import Page from './components/Page';

export const ThemeContext = createContext(null);
export const MemberContext = createContext(null);

function ContextExampleApp() {

  const [isDark, setIsDark] = useState(false);

  return (
    <MemberContext.Provider value={'김기정'}>
      <ThemeContext.Provider value={{ isDark, setIsDark }}>
        <Page />
      </ThemeContext.Provider>
    </MemberContext.Provider>

  );
}

export default ContextExampleApp;
