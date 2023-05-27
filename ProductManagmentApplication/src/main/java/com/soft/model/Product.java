package com.soft.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="product_details")
@SequenceGenerator(name="prodcut-seq",initialValue = 501,allocationSize = 1)
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "prodcut-seq" )
	private int pid;
	private String pname;
	private int pqty;
	private float price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int pid, String pname, int pqty, float price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pqty = pqty;
		this.price = price;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPqty() {
		return pqty;
	}
	public void setPqty(int pqty) {
		this.pqty = pqty;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	

}
