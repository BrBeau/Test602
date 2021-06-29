package com.beau.util;

import com.beau.constant.Constant;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

/**
 * 解析apktool.yml文件
 *
 * @author Byron
 * @date 210629
 */
public class YmlUntil {
    private static YmlUntil mInstance;
    private static String TAG = YmlUntil.class.getSimpleName();
    private YmlUntil(){}

    public static YmlUntil getInstance(){
        if (mInstance == null){
            mInstance = new YmlUntil();
            return mInstance;
        }
        return mInstance;
    }

    /**
     * 获取回编译是的名字
     * @param ymlPath H:\app-release\apktool.yml
     * @return
     */
    public String getApkFileName(String ymlPath){
        String apkFileName;
        try {
            Map ymlMap = (Map) new Yaml().load(new FileInputStream(new File(ymlPath)));
            apkFileName = (String) ymlMap.get(Constant.APK_FILE_NAME);
            System.out.println(TAG + " apkFileName: " + apkFileName);
            return apkFileName;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] arg){
        System.out.println(YmlUntil.getInstance().getApkFileName("H:\\app-release\\apktool.yml"));
    }


}
