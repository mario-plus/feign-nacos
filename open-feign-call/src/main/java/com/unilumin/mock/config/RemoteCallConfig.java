package com.unilumin.mock.config;

/**
 * @author zxz
 * @date 2022年12月01日 16:22
 */

public class RemoteCallConfig {
    private String url;

    public RemoteCallConfig(String url, String path) {
        this.url = url;
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public String getPath() {
        return path;
    }

    private String path;

    private String resType;//请求方式

    private Object[] args;//请求参数
}
