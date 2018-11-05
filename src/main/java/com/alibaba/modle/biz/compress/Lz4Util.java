package com.alibaba.modle.biz.compress;

import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;

public class Lz4Util {


    /**
     * @param srcByte 原始数据
     * @return 压缩后的数据
     */
    public static byte[] compressedByte(byte[] srcByte) {
        LZ4Factory factory = LZ4Factory.fastestInstance();
        LZ4Compressor compressor = factory.fastCompressor();
        return compressor.compress(srcByte);
    }



    public static byte[] decompressorByte(byte[] compressorByte, int srcLength) {
        LZ4Factory factory = LZ4Factory.fastestInstance();
        LZ4FastDecompressor decompressor = factory.fastDecompressor();
        return decompressor.decompress(compressorByte, srcLength);
    }


    public static void main(String[] args) {
        String s="hello,i am a girl!";
        byte[] bytes = compressedByte(s.getBytes());
        System.out.println(new String(decompressorByte(bytes,s.length())));
    }

}
