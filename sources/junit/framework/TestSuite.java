package junit.framework;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class TestSuite implements Test {

    /* renamed from: a  reason: collision with root package name */
    public String f56533a;

    /* renamed from: b  reason: collision with root package name */
    public Vector<Test> f56534b = new Vector<>(10);

    public static class a extends TestCase {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f56535a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, String str2) {
            super(str);
            this.f56535a = str2;
        }

        public void runTest() {
            TestCase.fail(this.f56535a);
        }
    }

    public TestSuite() {
    }

    public static Test e(Class<?> cls, String str) {
        Object obj;
        try {
            Constructor<?> h11 = h(cls);
            try {
                if (h11.getParameterTypes().length == 0) {
                    obj = h11.newInstance(new Object[0]);
                    if (obj instanceof TestCase) {
                        ((TestCase) obj).setName(str);
                    }
                } else {
                    obj = h11.newInstance(new Object[]{str});
                }
                return (Test) obj;
            } catch (InstantiationException e11) {
                return o("Cannot instantiate test case: " + str + " (" + f(e11) + ")");
            } catch (InvocationTargetException e12) {
                return o("Exception in constructor: " + str + " (" + f(e12.getTargetException()) + ")");
            } catch (IllegalAccessException e13) {
                return o("Cannot access test case: " + str + " (" + f(e13) + ")");
            }
        } catch (NoSuchMethodException unused) {
            return o("Class " + cls.getName() + " has no public constructor TestCase(String name) or TestCase()");
        }
    }

    public static String f(Throwable th2) {
        StringWriter stringWriter = new StringWriter();
        th2.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static Constructor<?> h(Class<?> cls) throws NoSuchMethodException {
        try {
            return cls.getConstructor(new Class[]{String.class});
        } catch (NoSuchMethodException unused) {
            return cls.getConstructor(new Class[0]);
        }
    }

    public static Test o(String str) {
        return new a("warning", str);
    }

    public void b(Test test) {
        this.f56534b.add(test);
    }

    public final void c(Method method, List<String> list, Class<?> cls) {
        String name = method.getName();
        if (!list.contains(name)) {
            if (i(method)) {
                list.add(name);
                b(e(cls, name));
            } else if (j(method)) {
                b(o("Test method isn't public: " + method.getName() + "(" + cls.getCanonicalName() + ")"));
            }
        }
    }

    public int countTestCases() {
        Iterator<Test> it2 = this.f56534b.iterator();
        int i11 = 0;
        while (it2.hasNext()) {
            i11 += it2.next().countTestCases();
        }
        return i11;
    }

    public final void d(Class<?> cls) {
        this.f56533a = cls.getName();
        try {
            h(cls);
            if (!Modifier.isPublic(cls.getModifiers())) {
                b(o("Class " + cls.getName() + " is not public"));
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Class<?> cls2 = cls; Test.class.isAssignableFrom(cls2); cls2 = cls2.getSuperclass()) {
                for (Method c11 : q20.a.a(cls2)) {
                    c(c11, arrayList, cls);
                }
            }
            if (this.f56534b.size() == 0) {
                b(o("No tests found in " + cls.getName()));
            }
        } catch (NoSuchMethodException unused) {
            b(o("Class " + cls.getName() + " has no public constructor TestCase(String name) or TestCase()"));
        }
    }

    public String g() {
        return this.f56533a;
    }

    public final boolean i(Method method) {
        return j(method) && Modifier.isPublic(method.getModifiers());
    }

    public final boolean j(Method method) {
        return method.getParameterTypes().length == 0 && method.getName().startsWith("test") && method.getReturnType().equals(Void.TYPE);
    }

    public void k(Test test, TestResult testResult) {
        test.run(testResult);
    }

    public void l(String str) {
        this.f56533a = str;
    }

    public Test m(int i11) {
        return this.f56534b.get(i11);
    }

    public int n() {
        return this.f56534b.size();
    }

    public void run(TestResult testResult) {
        Iterator<Test> it2 = this.f56534b.iterator();
        while (it2.hasNext()) {
            Test next = it2.next();
            if (!testResult.h()) {
                k(next, testResult);
            } else {
                return;
            }
        }
    }

    public String toString() {
        if (g() != null) {
            return g();
        }
        return super.toString();
    }

    public TestSuite(Class<?> cls) {
        d(cls);
    }

    public TestSuite(String str) {
        l(str);
    }
}
