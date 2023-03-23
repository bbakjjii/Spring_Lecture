package com.ezen.springrest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// -- 2 --
@AllArgsConstructor // -- 15 --
@NoArgsConstructor // -- 15 --
@Data
public class Pizza {
	private String name;
	private Integer price;
	private Double calories;

}
