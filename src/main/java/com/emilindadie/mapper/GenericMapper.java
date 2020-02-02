package com.emilindadie.mapper;

public interface GenericMapper<U,V> {
	V map(U dto);
}
