package com.sathya.servlet;

import java.sql.Date;

public class Product {
	private int proId;
	private String proName;
	private double proPrice;
	private String proBrand;
	private String proMadeIn;
	private Date proManufactured;
	private Date proExpiry;
	private byte[] proImage;
	private byte[] proAudio;
	private byte[] proVideo;
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public double getProPrice() {
		return proPrice;
	}
	public void setProPrice(double proPrice) {
		this.proPrice = proPrice;
	}
	public String getProBrand() {
		return proBrand;
	}
	public void setProBrand(String proBrand) {
		this.proBrand = proBrand;
	}
	public String getProMadeIn() {
		return proMadeIn;
	}
	public void setProMadeIn(String proMadeIn) {
		this.proMadeIn = proMadeIn;
	}
	public Date getProManufactured() {
		return proManufactured;
	}
	public void setProManufactured(Date proManufactured) {
		this.proManufactured = proManufactured;
	}
	public Date getProExpiry() {
		return proExpiry;
	}
	public void setProExpiry(Date proExpiry) {
		this.proExpiry = proExpiry;
	}
	public byte[] getProImage() {
		return proImage;
	}
	public void setProImage(byte[] proImage) {
		this.proImage = proImage;
	}
	public byte[] getProAudio() {
		return proAudio;
	}
	public void setProAudio(byte[] proAudio) {
		this.proAudio = proAudio;
	}
	public byte[] getProVideo() {
		return proVideo;
	}
	public void setProVideo(byte[] proVideo) {
		this.proVideo = proVideo;
	}
	
}
	
	