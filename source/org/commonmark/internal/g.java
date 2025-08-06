package org.commonmark.internal;

import b20.b;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.internal.inline.AsteriskDelimiterProcessor;
import org.commonmark.internal.inline.UnderscoreDelimiterProcessor;
import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.Html5Entities;
import org.commonmark.internal.util.LinkScanner;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Code;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.Text;

public class g implements b20.a {

    /* renamed from: i  reason: collision with root package name */
    public static final Pattern f59717i = Pattern.compile("^[!\"#\\$%&'\\(\\)\\*\\+,\\-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]");

    /* renamed from: j  reason: collision with root package name */
    public static final Pattern f59718j = Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>]|<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->|[<][?].*?[?][>]|<![A-Z]+\\s+[^>]*>|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>)", 2);

    /* renamed from: k  reason: collision with root package name */
    public static final Pattern f59719k = Pattern.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");

    /* renamed from: l  reason: collision with root package name */
    public static final Pattern f59720l = Pattern.compile("^&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);

    /* renamed from: m  reason: collision with root package name */
    public static final Pattern f59721m = Pattern.compile("`+");

    /* renamed from: n  reason: collision with root package name */
    public static final Pattern f59722n = Pattern.compile("^`+");

    /* renamed from: o  reason: collision with root package name */
    public static final Pattern f59723o = Pattern.compile("^<([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)>");

    /* renamed from: p  reason: collision with root package name */
    public static final Pattern f59724p = Pattern.compile("^<[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>\u0000- ]*>");

    /* renamed from: q  reason: collision with root package name */
    public static final Pattern f59725q = Pattern.compile("^ *(?:\n *)?");

    /* renamed from: r  reason: collision with root package name */
    public static final Pattern f59726r = Pattern.compile("^[\\p{Zs}\t\r\n\f]");

    /* renamed from: s  reason: collision with root package name */
    public static final Pattern f59727s = Pattern.compile("\\s+");

    /* renamed from: t  reason: collision with root package name */
    public static final Pattern f59728t = Pattern.compile(" *$");

    /* renamed from: a  reason: collision with root package name */
    public final BitSet f59729a;

    /* renamed from: b  reason: collision with root package name */
    public final BitSet f59730b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Character, d20.a> f59731c;

    /* renamed from: d  reason: collision with root package name */
    public final b f59732d;

    /* renamed from: e  reason: collision with root package name */
    public String f59733e;

    /* renamed from: f  reason: collision with root package name */
    public int f59734f;

    /* renamed from: g  reason: collision with root package name */
    public d f59735g;

    /* renamed from: h  reason: collision with root package name */
    public c f59736h;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f59737a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f59738b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f59739c;

        public a(int i11, boolean z11, boolean z12) {
            this.f59737a = i11;
            this.f59739c = z11;
            this.f59738b = z12;
        }
    }

    public g(b bVar) {
        Map<Character, d20.a> f11 = f(bVar.a());
        this.f59731c = f11;
        BitSet e11 = e(f11.keySet());
        this.f59730b = e11;
        this.f59729a = g(e11);
        this.f59732d = bVar;
    }

    public static void c(char c11, d20.a aVar, Map<Character, d20.a> map) {
        if (map.put(Character.valueOf(c11), aVar) != null) {
            throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + c11 + "'");
        }
    }

    public static void d(Iterable<d20.a> iterable, Map<Character, d20.a> map) {
        i iVar;
        for (d20.a next : iterable) {
            char d11 = next.d();
            char a11 = next.a();
            if (d11 == a11) {
                d20.a aVar = map.get(Character.valueOf(d11));
                if (aVar == null || aVar.d() != aVar.a()) {
                    c(d11, next, map);
                } else {
                    if (aVar instanceof i) {
                        iVar = (i) aVar;
                    } else {
                        i iVar2 = new i(d11);
                        iVar2.f(aVar);
                        iVar = iVar2;
                    }
                    iVar.f(next);
                    map.put(Character.valueOf(d11), iVar);
                }
            } else {
                c(d11, next, map);
                c(a11, next, map);
            }
        }
    }

    public static BitSet e(Set<Character> set) {
        BitSet bitSet = new BitSet();
        for (Character charValue : set) {
            bitSet.set(charValue.charValue());
        }
        return bitSet;
    }

    public static Map<Character, d20.a> f(List<d20.a> list) {
        HashMap hashMap = new HashMap();
        d(Arrays.asList(new d20.a[]{new AsteriskDelimiterProcessor(), new UnderscoreDelimiterProcessor()}), hashMap);
        d(list, hashMap);
        return hashMap;
    }

    public static BitSet g(BitSet bitSet) {
        BitSet bitSet2 = new BitSet();
        bitSet2.or(bitSet);
        bitSet2.set(10);
        bitSet2.set(96);
        bitSet2.set(91);
        bitSet2.set(93);
        bitSet2.set(92);
        bitSet2.set(33);
        bitSet2.set(60);
        bitSet2.set(38);
        return bitSet2;
    }

    public final Node A() {
        int i11 = this.f59734f;
        int length = this.f59733e.length();
        while (true) {
            int i12 = this.f59734f;
            if (i12 == length || this.f59729a.get(this.f59733e.charAt(i12))) {
                int i13 = this.f59734f;
            } else {
                this.f59734f++;
            }
        }
        int i132 = this.f59734f;
        if (i11 != i132) {
            return M(this.f59733e, i11, i132);
        }
        return null;
    }

    public final char B() {
        if (this.f59734f < this.f59733e.length()) {
            return this.f59733e.charAt(this.f59734f);
        }
        return 0;
    }

    public final void C(d dVar) {
        boolean z11;
        HashMap hashMap = new HashMap();
        d dVar2 = this.f59735g;
        while (dVar2 != null) {
            d dVar3 = dVar2.f59693e;
            if (dVar3 == dVar) {
                break;
            }
            dVar2 = dVar3;
        }
        while (dVar2 != null) {
            char c11 = dVar2.f59690b;
            d20.a aVar = this.f59731c.get(Character.valueOf(c11));
            if (!dVar2.f59692d || aVar == null) {
                dVar2 = dVar2.f59694f;
            } else {
                char d11 = aVar.d();
                d dVar4 = dVar2.f59693e;
                int i11 = 0;
                boolean z12 = false;
                while (true) {
                    z11 = true;
                    if (dVar4 == null || dVar4 == dVar || dVar4 == hashMap.get(Character.valueOf(c11))) {
                        z11 = false;
                    } else {
                        if (dVar4.f59691c && dVar4.f59690b == d11) {
                            i11 = aVar.c(dVar4, dVar2);
                            z12 = true;
                            if (i11 > 0) {
                                break;
                            }
                        }
                        dVar4 = dVar4.f59693e;
                    }
                }
                z11 = false;
                if (!z11) {
                    if (!z12) {
                        hashMap.put(Character.valueOf(c11), dVar2.f59693e);
                        if (!dVar2.f59691c) {
                            F(dVar2);
                        }
                    }
                    dVar2 = dVar2.f59694f;
                } else {
                    Text text = dVar4.f59689a;
                    Text text2 = dVar2.f59689a;
                    dVar4.f59695g -= i11;
                    dVar2.f59695g -= i11;
                    text.n(text.m().substring(0, text.m().length() - i11));
                    text2.n(text2.m().substring(0, text2.m().length() - i11));
                    G(dVar4, dVar2);
                    k(text, text2);
                    aVar.e(text, text2, i11);
                    if (dVar4.f59695g == 0) {
                        E(dVar4);
                    }
                    if (dVar2.f59695g == 0) {
                        d dVar5 = dVar2.f59694f;
                        E(dVar2);
                        dVar2 = dVar5;
                    }
                }
            }
        }
        while (true) {
            d dVar6 = this.f59735g;
            if (dVar6 != null && dVar6 != dVar) {
                F(dVar6);
            } else {
                return;
            }
        }
    }

    public final void D(d dVar) {
        d dVar2 = dVar.f59693e;
        if (dVar2 != null) {
            dVar2.f59694f = dVar.f59694f;
        }
        d dVar3 = dVar.f59694f;
        if (dVar3 == null) {
            this.f59735g = dVar2;
        } else {
            dVar3.f59693e = dVar2;
        }
    }

    public final void E(d dVar) {
        dVar.f59689a.l();
        D(dVar);
    }

    public final void F(d dVar) {
        D(dVar);
    }

    public final void G(d dVar, d dVar2) {
        d dVar3 = dVar2.f59693e;
        while (dVar3 != null && dVar3 != dVar) {
            d dVar4 = dVar3.f59693e;
            F(dVar3);
            dVar3 = dVar4;
        }
    }

    public final void H() {
        this.f59736h = this.f59736h.f59685d;
    }

    public void I(String str) {
        this.f59733e = str;
        this.f59734f = 0;
        this.f59735g = null;
        this.f59736h = null;
    }

    public final a J(d20.a aVar, char c11) {
        String str;
        boolean z11;
        int i11 = this.f59734f;
        boolean z12 = false;
        int i12 = 0;
        while (B() == c11) {
            i12++;
            this.f59734f++;
        }
        if (i12 < aVar.b()) {
            this.f59734f = i11;
            return null;
        }
        String str2 = "\n";
        if (i11 == 0) {
            str = str2;
        } else {
            str = this.f59733e.substring(i11 - 1, i11);
        }
        char B = B();
        if (B != 0) {
            str2 = String.valueOf(B);
        }
        Pattern pattern = f59717i;
        boolean matches = pattern.matcher(str).matches();
        Pattern pattern2 = f59726r;
        boolean matches2 = pattern2.matcher(str).matches();
        boolean matches3 = pattern.matcher(str2).matches();
        boolean matches4 = pattern2.matcher(str2).matches();
        boolean z13 = !matches4 && (!matches3 || matches2 || matches);
        boolean z14 = !matches2 && (!matches || matches4 || matches3);
        if (c11 == '_') {
            z11 = z13 && (!z14 || matches);
            if (z14 && (!z13 || matches3)) {
                z12 = true;
            }
        } else {
            boolean z15 = z13 && c11 == aVar.d();
            if (z14 && c11 == aVar.a()) {
                z12 = true;
            }
            z11 = z15;
        }
        this.f59734f = i11;
        return new a(i12, z11, z12);
    }

    public final void K() {
        h(f59725q);
    }

    public final Text L(String str) {
        return new Text(str);
    }

    public final Text M(String str, int i11, int i12) {
        return new Text(str.substring(i11, i12));
    }

    public void a(String str, Node node) {
        I(str.trim());
        Node node2 = null;
        while (true) {
            node2 = u(node2);
            if (node2 != null) {
                node.b(node2);
            } else {
                C((d) null);
                i(node);
                return;
            }
        }
    }

    public final void b(c cVar) {
        c cVar2 = this.f59736h;
        if (cVar2 != null) {
            cVar2.f59688g = true;
        }
        this.f59736h = cVar;
    }

    public final String h(Pattern pattern) {
        if (this.f59734f >= this.f59733e.length()) {
            return null;
        }
        Matcher matcher = pattern.matcher(this.f59733e);
        matcher.region(this.f59734f, this.f59733e.length());
        if (!matcher.find()) {
            return null;
        }
        this.f59734f = matcher.end();
        return matcher.group();
    }

    public final void i(Node node) {
        if (node.c() != node.d()) {
            l(node.c(), node.d());
        }
    }

    public final void j(Text text, Text text2, int i11) {
        if (text != null && text2 != null && text != text2) {
            StringBuilder sb2 = new StringBuilder(i11);
            sb2.append(text.m());
            Node e11 = text.e();
            Node e12 = text2.e();
            while (e11 != e12) {
                sb2.append(((Text) e11).m());
                Node e13 = e11.e();
                e11.l();
                e11 = e13;
            }
            text.n(sb2.toString());
        }
    }

    public final void k(Node node, Node node2) {
        if (node != node2 && node.e() != node2) {
            l(node.e(), node2.g());
        }
    }

    public final void l(Node node, Node node2) {
        int i11 = 0;
        Text text = null;
        Text text2 = null;
        while (node != null) {
            if (node instanceof Text) {
                text2 = (Text) node;
                if (text == null) {
                    text = text2;
                }
                i11 += text2.m().length();
            } else {
                j(text, text2, i11);
                i11 = 0;
                text = null;
                text2 = null;
            }
            if (node == node2) {
                break;
            }
            node = node.e();
        }
        j(text, text2, i11);
    }

    public final Node m() {
        String h11 = h(f59723o);
        if (h11 != null) {
            String substring = h11.substring(1, h11.length() - 1);
            Link link = new Link("mailto:" + substring, (String) null);
            link.b(new Text(substring));
            return link;
        }
        String h12 = h(f59724p);
        if (h12 == null) {
            return null;
        }
        String substring2 = h12.substring(1, h12.length() - 1);
        Link link2 = new Link(substring2, (String) null);
        link2.b(new Text(substring2));
        return link2;
    }

    public final Node n() {
        this.f59734f++;
        if (B() == 10) {
            HardLineBreak hardLineBreak = new HardLineBreak();
            this.f59734f++;
            return hardLineBreak;
        }
        if (this.f59734f < this.f59733e.length()) {
            Pattern pattern = f59719k;
            String str = this.f59733e;
            int i11 = this.f59734f;
            if (pattern.matcher(str.substring(i11, i11 + 1)).matches()) {
                String str2 = this.f59733e;
                int i12 = this.f59734f;
                Text M = M(str2, i12, i12 + 1);
                this.f59734f++;
                return M;
            }
        }
        return L("\\");
    }

    public final Node o() {
        String h11;
        String h12 = h(f59722n);
        if (h12 == null) {
            return null;
        }
        int i11 = this.f59734f;
        do {
            h11 = h(f59721m);
            if (h11 == null) {
                this.f59734f = i11;
                return L(h12);
            }
        } while (!h11.equals(h12));
        Code code = new Code();
        String replace = this.f59733e.substring(i11, this.f59734f - h12.length()).replace(10, ' ');
        if (replace.length() >= 3 && replace.charAt(0) == ' ' && replace.charAt(replace.length() - 1) == ' ' && Parsing.e(replace)) {
            replace = replace.substring(1, replace.length() - 1);
        }
        code.n(replace);
        return code;
    }

    public final Node p() {
        int i11 = this.f59734f;
        this.f59734f = i11 + 1;
        if (B() != '[') {
            return L(TopicOperation.OPERATION_PAIR_DIVIDER);
        }
        this.f59734f++;
        Text L = L("![");
        b(c.a(L, i11 + 1, this.f59736h, this.f59735g));
        return L;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.commonmark.node.Node q() {
        /*
            r12 = this;
            int r0 = r12.f59734f
            r1 = 1
            int r0 = r0 + r1
            r12.f59734f = r0
            org.commonmark.internal.c r2 = r12.f59736h
            java.lang.String r3 = "]"
            if (r2 != 0) goto L_0x0011
            org.commonmark.node.Text r0 = r12.L(r3)
            return r0
        L_0x0011:
            boolean r4 = r2.f59687f
            if (r4 != 0) goto L_0x001d
            r12.H()
            org.commonmark.node.Text r0 = r12.L(r3)
            return r0
        L_0x001d:
            char r4 = r12.B()
            r5 = 40
            r6 = 0
            r7 = 0
            if (r4 != r5) goto L_0x006d
            int r4 = r12.f59734f
            int r4 = r4 + r1
            r12.f59734f = r4
            r12.K()
            java.lang.String r4 = r12.v()
            if (r4 == 0) goto L_0x006a
            r12.K()
            java.util.regex.Pattern r5 = f59727s
            java.lang.String r8 = r12.f59733e
            int r9 = r12.f59734f
            int r10 = r9 + -1
            java.lang.String r8 = r8.substring(r10, r9)
            java.util.regex.Matcher r5 = r5.matcher(r8)
            boolean r5 = r5.matches()
            if (r5 == 0) goto L_0x0056
            java.lang.String r5 = r12.x()
            r12.K()
            goto L_0x0057
        L_0x0056:
            r5 = r7
        L_0x0057:
            char r8 = r12.B()
            r9 = 41
            if (r8 != r9) goto L_0x0066
            int r8 = r12.f59734f
            int r8 = r8 + r1
            r12.f59734f = r8
            r8 = r1
            goto L_0x0070
        L_0x0066:
            r12.f59734f = r0
            r8 = r6
            goto L_0x0070
        L_0x006a:
            r8 = r6
            r5 = r7
            goto L_0x0070
        L_0x006d:
            r8 = r6
            r4 = r7
            r5 = r4
        L_0x0070:
            if (r8 != 0) goto L_0x00a8
            int r9 = r12.f59734f
            r12.w()
            int r10 = r12.f59734f
            int r10 = r10 - r9
            r11 = 2
            if (r10 <= r11) goto L_0x0085
            java.lang.String r7 = r12.f59733e
            int r10 = r10 + r9
            java.lang.String r7 = r7.substring(r9, r10)
            goto L_0x0091
        L_0x0085:
            boolean r9 = r2.f59688g
            if (r9 != 0) goto L_0x0091
            java.lang.String r7 = r12.f59733e
            int r9 = r2.f59683b
            java.lang.String r7 = r7.substring(r9, r0)
        L_0x0091:
            if (r7 == 0) goto L_0x00a8
            java.lang.String r7 = org.commonmark.internal.util.Escaping.c(r7)
            b20.b r9 = r12.f59732d
            org.commonmark.node.LinkReferenceDefinition r7 = r9.b(r7)
            if (r7 == 0) goto L_0x00a8
            java.lang.String r4 = r7.m()
            java.lang.String r5 = r7.o()
            goto L_0x00a9
        L_0x00a8:
            r1 = r8
        L_0x00a9:
            if (r1 == 0) goto L_0x00ed
            boolean r0 = r2.f59684c
            if (r0 == 0) goto L_0x00b5
            org.commonmark.node.Image r0 = new org.commonmark.node.Image
            r0.<init>(r4, r5)
            goto L_0x00ba
        L_0x00b5:
            org.commonmark.node.Link r0 = new org.commonmark.node.Link
            r0.<init>(r4, r5)
        L_0x00ba:
            org.commonmark.node.Text r1 = r2.f59682a
            org.commonmark.node.Node r1 = r1.e()
        L_0x00c0:
            if (r1 == 0) goto L_0x00cb
            org.commonmark.node.Node r3 = r1.e()
            r0.b(r1)
            r1 = r3
            goto L_0x00c0
        L_0x00cb:
            org.commonmark.internal.d r1 = r2.f59686e
            r12.C(r1)
            r12.i(r0)
            org.commonmark.node.Text r1 = r2.f59682a
            r1.l()
            r12.H()
            boolean r1 = r2.f59684c
            if (r1 != 0) goto L_0x00ec
            org.commonmark.internal.c r1 = r12.f59736h
        L_0x00e1:
            if (r1 == 0) goto L_0x00ec
            boolean r2 = r1.f59684c
            if (r2 != 0) goto L_0x00e9
            r1.f59687f = r6
        L_0x00e9:
            org.commonmark.internal.c r1 = r1.f59685d
            goto L_0x00e1
        L_0x00ec:
            return r0
        L_0x00ed:
            r12.f59734f = r0
            r12.H()
            org.commonmark.node.Text r0 = r12.L(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonmark.internal.g.q():org.commonmark.node.Node");
    }

    public final Node r(d20.a aVar, char c11) {
        a J = J(aVar, c11);
        if (J == null) {
            return null;
        }
        int i11 = J.f59737a;
        int i12 = this.f59734f;
        int i13 = i12 + i11;
        this.f59734f = i13;
        Text M = M(this.f59733e, i12, i13);
        d dVar = new d(M, c11, J.f59739c, J.f59738b, this.f59735g);
        this.f59735g = dVar;
        dVar.f59695g = i11;
        dVar.f59696h = i11;
        d dVar2 = dVar.f59693e;
        if (dVar2 != null) {
            dVar2.f59694f = dVar;
        }
        return M;
    }

    public final Node s() {
        String h11 = h(f59720l);
        if (h11 != null) {
            return L(Html5Entities.a(h11));
        }
        return null;
    }

    public final Node t() {
        String h11 = h(f59718j);
        if (h11 == null) {
            return null;
        }
        HtmlInline htmlInline = new HtmlInline();
        htmlInline.n(h11);
        return htmlInline;
    }

    public final Node u(Node node) {
        Node node2;
        char B = B();
        if (B == 0) {
            return null;
        }
        if (B == 10) {
            node2 = y(node);
        } else if (B == '!') {
            node2 = p();
        } else if (B == '&') {
            node2 = s();
        } else if (B == '<') {
            node2 = m();
            if (node2 == null) {
                node2 = t();
            }
        } else if (B != '`') {
            switch (B) {
                case '[':
                    node2 = z();
                    break;
                case '\\':
                    node2 = n();
                    break;
                case ']':
                    node2 = q();
                    break;
                default:
                    if (!this.f59730b.get(B)) {
                        node2 = A();
                        break;
                    } else {
                        node2 = r(this.f59731c.get(Character.valueOf(B)), B);
                        break;
                    }
            }
        } else {
            node2 = o();
        }
        if (node2 != null) {
            return node2;
        }
        this.f59734f++;
        return L(String.valueOf(B));
    }

    public final String v() {
        String str;
        int a11 = LinkScanner.a(this.f59733e, this.f59734f);
        if (a11 == -1) {
            return null;
        }
        if (B() == '<') {
            str = this.f59733e.substring(this.f59734f + 1, a11 - 1);
        } else {
            str = this.f59733e.substring(this.f59734f, a11);
        }
        this.f59734f = a11;
        return Escaping.e(str);
    }

    public int w() {
        if (this.f59734f < this.f59733e.length() && this.f59733e.charAt(this.f59734f) == '[') {
            int i11 = this.f59734f + 1;
            int c11 = LinkScanner.c(this.f59733e, i11);
            int i12 = c11 - i11;
            if (c11 != -1 && i12 <= 999 && c11 < this.f59733e.length() && this.f59733e.charAt(c11) == ']') {
                this.f59734f = c11 + 1;
                return i12 + 2;
            }
        }
        return 0;
    }

    public final String x() {
        int d11 = LinkScanner.d(this.f59733e, this.f59734f);
        if (d11 == -1) {
            return null;
        }
        String substring = this.f59733e.substring(this.f59734f + 1, d11 - 1);
        this.f59734f = d11;
        return Escaping.e(substring);
    }

    public final Node y(Node node) {
        this.f59734f++;
        if (node instanceof Text) {
            Text text = (Text) node;
            if (text.m().endsWith(" ")) {
                String m11 = text.m();
                Matcher matcher = f59728t.matcher(m11);
                int end = matcher.find() ? matcher.end() - matcher.start() : 0;
                if (end > 0) {
                    text.n(m11.substring(0, m11.length() - end));
                }
                if (end >= 2) {
                    return new HardLineBreak();
                }
                return new SoftLineBreak();
            }
        }
        return new SoftLineBreak();
    }

    public final Node z() {
        int i11 = this.f59734f;
        this.f59734f = i11 + 1;
        Text L = L("[");
        b(c.b(L, i11, this.f59736h, this.f59735g));
        return L;
    }
}
