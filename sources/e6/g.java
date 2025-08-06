package e6;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.blankj.utilcode.util.l;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.dynamic.downloader.DyanmicConfig;
import com.hbg.lib.common.dynamic.downloader.Util;
import com.hbg.lib.common.dynamic.manager.HBDynamicBaseManager;
import com.huobi.view.roundimg.RoundedDrawable;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class g extends HBDynamicBaseManager {

    /* renamed from: i  reason: collision with root package name */
    public c f68130i;

    /* renamed from: j  reason: collision with root package name */
    public final Map<String, String> f68131j;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final g f68132a = new g();
    }

    public interface c {
        boolean G2();
    }

    public static g v() {
        return b.f68132a;
    }

    public static /* synthetic */ boolean z(File file) {
        return (file.getName().toLowerCase().endsWith(PictureMimeType.PNG) && !file.getName().toLowerCase().endsWith(".9.png")) || file.getName().toLowerCase().endsWith(PictureMimeType.JPG) || file.getName().toLowerCase().endsWith(".webp");
    }

    public final Drawable A(Resources resources, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            if (!Util.a()) {
                return new BitmapDrawable(resources, decodeFile);
            }
            Bitmap copy = decodeFile.copy(Bitmap.Config.ARGB_8888, true);
            Canvas canvas = new Canvas(copy);
            Paint paint = new Paint(1);
            paint.setColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawLine(0.0f, 0.0f, (float) decodeFile.getWidth(), (float) decodeFile.getHeight(), paint);
            canvas.drawLine(0.0f, (float) decodeFile.getHeight(), (float) decodeFile.getWidth(), 0.0f, paint);
            return new BitmapDrawable(resources, copy);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public void B(c cVar) {
        this.f68130i = cVar;
    }

    public File e(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(BaseApplication.b().getFilesDir().getPath());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("dynamic/Image/");
        sb2.append(BaseApplication.e());
        sb2.append(str2);
        sb2.append(str);
        return new File(sb2.toString());
    }

    public String g() {
        return "DynamicDrawable";
    }

    public String h() {
        return DyanmicConfig.Image.class.getName();
    }

    public void k() {
        long currentTimeMillis = System.currentTimeMillis();
        File r11 = r();
        if (r11.isDirectory() && r11.exists()) {
            for (File next : l.l(r11, e.f54277b)) {
                if (Util.a()) {
                    Log.d("DynamicDrawable", "imageFiles list called " + next.getPath());
                }
                List<File> l11 = l.l(next, f.f54278b);
                if (!l11.isEmpty()) {
                    for (int i11 = 0; i11 < l11.size(); i11++) {
                        File file = l11.get(i11);
                        if (file.isFile() && file.exists() && ((file.getName().toLowerCase().endsWith(PictureMimeType.PNG) && !file.getName().toLowerCase().endsWith(".9.png")) || file.getName().toLowerCase().endsWith(PictureMimeType.JPG) || file.getName().toLowerCase().endsWith(".webp"))) {
                            this.f68131j.put(next.getName() + "/" + file.getName().substring(0, file.getName().indexOf(InstructionFileId.DOT)), file.getAbsolutePath());
                        }
                    }
                }
            }
        }
        if (Util.a()) {
            Log.d("DynamicDrawable", "initData() called  cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public File r() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(BaseApplication.b().getFilesDir().getPath());
        String str = File.separator;
        sb2.append(str);
        sb2.append("dynamic/Image/");
        sb2.append(BaseApplication.e());
        sb2.append(str);
        sb2.append(f());
        sb2.append(str);
        sb2.append(i());
        sb2.append(str);
        return new File(sb2.toString());
    }

    public Drawable s(Resources resources, String str) {
        Drawable A;
        if (resources == null) {
            resources = BaseApplication.b().getResources();
        }
        if (l() && !TextUtils.isEmpty(str)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(y() ? "drawable-night-xxhdpi/" : "drawable-xxhdpi/");
            sb2.append(str);
            str = sb2.toString();
            if (this.f68131j.containsKey(str) && (A = A(resources, this.f68131j.get(str))) != null) {
                return A;
            }
        }
        try {
            if (!(resources instanceof k)) {
                return resources.getDrawable(resources.getIdentifier(str, "drawable", BaseApplication.b().getPackageName()));
            }
            return ((k) resources).a().getDrawable(((k) resources).a().getIdentifier(str, "drawable", BaseApplication.b().getPackageName()));
        } catch (Resources.NotFoundException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    @SuppressLint({"ResourceType"})
    public Drawable t(int i11) {
        if (!l() || i11 == 0) {
            return null;
        }
        String str = y() ? "drawable-night-xxhdpi/" : "drawable-xxhdpi/";
        Resources resources = BaseApplication.b().getResources();
        if (i11 < 0) {
            for (Map.Entry next : this.f68131j.entrySet()) {
                if (((String) next.getKey()).startsWith(str) && (-Math.abs(((String) next.getKey()).substring(str.length() - 1).hashCode())) == i11) {
                    return A(resources, (String) next.getValue());
                }
            }
        }
        String resourceName = BaseApplication.b().getResources().getResourceName(i11);
        if (resourceName.indexOf(47) != -1) {
            resourceName = resourceName.substring(resourceName.indexOf(47) + 1);
        }
        if (!TextUtils.isEmpty(resourceName)) {
            String str2 = str + resourceName;
            if (this.f68131j.containsKey(str2)) {
                return A(resources, this.f68131j.get(str2));
            }
        }
        return null;
    }

    @SuppressLint({"ResourceType"})
    public Drawable u(int i11, Resources.Theme theme) {
        if (!l() || i11 == 0) {
            return null;
        }
        String str = "drawable-night-xxhdpi/";
        String str2 = y() ? str : "drawable-xxhdpi/";
        Resources resources = BaseApplication.b().getResources();
        if (i11 < 0) {
            for (Map.Entry next : this.f68131j.entrySet()) {
                if (((String) next.getKey()).startsWith(str2) && (-Math.abs(((String) next.getKey()).substring(str2.length()).hashCode())) == i11) {
                    return A(resources, (String) next.getValue());
                }
            }
        }
        String resourceName = BaseApplication.b().getResources().getResourceName(i11);
        if (resourceName.indexOf(47) != -1) {
            resourceName = resourceName.substring(resourceName.indexOf(47) + 1);
        }
        String str3 = str2 + resourceName;
        if (!TextUtils.isEmpty(str3)) {
            StringBuilder sb2 = new StringBuilder();
            if (!y()) {
                str = "drawable-xxhdpi/";
            }
            sb2.append(str);
            sb2.append(str3);
            String sb3 = sb2.toString();
            if (this.f68131j.containsKey(sb3)) {
                return A(resources, this.f68131j.get(sb3));
            }
        }
        return null;
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
        if (TextUtils.isEmpty(resourceName)) {
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(y() ? "drawable-night-xxhdpi/" : "drawable-xxhdpi/");
        sb2.append(resourceName);
        String sb3 = sb2.toString();
        if (!this.f68131j.containsKey(sb3)) {
            return false;
        }
        if (Util.a()) {
            Log.d("DynamicDrawable", "hasResource() called with: key = [" + sb3 + "] return true;");
        }
        return true;
    }

    @SuppressLint({"ResourceType"})
    public boolean x(String str) {
        if (!l() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str)) {
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(y() ? "drawable-night-xxhdpi/" : "drawable-xxhdpi/");
        sb2.append(str);
        String sb3 = sb2.toString();
        if (!this.f68131j.containsKey(sb3)) {
            return false;
        }
        if (!Util.a()) {
            return true;
        }
        Log.d("DynamicDrawable", "hasResource() called with: key = [" + sb3 + "] return true;");
        return true;
    }

    public final boolean y() {
        c cVar = this.f68130i;
        if (cVar == null) {
            return false;
        }
        return cVar.G2();
    }

    public g() {
        this.f68131j = new ConcurrentHashMap();
    }
}
