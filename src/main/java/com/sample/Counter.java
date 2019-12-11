package com.sample;

public class Counter {
	public String name;
	public int count;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Counter(int cnt, String name) {
		System.out.println("creating new using overloaded constructor");
		this.count = cnt;
		this.name = name;
	}
}