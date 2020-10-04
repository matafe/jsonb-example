package com.matafe.jsonbexample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

public class User {

	private Long id;

	@JsonbProperty("user-name")
	private String name;

	private boolean active;

	@JsonbDateFormat("yyyy-MM-dd")
	private LocalDate lastUpdateDate;

	@JsonbTransient
	private List<Role> roles = new ArrayList<>();

	public User(Long id, String name, boolean active, LocalDate lastUpdateDate) {
		super();
		this.id = id;
		this.name = name;
		this.active = active;
		this.lastUpdateDate = lastUpdateDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setLastUpdateDate(LocalDate lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isActive() {
		return active;
	}

	public LocalDate getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void addRole(Role role) {
		this.roles.add(role);
	}

	public List<Role> getRoles() {
		return Collections.unmodifiableList(roles);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", active=" + active + ", lastUpdateDate=" + lastUpdateDate + "]";
	}

}
