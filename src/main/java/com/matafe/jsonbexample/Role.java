package com.matafe.jsonbexample;

import java.util.Objects;

import javax.json.bind.annotation.JsonbProperty;

public class Role {

	@JsonbProperty("user-name")
	private String name;

	public Role() {
	}

	public Role(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Role [name=" + name + "]";
	}

}
