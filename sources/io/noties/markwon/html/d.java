package io.noties.markwon.html;

import cn.sharesdk.framework.InnerShareParams;
import com.adjust.sdk.Constants;
import com.facebook.appevents.UserDataStore;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.noties.markwon.html.MarkwonHtmlParser;
import io.noties.markwon.html.b;
import io.noties.markwon.html.c;
import io.noties.markwon.html.jsoup.nodes.Attributes;
import io.noties.markwon.html.jsoup.parser.ParseErrorList;
import io.noties.markwon.html.jsoup.parser.Token;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class d extends MarkwonHtmlParser {

    /* renamed from: g  reason: collision with root package name */
    public static final Set<String> f55325g = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"a", "abbr", "acronym", "b", "bdo", "big", TtmlNode.TAG_BR, "button", "cite", "code", "dfn", UserDataStore.EMAIL, "i", "img", "input", "kbd", "label", "map", "object", "q", "samp", "script", "select", Constants.SMALL, TtmlNode.TAG_SPAN, "strong", "sub", "sup", "textarea", CrashHianalyticsData.TIME, TtmlNode.TAG_TT, "var"})));

    /* renamed from: h  reason: collision with root package name */
    public static final Set<String> f55326h = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"area", TtmlNode.RUBY_BASE, TtmlNode.TAG_BR, "col", "embed", "hr", "img", "input", "keygen", "link", Constants.REFERRER_API_META, RemoteMessageConst.MessageBody.PARAM, "source", "track", "wbr"})));

    /* renamed from: i  reason: collision with root package name */
    public static final Set<String> f55327i = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{InnerShareParams.ADDRESS, "article", "aside", "blockquote", "canvas", "dd", TtmlNode.TAG_DIV, "dl", "dt", "fieldset", "figcaption", "figure", "footer", "form", "h1", "h2", "h3", "h4", "h5", "h6", "header", "hgroup", "hr", "li", FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT, "nav", "noscript", "ol", "output", TtmlNode.TAG_P, "pre", FormItem.f33731j, "table", "tfoot", "ul", "video"})));

    /* renamed from: a  reason: collision with root package name */
    public final HtmlEmptyTagReplacement f55328a;

    /* renamed from: b  reason: collision with root package name */
    public final uz.d f55329b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.b> f55330c = new ArrayList(0);

    /* renamed from: d  reason: collision with root package name */
    public c.a f55331d = c.a.j();

    /* renamed from: e  reason: collision with root package name */
    public boolean f55332e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55333f;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f55334a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.noties.markwon.html.jsoup.parser.Token$TokenType[] r0 = io.noties.markwon.html.jsoup.parser.Token.TokenType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f55334a = r0
                io.noties.markwon.html.jsoup.parser.Token$TokenType r1 = io.noties.markwon.html.jsoup.parser.Token.TokenType.StartTag     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f55334a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.noties.markwon.html.jsoup.parser.Token$TokenType r1 = io.noties.markwon.html.jsoup.parser.Token.TokenType.EndTag     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f55334a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.noties.markwon.html.jsoup.parser.Token$TokenType r1 = io.noties.markwon.html.jsoup.parser.Token.TokenType.Character     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.noties.markwon.html.d.a.<clinit>():void");
        }
    }

    public d(HtmlEmptyTagReplacement htmlEmptyTagReplacement, uz.d dVar) {
        this.f55328a = htmlEmptyTagReplacement;
        this.f55329b = dVar;
    }

    public static d g(HtmlEmptyTagReplacement htmlEmptyTagReplacement) {
        return new d(htmlEmptyTagReplacement, uz.d.b());
    }

    public static <T extends Appendable & CharSequence> void h(T t11) {
        CharSequence charSequence = (CharSequence) t11;
        int length = charSequence.length();
        if (length > 0 && 10 != charSequence.charAt(length - 1)) {
            uz.a.a(t11, 10);
        }
    }

    public static Map<String, String> j(Token.StartTag startTag) {
        Attributes attributes = startTag.f55368j;
        int size = attributes.size();
        if (size <= 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(size);
        Iterator<wz.a> it2 = attributes.iterator();
        while (it2.hasNext()) {
            wz.a next = it2.next();
            hashMap.put(next.getKey().toLowerCase(Locale.US), next.getValue());
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public static boolean m(String str) {
        return f55327i.contains(str);
    }

    public static <T extends Appendable & CharSequence> boolean n(T t11, c cVar) {
        return cVar.f55320b == ((CharSequence) t11).length();
    }

    public static boolean o(String str) {
        return f55325g.contains(str);
    }

    public static boolean p(String str) {
        return f55326h.contains(str);
    }

    public void a(int i11, MarkwonHtmlParser.a<b.a> aVar) {
        c.a aVar2 = this.f55331d;
        while (true) {
            c.a aVar3 = aVar2.f55323e;
            if (aVar3 == null) {
                break;
            }
            aVar2 = aVar3;
        }
        if (i11 > -1) {
            aVar2.h(i11);
        }
        List<b.a> f11 = aVar2.f();
        if (f11.size() > 0) {
            aVar.a(f11);
        } else {
            aVar.a(Collections.emptyList());
        }
        this.f55331d = c.a.j();
    }

    public void b(int i11, MarkwonHtmlParser.a<b.C0653b> aVar) {
        if (this.f55330c.size() > 0) {
            if (i11 > -1) {
                for (c.b h11 : this.f55330c) {
                    h11.h(i11);
                }
            }
            aVar.a(Collections.unmodifiableList(this.f55330c));
            this.f55330c.clear();
            return;
        }
        aVar.a(Collections.emptyList());
    }

    public <T extends Appendable & CharSequence> void c(T t11, String str) {
        io.noties.markwon.html.jsoup.parser.c cVar = new io.noties.markwon.html.jsoup.parser.c(new io.noties.markwon.html.jsoup.parser.a(str), ParseErrorList.noTracking());
        while (true) {
            Token t12 = cVar.t();
            Token.TokenType tokenType = t12.f55351a;
            if (Token.TokenType.EOF != tokenType) {
                int i11 = a.f55334a[tokenType.ordinal()];
                if (i11 == 1) {
                    Token.StartTag startTag = (Token.StartTag) t12;
                    if (o(startTag.f55361c)) {
                        u(t11, startTag);
                    } else {
                        r(t11, startTag);
                    }
                } else if (i11 == 2) {
                    Token.f fVar = (Token.f) t12;
                    if (o(fVar.f55361c)) {
                        t(t11, fVar);
                    } else {
                        q(t11, fVar);
                    }
                } else if (i11 == 3) {
                    s(t11, (Token.b) t12);
                }
                t12.a();
            } else {
                return;
            }
        }
    }

    public void d() {
        this.f55330c.clear();
        this.f55331d = c.a.j();
    }

    public void e(c.a aVar, c.a aVar2) {
        List list = aVar.f55324f;
        if (list == null) {
            list = new ArrayList(2);
            aVar.f55324f = list;
        }
        list.add(aVar2);
    }

    public <T extends Appendable & CharSequence> void f(T t11, c cVar) {
        String a11 = this.f55328a.a(cVar);
        if (a11 != null) {
            uz.a.b(t11, a11);
        }
    }

    public <T extends Appendable & CharSequence> void i(T t11) {
        if (this.f55333f) {
            h(t11);
            this.f55333f = false;
        }
    }

    public c.a k(String str) {
        c.a aVar = this.f55331d;
        while (aVar != null && !str.equals(aVar.f55319a) && !aVar.isClosed()) {
            aVar = aVar.f55323e;
        }
        return aVar;
    }

    public c.b l(String str) {
        int size = this.f55330c.size();
        while (true) {
            size--;
            if (size <= -1) {
                return null;
            }
            c.b bVar = this.f55330c.get(size);
            if (str.equals(bVar.f55319a) && bVar.f55322d < 0) {
                return bVar;
            }
        }
    }

    public <T extends Appendable & CharSequence> void q(T t11, Token.f fVar) {
        String str = fVar.f55361c;
        c.a k11 = k(str);
        if (k11 != null) {
            if ("pre".equals(str)) {
                this.f55332e = false;
            }
            if (n(t11, k11)) {
                f(t11, k11);
            }
            k11.h(((CharSequence) t11).length());
            if (!k11.g()) {
                this.f55333f = m(k11.f55319a);
            }
            if (TtmlNode.TAG_P.equals(str)) {
                uz.a.a(t11, 10);
            }
            this.f55331d = k11.f55323e;
        }
    }

    public <T extends Appendable & CharSequence> void r(T t11, Token.StartTag startTag) {
        String str = startTag.f55361c;
        if (TtmlNode.TAG_P.equals(this.f55331d.f55319a)) {
            this.f55331d.h(((CharSequence) t11).length());
            uz.a.a(t11, 10);
            this.f55331d = this.f55331d.f55323e;
        } else if ("li".equals(str) && "li".equals(this.f55331d.f55319a)) {
            this.f55331d.h(((CharSequence) t11).length());
            this.f55331d = this.f55331d.f55323e;
        }
        if (m(str)) {
            this.f55332e = "pre".equals(str);
            h(t11);
        } else {
            i(t11);
        }
        CharSequence charSequence = (CharSequence) t11;
        c.a i11 = c.a.i(str, charSequence.length(), j(startTag), this.f55331d);
        boolean z11 = p(str) || startTag.f55367i;
        if (z11) {
            String a11 = this.f55328a.a(i11);
            if (a11 != null && a11.length() > 0) {
                uz.a.b(t11, a11);
            }
            i11.h(charSequence.length());
        }
        e(i11.f55323e, i11);
        if (!z11) {
            this.f55331d = i11;
        }
    }

    public <T extends Appendable & CharSequence> void s(T t11, Token.b bVar) {
        if (this.f55332e) {
            uz.a.b(t11, bVar.d());
            return;
        }
        i(t11);
        this.f55329b.a(t11, bVar.d());
    }

    public <T extends Appendable & CharSequence> void t(T t11, Token.f fVar) {
        c.b l11 = l(fVar.f55361c);
        if (l11 != null) {
            if (n(t11, l11)) {
                f(t11, l11);
            }
            l11.h(((CharSequence) t11).length());
        }
    }

    public <T extends Appendable & CharSequence> void u(T t11, Token.StartTag startTag) {
        String str = startTag.f55361c;
        CharSequence charSequence = (CharSequence) t11;
        c.b bVar = new c.b(str, charSequence.length(), j(startTag));
        i(t11);
        if (p(str) || startTag.f55367i) {
            String a11 = this.f55328a.a(bVar);
            if (a11 != null && a11.length() > 0) {
                uz.a.b(t11, a11);
            }
            bVar.h(charSequence.length());
        }
        this.f55330c.add(bVar);
    }
}
