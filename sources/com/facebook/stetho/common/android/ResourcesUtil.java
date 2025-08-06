package com.facebook.stetho.common.android;

import android.content.res.Resources;
import com.facebook.stetho.common.LogUtil;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;

public class ResourcesUtil {
    private ResourcesUtil() {
    }

    private static String getFallbackIdString(int i11) {
        return "#" + Integer.toHexString(i11);
    }

    public static String getIdString(Resources resources, int i11) throws Resources.NotFoundException {
        String str;
        if (resources == null) {
            return getFallbackIdString(i11);
        }
        String str2 = "";
        if (getResourcePackageId(i11) != 127) {
            str2 = resources.getResourcePackageName(i11);
            str = ":";
        } else {
            str = str2;
        }
        String resourceTypeName = resources.getResourceTypeName(i11);
        String resourceEntryName = resources.getResourceEntryName(i11);
        StringBuilder sb2 = new StringBuilder(str2.length() + 1 + str.length() + resourceTypeName.length() + 1 + resourceEntryName.length());
        sb2.append(TIMMentionEditText.TIM_MENTION_TAG);
        sb2.append(str2);
        sb2.append(str);
        sb2.append(resourceTypeName);
        sb2.append("/");
        sb2.append(resourceEntryName);
        return sb2.toString();
    }

    public static String getIdStringQuietly(Object obj, Resources resources, int i11) {
        try {
            return getIdString(resources, i11);
        } catch (Resources.NotFoundException unused) {
            String fallbackIdString = getFallbackIdString(i11);
            LogUtil.w("Unknown identifier encountered on " + obj + l.f34627b + fallbackIdString);
            return fallbackIdString;
        }
    }

    private static int getResourcePackageId(int i11) {
        return (i11 >>> 24) & 255;
    }
}
