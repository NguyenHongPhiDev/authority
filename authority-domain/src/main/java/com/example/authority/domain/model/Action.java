package com.example.authority.domain.model;
// Generated Aug 5, 2015 11:46:07 AM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "action")
public class Action implements java.io.Serializable {

	private Integer id;
	private String name;
	private String description;
	private Set<RoleAction> roleActions = new HashSet<RoleAction>(0);

	public Action() {
	}

	public Action(String name, Set<RoleAction> roleActions) {
		this.name = name;
		this.roleActions = roleActions;
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

	@Column(name = "NAME", length = 150)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "description", length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "action")
	public Set<RoleAction> getRoleActions() {
		return this.roleActions;
	}

	public void setRoleActions(Set<RoleAction> roleActions) {
		this.roleActions = roleActions;
	}

}
