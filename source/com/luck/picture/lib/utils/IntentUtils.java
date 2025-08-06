package com.luck.picture.lib.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import java.io.File;

public class IntentUtils {
    public static void startSystemPlayerVideo(Context context, String str) {
        Uri uri;
        Intent intent = new Intent("android.intent.action.VIEW");
        boolean z11 = PictureMimeType.isContent(str) || PictureMimeType.isHasHttp(str);
        if (SdkVersionUtils.isQ()) {
            uri = z11 ? Uri.parse(str) : Uri.fromFile(new File(str));
        } else if (!SdkVersionUtils.isMaxN()) {
            uri = z11 ? Uri.parse(str) : Uri.fromFile(new File(str));
        } else if (z11) {
            uri = Uri.parse(str);
        } else {
            uri = FileProvider.getUriForFile(context, context.getPackageName() + ".luckProvider", new File(str));
        }
        intent.addFlags(268468224);
        intent.addFlags(1);
        intent.setDataAndType(uri, SelectMimeType.SYSTEM_VIDEO);
        context.startActivity(intent);
    }
}
