import '../style/Body.css';
import { useState, useRef } from 'react'; // useState 훅

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

// function Body() {
//   // const state 생성
//   const [count, setCount] = useState(0); // count 상태와 setCount 함수 생성
//   // 변수와 satate의 차이점
//   // 변수는 변경되면 화면이 다시 렌더링되지 않지만, state는 변경되면 화면이 다시 렌더링됨 (바인딩)
// }

// function Body() {
//   // 객체형 state 생성
//   const [state, setState] = useState({
//     name: "홍길동",
//     location: "서울",
//     favoriteList: ["김치찌개", "비빔밥", "불고기"]
//   });

//   // 이벤트 핸들러 함수. state를 변경
//   const handleClick = (e) => {
//     console.log("현재 수정 대상 : ", e.target.name);
//     console.log("수정값 : ", e.target.value);
//     // setter를 사용해서 state를 변경. 전개구문 사용
//     setState({
//       ...state, // 기존 state를 유지하면서
//       [e.target.name]: e.target.value // 변경할 속성만 업데이트
//     });
//   };

//   return (
//     <div className='body'>
//       <h1>Welcome to My App</h1>
//       <p>This is a simple React application.</p>
//       <p>{state.name}은 {state.location}에 거주합니다.</p>
//       <br />
//       {state.favoriteList.length}개의 음식을 좋아합니다.
//       <br />
//       {/* input 요소에 onChange 이벤트 핸들러 추가 */}
//       <input type="text" name="name" value={state.name} onChange={handleClick} />
//       <br />
//       <input type="text" name="location" value={state.location} onChange={handleClick} />
//     </div>
//   );
  
// }

// Viewer 컴포넌트
// number props를 받음. 구조분해할당 사용
// function Viewer({number}) {
//   return <div>{number%2===0 ? <h3>짝수</h3>:<h3>홀수</h3>}</div>
// }

// function Body() {
//   // number state 생성. 구조분해할당 사용
//   const [number, setNumber] = useState(0);

//   const onIncrese = () => {
//     setNumber(number + 1); // number를 1 증가
//   };
//   const onDecrease = () => {
//     setNumber(number - 1); // number를 1 감소
//   };

//   return (
//     <div className='body'>
//       <h1>Welcome to My App</h1>
//       <p>This is a simple React application.</p>
//       <Viewer number={number} />
//       <button onClick={onIncrese}>증가</button>
//       <button onClick={onDecrease}>감소</button>
//       {/* ChildComp 컴포넌트 추가 */}
//       <ChildComp />
//     </div>
//   );
// }

function Body(){
  const [text, setText] = useState("");
  const textRef = useRef(); // input text를 가리킬 ref 생성

  const handleChange = (e) => {
    setText(e.target.value); // input의 value를 state에 저장
  };  

  const handleOnClick = () => {
    if(text.length<5){
      textRef.current.focus(); // input에 포커스 설정
      textRef.current.select(); // input의 내용을 선택
      alert("입력값은 5글자 이상이어야 합니다.");
    }else {
      alert(`입력값은 ${text} 입니다.`);
      setText(""); // 입력값 초기화
    }
  }

  return (
    <div className='body'>
      <input 
        type="text" 
        value={text} 
        onChange={handleChange} 
        ref={textRef} // input에 ref 연결
      />
      <button onClick={handleOnClick}>입력값 확인</button>
    </div>
  );
}

export default Body;