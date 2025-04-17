package com.naver.service;

public class Person {
	public String name; //field
	
	//method
	public void sleep() {
		System.out.println("잠을 잡니다.");
	}
	//생성자오버로딩
	public Person() {}; //기본생성자 (생성자를 추가하면 기본생성자를 제공하지 않기때문에 있어야 함)
	public Person(String name) { //생성자
		this.name=name; // 초기화
	}

}
