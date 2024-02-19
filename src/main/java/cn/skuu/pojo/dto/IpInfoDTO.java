package cn.skuu.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * ip信息
 *
 * @author dcx
 * @since 2022-10-24 16:08
 **/
@Data
public class IpInfoDTO {
    @NotBlank
    private String ip;
    private String country;
    private String region;
    private String province;
    private String city;
    private String isp;
}
