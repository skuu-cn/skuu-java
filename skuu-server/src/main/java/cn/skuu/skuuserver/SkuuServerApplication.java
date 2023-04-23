package cn.skuu.skuuserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"${yudao.info.base-package}.server", "${yudao.info.base-package}.module"})
public class SkuuServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkuuServerApplication.class, args);
    }

}
