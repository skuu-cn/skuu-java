package cn.skuu.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author dcx
 * @since 2025-06-07 12:14
 **/
@Data
public class FileTokenDto {
    @NotBlank
    private String key;
}
