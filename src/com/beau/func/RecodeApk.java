package com.beau.func;

import com.beau.constant.Constant;
import com.beau.interfaces.ApkFilePathInterface;

import java.io.IOException;

/**
 * 回编译类
 *
 * @author Byron
 * @date 210621
 */
public class RecodeApk implements ApkFilePathInterface {
    private String mApkPath;
    private static RecodeApk mInstance;
    private String TAG = RecodeApk.class.getSimpleName();
    private RecodeApk(){}

    public static RecodeApk getInstance(){
        if (mInstance == null){
            mInstance = new RecodeApk();
            return mInstance;
        }
        return mInstance;
    }


    @Override
    public void getApkFilePathSuccess(String apkPath) {
        if (apkPath.contains(".apk")){
            mApkPath = apkPath.replace(".apk", "");
            return;
        }
        mApkPath = apkPath;

    }

    @Override
    public void getApkFilePathFailed(String errorInfo) {

    }

    /**
     * 执行回编译命令
     */
    public void executeRecode(){
//        String mApkPath = "G:\\injectApk\\June\\04\\app-release";

        System.out.println(TAG + " apk文件路径： " + mApkPath);
        String execRecodeCmd = Constant.JAVA_CMD + Constant.JAR_PATH + Constant.B_CMD + mApkPath;
        System.out.println(TAG + " 回编译命令： " + execRecodeCmd);

        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec(execRecodeCmd);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] arg){
        RecodeApk.getInstance().executeRecode();
    }


}
