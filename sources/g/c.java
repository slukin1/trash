package g;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.r;
import androidx.core.view.m;
import com.tencent.imsdk.v2.V2TIMConversation;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class c extends MenuInflater {

    /* renamed from: e  reason: collision with root package name */
    public static final Class<?>[] f15747e;

    /* renamed from: f  reason: collision with root package name */
    public static final Class<?>[] f15748f;

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f15749a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f15750b;

    /* renamed from: c  reason: collision with root package name */
    public Context f15751c;

    /* renamed from: d  reason: collision with root package name */
    public Object f15752d;

    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c  reason: collision with root package name */
        public static final Class<?>[] f15753c = {MenuItem.class};

        /* renamed from: a  reason: collision with root package name */
        public Object f15754a;

        /* renamed from: b  reason: collision with root package name */
        public Method f15755b;

        public a(Object obj, String str) {
            this.f15754a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f15755b = cls.getMethod(str, f15753c);
            } catch (Exception e11) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e11);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f15755b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f15755b.invoke(this.f15754a, new Object[]{menuItem})).booleanValue();
                }
                this.f15755b.invoke(this.f15754a, new Object[]{menuItem});
                return true;
            } catch (Exception e11) {
                throw new RuntimeException(e11);
            }
        }
    }

    public class b {
        public androidx.core.view.a A;
        public CharSequence B;
        public CharSequence C;
        public ColorStateList D = null;
        public PorterDuff.Mode E = null;

        /* renamed from: a  reason: collision with root package name */
        public Menu f15756a;

        /* renamed from: b  reason: collision with root package name */
        public int f15757b;

        /* renamed from: c  reason: collision with root package name */
        public int f15758c;

        /* renamed from: d  reason: collision with root package name */
        public int f15759d;

        /* renamed from: e  reason: collision with root package name */
        public int f15760e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f15761f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f15762g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f15763h;

        /* renamed from: i  reason: collision with root package name */
        public int f15764i;

        /* renamed from: j  reason: collision with root package name */
        public int f15765j;

        /* renamed from: k  reason: collision with root package name */
        public CharSequence f15766k;

        /* renamed from: l  reason: collision with root package name */
        public CharSequence f15767l;

        /* renamed from: m  reason: collision with root package name */
        public int f15768m;

        /* renamed from: n  reason: collision with root package name */
        public char f15769n;

        /* renamed from: o  reason: collision with root package name */
        public int f15770o;

        /* renamed from: p  reason: collision with root package name */
        public char f15771p;

        /* renamed from: q  reason: collision with root package name */
        public int f15772q;

        /* renamed from: r  reason: collision with root package name */
        public int f15773r;

        /* renamed from: s  reason: collision with root package name */
        public boolean f15774s;

        /* renamed from: t  reason: collision with root package name */
        public boolean f15775t;

        /* renamed from: u  reason: collision with root package name */
        public boolean f15776u;

        /* renamed from: v  reason: collision with root package name */
        public int f15777v;

        /* renamed from: w  reason: collision with root package name */
        public int f15778w;

        /* renamed from: x  reason: collision with root package name */
        public String f15779x;

        /* renamed from: y  reason: collision with root package name */
        public String f15780y;

        /* renamed from: z  reason: collision with root package name */
        public String f15781z;

        public b(Menu menu) {
            this.f15756a = menu;
            h();
        }

        public void a() {
            this.f15763h = true;
            i(this.f15756a.add(this.f15757b, this.f15764i, this.f15765j, this.f15766k));
        }

        public SubMenu b() {
            this.f15763h = true;
            SubMenu addSubMenu = this.f15756a.addSubMenu(this.f15757b, this.f15764i, this.f15765j, this.f15766k);
            i(addSubMenu.getItem());
            return addSubMenu;
        }

        public final char c(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        public boolean d() {
            return this.f15763h;
        }

        public final <T> T e(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, c.this.f15751c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e11) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e11);
                return null;
            }
        }

        public void f(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = c.this.f15751c.obtainStyledAttributes(attributeSet, R$styleable.MenuGroup);
            this.f15757b = obtainStyledAttributes.getResourceId(R$styleable.MenuGroup_android_id, 0);
            this.f15758c = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_menuCategory, 0);
            this.f15759d = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_orderInCategory, 0);
            this.f15760e = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_checkableBehavior, 0);
            this.f15761f = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_visible, true);
            this.f15762g = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            d0 u11 = d0.u(c.this.f15751c, attributeSet, R$styleable.MenuItem);
            this.f15764i = u11.n(R$styleable.MenuItem_android_id, 0);
            this.f15765j = (u11.k(R$styleable.MenuItem_android_menuCategory, this.f15758c) & -65536) | (u11.k(R$styleable.MenuItem_android_orderInCategory, this.f15759d) & 65535);
            this.f15766k = u11.p(R$styleable.MenuItem_android_title);
            this.f15767l = u11.p(R$styleable.MenuItem_android_titleCondensed);
            this.f15768m = u11.n(R$styleable.MenuItem_android_icon, 0);
            this.f15769n = c(u11.o(R$styleable.MenuItem_android_alphabeticShortcut));
            this.f15770o = u11.k(R$styleable.MenuItem_alphabeticModifiers, 4096);
            this.f15771p = c(u11.o(R$styleable.MenuItem_android_numericShortcut));
            this.f15772q = u11.k(R$styleable.MenuItem_numericModifiers, 4096);
            int i11 = R$styleable.MenuItem_android_checkable;
            if (u11.s(i11)) {
                this.f15773r = u11.a(i11, false) ? 1 : 0;
            } else {
                this.f15773r = this.f15760e;
            }
            this.f15774s = u11.a(R$styleable.MenuItem_android_checked, false);
            this.f15775t = u11.a(R$styleable.MenuItem_android_visible, this.f15761f);
            this.f15776u = u11.a(R$styleable.MenuItem_android_enabled, this.f15762g);
            this.f15777v = u11.k(R$styleable.MenuItem_showAsAction, -1);
            this.f15781z = u11.o(R$styleable.MenuItem_android_onClick);
            this.f15778w = u11.n(R$styleable.MenuItem_actionLayout, 0);
            this.f15779x = u11.o(R$styleable.MenuItem_actionViewClass);
            String o11 = u11.o(R$styleable.MenuItem_actionProviderClass);
            this.f15780y = o11;
            boolean z11 = o11 != null;
            if (z11 && this.f15778w == 0 && this.f15779x == null) {
                this.A = (androidx.core.view.a) e(o11, c.f15748f, c.this.f15750b);
            } else {
                if (z11) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = u11.p(R$styleable.MenuItem_contentDescription);
            this.C = u11.p(R$styleable.MenuItem_tooltipText);
            int i12 = R$styleable.MenuItem_iconTintMode;
            if (u11.s(i12)) {
                this.E = r.e(u11.k(i12, -1), this.E);
            } else {
                this.E = null;
            }
            int i13 = R$styleable.MenuItem_iconTint;
            if (u11.s(i13)) {
                this.D = u11.c(i13);
            } else {
                this.D = null;
            }
            u11.w();
            this.f15763h = false;
        }

        public void h() {
            this.f15757b = 0;
            this.f15758c = 0;
            this.f15759d = 0;
            this.f15760e = 0;
            this.f15761f = true;
            this.f15762g = true;
        }

        public final void i(MenuItem menuItem) {
            boolean z11 = false;
            menuItem.setChecked(this.f15774s).setVisible(this.f15775t).setEnabled(this.f15776u).setCheckable(this.f15773r >= 1).setTitleCondensed(this.f15767l).setIcon(this.f15768m);
            int i11 = this.f15777v;
            if (i11 >= 0) {
                menuItem.setShowAsAction(i11);
            }
            if (this.f15781z != null) {
                if (!c.this.f15751c.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new a(c.this.b(), this.f15781z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.f15773r >= 2) {
                if (menuItem instanceof g) {
                    ((g) menuItem).t(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).h(true);
                }
            }
            String str = this.f15779x;
            if (str != null) {
                menuItem.setActionView((View) e(str, c.f15747e, c.this.f15749a));
                z11 = true;
            }
            int i12 = this.f15778w;
            if (i12 > 0) {
                if (!z11) {
                    menuItem.setActionView(i12);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            androidx.core.view.a aVar = this.A;
            if (aVar != null) {
                m.a(menuItem, aVar);
            }
            m.c(menuItem, this.B);
            m.g(menuItem, this.C);
            m.b(menuItem, this.f15769n, this.f15770o);
            m.f(menuItem, this.f15771p, this.f15772q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                m.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                m.d(menuItem, colorStateList);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r0[r1] = r2
            f15747e = r0
            f15748f = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g.c.<clinit>():void");
    }

    public c(Context context) {
        super(context);
        this.f15751c = context;
        Object[] objArr = {context};
        this.f15749a = objArr;
        this.f15750b = objArr;
    }

    public final Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public Object b() {
        if (this.f15752d == null) {
            this.f15752d = a(this.f15751c);
        }
        return this.f15752d;
    }

    public final void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            }
        }
        String str = null;
        boolean z11 = false;
        boolean z12 = false;
        while (!z11) {
            if (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z12 && name2.equals(str)) {
                            str = null;
                            z12 = false;
                        } else if (name2.equals(V2TIMConversation.CONVERSATION_GROUP_TYPE)) {
                            bVar.h();
                        } else if (name2.equals("item")) {
                            if (!bVar.d()) {
                                androidx.core.view.a aVar = bVar.A;
                                if (aVar == null || !aVar.a()) {
                                    bVar.a();
                                } else {
                                    bVar.b();
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z11 = true;
                        }
                    }
                } else if (!z12) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals(V2TIMConversation.CONVERSATION_GROUP_TYPE)) {
                        bVar.f(attributeSet);
                    } else if (name3.equals("item")) {
                        bVar.g(attributeSet);
                    } else if (name3.equals("menu")) {
                        c(xmlPullParser, attributeSet, bVar.b());
                    } else {
                        str = name3;
                        z12 = true;
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    public void inflate(int i11, Menu menu) {
        if (!(menu instanceof v0.a)) {
            super.inflate(i11, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.f15751c.getResources().getLayout(i11);
            c(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        } catch (XmlPullParserException e11) {
            throw new InflateException("Error inflating menu XML", e11);
        } catch (IOException e12) {
            throw new InflateException("Error inflating menu XML", e12);
        } catch (Throwable th2) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th2;
        }
    }
}
