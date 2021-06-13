package com.moralles.bookstore.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ValidationError extends StandartError {
	
	private List<FieldMessage> fieldErrors = new ArrayList<>();

	public void addError(String error, String message) {
		getFieldErrors().add(new FieldMessage(error, message));
	}

	public ValidationError(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
	}

	
}
