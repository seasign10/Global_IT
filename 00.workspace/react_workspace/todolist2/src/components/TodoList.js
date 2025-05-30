import { useState, useEffect } from "react";
import TodoItem from "./TodoItem";
import "./TodoList.css";

const TodoList = ({ todo=[], onUpdate, onDelete }) => {
  useEffect(() => {
    console.log(todo);
    if (todo.length === 0) {
      console.log("할 일이 없습니다.");
    }
  }, [todo]);

  const [search, setSearch] = useState(""); 
  const onChangeSearch = (e) => {
    setSearch(e.target.value);
  };

  const getSearchResult = () => {
    return search === ""
      ? todo
      : todo.filter((it) =>
          it.content.toLowerCase().includes(search.toLowerCase())
        );
  };

  return (
    <div className="TodoList">
      <h4>Todo List 🌱</h4>
      <input
        value={search}
        onChange={onChangeSearch}
        className="searchbar"
        placeholder="검색어를 입력하세요"
      />
      <div className="list_wrapper">
        {getSearchResult().map((it) => (
          <TodoItem
            key={it.id}
            {...it}
            onUpdate={onUpdate}
            onDelete={onDelete}
          />
        ))}
      </div>
    </div>
  );
};

export default TodoList;