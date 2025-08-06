package com.geetest.core;

import android.util.Pair;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class a {
    public static Pair<Boolean, String> a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            Pair<Boolean, String> pair = new Pair<>(Boolean.TRUE, byteArrayOutputStream.toString());
            try {
                byteArrayOutputStream.close();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e12) {
                e12.printStackTrace();
            }
            return pair;
        } catch (IOException e13) {
            e13.printStackTrace();
            Pair<Boolean, String> pair2 = new Pair<>(Boolean.FALSE, e13.toString());
            try {
                byteArrayOutputStream.close();
            } catch (IOException e14) {
                e14.printStackTrace();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e15) {
                    e15.printStackTrace();
                }
            }
            return pair2;
        } catch (Exception e16) {
            e16.printStackTrace();
            Pair<Boolean, String> pair3 = new Pair<>(Boolean.FALSE, e16.toString());
            try {
                byteArrayOutputStream.close();
            } catch (IOException e17) {
                e17.printStackTrace();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
            }
            return pair3;
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e19) {
                e19.printStackTrace();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e21) {
                    e21.printStackTrace();
                }
            }
            throw th2;
        }
    }
}
