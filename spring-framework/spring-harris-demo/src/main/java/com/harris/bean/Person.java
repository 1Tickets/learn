package com.harris.bean;

/**
 * @author Harris
 * @version 1.0
 * @ClassName: spring
 * @Description:
 * @date 2022/1/16 20:46
 */
public class Person {

	private String name;

	private String nickName;

	private Integer age;

	private Integer sex;

	public Person(String name, String nickName, Integer age, Integer sex) {
		this.name = name;
		this.nickName = nickName;
		this.age = age;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", nickName='" + nickName + '\'' +
				", age=" + age +
				", sex=" + sex +
				'}';
	}
}
