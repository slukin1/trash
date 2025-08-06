package junit.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class TestCase extends Assert implements Test {
    private String fName;

    public TestCase() {
        this.fName = null;
    }

    public static void assertEquals(String str, Object obj, Object obj2) {
        Assert.assertEquals(str, obj, obj2);
    }

    public static void assertFalse(String str, boolean z11) {
        Assert.assertFalse(str, z11);
    }

    public static void assertNotNull(Object obj) {
        Assert.assertNotNull(obj);
    }

    public static void assertNotSame(String str, Object obj, Object obj2) {
        Assert.assertNotSame(str, obj, obj2);
    }

    public static void assertNull(Object obj) {
        Assert.assertNull(obj);
    }

    public static void assertSame(String str, Object obj, Object obj2) {
        Assert.assertSame(str, obj, obj2);
    }

    public static void assertTrue(String str, boolean z11) {
        Assert.assertTrue(str, z11);
    }

    public static void fail(String str) {
        Assert.fail(str);
    }

    public static void failNotEquals(String str, Object obj, Object obj2) {
        Assert.failNotEquals(str, obj, obj2);
    }

    public static void failNotSame(String str, Object obj, Object obj2) {
        Assert.failNotSame(str, obj, obj2);
    }

    public static void failSame(String str) {
        Assert.failSame(str);
    }

    public static String format(String str, Object obj, Object obj2) {
        return Assert.format(str, obj, obj2);
    }

    public int countTestCases() {
        return 1;
    }

    public TestResult createResult() {
        return new TestResult();
    }

    public String getName() {
        return this.fName;
    }

    public TestResult run() {
        TestResult createResult = createResult();
        run(createResult);
        return createResult;
    }

    public void runBare() throws Throwable {
        setUp();
        try {
            runTest();
            try {
                tearDown();
                th = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable unused) {
        }
        if (th != null) {
            throw th;
        }
    }

    public void runTest() throws Throwable {
        assertNotNull("TestCase.fName cannot be null", this.fName);
        Method method = null;
        try {
            method = getClass().getMethod(this.fName, (Class[]) null);
        } catch (NoSuchMethodException unused) {
            fail("Method \"" + this.fName + "\" not found");
        }
        if (!Modifier.isPublic(method.getModifiers())) {
            fail("Method \"" + this.fName + "\" should be public");
        }
        try {
            method.invoke(this, new Object[0]);
        } catch (InvocationTargetException e11) {
            e11.fillInStackTrace();
            throw e11.getTargetException();
        } catch (IllegalAccessException e12) {
            e12.fillInStackTrace();
            throw e12;
        }
    }

    public void setName(String str) {
        this.fName = str;
    }

    public void setUp() throws Exception {
    }

    public void tearDown() throws Exception {
    }

    public String toString() {
        return getName() + "(" + getClass().getName() + ")";
    }

    public static void assertEquals(Object obj, Object obj2) {
        Assert.assertEquals(obj, obj2);
    }

    public static void assertFalse(boolean z11) {
        Assert.assertFalse(z11);
    }

    public static void assertNotNull(String str, Object obj) {
        Assert.assertNotNull(str, obj);
    }

    public static void assertNotSame(Object obj, Object obj2) {
        Assert.assertNotSame(obj, obj2);
    }

    public static void assertNull(String str, Object obj) {
        Assert.assertNull(str, obj);
    }

    public static void assertSame(Object obj, Object obj2) {
        Assert.assertSame(obj, obj2);
    }

    public static void assertTrue(boolean z11) {
        Assert.assertTrue(z11);
    }

    public static void fail() {
        Assert.fail();
    }

    public TestCase(String str) {
        this.fName = str;
    }

    public static void assertEquals(String str, String str2, String str3) {
        Assert.assertEquals(str, str2, str3);
    }

    public void run(TestResult testResult) {
        testResult.f(this);
    }

    public static void assertEquals(String str, String str2) {
        Assert.assertEquals(str, str2);
    }

    public static void assertEquals(String str, double d11, double d12, double d13) {
        Assert.assertEquals(str, d11, d12, d13);
    }

    public static void assertEquals(double d11, double d12, double d13) {
        Assert.assertEquals(d11, d12, d13);
    }

    public static void assertEquals(String str, float f11, float f12, float f13) {
        Assert.assertEquals(str, f11, f12, f13);
    }

    public static void assertEquals(float f11, float f12, float f13) {
        Assert.assertEquals(f11, f12, f13);
    }

    public static void assertEquals(String str, long j11, long j12) {
        Assert.assertEquals(str, j11, j12);
    }

    public static void assertEquals(long j11, long j12) {
        Assert.assertEquals(j11, j12);
    }

    public static void assertEquals(String str, boolean z11, boolean z12) {
        Assert.assertEquals(str, z11, z12);
    }

    public static void assertEquals(boolean z11, boolean z12) {
        Assert.assertEquals(z11, z12);
    }

    public static void assertEquals(String str, byte b11, byte b12) {
        Assert.assertEquals(str, b11, b12);
    }

    public static void assertEquals(byte b11, byte b12) {
        Assert.assertEquals(b11, b12);
    }

    public static void assertEquals(String str, char c11, char c12) {
        Assert.assertEquals(str, c11, c12);
    }

    public static void assertEquals(char c11, char c12) {
        Assert.assertEquals(c11, c12);
    }

    public static void assertEquals(String str, short s11, short s12) {
        Assert.assertEquals(str, s11, s12);
    }

    public static void assertEquals(short s11, short s12) {
        Assert.assertEquals(s11, s12);
    }

    public static void assertEquals(String str, int i11, int i12) {
        Assert.assertEquals(str, i11, i12);
    }

    public static void assertEquals(int i11, int i12) {
        Assert.assertEquals(i11, i12);
    }
}
