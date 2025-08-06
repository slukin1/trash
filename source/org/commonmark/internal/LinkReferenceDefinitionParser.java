package org.commonmark.internal;

import java.util.ArrayList;
import java.util.List;
import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.LinkScanner;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.LinkReferenceDefinition;

public class LinkReferenceDefinitionParser {

    /* renamed from: a  reason: collision with root package name */
    public State f59655a = State.START_DEFINITION;

    /* renamed from: b  reason: collision with root package name */
    public final StringBuilder f59656b = new StringBuilder();

    /* renamed from: c  reason: collision with root package name */
    public final List<LinkReferenceDefinition> f59657c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public StringBuilder f59658d;

    /* renamed from: e  reason: collision with root package name */
    public String f59659e;

    /* renamed from: f  reason: collision with root package name */
    public String f59660f;

    /* renamed from: g  reason: collision with root package name */
    public char f59661g;

    /* renamed from: h  reason: collision with root package name */
    public StringBuilder f59662h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f59663i = false;

    public enum State {
        START_DEFINITION,
        LABEL,
        DESTINATION,
        START_TITLE,
        TITLE,
        PARAGRAPH
    }

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f59664a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.commonmark.internal.LinkReferenceDefinitionParser$State[] r0 = org.commonmark.internal.LinkReferenceDefinitionParser.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f59664a = r0
                org.commonmark.internal.LinkReferenceDefinitionParser$State r1 = org.commonmark.internal.LinkReferenceDefinitionParser.State.PARAGRAPH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f59664a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.commonmark.internal.LinkReferenceDefinitionParser$State r1 = org.commonmark.internal.LinkReferenceDefinitionParser.State.START_DEFINITION     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f59664a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.commonmark.internal.LinkReferenceDefinitionParser$State r1 = org.commonmark.internal.LinkReferenceDefinitionParser.State.LABEL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f59664a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.commonmark.internal.LinkReferenceDefinitionParser$State r1 = org.commonmark.internal.LinkReferenceDefinitionParser.State.DESTINATION     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f59664a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.commonmark.internal.LinkReferenceDefinitionParser$State r1 = org.commonmark.internal.LinkReferenceDefinitionParser.State.START_TITLE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f59664a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.commonmark.internal.LinkReferenceDefinitionParser$State r1 = org.commonmark.internal.LinkReferenceDefinitionParser.State.TITLE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.commonmark.internal.LinkReferenceDefinitionParser.a.<clinit>():void");
        }
    }

    public final int a(CharSequence charSequence, int i11) {
        String str;
        int m11 = Parsing.m(charSequence, i11, charSequence.length());
        int a11 = LinkScanner.a(charSequence, m11);
        if (a11 == -1) {
            return -1;
        }
        if (charSequence.charAt(m11) == '<') {
            str = charSequence.subSequence(m11 + 1, a11 - 1).toString();
        } else {
            str = charSequence.subSequence(m11, a11).toString();
        }
        this.f59660f = str;
        int m12 = Parsing.m(charSequence, a11, charSequence.length());
        if (m12 >= charSequence.length()) {
            this.f59663i = true;
            this.f59656b.setLength(0);
        } else if (m12 == a11) {
            return -1;
        }
        this.f59655a = State.START_TITLE;
        return m12;
    }

    public final void b() {
        if (this.f59663i) {
            String e11 = Escaping.e(this.f59660f);
            StringBuilder sb2 = this.f59662h;
            this.f59657c.add(new LinkReferenceDefinition(this.f59659e, e11, sb2 != null ? Escaping.e(sb2.toString()) : null));
            this.f59658d = null;
            this.f59663i = false;
            this.f59659e = null;
            this.f59660f = null;
            this.f59662h = null;
        }
    }

    public List<LinkReferenceDefinition> c() {
        b();
        return this.f59657c;
    }

    public CharSequence d() {
        return this.f59656b;
    }

    public final int e(CharSequence charSequence, int i11) {
        int i12;
        int c11 = LinkScanner.c(charSequence, i11);
        if (c11 == -1) {
            return -1;
        }
        this.f59658d.append(charSequence, i11, c11);
        if (c11 >= charSequence.length()) {
            this.f59658d.append(10);
            return c11;
        } else if (charSequence.charAt(c11) != ']' || (i12 = c11 + 1) >= charSequence.length() || charSequence.charAt(i12) != ':' || this.f59658d.length() > 999) {
            return -1;
        } else {
            String b11 = Escaping.b(this.f59658d.toString());
            if (b11.isEmpty()) {
                return -1;
            }
            this.f59659e = b11;
            this.f59655a = State.DESTINATION;
            return Parsing.m(charSequence, i12 + 1, charSequence.length());
        }
    }

    public void f(CharSequence charSequence) {
        if (this.f59656b.length() != 0) {
            this.f59656b.append(10);
        }
        this.f59656b.append(charSequence);
        int i11 = 0;
        while (i11 < charSequence.length()) {
            switch (a.f59664a[this.f59655a.ordinal()]) {
                case 1:
                    return;
                case 2:
                    i11 = g(charSequence, i11);
                    break;
                case 3:
                    i11 = e(charSequence, i11);
                    break;
                case 4:
                    i11 = a(charSequence, i11);
                    break;
                case 5:
                    i11 = h(charSequence, i11);
                    break;
                case 6:
                    i11 = i(charSequence, i11);
                    break;
            }
            if (i11 == -1) {
                this.f59655a = State.PARAGRAPH;
                return;
            }
        }
    }

    public final int g(CharSequence charSequence, int i11) {
        int m11 = Parsing.m(charSequence, i11, charSequence.length());
        if (m11 >= charSequence.length() || charSequence.charAt(m11) != '[') {
            return -1;
        }
        this.f59655a = State.LABEL;
        this.f59658d = new StringBuilder();
        int i12 = m11 + 1;
        if (i12 >= charSequence.length()) {
            this.f59658d.append(10);
        }
        return i12;
    }

    public final int h(CharSequence charSequence, int i11) {
        int m11 = Parsing.m(charSequence, i11, charSequence.length());
        if (m11 >= charSequence.length()) {
            this.f59655a = State.START_DEFINITION;
            return m11;
        }
        this.f59661g = 0;
        char charAt = charSequence.charAt(m11);
        if (charAt == '\"' || charAt == '\'') {
            this.f59661g = charAt;
        } else if (charAt == '(') {
            this.f59661g = ')';
        }
        if (this.f59661g != 0) {
            this.f59655a = State.TITLE;
            this.f59662h = new StringBuilder();
            m11++;
            if (m11 == charSequence.length()) {
                this.f59662h.append(10);
            }
        } else {
            b();
            this.f59655a = State.START_DEFINITION;
        }
        return m11;
    }

    public final int i(CharSequence charSequence, int i11) {
        int e11 = LinkScanner.e(charSequence, i11, this.f59661g);
        if (e11 == -1) {
            return -1;
        }
        this.f59662h.append(charSequence.subSequence(i11, e11));
        if (e11 >= charSequence.length()) {
            this.f59662h.append(10);
            return e11;
        }
        int m11 = Parsing.m(charSequence, e11 + 1, charSequence.length());
        if (m11 != charSequence.length()) {
            return -1;
        }
        this.f59663i = true;
        b();
        this.f59656b.setLength(0);
        this.f59655a = State.START_DEFINITION;
        return m11;
    }
}
