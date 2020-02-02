package com.emilindadie.validator;

public interface GenericValidator<T> {
	boolean isValid(T t);
}
