package com.beau.func;

import com.beau.constant.Constant;
import com.beau.util.FileUtil;

import java.io.IOException;

/**
 * 反编译apk
 *
 * @author Byron
 * @date 210618
 */
public class DecodeApk {

    public static String TAG = DecodeApk.class.getSimpleName();
    public static DecodeApk mInstance;
    private DecodeApk(){}

    public static DecodeApk getInstance() {
        if (mInstance == null){
            mInstance = new DecodeApk();
            return mInstance;
        }
        return mInstance;
    }

    /**
     * 执行反编译操作
     * @param apkPath apk文件路径
     */
    public void executeDecode(String apkPath){

        //apkPath路径包含.apk,需要去除后创建改文件夹
        String outPath = FileUtil.getInstance().createDecodeFile(apkPath);
        String execCmd = Constant.JAVA_CMD + Constant.JAR_PATH + Constant.D_F_CMD + apkPath + Constant.OUT_CMD + outPath;

        System.out.println(TAG + " 执行反编译命令： " + execCmd);
        Runtime runtime = Runtime.getRuntime();

        try {
            Process process = runtime.exec(execCmd);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] arg){
        DecodeApk.getInstance().executeDecode("G:\\injectApk\\June\\04\\app-release.apk");
    }
}
