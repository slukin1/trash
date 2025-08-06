package junit.framework;

@Deprecated
public class Assert {
    public static void assertEquals(String str, Object obj, Object obj2) {
        if (obj != null || obj2 != null) {
            if (obj == null || !obj.equals(obj2)) {
                failNotEquals(str, obj, obj2);
            }
        }
    }

    public static void assertFalse(String str, boolean z11) {
        assertTrue(str, !z11);
    }

    public static void assertNotNull(Object obj) {
        assertNotNull((String) null, obj);
    }

    public static void assertNotSame(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            failSame(str);
        }
    }

    public static void assertNull(Object obj) {
        if (obj != null) {
            assertNull("Expected: <null> but was: " + obj.toString(), obj);
        }
    }

    public static void assertSame(String str, Object obj, Object obj2) {
        if (obj != obj2) {
            failNotSame(str, obj, obj2);
        }
    }

    public static void assertTrue(String str, boolean z11) {
        if (!z11) {
            fail(str);
        }
    }

    public static void fail(String str) {
        if (str == null) {
            throw new AssertionFailedError();
        }
        throw new AssertionFailedError(str);
    }

    public static void failNotEquals(String str, Object obj, Object obj2) {
        fail(format(str, obj, obj2));
    }

    public static void failNotSame(String str, Object obj, Object obj2) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        fail(str2 + "expected same:<" + obj + "> was not:<" + obj2 + ">");
    }

    public static void failSame(String str) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        fail(str2 + "expected not same");
    }

    public static String format(String str, Object obj, Object obj2) {
        String str2;
        if (str == null || str.length() <= 0) {
            str2 = "";
        } else {
            str2 = str + " ";
        }
        return str2 + "expected:<" + obj + "> but was:<" + obj2 + ">";
    }

    public static void assertFalse(boolean z11) {
        assertFalse((String) null, z11);
    }

    public static void assertNotNull(String str, Object obj) {
        assertTrue(str, obj != null);
    }

    public static void assertNotSame(Object obj, Object obj2) {
        assertNotSame((String) null, obj, obj2);
    }

    public static void assertNull(String str, Object obj) {
        assertTrue(str, obj == null);
    }

    public static void assertSame(Object obj, Object obj2) {
        assertSame((String) null, obj, obj2);
    }

    public static void assertTrue(boolean z11) {
        assertTrue((String) null, z11);
    }

    public static void assertEquals(Object obj, Object obj2) {
        assertEquals((String) null, obj, obj2);
    }

    public static void fail() {
        fail((String) null);
    }

    public static void assertEquals(String str, String str2, String str3) {
        if (str2 != null || str3 != null) {
            if (str2 == null || !str2.equals(str3)) {
                if (str == null) {
                    str = "";
                }
                throw new ComparisonFailure(str, str2, str3);
            }
        }
    }

    public static void assertEquals(String str, String str2) {
        assertEquals((String) null, str, str2);
    }

    public static void assertEquals(String str, double d11, double d12, double d13) {
        if (Double.compare(d11, d12) != 0 && Math.abs(d11 - d12) > d13) {
            failNotEquals(str, new Double(d11), new Double(d12));
        }
    }

    public static void assertEquals(double d11, double d12, double d13) {
        assertEquals((String) null, d11, d12, d13);
    }

    public static void assertEquals(String str, float f11, float f12, float f13) {
        if (Float.compare(f11, f12) != 0 && Math.abs(f11 - f12) > f13) {
            failNotEquals(str, new Float(f11), new Float(f12));
        }
    }

    public static void assertEquals(float f11, float f12, float f13) {
        assertEquals((String) null, f11, f12, f13);
    }

    public static void assertEquals(String str, long j11, long j12) {
        assertEquals(str, (Object) Long.valueOf(j11), (Object) Long.valueOf(j12));
    }

    public static void assertEquals(long j11, long j12) {
        assertEquals((String) null, j11, j12);
    }

    public static void assertEquals(String str, boolean z11, boolean z12) {
        assertEquals(str, (Object) Boolean.valueOf(z11), (Object) Boolean.valueOf(z12));
    }

    public static void assertEquals(boolean z11, boolean z12) {
        assertEquals((String) null, z11, z12);
    }

    public static void assertEquals(String str, byte b11, byte b12) {
        assertEquals(str, (Object) Byte.valueOf(b11), (Object) Byte.valueOf(b12));
    }

    public static void assertEquals(byte b11, byte b12) {
        assertEquals((String) null, b11, b12);
    }

    public static void assertEquals(String str, char c11, char c12) {
        assertEquals(str, (Object) Character.valueOf(c11), (Object) Character.valueOf(c12));
    }

    public static void assertEquals(char c11, char c12) {
        assertEquals((String) null, c11, c12);
    }

    public static void assertEquals(String str, short s11, short s12) {
        assertEquals(str, (Object) Short.valueOf(s11), (Object) Short.valueOf(s12));
    }

    public static void assertEquals(short s11, short s12) {
        assertEquals((String) null, s11, s12);
    }

    public static void assertEquals(String str, int i11, int i12) {
        assertEquals(str, (Object) Integer.valueOf(i11), (Object) Integer.valueOf(i12));
    }

    public static void assertEquals(int i11, int i12) {
        assertEquals((String) null, i11, i12);
    }
}
