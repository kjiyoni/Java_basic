import ContextExampleApp, { ThemeContext } from '../ContextExampleApp';
import React, { useContext } from 'react';
import Content from "./Content";
import Footer from "./Footer";
import Headder from "./Headder";

function Page() {
  // const theme = useContext(ThemeContext);
  return (
    <div className="page">
      <Headder />
      <Content />
      <Footer />
    </div>
  );
}

export default Page;