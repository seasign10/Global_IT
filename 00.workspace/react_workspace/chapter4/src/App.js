// import logo from './logo.svg';
// import './App.css';

// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }

// export default App;


import './App.css';
import Header from './component/Header';
import Body from './component/Body';
import Footer from './component/Footer';

// // Header 컴포넌트
// function Header() {
//   return (
//     <header className="App-header">
//       <h1>My React App</h1>
//     </header>
//   );
// }

// App 컴포넌트
function App() {
  const name = "홍길동";
  const location = "서울";
  const bodyProps = {
    name: name,
    location: location,
    favoriteList: ["김치찌개", "비빔밥", "불고기"]
  }

  return <div className="App">
    <Header />
    <Body name={name} location={location} />
    {/* <Body name={name} location={location} favoriteList={bodyProps.favoriteList} /> */}
    <Body {...bodyProps} />

    <Footer />
  </div>;
}

export default App;