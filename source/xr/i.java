package xr;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import bh.j;
import com.hbg.lib.common.utils.FileUtil;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.invite.bean.InvitePosterItem;
import com.huobi.invite.bean.InvitePosterListItem;
import com.huobi.sharev2.bean.ShareInfo;
import com.huobi.sharev2.helper.NewShareHelper;
import com.huobi.sharev2.view.NewShareQrLayout;
import com.huobi.social.share.HBShareHelper;
import com.huobi.utils.ImageUtils;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.nostra13.universalimageloader.core.assist.FailReason;
import i6.k;
import pro.huobi.R;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f85059a;

    public class a implements tx.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f85060a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Bitmap f85061b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c6.b f85062c;

        public a(boolean z11, Bitmap bitmap, c6.b bVar) {
            this.f85060a = z11;
            this.f85061b = bitmap;
            this.f85062c = bVar;
        }

        public void a(String str, View view) {
        }

        public void b(String str, View view, FailReason failReason) {
        }

        public void c(String str, View view, Bitmap bitmap) {
            if (this.f85060a) {
                bitmap = i.this.n(this.f85061b, bitmap);
            }
            c6.b bVar = this.f85062c;
            if (bVar != null) {
                bVar.onCallback(bitmap);
            }
        }

        public void d(String str, View view) {
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static i f85064a = new i((a) null);
    }

    public /* synthetic */ i(a aVar) {
        this();
    }

    public static i r() {
        return b.f85064a;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(Context context, HBShareHelper.HbPlatform hbPlatform, Bitmap bitmap) {
        u(context, hbPlatform, bitmap, (String) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(Context context, HBShareHelper.HbPlatform hbPlatform, Bitmap bitmap, String str, Bitmap bitmap2) {
        u(context, hbPlatform, o(bitmap2, bitmap, true), str);
    }

    public static /* synthetic */ void v(String str, Uri uri) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w(Context context, Bitmap bitmap) {
        I(context, bitmap, true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x(Context context, Bitmap bitmap) {
        I(context, bitmap, true);
    }

    public static /* synthetic */ void y(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        HuobiToastUtil.s(R.string.otc_saveimage_path_faild_text);
    }

    public static /* synthetic */ void z(FragmentActivity fragmentActivity, HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment.isAdded()) {
            hBDialogFragment.dismiss();
            return;
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", j.c().getPackageName(), (String) null));
        fragmentActivity.startActivity(intent);
        hBDialogFragment.dismiss();
    }

    public void A(Context context, boolean z11, HBShareHelper.HbPlatform hbPlatform, InvitePosterListItem invitePosterListItem, String str, Bitmap bitmap, String str2) {
        Bitmap l11 = l(context, z11, invitePosterListItem, str);
        if (l11 != null) {
            if (bitmap != null) {
                l11 = o(l11, bitmap, true);
            }
            u(context, hbPlatform, l11, str2);
            return;
        }
        Log.e("ShareUtils", "create share bitmap error: bitmap is null");
    }

    /* renamed from: B */
    public void u(Context context, HBShareHelper.HbPlatform hbPlatform, Bitmap bitmap, String str) {
        C(context, hbPlatform, I(context, bitmap, true), str);
    }

    public void C(Context context, HBShareHelper.HbPlatform hbPlatform, String str, String str2) {
        HBShareHelper hBShareHelper = new HBShareHelper(context, hbPlatform);
        if (TextUtils.isEmpty(str)) {
            k.d("openImageShare", "Open ImageShare Error: prams imageFilePath is null");
        } else {
            hBShareHelper.c("", str, str2);
        }
    }

    public void D(Context context, boolean z11, HBShareHelper.HbPlatform hbPlatform, InvitePosterListItem invitePosterListItem, String str) {
        p(context, invitePosterListItem, str, z11, new d(this, context, hbPlatform));
    }

    public void E(Context context, boolean z11, HBShareHelper.HbPlatform hbPlatform, InvitePosterListItem invitePosterListItem, String str, Bitmap bitmap, String str2) {
        if (bitmap != null) {
            p(context, invitePosterListItem, str, z11, new e(this, context, hbPlatform, bitmap, str2));
            return;
        }
        p(context, invitePosterListItem, str, z11, new f(this, context, hbPlatform, str2));
    }

    public void F(Context context, HBShareHelper.HbPlatform hbPlatform, String str, String str2, String str3) {
        new HBShareHelper(context, hbPlatform).f("", str, str2, str3);
    }

    public void G(Context context, HBShareHelper.HbPlatform hbPlatform, String str, String str2) {
        new HBShareHelper(context, hbPlatform).e("", str2, str);
    }

    public void H(Context context, HBShareHelper.HbPlatform hbPlatform, String str, String str2, String str3) {
        new HBShareHelper(context, hbPlatform).e(str, str2, str3);
    }

    public String I(Context context, Bitmap bitmap, boolean z11) {
        String str;
        String[] strArr;
        if (bitmap == null) {
            return null;
        }
        try {
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
            str = ImageUtils.h(bitmap, compressFormat, FileUtil.f(compressFormat.name(), z11));
        } catch (Exception e11) {
            k.d("ShareUtils", "saveBitmap ==> createPublicTempFile error : " + e11.toString());
            str = "";
        }
        if (z11) {
            if (Build.VERSION.SDK_INT >= 33) {
                strArr = new String[]{PermissionConfig.READ_MEDIA_IMAGES};
            } else {
                strArr = new String[]{PermissionConfig.READ_EXTERNAL_STORAGE, PermissionConfig.WRITE_EXTERNAL_STORAGE};
            }
            if (context == null || !EasyPermissions.hasPermissions(context, strArr)) {
                boolean z12 = false;
                for (String shouldShowRequestPermissionRationale : strArr) {
                    z12 = z12 || EasyPermissions.shouldShowRequestPermissionRationale(this, shouldShowRequestPermissionRationale);
                }
                if (z12) {
                    EasyPermissions.requestPermissions(this, 126, strArr);
                } else if (context instanceof FragmentActivity) {
                    P((FragmentActivity) context);
                }
            } else {
                MediaScannerConnection.scanFile(context, new String[]{str}, (String[]) null, a.f61692a);
                HuobiToastUtil.s(R.string.save_success);
            }
        }
        return str;
    }

    public void J(Context context, InvitePosterListItem invitePosterListItem, String str, Bitmap bitmap) {
        Bitmap l11 = l(context, true, invitePosterListItem, str);
        if (l11 != null) {
            if (bitmap != null) {
                l11 = o(l11, bitmap, true);
            }
            I(context, l11, true);
            return;
        }
        Log.e("ShareUtils", "create share bitmap error: bitmap is null");
    }

    public void K(Context context, ShareInfo shareInfo, String str, Bitmap bitmap) {
        I(context, n(k(context, str, shareInfo), bitmap), true);
    }

    public void L(Context context, Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap != null) {
            if (bitmap2 != null) {
                bitmap = o(bitmap, bitmap2, true);
            }
            I(context, bitmap, true);
            return;
        }
        Log.e("ShareUtils", "create share bitmap error: bitmap is null");
    }

    public void M(Context context, InvitePosterListItem invitePosterListItem, String str) {
        p(context, invitePosterListItem, str, true, new c(this, context));
    }

    public void N(Context context, InvitePosterListItem invitePosterListItem, String str) {
        p(context, invitePosterListItem, str, false, new b(this, context));
    }

    public void O(Bitmap bitmap) {
        this.f85059a = bitmap;
    }

    public final void P(FragmentActivity fragmentActivity) {
        if (fragmentActivity != null) {
            FragmentActivity fragmentActivity2 = fragmentActivity;
            DialogUtils.c0(fragmentActivity2, fragmentActivity.getResources().getString(R.string.share_content_tip), (String) null, fragmentActivity.getResources().getString(R.string.share_cancel), fragmentActivity.getResources().getString(R.string.share_ok), h.f61710a, new g(fragmentActivity));
        }
    }

    public final Bitmap j(Context context, String str, InvitePosterItem invitePosterItem) {
        NewShareQrLayout newShareQrLayout = new NewShareQrLayout(context);
        newShareQrLayout.d(invitePosterItem.getSubTitle(), invitePosterItem.getInviteCode(), str);
        return newShareQrLayout.a(str);
    }

    public final Bitmap k(Context context, String str, ShareInfo shareInfo) {
        NewShareQrLayout newShareQrLayout = new NewShareQrLayout(context);
        newShareQrLayout.d(shareInfo.getPosterSubtitle(), shareInfo.getInviteCode(), str);
        return newShareQrLayout.a(str);
    }

    public final Bitmap l(Context context, boolean z11, InvitePosterListItem invitePosterListItem, String str) {
        if (invitePosterListItem == null || invitePosterListItem.d() == null) {
            return null;
        }
        return m(context, z11, str, invitePosterListItem.d());
    }

    public Bitmap m(Context context, boolean z11, String str, InvitePosterItem invitePosterItem) {
        if (!z11) {
            return NewShareHelper.j().f(invitePosterItem.getBytesFromBitmap());
        }
        return n(j(context, str, invitePosterItem), NewShareHelper.j().f(invitePosterItem.getBytesFromBitmap()));
    }

    public final Bitmap n(Bitmap bitmap, Bitmap bitmap2) {
        return o(bitmap, bitmap2, false);
    }

    public Bitmap o(Bitmap bitmap, Bitmap bitmap2, boolean z11) {
        if (bitmap == null) {
            return null;
        }
        Bitmap l11 = ImageUtils.l(bitmap2, bitmap.getWidth(), (bitmap.getWidth() * bitmap2.getHeight()) / bitmap2.getWidth());
        if (z11) {
            return ImageUtils.k(bitmap, l11);
        }
        return ImageUtils.k(l11, bitmap);
    }

    public final void p(Context context, InvitePosterListItem invitePosterListItem, String str, boolean z11, c6.b<Bitmap> bVar) {
        if (invitePosterListItem != null && invitePosterListItem.d() != null) {
            InvitePosterItem d11 = invitePosterListItem.d();
            q(z11, z11 ? j(context, str, d11) : null, d11.getImg(), bVar);
        }
    }

    public final void q(boolean z11, Bitmap bitmap, String str, c6.b<Bitmap> bVar) {
        g6.b.c().m(str, new a(z11, bitmap, bVar));
    }

    public i() {
    }
}
