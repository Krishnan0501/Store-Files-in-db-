package com.krishna.dao;

import java.io.InputStream;

public class Filedb {
	String name;
	InputStream filecontent;
	public Filedb() {
		super();
	}
	public Filedb(String name, InputStream filecontent) {
		super();
		this.name = name;
		this.filecontent = filecontent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public InputStream getFilecontent() {
		return filecontent;
	}
	public void setFilecontent(InputStream filecontent) {
		this.filecontent = filecontent;
	}

}
