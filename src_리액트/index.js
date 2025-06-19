import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import './index2.css';
import App from './App';
import ContextExampleApp from './ContextExampleApp';
import reportWebVitals from './reportWebVitals';
import ReduxToolkitApp from './ReduxToolkitApp';

const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render( <React.StrictMode> <App/></React.StrictMode>);
root.render( <React.StrictMode><ReduxToolkitApp /></React.StrictMode>);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
