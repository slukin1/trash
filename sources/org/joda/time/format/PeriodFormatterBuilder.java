package org.joda.time.format;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;
import org.joda.time.DurationFieldType;
import org.joda.time.PeriodType;
import org.joda.time.i;

public class PeriodFormatterBuilder {

    /* renamed from: j  reason: collision with root package name */
    public static final ConcurrentMap<String, Pattern> f23160j = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    public int f23161a;

    /* renamed from: b  reason: collision with root package name */
    public int f23162b;

    /* renamed from: c  reason: collision with root package name */
    public int f23163c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23164d;

    /* renamed from: e  reason: collision with root package name */
    public f f23165e;

    /* renamed from: f  reason: collision with root package name */
    public List<Object> f23166f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23167g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23168h;

    /* renamed from: i  reason: collision with root package name */
    public c[] f23169i;

    public static class a implements p, o {

        /* renamed from: a  reason: collision with root package name */
        public final p[] f23170a;

        /* renamed from: b  reason: collision with root package name */
        public final o[] f23171b;

        public a(List<Object> list) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            f(list, arrayList, arrayList2);
            if (arrayList.size() <= 0) {
                this.f23170a = null;
            } else {
                this.f23170a = (p[]) arrayList.toArray(new p[arrayList.size()]);
            }
            if (arrayList2.size() <= 0) {
                this.f23171b = null;
            } else {
                this.f23171b = (o[]) arrayList2.toArray(new o[arrayList2.size()]);
            }
        }

        public int a(i iVar, int i11, Locale locale) {
            p[] pVarArr = this.f23170a;
            int length = pVarArr.length;
            int i12 = 0;
            while (i12 < i11) {
                length--;
                if (length < 0) {
                    break;
                }
                i12 += pVarArr[length].a(iVar, Integer.MAX_VALUE, locale);
            }
            return i12;
        }

        public void b(StringBuffer stringBuffer, i iVar, Locale locale) {
            for (p b11 : this.f23170a) {
                b11.b(stringBuffer, iVar, locale);
            }
        }

        public int c(org.joda.time.c cVar, String str, int i11, Locale locale) {
            o[] oVarArr = this.f23171b;
            if (oVarArr != null) {
                int length = oVarArr.length;
                for (int i12 = 0; i12 < length && i11 >= 0; i12++) {
                    i11 = oVarArr[i12].c(cVar, str, i11, locale);
                }
                return i11;
            }
            throw new UnsupportedOperationException();
        }

        public int d(i iVar, Locale locale) {
            p[] pVarArr = this.f23170a;
            int length = pVarArr.length;
            int i11 = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return i11;
                }
                i11 += pVarArr[length].d(iVar, locale);
            }
        }

        public final void e(List<Object> list, Object[] objArr) {
            if (objArr != null) {
                for (Object add : objArr) {
                    list.add(add);
                }
            }
        }

        public final void f(List<Object> list, List<Object> list2, List<Object> list3) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11 += 2) {
                Object obj = list.get(i11);
                if (obj instanceof p) {
                    if (obj instanceof a) {
                        e(list2, ((a) obj).f23170a);
                    } else {
                        list2.add(obj);
                    }
                }
                Object obj2 = list.get(i11 + 1);
                if (obj2 instanceof o) {
                    if (obj2 instanceof a) {
                        e(list3, ((a) obj2).f23171b);
                    } else {
                        list3.add(obj2);
                    }
                }
            }
        }
    }

    public static class b extends d {

        /* renamed from: b  reason: collision with root package name */
        public final f f23172b;

        /* renamed from: c  reason: collision with root package name */
        public final f f23173c;

        /* renamed from: d  reason: collision with root package name */
        public final String[] f23174d;

        public b(f fVar, f fVar2) {
            this.f23172b = fVar;
            this.f23173c = fVar2;
            HashSet hashSet = new HashSet();
            for (String str : fVar.e()) {
                for (String str2 : this.f23173c.e()) {
                    hashSet.add(str + str2);
                }
            }
            this.f23174d = (String[]) hashSet.toArray(new String[hashSet.size()]);
        }

        public int a(String str, int i11) {
            int a11;
            int a12 = this.f23172b.a(str, i11);
            if (a12 < 0 || ((a11 = this.f23173c.a(str, this.f23172b.b(str, a12))) >= 0 && g(this.f23173c.b(str, a11) - a12, str, i11))) {
                return ~i11;
            }
            return a12 > 0 ? a12 : a11;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
            r0 = r2.f23173c.b(r3, r0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int b(java.lang.String r3, int r4) {
            /*
                r2 = this;
                org.joda.time.format.PeriodFormatterBuilder$f r0 = r2.f23172b
                int r0 = r0.b(r3, r4)
                if (r0 < 0) goto L_0x001d
                org.joda.time.format.PeriodFormatterBuilder$f r1 = r2.f23173c
                int r0 = r1.b(r3, r0)
                if (r0 < 0) goto L_0x001d
                int r1 = r2.b(r3, r0)
                int r1 = r1 - r0
                boolean r3 = r2.g(r1, r3, r4)
                if (r3 == 0) goto L_0x001d
                int r3 = ~r4
                return r3
            L_0x001d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.PeriodFormatterBuilder.b.b(java.lang.String, int):int");
        }

        public void c(StringBuffer stringBuffer, int i11) {
            this.f23172b.c(stringBuffer, i11);
            this.f23173c.c(stringBuffer, i11);
        }

        public int d(int i11) {
            return this.f23172b.d(i11) + this.f23173c.d(i11);
        }

        public String[] e() {
            return (String[]) this.f23174d.clone();
        }
    }

    public static abstract class d implements f {

        /* renamed from: a  reason: collision with root package name */
        public volatile String[] f23183a;

        public void f(Set<f> set) {
            if (this.f23183a == null) {
                int i11 = Integer.MAX_VALUE;
                String str = null;
                for (String str2 : e()) {
                    if (str2.length() < i11) {
                        i11 = str2.length();
                        str = str2;
                    }
                }
                HashSet hashSet = new HashSet();
                for (f next : set) {
                    if (next != null) {
                        for (String str3 : next.e()) {
                            if (str3.length() > i11 || (str3.equalsIgnoreCase(str) && !str3.equals(str))) {
                                hashSet.add(str3);
                            }
                        }
                    }
                }
                this.f23183a = (String[]) hashSet.toArray(new String[hashSet.size()]);
            }
        }

        public boolean g(int i11, String str, int i12) {
            if (this.f23183a != null) {
                for (String str2 : this.f23183a) {
                    int length = str2.length();
                    if (i11 < length && str.regionMatches(true, i12, str2, 0, length)) {
                        return true;
                    }
                    if (i11 == length && str.regionMatches(false, i12, str2, 0, length)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static class e implements p, o {

        /* renamed from: b  reason: collision with root package name */
        public static final e f23184b = new e("");

        /* renamed from: a  reason: collision with root package name */
        public final String f23185a;

        public e(String str) {
            this.f23185a = str;
        }

        public int a(i iVar, int i11, Locale locale) {
            return 0;
        }

        public void b(StringBuffer stringBuffer, i iVar, Locale locale) {
            stringBuffer.append(this.f23185a);
        }

        public int c(org.joda.time.c cVar, String str, int i11, Locale locale) {
            String str2 = this.f23185a;
            return str.regionMatches(true, i11, str2, 0, str2.length()) ? i11 + this.f23185a.length() : ~i11;
        }

        public int d(i iVar, Locale locale) {
            return this.f23185a.length();
        }
    }

    public interface f {
        int a(String str, int i11);

        int b(String str, int i11);

        void c(StringBuffer stringBuffer, int i11);

        int d(int i11);

        String[] e();

        void f(Set<f> set);
    }

    public static class g implements p, o {

        /* renamed from: a  reason: collision with root package name */
        public final String f23186a;

        /* renamed from: b  reason: collision with root package name */
        public final String f23187b;

        /* renamed from: c  reason: collision with root package name */
        public final String[] f23188c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f23189d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f23190e;

        /* renamed from: f  reason: collision with root package name */
        public final p f23191f;

        /* renamed from: g  reason: collision with root package name */
        public volatile p f23192g;

        /* renamed from: h  reason: collision with root package name */
        public final o f23193h;

        /* renamed from: i  reason: collision with root package name */
        public volatile o f23194i;

        public g(String str, String str2, String[] strArr, p pVar, o oVar, boolean z11, boolean z12) {
            this.f23186a = str;
            this.f23187b = str2;
            if ((str2 == null || str.equals(str2)) && (strArr == null || strArr.length == 0)) {
                this.f23188c = new String[]{str};
            } else {
                TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                treeSet.add(str);
                treeSet.add(str2);
                if (strArr != null) {
                    int length = strArr.length;
                    while (true) {
                        length--;
                        if (length < 0) {
                            break;
                        }
                        treeSet.add(strArr[length]);
                    }
                }
                ArrayList arrayList = new ArrayList(treeSet);
                Collections.reverse(arrayList);
                this.f23188c = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            this.f23191f = pVar;
            this.f23193h = oVar;
            this.f23189d = z11;
            this.f23190e = z12;
        }

        public int a(i iVar, int i11, Locale locale) {
            int a11 = this.f23191f.a(iVar, i11, locale);
            return a11 < i11 ? a11 + this.f23192g.a(iVar, i11, locale) : a11;
        }

        public void b(StringBuffer stringBuffer, i iVar, Locale locale) {
            p pVar = this.f23191f;
            p pVar2 = this.f23192g;
            pVar.b(stringBuffer, iVar, locale);
            if (this.f23189d) {
                if (pVar.a(iVar, 1, locale) > 0) {
                    if (this.f23190e) {
                        int a11 = pVar2.a(iVar, 2, locale);
                        if (a11 > 0) {
                            stringBuffer.append(a11 > 1 ? this.f23186a : this.f23187b);
                        }
                    } else {
                        stringBuffer.append(this.f23186a);
                    }
                }
            } else if (this.f23190e && pVar2.a(iVar, 1, locale) > 0) {
                stringBuffer.append(this.f23186a);
            }
            pVar2.b(stringBuffer, iVar, locale);
        }

        public int c(org.joda.time.c cVar, String str, int i11, Locale locale) {
            String str2;
            org.joda.time.c cVar2 = cVar;
            String str3 = str;
            int i12 = i11;
            Locale locale2 = locale;
            int c11 = this.f23193h.c(cVar2, str3, i12, locale2);
            if (c11 < 0) {
                return c11;
            }
            int i13 = -1;
            boolean z11 = false;
            if (c11 > i12) {
                String[] strArr = this.f23188c;
                int length = strArr.length;
                int i14 = 0;
                while (true) {
                    if (i14 < length) {
                        str2 = strArr[i14];
                        if (str2 == null || str2.length() == 0) {
                            break;
                        }
                        if (str.regionMatches(true, c11, str2, 0, str2.length())) {
                            break;
                        }
                        i14++;
                    } else {
                        break;
                    }
                }
                if (str2 == null) {
                    i13 = 0;
                } else {
                    i13 = str2.length();
                }
                c11 += i13;
                z11 = true;
            }
            int c12 = this.f23194i.c(cVar2, str3, c11, locale2);
            if (c12 < 0) {
                return c12;
            }
            if (!z11 || c12 != c11 || i13 <= 0) {
                return (c12 <= c11 || z11 || this.f23189d) ? c12 : ~c11;
            }
            return ~c11;
        }

        public int d(i iVar, Locale locale) {
            int i11;
            p pVar = this.f23191f;
            p pVar2 = this.f23192g;
            int d11 = pVar.d(iVar, locale) + pVar2.d(iVar, locale);
            if (this.f23189d) {
                if (pVar.a(iVar, 1, locale) <= 0) {
                    return d11;
                }
                if (this.f23190e) {
                    int a11 = pVar2.a(iVar, 2, locale);
                    if (a11 <= 0) {
                        return d11;
                    }
                    i11 = (a11 > 1 ? this.f23186a : this.f23187b).length();
                } else {
                    i11 = this.f23186a.length();
                }
            } else if (!this.f23190e || pVar2.a(iVar, 1, locale) <= 0) {
                return d11;
            } else {
                i11 = this.f23186a.length();
            }
            return d11 + i11;
        }

        public g g(p pVar, o oVar) {
            this.f23192g = pVar;
            this.f23194i = oVar;
            return this;
        }
    }

    public static class h extends d {

        /* renamed from: b  reason: collision with root package name */
        public final String f23195b;

        public h(String str) {
            this.f23195b = str;
        }

        public int a(String str, int i11) {
            String str2 = this.f23195b;
            int length = str2.length();
            int length2 = str.length();
            int i12 = i11;
            while (i12 < length2) {
                if (str.regionMatches(true, i12, str2, 0, length) && !g(length, str, i12)) {
                    return i12;
                }
                switch (str.charAt(i12)) {
                    case '+':
                    case ',':
                    case '-':
                    case '.':
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        i12++;
                }
                return ~i11;
            }
            return ~i11;
        }

        public int b(String str, int i11) {
            String str2 = this.f23195b;
            int length = str2.length();
            return (!str.regionMatches(true, i11, str2, 0, length) || g(length, str, i11)) ? ~i11 : i11 + length;
        }

        public void c(StringBuffer stringBuffer, int i11) {
            stringBuffer.append(this.f23195b);
        }

        public int d(int i11) {
            return this.f23195b.length();
        }

        public String[] e() {
            return new String[]{this.f23195b};
        }
    }

    public PeriodFormatterBuilder() {
        p();
    }

    public static Object[] r(List<Object> list) {
        int size = list.size();
        if (size == 0) {
            e eVar = e.f23184b;
            return new Object[]{eVar, eVar};
        } else if (size != 1) {
            a aVar = new a(list);
            return new Object[]{aVar, aVar};
        } else {
            return new Object[]{list.get(0), list.get(1)};
        }
    }

    public static n t(List<Object> list, boolean z11, boolean z12) {
        if (!z11 || !z12) {
            int size = list.size();
            if (size >= 2 && (list.get(0) instanceof g)) {
                g gVar = (g) list.get(0);
                if (gVar.f23194i == null && gVar.f23192g == null) {
                    n t11 = t(list.subList(2, size), z11, z12);
                    g g11 = gVar.g(t11.e(), t11.d());
                    return new n(g11, g11);
                }
            }
            Object[] r11 = r(list);
            if (z11) {
                return new n((p) null, (o) r11[1]);
            }
            if (z12) {
                return new n((p) r11[0], (o) null);
            }
            return new n((p) r11[0], (o) r11[1]);
        }
        throw new IllegalStateException("Builder has created neither a printer nor a parser");
    }

    public final PeriodFormatterBuilder a(p pVar, o oVar) {
        this.f23166f.add(pVar);
        this.f23166f.add(oVar);
        boolean z11 = true;
        this.f23167g = (pVar == null) | this.f23167g;
        boolean z12 = this.f23168h;
        if (oVar != null) {
            z11 = false;
        }
        this.f23168h = z12 | z11;
        return this;
    }

    public PeriodFormatterBuilder b() {
        c(3);
        return this;
    }

    public final void c(int i11) {
        d(i11, this.f23161a);
    }

    public final void d(int i11, int i12) {
        c cVar = new c(i12, this.f23162b, this.f23163c, this.f23164d, i11, this.f23169i, this.f23165e, (f) null);
        a(cVar, cVar);
        this.f23169i[i11] = cVar;
        this.f23165e = null;
    }

    public PeriodFormatterBuilder e() {
        c(4);
        return this;
    }

    public PeriodFormatterBuilder f(String str) {
        if (str != null) {
            q();
            e eVar = new e(str);
            a(eVar, eVar);
            return this;
        }
        throw new IllegalArgumentException("Literal must not be null");
    }

    public PeriodFormatterBuilder g() {
        c(5);
        return this;
    }

    public PeriodFormatterBuilder h() {
        c(1);
        return this;
    }

    public PeriodFormatterBuilder i() {
        c(9);
        return this;
    }

    public final PeriodFormatterBuilder j(String str, String str2, String[] strArr, boolean z11, boolean z12) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException();
        }
        q();
        List<Object> list = this.f23166f;
        if (list.size() == 0) {
            if (z12 && !z11) {
                e eVar = e.f23184b;
                g gVar = new g(str, str2, strArr, eVar, eVar, z11, z12);
                a(gVar, gVar);
            }
            return this;
        }
        g gVar2 = null;
        int size = list.size();
        while (true) {
            int i11 = size - 1;
            if (i11 < 0) {
                break;
            } else if (list.get(i11) instanceof g) {
                gVar2 = (g) list.get(i11);
                list = list.subList(i11 + 1, list.size());
                break;
            } else {
                size = i11 - 1;
            }
        }
        List<Object> list2 = list;
        if (gVar2 == null || list2.size() != 0) {
            Object[] r11 = r(list2);
            list2.clear();
            g gVar3 = new g(str, str2, strArr, (p) r11[0], (o) r11[1], z11, z12);
            list2.add(gVar3);
            list2.add(gVar3);
            return this;
        }
        throw new IllegalStateException("Cannot have two adjacent separators");
    }

    public PeriodFormatterBuilder k(String str) {
        return j(str, str, (String[]) null, false, true);
    }

    public PeriodFormatterBuilder l(String str) {
        if (str != null) {
            return m(new h(str));
        }
        throw new IllegalArgumentException();
    }

    public final PeriodFormatterBuilder m(f fVar) {
        Object obj;
        Object obj2 = null;
        if (this.f23166f.size() > 0) {
            List<Object> list = this.f23166f;
            obj2 = list.get(list.size() - 2);
            List<Object> list2 = this.f23166f;
            obj = list2.get(list2.size() - 1);
        } else {
            obj = null;
        }
        if (obj2 == null || obj == null || obj2 != obj || !(obj2 instanceof c)) {
            throw new IllegalStateException("No field to apply suffix to");
        }
        q();
        c cVar = new c((c) obj2, fVar);
        List<Object> list3 = this.f23166f;
        list3.set(list3.size() - 2, cVar);
        List<Object> list4 = this.f23166f;
        list4.set(list4.size() - 1, cVar);
        this.f23169i[cVar.f()] = cVar;
        return this;
    }

    public PeriodFormatterBuilder n() {
        c(2);
        return this;
    }

    public PeriodFormatterBuilder o() {
        c(0);
        return this;
    }

    public void p() {
        this.f23161a = 1;
        this.f23162b = 2;
        this.f23163c = 10;
        this.f23164d = false;
        this.f23165e = null;
        List<Object> list = this.f23166f;
        if (list == null) {
            this.f23166f = new ArrayList();
        } else {
            list.clear();
        }
        this.f23167g = false;
        this.f23168h = false;
        this.f23169i = new c[10];
    }

    public final void q() throws IllegalStateException {
        if (this.f23165e == null) {
            this.f23165e = null;
            return;
        }
        throw new IllegalStateException("Prefix not followed by field");
    }

    public n s() {
        n t11 = t(this.f23166f, this.f23167g, this.f23168h);
        for (c cVar : this.f23169i) {
            if (cVar != null) {
                cVar.e(this.f23169i);
            }
        }
        this.f23169i = (c[]) this.f23169i.clone();
        return t11;
    }

    public static class c implements p, o {

        /* renamed from: a  reason: collision with root package name */
        public final int f23175a;

        /* renamed from: b  reason: collision with root package name */
        public final int f23176b;

        /* renamed from: c  reason: collision with root package name */
        public final int f23177c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f23178d;

        /* renamed from: e  reason: collision with root package name */
        public final int f23179e;

        /* renamed from: f  reason: collision with root package name */
        public final c[] f23180f;

        /* renamed from: g  reason: collision with root package name */
        public final f f23181g;

        /* renamed from: h  reason: collision with root package name */
        public final f f23182h;

        public c(int i11, int i12, int i13, boolean z11, int i14, c[] cVarArr, f fVar, f fVar2) {
            this.f23175a = i11;
            this.f23176b = i12;
            this.f23177c = i13;
            this.f23178d = z11;
            this.f23179e = i14;
            this.f23180f = cVarArr;
            this.f23181g = fVar;
            this.f23182h = fVar2;
        }

        public int a(i iVar, int i11, Locale locale) {
            if (i11 <= 0) {
                return 0;
            }
            return (this.f23176b == 4 || g(iVar) != Long.MAX_VALUE) ? 1 : 0;
        }

        public void b(StringBuffer stringBuffer, i iVar, Locale locale) {
            long g11 = g(iVar);
            if (g11 != Long.MAX_VALUE) {
                int i11 = (int) g11;
                if (this.f23179e >= 8) {
                    i11 = (int) (g11 / 1000);
                }
                f fVar = this.f23181g;
                if (fVar != null) {
                    fVar.c(stringBuffer, i11);
                }
                int length = stringBuffer.length();
                int i12 = this.f23175a;
                if (i12 <= 1) {
                    h.e(stringBuffer, i11);
                } else {
                    h.b(stringBuffer, i11, i12);
                }
                if (this.f23179e >= 8) {
                    int abs = (int) (Math.abs(g11) % 1000);
                    if (this.f23179e == 8 || abs > 0) {
                        if (g11 < 0 && g11 > -1000) {
                            stringBuffer.insert(length, '-');
                        }
                        stringBuffer.append('.');
                        h.b(stringBuffer, abs, 3);
                    }
                }
                f fVar2 = this.f23182h;
                if (fVar2 != null) {
                    fVar2.c(stringBuffer, i11);
                }
            }
        }

        public int c(org.joda.time.c cVar, String str, int i11, Locale locale) {
            int i12;
            int i13;
            f fVar;
            int i14;
            int i15;
            char charAt;
            org.joda.time.c cVar2 = cVar;
            String str2 = str;
            int i16 = i11;
            boolean z11 = this.f23176b == 4;
            if (i16 >= str.length()) {
                return z11 ? ~i16 : i16;
            }
            f fVar2 = this.f23181g;
            if (fVar2 != null) {
                i16 = fVar2.b(str2, i16);
                if (i16 < 0) {
                    return !z11 ? ~i16 : i16;
                }
                z11 = true;
            }
            f fVar3 = this.f23182h;
            int i17 = -1;
            if (fVar3 == null || z11) {
                i12 = -1;
            } else {
                i12 = fVar3.a(str2, i16);
                if (i12 < 0) {
                    return !z11 ? ~i12 : i12;
                }
                z11 = true;
            }
            if (!z11 && !h(cVar.getPeriodType(), this.f23179e)) {
                return i16;
            }
            if (i12 > 0) {
                i13 = Math.min(this.f23177c, i12 - i16);
            } else {
                i13 = Math.min(this.f23177c, str.length() - i16);
            }
            int i18 = 0;
            boolean z12 = false;
            while (i18 < i13) {
                int i19 = i16 + i18;
                char charAt2 = str2.charAt(i19);
                if (i18 == 0 && ((charAt2 == '-' || charAt2 == '+') && !this.f23178d)) {
                    boolean z13 = charAt2 == '-';
                    int i21 = i18 + 1;
                    if (i21 >= i13 || (charAt = str2.charAt(i19 + 1)) < '0' || charAt > '9') {
                        break;
                    }
                    if (z13) {
                        i18 = i21;
                    } else {
                        i16++;
                    }
                    i13 = Math.min(i13 + 1, str.length() - i16);
                } else {
                    if (charAt2 < '0' || charAt2 > '9') {
                        if ((charAt2 != '.' && charAt2 != ',') || (((i15 = this.f23179e) != 8 && i15 != 9) || i17 >= 0)) {
                            break;
                        }
                        i13 = Math.min(i13 + 1, str.length() - i16);
                        i17 = i19 + 1;
                    } else {
                        z12 = true;
                    }
                    i18++;
                }
            }
            if (!z12) {
                return ~i16;
            }
            if (i12 >= 0 && i16 + i18 != i12) {
                return i16;
            }
            int i22 = this.f23179e;
            if (i22 != 8 && i22 != 9) {
                k(cVar2, i22, j(str2, i16, i18));
            } else if (i17 < 0) {
                k(cVar2, 6, j(str2, i16, i18));
                k(cVar2, 7, 0);
            } else {
                int j11 = j(str2, i16, (i17 - i16) - 1);
                k(cVar2, 6, j11);
                int i23 = (i16 + i18) - i17;
                if (i23 <= 0) {
                    i14 = 0;
                } else {
                    if (i23 >= 3) {
                        i14 = j(str2, i17, 3);
                    } else {
                        int j12 = j(str2, i17, i23);
                        i14 = i23 == 1 ? j12 * 100 : j12 * 10;
                    }
                    if (j11 < 0) {
                        i14 = -i14;
                    }
                }
                k(cVar2, 7, i14);
            }
            int i24 = i16 + i18;
            return (i24 < 0 || (fVar = this.f23182h) == null) ? i24 : fVar.b(str2, i24);
        }

        public int d(i iVar, Locale locale) {
            long g11 = g(iVar);
            if (g11 == Long.MAX_VALUE) {
                return 0;
            }
            int max = Math.max(h.g(g11), this.f23175a);
            if (this.f23179e >= 8) {
                max = Math.max(max, g11 < 0 ? 5 : 4) + 1;
                if (this.f23179e == 9 && Math.abs(g11) % 1000 == 0) {
                    max -= 4;
                }
                g11 /= 1000;
            }
            int i11 = (int) g11;
            f fVar = this.f23181g;
            if (fVar != null) {
                max += fVar.d(i11);
            }
            f fVar2 = this.f23182h;
            return fVar2 != null ? max + fVar2.d(i11) : max;
        }

        public void e(c[] cVarArr) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (c cVar : cVarArr) {
                if (cVar != null && !equals(cVar)) {
                    hashSet.add(cVar.f23181g);
                    hashSet2.add(cVar.f23182h);
                }
            }
            f fVar = this.f23181g;
            if (fVar != null) {
                fVar.f(hashSet);
            }
            f fVar2 = this.f23182h;
            if (fVar2 != null) {
                fVar2.f(hashSet2);
            }
        }

        public int f() {
            return this.f23179e;
        }

        public long g(i iVar) {
            PeriodType periodType;
            long j11;
            int i11;
            if (this.f23176b == 4) {
                periodType = null;
            } else {
                periodType = iVar.getPeriodType();
            }
            if (periodType != null && !h(periodType, this.f23179e)) {
                return Long.MAX_VALUE;
            }
            switch (this.f23179e) {
                case 0:
                    i11 = iVar.get(DurationFieldType.years());
                    break;
                case 1:
                    i11 = iVar.get(DurationFieldType.months());
                    break;
                case 2:
                    i11 = iVar.get(DurationFieldType.weeks());
                    break;
                case 3:
                    i11 = iVar.get(DurationFieldType.days());
                    break;
                case 4:
                    i11 = iVar.get(DurationFieldType.hours());
                    break;
                case 5:
                    i11 = iVar.get(DurationFieldType.minutes());
                    break;
                case 6:
                    i11 = iVar.get(DurationFieldType.seconds());
                    break;
                case 7:
                    i11 = iVar.get(DurationFieldType.millis());
                    break;
                case 8:
                case 9:
                    j11 = (((long) iVar.get(DurationFieldType.seconds())) * 1000) + ((long) iVar.get(DurationFieldType.millis()));
                    break;
                default:
                    return Long.MAX_VALUE;
            }
            j11 = (long) i11;
            if (j11 == 0) {
                int i12 = this.f23176b;
                if (i12 == 1) {
                    if (i(iVar)) {
                        c[] cVarArr = this.f23180f;
                        int i13 = this.f23179e;
                        if (cVarArr[i13] == this) {
                            int min = Math.min(i13, 8);
                            while (true) {
                                min--;
                                if (min >= 0 && min <= 9) {
                                    if (!h(periodType, min) || this.f23180f[min] == null) {
                                    }
                                }
                            }
                        }
                    }
                    return Long.MAX_VALUE;
                } else if (i12 == 2) {
                    if (i(iVar)) {
                        c[] cVarArr2 = this.f23180f;
                        int i14 = this.f23179e;
                        if (cVarArr2[i14] == this) {
                            for (int i15 = i14 + 1; i15 <= 9; i15++) {
                                if (h(periodType, i15) && this.f23180f[i15] != null) {
                                    return Long.MAX_VALUE;
                                }
                            }
                        }
                    }
                    return Long.MAX_VALUE;
                } else if (i12 != 5) {
                    return j11;
                } else {
                    return Long.MAX_VALUE;
                }
            }
            return j11;
        }

        public boolean h(PeriodType periodType, int i11) {
            switch (i11) {
                case 0:
                    return periodType.isSupported(DurationFieldType.years());
                case 1:
                    return periodType.isSupported(DurationFieldType.months());
                case 2:
                    return periodType.isSupported(DurationFieldType.weeks());
                case 3:
                    return periodType.isSupported(DurationFieldType.days());
                case 4:
                    return periodType.isSupported(DurationFieldType.hours());
                case 5:
                    return periodType.isSupported(DurationFieldType.minutes());
                case 6:
                    return periodType.isSupported(DurationFieldType.seconds());
                case 7:
                    return periodType.isSupported(DurationFieldType.millis());
                case 8:
                case 9:
                    return periodType.isSupported(DurationFieldType.seconds()) || periodType.isSupported(DurationFieldType.millis());
                default:
                    return false;
            }
        }

        public boolean i(i iVar) {
            int size = iVar.size();
            for (int i11 = 0; i11 < size; i11++) {
                if (iVar.getValue(i11) != 0) {
                    return false;
                }
            }
            return true;
        }

        public final int j(String str, int i11, int i12) {
            if (i12 >= 10) {
                return Integer.parseInt(str.substring(i11, i12 + i11));
            }
            boolean z11 = false;
            if (i12 <= 0) {
                return 0;
            }
            int i13 = i11 + 1;
            char charAt = str.charAt(i11);
            int i14 = i12 - 1;
            if (charAt == '-') {
                i14--;
                if (i14 < 0) {
                    return 0;
                }
                char charAt2 = str.charAt(i13);
                i13++;
                charAt = charAt2;
                z11 = true;
            }
            int i15 = charAt - '0';
            while (true) {
                int i16 = i14 - 1;
                if (i14 <= 0) {
                    break;
                }
                i13++;
                i15 = (((i15 << 3) + (i15 << 1)) + str.charAt(i13)) - 48;
                i14 = i16;
            }
            return z11 ? -i15 : i15;
        }

        public void k(org.joda.time.c cVar, int i11, int i12) {
            switch (i11) {
                case 0:
                    cVar.setYears(i12);
                    return;
                case 1:
                    cVar.setMonths(i12);
                    return;
                case 2:
                    cVar.setWeeks(i12);
                    return;
                case 3:
                    cVar.setDays(i12);
                    return;
                case 4:
                    cVar.setHours(i12);
                    return;
                case 5:
                    cVar.setMinutes(i12);
                    return;
                case 6:
                    cVar.setSeconds(i12);
                    return;
                case 7:
                    cVar.setMillis(i12);
                    return;
                default:
                    return;
            }
        }

        public c(c cVar, f fVar) {
            this.f23175a = cVar.f23175a;
            this.f23176b = cVar.f23176b;
            this.f23177c = cVar.f23177c;
            this.f23178d = cVar.f23178d;
            this.f23179e = cVar.f23179e;
            this.f23180f = cVar.f23180f;
            this.f23181g = cVar.f23181g;
            f fVar2 = cVar.f23182h;
            this.f23182h = fVar2 != null ? new b(fVar2, fVar) : fVar;
        }
    }
}
