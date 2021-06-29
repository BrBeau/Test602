package com.beau.func;

import com.beau.constant.Constant;
import com.beau.interfaces.ApkFilePathInterface;
import com.beau.interfaces.SignPathInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 将回编译后的apk进行签名
 * todo: jarsigner -verbose -keystore [keystore路径] -storepass [密钥] -signedjar [签名后的apk] [待签名的apk] [别名]
 * @author Byron
 * @date 210621
 */
public class SignApk implements SignPathInterface {
    private static String TAG = SignApk.class.getSimpleName();
    private static SignApk mInstance;
    private SignApk(){}
    private String mSignPath;

    public static SignApk getInstance(){
        if (mInstance == null){
            mInstance = new SignApk();
            return mInstance;
        }
        return mInstance;
    }

    /**
     * 执行签名命令
     * @param distApkPath 回编译后的apk路径  H:\\app-release\\dist\\app-release.apk
     */
    public void executeSign(String distApkPath){

        Runtime runtime = Runtime.getRuntime();

        String executeSign = Constant.SIGN_CMD + mSignPath + " " + Constant.STORE_PASS + Constant.MOBAD_PASS + Constant.SIGN_JAR + "H:\\signedOut.apk " + distApkPath + " " + Constant.MOBAD_ALIAS;
        System.out.println(TAG + " 签名命令： " + executeSign);
        BufferedReader br = null;
        try {
            Process process = runtime.exec(executeSign);
            br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }

            if (process.waitFor() == 0){
                System.out.println(TAG + "签名完成");
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

    @Override
    public void getSignPathSuccess(String signPath) {
        if (!signPath.contains(".keystore")){
            System.out.println("签名路径异常，请重新输入");
            return;
        }
        mSignPath = signPath;
    }

    @Override
    public void getSignPathFailed(String errorInfo) {

    }


    public static void main(String[] arg){
        SignApk.getInstance().executeSign("H:\\app-release" + Constant.DIST + "app-release.apk");
    }
}
