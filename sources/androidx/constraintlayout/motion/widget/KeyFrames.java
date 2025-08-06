package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class KeyFrames {

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, Constructor<? extends Key>> f7435b;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<Integer, ArrayList<Key>> f7436a = new HashMap<>();

    static {
        HashMap<String, Constructor<? extends Key>> hashMap = new HashMap<>();
        f7435b = hashMap;
        try {
            hashMap.put("KeyAttribute", KeyAttributes.class.getConstructor(new Class[0]));
            f7435b.put("KeyPosition", KeyPosition.class.getConstructor(new Class[0]));
            f7435b.put("KeyCycle", KeyCycle.class.getConstructor(new Class[0]));
            f7435b.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor(new Class[0]));
            f7435b.put("KeyTrigger", KeyTrigger.class.getConstructor(new Class[0]));
        } catch (NoSuchMethodException e11) {
            Log.e("KeyFrames", "unable to load", e11);
        }
    }

    public KeyFrames() {
    }

    public void a(d dVar) {
        ArrayList arrayList = this.f7436a.get(-1);
        if (arrayList != null) {
            dVar.b(arrayList);
        }
    }

    public void b(d dVar) {
        ArrayList arrayList = this.f7436a.get(Integer.valueOf(dVar.f7662c));
        if (arrayList != null) {
            dVar.b(arrayList);
        }
        ArrayList arrayList2 = this.f7436a.get(-1);
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                Key key = (Key) it2.next();
                if (key.f(((ConstraintLayout.LayoutParams) dVar.f7661b.getLayoutParams()).f7931b0)) {
                    dVar.a(key);
                }
            }
        }
    }

    public void c(Key key) {
        if (!this.f7436a.containsKey(Integer.valueOf(key.f7392b))) {
            this.f7436a.put(Integer.valueOf(key.f7392b), new ArrayList());
        }
        ArrayList arrayList = this.f7436a.get(Integer.valueOf(key.f7392b));
        if (arrayList != null) {
            arrayList.add(key);
        }
    }

    public ArrayList<Key> d(int i11) {
        return this.f7436a.get(Integer.valueOf(i11));
    }

    public KeyFrames(Context context, XmlPullParser xmlPullParser) {
        HashMap<String, ConstraintAttribute> hashMap;
        HashMap<String, ConstraintAttribute> hashMap2;
        Key key;
        Exception e11;
        Key key2 = null;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (f7435b.containsKey(name)) {
                        try {
                            Constructor constructor = f7435b.get(name);
                            if (constructor != null) {
                                key = (Key) constructor.newInstance(new Object[0]);
                                try {
                                    key.e(context, Xml.asAttributeSet(xmlPullParser));
                                    c(key);
                                } catch (Exception e12) {
                                    e11 = e12;
                                }
                                key2 = key;
                            } else {
                                throw new NullPointerException("Keymaker for " + name + " not found");
                            }
                        } catch (Exception e13) {
                            Exception exc = e13;
                            key = key2;
                            e11 = exc;
                            Log.e("KeyFrames", "unable to create ", e11);
                            key2 = key;
                            eventType = xmlPullParser.next();
                        }
                    } else if (name.equalsIgnoreCase("CustomAttribute")) {
                        if (!(key2 == null || (hashMap2 = key2.f7395e) == null)) {
                            ConstraintAttribute.i(context, xmlPullParser, hashMap2);
                        }
                    } else if (!(!name.equalsIgnoreCase("CustomMethod") || key2 == null || (hashMap = key2.f7395e) == null)) {
                        ConstraintAttribute.i(context, xmlPullParser, hashMap);
                    }
                } else if (eventType == 3) {
                    if ("KeyFrameSet".equals(xmlPullParser.getName())) {
                        return;
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (XmlPullParserException e14) {
            e14.printStackTrace();
        } catch (IOException e15) {
            e15.printStackTrace();
        }
    }
}
