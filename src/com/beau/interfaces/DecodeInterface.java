package com.beau.interfaces;

/**
 * 反编译接口
 *
 * @author Byron
 * @date 210622
 */
public interface DecodeInterface {

    /**
     * 反编译成功
     */
    void decodeSuccess();

    /**
     * 反编译失败
     */
    void decodeFailed(String decodeErrorInfo);
}
