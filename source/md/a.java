package md;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import com.hbg.module.huobi.im.R$drawable;
import com.hbg.module.huobi.im.group.ui.barrage.LiveListener;
import com.hbg.module.huobi.im.group.ui.barrage.TUIBarrageButton;
import com.hbg.module.huobi.im.utils.MessageBusinessID;
import com.tencent.imsdk.common.IMLog;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuibarrage.manager.HbBarrageManager;
import com.tencent.qcloud.tuikit.tuibarrage.manager.TUIBarrageCallBack;
import com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.x;

@SuppressLint({"StaticFieldLeak"})
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f22950a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final String f22951b;

    /* renamed from: c  reason: collision with root package name */
    public static List<WeakReference<LiveListener>> f22952c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public static WeakReference<b> f22953d;

    /* renamed from: e  reason: collision with root package name */
    public static TUIBarrageCallBack f22954e = new C0200a();

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap<Integer, Bitmap> f22955f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public static String f22956g;

    /* renamed from: h  reason: collision with root package name */
    public static View f22957h;

    /* renamed from: i  reason: collision with root package name */
    public static Context f22958i;

    /* renamed from: j  reason: collision with root package name */
    public static String f22959j = "";

    /* renamed from: k  reason: collision with root package name */
    public static long f22960k;

    /* renamed from: l  reason: collision with root package name */
    public static List<String> f22961l = new ArrayList();

    /* renamed from: md.a$a  reason: collision with other inner class name */
    public static final class C0200a extends TUIBarrageCallBack {
        public void onCustomCallback(int i11, TUIBarrageMessage tUIBarrageMessage) {
            LiveListener liveListener;
            super.onCustomCallback(i11, tUIBarrageMessage);
            if (a.f22952c.size() > 0) {
                int size = a.f22952c.size();
                while (true) {
                    size--;
                    if (-1 < size) {
                        WeakReference weakReference = (WeakReference) a.f22952c.get(size);
                        if (weakReference.get() == null) {
                            a.f22952c.remove(size);
                        } else {
                            IMLog.d(a.f22951b, "收到自定义消息：" + tUIBarrageMessage);
                            String str = tUIBarrageMessage != null ? tUIBarrageMessage.businessID : null;
                            if (x.b(str, MessageBusinessID.MSG_BUSINESS_ID_LIVE_LIKE.getValue())) {
                                LiveListener liveListener2 = (LiveListener) weakReference.get();
                                if (liveListener2 != null) {
                                    liveListener2.d(tUIBarrageMessage);
                                }
                            } else if (x.b(str, MessageBusinessID.MSG_BUSINESS_ID_LIVE_MSG_DEL.getValue())) {
                                LiveListener liveListener3 = (LiveListener) weakReference.get();
                                if (liveListener3 != null) {
                                    liveListener3.f(tUIBarrageMessage);
                                }
                            } else if (x.b(str, MessageBusinessID.MSG_BUSINESS_ID_LIVE_KICK.getValue())) {
                                LiveListener liveListener4 = (LiveListener) weakReference.get();
                                if (liveListener4 != null) {
                                    liveListener4.c(tUIBarrageMessage);
                                }
                            } else if (x.b(str, MessageBusinessID.MSG_BUSINESS_ID_DELETE_USER_MESSAGE.getValue())) {
                                LiveListener liveListener5 = (LiveListener) weakReference.get();
                                if (liveListener5 != null) {
                                    liveListener5.f(tUIBarrageMessage);
                                }
                            } else if (x.b(str, MessageBusinessID.MSG_BUSINESS_ID_HUOBI_LIVE_FINISH.getValue())) {
                                LiveListener liveListener6 = (LiveListener) weakReference.get();
                                if (liveListener6 != null) {
                                    liveListener6.a(tUIBarrageMessage);
                                }
                            } else if (x.b(str, MessageBusinessID.MSG_BUSINESS_ID_HUOBI_LIVE_NOTICE.getValue())) {
                                LiveListener liveListener7 = (LiveListener) weakReference.get();
                                if (liveListener7 != null) {
                                    liveListener7.e(tUIBarrageMessage);
                                }
                            } else if (x.b(str, MessageBusinessID.MSG_BUSINESS_ID_HUOBI_LIVE_NOTICE_RECALL.getValue()) && (liveListener = (LiveListener) weakReference.get()) != null) {
                                liveListener.b(tUIBarrageMessage);
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public void onFailed(int i11, String str) {
        }
    }

    static {
        String simpleName = a.class.getSimpleName();
        f22951b = simpleName;
        Log.d(simpleName, "添加BarragePresenter的Listener");
        HbBarrageManager.getInstance().addBarrageCallBack(f22954e);
    }

    public final void c(LiveListener liveListener) {
        f22952c.add(new WeakReference(liveListener));
    }

    public final View d(Context context, String str, int i11, boolean z11) {
        View view;
        f22958i = context;
        if (!z11 && x.b(f22956g, str) && (view = f22957h) != null) {
            return view;
        }
        f22956g = str;
        TUIBarrageButton tUIBarrageButton = new TUIBarrageButton(context, str, i11);
        f22957h = tUIBarrageButton;
        return tUIBarrageButton;
    }

    public final Context e() {
        return f22958i;
    }

    public final Bitmap f(Context context) {
        return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R$drawable.icon_community_user_header), ScreenUtil.dip2px(18.0f), ScreenUtil.dip2px(18.0f), false);
    }

    public final long g() {
        return f22960k;
    }

    public final b h() {
        WeakReference<b> weakReference = f22953d;
        if (weakReference != null) {
            return (b) weakReference.get();
        }
        return null;
    }

    public final String i() {
        return f22959j;
    }

    public final void j() {
        f22958i = null;
        f22956g = null;
        f22957h = null;
        f22955f.clear();
    }

    public final void k(Context context) {
        f22958i = context;
    }

    public final void l(long j11) {
        f22960k = j11;
    }

    public final void m(b bVar) {
        f22953d = new WeakReference<>(bVar);
    }

    public final void n(String str) {
        f22959j = str;
    }
}
