package l1;

import android.os.Build;
import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.core.util.h;
import androidx.emoji2.text.EmojiCompat;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final b f16060a;

    public static class a extends b {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f16061a;

        /* renamed from: b  reason: collision with root package name */
        public final c f16062b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f16063c = true;

        public a(TextView textView) {
            this.f16061a = textView;
            this.f16062b = new c(textView);
        }

        public InputFilter[] a(InputFilter[] inputFilterArr) {
            if (!this.f16063c) {
                return h(inputFilterArr);
            }
            return f(inputFilterArr);
        }

        public boolean b() {
            return this.f16063c;
        }

        public void c(boolean z11) {
            if (z11) {
                l();
            }
        }

        public void d(boolean z11) {
            this.f16063c = z11;
            l();
            k();
        }

        public TransformationMethod e(TransformationMethod transformationMethod) {
            if (this.f16063c) {
                return m(transformationMethod);
            }
            return j(transformationMethod);
        }

        public final InputFilter[] f(InputFilter[] inputFilterArr) {
            for (c cVar : inputFilterArr) {
                if (cVar == this.f16062b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, r0);
            inputFilterArr2[r0] = this.f16062b;
            return inputFilterArr2;
        }

        public final SparseArray<InputFilter> g(InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArray = new SparseArray<>(1);
            for (int i11 = 0; i11 < inputFilterArr.length; i11++) {
                if (inputFilterArr[i11] instanceof c) {
                    sparseArray.put(i11, inputFilterArr[i11]);
                }
            }
            return sparseArray;
        }

        public final InputFilter[] h(InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> g11 = g(inputFilterArr);
            if (g11.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length - g11.size())];
            int i11 = 0;
            for (int i12 = 0; i12 < length; i12++) {
                if (g11.indexOfKey(i12) < 0) {
                    inputFilterArr2[i11] = inputFilterArr[i12];
                    i11++;
                }
            }
            return inputFilterArr2;
        }

        public void i(boolean z11) {
            this.f16063c = z11;
        }

        public final TransformationMethod j(TransformationMethod transformationMethod) {
            return transformationMethod instanceof f ? ((f) transformationMethod).a() : transformationMethod;
        }

        public final void k() {
            this.f16061a.setFilters(a(this.f16061a.getFilters()));
        }

        public void l() {
            this.f16061a.setTransformationMethod(e(this.f16061a.getTransformationMethod()));
        }

        public final TransformationMethod m(TransformationMethod transformationMethod) {
            if (!(transformationMethod instanceof f) && !(transformationMethod instanceof PasswordTransformationMethod)) {
                return new f(transformationMethod);
            }
            return transformationMethod;
        }
    }

    public static class b {
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            return inputFilterArr;
        }

        public boolean b() {
            return false;
        }

        public void c(boolean z11) {
        }

        public void d(boolean z11) {
        }

        public TransformationMethod e(TransformationMethod transformationMethod) {
            return transformationMethod;
        }
    }

    public static class c extends b {

        /* renamed from: a  reason: collision with root package name */
        public final a f16064a;

        public c(TextView textView) {
            this.f16064a = new a(textView);
        }

        public InputFilter[] a(InputFilter[] inputFilterArr) {
            if (f()) {
                return inputFilterArr;
            }
            return this.f16064a.a(inputFilterArr);
        }

        public boolean b() {
            return this.f16064a.b();
        }

        public void c(boolean z11) {
            if (!f()) {
                this.f16064a.c(z11);
            }
        }

        public void d(boolean z11) {
            if (f()) {
                this.f16064a.i(z11);
            } else {
                this.f16064a.d(z11);
            }
        }

        public TransformationMethod e(TransformationMethod transformationMethod) {
            if (f()) {
                return transformationMethod;
            }
            return this.f16064a.e(transformationMethod);
        }

        public final boolean f() {
            return !EmojiCompat.h();
        }
    }

    public d(TextView textView, boolean z11) {
        h.h(textView, "textView cannot be null");
        if (Build.VERSION.SDK_INT < 19) {
            this.f16060a = new b();
        } else if (!z11) {
            this.f16060a = new c(textView);
        } else {
            this.f16060a = new a(textView);
        }
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f16060a.a(inputFilterArr);
    }

    public boolean b() {
        return this.f16060a.b();
    }

    public void c(boolean z11) {
        this.f16060a.c(z11);
    }

    public void d(boolean z11) {
        this.f16060a.d(z11);
    }

    public TransformationMethod e(TransformationMethod transformationMethod) {
        return this.f16060a.e(transformationMethod);
    }
}
