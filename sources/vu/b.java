package vu;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huobi.woodpecker.utils.HexUtil;
import com.huobi.woodpecker.utils.MD5Util;
import com.huobi.woodpecker.utils.StringUtils;
import kv.c;
import kv.e;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f23407a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f23408b = "";

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f23407a)) {
            return f23407a;
        }
        if (context == null) {
            return "";
        }
        String c11 = c.c(context);
        if (StringUtils.b(c11) || "02:00:00:00:00:00".equalsIgnoreCase(c11)) {
            c11 = c.b(context);
            if (StringUtils.b(c11) || "9774d56d682e549c".equalsIgnoreCase(c11) || "0000000000000000".equalsIgnoreCase(c11)) {
                c11 = c.h();
                if (StringUtils.b(c11)) {
                    e.h("VHashGenerator", "The seed cannot be determined.");
                    return null;
                }
            }
        }
        String str = Build.BRAND;
        f23407a = HexUtil.b(MD5Util.b(HexUtil.b(MD5Util.b(c11)) + HexUtil.b(MD5Util.b(str))));
        e.e("VHashGenerator", "genVToken(seed=" + c11 + ", salt=" + str + ") =>" + f23407a);
        return f23407a;
    }

    public static String b(Context context) {
        if (!TextUtils.isEmpty(f23408b)) {
            return f23408b;
        }
        String a11 = a(context);
        if (TextUtils.isEmpty(a11)) {
            return "";
        }
        f23408b = HexUtil.b(MD5Util.b(a11));
        e.c("VHashGenerator", "getVHash vToken=" + a11 + ">>>vHash=" + f23408b);
        return f23408b;
    }
}
