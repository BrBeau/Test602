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

    //todo: java -jar *****apktool.jar b apkFilePath
    public static final String B_CMD = " b ";


    //todo: jarsigner -verbose -keystore [签名文件] -storepass [密钥] -signedjar [签名后的apk] [待签名的apk] [别名]
    public static final String SIGN_CMD = "jarsigner -verbose -keystore ";
    public static final String STORE_PASS = "-storepass ";
    public static final String SIGN_JAR = "-signedjar ";
    public static final String MOBAD_PASS = "leyogame123 ";
    public static final String MOBAD_ALIAS = "mobad.keystore";
    public static final String XB_PASS = "xb239sci ";
    public static final String XB_ALIAS = "xb2306lk";


    //<manifest>标签的package属性
    public static final String PACKAGE_ATTR = "package";
    public static final String UTF_8 = "UTF-8";
    public static final String DIST = "\\dist";
    public static final String ANDROID_MANIFEST_DIR = "\\AndroidManifest.xml";
    public static final String SIGN_OUT_APK_DIR = "\\signOut.apk";

    //apktool.yml
    public static String APK_TOOL_YML_FILE = "\\apktool.yml";
    public static String APKTOOL_YML_FIRST_LINE = "!!brut.androlib.meta.MetaInfo";
    public static String APK_FILE_NAME = "apkFileName";
}
