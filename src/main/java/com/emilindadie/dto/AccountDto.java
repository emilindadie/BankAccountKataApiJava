package com.emilindadie.dto;

import com.emilindadie.dto.UserDto.UserDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AccountDto {
	 	private String name = "";
	    private int solde = 0;
	    private UserDto user = new UserDto();
}
