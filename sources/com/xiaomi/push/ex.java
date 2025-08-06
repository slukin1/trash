package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class ex {

    /* renamed from: a  reason: collision with root package name */
    private XmlPullParser f51758a;

    public ex() {
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            this.f51758a = newPullParser;
            newPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);
        } catch (XmlPullParserException unused) {
        }
    }

    public fp a(byte[] bArr, fb fbVar) {
        this.f51758a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.f51758a.next();
        int eventType = this.f51758a.getEventType();
        String name = this.f51758a.getName();
        if (eventType != 2) {
            return null;
        }
        if (name.equals("message")) {
            return fx.a(this.f51758a);
        }
        if (name.equals("iq")) {
            return fx.a(this.f51758a, fbVar);
        }
        if (name.equals("presence")) {
            return fx.a(this.f51758a);
        }
        if (this.f51758a.getName().equals("stream")) {
            return null;
        }
        if (this.f51758a.getName().equals("error")) {
            throw new fj(fx.a(this.f51758a));
        } else if (this.f51758a.getName().equals("warning")) {
            this.f51758a.next();
            this.f51758a.getName().equals("multi-login");
            return null;
        } else {
            this.f51758a.getName().equals("bind");
            return null;
        }
    }
}
