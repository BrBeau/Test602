package com.beau.util;

import com.beau.constant.Constant;
import com.beau.func.RecodeApk;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * android Manifest xml解析
 *
 * @author Byron
 * @date 210618
 */
public class ManifestUtil {

    private static ManifestUtil mInstance;
    private String TAG = ManifestUtil.class.getSimpleName();
    private Document document = null;
    private ManifestUtil(){}

    public static ManifestUtil getInstance(){

        if (mInstance == null){
            mInstance = new ManifestUtil();
            return mInstance;
        }
        return mInstance;
    }

    /**
     * 解析manifest
     * @param manifestPath manifest路径
     * @param newPackageName 新包名
     */
    public void parseXmL(String manifestPath, String newPackageName){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            //解析xml文件获得document对象，即DOM树
            document = documentBuilder.parse(manifestPath);
            //查找xml结点
            Node node = document.getFirstChild();
            NamedNodeMap namedNodeMap = node.getAttributes();
            for (int i=0; i< namedNodeMap.getLength(); i++){
                if (namedNodeMap.item(i).getNodeName() == Constant.PACKAGE_ATTR){
                    System.out.println(TAG + " 原始包名： " + namedNodeMap.item(i).getNodeValue() + " 新包名： " + newPackageName);
                    namedNodeMap.item(i).setNodeValue(newPackageName);
                    System.out.println(TAG + " 解析manifest完成");
                    safeManifest(manifestPath);
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存修改后的manifest
     * 存在则覆盖
     * @param manifestPath manifest路径
     */
    private void safeManifest(String manifestPath){

        TransformerFactory tf = TransformerFactory.newInstance();
        try {
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, Constant.UTF_8);

            DOMSource domSource = new DOMSource(document);
            //指定目标路径
            StreamResult streamResult = new StreamResult(new FileOutputStream(manifestPath));
            //使用transform进行文件保存
            transformer.transform(domSource, streamResult);
            System.out.println(TAG + " 保存新manifest完成");
            //todo: 执行回编译操作

            RecodeApk.getInstance().executeRecode();

        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] arg){
//        ManifestUtil.getInstance().parseXmL();
//    }

}
