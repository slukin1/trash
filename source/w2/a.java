package w2;

import android.text.Html;
import android.util.Pair;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huochat.community.network.domain.DomainTool;
import com.huochat.community.util.FileTool;
import com.iproov.sdk.bridge.OptionsBridge;
import com.xiaomi.mipush.sdk.Constants;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, Boolean> f16737a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static Pattern f16738b = Pattern.compile("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<String, Boolean> f16739c = new HashMap<>();

    /* renamed from: w2.a$a  reason: collision with other inner class name */
    public static class C0108a implements Comparator<Pair<String, Integer>> {
        /* renamed from: a */
        public int compare(Pair<String, Integer> pair, Pair<String, Integer> pair2) {
            return ((Integer) pair.second).intValue() - ((Integer) pair2.second).intValue();
        }
    }

    public static int a(int i11, String str) {
        if (i11 > 0) {
            return i11;
        }
        if (str.equals(DomainTool.DOMAIN_PREFIX_HTTP)) {
            return 80;
        }
        return PsExtractor.SYSTEM_HEADER_START_CODE;
    }

    public static String b(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < iArr.length; i11++) {
            if (i11 != 0) {
                sb2.append(",&#");
            }
            sb2.append(iArr[i11]);
        }
        return sb2.toString();
    }

    public static String c(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < strArr.length; i11++) {
            if (i11 != 0) {
                sb2.append(",&#");
            }
            sb2.append(strArr[i11]);
        }
        return sb2.toString();
    }

    public static Map<String, String> d(String str) {
        if (str == null || str.isEmpty()) {
            return b.f16742c;
        }
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(Html.fromHtml(Html.fromHtml(str).toString()).toString());
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.get(next) == null ? null : jSONObject.get(next).toString());
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return hashMap;
    }

    public static boolean e(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return m(str, str2);
    }

    public static boolean f(String[] strArr, int[] iArr, String[] strArr2, int[] iArr2) {
        return Arrays.equals(strArr, strArr2) && Arrays.equals(iArr, iArr2);
    }

    public static String[] g(String[] strArr, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < strArr.length; i11++) {
            arrayList.add(new Pair(strArr[i11], Integer.valueOf(iArr[i11])));
        }
        Collections.sort(arrayList, new C0108a());
        String[] strArr2 = new String[arrayList.size()];
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            strArr2[i12] = (String) ((Pair) arrayList.get(i12)).first;
        }
        return strArr2;
    }

    public static String h(String str) {
        return str == null ? "" : str;
    }

    public static String i(Map<String, String> map) {
        if (map == null) {
            return OptionsBridge.NULL_VALUE;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        for (Map.Entry next : map.entrySet()) {
            sb2.append((String) next.getKey());
            sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb2.append((String) next.getValue());
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        sb2.append("]");
        return sb2.toString();
    }

    public static int[] j(String str) {
        int[] l11 = l(str);
        return (l11 == null || l11.length == 0) ? b.f16740a : l11;
    }

    public static String[] k(String str) {
        if (str == null) {
            return null;
        }
        return str.equals("") ? new String[0] : str.split(",&#");
    }

    public static int[] l(String str) {
        if (str == null) {
            return null;
        }
        int i11 = 0;
        if (str.equals("")) {
            return new int[0];
        }
        String[] split = str.split(",&#");
        int[] iArr = new int[split.length];
        while (i11 < split.length) {
            try {
                iArr[i11] = Integer.parseInt(split[i11]);
                i11++;
            } catch (Throwable unused) {
                return null;
            }
        }
        return iArr;
    }

    public static boolean m(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean n(String str) {
        Boolean bool = f16737a.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(o(str));
        f16737a.put(str, valueOf);
        return valueOf.booleanValue();
    }

    public static boolean o(String str) {
        if (str != null) {
            try {
                char[] charArray = str.toCharArray();
                if (charArray.length > 0) {
                    if (charArray.length <= 255) {
                        for (char c11 : charArray) {
                            if ((c11 < 'A' || c11 > 'Z') && ((c11 < 'a' || c11 > 'z') && ((c11 < '0' || c11 > '9') && c11 != '.' && c11 != '-'))) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return false;
    }

    public static String p(String str) {
        MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5);
        instance.update(str.getBytes());
        byte[] digest = instance.digest();
        StringBuilder sb2 = new StringBuilder();
        for (byte b11 : digest) {
            String hexString = Integer.toHexString(b11 & 255);
            while (hexString.length() < 2) {
                hexString = "0" + hexString;
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    public static boolean q(String str) {
        Boolean bool = f16739c.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(str != null && str.length() >= 7 && str.length() <= 15 && !str.equals("") && f16738b.matcher(str).matches());
        f16739c.put(str, valueOf);
        return valueOf.booleanValue();
    }

    public static String r(Object obj) {
        return obj == null ? OptionsBridge.NULL_VALUE : obj.toString();
    }
}
