package com.example.authority.domain.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CheckDto {
    List<String> Uncheck;
    List<String> Checked;
    String User_id;
}
