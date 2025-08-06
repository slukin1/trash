package com.huobi.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class f1 {
    public static String a(String str, String str2) {
        String str3 = str2 + ".zip";
        List<File> b11 = b(new File(str));
        byte[] bArr = new byte[512];
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new CheckedOutputStream(new FileOutputStream(str3), new CRC32()));
            for (File next : b11) {
                if (next.isFile()) {
                    ZipEntry zipEntry = new ZipEntry(c(str, next));
                    zipEntry.setSize(next.length());
                    zipEntry.setTime(next.lastModified());
                    zipOutputStream.putNextEntry(zipEntry);
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(next));
                    while (true) {
                        int read = bufferedInputStream.read(bArr, 0, 512);
                        if (read == -1) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, read);
                    }
                    bufferedInputStream.close();
                } else {
                    zipOutputStream.putNextEntry(new ZipEntry(c(str, next)));
                }
            }
            zipOutputStream.close();
        } catch (FileNotFoundException e11) {
            e11.printStackTrace();
        } catch (IOException e12) {
            e12.printStackTrace();
        }
        return str3;
    }

    public static List<File> b(File file) {
        ArrayList arrayList = new ArrayList();
        for (File file2 : file.listFiles()) {
            if (file2.isFile()) {
                arrayList.add(file2);
            } else if (file2.listFiles().length != 0) {
                arrayList.addAll(b(file2));
            } else {
                arrayList.add(file2);
            }
        }
        return arrayList;
    }

    public static String c(String str, File file) {
        File file2 = new File(str);
        String name = file.getName();
        while (true) {
            file = file.getParentFile();
            if (file != null && !file.equals(file2)) {
                name = file.getName() + "/" + name;
            }
        }
        return name;
    }
}
