package androidx.test.internal.runner;

import android.app.Instrumentation;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;
import androidx.test.filters.Suppress;
import androidx.test.internal.runner.ClassPathScanner;
import androidx.test.internal.runner.RunnerArgs;
import androidx.test.internal.util.AndroidRunnerParams;
import androidx.test.internal.util.Checks;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.junit.runner.Description;
import org.junit.runner.Request;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;
import w20.c;

public class TestRequestBuilder {

    /* renamed from: p  reason: collision with root package name */
    public static final String[] f11482p = {"junit", "org.junit", "org.hamcrest", "org.mockito", "androidx.test.internal.runner.junit3", "org.jacoco", "net.bytebuddy"};

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f11483a;

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f11484b;

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f11485c;

    /* renamed from: d  reason: collision with root package name */
    public Set<String> f11486d;

    /* renamed from: e  reason: collision with root package name */
    public Set<String> f11487e;

    /* renamed from: f  reason: collision with root package name */
    public ClassAndMethodFilter f11488f;

    /* renamed from: g  reason: collision with root package name */
    public Filter f11489g;

    /* renamed from: h  reason: collision with root package name */
    public List<Class<? extends RunnerBuilder>> f11490h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f11491i;

    /* renamed from: j  reason: collision with root package name */
    public final DeviceBuild f11492j;

    /* renamed from: k  reason: collision with root package name */
    public long f11493k;

    /* renamed from: l  reason: collision with root package name */
    public final Instrumentation f11494l;

    /* renamed from: m  reason: collision with root package name */
    public final Bundle f11495m;

    /* renamed from: n  reason: collision with root package name */
    public ClassLoader f11496n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f11497o;

    public static class AnnotationExclusionFilter extends ParentFilter {

        /* renamed from: b  reason: collision with root package name */
        public final Class<? extends Annotation> f11498b;

        public AnnotationExclusionFilter(Class<? extends Annotation> cls) {
            super();
            this.f11498b = cls;
        }

        public boolean d(Description description) {
            Class<?> testClass = description.getTestClass();
            return (testClass == null || !testClass.isAnnotationPresent(this.f11498b)) && description.getAnnotation(this.f11498b) == null;
        }
    }

    public static class AnnotationInclusionFilter extends ParentFilter {

        /* renamed from: b  reason: collision with root package name */
        public final Class<? extends Annotation> f11499b;

        public AnnotationInclusionFilter(Class<? extends Annotation> cls) {
            super();
            this.f11499b = cls;
        }

        public boolean d(Description description) {
            Class<?> testClass = description.getTestClass();
            return description.getAnnotation(this.f11499b) != null || (testClass != null && testClass.isAnnotationPresent(this.f11499b));
        }
    }

    public static class BlankRunner extends Runner {
        private BlankRunner() {
        }

        public void b(RunNotifier runNotifier) {
        }

        public Description getDescription() {
            return Description.createSuiteDescription("no tests found", new Annotation[0]);
        }
    }

    public static class ClassAndMethodFilter extends ParentFilter {

        /* renamed from: b  reason: collision with root package name */
        public Map<String, MethodFilter> f11500b;

        private ClassAndMethodFilter() {
            super();
            this.f11500b = new HashMap();
        }

        public boolean d(Description description) {
            MethodFilter methodFilter;
            if (!this.f11500b.isEmpty() && (methodFilter = this.f11500b.get(description.getClassName())) != null) {
                return methodFilter.c(description);
            }
            return true;
        }

        public void e(String str, String str2) {
            MethodFilter methodFilter = this.f11500b.get(str);
            if (methodFilter == null) {
                methodFilter = new MethodFilter(str);
                this.f11500b.put(str, methodFilter);
            }
            methodFilter.f(str2);
        }

        public void f(String str, String str2) {
            MethodFilter methodFilter = this.f11500b.get(str);
            if (methodFilter == null) {
                methodFilter = new MethodFilter(str);
                this.f11500b.put(str, methodFilter);
            }
            methodFilter.e(str2);
        }
    }

    public interface DeviceBuild {
        int a();

        String b();
    }

    public static class DeviceBuildImpl implements DeviceBuild {
        private DeviceBuildImpl() {
        }

        public int a() {
            return Build.VERSION.SDK_INT;
        }

        public String b() {
            return Build.HARDWARE;
        }
    }

    public static class ExtendedSuite extends c {
        public ExtendedSuite(List<Runner> list) throws InitializationError {
            super((Class<?>) null, list);
        }

        public static c D(List<Runner> list) {
            try {
                return new ExtendedSuite(list);
            } catch (InitializationError unused) {
                String name = c.class.getName();
                StringBuilder sb2 = new StringBuilder(name.length() + 107);
                sb2.append("Internal Error: ");
                sb2.append(name);
                sb2.append("(Class<?>, List<Runner>) should never throw an InitializationError when passed a null Class");
                throw new RuntimeException(sb2.toString());
            }
        }
    }

    public static class LenientFilterRequest extends Request {

        /* renamed from: a  reason: collision with root package name */
        public final Request f11501a;

        /* renamed from: b  reason: collision with root package name */
        public final Filter f11502b;

        public LenientFilterRequest(Request request, Filter filter) {
            this.f11501a = request;
            this.f11502b = filter;
        }

        public Runner a() {
            try {
                Runner a11 = this.f11501a.a();
                this.f11502b.a(a11);
                return a11;
            } catch (NoTestsRemainException unused) {
                return new BlankRunner();
            }
        }
    }

    public static class MethodFilter extends ParentFilter {

        /* renamed from: b  reason: collision with root package name */
        public final String f11503b;

        /* renamed from: c  reason: collision with root package name */
        public Set<String> f11504c = new HashSet();

        /* renamed from: d  reason: collision with root package name */
        public Set<String> f11505d = new HashSet();

        public MethodFilter(String str) {
            super();
            this.f11503b = str;
        }

        public boolean d(Description description) {
            String methodName = description.getMethodName();
            if (methodName == null) {
                return false;
            }
            String g11 = g(methodName);
            if (this.f11505d.contains(g11)) {
                return false;
            }
            if (this.f11504c.isEmpty() || this.f11504c.contains(g11) || g11.equals("initializationError")) {
                return true;
            }
            return false;
        }

        public void e(String str) {
            this.f11505d.add(str);
        }

        public void f(String str) {
            this.f11504c.add(str);
        }

        public final String g(String str) {
            return Pattern.compile(".+(\\[[0-9]+\\])$").matcher(str).matches() ? str.substring(0, str.lastIndexOf(91)) : str;
        }
    }

    public static abstract class ParentFilter extends Filter {
        private ParentFilter() {
        }

        public boolean c(Description description) {
            if (description.isTest()) {
                return d(description);
            }
            Iterator<Description> it2 = description.getChildren().iterator();
            while (it2.hasNext()) {
                if (c(it2.next())) {
                    return true;
                }
            }
            return false;
        }

        public abstract boolean d(Description description);
    }

    public class RequiresDeviceFilter extends AnnotationExclusionFilter {

        /* renamed from: c  reason: collision with root package name */
        public final Set<String> f11506c = new HashSet(Arrays.asList(new String[]{"goldfish", "ranchu", "gce_x86"}));

        public RequiresDeviceFilter() {
            super(RequiresDevice.class);
        }

        public boolean d(Description description) {
            if (!super.d(description)) {
                return !this.f11506c.contains(TestRequestBuilder.this.r());
            }
            return true;
        }
    }

    public class SdkSuppressFilter extends ParentFilter {
        public SdkSuppressFilter() {
            super();
        }

        public boolean d(Description description) {
            SdkSuppress e11 = e(description);
            if (e11 == null) {
                return true;
            }
            if (TestRequestBuilder.this.s() < e11.minSdkVersion() || TestRequestBuilder.this.s() > e11.maxSdkVersion()) {
                return false;
            }
            return true;
        }

        public final SdkSuppress e(Description description) {
            SdkSuppress sdkSuppress = (SdkSuppress) description.getAnnotation(SdkSuppress.class);
            if (sdkSuppress != null) {
                return sdkSuppress;
            }
            Class<?> testClass = description.getTestClass();
            if (testClass != null) {
                return (SdkSuppress) testClass.getAnnotation(SdkSuppress.class);
            }
            return null;
        }
    }

    public static class ShardingFilter extends Filter {

        /* renamed from: b  reason: collision with root package name */
        public final int f11509b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11510c;

        public ShardingFilter(int i11, int i12) {
            this.f11509b = i11;
            this.f11510c = i12;
        }

        public boolean c(Description description) {
            if (!description.isTest() || Math.abs(description.hashCode()) % this.f11509b == this.f11510c) {
                return true;
            }
            return false;
        }
    }

    public static class SizeFilter extends ParentFilter {

        /* renamed from: b  reason: collision with root package name */
        public final TestSize f11511b;

        public SizeFilter(TestSize testSize) {
            super();
            this.f11511b = testSize;
        }

        public boolean d(Description description) {
            if (this.f11511b.k(description)) {
                return true;
            }
            if (!this.f11511b.j(description)) {
                return false;
            }
            for (Annotation annotationType : description.getAnnotations()) {
                if (TestSize.h(annotationType.annotationType())) {
                    return false;
                }
            }
            return true;
        }
    }

    public TestRequestBuilder(Instrumentation instrumentation, Bundle bundle) {
        this(new DeviceBuildImpl(), instrumentation, bundle);
    }

    public TestRequestBuilder A(boolean z11) {
        this.f11491i = z11;
        return this;
    }

    public final void B(Set<String> set) {
        if (set.isEmpty() && this.f11483a.isEmpty()) {
            throw new IllegalArgumentException("Must provide either classes to run, or paths to scan");
        } else if ((!this.f11484b.isEmpty() || !this.f11485c.isEmpty()) && !set.isEmpty()) {
            throw new IllegalArgumentException("Ambiguous arguments: cannot provide both test package and test class(es) to run");
        }
    }

    public TestRequestBuilder c(String str) {
        Class<? extends Annotation> u11 = u(str);
        if (u11 != null) {
            f(new AnnotationExclusionFilter(u11));
        }
        return this;
    }

    public TestRequestBuilder d(String str) {
        Class<? extends Annotation> u11 = u(str);
        if (u11 != null) {
            f(new AnnotationInclusionFilter(u11));
        }
        return this;
    }

    public TestRequestBuilder e(Class<? extends RunnerBuilder> cls) {
        this.f11490h.add(cls);
        return this;
    }

    public TestRequestBuilder f(Filter filter) {
        this.f11489g = this.f11489g.b(filter);
        return this;
    }

    public TestRequestBuilder g(RunnerArgs runnerArgs) {
        int i11;
        for (RunnerArgs.TestArg next : runnerArgs.f11431p) {
            String str = next.f11469b;
            if (str == null) {
                k(next.f11468a);
            } else {
                l(next.f11468a, str);
            }
        }
        for (RunnerArgs.TestArg next2 : runnerArgs.f11432q) {
            String str2 = next2.f11469b;
            if (str2 == null) {
                v(next2.f11468a);
            } else {
                w(next2.f11468a, str2);
            }
        }
        for (String m11 : runnerArgs.f11422g) {
            m(m11);
        }
        for (String x11 : runnerArgs.f11423h) {
            x(x11);
        }
        String str3 = runnerArgs.f11424i;
        if (str3 != null) {
            n(TestSize.b(str3));
        }
        String str4 = runnerArgs.f11425j;
        if (str4 != null) {
            d(str4);
        }
        for (String c11 : runnerArgs.f11426k) {
            c(c11);
        }
        for (Filter f11 : runnerArgs.f11429n) {
            f(f11);
        }
        long j11 = runnerArgs.f11427l;
        if (j11 > 0) {
            z(j11);
        }
        int i12 = runnerArgs.f11433r;
        if (i12 > 0 && (i11 = runnerArgs.f11434s) >= 0 && i11 < i12) {
            j(i12, i11);
        }
        if (runnerArgs.f11421f) {
            A(true);
        }
        ClassLoader classLoader = runnerArgs.f11437v;
        if (classLoader != null) {
            y(classLoader);
        }
        for (Class<? extends RunnerBuilder> e11 : runnerArgs.f11430o) {
            e(e11);
        }
        return this;
    }

    public TestRequestBuilder h(String str) {
        this.f11483a.add(str);
        return this;
    }

    public TestRequestBuilder i(Iterable<String> iterable) {
        for (String h11 : iterable) {
            h(h11);
        }
        return this;
    }

    public TestRequestBuilder j(int i11, int i12) {
        return f(new ShardingFilter(i11, i12));
    }

    public TestRequestBuilder k(String str) {
        this.f11486d.add(str);
        return this;
    }

    public TestRequestBuilder l(String str, String str2) {
        this.f11486d.add(str);
        this.f11488f.e(str, str2);
        return this;
    }

    public TestRequestBuilder m(String str) {
        this.f11484b.add(str);
        return this;
    }

    public TestRequestBuilder n(TestSize testSize) {
        if (!TestSize.f11515h.equals(testSize)) {
            f(new SizeFilter(testSize));
        } else {
            Log.e("TestRequestBuilder", String.format("Unrecognized test size '%s'", new Object[]{testSize.f()}));
        }
        return this;
    }

    public Request o() {
        Collection collection;
        this.f11484b.removeAll(this.f11485c);
        this.f11486d.removeAll(this.f11487e);
        B(this.f11486d);
        boolean isEmpty = this.f11486d.isEmpty();
        TestLoader e11 = TestLoader.e(this.f11496n, t(new AndroidRunnerParams(this.f11494l, this.f11495m, this.f11493k, this.f11497o || isEmpty), isEmpty), isEmpty);
        if (isEmpty) {
            collection = q();
        } else {
            collection = this.f11486d;
        }
        return new LenientFilterRequest(Request.b(ExtendedSuite.D(e11.c(collection, isEmpty))), this.f11489g);
    }

    public ClassPathScanner p(List<String> list) {
        return new ClassPathScanner(list);
    }

    public final Collection<String> q() {
        if (!this.f11483a.isEmpty()) {
            Log.i("TestRequestBuilder", String.format("Scanning classpath to find tests in paths %s", new Object[]{this.f11483a}));
            ClassPathScanner p11 = p(this.f11483a);
            ClassPathScanner.ChainedClassNameFilter chainedClassNameFilter = new ClassPathScanner.ChainedClassNameFilter();
            chainedClassNameFilter.b(new ClassPathScanner.ExternalClassNameFilter());
            for (String str : f11482p) {
                if (!this.f11484b.contains(str)) {
                    this.f11485c.add(str);
                }
            }
            if (!this.f11484b.isEmpty()) {
                chainedClassNameFilter.b(new ClassPathScanner.InclusivePackageNamesFilter(this.f11484b));
            }
            for (String excludePackageNameFilter : this.f11485c) {
                chainedClassNameFilter.b(new ClassPathScanner.ExcludePackageNameFilter(excludePackageNameFilter));
            }
            chainedClassNameFilter.b(new ClassPathScanner.ExcludeClassNamesFilter(this.f11487e));
            try {
                return p11.b(chainedClassNameFilter);
            } catch (IOException e11) {
                Log.e("TestRequestBuilder", "Failed to scan classes", e11);
                return Collections.emptyList();
            }
        } else {
            throw new IllegalStateException("neither test class to execute or class paths were provided");
        }
    }

    public final String r() {
        return this.f11492j.b();
    }

    public final int s() {
        return this.f11492j.a();
    }

    public final RunnerBuilder t(AndroidRunnerParams androidRunnerParams, boolean z11) {
        if (this.f11491i) {
            return new AndroidLogOnlyBuilder(androidRunnerParams, z11, this.f11490h);
        }
        return new AndroidRunnerBuilder(androidRunnerParams, z11, this.f11490h);
    }

    public final Class<? extends Annotation> u(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            Log.e("TestRequestBuilder", String.format("Could not find annotation class: %s", new Object[]{str}));
            return null;
        } catch (ClassCastException unused2) {
            Log.e("TestRequestBuilder", String.format("Class %s is not an annotation", new Object[]{str}));
            return null;
        }
    }

    public TestRequestBuilder v(String str) {
        this.f11487e.add(str);
        return this;
    }

    public TestRequestBuilder w(String str, String str2) {
        this.f11488f.f(str, str2);
        return this;
    }

    public TestRequestBuilder x(String str) {
        this.f11485c.add(str);
        return this;
    }

    public TestRequestBuilder y(ClassLoader classLoader) {
        this.f11496n = classLoader;
        return this;
    }

    public TestRequestBuilder z(long j11) {
        this.f11493k = j11;
        return this;
    }

    public TestRequestBuilder(DeviceBuild deviceBuild, Instrumentation instrumentation, Bundle bundle) {
        this.f11483a = new ArrayList();
        this.f11484b = new HashSet();
        this.f11485c = new HashSet();
        this.f11486d = new HashSet();
        this.f11487e = new HashSet();
        this.f11488f = new ClassAndMethodFilter();
        this.f11489g = new AnnotationExclusionFilter(Suppress.class).b(new AnnotationExclusionFilter(android.test.suitebuilder.annotation.Suppress.class)).b(new SdkSuppressFilter()).b(new RequiresDeviceFilter()).b(this.f11488f);
        this.f11490h = new ArrayList();
        this.f11491i = false;
        this.f11493k = 0;
        this.f11497o = false;
        this.f11492j = (DeviceBuild) Checks.b(deviceBuild);
        this.f11494l = (Instrumentation) Checks.b(instrumentation);
        this.f11495m = (Bundle) Checks.b(bundle);
    }
}
