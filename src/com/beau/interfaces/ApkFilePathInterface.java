package com.beau.interfaces;

public interface ApkFilePathInterface {

    /**
     * 获取apk文件路径成功
     * @param apkPath apk文件路径
     */
    void getApkFilePathSuccess(String apkPath);

    /**
     * 获取apk文件路径失败
     * @param errorInfo 失败信息
     */
    void getApkFilePathFailed(String errorInfo);
}
