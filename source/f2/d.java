package f2;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.hbg.lib.network.pro.core.bean.RiskActionData;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;

public final class d extends c {

    /* renamed from: w  reason: collision with root package name */
    public static final ThreadLocal<char[]> f15733w = new ThreadLocal<>();

    /* renamed from: t  reason: collision with root package name */
    public Reader f15734t;

    /* renamed from: u  reason: collision with root package name */
    public char[] f15735u;

    /* renamed from: v  reason: collision with root package name */
    public int f15736v;

    public final boolean E() {
        int i11 = 0;
        while (true) {
            char c11 = this.f15735u[i11];
            if (c11 == 26) {
                this.f15718b = 20;
                return true;
            } else if (!c.X(c11)) {
                return false;
            } else {
                i11++;
            }
        }
    }

    public final BigDecimal G() {
        int i11 = this.f15726j;
        if (i11 == -1) {
            i11 = 0;
        }
        char R = R((this.f15725i + i11) - 1);
        int i12 = this.f15725i;
        if (R == 'L' || R == 'S' || R == 'B' || R == 'F' || R == 'D') {
            i12--;
        }
        return new BigDecimal(this.f15735u, i11, i12);
    }

    public final String H() {
        if (this.f15727k) {
            return new String(this.f15724h, 0, this.f15725i);
        }
        int i11 = this.f15726j + 1;
        if (i11 >= 0) {
            char[] cArr = this.f15735u;
            int length = cArr.length;
            int i12 = this.f15725i;
            if (i11 <= length - i12) {
                return new String(cArr, i11, i12);
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    public final String N() {
        int i11 = this.f15726j;
        if (i11 == -1) {
            i11 = 0;
        }
        char R = R((this.f15725i + i11) - 1);
        int i12 = this.f15725i;
        if (R == 'L' || R == 'S' || R == 'B' || R == 'F' || R == 'D') {
            i12--;
        }
        return new String(this.f15735u, i11, i12);
    }

    public final String O(int i11, int i12, int i13, g gVar) {
        return gVar.c(this.f15735u, i11, i12, i13);
    }

    public final void P(int i11, char[] cArr, int i12, int i13) {
        System.arraycopy(this.f15735u, i11, cArr, i12, i13);
    }

    public final boolean Q(char[] cArr) {
        for (int i11 = 0; i11 < cArr.length; i11++) {
            if (R(this.f15722f + i11) != cArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public final char R(int i11) {
        int i12 = this.f15736v;
        if (i11 >= i12) {
            if (i12 != -1) {
                int i13 = this.f15722f;
                if (i13 == 0) {
                    char[] cArr = this.f15735u;
                    int length = (cArr.length * 3) / 2;
                    char[] cArr2 = new char[length];
                    System.arraycopy(cArr, i13, cArr2, 0, i12);
                    int i14 = this.f15736v;
                    try {
                        this.f15736v += this.f15734t.read(cArr2, i14, length - i14);
                        this.f15735u = cArr2;
                    } catch (IOException e11) {
                        throw new JSONException(e11.getMessage(), e11);
                    }
                } else {
                    int i15 = i12 - i13;
                    if (i15 > 0) {
                        char[] cArr3 = this.f15735u;
                        System.arraycopy(cArr3, i13, cArr3, 0, i15);
                    }
                    try {
                        Reader reader = this.f15734t;
                        char[] cArr4 = this.f15735u;
                        int read = reader.read(cArr4, i15, cArr4.length - i15);
                        this.f15736v = read;
                        if (read == 0) {
                            throw new JSONException("illegal state, textLength is zero");
                        } else if (read == -1) {
                            return 26;
                        } else {
                            this.f15736v = read + i15;
                            int i16 = this.f15722f;
                            i11 -= i16;
                            this.f15726j -= i16;
                            this.f15722f = 0;
                        }
                    } catch (IOException e12) {
                        throw new JSONException(e12.getMessage(), e12);
                    }
                }
            } else if (i11 < this.f15725i) {
                return this.f15735u[i11];
            } else {
                return 26;
            }
        }
        return this.f15735u[i11];
    }

    public final void S(int i11, int i12, char[] cArr) {
        System.arraycopy(this.f15735u, i11, cArr, 0, i12);
    }

    public final int V(char c11, int i11) {
        int i12 = i11 - this.f15722f;
        while (true) {
            char R = R(this.f15722f + i12);
            if (c11 == R) {
                return i12 + this.f15722f;
            }
            if (R == 26) {
                return -1;
            }
            i12++;
        }
    }

    public boolean W() {
        if (this.f15736v == -1) {
            return true;
        }
        int i11 = this.f15722f;
        char[] cArr = this.f15735u;
        if (i11 != cArr.length) {
            return this.f15721e == 26 && i11 + 1 == cArr.length;
        }
        return true;
    }

    public void close() {
        super.close();
        char[] cArr = this.f15735u;
        if (cArr.length <= 65536) {
            f15733w.set(cArr);
        }
        this.f15735u = null;
        IOUtils.a(this.f15734t);
    }

    public byte[] j() {
        if (this.f15718b != 26) {
            return IOUtils.e(this.f15735u, this.f15726j + 1, this.f15725i);
        }
        throw new JSONException(RiskActionData.ORDER_STATE_TODO);
    }

    public final char next() {
        int i11 = this.f15722f + 1;
        this.f15722f = i11;
        int i12 = this.f15736v;
        if (i11 >= i12) {
            if (i12 == -1) {
                return 26;
            }
            int i13 = this.f15725i;
            if (i13 > 0) {
                int i14 = i12 - i13;
                if (this.f15721e == '\"' && i14 > 0) {
                    i14--;
                }
                char[] cArr = this.f15735u;
                System.arraycopy(cArr, i14, cArr, 0, i13);
            }
            this.f15726j = -1;
            int i15 = this.f15725i;
            this.f15722f = i15;
            try {
                char[] cArr2 = this.f15735u;
                int length = cArr2.length - i15;
                if (length == 0) {
                    char[] cArr3 = new char[(cArr2.length * 2)];
                    System.arraycopy(cArr2, 0, cArr3, 0, cArr2.length);
                    this.f15735u = cArr3;
                    length = cArr3.length - i15;
                }
                int read = this.f15734t.read(this.f15735u, this.f15722f, length);
                this.f15736v = read;
                if (read == 0) {
                    throw new JSONException("illegal stat, textLength is zero");
                } else if (read == -1) {
                    this.f15721e = 26;
                    return 26;
                } else {
                    this.f15736v = read + this.f15722f;
                    i11 = i15;
                }
            } catch (IOException e11) {
                throw new JSONException(e11.getMessage(), e11);
            }
        }
        char c11 = this.f15735u[i11];
        this.f15721e = c11;
        return c11;
    }

    public final String x0(int i11, int i12) {
        if (i12 >= 0) {
            return new String(this.f15735u, i11, i12);
        }
        throw new StringIndexOutOfBoundsException(i12);
    }

    public final char[] y0(int i11, int i12) {
        if (i12 < 0) {
            throw new StringIndexOutOfBoundsException(i12);
        } else if (i11 == 0) {
            return this.f15735u;
        } else {
            char[] cArr = new char[i12];
            System.arraycopy(this.f15735u, i11, cArr, 0, i12);
            return cArr;
        }
    }
}
