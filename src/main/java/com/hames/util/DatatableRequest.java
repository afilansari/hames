package com.hames.util;

public class DatatableRequest {
	
	private Integer iDisplayStart;
	private Integer iDisplayLength;
	private Integer iColumns;
	private String sSearch;
	private Boolean bRegex;
	private String sEcho;
	
	/**
	 * Hames defined fields
	 * @return
	 */
	private Class clazz;
	private String mongoCollectionName;
	
	public Integer getiDisplayStart() {
		return iDisplayStart;
	}
	public void setiDisplayStart(Integer iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}
	public Integer getiDisplayLength() {
		return iDisplayLength;
	}
	public void setiDisplayLength(Integer iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}
	public Integer getiColumns() {
		return iColumns;
	}
	public void setiColumns(Integer iColumns) {
		this.iColumns = iColumns;
	}
	public String getsSearch() {
		return sSearch;
	}
	public void setsSearch(String sSearch) {
		this.sSearch = sSearch;
	}
	public Boolean getbRegex() {
		return bRegex;
	}
	public void setbRegex(Boolean bRegex) {
		this.bRegex = bRegex;
	}
	public String getsEcho() {
		return sEcho;
	}
	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}
	public String getMongoCollectionName() {
		return mongoCollectionName;
	}
	public void setMongoCollectionName(String mongoCollectionName) {
		this.mongoCollectionName = mongoCollectionName;
	}
	public Class getClazz() {
		return clazz;
	}
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	@Override
	public String toString() {
		return "DatatableRequest [iDisplayStart=" + iDisplayStart
				+ ", iDisplayLength=" + iDisplayLength + ", iColumns="
				+ iColumns + ", sSearch=" + sSearch + ", bRegex=" + bRegex
				+ ", sEcho=" + sEcho + ", mongoCollectionName="
				+ mongoCollectionName + "]";
	}
	
	
}
