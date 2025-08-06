package com.luck.picture.lib.basic;

import android.content.Context;
import android.content.ContextWrapper;
import com.luck.picture.lib.language.PictureLanguageUtils;

public class PictureContextWrapper extends ContextWrapper {
    public PictureContextWrapper(Context context) {
        super(context);
    }

    public static ContextWrapper wrap(Context context, int i11, int i12) {
        if (i11 != -2) {
            PictureLanguageUtils.setAppLanguage(context, i11, i12);
        }
        return new PictureContextWrapper(context);
    }

    public Object getSystemService(String str) {
        if ("audio".equals(str)) {
            return getApplicationContext().getSystemService(str);
        }
        return super.getSystemService(str);
    }
}
