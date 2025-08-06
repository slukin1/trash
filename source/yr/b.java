package yr;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import bh.j;
import com.hbg.lib.core.GlobalAppConfig;
import com.huobi.R$drawable;
import com.huobi.social.share.HBShareHelper;
import com.huobi.social.share.event.ShareBusEvent;
import com.huobi.utils.ImageUtils;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import java.io.File;
import org.greenrobot.eventbus.EventBus;

public class b extends vr.a {

    /* renamed from: e  reason: collision with root package name */
    public static IWXAPI f85082e;

    /* renamed from: f  reason: collision with root package name */
    public static a f85083f;

    /* renamed from: d  reason: collision with root package name */
    public HBShareHelper.HbPlatform f85084d;

    public class a extends a {
        public a(HBShareHelper.HbPlatform hbPlatform) {
            super(hbPlatform);
        }

        public void a() {
            EventBus.d().k(new ShareBusEvent(this.f85081a, ShareBusEvent.Type.CANCEL));
        }

        public void b(Exception exc) {
            EventBus.d().k(new ShareBusEvent(this.f85081a, ShareBusEvent.Type.FAILURE));
        }

        public void c() {
            EventBus.d().k(new ShareBusEvent(this.f85081a, ShareBusEvent.Type.SUCCESS));
        }
    }

    public b(Context context, HBShareHelper.HbPlatform hbPlatform) {
        super(context);
        this.f85084d = hbPlatform;
        this.f85013a = p(context).isWXAppInstalled();
        f85083f = new a(hbPlatform);
    }

    public static String k() {
        return "img" + System.currentTimeMillis();
    }

    public static int l(HBShareHelper.HbPlatform hbPlatform) {
        return hbPlatform == HBShareHelper.HbPlatform.TYPE_WECHAT_MOMENTS ? 1 : 0;
    }

    public static String m() {
        return "webpage" + System.currentTimeMillis();
    }

    public static IWXAPI p(Context context) {
        if (f85082e == null) {
            f85082e = WXAPIFactory.createWXAPI(context, "wx1958676571cb329d", true);
        }
        return f85082e;
    }

    public static void q(SendMessageToWX.Resp resp) {
        a aVar = f85083f;
        if (aVar != null) {
            int i11 = resp.errCode;
            if (i11 == -4) {
                aVar.b(new Exception("BaseResp.ErrCode.ERR_AUTH_DENIED"));
            } else if (i11 == -2) {
                aVar.a();
            } else if (i11 == 0) {
                aVar.c();
            }
        }
    }

    public void c(String str, String str2, String str3) {
        WXImageObject wXImageObject = new WXImageObject();
        if (!o(this.f85014b) || !n()) {
            wXImageObject.setImagePath(str2);
        } else {
            Uri uriForFile = FileProvider.getUriForFile(this.f85014b, GlobalAppConfig.a() + ".fileprovider", new File(str2));
            wXImageObject.setImagePath(uriForFile.toString());
            this.f85014b.grantUriPermission(ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME, uriForFile, 1);
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = k();
        req.message = wXMediaMessage;
        req.scene = l(this.f85084d);
        Context context = this.f85014b;
        if (context != null) {
            p(context).sendReq(req);
            return;
        }
        Fragment fragment = this.f85015c;
        if (fragment != null && fragment.getActivity() != null) {
            p(this.f85015c.getActivity()).sendReq(req);
        }
    }

    public void e(String str, String str2, String str3) {
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
        if (this.f85084d == HBShareHelper.HbPlatform.TYPE_WECHAT_MOMENTS) {
            wXMediaMessage.title = str2;
        } else {
            wXMediaMessage.title = str;
        }
        wXMediaMessage.description = str2;
        Bitmap e11 = ImageUtils.e(j.c(), R$drawable.icon);
        if (e11 != null) {
            wXMediaMessage.thumbData = ImageUtils.a(e11);
            e11.recycle();
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = m();
        req.message = wXMediaMessage;
        req.scene = l(this.f85084d);
        Context context = this.f85014b;
        if (context != null) {
            p(context).sendReq(req);
            return;
        }
        Fragment fragment = this.f85015c;
        if (fragment != null && fragment.getActivity() != null) {
            p(this.f85015c.getActivity()).sendReq(req);
        }
    }

    public boolean n() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public boolean o(Context context) {
        return p(context).getWXAppSupportAPI() >= 654314752;
    }
}
