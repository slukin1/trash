package org.commonmark.internal;

import c20.b;
import c20.c;
import c20.d;
import c20.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.commonmark.internal.BlockQuoteParser;
import org.commonmark.internal.FencedCodeBlockParser;
import org.commonmark.internal.HeadingParser;
import org.commonmark.internal.HtmlBlockParser;
import org.commonmark.internal.IndentedCodeBlockParser;
import org.commonmark.internal.ListBlockParser;
import org.commonmark.internal.ThematicBreakParser;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.Document;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.ListBlock;
import org.commonmark.node.Paragraph;
import org.commonmark.node.ThematicBreak;

public class e implements f {

    /* renamed from: p  reason: collision with root package name */
    public static final Set<Class<? extends Block>> f59697p;

    /* renamed from: q  reason: collision with root package name */
    public static final Map<Class<? extends Block>, c> f59698q;

    /* renamed from: a  reason: collision with root package name */
    public CharSequence f59699a;

    /* renamed from: b  reason: collision with root package name */
    public int f59700b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f59701c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59702d;

    /* renamed from: e  reason: collision with root package name */
    public int f59703e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f59704f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f59705g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59706h;

    /* renamed from: i  reason: collision with root package name */
    public final List<c> f59707i;

    /* renamed from: j  reason: collision with root package name */
    public final b20.c f59708j;

    /* renamed from: k  reason: collision with root package name */
    public final List<d20.a> f59709k;

    /* renamed from: l  reason: collision with root package name */
    public final DocumentBlockParser f59710l;

    /* renamed from: m  reason: collision with root package name */
    public final Map<String, LinkReferenceDefinition> f59711m = new LinkedHashMap();

    /* renamed from: n  reason: collision with root package name */
    public List<b> f59712n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    public Set<b> f59713o = new LinkedHashSet();

    public static class a implements c20.e {

        /* renamed from: a  reason: collision with root package name */
        public final b f59714a;

        public a(b bVar) {
            this.f59714a = bVar;
        }

        public b a() {
            return this.f59714a;
        }

        public CharSequence b() {
            b bVar = this.f59714a;
            if (!(bVar instanceof ParagraphParser)) {
                return null;
            }
            CharSequence i11 = ((ParagraphParser) bVar).i();
            if (i11.length() == 0) {
                return null;
            }
            return i11;
        }
    }

    static {
        Class<IndentedCodeBlock> cls = IndentedCodeBlock.class;
        Class<ListBlock> cls2 = ListBlock.class;
        Class<ThematicBreak> cls3 = ThematicBreak.class;
        Class<HtmlBlock> cls4 = HtmlBlock.class;
        Class<FencedCodeBlock> cls5 = FencedCodeBlock.class;
        Class<Heading> cls6 = Heading.class;
        Class<BlockQuote> cls7 = BlockQuote.class;
        f59697p = new LinkedHashSet(Arrays.asList(new Class[]{cls7, cls6, cls5, cls4, cls3, cls2, cls}));
        HashMap hashMap = new HashMap();
        hashMap.put(cls7, new BlockQuoteParser.Factory());
        hashMap.put(cls6, new HeadingParser.Factory());
        hashMap.put(cls5, new FencedCodeBlockParser.Factory());
        hashMap.put(cls4, new HtmlBlockParser.Factory());
        hashMap.put(cls3, new ThematicBreakParser.Factory());
        hashMap.put(cls2, new ListBlockParser.Factory());
        hashMap.put(cls, new IndentedCodeBlockParser.Factory());
        f59698q = Collections.unmodifiableMap(hashMap);
    }

    public e(List<c> list, b20.c cVar, List<d20.a> list2) {
        this.f59707i = list;
        this.f59708j = cVar;
        this.f59709k = list2;
        DocumentBlockParser documentBlockParser = new DocumentBlockParser();
        this.f59710l = documentBlockParser;
        g(documentBlockParser);
    }

    public static List<c> l(List<c> list, Set<Class<? extends Block>> set) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        for (Class<? extends Block> cls : set) {
            arrayList.add(f59698q.get(cls));
        }
        return arrayList;
    }

    public static Set<Class<? extends Block>> s() {
        return f59697p;
    }

    public boolean a() {
        return this.f59706h;
    }

    public CharSequence b() {
        return this.f59699a;
    }

    public int c() {
        return this.f59701c;
    }

    public int d() {
        return this.f59703e;
    }

    public int e() {
        return this.f59705g;
    }

    public b f() {
        List<b> list = this.f59712n;
        return list.get(list.size() - 1);
    }

    public final void g(b bVar) {
        this.f59712n.add(bVar);
        this.f59713o.add(bVar);
    }

    public int getIndex() {
        return this.f59700b;
    }

    public final <T extends b> T h(T t11) {
        while (!f().f(t11.d())) {
            n(f());
        }
        f().d().b(t11.d());
        g(t11);
        return t11;
    }

    public final void i(ParagraphParser paragraphParser) {
        for (LinkReferenceDefinition next : paragraphParser.j()) {
            paragraphParser.d().i(next);
            String n11 = next.n();
            if (!this.f59711m.containsKey(n11)) {
                this.f59711m.put(n11, next);
            }
        }
    }

    public final void j() {
        CharSequence charSequence;
        if (this.f59702d) {
            CharSequence charSequence2 = this.f59699a;
            CharSequence subSequence = charSequence2.subSequence(this.f59700b + 1, charSequence2.length());
            int a11 = Parsing.a(this.f59701c);
            StringBuilder sb2 = new StringBuilder(subSequence.length() + a11);
            for (int i11 = 0; i11 < a11; i11++) {
                sb2.append(' ');
            }
            sb2.append(subSequence);
            charSequence = sb2.toString();
        } else {
            CharSequence charSequence3 = this.f59699a;
            charSequence = charSequence3.subSequence(this.f59700b, charSequence3.length());
        }
        f().e(charSequence);
    }

    public final void k() {
        if (this.f59699a.charAt(this.f59700b) == 9) {
            this.f59700b++;
            int i11 = this.f59701c;
            this.f59701c = i11 + Parsing.a(i11);
            return;
        }
        this.f59700b++;
        this.f59701c++;
    }

    public final void m() {
        List<b> list = this.f59712n;
        list.remove(list.size() - 1);
    }

    public final void n(b bVar) {
        if (f() == bVar) {
            m();
        }
        if (bVar instanceof ParagraphParser) {
            i((ParagraphParser) bVar);
        }
        bVar.h();
    }

    public final Document o() {
        p(this.f59712n);
        w();
        return this.f59710l.d();
    }

    public final void p(List<b> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            n(list.get(size));
        }
    }

    public final b q(b bVar) {
        a aVar = new a(bVar);
        for (c a11 : this.f59707i) {
            d a12 = a11.a(this, aVar);
            if (a12 instanceof b) {
                return (b) a12;
            }
        }
        return null;
    }

    public final void r() {
        int i11 = this.f59700b;
        int i12 = this.f59701c;
        this.f59706h = true;
        int length = this.f59699a.length();
        while (true) {
            if (i11 >= length) {
                break;
            }
            char charAt = this.f59699a.charAt(i11);
            if (charAt == 9) {
                i11++;
                i12 += 4 - (i12 % 4);
            } else if (charAt != ' ') {
                this.f59706h = false;
                break;
            } else {
                i11++;
                i12++;
            }
        }
        this.f59703e = i11;
        this.f59704f = i12;
        this.f59705g = i12 - this.f59701c;
    }

    public final void t(CharSequence charSequence) {
        this.f59699a = Parsing.j(charSequence);
        this.f59700b = 0;
        this.f59701c = 0;
        this.f59702d = false;
        List<b> list = this.f59712n;
        int i11 = 1;
        for (b next : list.subList(1, list.size())) {
            r();
            c20.a g11 = next.g(this);
            if (!(g11 instanceof a)) {
                break;
            }
            a aVar = (a) g11;
            if (aVar.g()) {
                n(next);
                return;
            }
            if (aVar.f() != -1) {
                y(aVar.f());
            } else if (aVar.e() != -1) {
                x(aVar.e());
            }
            i11++;
        }
        List<b> list2 = this.f59712n;
        ArrayList arrayList = new ArrayList(list2.subList(i11, list2.size()));
        b bVar = this.f59712n.get(i11 - 1);
        boolean isEmpty = arrayList.isEmpty();
        boolean z11 = (bVar.d() instanceof Paragraph) || bVar.a();
        while (true) {
            if (!z11) {
                break;
            }
            r();
            if (a() || (this.f59705g < Parsing.f59756a && Parsing.h(this.f59699a, this.f59703e))) {
                y(this.f59703e);
            } else {
                b q11 = q(bVar);
                if (q11 == null) {
                    y(this.f59703e);
                    break;
                }
                if (!isEmpty) {
                    p(arrayList);
                    isEmpty = true;
                }
                if (q11.h() != -1) {
                    y(q11.h());
                } else if (q11.g() != -1) {
                    x(q11.g());
                }
                if (q11.i()) {
                    v();
                }
                b[] f11 = q11.f();
                int length = f11.length;
                int i12 = 0;
                while (i12 < length) {
                    b bVar2 = f11[i12];
                    i12++;
                    b h11 = h(bVar2);
                    z11 = bVar2.a();
                    bVar = h11;
                }
            }
        }
        if (isEmpty || a() || !f().b()) {
            if (!isEmpty) {
                p(arrayList);
            }
            if (!bVar.a()) {
                j();
            } else if (!a()) {
                h(new ParagraphParser());
                j();
            }
        } else {
            j();
        }
    }

    public Document u(String str) {
        int i11 = 0;
        while (true) {
            int c11 = Parsing.c(str, i11);
            if (c11 == -1) {
                break;
            }
            t(str.substring(i11, c11));
            i11 = c11 + 1;
            if (i11 < str.length() && str.charAt(c11) == 13 && str.charAt(i11) == 10) {
                i11 = c11 + 2;
            }
        }
        if (str.length() > 0 && (i11 == 0 || i11 < str.length())) {
            t(str.substring(i11));
        }
        return o();
    }

    public final void v() {
        b f11 = f();
        m();
        this.f59713o.remove(f11);
        if (f11 instanceof ParagraphParser) {
            i((ParagraphParser) f11);
        }
        f11.d().l();
    }

    public final void w() {
        b20.a a11 = this.f59708j.a(new f(this.f59709k, this.f59711m));
        for (b c11 : this.f59713o) {
            c11.c(a11);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void x(int r4) {
        /*
            r3 = this;
            int r0 = r3.f59704f
            if (r4 < r0) goto L_0x000a
            int r1 = r3.f59703e
            r3.f59700b = r1
            r3.f59701c = r0
        L_0x000a:
            java.lang.CharSequence r0 = r3.f59699a
            int r0 = r0.length()
        L_0x0010:
            int r1 = r3.f59701c
            if (r1 >= r4) goto L_0x001c
            int r2 = r3.f59700b
            if (r2 == r0) goto L_0x001c
            r3.k()
            goto L_0x0010
        L_0x001c:
            if (r1 <= r4) goto L_0x0029
            int r0 = r3.f59700b
            r1 = 1
            int r0 = r0 - r1
            r3.f59700b = r0
            r3.f59701c = r4
            r3.f59702d = r1
            goto L_0x002c
        L_0x0029:
            r4 = 0
            r3.f59702d = r4
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonmark.internal.e.x(int):void");
    }

    public final void y(int i11) {
        int i12 = this.f59703e;
        if (i11 >= i12) {
            this.f59700b = i12;
            this.f59701c = this.f59704f;
        }
        int length = this.f59699a.length();
        while (true) {
            int i13 = this.f59700b;
            if (i13 >= i11 || i13 == length) {
                this.f59702d = false;
            } else {
                k();
            }
        }
        this.f59702d = false;
    }
}
