package com.huobi.main.helper;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.common.BaseApplication;
import com.hbg.module.libkt.base.ext.b;
import com.huobi.app.rms.HBRMSManager;
import com.huobi.app.rms.bean.HBRMSResourceInfoModel;
import com.huobi.app.rms.bean.HBRMSResourceType;
import com.huobi.main.bean.RemoteSkinBean;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import rd.d;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Resources f77721a;

    /* renamed from: com.huobi.main.helper.a$a  reason: collision with other inner class name */
    public static class C0832a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f77722a = new a((HBHomeSkinHelper$1) null);
    }

    public /* synthetic */ a(HBHomeSkinHelper$1 hBHomeSkinHelper$1) {
        this();
    }

    public static a c() {
        return C0832a.f77722a;
    }

    public ColorStateList a(ColorStateList colorStateList, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return colorStateList;
        }
        int parseColor = Color.parseColor(str2);
        int[] iArr = {parseColor, parseColor, parseColor, parseColor, Color.parseColor(str)};
        return new ColorStateList(new int[][]{new int[]{16842913}, new int[]{16842919}, new int[]{16842908}, new int[]{16842912}, new int[0]}, iArr);
    }

    public Drawable b(int i11, String str, String str2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable e11 = e(this.f77721a, str);
        Drawable e12 = e(this.f77721a, str2);
        if (e12 == null || e11 == null) {
            return ResourcesCompat.f(this.f77721a, i11, (Resources.Theme) null);
        }
        stateListDrawable.addState(new int[]{16842913}, e11);
        stateListDrawable.addState(new int[]{16842912}, e11);
        stateListDrawable.addState(new int[]{16842908}, e11);
        stateListDrawable.addState(new int[]{16842919}, e11);
        stateListDrawable.addState(new int[0], e12);
        return stateListDrawable;
    }

    public RemoteSkinBean d(Context context) {
        try {
            List<HBRMSResourceInfoModel> K = HBRMSManager.z().K(HBRMSResourceType.Skin);
            if (b.w(K)) {
                return null;
            }
            StringBuilder sb2 = new StringBuilder();
            File file = new File(K.get(0).getResourcePath() + "/config.json");
            if (!file.exists()) {
                return null;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return (RemoteSkinBean) d.f23353a.b(sb2.toString(), RemoteSkinBean.class);
                }
                sb2.append(readLine);
                sb2.append("\n");
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public Drawable e(Resources resources, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                List<HBRMSResourceInfoModel> K = HBRMSManager.z().K(HBRMSResourceType.Skin);
                if (b.w(K)) {
                    return null;
                }
                String str2 = K.get(0).getResourcePath() + "/" + str;
                if (!str2.endsWith(PictureMimeType.PNG)) {
                    str2 = str2 + PictureMimeType.PNG;
                }
                return new BitmapDrawable(resources, BitmapFactory.decodeFile(str2));
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return null;
    }

    public a() {
        this.f77721a = BaseApplication.b().getResources();
    }
}
