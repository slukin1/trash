package v1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import androidx.collection.ArrayMap;
import androidx.transition.ArcMotion;
import androidx.transition.AutoTransition;
import androidx.transition.ChangeBounds;
import androidx.transition.ChangeClipBounds;
import androidx.transition.ChangeImageTransform;
import androidx.transition.ChangeScroll;
import androidx.transition.ChangeTransform;
import androidx.transition.Explode;
import androidx.transition.Fade;
import androidx.transition.PathMotion;
import androidx.transition.PatternPathMotion;
import androidx.transition.Slide;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.IOException;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import s0.i;

public class m {

    /* renamed from: b  reason: collision with root package name */
    public static final Class<?>[] f16673b = {Context.class, AttributeSet.class};

    /* renamed from: c  reason: collision with root package name */
    public static final ArrayMap<String, Constructor<?>> f16674c = new ArrayMap<>();

    /* renamed from: a  reason: collision with root package name */
    public final Context f16675a;

    public m(Context context) {
        this.f16675a = context;
    }

    public static m c(Context context) {
        return new m(context);
    }

    public final Object a(AttributeSet attributeSet, Class<?> cls, String str) {
        Object newInstance;
        Class<? extends U> asSubclass;
        String attributeValue = attributeSet.getAttributeValue((String) null, Constants.CLASS);
        if (attributeValue != null) {
            try {
                ArrayMap<String, Constructor<?>> arrayMap = f16674c;
                synchronized (arrayMap) {
                    Constructor<? extends U> constructor = arrayMap.get(attributeValue);
                    if (constructor == null && (asSubclass = Class.forName(attributeValue, false, this.f16675a.getClassLoader()).asSubclass(cls)) != null) {
                        constructor = asSubclass.getConstructor(f16673b);
                        constructor.setAccessible(true);
                        arrayMap.put(attributeValue, constructor);
                    }
                    newInstance = constructor.newInstance(new Object[]{this.f16675a, attributeSet});
                }
                return newInstance;
            } catch (Exception e11) {
                throw new InflateException("Could not instantiate " + cls + " class " + attributeValue, e11);
            }
        } else {
            throw new InflateException(str + " tag must have a 'class' attribute");
        }
    }

    public final Transition b(XmlPullParser xmlPullParser, AttributeSet attributeSet, Transition transition) throws XmlPullParserException, IOException {
        Transition transition2;
        int depth = xmlPullParser.getDepth();
        TransitionSet transitionSet = transition instanceof TransitionSet ? (TransitionSet) transition : null;
        loop0:
        while (true) {
            transition2 = null;
            while (true) {
                int next = xmlPullParser.next();
                if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                    if (next == 2) {
                        String name = xmlPullParser.getName();
                        if ("fade".equals(name)) {
                            transition2 = new Fade(this.f16675a, attributeSet);
                        } else if ("changeBounds".equals(name)) {
                            transition2 = new ChangeBounds(this.f16675a, attributeSet);
                        } else if ("slide".equals(name)) {
                            transition2 = new Slide(this.f16675a, attributeSet);
                        } else if ("explode".equals(name)) {
                            transition2 = new Explode(this.f16675a, attributeSet);
                        } else if ("changeImageTransform".equals(name)) {
                            transition2 = new ChangeImageTransform(this.f16675a, attributeSet);
                        } else if ("changeTransform".equals(name)) {
                            transition2 = new ChangeTransform(this.f16675a, attributeSet);
                        } else if ("changeClipBounds".equals(name)) {
                            transition2 = new ChangeClipBounds(this.f16675a, attributeSet);
                        } else if ("autoTransition".equals(name)) {
                            transition2 = new AutoTransition(this.f16675a, attributeSet);
                        } else if ("changeScroll".equals(name)) {
                            transition2 = new ChangeScroll(this.f16675a, attributeSet);
                        } else if ("transitionSet".equals(name)) {
                            transition2 = new TransitionSet(this.f16675a, attributeSet);
                        } else if ("transition".equals(name)) {
                            transition2 = (Transition) a(attributeSet, Transition.class, "transition");
                        } else if ("targets".equals(name)) {
                            d(xmlPullParser, attributeSet, transition);
                        } else if ("arcMotion".equals(name)) {
                            if (transition != null) {
                                transition.setPathMotion(new ArcMotion(this.f16675a, attributeSet));
                            } else {
                                throw new RuntimeException("Invalid use of arcMotion element");
                            }
                        } else if ("pathMotion".equals(name)) {
                            if (transition != null) {
                                transition.setPathMotion((PathMotion) a(attributeSet, PathMotion.class, "pathMotion"));
                            } else {
                                throw new RuntimeException("Invalid use of pathMotion element");
                            }
                        } else if (!"patternPathMotion".equals(name)) {
                            throw new RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                        } else if (transition != null) {
                            transition.setPathMotion(new PatternPathMotion(this.f16675a, attributeSet));
                        } else {
                            throw new RuntimeException("Invalid use of patternPathMotion element");
                        }
                        if (transition2 == null) {
                            continue;
                        } else {
                            if (!xmlPullParser.isEmptyElementTag()) {
                                b(xmlPullParser, attributeSet, transition2);
                            }
                            if (transitionSet != null) {
                                break;
                            } else if (transition != null) {
                                throw new InflateException("Could not add transition to another transition.");
                            }
                        }
                    }
                }
            }
            transitionSet.g(transition2);
        }
        return transition2;
    }

    @SuppressLint({"RestrictedApi"})
    public final void d(XmlPullParser xmlPullParser, AttributeSet attributeSet, Transition transition) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                if (xmlPullParser.getName().equals("target")) {
                    TypedArray obtainStyledAttributes = this.f16675a.obtainStyledAttributes(attributeSet, l.f16662a);
                    int h11 = i.h(obtainStyledAttributes, xmlPullParser, "targetId", 1, 0);
                    if (h11 != 0) {
                        transition.addTarget(h11);
                    } else {
                        int h12 = i.h(obtainStyledAttributes, xmlPullParser, "excludeId", 2, 0);
                        if (h12 != 0) {
                            transition.excludeTarget(h12, true);
                        } else {
                            String i11 = i.i(obtainStyledAttributes, xmlPullParser, "targetName", 4);
                            if (i11 != null) {
                                transition.addTarget(i11);
                            } else {
                                String i12 = i.i(obtainStyledAttributes, xmlPullParser, "excludeName", 5);
                                if (i12 != null) {
                                    transition.excludeTarget(i12, true);
                                } else {
                                    String i13 = i.i(obtainStyledAttributes, xmlPullParser, "excludeClass", 3);
                                    if (i13 != null) {
                                        try {
                                            transition.excludeTarget(Class.forName(i13), true);
                                        } catch (ClassNotFoundException e11) {
                                            obtainStyledAttributes.recycle();
                                            throw new RuntimeException("Could not create " + i13, e11);
                                        }
                                    } else {
                                        String i14 = i.i(obtainStyledAttributes, xmlPullParser, "targetClass", 0);
                                        if (i14 != null) {
                                            transition.addTarget(Class.forName(i14));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    obtainStyledAttributes.recycle();
                } else {
                    throw new RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                }
            }
        }
    }

    public Transition e(int i11) {
        XmlResourceParser xml = this.f16675a.getResources().getXml(i11);
        try {
            Transition b11 = b(xml, Xml.asAttributeSet(xml), (Transition) null);
            xml.close();
            return b11;
        } catch (XmlPullParserException e11) {
            throw new InflateException(e11.getMessage(), e11);
        } catch (IOException e12) {
            throw new InflateException(xml.getPositionDescription() + l.f34627b + e12.getMessage(), e12);
        } catch (Throwable th2) {
            xml.close();
            throw th2;
        }
    }
}
