package k1;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import androidx.core.util.h;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class i extends SpannableStringBuilder {

    /* renamed from: b  reason: collision with root package name */
    public final Class<?> f16029b;

    /* renamed from: c  reason: collision with root package name */
    public final List<a> f16030c = new ArrayList();

    public static class a implements TextWatcher, SpanWatcher {

        /* renamed from: b  reason: collision with root package name */
        public final Object f16031b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicInteger f16032c = new AtomicInteger(0);

        public a(Object obj) {
            this.f16031b = obj;
        }

        public final void a() {
            this.f16032c.incrementAndGet();
        }

        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.f16031b).afterTextChanged(editable);
        }

        public final boolean b(Object obj) {
            return obj instanceof e;
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            ((TextWatcher) this.f16031b).beforeTextChanged(charSequence, i11, i12, i13);
        }

        public final void c() {
            this.f16032c.decrementAndGet();
        }

        public void onSpanAdded(Spannable spannable, Object obj, int i11, int i12) {
            if (this.f16032c.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f16031b).onSpanAdded(spannable, obj, i11, i12);
            }
        }

        public void onSpanChanged(Spannable spannable, Object obj, int i11, int i12, int i13, int i14) {
            int i15;
            int i16;
            if (this.f16032c.get() <= 0 || !b(obj)) {
                if (Build.VERSION.SDK_INT < 28) {
                    int i17 = i11 > i12 ? 0 : i11;
                    if (i13 > i14) {
                        i16 = i17;
                        i15 = 0;
                    } else {
                        i15 = i13;
                        i16 = i17;
                    }
                } else {
                    i16 = i11;
                    i15 = i13;
                }
                ((SpanWatcher) this.f16031b).onSpanChanged(spannable, obj, i16, i12, i15, i14);
            }
        }

        public void onSpanRemoved(Spannable spannable, Object obj, int i11, int i12) {
            if (this.f16032c.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f16031b).onSpanRemoved(spannable, obj, i11, i12);
            }
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            ((TextWatcher) this.f16031b).onTextChanged(charSequence, i11, i12, i13);
        }
    }

    public i(Class<?> cls, CharSequence charSequence) {
        super(charSequence);
        h.h(cls, "watcherClass cannot be null");
        this.f16029b = cls;
    }

    public static i c(Class<?> cls, CharSequence charSequence) {
        return new i(cls, charSequence);
    }

    public void a() {
        b();
    }

    public final void b() {
        for (int i11 = 0; i11 < this.f16030c.size(); i11++) {
            this.f16030c.get(i11).a();
        }
    }

    public void d() {
        i();
        e();
    }

    public final void e() {
        for (int i11 = 0; i11 < this.f16030c.size(); i11++) {
            this.f16030c.get(i11).onTextChanged(this, 0, length(), length());
        }
    }

    public final a f(Object obj) {
        for (int i11 = 0; i11 < this.f16030c.size(); i11++) {
            a aVar = this.f16030c.get(i11);
            if (aVar.f16031b == obj) {
                return aVar;
            }
        }
        return null;
    }

    public final boolean g(Class<?> cls) {
        return this.f16029b == cls;
    }

    public int getSpanEnd(Object obj) {
        a f11;
        if (h(obj) && (f11 = f(obj)) != null) {
            obj = f11;
        }
        return super.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        a f11;
        if (h(obj) && (f11 = f(obj)) != null) {
            obj = f11;
        }
        return super.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        a f11;
        if (h(obj) && (f11 = f(obj)) != null) {
            obj = f11;
        }
        return super.getSpanStart(obj);
    }

    @SuppressLint({"UnknownNullness"})
    public <T> T[] getSpans(int i11, int i12, Class<T> cls) {
        if (!g(cls)) {
            return super.getSpans(i11, i12, cls);
        }
        a[] aVarArr = (a[]) super.getSpans(i11, i12, a.class);
        T[] tArr = (Object[]) Array.newInstance(cls, aVarArr.length);
        for (int i13 = 0; i13 < aVarArr.length; i13++) {
            tArr[i13] = aVarArr[i13].f16031b;
        }
        return tArr;
    }

    public final boolean h(Object obj) {
        return obj != null && g(obj.getClass());
    }

    public final void i() {
        for (int i11 = 0; i11 < this.f16030c.size(); i11++) {
            this.f16030c.get(i11).c();
        }
    }

    public int nextSpanTransition(int i11, int i12, Class<a> cls) {
        if (cls == null || g(cls)) {
            cls = a.class;
        }
        return super.nextSpanTransition(i11, i12, cls);
    }

    public void removeSpan(Object obj) {
        a aVar;
        if (h(obj)) {
            aVar = f(obj);
            if (aVar != null) {
                obj = aVar;
            }
        } else {
            aVar = null;
        }
        super.removeSpan(obj);
        if (aVar != null) {
            this.f16030c.remove(aVar);
        }
    }

    public void setSpan(Object obj, int i11, int i12, int i13) {
        if (h(obj)) {
            a aVar = new a(obj);
            this.f16030c.add(aVar);
            obj = aVar;
        }
        super.setSpan(obj, i11, i12, i13);
    }

    @SuppressLint({"UnknownNullness"})
    public CharSequence subSequence(int i11, int i12) {
        return new i(this.f16029b, this, i11, i12);
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder delete(int i11, int i12) {
        super.delete(i11, i12);
        return this;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int i11, CharSequence charSequence) {
        super.insert(i11, charSequence);
        return this;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int i11, int i12, CharSequence charSequence) {
        b();
        super.replace(i11, i12, charSequence);
        i();
        return this;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int i11, CharSequence charSequence, int i12, int i13) {
        super.insert(i11, charSequence, i12, i13);
        return this;
    }

    public i(Class<?> cls, CharSequence charSequence, int i11, int i12) {
        super(charSequence, i11, i12);
        h.h(cls, "watcherClass cannot be null");
        this.f16029b = cls;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int i11, int i12, CharSequence charSequence, int i13, int i14) {
        b();
        super.replace(i11, i12, charSequence, i13, i14);
        i();
        return this;
    }

    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    public SpannableStringBuilder append(char c11) {
        super.append(c11);
        return this;
    }

    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i11, int i12) {
        super.append(charSequence, i11, i12);
        return this;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i11) {
        super.append(charSequence, obj, i11);
        return this;
    }
}
