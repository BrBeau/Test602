package com.beau.func;

import com.beau.constant.Constant;
import com.beau.interfaces.DecodeInterface;
import com.beau.util.FileUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
     * @param decodeInterface 反编译接口
     */
    public void executeDecode(String apkPath, DecodeInterface decodeInterface){

        //apkPath路径包含.apk,需要去除后创建改文件夹
        String outPath = FileUtil.getInstance().createDecodeFile(apkPath);
        String execCmd = Constant.JAVA_CMD + Constant.JAR_PATH + Constant.D_F_CMD + apkPath + Constant.OUT_CMD + outPath;

        System.out.println(TAG + " 执行反编译命令： " + execCmd);
        Runtime runtime = Runtime.getRuntime();
        BufferedReader bufferedReader = null;

        try {
            Process process = runtime.exec(execCmd);
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }

            if (process.waitFor() == 0){
                System.out.println(TAG + " 反编译执行结束");
                decodeInterface.decodeSuccess();
            }

        } catch (IOException e) {
            decodeInterface.decodeFailed(e.toString());
            e.printStackTrace();
        } catch (InterruptedException e) {
            decodeInterface.decodeFailed(e.toString());
            e.printStackTrace();
        } finally {
            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
