package com.company;

import java.io.FileInputStream;

public class Helloworld {

    public static void main(String[] args) {
        System.out.println("Hellworld!!!!!");
        Helloworld hw = new Helloworld();
        try
        {
            String str3;

            StringBuffer stringBuffer = new StringBuffer();

            str3 = new String(Helloworld.b(hw.b("userconfig"), stringBuffer),"UTF-8");
            System.out.println("[*] done!!!!!");
            System.out.println(str3);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public byte[] b(String str) throws Exception {
        FileInputStream fileInputStream = null;
        if (str.length() > 128) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return bArr;
        } catch (Exception e) {
            throw new Exception("AndroidRMSMgr Get Data  Error:" + e.getMessage());
        } catch (Throwable th) {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }
    public static byte[] b(byte[] bArr, StringBuffer stringBuffer) {
        if (bArr == null) {
            stringBuffer.append("内容长度为空");
            return null;
        }
        int length = bArr.length;
        if (length <= 0) {
            stringBuffer.append("内容长度为空");
            return null;
        }
        if (length <= 4) {
            stringBuffer.append("changdubugou");
            return null;
        }
        byte[] bArr2 = new byte[(length - 4)];
        int i = 0;
        for (int i2 = 4; i2 < length; i2++) {
            i += ((char) bArr[i2]) & 255;
            bArr2[i2 - 4] = bArr[i2];
        }
        byte b = bArr[0];
        byte b2 = bArr[1];
        byte b3 = bArr[2];
        if (((bArr[3] & 255) | (b << 24) | ((b2 << 16) & 16777215) | ((b3 << 8) & 65535)) == i) {
            return a(bArr2);
        }
        stringBuffer.append("sss");
        return null;
    }

    public static byte[] a(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        byte charAt = (byte) "fileprotect".charAt(0);
        int i = 1;
        byte b = charAt;
        while (i < 11) {
            byte charAt2 = (byte) "fileprotect".charAt(i);
            i++;
            b = (byte) (charAt ^ charAt2);
            charAt = charAt2;
        }
        for (int i2 = 0; i2 < length; i2++) {
            bArr2[i2] = (byte) (bArr[i2] ^ b);
        }
        return bArr2;
    }

}
