package com.xiaomi.push;

import android.text.TextUtils;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.fn;
import com.xiaomi.push.fr;
import com.xiaomi.push.ft;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.ar;
import com.xiaomi.push.service.i;
import e7.s;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class fx {

    /* renamed from: a  reason: collision with root package name */
    private static XmlPullParser f51874a;

    public static fp a(XmlPullParser xmlPullParser) {
        String str;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        boolean z11 = false;
        String str2 = null;
        if ("1".equals(xmlPullParser2.getAttributeValue("", s.f70071a))) {
            String attributeValue = xmlPullParser2.getAttributeValue("", "chid");
            String attributeValue2 = xmlPullParser2.getAttributeValue("", "id");
            String attributeValue3 = xmlPullParser2.getAttributeValue("", "from");
            String attributeValue4 = xmlPullParser2.getAttributeValue("", "to");
            String attributeValue5 = xmlPullParser2.getAttributeValue("", "type");
            am.b a11 = am.a().a(attributeValue, attributeValue4);
            if (a11 == null) {
                a11 = am.a().a(attributeValue, attributeValue3);
            }
            if (a11 != null) {
                fp fpVar = null;
                while (!z11) {
                    int next = xmlPullParser.next();
                    if (next == 2) {
                        if (!s.f70071a.equals(xmlPullParser.getName())) {
                            throw new fj("error while receiving a encrypted message with wrong format");
                        } else if (xmlPullParser.next() == 4) {
                            String text = xmlPullParser.getText();
                            if (BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC.equals(attributeValue) || BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL.equals(attributeValue)) {
                                fo foVar = new fo();
                                foVar.l(attributeValue);
                                foVar.b(true);
                                foVar.n(attributeValue3);
                                foVar.m(attributeValue4);
                                foVar.k(attributeValue2);
                                foVar.f(attributeValue5);
                                fm fmVar = new fm(s.f70071a, (String) null, (String[]) null, (String[]) null);
                                fmVar.a(text);
                                foVar.a(fmVar);
                                return foVar;
                            }
                            a(ar.a(ar.a(a11.f52471h, attributeValue2), text));
                            f51874a.next();
                            fpVar = a(f51874a);
                        } else {
                            throw new fj("error while receiving a encrypted message with wrong format");
                        }
                    } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                        z11 = true;
                    }
                }
                if (fpVar != null) {
                    return fpVar;
                }
                throw new fj("error while receiving a encrypted message with wrong format");
            }
            throw new fj("the channel id is wrong while receiving a encrypted message");
        }
        fo foVar2 = new fo();
        String attributeValue6 = xmlPullParser2.getAttributeValue("", "id");
        if (attributeValue6 == null) {
            attributeValue6 = "ID_NOT_AVAILABLE";
        }
        foVar2.k(attributeValue6);
        foVar2.m(xmlPullParser2.getAttributeValue("", "to"));
        foVar2.n(xmlPullParser2.getAttributeValue("", "from"));
        foVar2.l(xmlPullParser2.getAttributeValue("", "chid"));
        foVar2.a(xmlPullParser2.getAttributeValue("", "appid"));
        try {
            str = xmlPullParser2.getAttributeValue("", FacebookRequestErrorClassification.KEY_TRANSIENT);
        } catch (Exception unused) {
            str = null;
        }
        try {
            String attributeValue7 = xmlPullParser2.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                foVar2.b(attributeValue7);
            }
        } catch (Exception unused2) {
        }
        try {
            String attributeValue8 = xmlPullParser2.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                foVar2.c(attributeValue8);
            }
        } catch (Exception unused3) {
        }
        try {
            String attributeValue9 = xmlPullParser2.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                foVar2.d(attributeValue9);
            }
        } catch (Exception unused4) {
        }
        try {
            String attributeValue10 = xmlPullParser2.getAttributeValue("", "status");
            if (!TextUtils.isEmpty(attributeValue10)) {
                foVar2.e(attributeValue10);
            }
        } catch (Exception unused5) {
        }
        foVar2.a(!TextUtils.isEmpty(str) && str.equalsIgnoreCase("true"));
        foVar2.f(xmlPullParser2.getAttributeValue("", "type"));
        String b11 = b(xmlPullParser);
        if (b11 == null || "".equals(b11.trim())) {
            fp.q();
        } else {
            foVar2.j(b11);
        }
        while (!z11) {
            int next2 = xmlPullParser.next();
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (TextUtils.isEmpty(namespace)) {
                    namespace = "xm";
                }
                if (name.equals("subject")) {
                    b(xmlPullParser);
                    foVar2.g(a(xmlPullParser));
                } else if (name.equals(TtmlNode.TAG_BODY)) {
                    String attributeValue11 = xmlPullParser2.getAttributeValue("", "encode");
                    String a12 = a(xmlPullParser);
                    if (!TextUtils.isEmpty(attributeValue11)) {
                        foVar2.a(a12, attributeValue11);
                    } else {
                        foVar2.h(a12);
                    }
                } else if (name.equals("thread")) {
                    if (str2 == null) {
                        str2 = xmlPullParser.nextText();
                    }
                } else if (name.equals("error")) {
                    foVar2.a(a(xmlPullParser));
                } else {
                    foVar2.a(a(name, namespace, xmlPullParser2));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z11 = true;
            }
        }
        foVar2.i(str2);
        return foVar2;
    }

    private static String b(XmlPullParser xmlPullParser) {
        for (int i11 = 0; i11 < xmlPullParser.getAttributeCount(); i11++) {
            String attributeName = xmlPullParser.getAttributeName(i11);
            if ("xml:lang".equals(attributeName) || ("lang".equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i11)))) {
                return xmlPullParser.getAttributeValue(i11);
            }
        }
        return null;
    }

    private static void a(byte[] bArr) {
        if (f51874a == null) {
            try {
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                f51874a = newPullParser;
                newPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);
            } catch (XmlPullParserException e11) {
                e11.printStackTrace();
            }
        }
        f51874a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
    }

    /* renamed from: a  reason: collision with other method in class */
    private static String m2708a(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        String str = "";
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static fr m2705a(XmlPullParser xmlPullParser) {
        fr.b bVar = fr.b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVar = fr.b.valueOf(attributeValue);
            } catch (IllegalArgumentException unused) {
                System.err.println("Found invalid presence type " + attributeValue);
            }
        }
        fr frVar = new fr(bVar);
        frVar.m(xmlPullParser.getAttributeValue("", "to"));
        frVar.n(xmlPullParser.getAttributeValue("", "from"));
        frVar.l(xmlPullParser.getAttributeValue("", "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        frVar.k(attributeValue2);
        boolean z11 = false;
        while (!z11) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("status")) {
                    frVar.a(xmlPullParser.nextText());
                } else if (name.equals("priority")) {
                    try {
                        frVar.a(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException unused2) {
                    } catch (IllegalArgumentException unused3) {
                        frVar.a(0);
                    }
                } else if (name.equals("show")) {
                    String nextText = xmlPullParser.nextText();
                    try {
                        frVar.a(fr.a.valueOf(nextText));
                    } catch (IllegalArgumentException unused4) {
                        System.err.println("Found invalid presence mode " + nextText);
                    }
                } else if (name.equals("error")) {
                    frVar.a(a(xmlPullParser));
                } else {
                    frVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z11 = true;
            }
        }
        return frVar;
    }

    public static fn a(XmlPullParser xmlPullParser, fb fbVar) {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        fn.a a11 = fn.a.a(xmlPullParser.getAttributeValue("", "type"));
        HashMap hashMap = new HashMap();
        boolean z11 = false;
        for (int i11 = 0; i11 < xmlPullParser.getAttributeCount(); i11++) {
            String attributeName = xmlPullParser.getAttributeName(i11);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        fn fnVar = null;
        ft ftVar = null;
        while (!z11) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("error")) {
                    ftVar = a(xmlPullParser);
                } else {
                    fnVar = new fn();
                    fnVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z11 = true;
            }
        }
        if (fnVar == null) {
            if (fn.a.f51802a == a11 || fn.a.f51803b == a11) {
                AnonymousClass1 r13 = new fn() {
                    public String b() {
                        return null;
                    }
                };
                r13.k(attributeValue);
                r13.m(attributeValue3);
                r13.n(attributeValue2);
                r13.a(fn.a.f51805d);
                r13.l(attributeValue4);
                r13.a(new ft(ft.a.f51852e));
                fbVar.a((fp) r13);
                b.d("iq usage error. send packet in packet parser.");
                return null;
            }
            fnVar = new fn() {
                public String b() {
                    return null;
                }
            };
        }
        fnVar.k(attributeValue);
        fnVar.m(attributeValue2);
        fnVar.l(attributeValue4);
        fnVar.n(attributeValue3);
        fnVar.a(a11);
        fnVar.a(ftVar);
        fnVar.a((Map<String, String>) hashMap);
        return fnVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static fs m2706a(XmlPullParser xmlPullParser) {
        fs fsVar = null;
        boolean z11 = false;
        while (!z11) {
            int next = xmlPullParser.next();
            if (next == 2) {
                fsVar = new fs(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals("error")) {
                z11 = true;
            }
        }
        return fsVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static ft m2707a(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        boolean z11 = false;
        String str = "-1";
        String str2 = null;
        String str3 = null;
        for (int i11 = 0; i11 < xmlPullParser.getAttributeCount(); i11++) {
            if (xmlPullParser.getAttributeName(i11).equals("code")) {
                str = xmlPullParser.getAttributeValue("", "code");
            }
            if (xmlPullParser.getAttributeName(i11).equals("type")) {
                str3 = xmlPullParser.getAttributeValue("", "type");
            }
            if (xmlPullParser.getAttributeName(i11).equals(Constants.REASON)) {
                str2 = xmlPullParser.getAttributeValue("", Constants.REASON);
            }
        }
        String str4 = null;
        String str5 = null;
        while (!z11) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("text")) {
                    str5 = xmlPullParser.nextText();
                } else {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(namespace)) {
                        str4 = name;
                    } else {
                        arrayList.add(a(name, namespace, xmlPullParser));
                    }
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals("error")) {
                    z11 = true;
                }
            } else if (next == 4) {
                str5 = xmlPullParser.getText();
            }
        }
        return new ft(Integer.parseInt(str), str3 == null ? "cancel" : str3, str2, str4, str5, arrayList);
    }

    public static fm a(String str, String str2, XmlPullParser xmlPullParser) {
        Object a11 = fw.a().a(TtmlNode.COMBINE_ALL, "xm:chat");
        if (a11 == null || !(a11 instanceof i)) {
            return null;
        }
        return ((i) a11).b(xmlPullParser);
    }
}
