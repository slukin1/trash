package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.i;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.l;
import kotlin.text.Regex;

public final class NavDeepLink {

    /* renamed from: q  reason: collision with root package name */
    public static final a f10284q = new a((r) null);

    /* renamed from: r  reason: collision with root package name */
    public static final Pattern f10285r = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");

    /* renamed from: s  reason: collision with root package name */
    public static final Pattern f10286s = Pattern.compile("\\{(.+?)\\}");

    /* renamed from: a  reason: collision with root package name */
    public final String f10287a;

    /* renamed from: b  reason: collision with root package name */
    public final String f10288b;

    /* renamed from: c  reason: collision with root package name */
    public final String f10289c;

    /* renamed from: d  reason: collision with root package name */
    public final List<String> f10290d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public String f10291e;

    /* renamed from: f  reason: collision with root package name */
    public final i f10292f = LazyKt__LazyJVMKt.a(new NavDeepLink$pathPattern$2(this));

    /* renamed from: g  reason: collision with root package name */
    public final i f10293g = LazyKt__LazyJVMKt.a(new NavDeepLink$isParameterizedQuery$2(this));

    /* renamed from: h  reason: collision with root package name */
    public final i f10294h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f10295i;

    /* renamed from: j  reason: collision with root package name */
    public final i f10296j;

    /* renamed from: k  reason: collision with root package name */
    public final i f10297k;

    /* renamed from: l  reason: collision with root package name */
    public final i f10298l;

    /* renamed from: m  reason: collision with root package name */
    public final i f10299m;

    /* renamed from: n  reason: collision with root package name */
    public String f10300n;

    /* renamed from: o  reason: collision with root package name */
    public final i f10301o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f10302p;

    public static final class Builder {

        /* renamed from: d  reason: collision with root package name */
        public static final a f10303d = new a((r) null);

        /* renamed from: a  reason: collision with root package name */
        public String f10304a;

        /* renamed from: b  reason: collision with root package name */
        public String f10305b;

        /* renamed from: c  reason: collision with root package name */
        public String f10306c;

        public static final class a {
            public a() {
            }

            public /* synthetic */ a(r rVar) {
                this();
            }
        }

        public final NavDeepLink a() {
            return new NavDeepLink(this.f10304a, this.f10305b, this.f10306c);
        }

        public final Builder b(String str) {
            if (str.length() > 0) {
                this.f10305b = str;
                return this;
            }
            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.".toString());
        }

        public final Builder c(String str) {
            this.f10306c = str;
            return this;
        }

        public final Builder d(String str) {
            this.f10304a = str;
            return this;
        }
    }

    public static final class ParamQuery {

        /* renamed from: a  reason: collision with root package name */
        public String f10307a;

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f10308b = new ArrayList();

        public final void a(String str) {
            this.f10308b.add(str);
        }

        public final List<String> b() {
            return this.f10308b;
        }

        public final String c() {
            return this.f10307a;
        }

        public final void d(String str) {
            this.f10307a = str;
        }
    }

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final class b implements Comparable<b> {

        /* renamed from: b  reason: collision with root package name */
        public String f10309b;

        /* renamed from: c  reason: collision with root package name */
        public String f10310c;

        public b(String str) {
            List list;
            boolean z11;
            List<String> split = new Regex("/").split(str, 0);
            if (!split.isEmpty()) {
                ListIterator<String> listIterator = split.listIterator(split.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        break;
                    }
                    if (listIterator.previous().length() == 0) {
                        z11 = true;
                        continue;
                    } else {
                        z11 = false;
                        continue;
                    }
                    if (!z11) {
                        list = CollectionsKt___CollectionsKt.B0(split, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                this.f10309b = (String) list.get(0);
                this.f10310c = (String) list.get(1);
            }
            list = CollectionsKt__CollectionsKt.k();
            this.f10309b = (String) list.get(0);
            this.f10310c = (String) list.get(1);
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            int i11 = x.b(this.f10309b, bVar.f10309b) ? 2 : 0;
            return x.b(this.f10310c, bVar.f10310c) ? i11 + 1 : i11;
        }

        public final String b() {
            return this.f10310c;
        }

        public final String getType() {
            return this.f10309b;
        }
    }

    public NavDeepLink(String str, String str2, String str3) {
        this.f10287a = str;
        this.f10288b = str2;
        this.f10289c = str3;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.f10294h = LazyKt__LazyJVMKt.b(lazyThreadSafetyMode, new NavDeepLink$queryArgsMap$2(this));
        this.f10296j = LazyKt__LazyJVMKt.b(lazyThreadSafetyMode, new NavDeepLink$fragArgsAndRegex$2(this));
        this.f10297k = LazyKt__LazyJVMKt.b(lazyThreadSafetyMode, new NavDeepLink$fragArgs$2(this));
        this.f10298l = LazyKt__LazyJVMKt.b(lazyThreadSafetyMode, new NavDeepLink$fragRegex$2(this));
        this.f10299m = LazyKt__LazyJVMKt.a(new NavDeepLink$fragPattern$2(this));
        this.f10301o = LazyKt__LazyJVMKt.a(new NavDeepLink$mimeTypePattern$2(this));
        G();
        F();
    }

    public final boolean A() {
        return ((Boolean) this.f10293g.getValue()).booleanValue();
    }

    public final boolean B(Bundle bundle, String str, String str2, NavArgument navArgument) {
        if (navArgument != null) {
            navArgument.a().d(bundle, str, str2);
            return false;
        }
        bundle.putString(str, str2);
        return false;
    }

    public final boolean C(Bundle bundle, String str, String str2, NavArgument navArgument) {
        if (!bundle.containsKey(str)) {
            return true;
        }
        if (navArgument == null) {
            return false;
        }
        k<Object> a11 = navArgument.a();
        a11.e(bundle, str, str2, a11.a(bundle, str));
        return false;
    }

    public final Pair<List<String>, String> D() {
        String str = this.f10287a;
        if (str == null || Uri.parse(str).getFragment() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String fragment = Uri.parse(this.f10287a).getFragment();
        StringBuilder sb2 = new StringBuilder();
        g(fragment, arrayList, sb2);
        return l.a(arrayList, sb2.toString());
    }

    public final boolean E(List<String> list, ParamQuery paramQuery, Bundle bundle, Map<String, NavArgument> map) {
        if (list == null) {
            return true;
        }
        for (String str : list) {
            String c11 = paramQuery.c();
            Matcher matcher = c11 != null ? Pattern.compile(c11, 32).matcher(str) : null;
            if (matcher == null || !matcher.matches()) {
                return false;
            }
            Bundle bundle2 = new Bundle();
            try {
                List<String> b11 = paramQuery.b();
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(b11, 10));
                int i11 = 0;
                for (T next : b11) {
                    int i12 = i11 + 1;
                    if (i11 < 0) {
                        CollectionsKt__CollectionsKt.t();
                    }
                    String str2 = (String) next;
                    String group = matcher.group(i12);
                    if (group == null) {
                        group = "";
                    }
                    NavArgument navArgument = map.get(str2);
                    if (C(bundle, str2, group, navArgument)) {
                        if (!x.b(group, '{' + str2 + '}') && B(bundle2, str2, group, navArgument)) {
                            return false;
                        }
                    }
                    arrayList.add(Unit.f56620a);
                    i11 = i12;
                }
                bundle.putAll(bundle2);
            } catch (IllegalArgumentException unused) {
            }
        }
        return true;
    }

    public final void F() {
        if (this.f10289c != null) {
            if (Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(this.f10289c).matches()) {
                b bVar = new b(this.f10289c);
                this.f10300n = StringsKt__StringsJVMKt.G("^(" + bVar.getType() + "|[*]+)/(" + bVar.b() + "|[*]+)$", "*|[*]", "[\\s\\S]", false, 4, (Object) null);
                return;
            }
            throw new IllegalArgumentException(("The given mimeType " + this.f10289c + " does not match to required \"type/subtype\" format").toString());
        }
    }

    public final void G() {
        if (this.f10287a != null) {
            StringBuilder sb2 = new StringBuilder("^");
            if (!f10285r.matcher(this.f10287a).find()) {
                sb2.append("http[s]?://");
            }
            Matcher matcher = Pattern.compile("(\\?|\\#|$)").matcher(this.f10287a);
            matcher.find();
            boolean z11 = false;
            g(this.f10287a.substring(0, matcher.start()), this.f10290d, sb2);
            if (!StringsKt__StringsKt.R(sb2, ".*", false, 2, (Object) null) && !StringsKt__StringsKt.R(sb2, "([^/]+?)", false, 2, (Object) null)) {
                z11 = true;
            }
            this.f10302p = z11;
            sb2.append("($|(\\?(.)*)|(\\#(.)*))");
            this.f10291e = StringsKt__StringsJVMKt.G(sb2.toString(), ".*", "\\E.*\\Q", false, 4, (Object) null);
        }
    }

    public final Map<String, ParamQuery> H() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!A()) {
            return linkedHashMap;
        }
        Uri parse = Uri.parse(this.f10287a);
        for (String next : parse.getQueryParameterNames()) {
            StringBuilder sb2 = new StringBuilder();
            List<String> queryParameters = parse.getQueryParameters(next);
            int i11 = 0;
            if (queryParameters.size() <= 1) {
                String str = (String) CollectionsKt___CollectionsKt.c0(queryParameters);
                if (str == null) {
                    this.f10295i = true;
                    str = next;
                }
                Matcher matcher = f10286s.matcher(str);
                ParamQuery paramQuery = new ParamQuery();
                while (matcher.find()) {
                    paramQuery.a(matcher.group(1));
                    sb2.append(Pattern.quote(str.substring(i11, matcher.start())));
                    sb2.append("(.+?)?");
                    i11 = matcher.end();
                }
                if (i11 < str.length()) {
                    sb2.append(Pattern.quote(str.substring(i11)));
                }
                paramQuery.d(StringsKt__StringsJVMKt.G(sb2.toString(), ".*", "\\E.*\\Q", false, 4, (Object) null));
                linkedHashMap.put(next, paramQuery);
            } else {
                throw new IllegalArgumentException(("Query parameter " + next + " must only be present once in " + this.f10287a + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
            }
        }
        return linkedHashMap;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NavDeepLink)) {
            return false;
        }
        NavDeepLink navDeepLink = (NavDeepLink) obj;
        if (!x.b(this.f10287a, navDeepLink.f10287a) || !x.b(this.f10288b, navDeepLink.f10288b) || !x.b(this.f10289c, navDeepLink.f10289c)) {
            return false;
        }
        return true;
    }

    public final void g(String str, List<String> list, StringBuilder sb2) {
        Matcher matcher = f10286s.matcher(str);
        int i11 = 0;
        while (matcher.find()) {
            list.add(matcher.group(1));
            if (matcher.start() > i11) {
                sb2.append(Pattern.quote(str.substring(i11, matcher.start())));
            }
            sb2.append("([^/]+?)");
            i11 = matcher.end();
        }
        if (i11 < str.length()) {
            sb2.append(Pattern.quote(str.substring(i11)));
        }
    }

    public final int h(Uri uri) {
        if (uri == null || this.f10287a == null) {
            return 0;
        }
        return CollectionsKt___CollectionsKt.g0(uri.getPathSegments(), Uri.parse(this.f10287a).getPathSegments()).size();
    }

    public int hashCode() {
        String str = this.f10287a;
        int i11 = 0;
        int hashCode = ((str != null ? str.hashCode() : 0) + 0) * 31;
        String str2 = this.f10288b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f10289c;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode2 + i11;
    }

    public final String i() {
        return this.f10288b;
    }

    public final List<String> j() {
        List<String> list = this.f10290d;
        Collection<ParamQuery> values = x().values();
        ArrayList arrayList = new ArrayList();
        for (ParamQuery b11 : values) {
            boolean unused = CollectionsKt__MutableCollectionsKt.A(arrayList, b11.b());
        }
        return CollectionsKt___CollectionsKt.q0(CollectionsKt___CollectionsKt.q0(list, arrayList), k());
    }

    public final List<String> k() {
        return (List) this.f10297k.getValue();
    }

    public final Pair<List<String>, String> l() {
        return (Pair) this.f10296j.getValue();
    }

    public final Pattern m() {
        return (Pattern) this.f10299m.getValue();
    }

    public final String n() {
        return (String) this.f10298l.getValue();
    }

    public final Bundle o(Uri uri, Map<String, NavArgument> map) {
        Pattern w11 = w();
        Matcher matcher = w11 != null ? w11.matcher(uri.toString()) : null;
        if (matcher == null || !matcher.matches()) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (!q(matcher, bundle, map)) {
            return null;
        }
        if (A() && !r(uri, bundle, map)) {
            return null;
        }
        s(uri.getFragment(), bundle, map);
        if (!c.a(map, new NavDeepLink$getMatchingArguments$missingRequiredArguments$1(bundle)).isEmpty()) {
            return null;
        }
        return bundle;
    }

    public final Bundle p(Uri uri, Map<String, NavArgument> map) {
        Bundle bundle = new Bundle();
        if (uri == null) {
            return bundle;
        }
        Pattern w11 = w();
        Matcher matcher = w11 != null ? w11.matcher(uri.toString()) : null;
        if (matcher == null || !matcher.matches()) {
            return bundle;
        }
        q(matcher, bundle, map);
        if (A()) {
            r(uri, bundle, map);
        }
        return bundle;
    }

    public final boolean q(Matcher matcher, Bundle bundle, Map<String, NavArgument> map) {
        List<String> list = this.f10290d;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
        int i11 = 0;
        for (T next : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
            String str = (String) next;
            try {
                if (B(bundle, str, Uri.decode(matcher.group(i12)), map.get(str))) {
                    return false;
                }
                arrayList.add(Unit.f56620a);
                i11 = i12;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }
        return true;
    }

    public final boolean r(Uri uri, Bundle bundle, Map<String, NavArgument> map) {
        String query;
        for (Map.Entry next : x().entrySet()) {
            ParamQuery paramQuery = (ParamQuery) next.getValue();
            List<String> queryParameters = uri.getQueryParameters((String) next.getKey());
            if (this.f10295i && (query = uri.getQuery()) != null && !x.b(query, uri.toString())) {
                queryParameters = CollectionsKt__CollectionsJVMKt.e(query);
            }
            if (!E(queryParameters, paramQuery, bundle, map)) {
                return false;
            }
        }
        return true;
    }

    public final void s(String str, Bundle bundle, Map<String, NavArgument> map) {
        Pattern m11 = m();
        Matcher matcher = m11 != null ? m11.matcher(String.valueOf(str)) : null;
        if (matcher != null && matcher.matches()) {
            List<String> k11 = k();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(k11, 10));
            int i11 = 0;
            for (T next : k11) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt__CollectionsKt.t();
                }
                String str2 = (String) next;
                try {
                    if (!B(bundle, str2, Uri.decode(matcher.group(i12)), map.get(str2))) {
                        arrayList.add(Unit.f56620a);
                        i11 = i12;
                    } else {
                        return;
                    }
                } catch (IllegalArgumentException unused) {
                    return;
                }
            }
        }
    }

    public final String t() {
        return this.f10289c;
    }

    public final int u(String str) {
        if (this.f10289c == null || !v().matcher(str).matches()) {
            return -1;
        }
        return new b(this.f10289c).compareTo(new b(str));
    }

    public final Pattern v() {
        return (Pattern) this.f10301o.getValue();
    }

    public final Pattern w() {
        return (Pattern) this.f10292f.getValue();
    }

    public final Map<String, ParamQuery> x() {
        return (Map) this.f10294h.getValue();
    }

    public final String y() {
        return this.f10287a;
    }

    public final boolean z() {
        return this.f10302p;
    }
}
