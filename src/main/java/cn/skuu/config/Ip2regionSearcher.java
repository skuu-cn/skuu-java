package cn.skuu.config;

import cn.skuu.pojo.dto.IpInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.lionsoul.ip2region.xdb.Searcher;
import org.springframework.beans.factory.DisposableBean;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author dcx
 * @since 2022-10-24 15:51
 **/
@Slf4j
public class Ip2regionSearcher implements DisposableBean {

    private static final Pattern SPLIT_PATTERN = Pattern.compile("\\|");

    private final Searcher searcher;

    public Ip2regionSearcher(Searcher searcher) {
        this.searcher = searcher;
    }

    public String searchStr(String ip) throws Exception {
        return searcher.search(ip);
    }

    public IpInfoDTO getIpInfo(String ip) {
        try {
            String regionStr = searchStr(ip);
            String[] splitInfos = regionStr.split("\\|");
            if (splitInfos.length < 5) {
                splitInfos = Arrays.copyOf(splitInfos, 5);
            }
            IpInfoDTO ipInfo = new IpInfoDTO();
            ipInfo.setCountry(filterZero(splitInfos[0]));
            ipInfo.setRegion(filterZero(splitInfos[1]));
            ipInfo.setProvince(filterZero(splitInfos[2]));
            ipInfo.setCity(filterZero(splitInfos[3]));
            ipInfo.setIsp(filterZero(splitInfos[4]));
            ipInfo.setIp(ip);
            return ipInfo;
        } catch (Exception e) {
            log.error("getIpInfo error,msg:{}", ip, e);
        }
        return null;
    }

    private String filterZero(String info) {
        // null 或 0 返回 null
        if (info == null || BigDecimal.ZERO.toString().equals(info)) {
            return null;
        }
        return info;
    }

    @Override
    public void destroy() throws Exception {
        if (this.searcher != null) {
            this.searcher.close();
        }
    }
}
