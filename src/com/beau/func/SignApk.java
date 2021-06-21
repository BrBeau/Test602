package com.beau.func;

import com.beau.constant.Constant;
import com.beau.interfaces.ApkFilePathInterface;
import com.beau.interfaces.SignPathInterface;

import java.io.IOException;

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
     * @param distApkPath 回编译后的apk路径
     */
    public void executeSign(String distApkPath){
        Runtime runtime = Runtime.getRuntime();

        String executeSign = Constant.SIGN_CMD + mSignPath + " " + Constant.STORE_PASS + Constant.MOBAD_PASS + Constant.SIGN_JAR + "G:\\injectApk\\June\\04\\signedOut.apk " + distApkPath + " " + Constant.MOBAD_ALIAS;
        System.out.println(TAG + " 签名命令： " + executeSign);
        try {
            Process process = runtime.exec(executeSign);
        } catch (IOException e) {
            e.printStackTrace();
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
}
