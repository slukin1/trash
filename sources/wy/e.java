package wy;

import android.util.Xml;
import com.iproov.sdk.bridge.OptionsBridge;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.scuba.smartcards.ISO7816;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public class e {
    public static final Object a(XmlPullParser xmlPullParser, String[] strArr) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 2) {
            if (eventType == 3) {
                throw new XmlPullParserException("Unexpected end tag at: " + xmlPullParser.getName());
            } else if (eventType != 4) {
                try {
                    eventType = xmlPullParser.next();
                    if (eventType == 1) {
                        throw new XmlPullParserException("Unexpected end of document");
                    }
                } catch (Exception unused) {
                    throw new XmlPullParserException("Unexpected call next(): " + xmlPullParser.getName());
                }
            } else {
                throw new XmlPullParserException("Unexpected text: " + xmlPullParser.getText());
            }
        }
        return l(xmlPullParser, strArr);
    }

    public static final ArrayList b(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                arrayList.add(l(xmlPullParser, strArr));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return arrayList;
                }
                throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new XmlPullParserException("Document ended before " + str + " end tag");
    }

    public static final HashMap c(InputStream inputStream) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, (String) null);
        return (HashMap) a(newPullParser, new String[1]);
    }

    public static final HashMap d(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        HashMap hashMap = new HashMap();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                Object l11 = l(xmlPullParser, strArr);
                if (strArr[0] != null) {
                    hashMap.put(strArr[0], l11);
                } else {
                    throw new XmlPullParserException("Map value without name attribute: " + xmlPullParser.getName());
                }
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return hashMap;
                }
                throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new XmlPullParserException("Document ended before " + str + " end tag");
    }

    public static final void e(Object obj, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        String str2;
        if (obj == null) {
            xmlSerializer.startTag((String) null, OptionsBridge.NULL_VALUE);
            if (str != null) {
                xmlSerializer.attribute((String) null, "name", str);
            }
            xmlSerializer.endTag((String) null, OptionsBridge.NULL_VALUE);
        } else if (obj instanceof String) {
            xmlSerializer.startTag((String) null, "string");
            if (str != null) {
                xmlSerializer.attribute((String) null, "name", str);
            }
            xmlSerializer.text(obj.toString());
            xmlSerializer.endTag((String) null, "string");
        } else {
            if (obj instanceof Integer) {
                str2 = "int";
            } else if (obj instanceof Long) {
                str2 = "long";
            } else if (obj instanceof Float) {
                str2 = "float";
            } else if (obj instanceof Double) {
                str2 = "double";
            } else if (obj instanceof Boolean) {
                str2 = "boolean";
            } else if (obj instanceof byte[]) {
                i((byte[]) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof int[]) {
                j((int[]) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof Map) {
                h((Map) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof List) {
                f((List) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof CharSequence) {
                xmlSerializer.startTag((String) null, "string");
                if (str != null) {
                    xmlSerializer.attribute((String) null, "name", str);
                }
                xmlSerializer.text(obj.toString());
                xmlSerializer.endTag((String) null, "string");
                return;
            } else {
                throw new RuntimeException("writeValueXml: unable to write value " + obj);
            }
            xmlSerializer.startTag((String) null, str2);
            if (str != null) {
                xmlSerializer.attribute((String) null, "name", str);
            }
            xmlSerializer.attribute((String) null, "value", obj.toString());
            xmlSerializer.endTag((String) null, str2);
        }
    }

    public static final void f(List list, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (list == null) {
            xmlSerializer.startTag((String) null, OptionsBridge.NULL_VALUE);
            xmlSerializer.endTag((String) null, OptionsBridge.NULL_VALUE);
            return;
        }
        xmlSerializer.startTag((String) null, "list");
        if (str != null) {
            xmlSerializer.attribute((String) null, "name", str);
        }
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            e(list.get(i11), (String) null, xmlSerializer);
        }
        xmlSerializer.endTag((String) null, "list");
    }

    public static final void g(Map map, OutputStream outputStream) throws XmlPullParserException, IOException {
        a aVar = new a();
        aVar.setOutput(outputStream, "utf-8");
        aVar.startDocument((String) null, Boolean.TRUE);
        aVar.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        h(map, (String) null, aVar);
        aVar.endDocument();
    }

    public static final void h(Map map, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (map == null) {
            xmlSerializer.startTag((String) null, OptionsBridge.NULL_VALUE);
            xmlSerializer.endTag((String) null, OptionsBridge.NULL_VALUE);
            return;
        }
        xmlSerializer.startTag((String) null, "map");
        if (str != null) {
            xmlSerializer.attribute((String) null, "name", str);
        }
        for (Map.Entry entry : map.entrySet()) {
            e(entry.getValue(), (String) entry.getKey(), xmlSerializer);
        }
        xmlSerializer.endTag((String) null, "map");
    }

    public static final void i(byte[] bArr, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (bArr == null) {
            xmlSerializer.startTag((String) null, OptionsBridge.NULL_VALUE);
            xmlSerializer.endTag((String) null, OptionsBridge.NULL_VALUE);
            return;
        }
        xmlSerializer.startTag((String) null, "byte-array");
        if (str != null) {
            xmlSerializer.attribute((String) null, "name", str);
        }
        xmlSerializer.attribute((String) null, "num", Integer.toString(r8));
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b11 : bArr) {
            int i11 = b11 >> 4;
            sb2.append(i11 >= 10 ? (i11 + 97) - 10 : i11 + 48);
            byte b12 = b11 & 255;
            sb2.append(b12 >= 10 ? (b12 + 97) - 10 : b12 + ISO7816.INS_DECREASE);
        }
        xmlSerializer.text(sb2.toString());
        xmlSerializer.endTag((String) null, "byte-array");
    }

    public static final void j(int[] iArr, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (iArr == null) {
            xmlSerializer.startTag((String) null, OptionsBridge.NULL_VALUE);
            xmlSerializer.endTag((String) null, OptionsBridge.NULL_VALUE);
            return;
        }
        xmlSerializer.startTag((String) null, "int-array");
        if (str != null) {
            xmlSerializer.attribute((String) null, "name", str);
        }
        xmlSerializer.attribute((String) null, "num", Integer.toString(r7));
        for (int num : iArr) {
            xmlSerializer.startTag((String) null, "item");
            xmlSerializer.attribute((String) null, "value", Integer.toString(num));
            xmlSerializer.endTag((String) null, "item");
        }
        xmlSerializer.endTag((String) null, "int-array");
    }

    public static final int[] k(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        try {
            int[] iArr = new int[Integer.parseInt(xmlPullParser.getAttributeValue((String) null, "num"))];
            int i11 = 0;
            int eventType = xmlPullParser.getEventType();
            do {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("item")) {
                        try {
                            iArr[i11] = Integer.parseInt(xmlPullParser.getAttributeValue((String) null, "value"));
                        } catch (NullPointerException unused) {
                            throw new XmlPullParserException("Need value attribute in item");
                        } catch (NumberFormatException unused2) {
                            throw new XmlPullParserException("Not a number in value attribute in item");
                        }
                    } else {
                        throw new XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return iArr;
                    }
                    if (xmlPullParser.getName().equals("item")) {
                        i11++;
                    } else {
                        throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                    }
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new XmlPullParserException("Document ended before " + str + " end tag");
        } catch (NullPointerException unused3) {
            throw new XmlPullParserException("Need num attribute in byte-array");
        } catch (NumberFormatException unused4) {
            throw new XmlPullParserException("Not a number in num attribute in byte-array");
        }
    }

    public static Object l(XmlPullParser xmlPullParser, String[] strArr) throws XmlPullParserException, IOException {
        int next;
        Object obj = null;
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "name");
        String name = xmlPullParser.getName();
        if (!name.equals(OptionsBridge.NULL_VALUE)) {
            if (name.equals("string")) {
                String str = "";
                while (true) {
                    int next2 = xmlPullParser.next();
                    if (next2 == 1) {
                        throw new XmlPullParserException("Unexpected end of document in <string>");
                    } else if (next2 == 3) {
                        if (xmlPullParser.getName().equals("string")) {
                            strArr[0] = attributeValue;
                            return str;
                        }
                        throw new XmlPullParserException("Unexpected end tag in <string>: " + xmlPullParser.getName());
                    } else if (next2 == 4) {
                        str = str + xmlPullParser.getText();
                    } else if (next2 == 2) {
                        throw new XmlPullParserException("Unexpected start tag in <string>: " + xmlPullParser.getName());
                    }
                }
            } else if (name.equals("int")) {
                obj = Integer.valueOf(Integer.parseInt(xmlPullParser.getAttributeValue((String) null, "value")));
            } else if (name.equals("long")) {
                obj = Long.valueOf(xmlPullParser.getAttributeValue((String) null, "value"));
            } else if (name.equals("float")) {
                obj = Float.valueOf(xmlPullParser.getAttributeValue((String) null, "value"));
            } else if (name.equals("double")) {
                obj = Double.valueOf(xmlPullParser.getAttributeValue((String) null, "value"));
            } else if (name.equals("boolean")) {
                obj = Boolean.valueOf(xmlPullParser.getAttributeValue((String) null, "value"));
            } else if (name.equals("int-array")) {
                xmlPullParser.next();
                int[] k11 = k(xmlPullParser, "int-array", strArr);
                strArr[0] = attributeValue;
                return k11;
            } else if (name.equals("map")) {
                xmlPullParser.next();
                HashMap d11 = d(xmlPullParser, "map", strArr);
                strArr[0] = attributeValue;
                return d11;
            } else if (name.equals("list")) {
                xmlPullParser.next();
                ArrayList b11 = b(xmlPullParser, "list", strArr);
                strArr[0] = attributeValue;
                return b11;
            } else {
                throw new XmlPullParserException("Unknown tag: " + name);
            }
        }
        do {
            next = xmlPullParser.next();
            if (next == 1) {
                throw new XmlPullParserException("Unexpected end of document in <" + name + ">");
            } else if (next == 3) {
                if (xmlPullParser.getName().equals(name)) {
                    strArr[0] = attributeValue;
                    return obj;
                }
                throw new XmlPullParserException("Unexpected end tag in <" + name + ">: " + xmlPullParser.getName());
            } else if (next == 4) {
                throw new XmlPullParserException("Unexpected text in <" + name + ">: " + xmlPullParser.getName());
            }
        } while (next != 2);
        throw new XmlPullParserException("Unexpected start tag in <" + name + ">: " + xmlPullParser.getName());
    }
}
