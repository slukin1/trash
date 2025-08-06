package org.commonmark.internal;

import c20.d;
import c20.e;
import c20.f;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.BulletList;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.OrderedList;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;

public class ListBlockParser extends AbstractBlockParser {

    /* renamed from: a  reason: collision with root package name */
    public final ListBlock f59665a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59666b;

    /* renamed from: c  reason: collision with root package name */
    public int f59667c;

    public static class Factory extends AbstractBlockParserFactory {
        public d a(f fVar, e eVar) {
            c20.b a11 = eVar.a();
            if (fVar.e() >= Parsing.f59756a) {
                return d.c();
            }
            a i11 = ListBlockParser.n(fVar.b(), fVar.d(), fVar.c() + fVar.e(), eVar.b() != null);
            if (i11 == null) {
                return d.c();
            }
            int i12 = i11.f59669b;
            h hVar = new h(i12 - fVar.c());
            if (!(a11 instanceof ListBlockParser) || !ListBlockParser.m((ListBlock) a11.d(), i11.f59668a)) {
                ListBlockParser listBlockParser = new ListBlockParser(i11.f59668a);
                i11.f59668a.o(true);
                return d.d(listBlockParser, hVar).a(i12);
            }
            return d.d(hVar).a(i12);
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final ListBlock f59668a;

        /* renamed from: b  reason: collision with root package name */
        public final int f59669b;

        public a(ListBlock listBlock, int i11) {
            this.f59668a = listBlock;
            this.f59669b = i11;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final ListBlock f59670a;

        /* renamed from: b  reason: collision with root package name */
        public final int f59671b;

        public b(ListBlock listBlock, int i11) {
            this.f59670a = listBlock;
            this.f59671b = i11;
        }
    }

    public ListBlockParser(ListBlock listBlock) {
        this.f59665a = listBlock;
    }

    public static boolean k(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean l(CharSequence charSequence, int i11) {
        char charAt;
        if (i11 >= charSequence.length() || (charAt = charSequence.charAt(i11)) == 9 || charAt == ' ') {
            return true;
        }
        return false;
    }

    public static boolean m(ListBlock listBlock, ListBlock listBlock2) {
        if ((listBlock instanceof BulletList) && (listBlock2 instanceof BulletList)) {
            return k(Character.valueOf(((BulletList) listBlock).p()), Character.valueOf(((BulletList) listBlock2).p()));
        }
        if (!(listBlock instanceof OrderedList) || !(listBlock2 instanceof OrderedList)) {
            return false;
        }
        return k(Character.valueOf(((OrderedList) listBlock).p()), Character.valueOf(((OrderedList) listBlock2).p()));
    }

    public static a n(CharSequence charSequence, int i11, int i12, boolean z11) {
        b o11 = o(charSequence, i11);
        if (o11 == null) {
            return null;
        }
        ListBlock listBlock = o11.f59670a;
        int i13 = o11.f59671b;
        int i14 = i12 + (i13 - i11);
        boolean z12 = false;
        int length = charSequence.length();
        int i15 = i14;
        while (true) {
            if (i13 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i13);
            if (charAt != 9) {
                if (charAt != ' ') {
                    z12 = true;
                    break;
                }
                i15++;
            } else {
                i15 += Parsing.a(i15);
            }
            i13++;
        }
        if (z11 && (((listBlock instanceof OrderedList) && ((OrderedList) listBlock).q() != 1) || !z12)) {
            return null;
        }
        if (!z12 || i15 - i14 > Parsing.f59756a) {
            i15 = i14 + 1;
        }
        return new a(listBlock, i15);
    }

    public static b o(CharSequence charSequence, int i11) {
        char charAt = charSequence.charAt(i11);
        if (charAt != '*' && charAt != '+' && charAt != '-') {
            return p(charSequence, i11);
        }
        int i12 = i11 + 1;
        if (!l(charSequence, i12)) {
            return null;
        }
        BulletList bulletList = new BulletList();
        bulletList.q(charAt);
        return new b(bulletList, i12);
    }

    public static b p(CharSequence charSequence, int i11) {
        char charAt;
        int length = charSequence.length();
        int i12 = 0;
        int i13 = i11;
        while (true) {
            if (i13 < length) {
                charAt = charSequence.charAt(i13);
                if (charAt != ')' && charAt != '.') {
                    switch (charAt) {
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
                            if (i12 > 9) {
                                return null;
                            }
                            i13++;
                        default:
                            return null;
                    }
                }
            }
        }
        if (i12 >= 1) {
            int i14 = i13 + 1;
            if (l(charSequence, i14)) {
                String charSequence2 = charSequence.subSequence(i11, i13).toString();
                OrderedList orderedList = new OrderedList();
                orderedList.s(Integer.parseInt(charSequence2));
                orderedList.r(charAt);
                return new b(orderedList, i14);
            }
        }
        return null;
    }

    public boolean a() {
        return true;
    }

    public Block d() {
        return this.f59665a;
    }

    public boolean f(Block block) {
        if (!(block instanceof ListItem)) {
            return false;
        }
        if (this.f59666b && this.f59667c == 1) {
            this.f59665a.o(false);
            this.f59666b = false;
        }
        return true;
    }

    public c20.a g(f fVar) {
        if (fVar.a()) {
            this.f59666b = true;
            this.f59667c = 0;
        } else if (this.f59666b) {
            this.f59667c++;
        }
        return c20.a.b(fVar.getIndex());
    }
}
