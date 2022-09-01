package com.assignment.api.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "TRANSACTION")
@Data
@ToString
@NoArgsConstructor
public class Transaction extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	
	@Column(name = "AMOUNT")
	private double amount;
	
	@Column(name = "DATE")
	private Date date;
	
	
	@Column(name = "DESCRIPTION")
	private String description;


	public Transaction(double amount, Date date, String description) {
		super();
		this.amount = amount;
		this.date = date;
		this.description = description;
	}
	
	

}
