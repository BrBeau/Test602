package com.beau.bean;

import java.util.Map;

/**
 * 反编译后的apktool.yml
 *
 * @author Byron
 * @date 210629
 */
public class YmlBean {

    private String apkFileName;
    private boolean compressionType;
    private Map<String, Object> doNotCompress;
    private boolean isFrameworkApk;
    private Map<String, Object> packageInfo;
    private Map<String, Object> sdkInfo;
    private boolean sharedLibrary;
    private boolean sparseResources;
    private Map<String, Object> unknownFiles;
    private Map<String, Object> usesFramework;
    private String version;
    private Map<String, Object> versionInfo;

    public String getApkFileName() {
        return apkFileName;
    }

    public void setApkFileName(String apkFileName) {
        this.apkFileName = apkFileName;
    }

    public boolean compressionType() {
        return compressionType;
    }

    public void compressionType(boolean compressionType) {
        this.compressionType = compressionType;
    }

    public Map<String, Object> getDoNotCompress() {
        return doNotCompress;
    }

    public void setDoNotCompress(Map<String, Object> doNotCompress) {
        this.doNotCompress = doNotCompress;
    }

    public boolean isFrameworkApk() {
        return isFrameworkApk;
    }

    public void setFrameworkApk(boolean frameworkApk) {
        isFrameworkApk = frameworkApk;
    }

    public Map<String, Object> getPackageInfo() {
        return packageInfo;
    }

    public void setPackageInfo(Map<String, Object> packageInfo) {
        this.packageInfo = packageInfo;
    }

    public Map<String, Object> getSdkInfo() {
        return sdkInfo;
    }

    public void setSdkInfo(Map<String, Object> sdkInfo) {
        this.sdkInfo = sdkInfo;
    }

    public boolean isSharedLibrary() {
        return sharedLibrary;
    }

    public void setSharedLibrary(boolean sharedLibrary) {
        this.sharedLibrary = sharedLibrary;
    }

    public boolean isSparseResources() {
        return sparseResources;
    }

    public void setSparseResources(boolean sparseResources) {
        this.sparseResources = sparseResources;
    }

    public Map<String, Object> getUnknownFiles() {
        return unknownFiles;
    }

    public void setUnknownFiles(Map<String, Object> unknownFiles) {
        this.unknownFiles = unknownFiles;
    }

    public Map<String, Object> getUsesFramework() {
        return usesFramework;
    }

    public void setUsesFramework(Map<String, Object> usesFramework) {
        this.usesFramework = usesFramework;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Map<String, Object> getVersionInfo() {
        return versionInfo;
    }

    public void setVersionInfo(Map<String, Object> versionInfo) {
        this.versionInfo = versionInfo;
    }

    @Override
    public String toString() {
        return "YmlBean{" +
                "apkFileName='" + apkFileName + '\'' +
                ", compressionType=" + compressionType +
                ", doNotCompress=" + doNotCompress +
                ", isFrameworkApk=" + isFrameworkApk +
                ", packageInfo=" + packageInfo +
                ", sdkInfo=" + sdkInfo +
                ", sharedLibrary=" + sharedLibrary +
                ", sparseResources=" + sparseResources +
                ", unknownFiles=" + unknownFiles +
                ", usesFramework=" + usesFramework +
                ", version='" + version + '\'' +
                ", versionInfo=" + versionInfo +
                '}';
    }

}
