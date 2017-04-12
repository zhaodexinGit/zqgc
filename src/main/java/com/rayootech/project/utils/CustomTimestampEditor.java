package com.rayootech.project.utils;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import org.springframework.util.StringUtils;
import java.text.ParseException;
/**
 * 
 * <B>功能简述</B><br>
 * 日期转换
 * 
 * @date  2015年3月30日 上午11:50:08
 * @author    yongweif
 * @since     [project/v1.0]
 */
public class CustomTimestampEditor extends PropertyEditorSupport {

	private final SimpleDateFormat dateFormat;
	private final boolean allowEmpty;
	private final int exactDateLength;

	public CustomTimestampEditor(SimpleDateFormat dateFormat, boolean allowEmpty) {
		this.dateFormat = dateFormat;
		this.allowEmpty = allowEmpty;
		this.exactDateLength = -1;
	}

	public CustomTimestampEditor(SimpleDateFormat dateFormat, boolean allowEmpty, int exactDateLength) {
		this.dateFormat = dateFormat;
		this.allowEmpty = allowEmpty;
		this.exactDateLength = exactDateLength;
	}

	public void setAsText(String text) throws IllegalArgumentException {
		if ((this.allowEmpty) && (!(StringUtils.hasText(text)))) {
			setValue(null);
		} else {
			if ((text != null) && (this.exactDateLength >= 0) && (text.length() != this.exactDateLength)) {
				throw new IllegalArgumentException("Could not parse date: it is not exactly" + this.exactDateLength
						+ "characters long");
			}
			try {
				setValue(new Timestamp(this.dateFormat.parse(text).getTime()));
			} catch (ParseException ex) {
				throw new IllegalArgumentException("Could not parse date: " + ex.getMessage(), ex);
			}
		}
	}

	public String getAsText() {
		Timestamp value = (Timestamp) getValue();
		return ((value != null) ? this.dateFormat.format(value) : "");
	}
}