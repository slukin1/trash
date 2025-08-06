package hc;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import com.hbg.lib.core.GlobalAppConfig;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.hbg.module.libkt.base.ext.b;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.io.File;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.x;
import pa.e;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f19133a = new d();

    public static final class a implements e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f19134a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f19135b;

        public a(e eVar, Activity activity) {
            this.f19134a = eVar;
            this.f19135b = activity;
        }

        public void onCancel() {
        }

        public void onResult(List<? extends LocalMedia> list) {
            Uri d11;
            if (list != null) {
                e eVar = this.f19134a;
                Activity activity = this.f19135b;
                try {
                    LocalMedia localMedia = (LocalMedia) list.get(0);
                    if (localMedia.isCut()) {
                        String cutPath = localMedia.getCutPath();
                        String substring = cutPath.substring(StringsKt__StringsKt.m0(cutPath, "/", 0, false, 6, (Object) null) + 1);
                        if (eVar != null) {
                            eVar.a(Uri.fromFile(new File(localMedia.getCutPath())), substring);
                            Unit unit = Unit.f56620a;
                            return;
                        }
                        return;
                    }
                    String realPath = localMedia.getRealPath();
                    if (realPath != null && (d11 = d.f19133a.g(realPath, activity)) != null) {
                        String substring2 = realPath.substring(StringsKt__StringsKt.m0(realPath, "/", 0, false, 6, (Object) null) + 1);
                        if (eVar != null) {
                            eVar.a(d11, substring2);
                            Unit unit2 = Unit.f56620a;
                        }
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                    Unit unit3 = Unit.f56620a;
                }
            }
        }
    }

    public static /* synthetic */ void f(d dVar, String str, Activity activity, e eVar, Boolean bool, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            eVar = null;
        }
        if ((i11 & 8) != 0) {
            bool = Boolean.FALSE;
        }
        dVar.e(str, activity, eVar, bool);
    }

    @SensorsDataInstrumented
    public static final void i(Dialog dialog, Activity activity, e eVar, View view) {
        dialog.dismiss();
        f(f19133a, "Album", activity, eVar, (Boolean) null, 8, (Object) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void j(Dialog dialog, Activity activity, e eVar, View view) {
        dialog.dismiss();
        f(f19133a, PictureMimeType.CAMERA, activity, eVar, (Boolean) null, 8, (Object) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void k(Dialog dialog, View view) {
        dialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void e(String str, Activity activity, e eVar, Boolean bool) {
        if (b.e(activity)) {
            pa.d.o().h(activity, str, 1, x.b(bool, Boolean.TRUE), new a(eVar, activity));
        }
    }

    public final Uri g(String str, Activity activity) {
        Cursor cursor;
        ContentResolver contentResolver;
        String str2 = str;
        Activity activity2 = activity;
        Uri uri = null;
        try {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 < 24) {
                return Uri.fromFile(new File(str2));
            }
            if (i11 >= 29) {
                Uri uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                if (activity2 == null || (contentResolver = activity.getContentResolver()) == null) {
                    cursor = null;
                } else {
                    cursor = contentResolver.query(uri2, (String[]) null, "_display_name= ?", new String[]{str2.substring(StringsKt__StringsKt.m0(str, "/", 0, false, 6, (Object) null) + 1)}, (String) null);
                }
                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        uri = ContentUris.withAppendedId(uri2, cursor.getLong(cursor.getColumnIndex("_id")));
                    }
                    cursor.close();
                }
                return uri;
            } else if (activity2 == null) {
                return null;
            } else {
                return FileProvider.getUriForFile(activity2, GlobalAppConfig.a() + ".fileprovider", new File(str2));
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void h(Activity activity, e eVar) {
        View decorView;
        if (b.e(activity)) {
            WindowManager.LayoutParams layoutParams = null;
            View inflate = LayoutInflater.from(activity).inflate(R$layout.dialog_pic_choose, (ViewGroup) null);
            AlertDialog create = new AlertDialog.Builder(activity).setView(inflate).create();
            TextView textView = (TextView) inflate.findViewById(R$id.tvPhoto);
            TextView textView2 = (TextView) inflate.findViewById(R$id.tvCamera);
            View findViewById = inflate.findViewById(R$id.vLine);
            textView2.setVisibility(0);
            findViewById.setVisibility(0);
            textView.setVisibility(0);
            textView.setOnClickListener(new c(create, activity, eVar));
            textView2.setOnClickListener(new b(create, activity, eVar));
            ((TextView) inflate.findViewById(R$id.tvCancel)).setOnClickListener(new a(create));
            create.show();
            Window window = create.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            Window window2 = create.getWindow();
            if (window2 != null) {
                window2.setGravity(80);
            }
            Window window3 = create.getWindow();
            if (!(window3 == null || (decorView = window3.getDecorView()) == null)) {
                decorView.setPadding(0, 0, 0, 0);
            }
            if (window3 != null) {
                layoutParams = window3.getAttributes();
            }
            if (layoutParams != null) {
                layoutParams.width = -1;
            }
            if (layoutParams != null) {
                layoutParams.horizontalMargin = 0.0f;
            }
            if (window3 != null) {
                window3.setAttributes(layoutParams);
            }
        }
    }
}
