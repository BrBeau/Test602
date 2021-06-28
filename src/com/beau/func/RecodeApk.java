package com.beau.func;

import com.beau.constant.Constant;
import com.beau.interfaces.ApkFilePathInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        BufferedReader br = null;
        try {
            Process process = runtime.exec(execRecodeCmd);
            br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }

            if (process.waitFor() == 0){
                System.out.println(TAG + " 回编译执行结束");
                //todo: 执行签名操作

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    public static void main(String[] arg){
        RecodeApk.getInstance().executeRecode();
    }


}
