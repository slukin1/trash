package r20;

import java.lang.reflect.Modifier;
import org.junit.runner.Runner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

public class b extends RunnerBuilder {

    /* renamed from: b  reason: collision with root package name */
    public final RunnerBuilder f25623b;

    public b(RunnerBuilder runnerBuilder) {
        this.f25623b = runnerBuilder;
    }

    public Runner a(Class<?> cls) throws Exception {
        Class<?> cls2 = cls;
        while (cls2 != null) {
            org.junit.runner.b bVar = (org.junit.runner.b) cls2.getAnnotation(org.junit.runner.b.class);
            if (bVar != null) {
                return c(bVar.value(), cls);
            }
            cls2 = d(cls2);
        }
        return null;
    }

    public Runner c(Class<? extends Runner> cls, Class<?> cls2) throws Exception {
        try {
            return (Runner) cls.getConstructor(new Class[]{Class.class}).newInstance(new Object[]{cls2});
        } catch (NoSuchMethodException unused) {
            try {
                return (Runner) cls.getConstructor(new Class[]{Class.class, RunnerBuilder.class}).newInstance(new Object[]{cls2, this.f25623b});
            } catch (NoSuchMethodException unused2) {
                String simpleName = cls.getSimpleName();
                throw new InitializationError(String.format("Custom runner class %s should have a public constructor with signature %s(Class testClass)", new Object[]{simpleName, simpleName}));
            }
        }
    }

    public final Class<?> d(Class<?> cls) {
        if (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
            return null;
        }
        return cls.getEnclosingClass();
    }
}
