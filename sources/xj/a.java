package xj;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.huobi.edgeengine.template.widget.ContainerWidget;
import com.huobi.edgeengine.template.widget.EmptyWidget;
import com.huobi.edgeengine.template.widget.RootContainerWidget;
import com.huobi.edgeengine.template.widget.Widget;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import rj.b;
import rj.n;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f48081a;

    public a(b bVar) {
        this.f48081a = bVar;
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void a(org.xmlpull.v1.XmlPullParser r3) throws android.view.InflateException, java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
            r2 = this;
        L_0x0000:
            int r0 = r3.next()
            r1 = 2
            if (r0 == r1) goto L_0x000b
            r1 = 1
            if (r0 == r1) goto L_0x000b
            goto L_0x0000
        L_0x000b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: xj.a.a(org.xmlpull.v1.XmlPullParser):void");
    }

    public final Widget b(n nVar, XmlPullParser xmlPullParser, boolean z11) throws InstantiationException, IllegalAccessException {
        String name = xmlPullParser.getName();
        int attributeCount = xmlPullParser.getAttributeCount();
        HashMap hashMap = new HashMap();
        for (int i11 = 0; i11 < attributeCount; i11++) {
            hashMap.put(xmlPullParser.getAttributeName(i11), xmlPullParser.getAttributeValue(i11));
        }
        Class n11 = this.f48081a.n(name);
        if (n11 == null) {
            n11 = EmptyWidget.class;
        }
        Widget widget = (Widget) n11.newInstance();
        widget.T(nVar);
        widget.C(nVar.o(), hashMap);
        return widget;
    }

    public final Widget c(n nVar, XmlPullParser xmlPullParser, b bVar, boolean z11) throws XmlPullParserException, InstantiationException, IllegalAccessException, IOException {
        a(xmlPullParser);
        if (xmlPullParser.getEventType() != 2) {
            EmptyWidget emptyWidget = new EmptyWidget();
            emptyWidget.T(nVar);
            return emptyWidget;
        }
        Widget b11 = b(nVar, xmlPullParser, z11);
        b11.S(bVar);
        if (b11 instanceof ContainerWidget) {
            d(nVar, xmlPullParser, (ContainerWidget) b11, bVar, z11);
        }
        return b11;
    }

    public final void d(n nVar, XmlPullParser xmlPullParser, ContainerWidget containerWidget, b bVar, boolean z11) throws XmlPullParserException, InstantiationException, IllegalAccessException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                Widget b11 = b(nVar, xmlPullParser, z11);
                b11.S(bVar);
                if (b11 instanceof ContainerWidget) {
                    d(nVar, xmlPullParser, (ContainerWidget) b11, bVar, z11);
                }
                containerWidget.X(b11);
            }
        }
    }

    public View e(String str, InputStream inputStream, n nVar, boolean z11) {
        if (inputStream == null) {
            return new View(nVar.o());
        }
        return f(str, inputStream, nVar, z11).P(nVar.o());
    }

    public Widget f(String str, InputStream inputStream, n nVar, boolean z11) {
        if (inputStream == null) {
            EmptyWidget emptyWidget = new EmptyWidget();
            emptyWidget.T(nVar);
            return emptyWidget;
        }
        Widget widget = null;
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            newPullParser.setInput(inputStream, (String) null);
            widget = c(nVar, newPullParser, this.f48081a, z11);
        } catch (Throwable th2) {
            Log.e("EdgeEngine.TemplateEngine", th2.getMessage());
            th2.printStackTrace();
        }
        if (widget == null) {
            widget = new EmptyWidget();
            widget.T(nVar);
        }
        if (TextUtils.isEmpty(str) || b.i() == null) {
            return widget;
        }
        RootContainerWidget rootContainerWidget = new RootContainerWidget();
        rootContainerWidget.S(this.f48081a);
        rootContainerWidget.Z(widget);
        rootContainerWidget.T(nVar);
        rootContainerWidget.Y(str);
        return rootContainerWidget;
    }
}
