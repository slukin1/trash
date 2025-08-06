package com.tencent.liteav.extensions;

import android.content.res.AssetManager;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.util.LiteavLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AssetsUtils {
    public static boolean copyAssetFile(String str, String str2) {
        AssetManager applicationAssets = ContextUtils.getApplicationAssets();
        try {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            byte[] bArr = new byte[1024];
            InputStream open = applicationAssets.open(str);
            File file2 = new File(str2 + File.separator + str + ".tmp");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            while (true) {
                int read = open.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            open.close();
            fileOutputStream.close();
            if (file2.renameTo(new File(str2 + File.separator + str))) {
                return true;
            }
            file2.delete();
            return false;
        } catch (IOException e11) {
            LiteavLog.i("virtual-background", "copyAssetFile error: " + e11.getMessage());
            return false;
        }
    }

    public static boolean hasAssetFile(String str) {
        try {
            InputStream open = ContextUtils.getApplicationAssets().open(str);
            boolean z11 = open != null;
            open.close();
            return z11;
        } catch (IOException e11) {
            LiteavLog.i("virtual-background", "hasAssetFile error: " + e11.getMessage());
            return false;
        }
    }
}
