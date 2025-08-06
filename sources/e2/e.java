package e2;

public class e {

    /* renamed from: e  reason: collision with root package name */
    public static final e f15663e = new e(0, (char[]) null, 1443168256, 1);

    /* renamed from: f  reason: collision with root package name */
    public static final e f15664f = new e(1, (char[]) null, 1509950721, 1);

    /* renamed from: g  reason: collision with root package name */
    public static final e f15665g = new e(2, (char[]) null, 1124075009, 1);

    /* renamed from: h  reason: collision with root package name */
    public static final e f15666h = new e(3, (char[]) null, 1107297537, 1);

    /* renamed from: i  reason: collision with root package name */
    public static final e f15667i = new e(4, (char[]) null, 1392510721, 1);

    /* renamed from: j  reason: collision with root package name */
    public static final e f15668j = new e(5, (char[]) null, 1224736769, 1);

    /* renamed from: k  reason: collision with root package name */
    public static final e f15669k = new e(6, (char[]) null, 1174536705, 1);

    /* renamed from: l  reason: collision with root package name */
    public static final e f15670l = new e(7, (char[]) null, 1241579778, 1);

    /* renamed from: m  reason: collision with root package name */
    public static final e f15671m = new e(8, (char[]) null, 1141048066, 1);

    /* renamed from: a  reason: collision with root package name */
    public final int f15672a;

    /* renamed from: b  reason: collision with root package name */
    public final char[] f15673b;

    /* renamed from: c  reason: collision with root package name */
    public final int f15674c;

    /* renamed from: d  reason: collision with root package name */
    public final int f15675d;

    public e(int i11, char[] cArr, int i12, int i13) {
        this.f15672a = i11;
        this.f15673b = cArr;
        this.f15674c = i12;
        this.f15675d = i13;
    }

    public static int a(String str) {
        int i11;
        int i12 = 1;
        int i13 = 1;
        int i14 = 1;
        while (true) {
            i11 = i13 + 1;
            char charAt = str.charAt(i13);
            if (charAt == ')') {
                break;
            } else if (charAt == 'L') {
                while (true) {
                    i13 = i11 + 1;
                    if (str.charAt(i11) == ';') {
                        break;
                    }
                    i11 = i13;
                }
                i14++;
            } else {
                i14 = (charAt == 'D' || charAt == 'J') ? i14 + 2 : i14 + 1;
                i13 = i11;
            }
        }
        char charAt2 = str.charAt(i11);
        int i15 = i14 << 2;
        if (charAt2 == 'V') {
            i12 = 0;
        } else if (charAt2 == 'D' || charAt2 == 'J') {
            i12 = 2;
        }
        return i15 | i12;
    }

    public static e d(String str) {
        return e(str.toCharArray(), 0);
    }

    public static e e(char[] cArr, int i11) {
        int i12;
        char c11 = cArr[i11];
        if (c11 == 'F') {
            return f15669k;
        }
        if (c11 == 'S') {
            return f15667i;
        }
        if (c11 == 'V') {
            return f15663e;
        }
        if (c11 == 'I') {
            return f15668j;
        }
        if (c11 == 'J') {
            return f15670l;
        }
        if (c11 == 'Z') {
            return f15664f;
        }
        if (c11 != '[') {
            switch (c11) {
                case 'B':
                    return f15666h;
                case 'C':
                    return f15665g;
                case 'D':
                    return f15671m;
                default:
                    int i13 = 1;
                    while (cArr[i11 + i13] != ';') {
                        i13++;
                    }
                    return new e(10, cArr, i11 + 1, i13 - 1);
            }
        } else {
            int i14 = 1;
            while (true) {
                i12 = i11 + i14;
                if (cArr[i12] != '[') {
                    break;
                }
                i14++;
            }
            if (cArr[i12] == 'L') {
                do {
                    i14++;
                } while (cArr[i11 + i14] != ';');
            }
            return new e(9, cArr, i11, i14 + 1);
        }
    }

    public String b() {
        return new String(this.f15673b, this.f15674c, this.f15675d);
    }

    public String c() {
        return new String(this.f15673b, this.f15674c, this.f15675d);
    }
}
