package com.appsflyer.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Process;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.Gravity;
import android.webkit.URLUtil;
import com.appsflyer.AFLogger;
import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
import com.huochat.community.network.domain.DomainTool;
import com.sumsub.sns.internal.core.common.n0;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

final class d {
    private static char AFInAppEventParameterName = '鐹';
    private static char AFInAppEventType = 'ਆ';
    private static char AFKeystoreWrapper = '턊';
    private static int AFVersionDeclaration = 0;
    private static int getLevel = 1;
    private static char valueOf = 'ᇘ';
    private static long values = 123364835749994368L;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String AFInAppEventParameterName(java.lang.String r11) {
        /*
            r0 = 0
            r1 = 1
            if (r11 == 0) goto L_0x0006
            r2 = r1
            goto L_0x0007
        L_0x0006:
            r2 = r0
        L_0x0007:
            r3 = 2
            if (r2 == r1) goto L_0x000b
            goto L_0x0018
        L_0x000b:
            int r2 = getLevel
            int r2 = r2 + 121
            int r4 = r2 % 128
            AFVersionDeclaration = r4
            int r2 = r2 % r3
            char[] r11 = r11.toCharArray()
        L_0x0018:
            char[] r11 = (char[]) r11
            int r2 = r11.length
            char[] r2 = new char[r2]
            char[] r4 = new char[r3]
            r5 = r0
        L_0x0020:
            int r6 = r11.length
            r7 = 93
            if (r5 >= r6) goto L_0x0027
            r6 = r7
            goto L_0x0029
        L_0x0027:
            r6 = 83
        L_0x0029:
            if (r6 == r7) goto L_0x0033
            char r11 = r2[r0]
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2, r1, r11)
            return r0
        L_0x0033:
            int r6 = AFVersionDeclaration
            int r6 = r6 + 99
            int r7 = r6 % 128
            getLevel = r7
            int r6 = r6 % r3
            char r6 = r11[r5]
            r4[r0] = r6
            int r6 = r5 + 1
            char r7 = r11[r6]
            r4[r1] = r7
            char r7 = AFKeystoreWrapper
            char r8 = AFInAppEventParameterName
            char r9 = valueOf
            char r10 = AFInAppEventType
            com.appsflyer.internal.by.AFInAppEventParameterName(r4, r7, r8, r9, r10)
            char r7 = r4[r0]
            r2[r5] = r7
            char r7 = r4[r1]
            r2[r6] = r7
            int r5 = r5 + 2
            goto L_0x0020
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.d.AFInAppEventParameterName(java.lang.String):java.lang.String");
    }

    private static String AFKeystoreWrapper(String str, Long l11) {
        long j11;
        if (!(str == null || l11 == null)) {
            int i11 = getLevel + 49;
            AFVersionDeclaration = i11 % 128;
            int i12 = i11 % 2;
            if (str.length() == 32) {
                StringBuilder sb2 = new StringBuilder(str);
                String obj = l11.toString();
                long j12 = 0;
                boolean z11 = false;
                int i13 = 0;
                int i14 = 0;
                while (true) {
                    char c11 = 13;
                    if (i13 >= obj.length()) {
                        break;
                    }
                    int i15 = getLevel + 85;
                    AFVersionDeclaration = i15 % 128;
                    if (i15 % 2 != 0) {
                        c11 = '4';
                    }
                    if (c11 != '4') {
                        i14 += Character.getNumericValue(obj.charAt(i13));
                        i13++;
                    } else {
                        i14 >>= Character.getNumericValue(obj.charAt(i13));
                        i13 += 49;
                    }
                }
                String hexString = Integer.toHexString(i14);
                sb2.replace(7, hexString.length() + 7, hexString);
                int i16 = 0;
                while (true) {
                    if (i16 >= sb2.length()) {
                        break;
                    }
                    j12 = j11 + ((long) Character.getNumericValue(sb2.charAt(i16)));
                    i16++;
                }
                while (true) {
                    if ((j11 > 100 ? (char) 28 : 24) == 24) {
                        break;
                    }
                    int i17 = getLevel + 13;
                    int i18 = i17 % 128;
                    AFVersionDeclaration = i18;
                    if (i17 % 2 != 0) {
                        j11 &= 100;
                    } else {
                        j11 %= 100;
                    }
                    int i19 = i18 + 3;
                    getLevel = i19 % 128;
                    int i21 = i19 % 2;
                }
                sb2.insert(23, (int) j11);
                if (j11 < 10) {
                    z11 = true;
                }
                if (z11) {
                    sb2.insert(23, AFInAppEventParameterName("큮?").intern());
                }
                return sb2.toString();
            }
        }
        return values("嗧䨅됯ṗ䡹뉢᲏䛡낍᪦䓢꽘ᥧ䍚굀ᜰ䇃ꯣᗘ羑ꧩᑇ縿꡵መ籫ꛏწ窢꒙ຢ祈ꍑ").intern();
    }

    private static boolean valueOf(String str) {
        int i11 = AFVersionDeclaration + 51;
        getLevel = i11 % 128;
        int i12 = i11 % 2;
        try {
            Class.forName(str);
            int i13 = AFVersionDeclaration + 79;
            getLevel = i13 % 128;
            int i14 = i13 % 2;
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static String values(Context context, long j11) {
        String str;
        String str2;
        String str3;
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        sb3.append((valueOf(AFInAppEventParameterName("閺ﱤ⭾?툗룹㮄?镣뛫煄깅猽嵵䑱柖㼜鉀煄깅猽嵵䑱柖㼜∩핁៭䝟燎卭瑕").intern()) ? values("師䆚") : AFInAppEventParameterName("큮?")).intern());
        StringBuilder sb5 = new StringBuilder();
        String packageName = context.getPackageName();
        String AFKeystoreWrapper2 = AFKeystoreWrapper(packageName);
        sb3.append(values("師䆚").intern());
        sb5.append(AFKeystoreWrapper2);
        if (values(context) == null) {
            sb3.append(AFInAppEventParameterName("큮?").intern());
            sb5.append(packageName);
        } else {
            sb3.append(values("師䆚").intern());
            sb5.append(packageName);
            int i11 = AFVersionDeclaration + 111;
            getLevel = i11 % 128;
            int i12 = i11 % 2;
        }
        String valueOf2 = valueOf(context);
        if (valueOf2 == null) {
            sb3.append(AFInAppEventParameterName("큮?").intern());
            sb5.append(packageName);
        } else {
            sb3.append(values("師䆚").intern());
            sb5.append(valueOf2);
        }
        sb5.append(values(context, packageName));
        sb2.append(sb5.toString());
        try {
            sb2.append(new SimpleDateFormat(values("ދᡲჯक़Ǖ㨚㊏⬀⏵將咊䴦䕌緇癷滈权鿈頜").intern(), Locale.US).format(new Date(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime)));
            sb2.append(j11);
            if (!(!valueOf(AFInAppEventParameterName("洰⊭⭾?툗룹㮄?թ㧀䕻錰䇷?噗ᬤ㸬㏡⅀?").intern()))) {
                int i13 = getLevel + 33;
                AFVersionDeclaration = i13 % 128;
                int i14 = i13 % 2;
                str = values("師䆚");
            } else {
                str = AFInAppEventParameterName("큮?");
            }
            sb4.append(str.intern());
            if (valueOf(values("룷꜖渀㔁ﰮ茼䨣ᄥ?齇♇둰筼ɣ즋邕埉ẍꖰ沢㎰𥉉臃").intern())) {
                int i15 = AFVersionDeclaration + 57;
                getLevel = i15 % 128;
                if ((i15 % 2 == 0 ? '0' : 0) == 0) {
                    str2 = values("師䆚").intern();
                    int i16 = getLevel + 21;
                    AFVersionDeclaration = i16 % 128;
                    int i17 = i16 % 2;
                } else {
                    values("師䆚").intern();
                    throw null;
                }
            } else {
                str2 = AFInAppEventParameterName("큮?").intern();
            }
            sb4.append(str2);
            if (valueOf(AFInAppEventParameterName("?⭾?툗룹㮄?թ㧀⋽䜪嗚ᵧ߂왴֙?죷").intern())) {
                int i18 = getLevel + 77;
                AFVersionDeclaration = i18 % 128;
                int i19 = i18 % 2;
                str3 = values("師䆚");
            } else {
                str3 = AFInAppEventParameterName("큮?");
            }
            sb4.append(str3.intern());
            sb4.append((valueOf(values("㧥☄氤뉋㺖䒷誧킆ᛣ崗挣ꤒ㕴箂").intern()) ? values("師䆚") : AFInAppEventParameterName("큮?")).intern());
            String AFInAppEventType2 = af.AFInAppEventType(af.values(sb2.toString()));
            String obj = sb3.toString();
            StringBuilder sb6 = new StringBuilder(AFInAppEventType2);
            sb6.setCharAt(17, Integer.toString(Integer.parseInt(obj, 2), 16).charAt(0));
            String obj2 = sb6.toString();
            String obj3 = sb4.toString();
            StringBuilder sb7 = new StringBuilder(obj2);
            sb7.setCharAt(27, Integer.toString(Integer.parseInt(obj3, 2), 16).charAt(0));
            return AFKeystoreWrapper(sb7.toString(), Long.valueOf(j11));
        } catch (PackageManager.NameNotFoundException unused) {
            return values("嗧䨅됯ṗ䡹뉢᲏䛡낍᪦䓢꽘ᥧ䍚굀ᜰ䇃ꯣᗘ羑ꧩᑇ縿꡵መ籫ꛏწ窢꒙ຢ祈ꍑ").intern();
        }
    }

    private static String valueOf(Context context) {
        PackageManager packageManager;
        String packageName;
        int i11 = getLevel + 41;
        AFVersionDeclaration = i11 % 128;
        if ((i11 % 2 != 0 ? n0.h.f32179b : ':') != ':') {
            try {
                packageManager = context.getPackageManager();
                packageName = context.getPackageName();
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        } else {
            packageManager = context.getPackageManager();
            packageName = context.getPackageName();
        }
        String str = packageManager.getPackageInfo(packageName, 0).packageName;
        int i12 = AFVersionDeclaration + 47;
        getLevel = i12 % 128;
        int i13 = i12 % 2;
        return str;
    }

    public static class e extends HashMap<String, Object> {
        private static int AFInAppEventParameterName = 0;
        private static int AFLogger$LogLevel = 1;
        private static char[] valueOf = {28, '9', '9', '9', 'O', 'e', 'h', 129, 260, 266, 271, 272, 253, 243, 264, 270, 261, 258, 243, HighLevelEncoder.LATCH_TO_TEXT, 263, 265, 'g', 209, 207, 205, 205, '2', 'J', '2', '4', '2', 'J', 'N', '5', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, '1', '0', '4', 'M', 'a', 'a', 'c', 'c', 's', HighLevelEncoder.LATCH_TO_BASE256, 233, 237, 234, HighLevelEncoder.LATCH_TO_BASE256, 232, 244, 255, 248, HighLevelEncoder.LATCH_TO_ANSIX12, HighLevelEncoder.LATCH_TO_TEXT, 247, 237, 228, 219, 241, 273, 271, 273, 270, 261, 234, 244, 276, 268, 271, 276, 270, HighLevelEncoder.LATCH_TO_ANSIX12, 236, 265, 271, 275, 270, 268, 266, ':', 'l', 'i', 'n', 'j', 'k', 'i', 'j', 't', 's', 'k', '<', 'X', '7', 166, 'g', 166, 'g', 167, 'f', 167, 'f', 156, 163, 151, 170, 158, 153, 'h', 'h'};
        private static long values = 3100330032987487916L;
        private final Context AFInAppEventType;
        private final Map<String, Object> AFKeystoreWrapper;

        /* renamed from: com.appsflyer.internal.d$e$d  reason: collision with other inner class name */
        public static class C0074d {
            public Boolean AFInAppEventParameterName;
            public final Boolean valueOf;
            public final String values;

            public C0074d() {
            }

            public static byte[] AFInAppEventType(byte[] bArr) throws Exception {
                for (int i11 = 0; i11 < bArr.length; i11++) {
                    bArr[i11] = (byte) (bArr[i11] ^ ((i11 % 2) + 42));
                }
                return bArr;
            }

            public static byte[] valueOf(String str) throws Exception {
                return str.getBytes();
            }

            public static String values(byte[] bArr) throws Exception {
                StringBuilder sb2 = new StringBuilder();
                for (byte hexString : bArr) {
                    String hexString2 = Integer.toHexString(hexString);
                    if (hexString2.length() == 1) {
                        hexString2 = "0".concat(hexString2);
                    }
                    sb2.append(hexString2);
                }
                return sb2.toString();
            }

            public C0074d(String str, Boolean bool) {
                this.values = str;
                this.valueOf = bool;
            }
        }

        public e(Map<String, Object> map, Context context) {
            this.AFKeystoreWrapper = map;
            this.AFInAppEventType = context;
            put(valueOf(), AFInAppEventParameterName());
        }

        private String AFInAppEventParameterName() {
            String str;
            int i11;
            try {
                String obj = this.AFKeystoreWrapper.get(AFInAppEventParameterName("薝ṹ藼ꂳ鎙덭輝缥ᦂ雳맚烨ᓞ鱋븉").intern()).toString();
                String obj2 = this.AFKeystoreWrapper.get(AFInAppEventParameterName(new int[]{7, 15, 157, 0}, "\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001", !URLUtil.isJavaScriptUrl("javascript:")).intern()).toString();
                String replaceAll = AFInAppEventParameterName(new int[]{22, 5, 157, 1}, "\u0001\u0000\u0000\u0001\u0001", !TextUtils.equals("", "")).intern().replaceAll(AFInAppEventParameterName("툮툃呱꺒펩쑣⢙").intern(), "");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(obj);
                sb2.append(obj2);
                sb2.append(replaceAll);
                String values2 = af.values(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("");
                sb3.append(values2.substring(0, 16));
                str = sb3.toString();
            } catch (Exception e11) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(AFInAppEventParameterName("꾊偓꿬层ⅳㆁ෩唹垦奛㬺嫩嫼厮㳿徝䁖䱲↓䕋䟒䤀⭈䫺䪢䏍⳼侠瀧籮ᇭ畋瞋礯᭕穌竗珓ᰎ羹怲沏ƴ散杼楱ଭ").intern());
                sb4.append(e11);
                AFLogger.AFInAppEventParameterName(sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                sb5.append(AFInAppEventParameterName(new int[]{27, 18, 0, 13}, "\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000", PhoneNumberUtils.isGlobalPhoneNumber("")).intern());
                str = sb5.toString();
            }
            try {
                Intent registerReceiver = this.AFInAppEventType.registerReceiver((BroadcastReceiver) null, new IntentFilter(AFInAppEventParameterName(new int[]{45, 37, 163, 0}, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0000\u0001", !TextUtils.isGraphic("")).intern()));
                int i12 = -2700;
                if ((registerReceiver != null ? 'a' : 'D') == 'a') {
                    int i13 = AFInAppEventParameterName + 17;
                    AFLogger$LogLevel = i13 % 128;
                    int i14 = i13 % 2;
                    i12 = registerReceiver.getIntExtra(AFInAppEventParameterName(new int[]{82, 11, 0, 0}, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001", !URLUtil.isJavaScriptUrl("javascript:")).intern(), -2700);
                }
                String str2 = this.AFInAppEventType.getApplicationInfo().nativeLibraryDir;
                if (str2 != null) {
                    int i15 = AFInAppEventParameterName + 107;
                    AFLogger$LogLevel = i15 % 128;
                    int i16 = i15 % 2;
                    if (str2.contains(AFInAppEventParameterName(new int[]{93, 3, 0, 3}, "\u0000\u0000\u0000", !URLUtil.isHttpUrl(DomainTool.DOMAIN_PREFIX_HTTP)).intern())) {
                        int i17 = AFLogger$LogLevel + 73;
                        AFInAppEventParameterName = i17 % 128;
                        if ((i17 % 2 != 0 ? 16 : '\"') != 16) {
                            i11 = 1;
                            int size = ((SensorManager) this.AFInAppEventType.getSystemService(AFInAppEventParameterName("妿ટ姌둖篔ۢ䒔磣ꌓ൸").intern())).getSensorList(-1).size();
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(AFInAppEventParameterName("涞淼颍㲲ⓔ").intern());
                            sb6.append(i12);
                            sb6.append(AFInAppEventParameterName("㓷印㓑ʵ脧").intern());
                            sb6.append(i11);
                            sb6.append(AFInAppEventParameterName("ᓹꮼᓟᕣ襺瑞").intern());
                            sb6.append(size);
                            sb6.append(AFInAppEventParameterName("⳰赻Ⳗ㎧鱤盬").intern());
                            sb6.append(this.AFKeystoreWrapper.size());
                            String obj3 = sb6.toString();
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append(str);
                            sb7.append(C0074d.values(C0074d.AFInAppEventType(C0074d.valueOf(obj3))));
                            return sb7.toString();
                        }
                    }
                }
                i11 = 0;
                int size2 = ((SensorManager) this.AFInAppEventType.getSystemService(AFInAppEventParameterName("妿ટ姌둖篔ۢ䒔磣ꌓ൸").intern())).getSensorList(-1).size();
                StringBuilder sb62 = new StringBuilder();
                sb62.append(AFInAppEventParameterName("涞淼颍㲲ⓔ").intern());
                sb62.append(i12);
                sb62.append(AFInAppEventParameterName("㓷印㓑ʵ脧").intern());
                sb62.append(i11);
                sb62.append(AFInAppEventParameterName("ᓹꮼᓟᕣ襺瑞").intern());
                sb62.append(size2);
                sb62.append(AFInAppEventParameterName("⳰赻Ⳗ㎧鱤盬").intern());
                sb62.append(this.AFKeystoreWrapper.size());
                String obj32 = sb62.toString();
                StringBuilder sb72 = new StringBuilder();
                sb72.append(str);
                sb72.append(C0074d.values(C0074d.AFInAppEventType(C0074d.valueOf(obj32))));
                return sb72.toString();
            } catch (Exception e12) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append(AFInAppEventParameterName("꾊偓꿬层ⅳㆁ෩唹垦奛㬺嫩嫼厮㳿徝䁖䱲↓䕋䟒䤀⭈䫺䪢䏍⳼侠瀧籮ᇭ畋瞋礯᭕穌竗珓ᰎ羹怲沏ƴ散杼楱ଭ").intern());
                sb8.append(e12);
                AFLogger.AFInAppEventParameterName(sb8.toString());
                StringBuilder sb9 = new StringBuilder();
                sb9.append(str);
                sb9.append(AFInAppEventParameterName(new int[]{96, 16, 54, 9}, (String) null, !Gravity.isHorizontal(0)).intern());
                return sb9.toString();
            }
        }

        private static StringBuilder valueOf(String... strArr) throws Exception {
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            while (true) {
                if (i11 >= 3) {
                    break;
                }
                int i12 = AFLogger$LogLevel + 19;
                AFInAppEventParameterName = i12 % 128;
                if ((i12 % 2 != 0 ? '<' : ')') != '<') {
                    arrayList.add(Integer.valueOf(strArr[i11].length()));
                    i11++;
                } else {
                    arrayList.add(Integer.valueOf(strArr[i11].length()));
                    i11 += 0;
                }
            }
            Collections.sort(arrayList);
            int intValue = ((Integer) arrayList.get(0)).intValue();
            StringBuilder sb2 = new StringBuilder();
            int i13 = 0;
            while (i13 < intValue) {
                int i14 = AFLogger$LogLevel + 75;
                AFInAppEventParameterName = i14 % 128;
                int i15 = i14 % 2;
                Integer num = null;
                for (int i16 = 0; i16 < 3; i16++) {
                    int i17 = AFLogger$LogLevel + 31;
                    AFInAppEventParameterName = i17 % 128;
                    int i18 = i17 % 2;
                    char charAt = strArr[i16].charAt(i13);
                    if ((num == null ? 'U' : '8') != 'U') {
                        charAt ^= num.intValue();
                    }
                    num = Integer.valueOf(charAt);
                }
                sb2.append(Integer.toHexString(num.intValue()));
                i13++;
                int i19 = AFLogger$LogLevel + 1;
                AFInAppEventParameterName = i19 % 128;
                int i21 = i19 % 2;
            }
            return sb2;
        }

        private String valueOf() {
            int i11 = AFLogger$LogLevel + 49;
            AFInAppEventParameterName = i11 % 128;
            int i12 = i11 % 2;
            try {
                String num = Integer.toString(Build.VERSION.SDK_INT);
                String obj = this.AFKeystoreWrapper.get(AFInAppEventParameterName("薝ṹ藼ꂳ鎙덭輝缥ᦂ雳맚烨ᓞ鱋븉").intern()).toString();
                String obj2 = this.AFKeystoreWrapper.get(AFInAppEventParameterName("羹毌翛픒࠻甂ឞ⯴蔏").intern()).toString();
                if ((obj2 == null ? 27 : '%') != '%') {
                    int i13 = AFLogger$LogLevel + 81;
                    AFInAppEventParameterName = i13 % 128;
                    int i14 = i13 % 2;
                    obj2 = AFInAppEventParameterName("墧꺥壩၆❫婬矶䮰ꈋ꥛∪絀").intern();
                }
                StringBuilder sb2 = new StringBuilder(obj);
                sb2.reverse();
                StringBuilder valueOf2 = valueOf(num, obj2, sb2.toString());
                int length = valueOf2.length();
                if (length > 4) {
                    valueOf2.delete(4, length);
                } else {
                    while (true) {
                        if ((length < 4 ? 12 : '9') != 12) {
                            break;
                        }
                        length++;
                        valueOf2.append('1');
                    }
                }
                valueOf2.insert(0, AFInAppEventParameterName("骭髆忼㴛䀥䧐").intern());
                return valueOf2.toString();
            } catch (Exception e11) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(AFInAppEventParameterName("㘷栢㙑훯᥄摵쪏첄濗ᱝ쀴썔抍ᚨ쟱옠砧ॴ򷓶羣ఆ큆퍇狓ۖퟶ혈䠃㥺俻㱽䊠㛈塚⦒諾ﲋ彃").intern());
                sb3.append(e11);
                AFLogger.AFInAppEventParameterName(sb3.toString());
                return AFInAppEventParameterName(new int[]{0, 7, 0, 7}, "\u0001\u0000\u0000\u0000\u0001\u0001\u0000", Process.supportsProcesses()).intern();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: char[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: java.lang.String} */
        /* JADX WARNING: Failed to insert additional move for type inference */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.lang.String AFInAppEventParameterName(java.lang.String r11) {
            /*
                r0 = 0
                r1 = 1
                if (r11 == 0) goto L_0x0006
                r2 = r0
                goto L_0x0007
            L_0x0006:
                r2 = r1
            L_0x0007:
                if (r2 == 0) goto L_0x000a
                goto L_0x0018
            L_0x000a:
                int r2 = AFLogger$LogLevel
                int r2 = r2 + 3
                int r3 = r2 % 128
                AFInAppEventParameterName = r3
                int r2 = r2 % 2
                char[] r11 = r11.toCharArray()
            L_0x0018:
                char[] r11 = (char[]) r11
                long r2 = values
                char[] r11 = com.appsflyer.internal.bz.valueOf(r2, r11)
                r2 = 4
                r3 = r2
            L_0x0022:
                int r4 = r11.length
                if (r3 >= r4) goto L_0x0027
                r4 = r1
                goto L_0x0028
            L_0x0027:
                r4 = r0
            L_0x0028:
                if (r4 == r1) goto L_0x004a
                java.lang.String r0 = new java.lang.String
                int r1 = r11.length
                int r1 = r1 - r2
                r0.<init>(r11, r2, r1)
                int r11 = AFInAppEventParameterName
                int r11 = r11 + 19
                int r1 = r11 % 128
                AFLogger$LogLevel = r1
                int r11 = r11 % 2
                r1 = 55
                if (r11 != 0) goto L_0x0042
                r11 = 33
                goto L_0x0043
            L_0x0042:
                r11 = r1
            L_0x0043:
                if (r11 != r1) goto L_0x0046
                return r0
            L_0x0046:
                r11 = 0
                throw r11     // Catch:{ all -> 0x0048 }
            L_0x0048:
                r11 = move-exception
                throw r11
            L_0x004a:
                int r4 = AFLogger$LogLevel
                int r4 = r4 + 39
                int r5 = r4 % 128
                AFInAppEventParameterName = r5
                int r4 = r4 % 2
                int r4 = r3 + -4
                char r5 = r11[r3]
                int r6 = r3 % 4
                char r6 = r11[r6]
                r5 = r5 ^ r6
                long r5 = (long) r5
                long r7 = (long) r4
                long r9 = values
                long r7 = r7 * r9
                long r4 = r5 ^ r7
                int r4 = (int) r4
                char r4 = (char) r4
                r11[r3] = r4
                int r3 = r3 + 1
                goto L_0x0022
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.d.e.AFInAppEventParameterName(java.lang.String):java.lang.String");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v21, resolved type: byte[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v22, resolved type: java.lang.String} */
        /* JADX WARNING: Failed to insert additional move for type inference */
        /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r9v2, types: [char] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.lang.String AFInAppEventParameterName(int[] r12, java.lang.String r13, boolean r14) {
            /*
                r0 = 1
                r1 = 0
                if (r13 == 0) goto L_0x0006
                r2 = r1
                goto L_0x0007
            L_0x0006:
                r2 = r0
            L_0x0007:
                if (r2 == r0) goto L_0x000f
                java.lang.String r2 = "ISO-8859-1"
                byte[] r13 = r13.getBytes(r2)
            L_0x000f:
                byte[] r13 = (byte[]) r13
                r2 = r12[r1]
                r3 = r12[r0]
                r4 = 2
                r5 = r12[r4]
                r6 = 3
                r6 = r12[r6]
                char[] r7 = valueOf
                char[] r8 = new char[r3]
                java.lang.System.arraycopy(r7, r2, r8, r1, r3)
                if (r13 == 0) goto L_0x004c
                char[] r2 = new char[r3]
                r7 = r1
                r9 = r7
            L_0x0028:
                if (r7 >= r3) goto L_0x004b
                byte r10 = r13[r7]
                r11 = 20
                if (r10 != r0) goto L_0x0033
                r10 = 98
                goto L_0x0034
            L_0x0033:
                r10 = r11
            L_0x0034:
                if (r10 == r11) goto L_0x003f
                char r10 = r8[r7]
                int r10 = r10 << r0
                int r10 = r10 + r0
                int r10 = r10 - r9
                char r9 = (char) r10
                r2[r7] = r9
                goto L_0x0046
            L_0x003f:
                char r10 = r8[r7]
                int r10 = r10 << r0
                int r10 = r10 - r9
                char r9 = (char) r10
                r2[r7] = r9
            L_0x0046:
                char r9 = r2[r7]
                int r7 = r7 + 1
                goto L_0x0028
            L_0x004b:
                r8 = r2
            L_0x004c:
                if (r6 <= 0) goto L_0x0050
                r13 = r0
                goto L_0x0051
            L_0x0050:
                r13 = r1
            L_0x0051:
                if (r13 == 0) goto L_0x007b
                int r13 = AFInAppEventParameterName
                int r13 = r13 + 125
                int r2 = r13 % 128
                AFLogger$LogLevel = r2
                int r13 = r13 % r4
                if (r13 != 0) goto L_0x006e
                char[] r13 = new char[r3]
                java.lang.System.arraycopy(r8, r1, r13, r1, r3)
                int r2 = r3 >>> r6
                java.lang.System.arraycopy(r13, r0, r8, r2, r6)
                int r2 = r3 << r6
                java.lang.System.arraycopy(r13, r6, r8, r0, r2)
                goto L_0x007b
            L_0x006e:
                char[] r13 = new char[r3]
                java.lang.System.arraycopy(r8, r1, r13, r1, r3)
                int r2 = r3 - r6
                java.lang.System.arraycopy(r13, r1, r8, r2, r6)
                java.lang.System.arraycopy(r13, r6, r8, r1, r2)
            L_0x007b:
                if (r14 == 0) goto L_0x008d
                char[] r13 = new char[r3]
                r14 = r1
            L_0x0080:
                if (r14 >= r3) goto L_0x008c
                int r2 = r3 - r14
                int r2 = r2 - r0
                char r2 = r8[r2]
                r13[r14] = r2
                int r14 = r14 + 1
                goto L_0x0080
            L_0x008c:
                r8 = r13
            L_0x008d:
                if (r5 <= 0) goto L_0x0090
                goto L_0x0091
            L_0x0090:
                r0 = r1
            L_0x0091:
                if (r0 == 0) goto L_0x00ad
                int r13 = AFInAppEventParameterName
                int r13 = r13 + 65
            L_0x0097:
                int r14 = r13 % 128
                AFLogger$LogLevel = r14
                int r13 = r13 % r4
                if (r1 >= r3) goto L_0x00ad
                char r13 = r8[r1]
                r14 = r12[r4]
                int r13 = r13 - r14
                char r13 = (char) r13
                r8[r1] = r13
                int r1 = r1 + 1
                int r13 = AFInAppEventParameterName
                int r13 = r13 + 7
                goto L_0x0097
            L_0x00ad:
                java.lang.String r12 = new java.lang.String
                r12.<init>(r8)
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.d.e.AFInAppEventParameterName(int[], java.lang.String, boolean):java.lang.String");
        }
    }

    private static String AFKeystoreWrapper(String str) {
        boolean z11 = false;
        int i11 = 1;
        if (!str.contains(values("?쒕").intern())) {
            int i12 = AFVersionDeclaration + 97;
            getLevel = i12 % 128;
            if (i12 % 2 == 0) {
                z11 = true;
            }
            if (!z11) {
                return str;
            }
            throw null;
        }
        String[] split = str.split(AFInAppEventParameterName("귫౮ቮ᪺").intern());
        int length = split.length;
        StringBuilder sb2 = new StringBuilder();
        int i13 = length - 1;
        sb2.append(split[i13]);
        sb2.append(values("?쒕").intern());
        int i14 = AFVersionDeclaration + 79;
        getLevel = i14 % 128;
        int i15 = i14 % 2;
        while (true) {
            if ((i11 < i13 ? (char) 31 : 12) != 12) {
                int i16 = getLevel + 107;
                AFVersionDeclaration = i16 % 128;
                int i17 = i16 % 2;
                sb2.append(split[i11]);
                sb2.append(values("?쒕").intern());
                i11++;
            } else {
                sb2.append(split[0]);
                return sb2.toString();
            }
        }
    }

    private static String values(Context context) {
        if ((System.getProperties().containsKey(values("ﷳ?립鞅痓卿ㅀས쬗꣣蛈撬䊬").intern()) ? 'A' : '[') != 'A') {
            return null;
        }
        try {
            Matcher matcher = Pattern.compile(AFInAppEventParameterName("쨩ℏ즼㊈視鹫缡ꭖ㚛泧䕰뫰").intern()).matcher(context.getCacheDir().getPath().replace(AFInAppEventParameterName("ᨎ쭜䶴陊帬祖軖").intern(), ""));
            if ((matcher.find() ? '/' : 19) == 19) {
                return null;
            }
            int i11 = AFVersionDeclaration + 109;
            getLevel = i11 % 128;
            int i12 = i11 % 2;
            String group = matcher.group(1);
            int i13 = getLevel + 117;
            AFVersionDeclaration = i13 % 128;
            int i14 = i13 % 2;
            return group;
        } catch (Exception e11) {
            aj valueOf2 = aj.valueOf();
            String intern = AFInAppEventParameterName("湀?倴連断⿬팷惂뤚뫗戴猽㪬⎮髼ᐁ").intern();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(AFInAppEventParameterName("壐樅弙삤烉ӯ븢꜡㙤㕌櫩钴후嫶䌌볃놙倴連ᷤ蓉섎奱걏︠푤ꍟԅଣ窀戴猽㪬⎮髼ᐁ륞㠻").intern());
            sb2.append(e11);
            valueOf2.AFInAppEventType((String) null, intern, sb2.toString());
            return null;
        }
    }

    private static String values(Context context, String str) {
        boolean z11;
        try {
            Iterator it2 = ((List) PackageManager.class.getDeclaredMethod(AFInAppEventParameterName("鿮钴후돘≷蕃昴钸䙡삤烉迏꣪璿荤ᑪ䶴陊㪬⎮髼ᐁ쓎?").intern(), new Class[]{Integer.TYPE}).invoke(context.getPackageManager(), new Object[]{0})).iterator();
            int i11 = getLevel + 123;
            AFVersionDeclaration = i11 % 128;
            int i12 = i11 % 2;
            do {
                if (!it2.hasNext()) {
                    return Boolean.FALSE.toString();
                }
                int i13 = getLevel + 39;
                AFVersionDeclaration = i13 % 128;
                int i14 = i13 % 2;
                if (((ApplicationInfo) it2.next()).packageName.equals(str)) {
                    z11 = false;
                    continue;
                } else {
                    z11 = true;
                    continue;
                }
            } while (z11);
            int i15 = getLevel + 13;
            AFVersionDeclaration = i15 % 128;
            if (!(i15 % 2 != 0)) {
                return Boolean.TRUE.toString();
            }
            Boolean.TRUE.toString();
            throw null;
        } catch (IllegalAccessException e11) {
            aj valueOf2 = aj.valueOf();
            String intern = AFInAppEventParameterName("꾭孶倴連断⿬팷惂偸빁㛓ே삤烉⸳篛䠭쑅뒕䥦铺ꢻ㜃ꨍ").intern();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(AFInAppEventParameterName("求좌弙삤烉ӯ븢寬쇈䃺裒ꠃ੗榐햘㛓ே삤烉⸳鞾嗉?㛐钴후嵵䑱ӯ븢푤ꍟԅଣ窀戴猽㪬⎮髼ᐁ륞㠻").intern());
            sb2.append(e11);
            valueOf2.AFInAppEventType((String) null, intern, sb2.toString());
        } catch (NoSuchMethodException e12) {
            aj valueOf3 = aj.valueOf();
            String intern2 = AFInAppEventParameterName("꾭孶倴連断⿬팷惂偸빁㛓ே삤烉⸳篛䠭쑅뒕䥦铺ꢻ㜃ꨍ").intern();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(AFInAppEventParameterName("求좌弙삤烉ӯ븢寬쇈䃺裒ꠃ੗榐햘㛓ே삤烉⸳鞾嗉?㛐钴후嵵䑱ӯ븢푤ꍟԅଣ窀戴猽㪬⎮髼ᐁ륞㠻").intern());
            sb3.append(e12);
            valueOf3.AFInAppEventType((String) null, intern2, sb3.toString());
        } catch (InvocationTargetException e13) {
            aj valueOf4 = aj.valueOf();
            String intern3 = AFInAppEventParameterName("꾭孶倴連断⿬팷惂偸빁㛓ே삤烉⸳篛䠭쑅뒕䥦铺ꢻ㜃ꨍ").intern();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(AFInAppEventParameterName("求좌弙삤烉ӯ븢寬쇈䃺裒ꠃ੗榐햘㛓ே삤烉⸳鞾嗉?㛐钴후嵵䑱ӯ븢푤ꍟԅଣ窀戴猽㪬⎮髼ᐁ륞㠻").intern());
            sb4.append(e13);
            valueOf4.AFInAppEventType((String) null, intern3, sb4.toString());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String values(java.lang.String r8) {
        /*
            r0 = 0
            r1 = 1
            if (r8 == 0) goto L_0x0006
            r2 = r1
            goto L_0x0007
        L_0x0006:
            r2 = r0
        L_0x0007:
            if (r2 == r1) goto L_0x000a
            goto L_0x0021
        L_0x000a:
            int r2 = getLevel
            int r2 = r2 + r1
            int r3 = r2 % 128
            AFVersionDeclaration = r3
            int r2 = r2 % 2
            r3 = 10
            if (r2 == 0) goto L_0x001a
            r2 = 11
            goto L_0x001b
        L_0x001a:
            r2 = r3
        L_0x001b:
            if (r2 != r3) goto L_0x006a
            char[] r8 = r8.toCharArray()
        L_0x0021:
            char[] r8 = (char[]) r8
            char r0 = r8[r0]
            int r2 = r8.length
            int r2 = r2 - r1
            char[] r2 = new char[r2]
        L_0x0029:
            int r3 = r8.length
            if (r1 >= r3) goto L_0x0064
            int r3 = getLevel
            int r3 = r3 + 119
            int r4 = r3 % 128
            AFVersionDeclaration = r4
            int r3 = r3 % 2
            r4 = 51
            if (r3 == 0) goto L_0x003c
            r3 = r4
            goto L_0x003e
        L_0x003c:
            r3 = 35
        L_0x003e:
            if (r3 == r4) goto L_0x0052
            int r3 = r1 + -1
            char r4 = r8[r1]
            int r5 = r1 * r0
            r4 = r4 ^ r5
            long r4 = (long) r4
            long r6 = values
            long r4 = r4 ^ r6
            int r4 = (int) r4
            char r4 = (char) r4
            r2[r3] = r4
            int r1 = r1 + 1
            goto L_0x0029
        L_0x0052:
            int r3 = r1 % 0
            char r4 = r8[r1]
            int r5 = r1 * r0
            r4 = r4 | r5
            long r4 = (long) r4
            long r6 = values
            long r4 = r4 & r6
            int r4 = (int) r4
            char r4 = (char) r4
            r2[r3] = r4
            int r1 = r1 + 27
            goto L_0x0029
        L_0x0064:
            java.lang.String r8 = new java.lang.String
            r8.<init>(r2)
            return r8
        L_0x006a:
            r8.toCharArray()
            r8 = 0
            throw r8     // Catch:{ all -> 0x006f }
        L_0x006f:
            r8 = move-exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.d.values(java.lang.String):java.lang.String");
    }
}
