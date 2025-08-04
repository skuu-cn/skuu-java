package cn.skuu.util;

import cn.skuu.pojo.vo.FileTokenVo;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

/**
 * @author dcx
 * @since 2025-06-07 12:00
 **/
public class FileUtil {
    public static FileTokenVo fileToken(String key) {
        String accessKey = "SoAW7O_JcjLkhznSw8ga_ZblDBRopH8kWH6yGYfM";
        String secretKey = "0_xFmChz9YSgx-vQAkq6QN4isYUJKmH3VRlZ2afG";
        String bucketName = "skuu";
        Configuration cfg = new Configuration();
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(accessKey, secretKey);
        StringMap stringMap = new StringMap();
        stringMap.put("insertOnly",1);
        stringMap.put("forceInsertOnly",true);
        String token = auth.uploadToken(bucketName, key, 600L, stringMap);
//        String key = "file save key";
//        Response r = uploadManager.put("hello world".getBytes(), key, token);
        FileTokenVo fileTokenVo = new FileTokenVo();
        fileTokenVo.setToken(token);
        fileTokenVo.setKey(key);
        return fileTokenVo;
    }

    public static void main(String[] args) {
        FileTokenVo fileTokenVo = fileToken("blog/20200607/11/a");
        System.out.println(fileTokenVo);
    }
}
