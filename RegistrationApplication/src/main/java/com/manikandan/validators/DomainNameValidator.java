package com.manikandan.validators;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class DomainNameValidator extends FieldValidatorSupport {
	
	private String domainName;

	@Override
	public void validate(Object obj) throws ValidationException {
		System.out.println("DomainNameValidator is invoked");
		
		String fieldName = getFieldName();
		String email = (String) getFieldValue(fieldName, obj);
		
		if (!email.endsWith(domainName)) {
			addFieldError(fieldName, obj);
		}
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

}
