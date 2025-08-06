package androidx.profileinstaller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Map;
import java.util.TreeMap;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;

public class m {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f10508a = {ISO7816.INS_MANAGE_CHANNEL, 114, ISOFileInfo.FCI_BYTE, 0};

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f10509b = {ISO7816.INS_MANAGE_CHANNEL, 114, 109, 0};

    public static void A(InputStream inputStream) throws IOException {
        e.h(inputStream);
        int j11 = e.j(inputStream);
        if (j11 != 6 && j11 != 7) {
            while (j11 > 0) {
                e.j(inputStream);
                for (int j12 = e.j(inputStream); j12 > 0; j12--) {
                    e.h(inputStream);
                }
                j11--;
            }
        }
    }

    public static boolean B(OutputStream outputStream, byte[] bArr, d[] dVarArr) throws IOException {
        if (Arrays.equals(bArr, o.f10520a)) {
            N(outputStream, dVarArr);
            return true;
        } else if (Arrays.equals(bArr, o.f10521b)) {
            M(outputStream, dVarArr);
            return true;
        } else if (Arrays.equals(bArr, o.f10523d)) {
            K(outputStream, dVarArr);
            return true;
        } else if (Arrays.equals(bArr, o.f10522c)) {
            L(outputStream, dVarArr);
            return true;
        } else if (!Arrays.equals(bArr, o.f10524e)) {
            return false;
        } else {
            J(outputStream, dVarArr);
            return true;
        }
    }

    public static void C(OutputStream outputStream, d dVar) throws IOException {
        int i11 = 0;
        for (int valueOf : dVar.f10495h) {
            Integer valueOf2 = Integer.valueOf(valueOf);
            e.p(outputStream, valueOf2.intValue() - i11);
            i11 = valueOf2.intValue();
        }
    }

    public static p D(d[] dVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            e.p(byteArrayOutputStream, dVarArr.length);
            int i11 = 2;
            for (d dVar : dVarArr) {
                e.q(byteArrayOutputStream, dVar.f10490c);
                e.q(byteArrayOutputStream, dVar.f10491d);
                e.q(byteArrayOutputStream, (long) dVar.f10494g);
                String j11 = j(dVar.f10488a, dVar.f10489b, o.f10520a);
                int k11 = e.k(j11);
                e.p(byteArrayOutputStream, k11);
                i11 = i11 + 4 + 4 + 4 + 2 + (k11 * 1);
                e.n(byteArrayOutputStream, j11);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i11 == byteArray.length) {
                p pVar = new p(FileSectionType.DEX_FILES, i11, byteArray, false);
                byteArrayOutputStream.close();
                return pVar;
            }
            throw e.c("Expected size " + i11 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public static void E(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(f10508a);
        outputStream.write(bArr);
    }

    public static void F(OutputStream outputStream, d dVar) throws IOException {
        I(outputStream, dVar);
        C(outputStream, dVar);
        H(outputStream, dVar);
    }

    public static void G(OutputStream outputStream, d dVar, String str) throws IOException {
        e.p(outputStream, e.k(str));
        e.p(outputStream, dVar.f10492e);
        e.q(outputStream, (long) dVar.f10493f);
        e.q(outputStream, dVar.f10490c);
        e.q(outputStream, (long) dVar.f10494g);
        e.n(outputStream, str);
    }

    public static void H(OutputStream outputStream, d dVar) throws IOException {
        byte[] bArr = new byte[k(dVar.f10494g)];
        for (Map.Entry next : dVar.f10496i.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            int intValue2 = ((Integer) next.getValue()).intValue();
            if ((intValue2 & 2) != 0) {
                z(bArr, 2, intValue, dVar);
            }
            if ((intValue2 & 4) != 0) {
                z(bArr, 4, intValue, dVar);
            }
        }
        outputStream.write(bArr);
    }

    public static void I(OutputStream outputStream, d dVar) throws IOException {
        int i11 = 0;
        for (Map.Entry next : dVar.f10496i.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            if ((((Integer) next.getValue()).intValue() & 1) != 0) {
                e.p(outputStream, intValue - i11);
                e.p(outputStream, 0);
                i11 = intValue;
            }
        }
    }

    public static void J(OutputStream outputStream, d[] dVarArr) throws IOException {
        e.p(outputStream, dVarArr.length);
        for (d dVar : dVarArr) {
            String j11 = j(dVar.f10488a, dVar.f10489b, o.f10524e);
            e.p(outputStream, e.k(j11));
            e.p(outputStream, dVar.f10496i.size());
            e.p(outputStream, dVar.f10495h.length);
            e.q(outputStream, dVar.f10490c);
            e.n(outputStream, j11);
            for (Integer intValue : dVar.f10496i.keySet()) {
                e.p(outputStream, intValue.intValue());
            }
            for (int p11 : dVar.f10495h) {
                e.p(outputStream, p11);
            }
        }
    }

    public static void K(OutputStream outputStream, d[] dVarArr) throws IOException {
        e.r(outputStream, dVarArr.length);
        for (d dVar : dVarArr) {
            String j11 = j(dVar.f10488a, dVar.f10489b, o.f10523d);
            e.p(outputStream, e.k(j11));
            e.p(outputStream, dVar.f10495h.length);
            e.q(outputStream, (long) (dVar.f10496i.size() * 4));
            e.q(outputStream, dVar.f10490c);
            e.n(outputStream, j11);
            for (Integer intValue : dVar.f10496i.keySet()) {
                e.p(outputStream, intValue.intValue());
                e.p(outputStream, 0);
            }
            for (int p11 : dVar.f10495h) {
                e.p(outputStream, p11);
            }
        }
    }

    public static void L(OutputStream outputStream, d[] dVarArr) throws IOException {
        byte[] b11 = b(dVarArr, o.f10522c);
        e.r(outputStream, dVarArr.length);
        e.m(outputStream, b11);
    }

    public static void M(OutputStream outputStream, d[] dVarArr) throws IOException {
        byte[] b11 = b(dVarArr, o.f10521b);
        e.r(outputStream, dVarArr.length);
        e.m(outputStream, b11);
    }

    public static void N(OutputStream outputStream, d[] dVarArr) throws IOException {
        O(outputStream, dVarArr);
    }

    public static void O(OutputStream outputStream, d[] dVarArr) throws IOException {
        int i11;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(D(dVarArr));
        arrayList.add(c(dVarArr));
        arrayList.add(d(dVarArr));
        long length = ((long) o.f10520a.length) + ((long) f10508a.length) + 4 + ((long) (arrayList.size() * 16));
        e.q(outputStream, (long) arrayList.size());
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            p pVar = (p) arrayList.get(i12);
            e.q(outputStream, pVar.f10527a.getValue());
            e.q(outputStream, length);
            if (pVar.f10530d) {
                byte[] bArr = pVar.f10529c;
                byte[] b11 = e.b(bArr);
                arrayList2.add(b11);
                e.q(outputStream, (long) b11.length);
                e.q(outputStream, (long) bArr.length);
                i11 = b11.length;
            } else {
                arrayList2.add(pVar.f10529c);
                e.q(outputStream, (long) pVar.f10529c.length);
                e.q(outputStream, 0);
                i11 = pVar.f10529c.length;
            }
            length += (long) i11;
        }
        for (int i13 = 0; i13 < arrayList2.size(); i13++) {
            outputStream.write((byte[]) arrayList2.get(i13));
        }
    }

    public static int a(d dVar) {
        int i11 = 0;
        for (Map.Entry<Integer, Integer> value : dVar.f10496i.entrySet()) {
            i11 |= ((Integer) value.getValue()).intValue();
        }
        return i11;
    }

    public static byte[] b(d[] dVarArr, byte[] bArr) throws IOException {
        int i11 = 0;
        int i12 = 0;
        for (d dVar : dVarArr) {
            i12 += e.k(j(dVar.f10488a, dVar.f10489b, bArr)) + 16 + (dVar.f10492e * 2) + dVar.f10493f + k(dVar.f10494g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i12);
        if (Arrays.equals(bArr, o.f10522c)) {
            int length = dVarArr.length;
            while (i11 < length) {
                d dVar2 = dVarArr[i11];
                G(byteArrayOutputStream, dVar2, j(dVar2.f10488a, dVar2.f10489b, bArr));
                F(byteArrayOutputStream, dVar2);
                i11++;
            }
        } else {
            for (d dVar3 : dVarArr) {
                G(byteArrayOutputStream, dVar3, j(dVar3.f10488a, dVar3.f10489b, bArr));
            }
            int length2 = dVarArr.length;
            while (i11 < length2) {
                F(byteArrayOutputStream, dVarArr[i11]);
                i11++;
            }
        }
        if (byteArrayOutputStream.size() == i12) {
            return byteArrayOutputStream.toByteArray();
        }
        throw e.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + i12);
    }

    public static p c(d[] dVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i11 = 0;
        int i12 = 0;
        while (i11 < dVarArr.length) {
            try {
                d dVar = dVarArr[i11];
                e.p(byteArrayOutputStream, i11);
                e.p(byteArrayOutputStream, dVar.f10492e);
                i12 = i12 + 2 + 2 + (dVar.f10492e * 2);
                C(byteArrayOutputStream, dVar);
                i11++;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i12 == byteArray.length) {
            p pVar = new p(FileSectionType.CLASSES, i12, byteArray, true);
            byteArrayOutputStream.close();
            return pVar;
        }
        throw e.c("Expected size " + i12 + ", does not match actual size " + byteArray.length);
        throw th;
    }

    public static p d(d[] dVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i11 = 0;
        int i12 = 0;
        while (i11 < dVarArr.length) {
            try {
                d dVar = dVarArr[i11];
                int a11 = a(dVar);
                byte[] e11 = e(dVar);
                byte[] f11 = f(dVar);
                e.p(byteArrayOutputStream, i11);
                int length = e11.length + 2 + f11.length;
                e.q(byteArrayOutputStream, (long) length);
                e.p(byteArrayOutputStream, a11);
                byteArrayOutputStream.write(e11);
                byteArrayOutputStream.write(f11);
                i12 = i12 + 2 + 4 + length;
                i11++;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i12 == byteArray.length) {
            p pVar = new p(FileSectionType.METHODS, i12, byteArray, true);
            byteArrayOutputStream.close();
            return pVar;
        }
        throw e.c("Expected size " + i12 + ", does not match actual size " + byteArray.length);
        throw th;
    }

    public static byte[] e(d dVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            H(byteArrayOutputStream, dVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public static byte[] f(d dVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            I(byteArrayOutputStream, dVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public static String g(String str, String str2) {
        if (TopicOperation.OPERATION_PAIR_DIVIDER.equals(str2)) {
            return str.replace(":", TopicOperation.OPERATION_PAIR_DIVIDER);
        }
        return ":".equals(str2) ? str.replace(TopicOperation.OPERATION_PAIR_DIVIDER, ":") : str;
    }

    public static String h(String str) {
        int indexOf = str.indexOf(TopicOperation.OPERATION_PAIR_DIVIDER);
        if (indexOf < 0) {
            indexOf = str.indexOf(":");
        }
        return indexOf > 0 ? str.substring(indexOf + 1) : str;
    }

    public static d i(d[] dVarArr, String str) {
        if (dVarArr.length <= 0) {
            return null;
        }
        String h11 = h(str);
        for (int i11 = 0; i11 < dVarArr.length; i11++) {
            if (dVarArr[i11].f10489b.equals(h11)) {
                return dVarArr[i11];
            }
        }
        return null;
    }

    public static String j(String str, String str2, byte[] bArr) {
        String a11 = o.a(bArr);
        if (str.length() <= 0) {
            return g(str2, a11);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains(TopicOperation.OPERATION_PAIR_DIVIDER) || str2.contains(":")) {
            return g(str2, a11);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + o.a(bArr) + str2;
    }

    public static int k(int i11) {
        return y(i11 * 2) / 8;
    }

    public static int l(int i11, int i12, int i13) {
        if (i11 == 1) {
            throw e.c("HOT methods are not stored in the bitmap");
        } else if (i11 == 2) {
            return i12;
        } else {
            if (i11 == 4) {
                return i12 + i13;
            }
            throw e.c("Unexpected flag: " + i11);
        }
    }

    public static int[] m(InputStream inputStream, int i11) throws IOException {
        int[] iArr = new int[i11];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 += e.h(inputStream);
            iArr[i13] = i12;
        }
        return iArr;
    }

    public static int n(BitSet bitSet, int i11, int i12) {
        int i13 = 2;
        if (!bitSet.get(l(2, i11, i12))) {
            i13 = 0;
        }
        return bitSet.get(l(4, i11, i12)) ? i13 | 4 : i13;
    }

    public static byte[] o(InputStream inputStream, byte[] bArr) throws IOException {
        if (Arrays.equals(bArr, e.d(inputStream, bArr.length))) {
            return e.d(inputStream, o.f10521b.length);
        }
        throw e.c("Invalid magic");
    }

    public static void p(InputStream inputStream, d dVar) throws IOException {
        int available = inputStream.available() - dVar.f10493f;
        int i11 = 0;
        while (inputStream.available() > available) {
            i11 += e.h(inputStream);
            dVar.f10496i.put(Integer.valueOf(i11), 1);
            for (int h11 = e.h(inputStream); h11 > 0; h11--) {
                A(inputStream);
            }
        }
        if (inputStream.available() != available) {
            throw e.c("Read too much data during profile line parse");
        }
    }

    public static d[] q(InputStream inputStream, byte[] bArr, byte[] bArr2, d[] dVarArr) throws IOException {
        if (Arrays.equals(bArr, o.f10525f)) {
            if (!Arrays.equals(o.f10520a, bArr2)) {
                return r(inputStream, bArr, dVarArr);
            }
            throw e.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        } else if (Arrays.equals(bArr, o.f10526g)) {
            return t(inputStream, bArr2, dVarArr);
        } else {
            throw e.c("Unsupported meta version");
        }
    }

    public static d[] r(InputStream inputStream, byte[] bArr, d[] dVarArr) throws IOException {
        if (Arrays.equals(bArr, o.f10525f)) {
            int j11 = e.j(inputStream);
            byte[] e11 = e.e(inputStream, (int) e.i(inputStream), (int) e.i(inputStream));
            if (inputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e11);
                try {
                    d[] s11 = s(byteArrayInputStream, j11, dVarArr);
                    byteArrayInputStream.close();
                    return s11;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            } else {
                throw e.c("Content found after the end of file");
            }
        } else {
            throw e.c("Unsupported meta version");
        }
        throw th;
    }

    public static d[] s(InputStream inputStream, int i11, d[] dVarArr) throws IOException {
        int i12 = 0;
        if (inputStream.available() == 0) {
            return new d[0];
        }
        if (i11 == dVarArr.length) {
            String[] strArr = new String[i11];
            int[] iArr = new int[i11];
            for (int i13 = 0; i13 < i11; i13++) {
                int h11 = e.h(inputStream);
                iArr[i13] = e.h(inputStream);
                strArr[i13] = e.f(inputStream, h11);
            }
            while (i12 < i11) {
                d dVar = dVarArr[i12];
                if (dVar.f10489b.equals(strArr[i12])) {
                    int i14 = iArr[i12];
                    dVar.f10492e = i14;
                    dVar.f10495h = m(inputStream, i14);
                    i12++;
                } else {
                    throw e.c("Order of dexfiles in metadata did not match baseline");
                }
            }
            return dVarArr;
        }
        throw e.c("Mismatched number of dex files found in metadata");
    }

    public static d[] t(InputStream inputStream, byte[] bArr, d[] dVarArr) throws IOException {
        int h11 = e.h(inputStream);
        byte[] e11 = e.e(inputStream, (int) e.i(inputStream), (int) e.i(inputStream));
        if (inputStream.read() <= 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e11);
            try {
                d[] u11 = u(byteArrayInputStream, bArr, h11, dVarArr);
                byteArrayInputStream.close();
                return u11;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            throw e.c("Content found after the end of file");
        }
        throw th;
    }

    public static d[] u(InputStream inputStream, byte[] bArr, int i11, d[] dVarArr) throws IOException {
        int i12 = 0;
        if (inputStream.available() == 0) {
            return new d[0];
        }
        if (i11 == dVarArr.length) {
            while (i12 < i11) {
                e.h(inputStream);
                String f11 = e.f(inputStream, e.h(inputStream));
                long i13 = e.i(inputStream);
                int h11 = e.h(inputStream);
                d i14 = i(dVarArr, f11);
                if (i14 != null) {
                    i14.f10491d = i13;
                    int[] m11 = m(inputStream, h11);
                    if (Arrays.equals(bArr, o.f10524e)) {
                        i14.f10492e = h11;
                        i14.f10495h = m11;
                    }
                    i12++;
                } else {
                    throw e.c("Missing profile key: " + f11);
                }
            }
            return dVarArr;
        }
        throw e.c("Mismatched number of dex files found in metadata");
    }

    public static void v(InputStream inputStream, d dVar) throws IOException {
        BitSet valueOf = BitSet.valueOf(e.d(inputStream, e.a(dVar.f10494g * 2)));
        int i11 = 0;
        while (true) {
            int i12 = dVar.f10494g;
            if (i11 < i12) {
                int n11 = n(valueOf, i11, i12);
                if (n11 != 0) {
                    Integer num = dVar.f10496i.get(Integer.valueOf(i11));
                    if (num == null) {
                        num = 0;
                    }
                    dVar.f10496i.put(Integer.valueOf(i11), Integer.valueOf(n11 | num.intValue()));
                }
                i11++;
            } else {
                return;
            }
        }
    }

    public static d[] w(InputStream inputStream, byte[] bArr, String str) throws IOException {
        if (Arrays.equals(bArr, o.f10521b)) {
            int j11 = e.j(inputStream);
            byte[] e11 = e.e(inputStream, (int) e.i(inputStream), (int) e.i(inputStream));
            if (inputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e11);
                try {
                    d[] x11 = x(byteArrayInputStream, str, j11);
                    byteArrayInputStream.close();
                    return x11;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            } else {
                throw e.c("Content found after the end of file");
            }
        } else {
            throw e.c("Unsupported version");
        }
        throw th;
    }

    public static d[] x(InputStream inputStream, String str, int i11) throws IOException {
        InputStream inputStream2 = inputStream;
        int i12 = i11;
        if (inputStream.available() == 0) {
            return new d[0];
        }
        d[] dVarArr = new d[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            int h11 = e.h(inputStream);
            int h12 = e.h(inputStream);
            long i14 = e.i(inputStream);
            String str2 = str;
            dVarArr[i13] = new d(str2, e.f(inputStream2, h11), e.i(inputStream), 0, h12, (int) i14, (int) e.i(inputStream), new int[h12], new TreeMap());
        }
        for (int i15 = 0; i15 < i12; i15++) {
            d dVar = dVarArr[i15];
            p(inputStream2, dVar);
            dVar.f10495h = m(inputStream2, dVar.f10492e);
            v(inputStream2, dVar);
        }
        return dVarArr;
    }

    public static int y(int i11) {
        return ((i11 + 8) - 1) & -8;
    }

    public static void z(byte[] bArr, int i11, int i12, d dVar) {
        int l11 = l(i11, i12, dVar.f10494g);
        int i13 = l11 / 8;
        bArr[i13] = (byte) ((1 << (l11 % 8)) | bArr[i13]);
    }
}
