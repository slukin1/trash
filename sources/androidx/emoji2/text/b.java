package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.c;
import java.util.Arrays;
import k1.d;
import k1.e;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final EmojiCompat.g f9422a;

    /* renamed from: b  reason: collision with root package name */
    public final c f9423b;

    /* renamed from: c  reason: collision with root package name */
    public EmojiCompat.d f9424c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f9425d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f9426e;

    public static final class a {
        public static int a(CharSequence charSequence, int i11, int i12) {
            int length = charSequence.length();
            if (i11 < 0 || length < i11 || i12 < 0) {
                return -1;
            }
            while (true) {
                boolean z11 = false;
                while (i12 != 0) {
                    i11--;
                    if (i11 < 0) {
                        return z11 ? -1 : 0;
                    }
                    char charAt = charSequence.charAt(i11);
                    if (z11) {
                        if (!Character.isHighSurrogate(charAt)) {
                            return -1;
                        }
                        i12--;
                    } else if (!Character.isSurrogate(charAt)) {
                        i12--;
                    } else if (Character.isHighSurrogate(charAt)) {
                        return -1;
                    } else {
                        z11 = true;
                    }
                }
                return i11;
            }
        }

        public static int b(CharSequence charSequence, int i11, int i12) {
            int length = charSequence.length();
            if (i11 < 0 || length < i11 || i12 < 0) {
                return -1;
            }
            while (true) {
                boolean z11 = false;
                while (i12 != 0) {
                    if (r7 < length) {
                        char charAt = charSequence.charAt(r7);
                        if (z11) {
                            if (!Character.isLowSurrogate(charAt)) {
                                return -1;
                            }
                            i12--;
                            i11 = r7 + 1;
                        } else if (!Character.isSurrogate(charAt)) {
                            i12--;
                            r7++;
                        } else if (Character.isLowSurrogate(charAt)) {
                            return -1;
                        } else {
                            r7++;
                            z11 = true;
                        }
                    } else if (z11) {
                        return -1;
                    } else {
                        return length;
                    }
                }
                return r7;
            }
        }
    }

    /* renamed from: androidx.emoji2.text.b$b  reason: collision with other inner class name */
    public static final class C0040b {

        /* renamed from: a  reason: collision with root package name */
        public int f9427a = 1;

        /* renamed from: b  reason: collision with root package name */
        public final c.a f9428b;

        /* renamed from: c  reason: collision with root package name */
        public c.a f9429c;

        /* renamed from: d  reason: collision with root package name */
        public c.a f9430d;

        /* renamed from: e  reason: collision with root package name */
        public int f9431e;

        /* renamed from: f  reason: collision with root package name */
        public int f9432f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f9433g;

        /* renamed from: h  reason: collision with root package name */
        public final int[] f9434h;

        public C0040b(c.a aVar, boolean z11, int[] iArr) {
            this.f9428b = aVar;
            this.f9429c = aVar;
            this.f9433g = z11;
            this.f9434h = iArr;
        }

        public static boolean d(int i11) {
            return i11 == 65039;
        }

        public static boolean f(int i11) {
            return i11 == 65038;
        }

        public int a(int i11) {
            c.a a11 = this.f9429c.a(i11);
            int i12 = 3;
            if (this.f9427a != 2) {
                if (a11 == null) {
                    i12 = g();
                    this.f9431e = i11;
                    return i12;
                }
                this.f9427a = 2;
                this.f9429c = a11;
                this.f9432f = 1;
            } else if (a11 != null) {
                this.f9429c = a11;
                this.f9432f++;
            } else {
                if (f(i11)) {
                    i12 = g();
                } else if (!d(i11)) {
                    if (this.f9429c.b() == null) {
                        i12 = g();
                    } else if (this.f9432f != 1) {
                        this.f9430d = this.f9429c;
                        g();
                    } else if (h()) {
                        this.f9430d = this.f9429c;
                        g();
                    } else {
                        i12 = g();
                    }
                }
                this.f9431e = i11;
                return i12;
            }
            i12 = 2;
            this.f9431e = i11;
            return i12;
        }

        public d b() {
            return this.f9429c.b();
        }

        public d c() {
            return this.f9430d.b();
        }

        public boolean e() {
            if (this.f9427a != 2 || this.f9429c.b() == null || (this.f9432f <= 1 && !h())) {
                return false;
            }
            return true;
        }

        public final int g() {
            this.f9427a = 1;
            this.f9429c = this.f9428b;
            this.f9432f = 0;
            return 1;
        }

        public final boolean h() {
            if (this.f9429c.b().j() || d(this.f9431e)) {
                return true;
            }
            if (this.f9433g) {
                if (this.f9434h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f9434h, this.f9429c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public b(c cVar, EmojiCompat.g gVar, EmojiCompat.d dVar, boolean z11, int[] iArr) {
        this.f9422a = gVar;
        this.f9423b = cVar;
        this.f9424c = dVar;
        this.f9425d = z11;
        this.f9426e = iArr;
    }

    public static boolean b(Editable editable, KeyEvent keyEvent, boolean z11) {
        e[] eVarArr;
        if (g(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!f(selectionStart, selectionEnd) && (eVarArr = (e[]) editable.getSpans(selectionStart, selectionEnd, e.class)) != null && eVarArr.length > 0) {
            int length = eVarArr.length;
            int i11 = 0;
            while (i11 < length) {
                e eVar = eVarArr[i11];
                int spanStart = editable.getSpanStart(eVar);
                int spanEnd = editable.getSpanEnd(eVar);
                if ((!z11 || spanStart != selectionStart) && ((z11 || spanEnd != selectionStart) && (selectionStart <= spanStart || selectionStart >= spanEnd))) {
                    i11++;
                } else {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean c(InputConnection inputConnection, Editable editable, int i11, int i12, boolean z11) {
        int i13;
        int i14;
        if (editable != null && inputConnection != null && i11 >= 0 && i12 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (f(selectionStart, selectionEnd)) {
                return false;
            }
            if (z11) {
                i14 = a.a(editable, selectionStart, Math.max(i11, 0));
                i13 = a.b(editable, selectionEnd, Math.max(i12, 0));
                if (i14 == -1 || i13 == -1) {
                    return false;
                }
            } else {
                i14 = Math.max(selectionStart - i11, 0);
                i13 = Math.min(selectionEnd + i12, editable.length());
            }
            e[] eVarArr = (e[]) editable.getSpans(i14, i13, e.class);
            if (eVarArr != null && eVarArr.length > 0) {
                for (e eVar : eVarArr) {
                    int spanStart = editable.getSpanStart(eVar);
                    int spanEnd = editable.getSpanEnd(eVar);
                    i14 = Math.min(spanStart, i14);
                    i13 = Math.max(spanEnd, i13);
                }
                int max = Math.max(i14, 0);
                int min = Math.min(i13, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(max, min);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    public static boolean d(Editable editable, int i11, KeyEvent keyEvent) {
        boolean z11;
        if (i11 != 67) {
            z11 = i11 != 112 ? false : b(editable, keyEvent, true);
        } else {
            z11 = b(editable, keyEvent, false);
        }
        if (!z11) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    public static boolean f(int i11, int i12) {
        return i11 == -1 || i12 == -1 || i11 != i12;
    }

    public static boolean g(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    public final void a(Spannable spannable, d dVar, int i11, int i12) {
        spannable.setSpan(this.f9422a.a(dVar), i11, i12, 33);
    }

    public final boolean e(CharSequence charSequence, int i11, int i12, d dVar) {
        if (dVar.d() == 0) {
            dVar.k(this.f9424c.a(charSequence, i11, i12, dVar.h()));
        }
        return dVar.d() == 2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0047 A[Catch:{ all -> 0x012c }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063 A[Catch:{ all -> 0x012c }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0125  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.CharSequence h(java.lang.CharSequence r10, int r11, int r12, int r13, boolean r14) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof k1.i
            if (r0 == 0) goto L_0x000a
            r1 = r10
            k1.i r1 = (k1.i) r1
            r1.a()
        L_0x000a:
            r1 = 0
            if (r0 != 0) goto L_0x002b
            boolean r2 = r10 instanceof android.text.Spannable     // Catch:{ all -> 0x012c }
            if (r2 == 0) goto L_0x0012
            goto L_0x002b
        L_0x0012:
            boolean r2 = r10 instanceof android.text.Spanned     // Catch:{ all -> 0x012c }
            if (r2 == 0) goto L_0x0033
            r2 = r10
            android.text.Spanned r2 = (android.text.Spanned) r2     // Catch:{ all -> 0x012c }
            int r3 = r11 + -1
            int r4 = r12 + 1
            java.lang.Class<k1.e> r5 = k1.e.class
            int r2 = r2.nextSpanTransition(r3, r4, r5)     // Catch:{ all -> 0x012c }
            if (r2 > r12) goto L_0x0033
            k1.k r1 = new k1.k     // Catch:{ all -> 0x012c }
            r1.<init>((java.lang.CharSequence) r10)     // Catch:{ all -> 0x012c }
            goto L_0x0033
        L_0x002b:
            k1.k r1 = new k1.k     // Catch:{ all -> 0x012c }
            r2 = r10
            android.text.Spannable r2 = (android.text.Spannable) r2     // Catch:{ all -> 0x012c }
            r1.<init>((android.text.Spannable) r2)     // Catch:{ all -> 0x012c }
        L_0x0033:
            r2 = 0
            if (r1 == 0) goto L_0x0061
            java.lang.Class<k1.e> r3 = k1.e.class
            java.lang.Object[] r3 = r1.getSpans(r11, r12, r3)     // Catch:{ all -> 0x012c }
            k1.e[] r3 = (k1.e[]) r3     // Catch:{ all -> 0x012c }
            if (r3 == 0) goto L_0x0061
            int r4 = r3.length     // Catch:{ all -> 0x012c }
            if (r4 <= 0) goto L_0x0061
            int r4 = r3.length     // Catch:{ all -> 0x012c }
            r5 = r2
        L_0x0045:
            if (r5 >= r4) goto L_0x0061
            r6 = r3[r5]     // Catch:{ all -> 0x012c }
            int r7 = r1.getSpanStart(r6)     // Catch:{ all -> 0x012c }
            int r8 = r1.getSpanEnd(r6)     // Catch:{ all -> 0x012c }
            if (r7 == r12) goto L_0x0056
            r1.removeSpan(r6)     // Catch:{ all -> 0x012c }
        L_0x0056:
            int r11 = java.lang.Math.min(r7, r11)     // Catch:{ all -> 0x012c }
            int r12 = java.lang.Math.max(r8, r12)     // Catch:{ all -> 0x012c }
            int r5 = r5 + 1
            goto L_0x0045
        L_0x0061:
            if (r11 == r12) goto L_0x0123
            int r3 = r10.length()     // Catch:{ all -> 0x012c }
            if (r11 < r3) goto L_0x006b
            goto L_0x0123
        L_0x006b:
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r13 == r3) goto L_0x0080
            if (r1 == 0) goto L_0x0080
            int r3 = r1.length()     // Catch:{ all -> 0x012c }
            java.lang.Class<k1.e> r4 = k1.e.class
            java.lang.Object[] r3 = r1.getSpans(r2, r3, r4)     // Catch:{ all -> 0x012c }
            k1.e[] r3 = (k1.e[]) r3     // Catch:{ all -> 0x012c }
            int r3 = r3.length     // Catch:{ all -> 0x012c }
            int r13 = r13 - r3
        L_0x0080:
            androidx.emoji2.text.b$b r3 = new androidx.emoji2.text.b$b     // Catch:{ all -> 0x012c }
            androidx.emoji2.text.c r4 = r9.f9423b     // Catch:{ all -> 0x012c }
            androidx.emoji2.text.c$a r4 = r4.f()     // Catch:{ all -> 0x012c }
            boolean r5 = r9.f9425d     // Catch:{ all -> 0x012c }
            int[] r6 = r9.f9426e     // Catch:{ all -> 0x012c }
            r3.<init>(r4, r5, r6)     // Catch:{ all -> 0x012c }
            int r4 = java.lang.Character.codePointAt(r10, r11)     // Catch:{ all -> 0x012c }
            r5 = r4
            r4 = r2
            r2 = r1
        L_0x0096:
            r1 = r11
        L_0x0097:
            if (r11 >= r12) goto L_0x00e9
            if (r4 >= r13) goto L_0x00e9
            int r6 = r3.a(r5)     // Catch:{ all -> 0x012c }
            r7 = 1
            if (r6 == r7) goto L_0x00d7
            r7 = 2
            if (r6 == r7) goto L_0x00cb
            r7 = 3
            if (r6 == r7) goto L_0x00a9
            goto L_0x0097
        L_0x00a9:
            if (r14 != 0) goto L_0x00b5
            k1.d r6 = r3.c()     // Catch:{ all -> 0x012c }
            boolean r6 = r9.e(r10, r1, r11, r6)     // Catch:{ all -> 0x012c }
            if (r6 != 0) goto L_0x0096
        L_0x00b5:
            if (r2 != 0) goto L_0x00c1
            k1.k r2 = new k1.k     // Catch:{ all -> 0x012c }
            android.text.SpannableString r6 = new android.text.SpannableString     // Catch:{ all -> 0x012c }
            r6.<init>(r10)     // Catch:{ all -> 0x012c }
            r2.<init>((android.text.Spannable) r6)     // Catch:{ all -> 0x012c }
        L_0x00c1:
            k1.d r6 = r3.c()     // Catch:{ all -> 0x012c }
            r9.a(r2, r6, r1, r11)     // Catch:{ all -> 0x012c }
            int r4 = r4 + 1
            goto L_0x0096
        L_0x00cb:
            int r6 = java.lang.Character.charCount(r5)     // Catch:{ all -> 0x012c }
            int r11 = r11 + r6
            if (r11 >= r12) goto L_0x0097
            int r5 = java.lang.Character.codePointAt(r10, r11)     // Catch:{ all -> 0x012c }
            goto L_0x0097
        L_0x00d7:
            int r11 = java.lang.Character.codePointAt(r10, r1)     // Catch:{ all -> 0x012c }
            int r11 = java.lang.Character.charCount(r11)     // Catch:{ all -> 0x012c }
            int r1 = r1 + r11
            if (r1 >= r12) goto L_0x00e7
            int r11 = java.lang.Character.codePointAt(r10, r1)     // Catch:{ all -> 0x012c }
            r5 = r11
        L_0x00e7:
            r11 = r1
            goto L_0x0097
        L_0x00e9:
            boolean r12 = r3.e()     // Catch:{ all -> 0x012c }
            if (r12 == 0) goto L_0x010c
            if (r4 >= r13) goto L_0x010c
            if (r14 != 0) goto L_0x00fd
            k1.d r12 = r3.b()     // Catch:{ all -> 0x012c }
            boolean r12 = r9.e(r10, r1, r11, r12)     // Catch:{ all -> 0x012c }
            if (r12 != 0) goto L_0x010c
        L_0x00fd:
            if (r2 != 0) goto L_0x0105
            k1.k r12 = new k1.k     // Catch:{ all -> 0x012c }
            r12.<init>((java.lang.CharSequence) r10)     // Catch:{ all -> 0x012c }
            r2 = r12
        L_0x0105:
            k1.d r12 = r3.b()     // Catch:{ all -> 0x012c }
            r9.a(r2, r12, r1, r11)     // Catch:{ all -> 0x012c }
        L_0x010c:
            if (r2 == 0) goto L_0x011a
            android.text.Spannable r11 = r2.b()     // Catch:{ all -> 0x012c }
            if (r0 == 0) goto L_0x0119
            k1.i r10 = (k1.i) r10
            r10.d()
        L_0x0119:
            return r11
        L_0x011a:
            if (r0 == 0) goto L_0x0122
            r11 = r10
            k1.i r11 = (k1.i) r11
            r11.d()
        L_0x0122:
            return r10
        L_0x0123:
            if (r0 == 0) goto L_0x012b
            r11 = r10
            k1.i r11 = (k1.i) r11
            r11.d()
        L_0x012b:
            return r10
        L_0x012c:
            r11 = move-exception
            if (r0 == 0) goto L_0x0134
            k1.i r10 = (k1.i) r10
            r10.d()
        L_0x0134:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.b.h(java.lang.CharSequence, int, int, int, boolean):java.lang.CharSequence");
    }
}
