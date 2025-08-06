package e6;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.blankj.utilcode.util.l;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.dynamic.downloader.DyanmicConfig;
import com.hbg.lib.common.dynamic.downloader.Util;
import com.hbg.lib.common.dynamic.manager.HBDynamicBaseManager;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.xiaomi.mipush.sdk.Constants;
import i6.k;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class d extends HBDynamicBaseManager {

    /* renamed from: i  reason: collision with root package name */
    public String f68126i;

    /* renamed from: j  reason: collision with root package name */
    public final ConcurrentHashMap<String, HashMap<String, String>> f68127j;

    public class a implements FileFilter {
        public a() {
        }

        public boolean accept(File file) {
            return file.getName().endsWith(".xml");
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d f68129a = new d((a) null);
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d r() {
        return b.f68129a;
    }

    public File e(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(BaseApplication.b().getFilesDir().getPath());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("dynamic/i18n/");
        sb2.append(BaseApplication.e());
        sb2.append(str2);
        sb2.append(str);
        return new File(sb2.toString());
    }

    public String g() {
        return "I18nManager";
    }

    public String h() {
        return DyanmicConfig.I18n.class.getName();
    }

    public void k() {
        long currentTimeMillis = System.currentTimeMillis();
        File q11 = q();
        if (Util.a()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("initData() called i18ns=");
            sb2.append(q11.getPath());
            sb2.append("  , =(i18ns.isDirectory() && i18ns.exists())=");
            sb2.append(q11.isDirectory() && q11.exists());
            Log.d("I18nManager", sb2.toString());
        }
        if (q11.isDirectory() && q11.exists()) {
            List<File> l11 = l.l(q11, new a());
            Log.d("I18nManager", "initData() called files=" + l11);
            if (!l11.isEmpty()) {
                HashMap hashMap = new HashMap();
                for (int i11 = 0; i11 < l11.size(); i11++) {
                    File file = l11.get(i11);
                    if (Util.a()) {
                        Log.e("I18nManager", String.format("initData(%d) called file=%s", new Object[]{Integer.valueOf(i11), file.getPath()}));
                    }
                    if (file.isFile() && file.exists() && file.getName().endsWith(".xml")) {
                        try {
                            w(file, hashMap);
                        } catch (Exception e11) {
                            k.h("I18nManager", "readXmlLangFile() called Exception", e11, false);
                        }
                        if (Util.a()) {
                            Log.d("I18nManager", "initData(" + s() + ") called langmap.size=" + hashMap.size());
                        }
                        if (i11 == l11.size() - 1 && !hashMap.isEmpty()) {
                            this.f68127j.put(s(), hashMap);
                        }
                    }
                }
            }
        }
        if (Util.a()) {
            Log.d("I18nManager", "initData() called  cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public File q() {
        String str;
        String s11 = s();
        if (s11.indexOf(45) != -1) {
            String[] split = s11.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            str = String.format("res/values-%s-r%s/", new Object[]{split[0], split[1]});
        } else {
            str = String.format("res/values-%s/", new Object[]{s11});
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(BaseApplication.b().getFilesDir().getPath());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("dynamic/i18n/");
        sb2.append(BaseApplication.e());
        sb2.append(str2);
        sb2.append(f());
        sb2.append(str2);
        sb2.append(i());
        sb2.append(str2);
        sb2.append(str);
        return new File(sb2.toString());
    }

    public String s() {
        if (this.f68126i == null) {
            this.f68126i = TUIThemeManager.LANGUAGE_EN;
        }
        return this.f68126i;
    }

    @SuppressLint({"ResourceType"})
    public String t(int i11) {
        if (!l() || i11 == 0) {
            return null;
        }
        if (i11 < 0) {
            for (Map.Entry entry : this.f68127j.get(s()).entrySet()) {
                if ((-Math.abs(((String) entry.getKey()).hashCode())) == i11) {
                    return (String) entry.getValue();
                }
            }
        }
        String resourceName = BaseApplication.b().getResources().getResourceName(i11);
        if (resourceName.indexOf(47) != -1) {
            resourceName = resourceName.substring(resourceName.indexOf(47) + 1);
        }
        if (TextUtils.isEmpty(resourceName) || TextUtils.isEmpty(s()) || !this.f68127j.containsKey(s()) || !this.f68127j.get(s()).containsKey(resourceName)) {
            return null;
        }
        return (String) this.f68127j.get(s()).get(resourceName);
    }

    @SuppressLint({"ResourceType"})
    public boolean u(int i11) {
        if (!l() || i11 <= 0) {
            return false;
        }
        String resourceName = BaseApplication.b().getResources().getResourceName(i11);
        if (resourceName.indexOf(47) != -1) {
            resourceName = resourceName.substring(resourceName.indexOf(47) + 1);
        }
        if (TextUtils.isEmpty(resourceName) || TextUtils.isEmpty(s()) || !this.f68127j.containsKey(s()) || !this.f68127j.get(s()).containsKey(resourceName)) {
            return false;
        }
        if (Util.a()) {
            Log.d("I18nManager", "hasResource() called with: key = [" + resourceName + "]");
        }
        return true;
    }

    @SuppressLint({"ResourceType"})
    public boolean v(String str) {
        if (!l() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(s()) || !this.f68127j.containsKey(s()) || !this.f68127j.get(s()).containsKey(str)) {
            return false;
        }
        if (!Util.a()) {
            return true;
        }
        Log.d("I18nManager", "hasResource() called with: key = [" + str + "]");
        return true;
    }

    public final HashMap<String, String> w(File file, HashMap<String, String> hashMap) throws XmlPullParserException, IOException {
        if (file != null && file.isFile() && file.exists() && file.length() > 0) {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(new FileInputStream(file), "utf-8");
            String str = "";
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if (!TextUtils.isEmpty(name) && name.equals("string")) {
                        str = newPullParser.getAttributeValue((String) null, "name");
                    }
                } else if (eventType == 3) {
                    str = "";
                } else if (eventType == 4) {
                    String text = newPullParser.getText();
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(text)) {
                        hashMap.put(str, text);
                        if (Util.a()) {
                            Log.d("I18nManager", "readXmlLangFile() called with: , key = [" + str + "], value = [" + text + "]");
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public void x(String str) {
        if (Util.a()) {
            Log.d("I18nManager", "setLanguage() called with: language = [" + str + "]");
        }
        if (str.equals("en-US")) {
            this.f68126i = TUIThemeManager.LANGUAGE_EN;
        } else {
            this.f68126i = str;
        }
        if (l()) {
            k();
        }
    }

    public d() {
        this.f68126i = null;
        this.f68127j = new ConcurrentHashMap<>();
    }
}
