package com.board.model;

import java.util.Arrays;

public class Criteria {

	// 현재 페이지
	private int pageNum;

	// 한 페이지당 보여질 게시물 갯수
	private int amount;

	// 검색 키워드
	private String keyword;

	// 검색 타입
	private String type;

	// 검색 타입 배열
	private String[] typeArr;

	// MySQL은 쿼리문에 limit을 활용할 것이기 때문에 변수 추가
	// 스킬할 게시물 수 ( (pageNum-1) * amount)
	private int skip;

	// 기본 생성자 -> 기본 세팅 : pageNum = 1, amount = 10
	public Criteria() {
		this(1, 10);
		this.skip = 0;
	}

	// 생성자 -> 원하는 pageNum, 원하는 amount
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.skip = (pageNum - 1) * amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.skip = (pageNum - 1) * this.amount;

		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.skip = (pageNum - 1) * this.amount;

		this.amount = amount;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
		this.typeArr = type.split("");
		/* type변수에 데이터가 들어왔을 때 자동으로 배열 형식으로 변환하여
		 * typeArr변수에 저장될 수 있도록 setType 메서드 수정
		 * 배열로 변환하기 위해 String 타입의 데이터를 String 배열 타입 데이터로
		 * 변환해주는 split() 메서드 사용*/
	}

	public String[] getTypeArr() {
		return typeArr;
	}

	public void setTypeArr(String[] typeArr) {
		this.typeArr = typeArr;
	}

	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", keyword=" + keyword + ", type=" + type
				+ ", typeArr=" + Arrays.toString(typeArr) + ", skip=" + skip + "]";
	}

}
