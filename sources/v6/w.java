package v6;

import android.app.Activity;
import android.text.TextUtils;
import android.view.MenuItem;
import com.hbg.lib.core.GlobalAppConfig;
import com.hbg.lib.core.webview.HBWebView;
import com.hbg.lib.core.webview.annotation.ActionAnnotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import l6.a;
import x6.h;

public class w {

    /* renamed from: b  reason: collision with root package name */
    public static List<Class> f69070b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static w f69071c;

    /* renamed from: d  reason: collision with root package name */
    public static HashMap<String, Method> f69072d = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public h f69073a;

    public static w e() {
        if (f69071c == null) {
            synchronized (w.class) {
                if (f69071c == null) {
                    f69071c = new w();
                }
            }
        }
        return f69071c;
    }

    public void a(Class cls) {
        if (!f69070b.contains(cls)) {
            f69070b.add(cls);
        }
    }

    public void b() {
        boolean z11;
        if (f69072d.size() <= 0) {
            for (Class next : f69070b) {
                for (Method method : next.getMethods()) {
                    ActionAnnotation actionAnnotation = (ActionAnnotation) method.getAnnotation(ActionAnnotation.class);
                    if (actionAnnotation != null) {
                        boolean z12 = true;
                        if (TextUtils.isEmpty(actionAnnotation.value()) || f69072d.containsKey(actionAnnotation.value())) {
                            z11 = false;
                        } else {
                            f69072d.put(actionAnnotation.value(), method);
                            z11 = true;
                        }
                        if (TextUtils.isEmpty(actionAnnotation.actionName()) || f69072d.containsKey(actionAnnotation.actionName())) {
                            z12 = z11;
                        } else {
                            f69072d.put(actionAnnotation.actionName(), method);
                        }
                        if (!z12 && GlobalAppConfig.e()) {
                            new Exception(next + "类的action:" + actionAnnotation.value() + "重复注册，请排查" + actionAnnotation.actionName()).printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public boolean c(Activity activity, String str, String str2) {
        h hVar = this.f69073a;
        if (hVar != null) {
            return hVar.h(activity, str, str2);
        }
        return false;
    }

    public Method d(String str) {
        return f69072d.get(str);
    }

    public String f(String str) {
        h hVar = this.f69073a;
        return hVar != null ? hVar.d(str) : "";
    }

    public void g(Activity activity, String str) {
        try {
            h hVar = this.f69073a;
            if (hVar != null) {
                hVar.c(activity, str);
            }
        } catch (Exception e11) {
            a.a().b(e11, activity, str);
        }
    }

    public void h(Activity activity, String str) {
        try {
            h hVar = this.f69073a;
            if (hVar != null) {
                hVar.b(activity, str);
            }
        } catch (Exception e11) {
            a.a().b(e11, activity, str);
        }
    }

    public void i(String str, String str2, long j11, int i11, String str3) {
        h hVar = this.f69073a;
        if (hVar != null) {
            hVar.g(str, str2, j11, i11, str3);
        }
    }

    public void j(String str) {
        h hVar = this.f69073a;
        if (hVar != null) {
            hVar.a(str);
        }
    }

    public void k(h hVar) {
        this.f69073a = hVar;
    }

    public void l(Activity activity, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        h hVar = this.f69073a;
        if (hVar != null) {
            hVar.f(activity, onMenuItemClickListener);
        }
    }

    public void m(HBWebView hBWebView, String str) {
        h hVar = this.f69073a;
        if (hVar != null) {
            hVar.e(hBWebView, str);
        }
    }
}
