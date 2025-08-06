package com.hbg.lib.widgets.ticker;

import com.hbg.lib.widgets.ticker.TickerView;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f72376a;

    /* renamed from: b  reason: collision with root package name */
    public final char[] f72377b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Character, Integer> f72378c;

    /* renamed from: com.hbg.lib.widgets.ticker.a$a  reason: collision with other inner class name */
    public static /* synthetic */ class C0794a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f72379a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.hbg.lib.widgets.ticker.TickerView$ScrollingDirection[] r0 = com.hbg.lib.widgets.ticker.TickerView.ScrollingDirection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f72379a = r0
                com.hbg.lib.widgets.ticker.TickerView$ScrollingDirection r1 = com.hbg.lib.widgets.ticker.TickerView.ScrollingDirection.DOWN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f72379a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.widgets.ticker.TickerView$ScrollingDirection r1 = com.hbg.lib.widgets.ticker.TickerView.ScrollingDirection.UP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f72379a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.widgets.ticker.TickerView$ScrollingDirection r1 = com.hbg.lib.widgets.ticker.TickerView.ScrollingDirection.ANY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.widgets.ticker.a.C0794a.<clinit>():void");
        }
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f72380a;

        /* renamed from: b  reason: collision with root package name */
        public final int f72381b;

        public b(int i11, int i12) {
            this.f72380a = i11;
            this.f72381b = i12;
        }
    }

    public a(String str) {
        int i11 = 0;
        if (!str.contains(Character.toString(0))) {
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            this.f72376a = length;
            this.f72378c = new HashMap(length);
            for (int i12 = 0; i12 < length; i12++) {
                this.f72378c.put(Character.valueOf(charArray[i12]), Integer.valueOf(i12));
            }
            char[] cArr = new char[((length * 2) + 1)];
            this.f72377b = cArr;
            cArr[0] = 0;
            while (i11 < length) {
                char[] cArr2 = this.f72377b;
                int i13 = i11 + 1;
                cArr2[i13] = charArray[i11];
                cArr2[length + 1 + i11] = charArray[i11];
                i11 = i13;
            }
            return;
        }
        throw new IllegalArgumentException("You cannot include TickerUtils.EMPTY_CHAR in the character list.");
    }

    public b a(char c11, char c12, TickerView.ScrollingDirection scrollingDirection) {
        int c13 = c(c11);
        int c14 = c(c12);
        if (c13 < 0 || c14 < 0) {
            return null;
        }
        int i11 = C0794a.f72379a[scrollingDirection.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (!(i11 != 3 || c11 == 0 || c12 == 0)) {
                    if (c14 < c13) {
                        int i12 = c13 - c14;
                        int i13 = this.f72376a;
                        if ((i13 - c13) + c14 < i12) {
                            c14 += i13;
                        }
                    } else if (c13 < c14) {
                        int i14 = c14 - c13;
                        int i15 = this.f72376a;
                        if ((i15 - c14) + c13 < i14) {
                            c13 += i15;
                        }
                    }
                }
            } else if (c13 < c14) {
                c13 += this.f72376a;
            }
        } else if (c12 == 0) {
            c14 = this.f72377b.length;
        } else if (c14 < c13) {
            c14 += this.f72376a;
        }
        return new b(c13, c14);
    }

    public char[] b() {
        return this.f72377b;
    }

    public final int c(char c11) {
        if (c11 == 0) {
            return 0;
        }
        if (this.f72378c.containsKey(Character.valueOf(c11))) {
            return this.f72378c.get(Character.valueOf(c11)).intValue() + 1;
        }
        return -1;
    }

    public Set<Character> d() {
        return this.f72378c.keySet();
    }
}
