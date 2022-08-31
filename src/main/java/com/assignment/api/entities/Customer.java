package com.assignment.api.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "CUSTOMER")
@Data
@EqualsAndHashCode(callSuper = false)
public class Customer extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SURNAME")
	private String Surname;
	
	@OneToMany(mappedBy = "customer")
	private List<Account> accounts = new ArrayList<>();

}
