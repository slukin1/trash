package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.motion.widget.Debug;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class ConstraintAttribute {

    /* renamed from: a  reason: collision with root package name */
    public boolean f7910a = false;

    /* renamed from: b  reason: collision with root package name */
    public String f7911b;

    /* renamed from: c  reason: collision with root package name */
    public AttributeType f7912c;

    /* renamed from: d  reason: collision with root package name */
    public int f7913d;

    /* renamed from: e  reason: collision with root package name */
    public float f7914e;

    /* renamed from: f  reason: collision with root package name */
    public String f7915f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7916g;

    /* renamed from: h  reason: collision with root package name */
    public int f7917h;

    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f7918a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType[] r0 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7918a = r0
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.REFERENCE_TYPE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7918a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.BOOLEAN_TYPE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7918a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.STRING_TYPE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7918a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.COLOR_TYPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7918a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.COLOR_DRAWABLE_TYPE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7918a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.INT_TYPE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7918a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.FLOAT_TYPE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f7918a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.DIMENSION_TYPE     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintAttribute.a.<clinit>():void");
        }
    }

    public ConstraintAttribute(String str, AttributeType attributeType, Object obj, boolean z11) {
        this.f7911b = str;
        this.f7912c = attributeType;
        this.f7910a = z11;
        l(obj);
    }

    public static int b(int i11) {
        int i12 = (i11 & (~(i11 >> 31))) - 255;
        return (i12 & (i12 >> 31)) + 255;
    }

    public static HashMap<String, ConstraintAttribute> c(HashMap<String, ConstraintAttribute> hashMap, View view) {
        HashMap<String, ConstraintAttribute> hashMap2 = new HashMap<>();
        Class<?> cls = view.getClass();
        for (String next : hashMap.keySet()) {
            ConstraintAttribute constraintAttribute = hashMap.get(next);
            try {
                if (next.equals("BackgroundColor")) {
                    hashMap2.put(next, new ConstraintAttribute(constraintAttribute, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    hashMap2.put(next, new ConstraintAttribute(constraintAttribute, cls.getMethod("getMap" + next, new Class[0]).invoke(view, new Object[0])));
                }
            } catch (NoSuchMethodException e11) {
                e11.printStackTrace();
            } catch (IllegalAccessException e12) {
                e12.printStackTrace();
            } catch (InvocationTargetException e13) {
                e13.printStackTrace();
            }
        }
        return hashMap2;
    }

    public static void i(Context context, XmlPullParser xmlPullParser, HashMap<String, ConstraintAttribute> hashMap) {
        AttributeType attributeType;
        Object valueOf;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        AttributeType attributeType2 = null;
        boolean z11 = false;
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = obtainStyledAttributes.getIndex(i11);
            if (index == R$styleable.CustomAttribute_attributeName) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == R$styleable.CustomAttribute_methodName) {
                str = obtainStyledAttributes.getString(index);
                z11 = true;
            } else if (index == R$styleable.CustomAttribute_customBoolean) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                attributeType2 = AttributeType.BOOLEAN_TYPE;
            } else {
                if (index == R$styleable.CustomAttribute_customColorValue) {
                    attributeType = AttributeType.COLOR_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R$styleable.CustomAttribute_customColorDrawableValue) {
                    attributeType = AttributeType.COLOR_DRAWABLE_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R$styleable.CustomAttribute_customPixelDimension) {
                    attributeType = AttributeType.DIMENSION_TYPE;
                    valueOf = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == R$styleable.CustomAttribute_customDimension) {
                    attributeType = AttributeType.DIMENSION_TYPE;
                    valueOf = Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R$styleable.CustomAttribute_customFloatValue) {
                    attributeType = AttributeType.FLOAT_TYPE;
                    valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == R$styleable.CustomAttribute_customIntegerValue) {
                    attributeType = AttributeType.INT_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                } else if (index == R$styleable.CustomAttribute_customStringValue) {
                    attributeType = AttributeType.STRING_TYPE;
                    valueOf = obtainStyledAttributes.getString(index);
                } else if (index == R$styleable.CustomAttribute_customReference) {
                    attributeType = AttributeType.REFERENCE_TYPE;
                    int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                    if (resourceId == -1) {
                        resourceId = obtainStyledAttributes.getInt(index, -1);
                    }
                    valueOf = Integer.valueOf(resourceId);
                }
                Object obj2 = valueOf;
                attributeType2 = attributeType;
                obj = obj2;
            }
        }
        if (!(str == null || obj == null)) {
            hashMap.put(str, new ConstraintAttribute(str, attributeType2, obj, z11));
        }
        obtainStyledAttributes.recycle();
    }

    public static void j(View view, HashMap<String, ConstraintAttribute> hashMap) {
        String str;
        Class<?> cls = view.getClass();
        for (String next : hashMap.keySet()) {
            ConstraintAttribute constraintAttribute = hashMap.get(next);
            if (!constraintAttribute.f7910a) {
                str = "set" + next;
            } else {
                str = next;
            }
            try {
                switch (a.f7918a[constraintAttribute.f7912c.ordinal()]) {
                    case 1:
                        cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(constraintAttribute.f7913d)});
                        break;
                    case 2:
                        cls.getMethod(str, new Class[]{Boolean.TYPE}).invoke(view, new Object[]{Boolean.valueOf(constraintAttribute.f7916g)});
                        break;
                    case 3:
                        cls.getMethod(str, new Class[]{CharSequence.class}).invoke(view, new Object[]{constraintAttribute.f7915f});
                        break;
                    case 4:
                        cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(constraintAttribute.f7917h)});
                        break;
                    case 5:
                        Method method = cls.getMethod(str, new Class[]{Drawable.class});
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(constraintAttribute.f7917h);
                        method.invoke(view, new Object[]{colorDrawable});
                        break;
                    case 6:
                        cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(constraintAttribute.f7913d)});
                        break;
                    case 7:
                        cls.getMethod(str, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(constraintAttribute.f7914e)});
                        break;
                    case 8:
                        cls.getMethod(str, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(constraintAttribute.f7914e)});
                        break;
                }
            } catch (NoSuchMethodException e11) {
                Log.e("TransitionLayout", e11.getMessage());
                Log.e("TransitionLayout", " Custom Attribute \"" + next + "\" not found on " + cls.getName());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(cls.getName());
                sb2.append(" must have a method ");
                sb2.append(str);
                Log.e("TransitionLayout", sb2.toString());
            } catch (IllegalAccessException e12) {
                Log.e("TransitionLayout", " Custom Attribute \"" + next + "\" not found on " + cls.getName());
                e12.printStackTrace();
            } catch (InvocationTargetException e13) {
                Log.e("TransitionLayout", " Custom Attribute \"" + next + "\" not found on " + cls.getName());
                e13.printStackTrace();
            }
        }
    }

    public void a(View view) {
        String str;
        Class<?> cls = view.getClass();
        String str2 = this.f7911b;
        if (!this.f7910a) {
            str = "set" + str2;
        } else {
            str = str2;
        }
        try {
            switch (a.f7918a[this.f7912c.ordinal()]) {
                case 1:
                case 6:
                    cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(this.f7913d)});
                    return;
                case 2:
                    cls.getMethod(str, new Class[]{Boolean.TYPE}).invoke(view, new Object[]{Boolean.valueOf(this.f7916g)});
                    return;
                case 3:
                    cls.getMethod(str, new Class[]{CharSequence.class}).invoke(view, new Object[]{this.f7915f});
                    return;
                case 4:
                    cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(this.f7917h)});
                    return;
                case 5:
                    Method method = cls.getMethod(str, new Class[]{Drawable.class});
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor(this.f7917h);
                    method.invoke(view, new Object[]{colorDrawable});
                    return;
                case 7:
                    cls.getMethod(str, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(this.f7914e)});
                    return;
                case 8:
                    cls.getMethod(str, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(this.f7914e)});
                    return;
                default:
                    return;
            }
        } catch (NoSuchMethodException e11) {
            Log.e("TransitionLayout", e11.getMessage());
            Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append(" must have a method ");
            sb2.append(str);
            Log.e("TransitionLayout", sb2.toString());
        } catch (IllegalAccessException e12) {
            Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
            e12.printStackTrace();
        } catch (InvocationTargetException e13) {
            Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
            e13.printStackTrace();
        }
    }

    public AttributeType d() {
        return this.f7912c;
    }

    public float e() {
        switch (a.f7918a[this.f7912c.ordinal()]) {
            case 2:
                return this.f7916g ? 1.0f : 0.0f;
            case 3:
                throw new RuntimeException("Cannot interpolate String");
            case 4:
            case 5:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 6:
                return (float) this.f7913d;
            case 7:
                return this.f7914e;
            case 8:
                return this.f7914e;
            default:
                return Float.NaN;
        }
    }

    public void f(float[] fArr) {
        switch (a.f7918a[this.f7912c.ordinal()]) {
            case 2:
                fArr[0] = this.f7916g ? 1.0f : 0.0f;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int i11 = this.f7917h;
                float pow = (float) Math.pow((double) (((float) ((i11 >> 16) & 255)) / 255.0f), 2.2d);
                float pow2 = (float) Math.pow((double) (((float) ((i11 >> 8) & 255)) / 255.0f), 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = (float) Math.pow((double) (((float) (i11 & 255)) / 255.0f), 2.2d);
                fArr[3] = ((float) ((i11 >> 24) & 255)) / 255.0f;
                return;
            case 6:
                fArr[0] = (float) this.f7913d;
                return;
            case 7:
                fArr[0] = this.f7914e;
                return;
            case 8:
                fArr[0] = this.f7914e;
                return;
            default:
                return;
        }
    }

    public boolean g() {
        int i11 = a.f7918a[this.f7912c.ordinal()];
        return (i11 == 1 || i11 == 2 || i11 == 3) ? false : true;
    }

    public int h() {
        int i11 = a.f7918a[this.f7912c.ordinal()];
        return (i11 == 4 || i11 == 5) ? 4 : 1;
    }

    public void k(View view, float[] fArr) {
        View view2 = view;
        Class<?> cls = view.getClass();
        String str = "set" + this.f7911b;
        try {
            switch (a.f7918a[this.f7912c.ordinal()]) {
                case 2:
                    Method method = cls.getMethod(str, new Class[]{Boolean.TYPE});
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(fArr[0] > 0.5f);
                    method.invoke(view2, objArr);
                    return;
                case 3:
                    throw new RuntimeException("unable to interpolate strings " + this.f7911b);
                case 4:
                    cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view2, new Object[]{Integer.valueOf((b((int) (((float) Math.pow((double) fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (b((int) (fArr[3] * 255.0f)) << 24) | (b((int) (((float) Math.pow((double) fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | b((int) (((float) Math.pow((double) fArr[2], 0.45454545454545453d)) * 255.0f)))});
                    return;
                case 5:
                    Method method2 = cls.getMethod(str, new Class[]{Drawable.class});
                    int b11 = b((int) (((float) Math.pow((double) fArr[0], 0.45454545454545453d)) * 255.0f));
                    int b12 = b((int) (((float) Math.pow((double) fArr[1], 0.45454545454545453d)) * 255.0f));
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor((b11 << 16) | (b((int) (fArr[3] * 255.0f)) << 24) | (b12 << 8) | b((int) (((float) Math.pow((double) fArr[2], 0.45454545454545453d)) * 255.0f)));
                    method2.invoke(view2, new Object[]{colorDrawable});
                    return;
                case 6:
                    cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view2, new Object[]{Integer.valueOf((int) fArr[0])});
                    return;
                case 7:
                    cls.getMethod(str, new Class[]{Float.TYPE}).invoke(view2, new Object[]{Float.valueOf(fArr[0])});
                    return;
                case 8:
                    cls.getMethod(str, new Class[]{Float.TYPE}).invoke(view2, new Object[]{Float.valueOf(fArr[0])});
                    return;
                default:
                    return;
            }
        } catch (NoSuchMethodException e11) {
            Log.e("TransitionLayout", "no method " + str + " on View \"" + Debug.d(view) + "\"");
            e11.printStackTrace();
        } catch (IllegalAccessException e12) {
            Log.e("TransitionLayout", "cannot access method " + str + " on View \"" + Debug.d(view) + "\"");
            e12.printStackTrace();
        } catch (InvocationTargetException e13) {
            e13.printStackTrace();
        }
    }

    public void l(Object obj) {
        switch (a.f7918a[this.f7912c.ordinal()]) {
            case 1:
            case 6:
                this.f7913d = ((Integer) obj).intValue();
                return;
            case 2:
                this.f7916g = ((Boolean) obj).booleanValue();
                return;
            case 3:
                this.f7915f = (String) obj;
                return;
            case 4:
            case 5:
                this.f7917h = ((Integer) obj).intValue();
                return;
            case 7:
                this.f7914e = ((Float) obj).floatValue();
                return;
            case 8:
                this.f7914e = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public ConstraintAttribute(ConstraintAttribute constraintAttribute, Object obj) {
        this.f7911b = constraintAttribute.f7911b;
        this.f7912c = constraintAttribute.f7912c;
        l(obj);
    }
}
