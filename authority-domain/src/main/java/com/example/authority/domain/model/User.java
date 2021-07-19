package com.example.authority.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "USERNAME"))
public class User implements java.io.Serializable {

	private Integer id;
	private String username;
	private String password;
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);

	public User() {
	}

	public User(String username, String password, Set<UserRole> userRoles) {
		this.username = username;
		this.password = password;
		this.userRoles = userRoles;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "USERNAME", unique = true, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

//	@ManyToMany
//	public  Set<Action> getActions;

}
