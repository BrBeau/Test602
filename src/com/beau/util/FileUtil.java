package com.beau.util;

import java.io.File;

/**
 * 文件工具类
 *
 * @author Byron
 * @date 210618
 */
public class FileUtil {

    private static String TAG = FileUtil.class.getSimpleName();
    private static FileUtil mInstance;
    private FileUtil(){}

    public static FileUtil getInstance(){
        if (mInstance == null){
            return mInstance = new FileUtil();
        }
        return mInstance;
    }

    /**
     * 创建反编译文件夹
     * @param apkFilePath apk文件路径
     */
    public String createDecodeFile(String apkFilePath){
        String newApkFilePath;
        if (apkFilePath.contains(".apk")){
            newApkFilePath = apkFilePath.replace(".apk", "");
            System.out.println(TAG + " 生成反编译文件路径： " + newApkFilePath);
        } else {
            System.out.println("错误的apk文件路径");
            return null;
        }

        File apkFile = new File(newApkFilePath);
        if (apkFile.exists()){
            System.out.println("反编译文件夹已经存在");
            return apkFile.getAbsolutePath();
        }
        apkFile.mkdir();
        return apkFile.getAbsolutePath();
    }

    /**
     * 获取apktool文件的路径
     *
     * @return
     */
    public String getApkToolPath(){
        String apktoolPath = this.getClass().getClassLoader().getResource("tool/apktool.jar").getPath().substring(1);
        if (apktoolPath == null){
            System.out.println(TAG + " 获取apktool路径失败");
            return null;
        }
        System.out.println(TAG + " 获取apktool路径成功： " + apktoolPath);
        return apktoolPath;
    }


    public static void main(String[] arg){
//         FileUtil.getInstance().createDecodeFile("G:\\injectApk\\June\\04\\app-release.apk");
        FileUtil.getInstance().getApkToolPath();
    }

}
