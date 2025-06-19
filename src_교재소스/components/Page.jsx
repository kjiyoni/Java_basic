import React from 'react';
import Content from "./Content";
import Footer from "./Footer";
import Headder from "./Headder";

function Page({isDark, setIsDark}) {
  return (
    <div className="page">
      <Headder isDark={isDark} />
      <Content isDark={isDark} />
      <Footer isDark={isDark} setIsDark={setIsDark}/>
    </div>
  );
}

export default Page;