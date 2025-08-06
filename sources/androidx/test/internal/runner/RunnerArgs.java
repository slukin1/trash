package androidx.test.internal.runner;

import android.app.Instrumentation;
import android.app.UiAutomation;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import androidx.test.runner.lifecycle.ApplicationLifecycleCallback;
import androidx.test.runner.screenshot.ScreenCaptureProcessor;
import com.alibaba.verificationsdk.BuildConfig;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.sumsub.sns.internal.core.common.n0;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.notification.RunListener;
import org.junit.runners.model.RunnerBuilder;

public class RunnerArgs {
    public final String A;
    public final boolean B;
    public final String C;
    public final boolean D;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f11416a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f11417b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f11418c;

    /* renamed from: d  reason: collision with root package name */
    public final String f11419d;

    /* renamed from: e  reason: collision with root package name */
    public final int f11420e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f11421f;

    /* renamed from: g  reason: collision with root package name */
    public final List<String> f11422g;

    /* renamed from: h  reason: collision with root package name */
    public final List<String> f11423h;

    /* renamed from: i  reason: collision with root package name */
    public final String f11424i;

    /* renamed from: j  reason: collision with root package name */
    public final String f11425j;

    /* renamed from: k  reason: collision with root package name */
    public final List<String> f11426k;

    /* renamed from: l  reason: collision with root package name */
    public final long f11427l;

    /* renamed from: m  reason: collision with root package name */
    public final List<RunListener> f11428m;

    /* renamed from: n  reason: collision with root package name */
    public final List<Filter> f11429n;

    /* renamed from: o  reason: collision with root package name */
    public final List<Class<? extends RunnerBuilder>> f11430o;

    /* renamed from: p  reason: collision with root package name */
    public final List<TestArg> f11431p;

    /* renamed from: q  reason: collision with root package name */
    public final List<TestArg> f11432q;

    /* renamed from: r  reason: collision with root package name */
    public final int f11433r;

    /* renamed from: s  reason: collision with root package name */
    public final int f11434s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f11435t;

    /* renamed from: u  reason: collision with root package name */
    public final List<ApplicationLifecycleCallback> f11436u;

    /* renamed from: v  reason: collision with root package name */
    public final ClassLoader f11437v;

    /* renamed from: w  reason: collision with root package name */
    public final Set<String> f11438w;

    /* renamed from: x  reason: collision with root package name */
    public final TestArg f11439x;

    /* renamed from: y  reason: collision with root package name */
    public final String f11440y;

    /* renamed from: z  reason: collision with root package name */
    public final List<ScreenCaptureProcessor> f11441z;

    public static class Builder {
        public String A = null;
        public List<ScreenCaptureProcessor> B = new ArrayList();
        public String C;
        public boolean D = false;

        /* renamed from: a  reason: collision with root package name */
        public boolean f11442a = false;

        /* renamed from: b  reason: collision with root package name */
        public boolean f11443b = false;

        /* renamed from: c  reason: collision with root package name */
        public boolean f11444c = false;

        /* renamed from: d  reason: collision with root package name */
        public String f11445d = null;

        /* renamed from: e  reason: collision with root package name */
        public int f11446e = -1;

        /* renamed from: f  reason: collision with root package name */
        public boolean f11447f = false;

        /* renamed from: g  reason: collision with root package name */
        public List<String> f11448g = new ArrayList();

        /* renamed from: h  reason: collision with root package name */
        public List<String> f11449h = new ArrayList();

        /* renamed from: i  reason: collision with root package name */
        public String f11450i = null;

        /* renamed from: j  reason: collision with root package name */
        public String f11451j = null;

        /* renamed from: k  reason: collision with root package name */
        public List<String> f11452k = new ArrayList();

        /* renamed from: l  reason: collision with root package name */
        public long f11453l = -1;

        /* renamed from: m  reason: collision with root package name */
        public List<RunListener> f11454m = new ArrayList();

        /* renamed from: n  reason: collision with root package name */
        public List<Filter> f11455n = new ArrayList();

        /* renamed from: o  reason: collision with root package name */
        public List<Class<? extends RunnerBuilder>> f11456o = new ArrayList();

        /* renamed from: p  reason: collision with root package name */
        public List<TestArg> f11457p = new ArrayList();

        /* renamed from: q  reason: collision with root package name */
        public List<TestArg> f11458q = new ArrayList();

        /* renamed from: r  reason: collision with root package name */
        public int f11459r = 0;

        /* renamed from: s  reason: collision with root package name */
        public int f11460s = 0;

        /* renamed from: t  reason: collision with root package name */
        public boolean f11461t = false;

        /* renamed from: u  reason: collision with root package name */
        public List<ApplicationLifecycleCallback> f11462u = new ArrayList();

        /* renamed from: v  reason: collision with root package name */
        public ClassLoader f11463v = null;

        /* renamed from: w  reason: collision with root package name */
        public Set<String> f11464w = new HashSet();

        /* renamed from: x  reason: collision with root package name */
        public TestArg f11465x = null;

        /* renamed from: y  reason: collision with root package name */
        public String f11466y = null;

        /* renamed from: z  reason: collision with root package name */
        public boolean f11467z = false;

        public static boolean G(String str) {
            return str.matches("^([\\p{L}_$][\\p{L}\\p{N}_$]*\\.)*[\\p{Lu}_$][\\p{L}\\p{N}_$]*(#[\\p{L}_$][\\p{L}\\p{N}_$]*)?$");
        }

        public static boolean L(String str) {
            return str != null && Boolean.parseBoolean(str);
        }

        public static Set<String> M(String str) {
            if (str == null || str.isEmpty()) {
                return new HashSet();
            }
            return new HashSet(Arrays.asList(str.split(":", -1)));
        }

        public static List<String> Q(String str) {
            if (str == null) {
                return Collections.emptyList();
            }
            return Arrays.asList(str.split(Constants.ACCEPT_TIME_SEPARATOR_SP));
        }

        public static TestArg R(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int indexOf = str.indexOf(35);
            if (indexOf <= 0) {
                return new TestArg(str);
            }
            return new TestArg(str.substring(0, indexOf), str.substring(indexOf + 1));
        }

        public static List<String> T(String str) {
            ArrayList arrayList = new ArrayList();
            if (str != null) {
                for (String add : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    arrayList.add(add);
                }
            }
            return arrayList;
        }

        public static int U(Object obj, String str) {
            if (obj == null) {
                return -1;
            }
            int parseInt = Integer.parseInt(obj.toString());
            if (parseInt >= 0) {
                return parseInt;
            }
            throw new NumberFormatException(String.valueOf(str).concat(" can not be negative"));
        }

        public static long V(Object obj, String str) {
            if (obj == null) {
                return -1;
            }
            long parseLong = Long.parseLong(obj.toString());
            if (parseLong >= 0) {
                return parseLong;
            }
            throw new NumberFormatException(String.valueOf(str).concat(" can not be negative"));
        }

        public static String W(String str) {
            if (str.matches("^([\\p{L}_$][\\p{L}\\p{N}_$]*\\.)*[\\p{L}_$][\\p{L}\\p{N}_$]*$")) {
                return str;
            }
            throw new IllegalArgumentException(String.format("\"%s\" not recognized as valid package name", new Object[]{str}));
        }

        public RunnerArgs D() {
            return new RunnerArgs(this);
        }

        public Builder E(Instrumentation instrumentation, Bundle bundle) {
            this.f11442a = L(bundle.getString(BuildConfig.BUILD_TYPE));
            this.f11446e = U(bundle.get("delay_msec"), "delay_msec");
            this.f11457p.addAll(S(bundle.getString(io.flutter.plugins.firebase.crashlytics.Constants.CLASS)));
            this.f11458q.addAll(S(bundle.getString("notClass")));
            this.f11448g.addAll(T(bundle.getString("package")));
            this.f11449h.addAll(T(bundle.getString("notPackage")));
            TestFileArgs N = N(instrumentation, bundle.getString("testFile"));
            this.f11457p.addAll(N.f11470a);
            this.f11448g.addAll(N.f11471b);
            TestFileArgs N2 = N(instrumentation, bundle.getString("notTestFile"));
            this.f11458q.addAll(N2.f11470a);
            this.f11449h.addAll(N2.f11471b);
            this.f11454m.addAll(P(bundle.getString(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER), RunListener.class, (Bundle) null));
            this.f11455n.addAll(P(bundle.getString("filter"), Filter.class, bundle));
            this.f11456o.addAll(K(bundle.getString("runnerBuilder"), RunnerBuilder.class));
            this.f11450i = bundle.getString("size");
            this.f11451j = bundle.getString("annotation");
            this.f11452k.addAll(Q(bundle.getString("notAnnotation")));
            this.f11453l = V(bundle.getString("timeout_msec"), "timeout_msec");
            this.f11459r = U(bundle.get("numShards"), "numShards");
            this.f11460s = U(bundle.get("shardIndex"), "shardIndex");
            this.f11447f = L(bundle.getString("log"));
            this.f11461t = L(bundle.getString("disableAnalytics"));
            this.f11462u.addAll(P(bundle.getString("appListener"), ApplicationLifecycleCallback.class, (Bundle) null));
            this.f11444c = L(bundle.getString("coverage"));
            this.f11445d = bundle.getString("coverageFile");
            this.f11443b = L(bundle.getString("suiteAssignment"));
            this.f11463v = (ClassLoader) O(bundle.getString("classLoader"), ClassLoader.class);
            this.f11464w = M(bundle.getString("classpathToScan"));
            if (bundle.containsKey("remoteMethod")) {
                this.f11465x = R(bundle.getString("remoteMethod"));
            }
            this.f11466y = bundle.getString("orchestratorService");
            this.f11467z = L(bundle.getString("listTestsForOrchestrator"));
            this.A = bundle.getString("targetProcess");
            this.B.addAll(P(bundle.getString("screenCaptureProcessors"), ScreenCaptureProcessor.class, (Bundle) null));
            this.C = bundle.getString("shellExecBinderKey");
            this.D = L(bundle.getString("newRunListenerMode"));
            return this;
        }

        public Builder F(Instrumentation instrumentation) {
            try {
                Bundle bundle = instrumentation.getContext().getPackageManager().getInstrumentationInfo(instrumentation.getComponentName(), 128).metaData;
                if (bundle == null) {
                    return this;
                }
                return E(instrumentation, bundle);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.wtf("RunnerArgs", String.format("Could not find component %s", new Object[]{instrumentation.getComponentName()}));
                return this;
            }
        }

        public final <T> void H(List<Class<? extends T>> list, String str, Class<T> cls) {
            if (str != null && str.length() != 0) {
                try {
                    Class<?> cls2 = Class.forName(str);
                    if (cls.isAssignableFrom(cls2)) {
                        list.add(cls2);
                        return;
                    }
                    String name = cls.getName();
                    StringBuilder sb2 = new StringBuilder(str.length() + 17 + name.length());
                    sb2.append(str);
                    sb2.append(" does not extend ");
                    sb2.append(name);
                    throw new IllegalArgumentException(sb2.toString());
                } catch (ClassNotFoundException unused) {
                    throw new IllegalArgumentException(str.length() != 0 ? "Could not find extra class ".concat(str) : new String("Could not find extra class "));
                } catch (ClassCastException unused2) {
                    String name2 = cls.getName();
                    StringBuilder sb3 = new StringBuilder(str.length() + 17 + name2.length());
                    sb3.append(str);
                    sb3.append(" does not extend ");
                    sb3.append(name2);
                    throw new IllegalArgumentException(sb3.toString());
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003f, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0048, code lost:
            if (r9.length() != 0) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004a, code lost:
            r9 = "Failed to create listener: ".concat(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x004f, code lost:
            r9 = new java.lang.String("Failed to create listener: ");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0057, code lost:
            throw new java.lang.IllegalArgumentException(r9, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0058, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x005f, code lost:
            if (r9.length() != 0) goto L_0x0061;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0061, code lost:
            r9 = "Failed to create: ".concat(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0066, code lost:
            r9 = new java.lang.String("Failed to create: ");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x006e, code lost:
            throw new java.lang.IllegalArgumentException(r9, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x006f, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0076, code lost:
            if (r9.length() != 0) goto L_0x0078;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0078, code lost:
            r9 = "Failed to create: ".concat(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x007d, code lost:
            r9 = new java.lang.String("Failed to create: ");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0085, code lost:
            throw new java.lang.IllegalArgumentException(r9, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0086, code lost:
            r10 = r10.getName();
            r0 = new java.lang.StringBuilder((r9.length() + 17) + r10.length());
            r0.append(r9);
            r0.append(" does not extend ");
            r0.append(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ae, code lost:
            throw new java.lang.IllegalArgumentException(r0.toString());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00cf, code lost:
            if (r9.length() != 0) goto L_0x00d1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00d1, code lost:
            r9 = "Could not find extra class ".concat(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00d6, code lost:
            r9 = new java.lang.String("Could not find extra class ");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00de, code lost:
            throw new java.lang.IllegalArgumentException(r9);
         */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x003f A[ExcHandler: IllegalAccessException (r8v6 'e' java.lang.IllegalAccessException A[CUSTOM_DECLARE]), Splitter:B:4:0x000c] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0058 A[ExcHandler: InvocationTargetException (r8v5 'e' java.lang.reflect.InvocationTargetException A[CUSTOM_DECLARE]), Splitter:B:4:0x000c] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x006f A[ExcHandler: InstantiationException (r8v4 'e' java.lang.InstantiationException A[CUSTOM_DECLARE]), Splitter:B:4:0x000c] */
        /* JADX WARNING: Removed duplicated region for block: B:43:? A[ExcHandler: ClassCastException (unused java.lang.ClassCastException), SYNTHETIC, Splitter:B:4:0x000c] */
        /* JADX WARNING: Removed duplicated region for block: B:53:? A[ExcHandler: ClassNotFoundException (unused java.lang.ClassNotFoundException), SYNTHETIC, Splitter:B:4:0x000c] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final <T> void I(java.util.List<T> r8, java.lang.String r9, java.lang.Class<T> r10, android.os.Bundle r11) {
            /*
                r7 = this;
                java.lang.String r0 = "Failed to create: "
                if (r9 == 0) goto L_0x00df
                int r1 = r9.length()
                if (r1 != 0) goto L_0x000c
                goto L_0x00df
            L_0x000c:
                java.lang.Class r1 = java.lang.Class.forName(r9)     // Catch:{ ClassNotFoundException -> 0x00c7, NoSuchMethodException -> 0x00af, ClassCastException -> 0x0086, InstantiationException -> 0x006f, InvocationTargetException -> 0x0058, IllegalAccessException -> 0x003f }
                r2 = 1
                r3 = 0
                java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x001b, ClassNotFoundException -> 0x00c7, ClassCastException -> 0x0086, InstantiationException -> 0x006f, InvocationTargetException -> 0x0058, IllegalAccessException -> 0x003f }
                java.lang.reflect.Constructor r4 = r1.getConstructor(r4)     // Catch:{ NoSuchMethodException -> 0x001b, ClassNotFoundException -> 0x00c7, ClassCastException -> 0x0086, InstantiationException -> 0x006f, InvocationTargetException -> 0x0058, IllegalAccessException -> 0x003f }
                java.lang.Object[] r11 = new java.lang.Object[r3]     // Catch:{ NoSuchMethodException -> 0x001b, ClassNotFoundException -> 0x00c7, ClassCastException -> 0x0086, InstantiationException -> 0x006f, InvocationTargetException -> 0x0058, IllegalAccessException -> 0x003f }
                goto L_0x002e
            L_0x001b:
                r4 = move-exception
                if (r11 == 0) goto L_0x003e
                java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x0039, ClassNotFoundException -> 0x00c7, ClassCastException -> 0x0086, InstantiationException -> 0x006f, InvocationTargetException -> 0x0058, IllegalAccessException -> 0x003f }
                java.lang.Class<android.os.Bundle> r6 = android.os.Bundle.class
                r5[r3] = r6     // Catch:{ NoSuchMethodException -> 0x0039, ClassNotFoundException -> 0x00c7, ClassCastException -> 0x0086, InstantiationException -> 0x006f, InvocationTargetException -> 0x0058, IllegalAccessException -> 0x003f }
                java.lang.reflect.Constructor r1 = r1.getConstructor(r5)     // Catch:{ NoSuchMethodException -> 0x0039, ClassNotFoundException -> 0x00c7, ClassCastException -> 0x0086, InstantiationException -> 0x006f, InvocationTargetException -> 0x0058, IllegalAccessException -> 0x003f }
                java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ NoSuchMethodException -> 0x0039, ClassNotFoundException -> 0x00c7, ClassCastException -> 0x0086, InstantiationException -> 0x006f, InvocationTargetException -> 0x0058, IllegalAccessException -> 0x003f }
                r5[r3] = r11     // Catch:{ NoSuchMethodException -> 0x0039, ClassNotFoundException -> 0x00c7, ClassCastException -> 0x0086, InstantiationException -> 0x006f, InvocationTargetException -> 0x0058, IllegalAccessException -> 0x003f }
                r4 = r1
                r11 = r5
            L_0x002e:
                r4.setAccessible(r2)     // Catch:{ ClassNotFoundException -> 0x00c7, NoSuchMethodException -> 0x00af, ClassCastException -> 0x0086, InstantiationException -> 0x006f, InvocationTargetException -> 0x0058, IllegalAccessException -> 0x003f }
                java.lang.Object r11 = r4.newInstance(r11)     // Catch:{ ClassNotFoundException -> 0x00c7, NoSuchMethodException -> 0x00af, ClassCastException -> 0x0086, InstantiationException -> 0x006f, InvocationTargetException -> 0x0058, IllegalAccessException -> 0x003f }
                r8.add(r11)     // Catch:{ ClassNotFoundException -> 0x00c7, NoSuchMethodException -> 0x00af, ClassCastException -> 0x0086, InstantiationException -> 0x006f, InvocationTargetException -> 0x0058, IllegalAccessException -> 0x003f }
                return
            L_0x0039:
                r8 = move-exception
                r8.initCause(r4)     // Catch:{ ClassNotFoundException -> 0x00c7, NoSuchMethodException -> 0x00af, ClassCastException -> 0x0086, InstantiationException -> 0x006f, InvocationTargetException -> 0x0058, IllegalAccessException -> 0x003f }
                throw r8     // Catch:{ ClassNotFoundException -> 0x00c7, NoSuchMethodException -> 0x00af, ClassCastException -> 0x0086, InstantiationException -> 0x006f, InvocationTargetException -> 0x0058, IllegalAccessException -> 0x003f }
            L_0x003e:
                throw r4     // Catch:{ ClassNotFoundException -> 0x00c7, NoSuchMethodException -> 0x00af, ClassCastException -> 0x0086, InstantiationException -> 0x006f, InvocationTargetException -> 0x0058, IllegalAccessException -> 0x003f }
            L_0x003f:
                r8 = move-exception
                java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
                java.lang.String r11 = "Failed to create listener: "
                int r0 = r9.length()
                if (r0 == 0) goto L_0x004f
                java.lang.String r9 = r11.concat(r9)
                goto L_0x0054
            L_0x004f:
                java.lang.String r9 = new java.lang.String
                r9.<init>(r11)
            L_0x0054:
                r10.<init>(r9, r8)
                throw r10
            L_0x0058:
                r8 = move-exception
                java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
                int r11 = r9.length()
                if (r11 == 0) goto L_0x0066
                java.lang.String r9 = r0.concat(r9)
                goto L_0x006b
            L_0x0066:
                java.lang.String r9 = new java.lang.String
                r9.<init>(r0)
            L_0x006b:
                r10.<init>(r9, r8)
                throw r10
            L_0x006f:
                r8 = move-exception
                java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
                int r11 = r9.length()
                if (r11 == 0) goto L_0x007d
                java.lang.String r9 = r0.concat(r9)
                goto L_0x0082
            L_0x007d:
                java.lang.String r9 = new java.lang.String
                r9.<init>(r0)
            L_0x0082:
                r10.<init>(r9, r8)
                throw r10
            L_0x0086:
                java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                java.lang.String r10 = r10.getName()
                int r11 = r9.length()
                int r11 = r11 + 17
                int r0 = r10.length()
                int r11 = r11 + r0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>(r11)
                r0.append(r9)
                java.lang.String r9 = " does not extend "
                r0.append(r9)
                r0.append(r10)
                java.lang.String r9 = r0.toString()
                r8.<init>(r9)
                throw r8
            L_0x00af:
                java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                java.lang.String r10 = "Must have no argument constructor for class "
                int r11 = r9.length()
                if (r11 == 0) goto L_0x00be
                java.lang.String r9 = r10.concat(r9)
                goto L_0x00c3
            L_0x00be:
                java.lang.String r9 = new java.lang.String
                r9.<init>(r10)
            L_0x00c3:
                r8.<init>(r9)
                throw r8
            L_0x00c7:
                java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                java.lang.String r10 = "Could not find extra class "
                int r11 = r9.length()
                if (r11 == 0) goto L_0x00d6
                java.lang.String r9 = r10.concat(r9)
                goto L_0x00db
            L_0x00d6:
                java.lang.String r9 = new java.lang.String
                r9.<init>(r10)
            L_0x00db:
                r8.<init>(r9)
                throw r8
            L_0x00df:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.test.internal.runner.RunnerArgs.Builder.I(java.util.List, java.lang.String, java.lang.Class, android.os.Bundle):void");
        }

        public final BufferedReader J(Instrumentation instrumentation, String str) throws IOException {
            Reader reader;
            if (Build.VERSION.SDK_INT >= 26 && instrumentation.getContext().getPackageManager().isInstantApp()) {
                UiAutomation uiAutomation = instrumentation.getUiAutomation();
                String valueOf = String.valueOf(str);
                reader = new InputStreamReader(new ParcelFileDescriptor.AutoCloseInputStream(uiAutomation.executeShellCommand(valueOf.length() != 0 ? "cat ".concat(valueOf) : new String("cat "))));
            } else {
                reader = new FileReader(new File(str));
            }
            return new BufferedReader(reader);
        }

        public final <T> List<Class<? extends T>> K(String str, Class<T> cls) {
            ArrayList arrayList = new ArrayList();
            if (str != null) {
                for (String H : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    H(arrayList, H, cls);
                }
            }
            return arrayList;
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [androidx.test.internal.runner.RunnerArgs$1, java.io.BufferedReader] */
        public final TestFileArgs N(Instrumentation instrumentation, String str) {
            ? r12 = 0;
            TestFileArgs testFileArgs = new TestFileArgs();
            if (str == null) {
                return testFileArgs;
            }
            try {
                BufferedReader J = J(instrumentation, str);
                while (true) {
                    String readLine = J.readLine();
                    if (readLine == null) {
                        try {
                            break;
                        } catch (IOException unused) {
                        }
                    } else if (G(readLine)) {
                        testFileArgs.f11470a.add(R(readLine));
                    } else {
                        testFileArgs.f11471b.addAll(T(W(readLine)));
                    }
                }
                J.close();
                return testFileArgs;
            } catch (FileNotFoundException e11) {
                throw new IllegalArgumentException(str.length() != 0 ? "testfile not found: ".concat(str) : new String("testfile not found: "), e11);
            } catch (IOException e12) {
                throw new IllegalArgumentException(str.length() != 0 ? "Could not read test file ".concat(str) : new String("Could not read test file "), e12);
            } catch (Throwable th2) {
                if (r12 != 0) {
                    try {
                        r12.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th2;
            }
        }

        public final <T> T O(String str, Class<T> cls) {
            List<T> P = P(str, cls, (Bundle) null);
            if (P.isEmpty()) {
                return null;
            }
            if (P.size() <= 1) {
                return P.get(0);
            }
            throw new IllegalArgumentException(String.format("Expected 1 class loader, %d given", new Object[]{Integer.valueOf(P.size())}));
        }

        public final <T> List<T> P(String str, Class<T> cls, Bundle bundle) {
            ArrayList arrayList = new ArrayList();
            if (str != null) {
                for (String I : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    I(arrayList, I, cls, bundle);
                }
            }
            return arrayList;
        }

        public final List<TestArg> S(String str) {
            ArrayList arrayList = new ArrayList();
            if (str != null) {
                for (String R : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    arrayList.add(R(R));
                }
            }
            return arrayList;
        }
    }

    public static final class TestFileArgs {

        /* renamed from: a  reason: collision with root package name */
        public final List<TestArg> f11470a;

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f11471b;

        private TestFileArgs() {
            this.f11470a = new ArrayList();
            this.f11471b = new ArrayList();
        }
    }

    public RunnerArgs(Builder builder) {
        this.f11416a = builder.f11442a;
        this.f11417b = builder.f11443b;
        this.f11418c = builder.f11444c;
        this.f11419d = builder.f11445d;
        this.f11420e = builder.f11446e;
        this.f11421f = builder.f11447f;
        this.f11422g = builder.f11448g;
        this.f11423h = builder.f11449h;
        this.f11424i = builder.f11450i;
        this.f11425j = builder.f11451j;
        this.f11426k = Collections.unmodifiableList(builder.f11452k);
        this.f11427l = builder.f11453l;
        this.f11428m = Collections.unmodifiableList(builder.f11454m);
        this.f11429n = Collections.unmodifiableList(builder.f11455n);
        this.f11430o = Collections.unmodifiableList(builder.f11456o);
        this.f11431p = Collections.unmodifiableList(builder.f11457p);
        this.f11432q = Collections.unmodifiableList(builder.f11458q);
        this.f11433r = builder.f11459r;
        this.f11434s = builder.f11460s;
        this.f11435t = builder.f11461t;
        this.f11436u = Collections.unmodifiableList(builder.f11462u);
        this.f11437v = builder.f11463v;
        this.f11438w = builder.f11464w;
        this.f11439x = builder.f11465x;
        this.A = builder.f11466y;
        this.B = builder.f11467z;
        this.f11441z = Collections.unmodifiableList(builder.B);
        this.f11440y = builder.A;
        this.C = builder.C;
        this.D = builder.D;
    }

    public static class TestArg {

        /* renamed from: a  reason: collision with root package name */
        public final String f11468a;

        /* renamed from: b  reason: collision with root package name */
        public final String f11469b;

        public TestArg(String str, String str2) {
            this.f11468a = str;
            this.f11469b = str2;
        }

        public String toString() {
            String str = this.f11469b;
            if (str == null) {
                return this.f11468a;
            }
            String str2 = this.f11468a;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(str).length());
            sb2.append(str2);
            sb2.append(n0.h.f32179b);
            sb2.append(str);
            return sb2.toString();
        }

        public TestArg(String str) {
            this(str, (String) null);
        }
    }
}
