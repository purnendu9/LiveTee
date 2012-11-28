package com.livetee.form1;

import android.app.Application;

public class CustomApplication extends Application {
	private FormData formData;

	public FormData getFormData() {
		return formData;
	}

	public void setFormData(FormData formData) {
		this.formData = formData;
	}

	public CustomApplication() {
		formData = new FormData();
		formData.clearFormData();
	}

}
