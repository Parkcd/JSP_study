package com.saeyan.dto;

public class ProductVO { // 상품 테이블의 정보를 자바에서 얻어오기전에 정보를 저장할 공간을 위한 준비과정.
	private Integer code; // 정수형 상품 code 정보 DB 타입이 number 인것은 integer로 선언
	private String name; // 책 이름 DB 타입이 varchar2 인것은 String 으로 선언
	private Integer price; // 책 가격 DB 타입이 number 인것은 integer로 선언
	private String description; // 부가 정보 DB 타입이 varchar2 인것은 String 으로 선언
	private String pictureUrl; // 사진 URL 정보 DB 타입이 varchar2 인것은 String 으로 선언
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
}
