package com.example.Ecommerce.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Builder
@Setter
@ToString
public class RequestDTO {

	private String itemId;
	private Long quantity;
}
