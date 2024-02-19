package cn.skuu.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author dcx
 * @since 2024-02-19 22:03
 **/
@Data
public class IdDto {
    @NotBlank
    private String id;
}
