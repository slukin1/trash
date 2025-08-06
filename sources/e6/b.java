package e6;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import com.blankj.utilcode.util.l;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.dynamic.downloader.DyanmicConfig;
import com.hbg.lib.common.dynamic.downloader.Util;
import com.hbg.lib.common.dynamic.manager.HBDynamicBaseManager;
import i6.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class b extends HBDynamicBaseManager {

    /* renamed from: i  reason: collision with root package name */
    public final Map<String, Integer> f68120i;

    /* renamed from: j  reason: collision with root package name */
    public final Map<Integer, String> f68121j;

    /* renamed from: e6.b$b  reason: collision with other inner class name */
    public static class C0738b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f68122a = new b();
    }

    public static b v() {
        return C0738b.f68122a;
    }

    public final void A(File file) throws XmlPullParserException, IOException {
        if (file != null && file.isFile() && file.exists() && file.length() > 0) {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(new FileInputStream(file), "utf-8");
            String str = "";
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if (!TextUtils.isEmpty(name) && name.equals("color")) {
                        str = newPullParser.getAttributeValue((String) null, "name");
                    }
                } else if (eventType == 3) {
                    str = "";
                } else if (eventType == 4) {
                    String trim = newPullParser.getText().replace(10, ' ').replace(9, ' ').trim();
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(trim) && !this.f68120i.containsKey(str)) {
                        if (trim.startsWith("@color/")) {
                            String substring = trim.substring(7);
                            if (this.f68120i.containsKey(substring)) {
                                Map<String, Integer> map = this.f68120i;
                                map.put(str, map.get(substring));
                            } else {
                                Resources resources = BaseApplication.b().getResources();
                                try {
                                    if (resources instanceof k) {
                                        this.f68120i.put(str, Integer.valueOf(((k) resources).a().getColor(((k) resources).a().getIdentifier(substring, "color", BaseApplication.b().getPackageName()))));
                                    } else {
                                        this.f68120i.put(str, Integer.valueOf(resources.getColor(resources.getIdentifier(substring, "color", BaseApplication.b().getPackageName()))));
                                    }
                                } catch (Resources.NotFoundException e11) {
                                    k.g("ColorManager", "readXmlLangFile() called with: color = [" + file + "]", e11);
                                }
                            }
                        } else {
                            String text = newPullParser.getText();
                            if (!text.contains("@android") && !text.contains("transparent")) {
                                try {
                                    this.f68120i.put(str, Integer.valueOf(Color.parseColor(text)));
                                } catch (Exception e12) {
                                    if (text.charAt(0) == '#' && text.length() == 4) {
                                        this.f68120i.put(str, Integer.valueOf(Color.parseColor("#" + text.charAt(1) + text.charAt(1) + text.charAt(2) + text.charAt(2) + text.charAt(3) + text.charAt(3))));
                                    } else {
                                        k.g("ColorManager", "readXmlLangFile() called with: color = [" + text + "]", e12);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public File e(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(BaseApplication.b().getFilesDir().getPath());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("dynamic/color/");
        sb2.append(BaseApplication.e());
        sb2.append(str2);
        sb2.append(str);
        return new File(sb2.toString());
    }

    public String g() {
        return "ColorManager";
    }

    public String h() {
        return DyanmicConfig.Color.class.getName();
    }

    public void k() {
        long currentTimeMillis = System.currentTimeMillis();
        File u11 = u();
        if (u11.isDirectory() && u11.exists()) {
            List<File> l11 = l.l(u11, a.f54276b);
            if (!l11.isEmpty()) {
                for (int i11 = 0; i11 < l11.size(); i11++) {
                    File file = l11.get(i11);
                    if (Util.a()) {
                        Log.e("ColorManager", String.format("initData(%d) called file=%s", new Object[]{Integer.valueOf(i11), file.getPath()}));
                    }
                    if (file.isFile() && file.exists() && file.getName().endsWith(".xml")) {
                        try {
                            A(file);
                        } catch (Exception e11) {
                            k.h("ColorManager", "readXmlLangFile() called Exception", e11, false);
                        }
                        if (i11 == l11.size() - 1 && Util.a()) {
                            Log.d("ColorManager", "initData() called langs.size=" + this.f68120i.size());
                        }
                    }
                }
            }
        }
        if (Util.a()) {
            Log.d("ColorManager", "initData() called  cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public int r(String str) {
        if (l() && !TextUtils.isEmpty(str) && this.f68120i.containsKey(str)) {
            return this.f68120i.get(str).intValue();
        }
        Resources resources = BaseApplication.b().getResources();
        try {
            if (!(resources instanceof k)) {
                return resources.getColor(resources.getIdentifier(str, "color", BaseApplication.b().getPackageName()));
            }
            return ((k) resources).a().getColor(((k) resources).a().getIdentifier(str, "color", BaseApplication.b().getPackageName()));
        } catch (Resources.NotFoundException unused) {
            return Integer.MIN_VALUE;
        }
    }

    @SuppressLint({"ResourceType"})
    public int s(int i11) {
        if (!l()) {
            return Integer.MIN_VALUE;
        }
        if (this.f68121j.containsKey(Integer.valueOf(i11))) {
            try {
                return this.f68120i.get(this.f68121j.get(Integer.valueOf(i11))).intValue();
            } catch (Exception e11) {
                Log.e("ColorManager", "getColorForProxy() called with: resid = [" + i11 + "]", e11);
            }
        }
        if (i11 <= 0) {
            return Integer.MIN_VALUE;
        }
        String resourceName = BaseApplication.b().getResources().getResourceName(i11);
        if (resourceName.indexOf(47) != -1) {
            resourceName = resourceName.substring(resourceName.indexOf(47) + 1);
        }
        if (TextUtils.isEmpty(resourceName) || !this.f68120i.containsKey(resourceName)) {
            return Integer.MIN_VALUE;
        }
        return this.f68120i.get(resourceName).intValue();
    }

    @SuppressLint({"ResourceType"})
    public int t(int i11, Resources.Theme theme) {
        if (!l()) {
            return Integer.MIN_VALUE;
        }
        if (this.f68121j.containsKey(Integer.valueOf(i11))) {
            try {
                return this.f68120i.get(this.f68121j.get(Integer.valueOf(i11))).intValue();
            } catch (Exception e11) {
                Log.e("ColorManager", "getColorForProxy() called with: resid = [" + i11 + "]", e11);
            }
        }
        if (i11 <= 0) {
            return Integer.MIN_VALUE;
        }
        String resourceName = BaseApplication.b().getResources().getResourceName(i11);
        if (resourceName.indexOf(47) != -1) {
            resourceName = resourceName.substring(resourceName.indexOf(47) + 1);
        }
        if (TextUtils.isEmpty(resourceName) || !this.f68120i.containsKey(resourceName)) {
            return Integer.MIN_VALUE;
        }
        return this.f68120i.get(resourceName).intValue();
    }

    public File u() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(BaseApplication.b().getFilesDir().getPath());
        String str = File.separator;
        sb2.append(str);
        sb2.append("dynamic/color/");
        sb2.append(BaseApplication.e());
        sb2.append(str);
        sb2.append(f());
        sb2.append(str);
        sb2.append(i());
        sb2.append(str);
        sb2.append("values/");
        return new File(sb2.toString());
    }

    @SuppressLint({"ResourceType"})
    public boolean w(int i11) {
        if (!l() || i11 <= 0) {
            return false;
        }
        String resourceName = BaseApplication.b().getResources().getResourceName(i11);
        if (resourceName.indexOf(47) != -1) {
            resourceName = resourceName.substring(resourceName.indexOf(47) + 1);
        }
        if (TextUtils.isEmpty(resourceName) || !this.f68120i.containsKey(resourceName)) {
            return false;
        }
        if (Util.a()) {
            Log.d("ColorManager", "hasResource() called with: key = [" + resourceName + "]");
        }
        return true;
    }

    public boolean x(String str) {
        if (!l() || TextUtils.isEmpty(str) || !this.f68120i.containsKey(str)) {
            return false;
        }
        if (!Util.a()) {
            return true;
        }
        Log.d("ColorManager", "hasResource() called with: key = [" + str + "]");
        return true;
    }

    public void z(String str, Integer num) {
        if (!this.f68121j.containsKey(num)) {
            this.f68121j.put(num, str);
        }
    }

    public b() {
        this.f68120i = new ConcurrentHashMap();
        this.f68121j = new ConcurrentHashMap();
    }
}
