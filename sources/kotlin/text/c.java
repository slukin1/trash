package kotlin.text;

import d10.p;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.ranges.h;
import kotlin.sequences.g;

public final class c implements g<h> {

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f56916a;

    /* renamed from: b  reason: collision with root package name */
    public final int f56917b;

    /* renamed from: c  reason: collision with root package name */
    public final int f56918c;

    /* renamed from: d  reason: collision with root package name */
    public final p<CharSequence, Integer, Pair<Integer, Integer>> f56919d;

    public static final class a implements Iterator<h>, e10.a {

        /* renamed from: b  reason: collision with root package name */
        public int f56920b = -1;

        /* renamed from: c  reason: collision with root package name */
        public int f56921c;

        /* renamed from: d  reason: collision with root package name */
        public int f56922d;

        /* renamed from: e  reason: collision with root package name */
        public h f56923e;

        /* renamed from: f  reason: collision with root package name */
        public int f56924f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f56925g;

        public a(c cVar) {
            this.f56925g = cVar;
            int j11 = RangesKt___RangesKt.j(cVar.f56917b, 0, cVar.f56916a.length());
            this.f56921c = j11;
            this.f56922d = j11;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
            if (r0 < kotlin.text.c.d(r6.f56925g)) goto L_0x0023;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a() {
            /*
                r6 = this;
                int r0 = r6.f56922d
                r1 = 0
                if (r0 >= 0) goto L_0x000c
                r6.f56920b = r1
                r0 = 0
                r6.f56923e = r0
                goto L_0x009e
            L_0x000c:
                kotlin.text.c r0 = r6.f56925g
                int r0 = r0.f56918c
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L_0x0023
                int r0 = r6.f56924f
                int r0 = r0 + r3
                r6.f56924f = r0
                kotlin.text.c r4 = r6.f56925g
                int r4 = r4.f56918c
                if (r0 >= r4) goto L_0x0031
            L_0x0023:
                int r0 = r6.f56922d
                kotlin.text.c r4 = r6.f56925g
                java.lang.CharSequence r4 = r4.f56916a
                int r4 = r4.length()
                if (r0 <= r4) goto L_0x0047
            L_0x0031:
                kotlin.ranges.h r0 = new kotlin.ranges.h
                int r1 = r6.f56921c
                kotlin.text.c r4 = r6.f56925g
                java.lang.CharSequence r4 = r4.f56916a
                int r4 = kotlin.text.StringsKt__StringsKt.a0(r4)
                r0.<init>(r1, r4)
                r6.f56923e = r0
                r6.f56922d = r2
                goto L_0x009c
            L_0x0047:
                kotlin.text.c r0 = r6.f56925g
                d10.p r0 = r0.f56919d
                kotlin.text.c r4 = r6.f56925g
                java.lang.CharSequence r4 = r4.f56916a
                int r5 = r6.f56922d
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L_0x0077
                kotlin.ranges.h r0 = new kotlin.ranges.h
                int r1 = r6.f56921c
                kotlin.text.c r4 = r6.f56925g
                java.lang.CharSequence r4 = r4.f56916a
                int r4 = kotlin.text.StringsKt__StringsKt.a0(r4)
                r0.<init>(r1, r4)
                r6.f56923e = r0
                r6.f56922d = r2
                goto L_0x009c
            L_0x0077:
                java.lang.Object r2 = r0.component1()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.component2()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f56921c
                kotlin.ranges.h r4 = kotlin.ranges.RangesKt___RangesKt.o(r4, r2)
                r6.f56923e = r4
                int r2 = r2 + r0
                r6.f56921c = r2
                if (r0 != 0) goto L_0x0099
                r1 = r3
            L_0x0099:
                int r2 = r2 + r1
                r6.f56922d = r2
            L_0x009c:
                r6.f56920b = r3
            L_0x009e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.c.a.a():void");
        }

        /* renamed from: b */
        public h next() {
            if (this.f56920b == -1) {
                a();
            }
            if (this.f56920b != 0) {
                h hVar = this.f56923e;
                this.f56923e = null;
                this.f56920b = -1;
                return hVar;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.f56920b == -1) {
                a();
            }
            return this.f56920b == 1;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public c(CharSequence charSequence, int i11, int i12, p<? super CharSequence, ? super Integer, Pair<Integer, Integer>> pVar) {
        this.f56916a = charSequence;
        this.f56917b = i11;
        this.f56918c = i12;
        this.f56919d = pVar;
    }

    public Iterator<h> iterator() {
        return new a(this);
    }
}
