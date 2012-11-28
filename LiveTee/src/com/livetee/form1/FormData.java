package com.livetee.form1;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FormData {
	private String userID = "";
	private HashMap<String, LinkedHashMap<String, String>> allPageData = new HashMap<String, LinkedHashMap<String, String>>();
	private boolean existingForm = false;
	public String page2Answers = "";
	public String page3Answers = "";
	public String page4Answers = "";

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public boolean isExistingForm() {
		return existingForm;
	}

	public void setExistingForm(boolean existingForm) {
		this.existingForm = existingForm;
	}

	public HashMap<String, LinkedHashMap<String, String>> getAllPageData() {
		return allPageData;
	}

	public void setAllPageData(
			HashMap<String, LinkedHashMap<String, String>> allPageData) {
		this.allPageData = allPageData;
	}

	public void clearFormData() {
		allPageData.clear();
		page2Answers = "";
		page3Answers = "";
		page4Answers = "";
		existingForm = false;
	}

}
