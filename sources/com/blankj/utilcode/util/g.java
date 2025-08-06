package com.blankj.utilcode.util;

import java.io.Closeable;
import java.io.IOException;

public final class g {
    public static void a(Closeable... closeableArr) {
        if (closeableArr != null) {
            for (Closeable closeable : closeableArr) {
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                }
            }
        }
    }
}
