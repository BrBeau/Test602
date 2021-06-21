package com.beau.interfaces;

public interface SignPathInterface {

    /**
     * 获取签名路径成功
     */
    void getSignPathSuccess(String signPath);

    /**
     * 获取签名路径失败
     */
    void getSignPathFailed(String errorInfo);
}
