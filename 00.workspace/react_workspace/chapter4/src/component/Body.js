import '../style/Body.css';
import { useState } from 'react'; // useState 훅

// ChildComp 컴포넌트
function ChildComp() {
  return <div>child-component</div>;
}

// props로 구조분해할당해서 처리
// function Body({name, location, favoriteList=[]}) {
//   return (
//     <div className='body'>
//       <h1 style={{ backgroundColor: "red", color: "blue" }}>Welcome to My App</h1>
//       <p>This is a simple React application.</p>
//       <p>{name}은 {location}에 거주합니다.</p>
//       <br />
//       {favoriteList.length}개의 음식을 좋아합니다.
//     </div>
//   );
// } 

// function Body() {
//   return (
//     <div className='body'>{ChildComp()}</div>
//   );
// }

// function Body() {
//   //inner function
//   function handleClick(e) {
//     console.log(e);
//     console.log(e.target);  
//     alert("버튼이 클릭되었습니다!");

//     return (
//       <div>
//         <button name="A버튼" onClick={handleClick}>A버튼</button>
//       </div>
//     );
//   } 
// }

function Body() {
  // const state 생성
  const [count, setCount] = useState(0); // count 상태와 setCount 함수 생성
  // 변수와 satate의 차이점
  // 변수는 변경되면 화면이 다시 렌더링되지 않지만, state는 변경되면 화면이 다시 렌더링됨 (바인딩)
}

export default Body;