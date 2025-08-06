package dd;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.huobi.im.c2c.ui.ImC2CChatActivity;
import com.hbg.module.huobi.im.group.ui.GroupChatListAllActivity;
import com.hbg.module.huobi.im.group.ui.chat.ImGroupChatActivity;
import com.hbg.module.huobi.im.utils.LiveErrorCode;
import com.huobi.framework.im.common.ImCommonCallback;
import com.huobi.framework.im.common.ImManager;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import ld.e;
import ld.f;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f22740a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final String f22741b = b.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public static final f f22742c = new f((e) null);

    /* renamed from: d  reason: collision with root package name */
    public static int f22743d = 120;

    public static final class a implements ImCommonCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f22744a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f22745b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f22746c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f22747d;

        public a(Context context, String str, String str2, String str3) {
            this.f22744a = context;
            this.f22745b = str;
            this.f22746c = str2;
            this.f22747d = str3;
        }

        public void onFailed(int i11, String str) {
            String a11 = b.f22741b;
            Log.e(a11, "加群失败：" + i11 + str);
            if (i11 == LiveErrorCode.LIVE_USER_IM_KICK.getCode()) {
                ToastUtil.toastShortMessage(this.f22744a.getString(R$string.n_im_kick_out));
            } else if (i11 == LiveErrorCode.LIVE_USER_IM_BLACK.getCode()) {
                ToastUtil.toastShortMessage(this.f22744a.getString(R$string.n_im_block_done));
            } else {
                b.f22740a.l(this.f22744a, this.f22745b, this.f22746c, this.f22747d);
            }
        }

        public void onSuccess() {
            Log.e(b.f22741b, "加群成功");
            b.f22740a.l(this.f22744a, this.f22745b, this.f22746c, this.f22747d);
        }
    }

    public static /* synthetic */ void k(b bVar, Context context, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str3 = null;
        }
        bVar.j(context, str, str2, str3);
    }

    public final int c() {
        return f22743d;
    }

    public final void d(Context context, boolean z11) {
        ImManager.INSTANCE.initContext(context.getApplicationContext(), z11 ? 20000142 : 20000241);
    }

    public final void e() {
        f22742c.z();
    }

    public final void f(int i11) {
        f22743d = i11;
    }

    public final void g(Context context) {
        context.startActivity(new Intent(context, GroupChatListAllActivity.class));
    }

    public final void h(Context context, String str, String str2) {
        i(context, str, str2);
    }

    public final void i(Context context, String str, String str2) {
        Intent intent = new Intent(context, ImC2CChatActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("chatId", str);
        bundle.putString(TUIConstants.TUIChat.CHAT_NAME, str2);
        bundle.putString(TUIConstants.TUIChat.CHAT_TYPE, "1");
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public final void j(Context context, String str, String str2, String str3) {
        String str4;
        if (str != null) {
            if (!StringsKt__StringsJVMKt.M(str, "@TGS#_", false, 2, (Object) null)) {
                str4 = "@TGS#_" + str;
            } else {
                str4 = str;
            }
            ImManager.INSTANCE.joinChatGroup(str4, new a(context, str, str2, str3));
        }
    }

    public final void l(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, ImGroupChatActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("chatId", str);
        bundle.putString(TUIConstants.TUIChat.CHAT_NAME, str2);
        bundle.putString("messageId", str3);
        bundle.putString(TUIConstants.TUIChat.CHAT_TYPE, "2");
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
