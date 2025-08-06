package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;

public abstract class Key {

    /* renamed from: f  reason: collision with root package name */
    public static int f7390f = -1;

    /* renamed from: a  reason: collision with root package name */
    public int f7391a;

    /* renamed from: b  reason: collision with root package name */
    public int f7392b;

    /* renamed from: c  reason: collision with root package name */
    public String f7393c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f7394d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, ConstraintAttribute> f7395e;

    public Key() {
        int i11 = f7390f;
        this.f7391a = i11;
        this.f7392b = i11;
    }

    public abstract void a(HashMap<String, ViewSpline> hashMap);

    /* renamed from: b */
    public abstract Key clone();

    public Key c(Key key) {
        this.f7391a = key.f7391a;
        this.f7392b = key.f7392b;
        this.f7393c = key.f7393c;
        this.f7394d = key.f7394d;
        this.f7395e = key.f7395e;
        return this;
    }

    public abstract void d(HashSet<String> hashSet);

    public abstract void e(Context context, AttributeSet attributeSet);

    public boolean f(String str) {
        String str2 = this.f7393c;
        if (str2 == null || str == null) {
            return false;
        }
        return str.matches(str2);
    }

    public void g(int i11) {
        this.f7391a = i11;
    }

    public void h(HashMap<String, Integer> hashMap) {
    }

    public Key i(int i11) {
        this.f7392b = i11;
        return this;
    }

    public boolean j(Object obj) {
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(obj.toString());
    }

    public float k(Object obj) {
        return obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
    }

    public int l(Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() : Integer.parseInt(obj.toString());
    }
}
