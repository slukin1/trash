package com.caverock.androidsvg;

import android.util.Log;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParser;
import com.iproov.sdk.bridge.OptionsBridge;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CSSParser {

    /* renamed from: a  reason: collision with root package name */
    public MediaType f64351a;

    /* renamed from: b  reason: collision with root package name */
    public Source f64352b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f64353c;

    public enum AttribOp {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH
    }

    public enum Combinator {
        DESCENDANT,
        CHILD,
        FOLLOWS
    }

    public enum MediaType {
        all,
        aural,
        braille,
        embossed,
        handheld,
        print,
        projection,
        screen,
        speech,
        tty,
        tv
    }

    public enum PseudoClassIdents {
        target,
        root,
        nth_child,
        nth_last_child,
        nth_of_type,
        nth_last_of_type,
        first_child,
        last_child,
        first_of_type,
        last_of_type,
        only_child,
        only_of_type,
        empty,
        not,
        lang,
        link,
        visited,
        hover,
        active,
        focus,
        enabled,
        disabled,
        checked,
        indeterminate,
        UNSUPPORTED;
        
        private static final Map<String, PseudoClassIdents> cache = null;

        /* access modifiers changed from: public */
        static {
            cache = new HashMap();
            for (PseudoClassIdents pseudoClassIdents : values()) {
                if (pseudoClassIdents != UNSUPPORTED) {
                    cache.put(pseudoClassIdents.name().replace('_', '-'), pseudoClassIdents);
                }
            }
        }

        public static PseudoClassIdents fromString(String str) {
            PseudoClassIdents pseudoClassIdents = cache.get(str);
            if (pseudoClassIdents != null) {
                return pseudoClassIdents;
            }
            return UNSUPPORTED;
        }
    }

    public enum Source {
        Document,
        RenderOptions
    }

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f64355a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f64356b;

        /* JADX WARNING: Can't wrap try/catch for region: R(54:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|(3:59|60|62)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|62) */
        /* JADX WARNING: Can't wrap try/catch for region: R(57:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|62) */
        /* JADX WARNING: Can't wrap try/catch for region: R(58:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|62) */
        /* JADX WARNING: Can't wrap try/catch for region: R(59:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|62) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x0114 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0131 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x013b */
        static {
            /*
                com.caverock.androidsvg.CSSParser$PseudoClassIdents[] r0 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f64356b = r0
                r1 = 1
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r2 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.first_child     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f64356b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r3 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.last_child     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f64356b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.only_child     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = f64356b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.first_of_type     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = f64356b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.last_of_type     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r3 = f64356b     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.only_of_type     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r5 = 6
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r3 = f64356b     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.root     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r5 = 7
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r3 = f64356b     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.empty     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r5 = 8
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r3 = f64356b     // Catch:{ NoSuchFieldError -> 0x006c }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.nth_child     // Catch:{ NoSuchFieldError -> 0x006c }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r5 = 9
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r3 = f64356b     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.nth_last_child     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r5 = 10
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r3 = f64356b     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.nth_of_type     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r5 = 11
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r3 = f64356b     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.nth_last_of_type     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r5 = 12
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r3 = f64356b     // Catch:{ NoSuchFieldError -> 0x009c }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.not     // Catch:{ NoSuchFieldError -> 0x009c }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r5 = 13
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r3 = f64356b     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.target     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r5 = 14
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r3 = f64356b     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.lang     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r5 = 15
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r3 = f64356b     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.link     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r5 = 16
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r3 = f64356b     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.visited     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r5 = 17
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r3 = f64356b     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.hover     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r5 = 18
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r3 = f64356b     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.active     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r5 = 19
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r3 = f64356b     // Catch:{ NoSuchFieldError -> 0x00f0 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.focus     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r5 = 20
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                int[] r3 = f64356b     // Catch:{ NoSuchFieldError -> 0x00fc }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.enabled     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r5 = 21
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                int[] r3 = f64356b     // Catch:{ NoSuchFieldError -> 0x0108 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.disabled     // Catch:{ NoSuchFieldError -> 0x0108 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
                r5 = 22
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0108 }
            L_0x0108:
                int[] r3 = f64356b     // Catch:{ NoSuchFieldError -> 0x0114 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.checked     // Catch:{ NoSuchFieldError -> 0x0114 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0114 }
                r5 = 23
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0114 }
            L_0x0114:
                int[] r3 = f64356b     // Catch:{ NoSuchFieldError -> 0x0120 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.indeterminate     // Catch:{ NoSuchFieldError -> 0x0120 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0120 }
                r5 = 24
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0120 }
            L_0x0120:
                com.caverock.androidsvg.CSSParser$AttribOp[] r3 = com.caverock.androidsvg.CSSParser.AttribOp.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f64355a = r3
                com.caverock.androidsvg.CSSParser$AttribOp r4 = com.caverock.androidsvg.CSSParser.AttribOp.EQUALS     // Catch:{ NoSuchFieldError -> 0x0131 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0131 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0131 }
            L_0x0131:
                int[] r1 = f64355a     // Catch:{ NoSuchFieldError -> 0x013b }
                com.caverock.androidsvg.CSSParser$AttribOp r3 = com.caverock.androidsvg.CSSParser.AttribOp.INCLUDES     // Catch:{ NoSuchFieldError -> 0x013b }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x013b }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x013b }
            L_0x013b:
                int[] r0 = f64355a     // Catch:{ NoSuchFieldError -> 0x0145 }
                com.caverock.androidsvg.CSSParser$AttribOp r1 = com.caverock.androidsvg.CSSParser.AttribOp.DASHMATCH     // Catch:{ NoSuchFieldError -> 0x0145 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0145 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0145 }
            L_0x0145:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.CSSParser.a.<clinit>():void");
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f64357a;

        /* renamed from: b  reason: collision with root package name */
        public final AttribOp f64358b;

        /* renamed from: c  reason: collision with root package name */
        public final String f64359c;

        public b(String str, AttribOp attribOp, String str2) {
            this.f64357a = str;
            this.f64358b = attribOp;
            this.f64359c = str2;
        }
    }

    public static class c extends SVGParser.g {

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public int f64360a;

            /* renamed from: b  reason: collision with root package name */
            public int f64361b;

            public a(int i11, int i12) {
                this.f64360a = i11;
                this.f64361b = i12;
            }
        }

        public c(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
        }

        public final int C(int i11) {
            if (i11 >= 48 && i11 <= 57) {
                return i11 - 48;
            }
            int i12 = 65;
            if (i11 < 65 || i11 > 70) {
                i12 = 97;
                if (i11 < 97 || i11 > 102) {
                    return -1;
                }
            }
            return (i11 - i12) + 10;
        }

        public final a D() throws CSSParseException {
            a aVar;
            a aVar2;
            if (h()) {
                return null;
            }
            int i11 = this.f64611b;
            if (!f('(')) {
                return null;
            }
            A();
            int i12 = 1;
            if (g("odd")) {
                aVar = new a(2, 1);
            } else {
                int i13 = 0;
                if (g("even")) {
                    aVar = new a(2, 0);
                } else {
                    int i14 = (!f('+') && f('-')) ? -1 : 1;
                    a c11 = a.c(this.f64610a, this.f64611b, this.f64612c, false);
                    if (c11 != null) {
                        this.f64611b = c11.a();
                    }
                    if (f('n') || f('N')) {
                        if (c11 == null) {
                            c11 = new a(1, this.f64611b);
                        }
                        A();
                        boolean f11 = f('+');
                        if (!f11 && (f11 = f('-'))) {
                            i12 = -1;
                        }
                        if (f11) {
                            A();
                            aVar2 = a.c(this.f64610a, this.f64611b, this.f64612c, false);
                            if (aVar2 != null) {
                                this.f64611b = aVar2.a();
                            } else {
                                this.f64611b = i11;
                                return null;
                            }
                        } else {
                            aVar2 = null;
                        }
                        int i15 = i12;
                        i12 = i14;
                        i14 = i15;
                    } else {
                        aVar2 = c11;
                        c11 = null;
                    }
                    int d11 = c11 == null ? 0 : i12 * c11.d();
                    if (aVar2 != null) {
                        i13 = i14 * aVar2.d();
                    }
                    aVar = new a(d11, i13);
                }
            }
            A();
            if (f(')')) {
                return aVar;
            }
            this.f64611b = i11;
            return null;
        }

        public final String E() {
            if (h()) {
                return null;
            }
            String q11 = q();
            if (q11 != null) {
                return q11;
            }
            return H();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0057, code lost:
            r2 = l().intValue();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String F() {
            /*
                r8 = this;
                boolean r0 = r8.h()
                r1 = 0
                if (r0 == 0) goto L_0x0008
                return r1
            L_0x0008:
                java.lang.String r0 = r8.f64610a
                int r2 = r8.f64611b
                char r0 = r0.charAt(r2)
                r2 = 39
                if (r0 == r2) goto L_0x0019
                r2 = 34
                if (r0 == r2) goto L_0x0019
                return r1
            L_0x0019:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                int r2 = r8.f64611b
                r3 = 1
                int r2 = r2 + r3
                r8.f64611b = r2
                java.lang.Integer r2 = r8.l()
                int r2 = r2.intValue()
            L_0x002c:
                r4 = -1
                if (r2 == r4) goto L_0x0087
                if (r2 == r0) goto L_0x0087
                r5 = 92
                if (r2 != r5) goto L_0x007a
                java.lang.Integer r2 = r8.l()
                int r2 = r2.intValue()
                if (r2 != r4) goto L_0x0040
                goto L_0x002c
            L_0x0040:
                r5 = 10
                if (r2 == r5) goto L_0x0071
                r5 = 13
                if (r2 == r5) goto L_0x0071
                r5 = 12
                if (r2 != r5) goto L_0x004d
                goto L_0x0071
            L_0x004d:
                int r5 = r8.C(r2)
                if (r5 == r4) goto L_0x007a
                r6 = r3
            L_0x0054:
                r7 = 5
                if (r6 > r7) goto L_0x006c
                java.lang.Integer r2 = r8.l()
                int r2 = r2.intValue()
                int r7 = r8.C(r2)
                if (r7 != r4) goto L_0x0066
                goto L_0x006c
            L_0x0066:
                int r5 = r5 * 16
                int r5 = r5 + r7
                int r6 = r6 + 1
                goto L_0x0054
            L_0x006c:
                char r4 = (char) r5
                r1.append(r4)
                goto L_0x002c
            L_0x0071:
                java.lang.Integer r2 = r8.l()
                int r2 = r2.intValue()
                goto L_0x002c
            L_0x007a:
                char r2 = (char) r2
                r1.append(r2)
                java.lang.Integer r2 = r8.l()
                int r2 = r2.intValue()
                goto L_0x002c
            L_0x0087:
                java.lang.String r0 = r1.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.CSSParser.c.F():java.lang.String");
        }

        public final List<String> G() throws CSSParseException {
            if (h()) {
                return null;
            }
            int i11 = this.f64611b;
            if (!f('(')) {
                return null;
            }
            A();
            ArrayList arrayList = null;
            do {
                String H = H();
                if (H == null) {
                    this.f64611b = i11;
                    return null;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(H);
                A();
            } while (z());
            if (f(')')) {
                return arrayList;
            }
            this.f64611b = i11;
            return null;
        }

        public String H() {
            int P = P();
            int i11 = this.f64611b;
            if (P == i11) {
                return null;
            }
            String substring = this.f64610a.substring(i11, P);
            this.f64611b = P;
            return substring;
        }

        public String I() {
            char charAt;
            int C;
            StringBuilder sb2 = new StringBuilder();
            while (!h() && (charAt = this.f64610a.charAt(this.f64611b)) != '\'' && charAt != '\"' && charAt != '(' && charAt != ')' && !k(charAt) && !Character.isISOControl(charAt)) {
                this.f64611b++;
                if (charAt == '\\') {
                    if (!h()) {
                        String str = this.f64610a;
                        int i11 = this.f64611b;
                        this.f64611b = i11 + 1;
                        charAt = str.charAt(i11);
                        if (!(charAt == 10 || charAt == 13 || charAt == 12)) {
                            int C2 = C(charAt);
                            if (C2 != -1) {
                                for (int i12 = 1; i12 <= 5 && !h() && (C = C(this.f64610a.charAt(this.f64611b))) != -1; i12++) {
                                    this.f64611b++;
                                    C2 = (C2 * 16) + C;
                                }
                                sb2.append((char) C2);
                            }
                        }
                    }
                }
                sb2.append((char) charAt);
            }
            if (sb2.length() == 0) {
                return null;
            }
            return sb2.toString();
        }

        public String J() {
            if (h()) {
                return null;
            }
            int i11 = this.f64611b;
            int charAt = this.f64610a.charAt(i11);
            int i12 = i11;
            while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33 && !j(charAt)) {
                if (!k(charAt)) {
                    i12 = this.f64611b + 1;
                }
                charAt = a();
            }
            if (this.f64611b > i11) {
                return this.f64610a.substring(i11, i12);
            }
            this.f64611b = i11;
            return null;
        }

        public final List<o> K() throws CSSParseException {
            List<p> list;
            List<d> list2;
            if (h()) {
                return null;
            }
            int i11 = this.f64611b;
            if (!f('(')) {
                return null;
            }
            A();
            List<o> L = L();
            if (L == null) {
                this.f64611b = i11;
                return null;
            } else if (!f(')')) {
                this.f64611b = i11;
                return null;
            } else {
                Iterator<o> it2 = L.iterator();
                while (it2.hasNext() && (list = it2.next().f64376a) != null) {
                    Iterator<p> it3 = list.iterator();
                    while (it3.hasNext() && (list2 = it3.next().f64381d) != null) {
                        Iterator<d> it4 = list2.iterator();
                        while (true) {
                            if (it4.hasNext()) {
                                if (it4.next() instanceof g) {
                                    return null;
                                }
                            }
                        }
                    }
                }
                return L;
            }
        }

        public final List<o> L() throws CSSParseException {
            if (h()) {
                return null;
            }
            ArrayList arrayList = new ArrayList(1);
            o oVar = new o((a) null);
            while (!h() && M(oVar)) {
                if (z()) {
                    arrayList.add(oVar);
                    oVar = new o((a) null);
                }
            }
            if (!oVar.f()) {
                arrayList.add(oVar);
            }
            return arrayList;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x0130  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0135  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean M(com.caverock.androidsvg.CSSParser.o r11) throws com.caverock.androidsvg.CSSParseException {
            /*
                r10 = this;
                boolean r0 = r10.h()
                r1 = 0
                if (r0 == 0) goto L_0x0008
                return r1
            L_0x0008:
                int r0 = r10.f64611b
                boolean r2 = r11.f()
                r3 = 0
                if (r2 != 0) goto L_0x002d
                r2 = 62
                boolean r2 = r10.f(r2)
                if (r2 == 0) goto L_0x001f
                com.caverock.androidsvg.CSSParser$Combinator r2 = com.caverock.androidsvg.CSSParser.Combinator.CHILD
                r10.A()
                goto L_0x002e
            L_0x001f:
                r2 = 43
                boolean r2 = r10.f(r2)
                if (r2 == 0) goto L_0x002d
                com.caverock.androidsvg.CSSParser$Combinator r2 = com.caverock.androidsvg.CSSParser.Combinator.FOLLOWS
                r10.A()
                goto L_0x002e
            L_0x002d:
                r2 = r3
            L_0x002e:
                r4 = 42
                boolean r4 = r10.f(r4)
                if (r4 == 0) goto L_0x003c
                com.caverock.androidsvg.CSSParser$p r4 = new com.caverock.androidsvg.CSSParser$p
                r4.<init>(r2, r3)
                goto L_0x004d
            L_0x003c:
                java.lang.String r4 = r10.H()
                if (r4 == 0) goto L_0x004c
                com.caverock.androidsvg.CSSParser$p r5 = new com.caverock.androidsvg.CSSParser$p
                r5.<init>(r2, r4)
                r11.c()
                r4 = r5
                goto L_0x004d
            L_0x004c:
                r4 = r3
            L_0x004d:
                boolean r5 = r10.h()
                if (r5 != 0) goto L_0x012e
                r5 = 46
                boolean r5 = r10.f(r5)
                if (r5 == 0) goto L_0x007b
                if (r4 != 0) goto L_0x0062
                com.caverock.androidsvg.CSSParser$p r4 = new com.caverock.androidsvg.CSSParser$p
                r4.<init>(r2, r3)
            L_0x0062:
                java.lang.String r5 = r10.H()
                if (r5 == 0) goto L_0x0073
                com.caverock.androidsvg.CSSParser$AttribOp r6 = com.caverock.androidsvg.CSSParser.AttribOp.EQUALS
                java.lang.String r7 = "class"
                r4.a(r7, r6, r5)
                r11.b()
                goto L_0x004d
            L_0x0073:
                com.caverock.androidsvg.CSSParseException r11 = new com.caverock.androidsvg.CSSParseException
                java.lang.String r0 = "Invalid \".class\" simpleSelectors"
                r11.<init>(r0)
                throw r11
            L_0x007b:
                r5 = 35
                boolean r5 = r10.f(r5)
                if (r5 == 0) goto L_0x00a3
                if (r4 != 0) goto L_0x008a
                com.caverock.androidsvg.CSSParser$p r4 = new com.caverock.androidsvg.CSSParser$p
                r4.<init>(r2, r3)
            L_0x008a:
                java.lang.String r5 = r10.H()
                if (r5 == 0) goto L_0x009b
                com.caverock.androidsvg.CSSParser$AttribOp r6 = com.caverock.androidsvg.CSSParser.AttribOp.EQUALS
                java.lang.String r7 = "id"
                r4.a(r7, r6, r5)
                r11.d()
                goto L_0x004d
            L_0x009b:
                com.caverock.androidsvg.CSSParseException r11 = new com.caverock.androidsvg.CSSParseException
                java.lang.String r0 = "Invalid \"#id\" simpleSelectors"
                r11.<init>(r0)
                throw r11
            L_0x00a3:
                r5 = 91
                boolean r5 = r10.f(r5)
                if (r5 == 0) goto L_0x011a
                if (r4 != 0) goto L_0x00b2
                com.caverock.androidsvg.CSSParser$p r4 = new com.caverock.androidsvg.CSSParser$p
                r4.<init>(r2, r3)
            L_0x00b2:
                r10.A()
                java.lang.String r5 = r10.H()
                java.lang.String r6 = "Invalid attribute simpleSelectors"
                if (r5 == 0) goto L_0x0114
                r10.A()
                r7 = 61
                boolean r7 = r10.f(r7)
                if (r7 == 0) goto L_0x00cb
                com.caverock.androidsvg.CSSParser$AttribOp r7 = com.caverock.androidsvg.CSSParser.AttribOp.EQUALS
                goto L_0x00e4
            L_0x00cb:
                java.lang.String r7 = "~="
                boolean r7 = r10.g(r7)
                if (r7 == 0) goto L_0x00d7
                com.caverock.androidsvg.CSSParser$AttribOp r7 = com.caverock.androidsvg.CSSParser.AttribOp.INCLUDES
                goto L_0x00e4
            L_0x00d7:
                java.lang.String r7 = "|="
                boolean r7 = r10.g(r7)
                if (r7 == 0) goto L_0x00e3
                com.caverock.androidsvg.CSSParser$AttribOp r7 = com.caverock.androidsvg.CSSParser.AttribOp.DASHMATCH
                goto L_0x00e4
            L_0x00e3:
                r7 = r3
            L_0x00e4:
                if (r7 == 0) goto L_0x00f9
                r10.A()
                java.lang.String r8 = r10.E()
                if (r8 == 0) goto L_0x00f3
                r10.A()
                goto L_0x00fa
            L_0x00f3:
                com.caverock.androidsvg.CSSParseException r11 = new com.caverock.androidsvg.CSSParseException
                r11.<init>(r6)
                throw r11
            L_0x00f9:
                r8 = r3
            L_0x00fa:
                r9 = 93
                boolean r9 = r10.f(r9)
                if (r9 == 0) goto L_0x010e
                if (r7 != 0) goto L_0x0106
                com.caverock.androidsvg.CSSParser$AttribOp r7 = com.caverock.androidsvg.CSSParser.AttribOp.EXISTS
            L_0x0106:
                r4.a(r5, r7, r8)
                r11.b()
                goto L_0x004d
            L_0x010e:
                com.caverock.androidsvg.CSSParseException r11 = new com.caverock.androidsvg.CSSParseException
                r11.<init>(r6)
                throw r11
            L_0x0114:
                com.caverock.androidsvg.CSSParseException r11 = new com.caverock.androidsvg.CSSParseException
                r11.<init>(r6)
                throw r11
            L_0x011a:
                r5 = 58
                boolean r5 = r10.f(r5)
                if (r5 == 0) goto L_0x012e
                if (r4 != 0) goto L_0x0129
                com.caverock.androidsvg.CSSParser$p r4 = new com.caverock.androidsvg.CSSParser$p
                r4.<init>(r2, r3)
            L_0x0129:
                r10.O(r11, r4)
                goto L_0x004d
            L_0x012e:
                if (r4 == 0) goto L_0x0135
                r11.a(r4)
                r11 = 1
                return r11
            L_0x0135:
                r10.f64611b = r0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.CSSParser.c.M(com.caverock.androidsvg.CSSParser$o):boolean");
        }

        public String N() {
            if (h()) {
                return null;
            }
            int i11 = this.f64611b;
            if (!g("url(")) {
                return null;
            }
            A();
            String F = F();
            if (F == null) {
                F = I();
            }
            if (F == null) {
                this.f64611b = i11;
                return null;
            }
            A();
            if (h() || g(")")) {
                return F;
            }
            this.f64611b = i11;
            return null;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.caverock.androidsvg.CSSParser$e} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: com.caverock.androidsvg.CSSParser$g} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.caverock.androidsvg.CSSParser$e} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.caverock.androidsvg.CSSParser$e} */
        /* JADX WARNING: type inference failed for: r2v4, types: [com.caverock.androidsvg.CSSParser$i] */
        /* JADX WARNING: type inference failed for: r2v7, types: [com.caverock.androidsvg.CSSParser$i] */
        /* JADX WARNING: type inference failed for: r2v8, types: [com.caverock.androidsvg.CSSParser$j] */
        /* JADX WARNING: type inference failed for: r2v9, types: [com.caverock.androidsvg.CSSParser$f] */
        /* JADX WARNING: type inference failed for: r2v16, types: [com.caverock.androidsvg.CSSParser$k] */
        /* JADX WARNING: type inference failed for: r2v17, types: [com.caverock.androidsvg.CSSParser$h] */
        /* JADX WARNING: type inference failed for: r2v18, types: [com.caverock.androidsvg.CSSParser$h] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 7 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void O(com.caverock.androidsvg.CSSParser.o r21, com.caverock.androidsvg.CSSParser.p r22) throws com.caverock.androidsvg.CSSParseException {
            /*
                r20 = this;
                r0 = r22
                java.lang.String r1 = r20.H()
                if (r1 == 0) goto L_0x0144
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r2 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.fromString(r1)
                int[] r3 = com.caverock.androidsvg.CSSParser.a.f64356b
                int r4 = r2.ordinal()
                r3 = r3[r4]
                java.lang.String r4 = "Invalid or missing parameter section for pseudo class: "
                r5 = 1
                r6 = 0
                r7 = 0
                switch(r3) {
                    case 1: goto L_0x012c;
                    case 2: goto L_0x011b;
                    case 3: goto L_0x0110;
                    case 4: goto L_0x00fb;
                    case 5: goto L_0x00e9;
                    case 6: goto L_0x00dc;
                    case 7: goto L_0x00d0;
                    case 8: goto L_0x00c4;
                    case 9: goto L_0x007f;
                    case 10: goto L_0x007f;
                    case 11: goto L_0x007f;
                    case 12: goto L_0x007f;
                    case 13: goto L_0x0054;
                    case 14: goto L_0x004a;
                    case 15: goto L_0x003d;
                    case 16: goto L_0x0033;
                    case 17: goto L_0x0033;
                    case 18: goto L_0x0033;
                    case 19: goto L_0x0033;
                    case 20: goto L_0x0033;
                    case 21: goto L_0x0033;
                    case 22: goto L_0x0033;
                    case 23: goto L_0x0033;
                    case 24: goto L_0x0033;
                    default: goto L_0x001c;
                }
            L_0x001c:
                com.caverock.androidsvg.CSSParseException r0 = new com.caverock.androidsvg.CSSParseException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Unsupported pseudo class: "
                r2.append(r3)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                r0.<init>(r1)
                throw r0
            L_0x0033:
                com.caverock.androidsvg.CSSParser$h r2 = new com.caverock.androidsvg.CSSParser$h
                r2.<init>(r1)
                r21.b()
                goto L_0x0140
            L_0x003d:
                r20.G()
                com.caverock.androidsvg.CSSParser$h r2 = new com.caverock.androidsvg.CSSParser$h
                r2.<init>(r1)
                r21.b()
                goto L_0x0140
            L_0x004a:
                com.caverock.androidsvg.CSSParser$k r2 = new com.caverock.androidsvg.CSSParser$k
                r2.<init>(r7)
                r21.b()
                goto L_0x0140
            L_0x0054:
                java.util.List r2 = r20.K()
                if (r2 == 0) goto L_0x006a
                com.caverock.androidsvg.CSSParser$g r1 = new com.caverock.androidsvg.CSSParser$g
                r1.<init>(r2)
                int r2 = r1.b()
                r3 = r21
                r3.f64377b = r2
            L_0x0067:
                r2 = r1
                goto L_0x0140
            L_0x006a:
                com.caverock.androidsvg.CSSParseException r0 = new com.caverock.androidsvg.CSSParseException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r4)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                r0.<init>(r1)
                throw r0
            L_0x007f:
                r3 = r21
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r7 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.nth_child
                if (r2 == r7) goto L_0x008c
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r7 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.nth_of_type
                if (r2 != r7) goto L_0x008a
                goto L_0x008c
            L_0x008a:
                r11 = r6
                goto L_0x008d
            L_0x008c:
                r11 = r5
            L_0x008d:
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r7 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.nth_of_type
                if (r2 == r7) goto L_0x0098
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r7 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.nth_last_of_type
                if (r2 != r7) goto L_0x0096
                goto L_0x0098
            L_0x0096:
                r12 = r6
                goto L_0x0099
            L_0x0098:
                r12 = r5
            L_0x0099:
                com.caverock.androidsvg.CSSParser$c$a r2 = r20.D()
                if (r2 == 0) goto L_0x00af
                com.caverock.androidsvg.CSSParser$e r1 = new com.caverock.androidsvg.CSSParser$e
                int r9 = r2.f64360a
                int r10 = r2.f64361b
                java.lang.String r13 = r0.f64379b
                r8 = r1
                r8.<init>(r9, r10, r11, r12, r13)
                r21.b()
                goto L_0x0067
            L_0x00af:
                com.caverock.androidsvg.CSSParseException r0 = new com.caverock.androidsvg.CSSParseException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r4)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                r0.<init>(r1)
                throw r0
            L_0x00c4:
                r3 = r21
                com.caverock.androidsvg.CSSParser$f r2 = new com.caverock.androidsvg.CSSParser$f
                r2.<init>(r7)
                r21.b()
                goto L_0x0140
            L_0x00d0:
                r3 = r21
                com.caverock.androidsvg.CSSParser$j r2 = new com.caverock.androidsvg.CSSParser$j
                r2.<init>(r7)
                r21.b()
                goto L_0x0140
            L_0x00dc:
                r3 = r21
                com.caverock.androidsvg.CSSParser$i r2 = new com.caverock.androidsvg.CSSParser$i
                java.lang.String r1 = r0.f64379b
                r2.<init>(r5, r1)
                r21.b()
                goto L_0x0140
            L_0x00e9:
                r3 = r21
                com.caverock.androidsvg.CSSParser$e r2 = new com.caverock.androidsvg.CSSParser$e
                r7 = 0
                r8 = 1
                r9 = 0
                r10 = 1
                java.lang.String r11 = r0.f64379b
                r6 = r2
                r6.<init>(r7, r8, r9, r10, r11)
                r21.b()
                goto L_0x0140
            L_0x00fb:
                r3 = r21
                com.caverock.androidsvg.CSSParser$e r2 = new com.caverock.androidsvg.CSSParser$e
                r13 = 0
                r14 = 1
                r15 = 1
                r16 = 1
                java.lang.String r1 = r0.f64379b
                r12 = r2
                r17 = r1
                r12.<init>(r13, r14, r15, r16, r17)
                r21.b()
                goto L_0x0140
            L_0x0110:
                r3 = r21
                com.caverock.androidsvg.CSSParser$i r2 = new com.caverock.androidsvg.CSSParser$i
                r2.<init>(r6, r7)
                r21.b()
                goto L_0x0140
            L_0x011b:
                r3 = r21
                com.caverock.androidsvg.CSSParser$e r2 = new com.caverock.androidsvg.CSSParser$e
                r9 = 0
                r10 = 1
                r11 = 0
                r12 = 0
                r13 = 0
                r8 = r2
                r8.<init>(r9, r10, r11, r12, r13)
                r21.b()
                goto L_0x0140
            L_0x012c:
                r3 = r21
                com.caverock.androidsvg.CSSParser$e r2 = new com.caverock.androidsvg.CSSParser$e
                r15 = 0
                r16 = 1
                r17 = 1
                r18 = 0
                r19 = 0
                r14 = r2
                r14.<init>(r15, r16, r17, r18, r19)
                r21.b()
            L_0x0140:
                r0.b(r2)
                return
            L_0x0144:
                com.caverock.androidsvg.CSSParseException r0 = new com.caverock.androidsvg.CSSParseException
                java.lang.String r1 = "Invalid pseudo class"
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.CSSParser.c.O(com.caverock.androidsvg.CSSParser$o, com.caverock.androidsvg.CSSParser$p):void");
        }

        public final int P() {
            int i11;
            if (h()) {
                return this.f64611b;
            }
            int i12 = this.f64611b;
            int charAt = this.f64610a.charAt(i12);
            if (charAt == 45) {
                charAt = a();
            }
            if ((charAt < 65 || charAt > 90) && ((charAt < 97 || charAt > 122) && charAt != 95)) {
                i11 = i12;
            } else {
                int a11 = a();
                while (true) {
                    if ((a11 < 65 || a11 > 90) && ((a11 < 97 || a11 > 122) && !((a11 >= 48 && a11 <= 57) || a11 == 45 || a11 == 95))) {
                        break;
                    }
                    a11 = a();
                }
                i11 = this.f64611b;
            }
            this.f64611b = i12;
            return i11;
        }
    }

    public interface d {
        boolean a(m mVar, SVG.j0 j0Var);
    }

    public static class e implements d {

        /* renamed from: a  reason: collision with root package name */
        public int f64362a;

        /* renamed from: b  reason: collision with root package name */
        public int f64363b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f64364c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f64365d;

        /* renamed from: e  reason: collision with root package name */
        public String f64366e;

        public e(int i11, int i12, boolean z11, boolean z12, String str) {
            this.f64362a = i11;
            this.f64363b = i12;
            this.f64364c = z11;
            this.f64365d = z12;
            this.f64366e = str;
        }

        public boolean a(m mVar, SVG.j0 j0Var) {
            int i11;
            int i12;
            String m11 = (!this.f64365d || this.f64366e != null) ? this.f64366e : j0Var.m();
            SVG.h0 h0Var = j0Var.f64509b;
            if (h0Var != null) {
                Iterator<SVG.l0> it2 = h0Var.getChildren().iterator();
                i12 = 0;
                i11 = 0;
                while (it2.hasNext()) {
                    SVG.j0 j0Var2 = (SVG.j0) it2.next();
                    if (j0Var2 == j0Var) {
                        i12 = i11;
                    }
                    if (m11 == null || j0Var2.m().equals(m11)) {
                        i11++;
                    }
                }
            } else {
                i12 = 0;
                i11 = 1;
            }
            int i13 = this.f64364c ? i12 + 1 : i11 - i12;
            int i14 = this.f64362a;
            if (i14 != 0) {
                int i15 = this.f64363b;
                if ((i13 - i15) % i14 != 0) {
                    return false;
                }
                if (Integer.signum(i13 - i15) == 0 || Integer.signum(i13 - this.f64363b) == Integer.signum(this.f64362a)) {
                    return true;
                }
                return false;
            } else if (i13 == this.f64363b) {
                return true;
            } else {
                return false;
            }
        }

        public String toString() {
            String str = this.f64364c ? "" : "last-";
            if (this.f64365d) {
                return String.format("nth-%schild(%dn%+d of type <%s>)", new Object[]{str, Integer.valueOf(this.f64362a), Integer.valueOf(this.f64363b), this.f64366e});
            }
            return String.format("nth-%schild(%dn%+d)", new Object[]{str, Integer.valueOf(this.f64362a), Integer.valueOf(this.f64363b)});
        }
    }

    public static class f implements d {
        public f() {
        }

        public boolean a(m mVar, SVG.j0 j0Var) {
            if (!(j0Var instanceof SVG.h0) || ((SVG.h0) j0Var).getChildren().size() == 0) {
                return true;
            }
            return false;
        }

        public String toString() {
            return OptionsBridge.EMPTY_VALUE;
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public static class g implements d {

        /* renamed from: a  reason: collision with root package name */
        public List<o> f64367a;

        public g(List<o> list) {
            this.f64367a = list;
        }

        public boolean a(m mVar, SVG.j0 j0Var) {
            for (o l11 : this.f64367a) {
                if (CSSParser.l(mVar, l11, j0Var)) {
                    return false;
                }
            }
            return true;
        }

        public int b() {
            int i11 = Integer.MIN_VALUE;
            for (o oVar : this.f64367a) {
                int i12 = oVar.f64377b;
                if (i12 > i11) {
                    i11 = i12;
                }
            }
            return i11;
        }

        public String toString() {
            return "not(" + this.f64367a + ")";
        }
    }

    public static class h implements d {

        /* renamed from: a  reason: collision with root package name */
        public String f64368a;

        public h(String str) {
            this.f64368a = str;
        }

        public boolean a(m mVar, SVG.j0 j0Var) {
            return false;
        }

        public String toString() {
            return this.f64368a;
        }
    }

    public static class i implements d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f64369a;

        /* renamed from: b  reason: collision with root package name */
        public String f64370b;

        public i(boolean z11, String str) {
            this.f64369a = z11;
            this.f64370b = str;
        }

        public boolean a(m mVar, SVG.j0 j0Var) {
            int i11;
            String m11 = (!this.f64369a || this.f64370b != null) ? this.f64370b : j0Var.m();
            SVG.h0 h0Var = j0Var.f64509b;
            if (h0Var != null) {
                Iterator<SVG.l0> it2 = h0Var.getChildren().iterator();
                i11 = 0;
                while (it2.hasNext()) {
                    SVG.j0 j0Var2 = (SVG.j0) it2.next();
                    if (m11 == null || j0Var2.m().equals(m11)) {
                        i11++;
                    }
                }
            } else {
                i11 = 1;
            }
            if (i11 == 1) {
                return true;
            }
            return false;
        }

        public String toString() {
            if (!this.f64369a) {
                return String.format("only-child", new Object[0]);
            }
            return String.format("only-of-type <%s>", new Object[]{this.f64370b});
        }
    }

    public static class j implements d {
        public j() {
        }

        public boolean a(m mVar, SVG.j0 j0Var) {
            return j0Var.f64509b == null;
        }

        public String toString() {
            return "root";
        }

        public /* synthetic */ j(a aVar) {
            this();
        }
    }

    public static class k implements d {
        public k() {
        }

        public boolean a(m mVar, SVG.j0 j0Var) {
            return mVar != null && j0Var == mVar.f64374a;
        }

        public String toString() {
            return "target";
        }

        public /* synthetic */ k(a aVar) {
            this();
        }
    }

    public static class l {

        /* renamed from: a  reason: collision with root package name */
        public o f64371a = null;

        /* renamed from: b  reason: collision with root package name */
        public SVG.Style f64372b = null;

        /* renamed from: c  reason: collision with root package name */
        public Source f64373c;

        public l(o oVar, SVG.Style style, Source source) {
            this.f64371a = oVar;
            this.f64372b = style;
            this.f64373c = source;
        }

        public String toString() {
            return String.valueOf(this.f64371a) + " {...} (src=" + this.f64373c + ")";
        }
    }

    public static class m {

        /* renamed from: a  reason: collision with root package name */
        public SVG.j0 f64374a;

        public String toString() {
            SVG.j0 j0Var = this.f64374a;
            if (j0Var == null) {
                return "";
            }
            return String.format("<%s id=\"%s\">", new Object[]{j0Var.m(), this.f64374a.f64497c});
        }
    }

    public static class n {

        /* renamed from: a  reason: collision with root package name */
        public List<l> f64375a = null;

        public void a(l lVar) {
            if (this.f64375a == null) {
                this.f64375a = new ArrayList();
            }
            for (int i11 = 0; i11 < this.f64375a.size(); i11++) {
                if (this.f64375a.get(i11).f64371a.f64377b > lVar.f64371a.f64377b) {
                    this.f64375a.add(i11, lVar);
                    return;
                }
            }
            this.f64375a.add(lVar);
        }

        public void b(n nVar) {
            if (nVar.f64375a != null) {
                if (this.f64375a == null) {
                    this.f64375a = new ArrayList(nVar.f64375a.size());
                }
                for (l a11 : nVar.f64375a) {
                    a(a11);
                }
            }
        }

        public List<l> c() {
            return this.f64375a;
        }

        public boolean d() {
            List<l> list = this.f64375a;
            return list == null || list.isEmpty();
        }

        public void e(Source source) {
            List<l> list = this.f64375a;
            if (list != null) {
                Iterator<l> it2 = list.iterator();
                while (it2.hasNext()) {
                    if (it2.next().f64373c == source) {
                        it2.remove();
                    }
                }
            }
        }

        public int f() {
            List<l> list = this.f64375a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public String toString() {
            if (this.f64375a == null) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder();
            for (l lVar : this.f64375a) {
                sb2.append(lVar.toString());
                sb2.append(10);
            }
            return sb2.toString();
        }
    }

    public static class p {

        /* renamed from: a  reason: collision with root package name */
        public Combinator f64378a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f64379b = null;

        /* renamed from: c  reason: collision with root package name */
        public List<b> f64380c = null;

        /* renamed from: d  reason: collision with root package name */
        public List<d> f64381d = null;

        public p(Combinator combinator, String str) {
            this.f64378a = combinator == null ? Combinator.DESCENDANT : combinator;
            this.f64379b = str;
        }

        public void a(String str, AttribOp attribOp, String str2) {
            if (this.f64380c == null) {
                this.f64380c = new ArrayList();
            }
            this.f64380c.add(new b(str, attribOp, str2));
        }

        public void b(d dVar) {
            if (this.f64381d == null) {
                this.f64381d = new ArrayList();
            }
            this.f64381d.add(dVar);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            Combinator combinator = this.f64378a;
            if (combinator == Combinator.CHILD) {
                sb2.append("> ");
            } else if (combinator == Combinator.FOLLOWS) {
                sb2.append("+ ");
            }
            String str = this.f64379b;
            if (str == null) {
                str = "*";
            }
            sb2.append(str);
            List<b> list = this.f64380c;
            if (list != null) {
                for (b next : list) {
                    sb2.append('[');
                    sb2.append(next.f64357a);
                    int i11 = a.f64355a[next.f64358b.ordinal()];
                    if (i11 == 1) {
                        sb2.append('=');
                        sb2.append(next.f64359c);
                    } else if (i11 == 2) {
                        sb2.append("~=");
                        sb2.append(next.f64359c);
                    } else if (i11 == 3) {
                        sb2.append("|=");
                        sb2.append(next.f64359c);
                    }
                    sb2.append(']');
                }
            }
            List<d> list2 = this.f64381d;
            if (list2 != null) {
                for (d append : list2) {
                    sb2.append(':');
                    sb2.append(append);
                }
            }
            return sb2.toString();
        }
    }

    public CSSParser(Source source) {
        this(MediaType.screen, source);
    }

    public static int a(List<SVG.h0> list, int i11, SVG.j0 j0Var) {
        int i12 = 0;
        if (i11 < 0) {
            return 0;
        }
        SVG.h0 h0Var = list.get(i11);
        SVG.h0 h0Var2 = j0Var.f64509b;
        if (h0Var != h0Var2) {
            return -1;
        }
        for (SVG.l0 l0Var : h0Var2.getChildren()) {
            if (l0Var == j0Var) {
                return i12;
            }
            i12++;
        }
        return -1;
    }

    public static boolean b(String str, MediaType mediaType) {
        c cVar = new c(str);
        cVar.A();
        return c(h(cVar), mediaType);
    }

    public static boolean c(List<MediaType> list, MediaType mediaType) {
        for (MediaType next : list) {
            if (next == MediaType.all) {
                return true;
            }
            if (next == mediaType) {
                return true;
            }
        }
        return false;
    }

    public static List<String> f(String str) {
        c cVar = new c(str);
        ArrayList arrayList = null;
        while (!cVar.h()) {
            String r11 = cVar.r();
            if (r11 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(r11);
                cVar.A();
            }
        }
        return arrayList;
    }

    public static List<MediaType> h(c cVar) {
        String w11;
        ArrayList arrayList = new ArrayList();
        while (!cVar.h() && (w11 = cVar.w()) != null) {
            try {
                arrayList.add(MediaType.valueOf(w11));
            } catch (IllegalArgumentException unused) {
            }
            if (!cVar.z()) {
                break;
            }
        }
        return arrayList;
    }

    public static boolean k(m mVar, o oVar, int i11, List<SVG.h0> list, int i12, SVG.j0 j0Var) {
        p e11 = oVar.e(i11);
        if (!n(mVar, e11, list, i12, j0Var)) {
            return false;
        }
        Combinator combinator = e11.f64378a;
        if (combinator == Combinator.DESCENDANT) {
            if (i11 == 0) {
                return true;
            }
            while (i12 >= 0) {
                if (m(mVar, oVar, i11 - 1, list, i12)) {
                    return true;
                }
                i12--;
            }
            return false;
        } else if (combinator == Combinator.CHILD) {
            return m(mVar, oVar, i11 - 1, list, i12);
        } else {
            int a11 = a(list, i12, j0Var);
            if (a11 <= 0) {
                return false;
            }
            return k(mVar, oVar, i11 - 1, list, i12, (SVG.j0) j0Var.f64509b.getChildren().get(a11 - 1));
        }
    }

    public static boolean l(m mVar, o oVar, SVG.j0 j0Var) {
        ArrayList arrayList = new ArrayList();
        for (SVG.h0 h0Var = j0Var.f64509b; h0Var != null; h0Var = ((SVG.l0) h0Var).f64509b) {
            arrayList.add(0, h0Var);
        }
        int size = arrayList.size() - 1;
        if (oVar.g() == 1) {
            return n(mVar, oVar.e(0), arrayList, size, j0Var);
        }
        return k(mVar, oVar, oVar.g() - 1, arrayList, size, j0Var);
    }

    public static boolean m(m mVar, o oVar, int i11, List<SVG.h0> list, int i12) {
        p e11 = oVar.e(i11);
        SVG.j0 j0Var = (SVG.j0) list.get(i12);
        if (!n(mVar, e11, list, i12, j0Var)) {
            return false;
        }
        Combinator combinator = e11.f64378a;
        if (combinator == Combinator.DESCENDANT) {
            if (i11 == 0) {
                return true;
            }
            while (i12 > 0) {
                i12--;
                if (m(mVar, oVar, i11 - 1, list, i12)) {
                    return true;
                }
            }
            return false;
        } else if (combinator == Combinator.CHILD) {
            return m(mVar, oVar, i11 - 1, list, i12 - 1);
        } else {
            int a11 = a(list, i12, j0Var);
            if (a11 <= 0) {
                return false;
            }
            return k(mVar, oVar, i11 - 1, list, i12, (SVG.j0) j0Var.f64509b.getChildren().get(a11 - 1));
        }
    }

    public static boolean n(m mVar, p pVar, List<SVG.h0> list, int i11, SVG.j0 j0Var) {
        List<String> list2;
        String str = pVar.f64379b;
        if (str != null && !str.equals(j0Var.m().toLowerCase(Locale.US))) {
            return false;
        }
        List<b> list3 = pVar.f64380c;
        if (list3 != null) {
            for (b next : list3) {
                String str2 = next.f64357a;
                str2.hashCode();
                if (!str2.equals("id")) {
                    if (!str2.equals(Constants.CLASS) || (list2 = j0Var.f64501g) == null || !list2.contains(next.f64359c)) {
                        return false;
                    }
                } else if (!next.f64359c.equals(j0Var.f64497c)) {
                    return false;
                }
            }
        }
        List<d> list4 = pVar.f64381d;
        if (list4 == null) {
            return true;
        }
        for (d a11 : list4) {
            if (!a11.a(mVar, j0Var)) {
                return false;
            }
        }
        return true;
    }

    public static void p(String str, Object... objArr) {
        Log.w("AndroidSVG CSSParser", String.format(str, objArr));
    }

    public n d(String str) {
        c cVar = new c(str);
        cVar.A();
        return j(cVar);
    }

    public final void e(n nVar, c cVar) throws CSSParseException {
        String H = cVar.H();
        cVar.A();
        if (H != null) {
            if (!this.f64353c && H.equals("media")) {
                List<MediaType> h11 = h(cVar);
                if (cVar.f('{')) {
                    cVar.A();
                    if (c(h11, this.f64351a)) {
                        this.f64353c = true;
                        nVar.b(j(cVar));
                        this.f64353c = false;
                    } else {
                        j(cVar);
                    }
                    if (!cVar.h() && !cVar.f('}')) {
                        throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
                    }
                } else {
                    throw new CSSParseException("Invalid @media rule: missing rule set");
                }
            } else if (this.f64353c || !H.equals("import")) {
                p("Ignoring @%s rule", H);
                o(cVar);
            } else {
                String N = cVar.N();
                if (N == null) {
                    N = cVar.F();
                }
                if (N != null) {
                    cVar.A();
                    List<MediaType> h12 = h(cVar);
                    if (!cVar.h() && !cVar.f(';')) {
                        throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
                    } else if (SVG.g() != null && c(h12, this.f64351a)) {
                        String b11 = SVG.g().b(N);
                        if (b11 != null) {
                            nVar.b(d(b11));
                        } else {
                            return;
                        }
                    }
                } else {
                    throw new CSSParseException("Invalid @import rule: expected string or url()");
                }
            }
            cVar.A();
            return;
        }
        throw new CSSParseException("Invalid '@' rule");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.caverock.androidsvg.SVG.Style g(com.caverock.androidsvg.CSSParser.c r5) throws com.caverock.androidsvg.CSSParseException {
        /*
            r4 = this;
            com.caverock.androidsvg.SVG$Style r0 = new com.caverock.androidsvg.SVG$Style
            r0.<init>()
        L_0x0005:
            java.lang.String r1 = r5.H()
            r5.A()
            r2 = 58
            boolean r2 = r5.f(r2)
            if (r2 == 0) goto L_0x0061
            r5.A()
            java.lang.String r2 = r5.J()
            if (r2 == 0) goto L_0x0059
            r5.A()
            r3 = 33
            boolean r3 = r5.f(r3)
            if (r3 == 0) goto L_0x003f
            r5.A()
            java.lang.String r3 = "important"
            boolean r3 = r5.g(r3)
            if (r3 == 0) goto L_0x0037
            r5.A()
            goto L_0x003f
        L_0x0037:
            com.caverock.androidsvg.CSSParseException r5 = new com.caverock.androidsvg.CSSParseException
            java.lang.String r0 = "Malformed rule set: found unexpected '!'"
            r5.<init>(r0)
            throw r5
        L_0x003f:
            r3 = 59
            r5.f(r3)
            com.caverock.androidsvg.SVGParser.S0(r0, r1, r2)
            r5.A()
            boolean r1 = r5.h()
            if (r1 != 0) goto L_0x0058
            r1 = 125(0x7d, float:1.75E-43)
            boolean r1 = r5.f(r1)
            if (r1 == 0) goto L_0x0005
        L_0x0058:
            return r0
        L_0x0059:
            com.caverock.androidsvg.CSSParseException r5 = new com.caverock.androidsvg.CSSParseException
            java.lang.String r0 = "Expected property value"
            r5.<init>(r0)
            throw r5
        L_0x0061:
            com.caverock.androidsvg.CSSParseException r5 = new com.caverock.androidsvg.CSSParseException
            java.lang.String r0 = "Expected ':'"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.CSSParser.g(com.caverock.androidsvg.CSSParser$c):com.caverock.androidsvg.SVG$Style");
    }

    public final boolean i(n nVar, c cVar) throws CSSParseException {
        List<o> B = cVar.L();
        if (B == null || B.isEmpty()) {
            return false;
        }
        if (cVar.f('{')) {
            cVar.A();
            SVG.Style g11 = g(cVar);
            cVar.A();
            for (o lVar : B) {
                nVar.a(new l(lVar, g11, this.f64352b));
            }
            return true;
        }
        throw new CSSParseException("Malformed rule block: expected '{'");
    }

    public final n j(c cVar) {
        n nVar = new n();
        while (!cVar.h()) {
            try {
                if (!cVar.g("<!--")) {
                    if (!cVar.g("-->")) {
                        if (!cVar.f('@')) {
                            if (!i(nVar, cVar)) {
                                break;
                            }
                        } else {
                            e(nVar, cVar);
                        }
                    }
                }
            } catch (CSSParseException e11) {
                Log.e("AndroidSVG CSSParser", "CSS parser terminated early due to error: " + e11.getMessage());
            }
        }
        return nVar;
    }

    public final void o(c cVar) {
        int i11 = 0;
        while (!cVar.h()) {
            int intValue = cVar.l().intValue();
            if (intValue != 59 || i11 != 0) {
                if (intValue == 123) {
                    i11++;
                } else if (intValue == 125 && i11 > 0 && i11 - 1 == 0) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public CSSParser(MediaType mediaType, Source source) {
        this.f64351a = null;
        this.f64352b = null;
        this.f64353c = false;
        this.f64351a = mediaType;
        this.f64352b = source;
    }

    public static class o {

        /* renamed from: a  reason: collision with root package name */
        public List<p> f64376a;

        /* renamed from: b  reason: collision with root package name */
        public int f64377b;

        public o() {
            this.f64376a = null;
            this.f64377b = 0;
        }

        public void a(p pVar) {
            if (this.f64376a == null) {
                this.f64376a = new ArrayList();
            }
            this.f64376a.add(pVar);
        }

        public void b() {
            this.f64377b += 1000;
        }

        public void c() {
            this.f64377b++;
        }

        public void d() {
            this.f64377b += 1000000;
        }

        public p e(int i11) {
            return this.f64376a.get(i11);
        }

        public boolean f() {
            List<p> list = this.f64376a;
            return list == null || list.isEmpty();
        }

        public int g() {
            List<p> list = this.f64376a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            for (p append : this.f64376a) {
                sb2.append(append);
                sb2.append(' ');
            }
            sb2.append('[');
            sb2.append(this.f64377b);
            sb2.append(']');
            return sb2.toString();
        }

        public /* synthetic */ o(a aVar) {
            this();
        }
    }
}
