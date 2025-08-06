package yl;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.NightHelper;
import tg.r;

public final class i {

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static i f76839a = new i();
    }

    public static i a() {
        return b.f76839a;
    }

    public static String c(String str) {
        String str2 = "_" + NightHelper.e().g() + "_" + AppLanguageHelper.getInstance().getCurLanguageHeader() + "_" + r.x().J();
        String str3 = "_" + AppLanguageHelper.getInstance().getCurLanguageHeader();
        if (TextUtils.equals(str, "SP_TAG_BANNER_211201")) {
            return "SP_TAG_BANNER_211201" + str3;
        } else if (TextUtils.equals(str, "SP_TAG_NOTICE_211201")) {
            return "SP_TAG_NOTICE_211201" + str3;
        } else if (TextUtils.equals(str, "SP_TAG_QUICK_211201")) {
            return "SP_TAG_QUICK_211201" + str2;
        } else if (TextUtils.equals(str, "SP_TAG_BIZ_211201")) {
            return "SP_TAG_BIZ_211201" + str2 + "_biz_version1";
        } else if (TextUtils.equals(str, "SP_TAG_EARN_211201")) {
            return "SP_TAG_EARN_211201" + str2;
        } else if (TextUtils.equals(str, "SP_TAG_INFORMATION_211201")) {
            return "SP_TAG_INFORMATION_211201" + str2;
        } else if (TextUtils.equals(str, "SP_TAG_INFORMATION_220618")) {
            return "SP_TAG_INFORMATION_220618" + str2;
        } else if (!TextUtils.equals(str, "SP_TAG_INVEST_AREA_211201")) {
            return null;
        } else {
            return "SP_TAG_INVEST_AREA_211201" + str2;
        }
    }

    public boolean b() {
        return TextUtils.isEmpty(SP.i(c("SP_TAG_QUICK_211201"), "")) && TextUtils.isEmpty(SP.i(c("SP_TAG_BIZ_211201"), "")) && TextUtils.isEmpty(SP.i(c("SP_TAG_EARN_211201"), "")) && TextUtils.isEmpty(SP.i(c("SP_TAG_INFORMATION_211201"), ""));
    }

    public i() {
    }
}
