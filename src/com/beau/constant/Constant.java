package com.beau.constant;

import com.beau.util.FileUtil;

/**
 * 常量类
 *
 * @author Byron
 * @date 210618
 */
public class Constant {

    //todo: java -jar *****apktool.jar d -f apkFilePath -out decodeFilePath
    public static final String JAVA_CMD = "java -jar ";
    public static String JAR_PATH = FileUtil.getInstance().getApkToolPath();
    public static final  String D_F_CMD = " d -f ";
    public static final String OUT_CMD = " -o ";
}
