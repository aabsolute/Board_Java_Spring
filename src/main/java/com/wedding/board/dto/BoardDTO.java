package com.wedding.board.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDTO {

	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	
	
}
