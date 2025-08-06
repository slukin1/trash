package androidx.test.internal.runner;

import androidx.test.internal.runner.junit3.AndroidJUnit3Builder;
import androidx.test.internal.runner.junit3.AndroidSuiteBuilder;
import androidx.test.internal.runner.junit4.AndroidAnnotatedBuilder;
import androidx.test.internal.runner.junit4.AndroidJUnit4Builder;
import androidx.test.internal.util.AndroidRunnerParams;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.junit.internal.builders.IgnoredBuilder;
import org.junit.internal.builders.JUnit3Builder;
import org.junit.internal.builders.JUnit4Builder;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;
import r20.a;
import r20.b;

class AndroidRunnerBuilder extends a {

    /* renamed from: c  reason: collision with root package name */
    public final AndroidJUnit3Builder f11387c;

    /* renamed from: d  reason: collision with root package name */
    public final AndroidJUnit4Builder f11388d;

    /* renamed from: e  reason: collision with root package name */
    public final AndroidSuiteBuilder f11389e;

    /* renamed from: f  reason: collision with root package name */
    public final AndroidAnnotatedBuilder f11390f;

    /* renamed from: g  reason: collision with root package name */
    public final IgnoredBuilder f11391g;

    /* renamed from: h  reason: collision with root package name */
    public final List<RunnerBuilder> f11392h;

    public AndroidRunnerBuilder(AndroidRunnerParams androidRunnerParams, boolean z11, List<Class<? extends RunnerBuilder>> list) {
        this((RunnerBuilder) null, androidRunnerParams, z11, list);
    }

    public Runner a(Class<?> cls) throws Throwable {
        for (RunnerBuilder b11 : this.f11392h) {
            Runner b12 = b11.b(cls);
            if (b12 != null) {
                return b12;
            }
        }
        return super.a(cls);
    }

    public b c() {
        return this.f11390f;
    }

    public IgnoredBuilder d() {
        return this.f11391g;
    }

    public JUnit3Builder e() {
        return this.f11387c;
    }

    public JUnit4Builder f() {
        return this.f11388d;
    }

    public RunnerBuilder g() {
        return this.f11389e;
    }

    public final List<RunnerBuilder> h(List<Class<? extends RunnerBuilder>> list) {
        ArrayList arrayList = new ArrayList();
        for (Class next : list) {
            try {
                arrayList.add((RunnerBuilder) next.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (InstantiationException e11) {
                String valueOf = String.valueOf(next);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 113);
                sb2.append("Could not create instance of ");
                sb2.append(valueOf);
                sb2.append(", make sure that it is a public concrete class with a public no-argument constructor");
                throw new IllegalStateException(sb2.toString(), e11);
            } catch (IllegalAccessException e12) {
                String valueOf2 = String.valueOf(next);
                StringBuilder sb3 = new StringBuilder(valueOf2.length() + 113);
                sb3.append("Could not create instance of ");
                sb3.append(valueOf2);
                sb3.append(", make sure that it is a public concrete class with a public no-argument constructor");
                throw new IllegalStateException(sb3.toString(), e12);
            } catch (NoSuchMethodException e13) {
                String valueOf3 = String.valueOf(next);
                StringBuilder sb4 = new StringBuilder(valueOf3.length() + 113);
                sb4.append("Could not create instance of ");
                sb4.append(valueOf3);
                sb4.append(", make sure that it is a public concrete class with a public no-argument constructor");
                throw new IllegalStateException(sb4.toString(), e13);
            } catch (InvocationTargetException e14) {
                String valueOf4 = String.valueOf(next);
                StringBuilder sb5 = new StringBuilder(valueOf4.length() + 74);
                sb5.append("Could not create instance of ");
                sb5.append(valueOf4);
                sb5.append(", the constructor must not throw an exception");
                throw new IllegalStateException(sb5.toString(), e14);
            }
        }
        return arrayList;
    }

    public AndroidRunnerBuilder(RunnerBuilder runnerBuilder, AndroidRunnerParams androidRunnerParams, boolean z11, List<Class<? extends RunnerBuilder>> list) {
        super(true);
        this.f11387c = new AndroidJUnit3Builder(androidRunnerParams, z11);
        this.f11388d = new AndroidJUnit4Builder(androidRunnerParams, z11);
        this.f11389e = new AndroidSuiteBuilder(androidRunnerParams);
        this.f11390f = new AndroidAnnotatedBuilder(runnerBuilder == null ? this : runnerBuilder, androidRunnerParams);
        this.f11391g = new IgnoredBuilder();
        this.f11392h = h(list);
    }
}
