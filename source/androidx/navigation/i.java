package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavOptions;
import androidx.navigation.common.R$styleable;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import org.xmlpull.v1.XmlPullParserException;

public final class i {

    /* renamed from: c  reason: collision with root package name */
    public static final a f10433c = new a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f10434d = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    public final Context f10435a;

    /* renamed from: b  reason: collision with root package name */
    public final NavigatorProvider f10436b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final k<?> a(TypedValue typedValue, k<?> kVar, k<?> kVar2, String str, String str2) throws XmlPullParserException {
            if (kVar == null || kVar == kVar2) {
                return kVar == null ? kVar2 : kVar;
            }
            throw new XmlPullParserException("Type is " + str + " but found " + str2 + l.f34627b + typedValue.data);
        }
    }

    public i(Context context, NavigatorProvider navigatorProvider) {
        this.f10435a = context;
        this.f10436b = navigatorProvider;
    }

    public final NavDestination a(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int i11) throws XmlPullParserException, IOException {
        int depth;
        NavDestination a11 = this.f10436b.d(xmlResourceParser.getName()).a();
        a11.u(this.f10435a, attributeSet);
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                return a11;
            }
            if (next == 2 && depth <= depth2) {
                String name = xmlResourceParser.getName();
                if (x.b("argument", name)) {
                    f(resources, a11, attributeSet, i11);
                } else if (x.b("deepLink", name)) {
                    g(resources, a11, attributeSet);
                } else if (x.b("action", name)) {
                    c(resources, a11, attributeSet, xmlResourceParser, i11);
                } else if (x.b("include", name) && (a11 instanceof NavGraph)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R$styleable.NavInclude);
                    ((NavGraph) a11).A(b(obtainAttributes.getResourceId(R$styleable.NavInclude_graph, 0)));
                    Unit unit = Unit.f56620a;
                    obtainAttributes.recycle();
                } else if (a11 instanceof NavGraph) {
                    ((NavGraph) a11).A(a(resources, xmlResourceParser, attributeSet, i11));
                }
            }
        }
        return a11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c A[Catch:{ Exception -> 0x0056, all -> 0x0054 }] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x001a A[Catch:{ Exception -> 0x0056, all -> 0x0054 }] */
    @android.annotation.SuppressLint({"ResourceType"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.navigation.NavGraph b(int r7) {
        /*
            r6 = this;
            android.content.Context r0 = r6.f10435a
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.XmlResourceParser r1 = r0.getXml(r7)
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r1)
        L_0x000e:
            int r3 = r1.next()     // Catch:{ Exception -> 0x0056 }
            r4 = 2
            if (r3 == r4) goto L_0x0018
            r5 = 1
            if (r3 != r5) goto L_0x000e
        L_0x0018:
            if (r3 != r4) goto L_0x004c
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x0056 }
            androidx.navigation.NavDestination r2 = r6.a(r0, r1, r2, r7)     // Catch:{ Exception -> 0x0056 }
            boolean r4 = r2 instanceof androidx.navigation.NavGraph     // Catch:{ Exception -> 0x0056 }
            if (r4 == 0) goto L_0x002c
            androidx.navigation.NavGraph r2 = (androidx.navigation.NavGraph) r2     // Catch:{ Exception -> 0x0056 }
            r1.close()
            return r2
        L_0x002c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0056 }
            r2.<init>()     // Catch:{ Exception -> 0x0056 }
            java.lang.String r4 = "Root element <"
            r2.append(r4)     // Catch:{ Exception -> 0x0056 }
            r2.append(r3)     // Catch:{ Exception -> 0x0056 }
            java.lang.String r3 = "> did not inflate into a NavGraph"
            r2.append(r3)     // Catch:{ Exception -> 0x0056 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0056 }
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0056 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0056 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0056 }
            throw r3     // Catch:{ Exception -> 0x0056 }
        L_0x004c:
            org.xmlpull.v1.XmlPullParserException r2 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x0056 }
            java.lang.String r3 = "No start tag found"
            r2.<init>(r3)     // Catch:{ Exception -> 0x0056 }
            throw r2     // Catch:{ Exception -> 0x0056 }
        L_0x0054:
            r7 = move-exception
            goto L_0x007e
        L_0x0056:
            r2 = move-exception
            java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch:{ all -> 0x0054 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0054 }
            r4.<init>()     // Catch:{ all -> 0x0054 }
            java.lang.String r5 = "Exception inflating "
            r4.append(r5)     // Catch:{ all -> 0x0054 }
            java.lang.String r7 = r0.getResourceName(r7)     // Catch:{ all -> 0x0054 }
            r4.append(r7)     // Catch:{ all -> 0x0054 }
            java.lang.String r7 = " line "
            r4.append(r7)     // Catch:{ all -> 0x0054 }
            int r7 = r1.getLineNumber()     // Catch:{ all -> 0x0054 }
            r4.append(r7)     // Catch:{ all -> 0x0054 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0054 }
            r3.<init>(r7, r2)     // Catch:{ all -> 0x0054 }
            throw r3     // Catch:{ all -> 0x0054 }
        L_0x007e:
            r1.close()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.i.b(int):androidx.navigation.NavGraph");
    }

    public final void c(Resources resources, NavDestination navDestination, AttributeSet attributeSet, XmlResourceParser xmlResourceParser, int i11) throws IOException, XmlPullParserException {
        int depth;
        TypedArray obtainStyledAttributes = this.f10435a.obtainStyledAttributes(attributeSet, R$styleable.NavAction, 0, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.NavAction_android_id, 0);
        b bVar = new b(obtainStyledAttributes.getResourceId(R$styleable.NavAction_destination, 0), (NavOptions) null, (Bundle) null, 6, (r) null);
        NavOptions.Builder builder = new NavOptions.Builder();
        builder.d(obtainStyledAttributes.getBoolean(R$styleable.NavAction_launchSingleTop, false));
        builder.j(obtainStyledAttributes.getBoolean(R$styleable.NavAction_restoreState, false));
        builder.g(obtainStyledAttributes.getResourceId(R$styleable.NavAction_popUpTo, -1), obtainStyledAttributes.getBoolean(R$styleable.NavAction_popUpToInclusive, false), obtainStyledAttributes.getBoolean(R$styleable.NavAction_popUpToSaveState, false));
        builder.b(obtainStyledAttributes.getResourceId(R$styleable.NavAction_enterAnim, -1));
        builder.c(obtainStyledAttributes.getResourceId(R$styleable.NavAction_exitAnim, -1));
        builder.e(obtainStyledAttributes.getResourceId(R$styleable.NavAction_popEnterAnim, -1));
        builder.f(obtainStyledAttributes.getResourceId(R$styleable.NavAction_popExitAnim, -1));
        bVar.e(builder.a());
        Bundle bundle = new Bundle();
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next != 1 && ((depth = xmlResourceParser.getDepth()) >= depth2 || next != 3)) {
                if (next == 2 && depth <= depth2 && x.b("argument", xmlResourceParser.getName())) {
                    e(resources, bundle, attributeSet, i11);
                }
            }
        }
        if (!bundle.isEmpty()) {
            bVar.d(bundle);
        }
        navDestination.v(resourceId, bVar);
        obtainStyledAttributes.recycle();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: androidx.navigation.k<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: androidx.navigation.k<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: androidx.navigation.k<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: androidx.navigation.k<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: androidx.navigation.k<java.lang.Float>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: androidx.navigation.k<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: androidx.navigation.k<java.lang.Integer>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: androidx.navigation.k<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: androidx.navigation.k<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: androidx.navigation.k<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: androidx.navigation.k<java.lang.Float>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: androidx.navigation.k<java.lang.Integer>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: androidx.navigation.k<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: androidx.navigation.k<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: androidx.navigation.k<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: androidx.navigation.k<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: androidx.navigation.k<?>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.navigation.NavArgument d(android.content.res.TypedArray r11, android.content.res.Resources r12, int r13) throws org.xmlpull.v1.XmlPullParserException {
        /*
            r10 = this;
            androidx.navigation.NavArgument$Builder r0 = new androidx.navigation.NavArgument$Builder
            r0.<init>()
            int r1 = androidx.navigation.common.R$styleable.NavArgument_nullable
            r2 = 0
            boolean r1 = r11.getBoolean(r1, r2)
            r0.c(r1)
            java.lang.ThreadLocal<android.util.TypedValue> r1 = f10434d
            java.lang.Object r3 = r1.get()
            android.util.TypedValue r3 = (android.util.TypedValue) r3
            if (r3 != 0) goto L_0x0021
            android.util.TypedValue r3 = new android.util.TypedValue
            r3.<init>()
            r1.set(r3)
        L_0x0021:
            int r1 = androidx.navigation.common.R$styleable.NavArgument_argType
            java.lang.String r8 = r11.getString(r1)
            r1 = 0
            if (r8 == 0) goto L_0x0036
            androidx.navigation.k$l r4 = androidx.navigation.k.f10437c
            java.lang.String r13 = r12.getResourcePackageName(r13)
            androidx.navigation.k r13 = r4.a(r8, r13)
            r6 = r13
            goto L_0x0037
        L_0x0036:
            r6 = r1
        L_0x0037:
            int r13 = androidx.navigation.common.R$styleable.NavArgument_android_defaultValue
            boolean r4 = r11.getValue(r13, r3)
            if (r4 == 0) goto L_0x0179
            androidx.navigation.k<java.lang.Integer> r1 = androidx.navigation.k.f10439e
            java.lang.String r4 = "' for "
            java.lang.String r5 = "unsupported value '"
            r7 = 16
            if (r6 != r1) goto L_0x0083
            int r11 = r3.resourceId
            if (r11 == 0) goto L_0x004f
            r2 = r11
            goto L_0x0057
        L_0x004f:
            int r11 = r3.type
            if (r11 != r7) goto L_0x005d
            int r11 = r3.data
            if (r11 != 0) goto L_0x005d
        L_0x0057:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            goto L_0x0179
        L_0x005d:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r5)
            java.lang.CharSequence r13 = r3.string
            r12.append(r13)
            r12.append(r4)
            java.lang.String r13 = r6.b()
            r12.append(r13)
            java.lang.String r13 = ". Must be a reference to a resource."
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x0083:
            int r9 = r3.resourceId
            if (r9 == 0) goto L_0x00c3
            if (r6 != 0) goto L_0x0091
            java.lang.Integer r11 = java.lang.Integer.valueOf(r9)
            r6 = r1
            r1 = r11
            goto L_0x0179
        L_0x0091:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r5)
            java.lang.CharSequence r13 = r3.string
            r12.append(r13)
            r12.append(r4)
            java.lang.String r13 = r6.b()
            r12.append(r13)
            java.lang.String r13 = ". You must use a \""
            r12.append(r13)
            java.lang.String r13 = r1.b()
            r12.append(r13)
            java.lang.String r13 = "\" type to reference other resources."
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x00c3:
            androidx.navigation.k<java.lang.String> r1 = androidx.navigation.k.f10447m
            if (r6 != r1) goto L_0x00cd
            java.lang.String r1 = r11.getString(r13)
            goto L_0x0179
        L_0x00cd:
            int r11 = r3.type
            r13 = 3
            if (r11 == r13) goto L_0x0166
            r13 = 4
            if (r11 == r13) goto L_0x0152
            r13 = 5
            if (r11 == r13) goto L_0x0139
            r12 = 18
            if (r11 == r12) goto L_0x0124
            if (r11 < r7) goto L_0x010b
            r12 = 31
            if (r11 > r12) goto L_0x010b
            androidx.navigation.k<java.lang.Float> r7 = androidx.navigation.k.f10443i
            if (r6 != r7) goto L_0x00f8
            androidx.navigation.i$a r4 = f10433c
            java.lang.String r9 = "float"
            r5 = r3
            androidx.navigation.k r6 = r4.a(r5, r6, r7, r8, r9)
            int r11 = r3.data
            float r11 = (float) r11
            java.lang.Float r1 = java.lang.Float.valueOf(r11)
            goto L_0x0179
        L_0x00f8:
            androidx.navigation.i$a r4 = f10433c
            androidx.navigation.k<java.lang.Integer> r7 = androidx.navigation.k.f10438d
            java.lang.String r9 = "integer"
            r5 = r3
            androidx.navigation.k r6 = r4.a(r5, r6, r7, r8, r9)
            int r11 = r3.data
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            goto L_0x0179
        L_0x010b:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "unsupported argument type "
            r12.append(r13)
            int r13 = r3.type
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x0124:
            androidx.navigation.i$a r4 = f10433c
            androidx.navigation.k<java.lang.Boolean> r7 = androidx.navigation.k.f10445k
            java.lang.String r9 = "boolean"
            r5 = r3
            androidx.navigation.k r6 = r4.a(r5, r6, r7, r8, r9)
            int r11 = r3.data
            if (r11 == 0) goto L_0x0134
            r2 = 1
        L_0x0134:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r2)
            goto L_0x0179
        L_0x0139:
            androidx.navigation.i$a r4 = f10433c
            androidx.navigation.k<java.lang.Integer> r7 = androidx.navigation.k.f10438d
            java.lang.String r9 = "dimension"
            r5 = r3
            androidx.navigation.k r6 = r4.a(r5, r6, r7, r8, r9)
            android.util.DisplayMetrics r11 = r12.getDisplayMetrics()
            float r11 = r3.getDimension(r11)
            int r11 = (int) r11
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            goto L_0x0179
        L_0x0152:
            androidx.navigation.i$a r4 = f10433c
            androidx.navigation.k<java.lang.Float> r7 = androidx.navigation.k.f10443i
            java.lang.String r9 = "float"
            r5 = r3
            androidx.navigation.k r6 = r4.a(r5, r6, r7, r8, r9)
            float r11 = r3.getFloat()
            java.lang.Float r1 = java.lang.Float.valueOf(r11)
            goto L_0x0179
        L_0x0166:
            java.lang.CharSequence r11 = r3.string
            java.lang.String r11 = r11.toString()
            if (r6 != 0) goto L_0x0175
            androidx.navigation.k$l r12 = androidx.navigation.k.f10437c
            androidx.navigation.k r12 = r12.b(r11)
            r6 = r12
        L_0x0175:
            java.lang.Object r1 = r6.f(r11)
        L_0x0179:
            if (r1 == 0) goto L_0x017e
            r0.b(r1)
        L_0x017e:
            if (r6 == 0) goto L_0x0183
            r0.d(r6)
        L_0x0183:
            androidx.navigation.NavArgument r11 = r0.a()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.i.d(android.content.res.TypedArray, android.content.res.Resources, int):androidx.navigation.NavArgument");
    }

    public final void e(Resources resources, Bundle bundle, AttributeSet attributeSet, int i11) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R$styleable.NavArgument);
        String string = obtainAttributes.getString(R$styleable.NavArgument_android_name);
        if (string != null) {
            NavArgument d11 = d(obtainAttributes, resources, i11);
            if (d11.b()) {
                d11.d(string, bundle);
            }
            Unit unit = Unit.f56620a;
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Arguments must have a name");
    }

    public final void f(Resources resources, NavDestination navDestination, AttributeSet attributeSet, int i11) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R$styleable.NavArgument);
        String string = obtainAttributes.getString(R$styleable.NavArgument_android_name);
        if (string != null) {
            navDestination.a(string, d(obtainAttributes, resources, i11));
            Unit unit = Unit.f56620a;
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Arguments must have a name");
    }

    public final void g(Resources resources, NavDestination navDestination, AttributeSet attributeSet) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R$styleable.NavDeepLink);
        String string = obtainAttributes.getString(R$styleable.NavDeepLink_uri);
        String string2 = obtainAttributes.getString(R$styleable.NavDeepLink_action);
        String string3 = obtainAttributes.getString(R$styleable.NavDeepLink_mimeType);
        boolean z11 = false;
        if (string == null || string.length() == 0) {
            if (string2 == null || string2.length() == 0) {
                if (string3 == null || string3.length() == 0) {
                    throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
                }
            }
        }
        NavDeepLink.Builder builder = new NavDeepLink.Builder();
        if (string != null) {
            builder.d(StringsKt__StringsJVMKt.G(string, "${applicationId}", this.f10435a.getPackageName(), false, 4, (Object) null));
        }
        if (string2 == null || string2.length() == 0) {
            z11 = true;
        }
        if (!z11) {
            builder.b(StringsKt__StringsJVMKt.G(string2, "${applicationId}", this.f10435a.getPackageName(), false, 4, (Object) null));
        }
        if (string3 != null) {
            builder.c(StringsKt__StringsJVMKt.G(string3, "${applicationId}", this.f10435a.getPackageName(), false, 4, (Object) null));
        }
        navDestination.b(builder.a());
        Unit unit = Unit.f56620a;
        obtainAttributes.recycle();
    }
}
