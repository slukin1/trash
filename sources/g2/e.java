package g2;

import com.alibaba.fastjson.JSONException;
import f2.a;
import f2.b;
import java.lang.reflect.Type;
import java.util.Arrays;

public class e implements l {

    /* renamed from: a  reason: collision with root package name */
    public final Class<?> f15804a;

    /* renamed from: b  reason: collision with root package name */
    public final Enum[] f15805b;

    /* renamed from: c  reason: collision with root package name */
    public final Enum[] f15806c;

    /* renamed from: d  reason: collision with root package name */
    public long[] f15807d;

    public e(Class<?> cls) {
        this.f15804a = cls;
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        this.f15806c = enumArr;
        int length = enumArr.length;
        long[] jArr = new long[length];
        this.f15807d = new long[enumArr.length];
        int i11 = 0;
        while (true) {
            Enum[] enumArr2 = this.f15806c;
            if (i11 >= enumArr2.length) {
                break;
            }
            String name = enumArr2[i11].name();
            long j11 = -2128831035;
            for (int i12 = 0; i12 < name.length(); i12++) {
                j11 = (j11 ^ ((long) name.charAt(i12))) * 16777619;
            }
            jArr[i11] = j11;
            this.f15807d[i11] = j11;
            i11++;
        }
        Arrays.sort(this.f15807d);
        this.f15805b = new Enum[this.f15806c.length];
        for (int i13 = 0; i13 < this.f15807d.length; i13++) {
            int i14 = 0;
            while (true) {
                if (i14 >= length) {
                    break;
                } else if (this.f15807d[i13] == jArr[i14]) {
                    this.f15805b[i13] = this.f15806c[i14];
                    break;
                } else {
                    i14++;
                }
            }
        }
    }

    public int b() {
        return 2;
    }

    public Enum c(long j11) {
        int binarySearch;
        if (this.f15805b != null && (binarySearch = Arrays.binarySearch(this.f15807d, j11)) >= 0) {
            return this.f15805b[binarySearch];
        }
        return null;
    }

    public Enum<?> d(int i11) {
        return this.f15806c[i11];
    }

    public <T> T e(a aVar, Type type, Object obj) {
        try {
            b bVar = aVar.f15701g;
            int J = bVar.J();
            if (J == 2) {
                int w11 = bVar.w();
                bVar.f(16);
                if (w11 >= 0) {
                    T[] tArr = this.f15806c;
                    if (w11 <= tArr.length) {
                        return tArr[w11];
                    }
                }
                throw new JSONException("parse enum " + this.f15804a.getName() + " error, value : " + w11);
            } else if (J == 4) {
                String H = bVar.H();
                bVar.f(16);
                if (H.length() == 0) {
                    return null;
                }
                return Enum.valueOf(this.f15804a, H);
            } else if (J == 8) {
                bVar.f(16);
                return null;
            } else {
                Object z11 = aVar.z();
                throw new JSONException("parse enum " + this.f15804a.getName() + " error, value : " + z11);
            }
        } catch (JSONException e11) {
            throw e11;
        } catch (Exception e12) {
            throw new JSONException(e12.getMessage(), e12);
        }
    }
}
