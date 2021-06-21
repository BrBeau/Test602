package com.beau.ui;

import com.beau.func.RecodeApk;
import com.beau.func.SignApk;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * 获取签名路径
 *
 * @author Byron
 * @date 210618
 */
public class SignPathFile extends JTextField implements DropTargetListener {

    private String TAG = SignPathFile.class.getSimpleName();
    private SignApk signApk;

    public SignPathFile(String hint){
        this.setText(hint);
        new DropTarget(this, DnDConstants.ACTION_COPY_OR_MOVE, this);
        signApk = SignApk.getInstance();
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

                Iterator iterator = list.iterator();
                while (iterator.hasNext()){
                    File file = (File) iterator.next();
                    this.setText(file.getAbsolutePath());
                    System.out.println(TAG + " 签名路径获取成功： " + file.getAbsolutePath());
                    signApk.getSignPathSuccess(file.getAbsolutePath());
                }
            } catch (UnsupportedFlavorException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            dtde.rejectDrop();
            System.out.println(TAG + " 签名文件获取失败");
        }

    }
}
