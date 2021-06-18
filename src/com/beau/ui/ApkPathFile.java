package com.beau.ui;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * 获取输入或者拖拽进入的文件路径
 *
 * @author Byron
 * @date 210618
 */
public class ApkPathFile extends JTextField implements DropTargetListener {

    public String TAG =  ApkPathFile.class.getSimpleName();
    public ApkPathFile(){
        new DropTarget(this, DnDConstants.ACTION_COPY_OR_MOVE, this);
    }

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {

    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {

    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {

    }

    @Override
    public void dragExit(DropTargetEvent dte) {

    }

    @Override
    public void drop(DropTargetDropEvent dtde) {

        if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)){
            dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);

            try {
                List list = (List) dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                Iterator it = list.iterator();

                while (it.hasNext()){
                    File file = (File) it.next();
                    this.setText(file.getAbsolutePath());
                    System.out.println(TAG + " apk路径获取成功： " + file.getAbsolutePath());
                }
            } catch (UnsupportedFlavorException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            dtde.rejectDrop();
            System.out.println(TAG + " apk路径获取失败");

        }

    }
}
