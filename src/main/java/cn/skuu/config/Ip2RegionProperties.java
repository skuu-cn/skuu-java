package cn.skuu.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author dcx
 * @since 2022-10-24 15:49
 **/
@Data
@ConfigurationProperties(prefix = Ip2RegionProperties.PREFIX)
public class Ip2RegionProperties {

    public static final String PREFIX = "ip2region";

    /**
     * 是否开启自动配置
     */
    private boolean enabled = false;

    /**
     * db数据文件位置.
     * ClassPath目录下
     */
    private String dbFile = "data/ip2region.xdb";

}
