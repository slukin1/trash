package ma;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.hbg.lib.widgets.ticker.LevenshteinUtils;
import com.hbg.lib.widgets.ticker.b;
import com.hbg.lib.widgets.ticker.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<b> f76282a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public final c f76283b;

    /* renamed from: c  reason: collision with root package name */
    public com.hbg.lib.widgets.ticker.a[] f76284c;

    /* renamed from: d  reason: collision with root package name */
    public Set<Character> f76285d;

    public a(c cVar) {
        this.f76283b = cVar;
    }

    public void a(Canvas canvas, Paint paint) {
        int size = this.f76282a.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f76282a.get(i11);
            bVar.b(canvas, paint);
            canvas.translate(bVar.e(), 0.0f);
        }
    }

    public com.hbg.lib.widgets.ticker.a[] b() {
        return this.f76284c;
    }

    public char[] c() {
        int size = this.f76282a.size();
        char[] cArr = new char[size];
        for (int i11 = 0; i11 < size; i11++) {
            cArr[i11] = this.f76282a.get(i11).d();
        }
        return cArr;
    }

    public float d() {
        int size = this.f76282a.size();
        float f11 = 0.0f;
        for (int i11 = 0; i11 < size; i11++) {
            f11 += this.f76282a.get(i11).e();
        }
        return f11;
    }

    public float e() {
        int size = this.f76282a.size();
        float f11 = 0.0f;
        for (int i11 = 0; i11 < size; i11++) {
            f11 += this.f76282a.get(i11).f();
        }
        return f11;
    }

    public void f() {
        int size = this.f76282a.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f76282a.get(i11).g();
        }
    }

    public void g(float f11) {
        int size = this.f76282a.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f76282a.get(i11).h(f11);
        }
    }

    public void h(String... strArr) {
        this.f76284c = new com.hbg.lib.widgets.ticker.a[strArr.length];
        for (int i11 = 0; i11 < strArr.length; i11++) {
            this.f76284c[i11] = new com.hbg.lib.widgets.ticker.a(strArr[i11]);
        }
        this.f76285d = new HashSet();
        for (int i12 = 0; i12 < strArr.length; i12++) {
            this.f76285d.addAll(this.f76284c[i12].d());
        }
    }

    public void i(char[] cArr) {
        if (this.f76284c != null) {
            int i11 = 0;
            while (i11 < this.f76282a.size()) {
                if (this.f76282a.get(i11).e() > 0.0f) {
                    i11++;
                } else {
                    this.f76282a.remove(i11);
                }
            }
            int[] b11 = LevenshteinUtils.b(c(), cArr, this.f76285d);
            int i12 = 0;
            int i13 = 0;
            for (int i14 = 0; i14 < b11.length; i14++) {
                int i15 = b11[i14];
                if (i15 != 0) {
                    if (i15 == 1) {
                        this.f76282a.add(i12, new b(this.f76284c, this.f76283b));
                    } else if (i15 == 2) {
                        this.f76282a.get(i12).j(0);
                        i12++;
                    } else {
                        throw new IllegalArgumentException("Unknown action: " + b11[i14]);
                    }
                }
                this.f76282a.get(i12).j(cArr[i13]);
                i12++;
                i13++;
            }
            return;
        }
        throw new IllegalStateException("Need to call #setCharacterLists first.");
    }
}
