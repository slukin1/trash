package com.huawei.hms.opendevice;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public abstract class m {
    public static void a(File file) throws IOException {
        if (!file.exists()) {
            if (file.getParentFile() == null) {
                HMSLog.e("StreamUtil", "parent file is null.");
                throw new IOException("parent file is null");
            } else if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
                HMSLog.e("StreamUtil", "make parent dirs failed.");
                throw new IOException("make parent dirs failed");
            } else if (!file.createNewFile()) {
                HMSLog.e("StreamUtil", "create file failed.");
                throw new IOException("create file failed");
            }
        }
    }

    public static String a(String str) {
        InputStreamReader inputStreamReader;
        File file = new File(str);
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
            try {
                BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb2.append(readLine);
                    } catch (FileNotFoundException unused) {
                        bufferedReader = bufferedReader2;
                        HMSLog.e("StreamUtil", "file not exist.");
                        IOUtils.closeQuietly((Reader) inputStreamReader);
                        IOUtils.closeQuietly((Reader) bufferedReader);
                        return sb2.toString();
                    } catch (IOException unused2) {
                        bufferedReader = bufferedReader2;
                        HMSLog.e("StreamUtil", "read value IOException.");
                        IOUtils.closeQuietly((Reader) inputStreamReader);
                        IOUtils.closeQuietly((Reader) bufferedReader);
                        return sb2.toString();
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        IOUtils.closeQuietly((Reader) inputStreamReader);
                        IOUtils.closeQuietly((Reader) bufferedReader);
                        throw th;
                    }
                }
                IOUtils.closeQuietly((Reader) inputStreamReader);
                IOUtils.closeQuietly((Reader) bufferedReader2);
            } catch (FileNotFoundException unused3) {
                HMSLog.e("StreamUtil", "file not exist.");
                IOUtils.closeQuietly((Reader) inputStreamReader);
                IOUtils.closeQuietly((Reader) bufferedReader);
                return sb2.toString();
            } catch (IOException unused4) {
                HMSLog.e("StreamUtil", "read value IOException.");
                IOUtils.closeQuietly((Reader) inputStreamReader);
                IOUtils.closeQuietly((Reader) bufferedReader);
                return sb2.toString();
            }
        } catch (FileNotFoundException unused5) {
            inputStreamReader = null;
            HMSLog.e("StreamUtil", "file not exist.");
            IOUtils.closeQuietly((Reader) inputStreamReader);
            IOUtils.closeQuietly((Reader) bufferedReader);
            return sb2.toString();
        } catch (IOException unused6) {
            inputStreamReader = null;
            HMSLog.e("StreamUtil", "read value IOException.");
            IOUtils.closeQuietly((Reader) inputStreamReader);
            IOUtils.closeQuietly((Reader) bufferedReader);
            return sb2.toString();
        } catch (Throwable th3) {
            th = th3;
            IOUtils.closeQuietly((Reader) inputStreamReader);
            IOUtils.closeQuietly((Reader) bufferedReader);
            throw th;
        }
        return sb2.toString();
    }
}
