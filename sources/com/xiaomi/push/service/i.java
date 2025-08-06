package com.xiaomi.push.service;

import com.xiaomi.push.fm;
import com.xiaomi.push.fv;
import com.xiaomi.push.fw;
import com.xiaomi.push.fy;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class i implements fv {
    public void a() {
        fw.a().a(TtmlNode.COMBINE_ALL, "xm:chat", this);
    }

    public fm b(XmlPullParser xmlPullParser) {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1 && eventType != 2) {
            eventType = xmlPullParser.next();
        }
        if (eventType == 2) {
            return a(xmlPullParser);
        }
        return null;
    }

    public static fm a(XmlPullParser xmlPullParser) {
        ArrayList arrayList;
        String str;
        String[] strArr;
        String[] strArr2;
        if (xmlPullParser.getEventType() != 2) {
            return null;
        }
        String name = xmlPullParser.getName();
        String namespace = xmlPullParser.getNamespace();
        if (xmlPullParser.getAttributeCount() > 0) {
            String[] strArr3 = new String[xmlPullParser.getAttributeCount()];
            String[] strArr4 = new String[xmlPullParser.getAttributeCount()];
            for (int i11 = 0; i11 < xmlPullParser.getAttributeCount(); i11++) {
                strArr3[i11] = xmlPullParser.getAttributeName(i11);
                strArr4[i11] = fy.b(xmlPullParser.getAttributeValue(i11));
            }
            strArr2 = strArr3;
            str = null;
            arrayList = null;
            strArr = strArr4;
        } else {
            strArr2 = null;
            strArr = null;
            str = null;
            arrayList = null;
        }
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3) {
                return new fm(name, namespace, strArr2, strArr, str, arrayList);
            }
            if (next == 4) {
                str = xmlPullParser.getText().trim();
            } else if (next == 2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                fm a11 = a(xmlPullParser);
                if (a11 != null) {
                    arrayList.add(a11);
                }
            }
        }
    }
}
