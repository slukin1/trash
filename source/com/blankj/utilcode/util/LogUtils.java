package com.blankj.utilcode.util;

import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.blankj.utilcode.util.a0;
import com.hbg.lib.network.pro.core.util.Period;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import e7.s;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public final class LogUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f63310a = {'V', 'D', 'I', 'W', 'E', 'A'};

    /* renamed from: b  reason: collision with root package name */
    public static final String f63311b = System.getProperty("file.separator");

    /* renamed from: c  reason: collision with root package name */
    public static final String f63312c = System.getProperty("line.separator");

    /* renamed from: d  reason: collision with root package name */
    public static final d f63313d = new d((a) null);

    /* renamed from: e  reason: collision with root package name */
    public static SimpleDateFormat f63314e;

    /* renamed from: f  reason: collision with root package name */
    public static final ExecutorService f63315f = Executors.newSingleThreadExecutor();

    /* renamed from: g  reason: collision with root package name */
    public static final SimpleArrayMap<Class, IFormatter> f63316g = new SimpleArrayMap<>();

    public static abstract class IFormatter<T> {
        public abstract String a(T t11);
    }

    public static class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f63317b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f63318c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f63319d;

        public a(int i11, i iVar, String str) {
            this.f63317b = i11;
            this.f63318c = iVar;
            this.f63319d = str;
        }

        public void run() {
            int i11 = this.f63317b;
            String str = this.f63318c.f63343a;
            LogUtils.w(i11, str, this.f63318c.f63345c + this.f63319d);
        }
    }

    public static class b implements FilenameFilter {
        public boolean accept(File file, String str) {
            return LogUtils.s(str);
        }
    }

    public static class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f63320b;

        public c(File file) {
            this.f63320b = file;
        }

        public void run() {
            if (!this.f63320b.delete()) {
                Log.e("LogUtils", "delete " + this.f63320b + " failed!");
            }
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public String f63321a;

        /* renamed from: b  reason: collision with root package name */
        public String f63322b;

        /* renamed from: c  reason: collision with root package name */
        public String f63323c;

        /* renamed from: d  reason: collision with root package name */
        public String f63324d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f63325e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f63326f;

        /* renamed from: g  reason: collision with root package name */
        public String f63327g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f63328h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f63329i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f63330j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f63331k;

        /* renamed from: l  reason: collision with root package name */
        public boolean f63332l;

        /* renamed from: m  reason: collision with root package name */
        public int f63333m;

        /* renamed from: n  reason: collision with root package name */
        public int f63334n;

        /* renamed from: o  reason: collision with root package name */
        public int f63335o;

        /* renamed from: p  reason: collision with root package name */
        public int f63336p;

        /* renamed from: q  reason: collision with root package name */
        public int f63337q;

        /* renamed from: r  reason: collision with root package name */
        public String f63338r;

        /* renamed from: s  reason: collision with root package name */
        public e f63339s;

        /* renamed from: t  reason: collision with root package name */
        public g f63340t;

        /* renamed from: u  reason: collision with root package name */
        public h f63341u;

        /* renamed from: v  reason: collision with root package name */
        public a0.a f63342v;

        public /* synthetic */ d(a aVar) {
            this();
        }

        public final char h() {
            return LogUtils.f63310a[this.f63333m - 2];
        }

        public final String i() {
            String str = this.f63322b;
            return str == null ? this.f63321a : str;
        }

        public final String j() {
            return this.f63324d;
        }

        public final char k() {
            return LogUtils.f63310a[this.f63334n - 2];
        }

        public final String l() {
            return this.f63323c;
        }

        public final String m() {
            if (a0.C(this.f63327g)) {
                return "";
            }
            return this.f63327g;
        }

        public final String n() {
            String str = this.f63338r;
            if (str == null) {
                return "";
            }
            return str.replace(":", "_");
        }

        public final int o() {
            return this.f63337q;
        }

        public final int p() {
            return this.f63335o;
        }

        public final int q() {
            return this.f63336p;
        }

        public final boolean r() {
            return this.f63326f;
        }

        public final boolean s() {
            return this.f63330j;
        }

        public final boolean t() {
            return this.f63331k;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("process: ");
            sb2.append(n());
            sb2.append(LogUtils.f63312c);
            sb2.append("logSwitch: ");
            sb2.append(v());
            sb2.append(LogUtils.f63312c);
            sb2.append("consoleSwitch: ");
            sb2.append(r());
            sb2.append(LogUtils.f63312c);
            sb2.append("tag: ");
            sb2.append(m().equals("") ? OptionsBridge.NULL_VALUE : m());
            sb2.append(LogUtils.f63312c);
            sb2.append("headSwitch: ");
            sb2.append(u());
            sb2.append(LogUtils.f63312c);
            sb2.append("fileSwitch: ");
            sb2.append(s());
            sb2.append(LogUtils.f63312c);
            sb2.append("dir: ");
            sb2.append(i());
            sb2.append(LogUtils.f63312c);
            sb2.append("filePrefix: ");
            sb2.append(l());
            sb2.append(LogUtils.f63312c);
            sb2.append("borderSwitch: ");
            sb2.append(t());
            sb2.append(LogUtils.f63312c);
            sb2.append("singleTagSwitch: ");
            sb2.append(w());
            sb2.append(LogUtils.f63312c);
            sb2.append("consoleFilter: ");
            sb2.append(h());
            sb2.append(LogUtils.f63312c);
            sb2.append("fileFilter: ");
            sb2.append(k());
            sb2.append(LogUtils.f63312c);
            sb2.append("stackDeep: ");
            sb2.append(p());
            sb2.append(LogUtils.f63312c);
            sb2.append("stackOffset: ");
            sb2.append(q());
            sb2.append(LogUtils.f63312c);
            sb2.append("saveDays: ");
            sb2.append(o());
            sb2.append(LogUtils.f63312c);
            sb2.append("formatter: ");
            sb2.append(LogUtils.f63316g);
            sb2.append(LogUtils.f63312c);
            sb2.append("fileWriter: ");
            sb2.append(this.f63339s);
            sb2.append(LogUtils.f63312c);
            sb2.append("onConsoleOutputListener: ");
            sb2.append(this.f63340t);
            sb2.append(LogUtils.f63312c);
            sb2.append("onFileOutputListener: ");
            sb2.append(this.f63341u);
            sb2.append(LogUtils.f63312c);
            sb2.append("fileExtraHeader: ");
            sb2.append(this.f63342v.c());
            return sb2.toString();
        }

        public final boolean u() {
            return this.f63329i;
        }

        public final boolean v() {
            return this.f63325e;
        }

        public final boolean w() {
            return this.f63332l;
        }

        public d() {
            this.f63323c = "util";
            this.f63324d = ".txt";
            this.f63325e = true;
            this.f63326f = true;
            this.f63327g = "";
            this.f63328h = true;
            this.f63329i = true;
            this.f63330j = false;
            this.f63331k = true;
            this.f63332l = true;
            this.f63333m = 2;
            this.f63334n = 2;
            this.f63335o = 1;
            this.f63336p = 0;
            this.f63337q = -1;
            this.f63338r = a0.j();
            this.f63342v = new a0.a("Log");
            if (!a0.B() || Utils.a().getExternalFilesDir((String) null) == null) {
                this.f63321a = Utils.a().getFilesDir() + LogUtils.f63311b + "log" + LogUtils.f63311b;
                return;
            }
            this.f63321a = Utils.a().getExternalFilesDir((String) null) + LogUtils.f63311b + "log" + LogUtils.f63311b;
        }
    }

    public interface e {
        void a(String str, String str2);
    }

    public static final class f {
        public static String a(Object obj) {
            if (obj instanceof Object[]) {
                return Arrays.deepToString((Object[]) obj);
            }
            if (obj instanceof boolean[]) {
                return Arrays.toString((boolean[]) obj);
            }
            if (obj instanceof byte[]) {
                return Arrays.toString((byte[]) obj);
            }
            if (obj instanceof char[]) {
                return Arrays.toString((char[]) obj);
            }
            if (obj instanceof double[]) {
                return Arrays.toString((double[]) obj);
            }
            if (obj instanceof float[]) {
                return Arrays.toString((float[]) obj);
            }
            if (obj instanceof int[]) {
                return Arrays.toString((int[]) obj);
            }
            if (obj instanceof long[]) {
                return Arrays.toString((long[]) obj);
            }
            if (obj instanceof short[]) {
                return Arrays.toString((short[]) obj);
            }
            throw new IllegalArgumentException("Array has incompatible type: " + obj.getClass());
        }

        public static String b(Bundle bundle) {
            String str;
            Iterator it2 = bundle.keySet().iterator();
            if (!it2.hasNext()) {
                return "Bundle {}";
            }
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("Bundle { ");
            while (true) {
                String str2 = (String) it2.next();
                Object obj = bundle.get(str2);
                sb2.append(str2);
                sb2.append('=');
                if (obj instanceof Bundle) {
                    if (obj == bundle) {
                        str = "(this Bundle)";
                    } else {
                        str = b((Bundle) obj);
                    }
                    sb2.append(str);
                } else {
                    sb2.append(LogUtils.m(obj));
                }
                if (!it2.hasNext()) {
                    sb2.append(" }");
                    return sb2.toString();
                }
                sb2.append(',');
                sb2.append(' ');
            }
        }

        public static void c(ClipData clipData, StringBuilder sb2) {
            ClipData.Item itemAt = clipData.getItemAt(0);
            if (itemAt == null) {
                sb2.append("ClipData.Item {}");
                return;
            }
            sb2.append("ClipData.Item { ");
            String htmlText = itemAt.getHtmlText();
            if (htmlText != null) {
                sb2.append("H:");
                sb2.append(htmlText);
                sb2.append("}");
                return;
            }
            CharSequence text = itemAt.getText();
            if (text != null) {
                sb2.append("T:");
                sb2.append(text);
                sb2.append("}");
                return;
            }
            Uri uri = itemAt.getUri();
            if (uri != null) {
                sb2.append("U:");
                sb2.append(uri);
                sb2.append("}");
                return;
            }
            Intent intent = itemAt.getIntent();
            if (intent != null) {
                sb2.append("I:");
                sb2.append(e(intent));
                sb2.append("}");
                return;
            }
            sb2.append("NULL");
            sb2.append("}");
        }

        public static String d(String str) {
            try {
                StreamSource streamSource = new StreamSource(new StringReader(str));
                StreamResult streamResult = new StreamResult(new StringWriter());
                Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
                newTransformer.setOutputProperty("indent", "yes");
                newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                newTransformer.transform(streamSource, streamResult);
                String obj = streamResult.getWriter().toString();
                return obj.replaceFirst(">", ">" + LogUtils.f63312c);
            } catch (Exception e11) {
                e11.printStackTrace();
                return str;
            }
        }

        public static String e(Intent intent) {
            boolean z11;
            Intent selector;
            String str;
            ClipData clipData;
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("Intent { ");
            String action = intent.getAction();
            boolean z12 = true;
            boolean z13 = false;
            if (action != null) {
                sb2.append("act=");
                sb2.append(action);
                z11 = false;
            } else {
                z11 = true;
            }
            Set<String> categories = intent.getCategories();
            if (categories != null) {
                if (!z11) {
                    sb2.append(' ');
                }
                sb2.append("cat=[");
                for (String next : categories) {
                    if (!z12) {
                        sb2.append(',');
                    }
                    sb2.append(next);
                    z12 = false;
                }
                sb2.append("]");
                z11 = false;
            }
            Uri data = intent.getData();
            if (data != null) {
                if (!z11) {
                    sb2.append(' ');
                }
                sb2.append("dat=");
                sb2.append(data);
                z11 = false;
            }
            String type = intent.getType();
            if (type != null) {
                if (!z11) {
                    sb2.append(' ');
                }
                sb2.append("typ=");
                sb2.append(type);
                z11 = false;
            }
            int flags = intent.getFlags();
            if (flags != 0) {
                if (!z11) {
                    sb2.append(' ');
                }
                sb2.append("flg=0x");
                sb2.append(Integer.toHexString(flags));
                z11 = false;
            }
            String str2 = intent.getPackage();
            if (str2 != null) {
                if (!z11) {
                    sb2.append(' ');
                }
                sb2.append("pkg=");
                sb2.append(str2);
                z11 = false;
            }
            ComponentName component = intent.getComponent();
            if (component != null) {
                if (!z11) {
                    sb2.append(' ');
                }
                sb2.append("cmp=");
                sb2.append(component.flattenToShortString());
                z11 = false;
            }
            Rect sourceBounds = intent.getSourceBounds();
            if (sourceBounds != null) {
                if (!z11) {
                    sb2.append(' ');
                }
                sb2.append("bnds=");
                sb2.append(sourceBounds.toShortString());
                z11 = false;
            }
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 16 && (clipData = intent.getClipData()) != null) {
                if (!z11) {
                    sb2.append(' ');
                }
                c(clipData, sb2);
                z11 = false;
            }
            Bundle extras = intent.getExtras();
            if (extras != null) {
                if (!z11) {
                    sb2.append(' ');
                }
                sb2.append("extras={");
                sb2.append(b(extras));
                sb2.append('}');
            } else {
                z13 = z11;
            }
            if (i11 >= 15 && (selector = intent.getSelector()) != null) {
                if (!z13) {
                    sb2.append(' ');
                }
                sb2.append("sel={");
                if (selector == intent) {
                    str = "(this Intent)";
                } else {
                    str = e(selector);
                }
                sb2.append(str);
                sb2.append("}");
            }
            sb2.append(" }");
            return sb2.toString();
        }

        public static String f(Object obj) {
            if (obj instanceof CharSequence) {
                return a0.f(obj.toString());
            }
            try {
                return a0.m().toJson(obj);
            } catch (Throwable unused) {
                return obj.toString();
            }
        }

        public static String g(Object obj) {
            return h(obj, -1);
        }

        public static String h(Object obj, int i11) {
            if (obj.getClass().isArray()) {
                return a(obj);
            }
            if (obj instanceof Throwable) {
                return a0.l((Throwable) obj);
            }
            if (obj instanceof Bundle) {
                return b((Bundle) obj);
            }
            if (obj instanceof Intent) {
                return e((Intent) obj);
            }
            if (i11 == 32) {
                return f(obj);
            }
            if (i11 == 48) {
                return d(obj.toString());
            }
            return obj.toString();
        }
    }

    public interface g {
        void a(int i11, String str, String str2);
    }

    public interface h {
        void a(String str, String str2);
    }

    public static final class i {

        /* renamed from: a  reason: collision with root package name */
        public String f63343a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f63344b;

        /* renamed from: c  reason: collision with root package name */
        public String f63345c;

        public i(String str, String[] strArr, String str2) {
            this.f63343a = str;
            this.f63344b = strArr;
            this.f63345c = str2;
        }
    }

    public static void A(int i11, String str, String str2) {
        int length = str2.length();
        int i12 = length / 1100;
        if (i12 > 0) {
            int i13 = 0;
            int i14 = 0;
            while (i13 < i12) {
                int i15 = i14 + 1100;
                C(i11, str, str2.substring(i14, i15));
                i13++;
                i14 = i15;
            }
            if (i14 != length) {
                C(i11, str, str2.substring(i14, length));
                return;
            }
            return;
        }
        C(i11, str, str2);
    }

    public static void B(int i11, String str, String str2) {
        int length = str2.length();
        d dVar = f63313d;
        int i12 = 1100;
        int i13 = dVar.t() ? (length - 113) / 1100 : length / 1100;
        if (i13 > 0) {
            int i14 = 1;
            if (dVar.t()) {
                u(i11, str, str2.substring(0, 1100) + f63312c + "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
                while (i14 < i13) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(" ");
                    String str3 = f63312c;
                    sb2.append(str3);
                    sb2.append("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
                    sb2.append(str3);
                    sb2.append("│ ");
                    int i15 = i12 + 1100;
                    sb2.append(str2.substring(i12, i15));
                    sb2.append(str3);
                    sb2.append("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
                    u(i11, str, sb2.toString());
                    i14++;
                    i12 = i15;
                }
                if (i12 != length - 113) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(" ");
                    String str4 = f63312c;
                    sb3.append(str4);
                    sb3.append("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
                    sb3.append(str4);
                    sb3.append("│ ");
                    sb3.append(str2.substring(i12, length));
                    u(i11, str, sb3.toString());
                    return;
                }
                return;
            }
            u(i11, str, str2.substring(0, 1100));
            while (i14 < i13) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(" ");
                sb4.append(f63312c);
                int i16 = i12 + 1100;
                sb4.append(str2.substring(i12, i16));
                u(i11, str, sb4.toString());
                i14++;
                i12 = i16;
            }
            if (i12 != length) {
                u(i11, str, " " + f63312c + str2.substring(i12, length));
                return;
            }
            return;
        }
        u(i11, str, str2);
    }

    public static void C(int i11, String str, String str2) {
        if (!f63313d.t()) {
            u(i11, str, str2);
            return;
        }
        for (String str3 : str2.split(f63312c)) {
            u(i11, str, "│ " + str3);
        }
    }

    public static String D(int i11, Object... objArr) {
        String str;
        if (objArr != null) {
            if (objArr.length == 1) {
                str = l(i11, objArr[0]);
            } else {
                StringBuilder sb2 = new StringBuilder();
                int length = objArr.length;
                for (int i12 = 0; i12 < length; i12++) {
                    Object obj = objArr[i12];
                    sb2.append("args");
                    sb2.append("[");
                    sb2.append(i12);
                    sb2.append("]");
                    sb2.append(" = ");
                    sb2.append(m(obj));
                    sb2.append(f63312c);
                }
                str = sb2.toString();
            }
        } else {
            str = OptionsBridge.NULL_VALUE;
        }
        return str.length() == 0 ? "log nothing" : str;
    }

    public static String E(int i11, String str, String[] strArr, String str2) {
        StringBuilder sb2 = new StringBuilder();
        int i12 = 0;
        if (f63313d.t()) {
            sb2.append(" ");
            String str3 = f63312c;
            sb2.append(str3);
            sb2.append("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            sb2.append(str3);
            if (strArr != null) {
                for (String append : strArr) {
                    sb2.append("│ ");
                    sb2.append(append);
                    sb2.append(f63312c);
                }
                sb2.append("├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
                sb2.append(f63312c);
            }
            String[] split = str2.split(f63312c);
            int length = split.length;
            while (i12 < length) {
                String str4 = split[i12];
                sb2.append("│ ");
                sb2.append(str4);
                sb2.append(f63312c);
                i12++;
            }
            sb2.append("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        } else {
            if (strArr != null) {
                sb2.append(" ");
                sb2.append(f63312c);
                int length2 = strArr.length;
                while (i12 < length2) {
                    sb2.append(strArr[i12]);
                    sb2.append(f63312c);
                    i12++;
                }
            }
            sb2.append(str2);
        }
        return sb2.toString();
    }

    public static i F(String str) {
        String str2;
        String str3;
        String str4;
        d dVar = f63313d;
        if (dVar.f63328h || dVar.u()) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            int q11 = dVar.q() + 3;
            if (q11 >= stackTrace.length) {
                String p11 = p(stackTrace[3]);
                if (!dVar.f63328h || !a0.C(str)) {
                    str4 = str;
                } else {
                    int indexOf = p11.indexOf(46);
                    str4 = indexOf == -1 ? p11 : p11.substring(0, indexOf);
                }
                return new i(str4, (String[]) null, l.f34627b);
            }
            StackTraceElement stackTraceElement = stackTrace[q11];
            String p12 = p(stackTraceElement);
            if (!dVar.f63328h || !a0.C(str)) {
                str3 = str;
            } else {
                int indexOf2 = p12.indexOf(46);
                str3 = indexOf2 == -1 ? p12 : p12.substring(0, indexOf2);
            }
            if (dVar.u()) {
                String name = Thread.currentThread().getName();
                String formatter = new Formatter().format("%s, %s.%s(%s:%d)", new Object[]{name, stackTraceElement.getClassName(), stackTraceElement.getMethodName(), p12, Integer.valueOf(stackTraceElement.getLineNumber())}).toString();
                String str5 = " [" + formatter + "]: ";
                if (dVar.p() <= 1) {
                    return new i(str3, new String[]{formatter}, str5);
                }
                int min = Math.min(dVar.p(), stackTrace.length - q11);
                String[] strArr = new String[min];
                strArr[0] = formatter;
                String formatter2 = new Formatter().format("%" + (name.length() + 2) + s.f70071a, new Object[]{""}).toString();
                for (int i11 = 1; i11 < min; i11++) {
                    StackTraceElement stackTraceElement2 = stackTrace[i11 + q11];
                    strArr[i11] = new Formatter().format("%s%s.%s(%s:%d)", new Object[]{formatter2, stackTraceElement2.getClassName(), stackTraceElement2.getMethodName(), p(stackTraceElement2), Integer.valueOf(stackTraceElement2.getLineNumber())}).toString();
                }
                return new i(str3, strArr, str5);
            }
            str2 = str3;
        } else {
            str2 = dVar.m();
        }
        return new i(str2, (String[]) null, l.f34627b);
    }

    public static boolean h(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile();
        }
        if (!a0.b(file.getParentFile())) {
            return false;
        }
        try {
            i(str, str2);
            boolean createNewFile = file.createNewFile();
            if (createNewFile) {
                y(str, str2);
            }
            return createNewFile;
        } catch (IOException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static void i(String str, String str2) {
        File[] listFiles;
        d dVar = f63313d;
        if (dVar.o() > 0 && (listFiles = new File(str).getParentFile().listFiles(new b())) != null && listFiles.length > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd", Locale.getDefault());
            try {
                long time = simpleDateFormat.parse(str2).getTime() - (((long) dVar.o()) * Period.DAY_MILLS);
                for (File file : listFiles) {
                    String name = file.getName();
                    name.length();
                    if (simpleDateFormat.parse(k(name)).getTime() <= time) {
                        f63315f.execute(new c(file));
                    }
                }
            } catch (ParseException e11) {
                e11.printStackTrace();
            }
        }
    }

    public static void j(Object... objArr) {
        t(6, f63313d.m(), objArr);
    }

    public static String k(String str) {
        Matcher matcher = Pattern.compile("[0-9]{4}_[0-9]{2}_[0-9]{2}").matcher(str);
        return matcher.find() ? matcher.group() : "";
    }

    public static String l(int i11, Object obj) {
        if (obj == null) {
            return OptionsBridge.NULL_VALUE;
        }
        if (i11 == 32) {
            return f.h(obj, 32);
        }
        if (i11 == 48) {
            return f.h(obj, 48);
        }
        return m(obj);
    }

    public static String m(Object obj) {
        IFormatter iFormatter;
        if (obj == null) {
            return OptionsBridge.NULL_VALUE;
        }
        SimpleArrayMap<Class, IFormatter> simpleArrayMap = f63316g;
        if (simpleArrayMap.isEmpty() || (iFormatter = simpleArrayMap.get(n(obj))) == null) {
            return f.g(obj);
        }
        return iFormatter.a(obj);
    }

    public static Class n(Object obj) {
        String str;
        Class<?> cls = obj.getClass();
        if (cls.isAnonymousClass() || cls.isSynthetic()) {
            Type[] genericInterfaces = cls.getGenericInterfaces();
            if (genericInterfaces.length == 1) {
                Type type = genericInterfaces[0];
                while (type instanceof ParameterizedType) {
                    type = ((ParameterizedType) type).getRawType();
                }
                str = type.toString();
            } else {
                Type genericSuperclass = cls.getGenericSuperclass();
                while (genericSuperclass instanceof ParameterizedType) {
                    genericSuperclass = ((ParameterizedType) genericSuperclass).getRawType();
                }
                str = genericSuperclass.toString();
            }
            if (str.startsWith("class ")) {
                str = str.substring(6);
            } else if (str.startsWith("interface ")) {
                str = str.substring(10);
            }
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException e11) {
                e11.printStackTrace();
            }
        }
        return cls;
    }

    public static String o(Date date) {
        String substring = q().format(date).substring(0, 10);
        StringBuilder sb2 = new StringBuilder();
        d dVar = f63313d;
        sb2.append(dVar.i());
        sb2.append(dVar.l());
        sb2.append("_");
        sb2.append(substring);
        sb2.append("_");
        sb2.append(dVar.n());
        sb2.append(dVar.j());
        return sb2.toString();
    }

    public static String p(StackTraceElement stackTraceElement) {
        String fileName = stackTraceElement.getFileName();
        if (fileName != null) {
            return fileName;
        }
        String className = stackTraceElement.getClassName();
        String[] split = className.split("\\.");
        if (split.length > 0) {
            className = split[split.length - 1];
        }
        int indexOf = className.indexOf(36);
        if (indexOf != -1) {
            className = className.substring(0, indexOf);
        }
        return className + ".java";
    }

    public static SimpleDateFormat q() {
        if (f63314e == null) {
            f63314e = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss.SSS ", Locale.getDefault());
        }
        return f63314e;
    }

    public static void r(String str, String str2) {
        d dVar = f63313d;
        if (dVar.f63339s == null) {
            a0.M(str, str2, true);
        } else {
            dVar.f63339s.a(str, str2);
        }
        if (dVar.f63341u != null) {
            dVar.f63341u.a(str, str2);
        }
    }

    public static boolean s(String str) {
        return str.matches("^" + f63313d.l() + "_[0-9]{4}_[0-9]{2}_[0-9]{2}_.*$");
    }

    public static void t(int i11, String str, Object... objArr) {
        d dVar = f63313d;
        if (dVar.v()) {
            int i12 = i11 & 15;
            int i13 = i11 & 240;
            if (!dVar.r() && !dVar.s() && i13 != 16) {
                return;
            }
            if (i12 >= dVar.f63333m || i12 >= dVar.f63334n) {
                i F = F(str);
                String D = D(i13, objArr);
                if (dVar.r() && i13 != 16 && i12 >= dVar.f63333m) {
                    v(i12, F.f63343a, F.f63344b, D);
                }
                if ((dVar.s() || i13 == 16) && i12 >= dVar.f63334n) {
                    f63315f.execute(new a(i12, F, D));
                }
            }
        }
    }

    public static void u(int i11, String str, String str2) {
        Log.println(i11, str, str2);
        d dVar = f63313d;
        if (dVar.f63340t != null) {
            dVar.f63340t.a(i11, str, str2);
        }
    }

    public static void v(int i11, String str, String[] strArr, String str2) {
        if (f63313d.w()) {
            B(i11, str, E(i11, str, strArr, str2));
            return;
        }
        x(i11, str, true);
        z(i11, str, strArr);
        A(i11, str, str2);
        x(i11, str, false);
    }

    public static void w(int i11, String str, String str2) {
        Date date = new Date();
        String format = q().format(date);
        String substring = format.substring(0, 10);
        String o11 = o(date);
        if (!h(o11, substring)) {
            Log.e("LogUtils", "create " + o11 + " failed!");
            return;
        }
        String substring2 = format.substring(11);
        r(o11, substring2 + f63310a[i11 - 2] + "/" + str + str2 + f63312c);
    }

    public static void x(int i11, String str, boolean z11) {
        if (f63313d.t()) {
            u(i11, str, z11 ? "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────" : "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        }
    }

    public static void y(String str, String str2) {
        d dVar = f63313d;
        dVar.f63342v.a("Date of Log", str2);
        r(str, dVar.f63342v.toString());
    }

    public static void z(int i11, String str, String[] strArr) {
        if (strArr != null) {
            for (String str2 : strArr) {
                if (f63313d.t()) {
                    str2 = "│ " + str2;
                }
                u(i11, str, str2);
            }
            if (f63313d.t()) {
                u(i11, str, "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
            }
        }
    }
}
