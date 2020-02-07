package com.emilindadie.dto;

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
public class UserDto{
	private int id = 0;
    private String name = "";
    private String email = "";
    private String password = "";
    private String address = "";
}
