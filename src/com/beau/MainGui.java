package com.beau;


import com.beau.func.DecodeApk;
import com.beau.ui.ApkPathFile;
import com.beau.ui.SignPathFile;

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

        JLabel apkPathLabel = new JLabel("文件路径");
        apkPathLabel.setBounds(20, 20, 100, 30);
        ApkPathFile apkPathFile = new ApkPathFile();
        apkPathFile.setBounds(120, 20, 300, 30);
        apkPathFile.setText("拖拽或输入文件路径");

        JLabel packageLabel = new JLabel("输入包名");
        packageLabel.setBounds(20, 60, 100, 30);
        JTextField packageField = new JTextField("请输入包名");
        packageField.setBounds(120, 60, 300, 30);

        JLabel signLabel = new JLabel("签名路径");
        signLabel.setBounds(20, 100, 100, 30);
        SignPathFile signField = new SignPathFile("拖拽或输入签名路径");
        signField.setBounds(120, 100, 300, 30);


        JButton confirmBtn = new JButton("确定");
        confirmBtn.setBounds(200, 280, 80, 30);


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

                if (apkPathFile.getText() != null && packageField.getText() != null && signField.getText() != null){

                    DecodeApk.getInstance().executeDecode(apkPathFile.getText());
                } else{
                    System.out.println("请输入....");
                }

            }
        });


    }

    public static void main(String[] arg){
        new MainGui("MainGui");
    }
}
