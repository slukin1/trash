package cn.sharesdk.framework.utils;

import android.text.TextUtils;
import android.util.Xml;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class o {

    public static class a extends DefaultHandler {

        /* renamed from: a  reason: collision with root package name */
        private HashMap<String, Object> f13538a = new HashMap<>();

        /* renamed from: b  reason: collision with root package name */
        private HashMap<String, Object> f13539b;

        public HashMap<String, Object> a() {
            return this.f13538a;
        }

        public void characters(char[] cArr, int i11, int i12) {
            HashMap<String, Object> hashMap;
            String trim = String.valueOf(cArr, i11, i12).trim();
            if (!TextUtils.isEmpty(trim) && (hashMap = this.f13539b) != null) {
                hashMap.put("value", trim);
            }
        }

        public void endElement(String str, String str2, String str3) throws SAXException {
            this.f13539b = null;
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            if (this.f13539b != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                this.f13539b.put(str2, hashMap);
                this.f13539b = hashMap;
            } else {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                this.f13539b = hashMap2;
                this.f13538a.put(str2, hashMap2);
            }
            int length = attributes.getLength();
            for (int i11 = 0; i11 < length; i11++) {
                this.f13539b.put(attributes.getLocalName(i11), attributes.getValue(i11));
            }
        }
    }

    public HashMap<String, Object> a(String str) throws Throwable {
        a aVar = new a();
        Xml.parse(str, aVar);
        return aVar.a();
    }
}
