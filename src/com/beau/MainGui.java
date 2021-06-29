package com.beau;


import com.beau.constant.Constant;
import com.beau.func.DecodeApk;
import com.beau.interfaces.ApkFilePathInterface;
import com.beau.interfaces.DecodeInterface;
import com.beau.interfaces.SignPathInterface;
import com.beau.ui.ApkPathFile;
import com.beau.ui.SignPathFile;
import com.beau.util.FileUtil;
import com.beau.util.ManifestUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 程序的主界面
 *
 * @author Byron
 * @date 210618
 */
public class MainGui extends JFrame {

    private String TAG = MainGui.class.getSimpleName();
    private JLabel apkPathLabel,packageLabel,signLabel;
    private JButton confirmBtn;
    private ApkPathFile apkPathFile;
    private JTextField packageField;
    private SignPathFile signField;

    public MainGui(String title){
        super.setTitle(title);
        super.setSize(500,400);
        super.setLocation(500,300);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.initGui();
        super.setVisible(true);


    }

    /**
     * 加载界面
     */
    private void initGui(){

        apkPathLabel = new JLabel("文件路径");
        apkPathLabel.setBounds(20, 20, 100, 30);
        apkPathFile = new ApkPathFile();
        apkPathFile.setBounds(120, 20, 300, 30);
        apkPathFile.setText("拖拽或输入文件路径");

        packageLabel = new JLabel("输入包名");
        packageLabel.setBounds(20, 60, 100, 30);
        packageField = new JTextField("请输入包名");
        packageField.setBounds(120, 60, 300, 30);

        signLabel = new JLabel("签名路径");
        signLabel.setBounds(20, 100, 100, 30);
        signField = new SignPathFile("拖拽或输入签名路径");
        signField.setBounds(120, 100, 300, 30);


        confirmBtn = new JButton("确定");
        confirmBtn.setBounds(200, 280, 80, 30);
        confirmBtn.setEnabled(true);


        Container container = this.getContentPane();
        container.setLayout(null);

        container.add(apkPathLabel);
        container.add(apkPathFile);

        container.add(packageLabel);
        container.add(packageField);

        container.add(signLabel);
        container.add(signField);

        container.add(confirmBtn);



        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionCmd();

            }
        });
    }

    public void actionCmd(){

        if (apkPathFile.getText().contains(".apk")){
            if (packageField.getText().contains("com.")){
                if (signField.getText().contains(".keystore")){

                    new Thread(new Runnable() {

                        @Override
                        public void run() {

                            DecodeApk.getInstance().executeDecode(apkPathFile.getText(), new DecodeInterface() {

                                @Override
                                public void decodeSuccess() {

                                    String manifestPath = apkPathFile.getText().replace(".apk", "") + Constant.ANDROID_MANIFEST_DIR;
                                    String ymlPath = apkPathFile.getText().replace(".apk", "") + Constant.APK_TOOL_YML_FILE;
                                    //反编译完成，同时对yml文件进行修改
                                    FileUtil.getInstance().replaceYmlFirstLine(ymlPath);

                                    System.out.println(TAG + " 开始解析manifest： " + manifestPath);
                                    ManifestUtil.getInstance().parseXmL(manifestPath, packageField.getText());
                                }

                                @Override
                                public void decodeFailed(String decodeErrorInfo) {
                                    System.out.println(TAG + " 反编译执行失败： " + decodeErrorInfo);
                                    return;
                                }
                            });

                        }
                    }).start();


                } else {
                    System.out.println(TAG + " 请输入签名路径");

                }
            } else {
                System.out.println(TAG + " 请输入包名");
            }
        } else {
            System.out.println(TAG + " 请输入apk路径");
        }

    }

    public static void main(String[] arg){
        new MainGui("MainGui");
    }

}
