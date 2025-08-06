package com.amazonaws.transform;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.IOException;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class StaxUnmarshallerContext {

    /* renamed from: a  reason: collision with root package name */
    public int f15524a;

    /* renamed from: b  reason: collision with root package name */
    public final XmlPullParser f15525b;

    /* renamed from: c  reason: collision with root package name */
    public final Deque<String> f15526c;

    /* renamed from: d  reason: collision with root package name */
    public String f15527d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f15528e;

    /* renamed from: f  reason: collision with root package name */
    public List<MetadataExpression> f15529f;

    public static class MetadataExpression {

        /* renamed from: a  reason: collision with root package name */
        public String f15530a;

        /* renamed from: b  reason: collision with root package name */
        public int f15531b;

        /* renamed from: c  reason: collision with root package name */
        public String f15532c;
    }

    public int a() {
        return this.f15526c.size();
    }

    public boolean b() {
        return this.f15524a == 0;
    }

    public int c() throws XmlPullParserException, IOException {
        int next = this.f15525b.next();
        this.f15524a = next;
        if (next == 4) {
            this.f15524a = this.f15525b.next();
        }
        f();
        if (this.f15524a == 2) {
            Iterator<MetadataExpression> it2 = this.f15529f.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                MetadataExpression next2 = it2.next();
                if (e(next2.f15530a, next2.f15531b)) {
                    this.f15528e.put(next2.f15532c, d());
                    break;
                }
            }
        }
        return this.f15524a;
    }

    public String d() throws XmlPullParserException, IOException {
        String nextText = this.f15525b.nextText();
        if (this.f15525b.getEventType() != 3) {
            this.f15525b.next();
        }
        this.f15524a = this.f15525b.getEventType();
        f();
        return nextText;
    }

    public boolean e(String str, int i11) {
        if (InstructionFileId.DOT.equals(str)) {
            return true;
        }
        int i12 = -1;
        while (true) {
            i12 = str.indexOf("/", i12 + 1);
            if (i12 <= -1) {
                break;
            } else if (str.charAt(i12 + 1) != '@') {
                i11++;
            }
        }
        if (a() == i11) {
            if (this.f15527d.endsWith("/" + str)) {
                return true;
            }
        }
        return false;
    }

    public final void f() {
        int i11 = this.f15524a;
        if (i11 == 2) {
            String str = this.f15527d + "/" + this.f15525b.getName();
            this.f15527d = str;
            this.f15526c.push(str);
        } else if (i11 == 3) {
            this.f15526c.pop();
            this.f15527d = this.f15526c.isEmpty() ? "" : this.f15526c.peek();
        }
    }
}
