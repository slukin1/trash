package com.hbg.module.huobi.im.group.ui.barrage;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.hbg.module.huobi.im.group.ui.barrage.b;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.imsdk.common.IMLog;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuibarrage.R;
import com.tencent.qcloud.tuikit.tuibarrage.core.TUIBarrageExtension;
import com.tencent.qcloud.tuikit.tuibarrage.manager.HbBarrageManager;
import com.tencent.qcloud.tuikit.tuibarrage.manager.IHbBarrageManager;
import com.tencent.qcloud.tuikit.tuibarrage.manager.TUIBarrageCallBack;
import com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage;
import com.tencent.qcloud.tuikit.tuibarrage.view.ITUIBarrageButton;
import com.tencent.qcloud.tuikit.tuibarrage.view.ITUIBarrageListener;

public class TUIBarrageButton extends FrameLayout implements ITUIBarrageButton {

    /* renamed from: b  reason: collision with root package name */
    public Context f20312b;

    /* renamed from: c  reason: collision with root package name */
    public String f20313c;

    /* renamed from: d  reason: collision with root package name */
    public int f20314d;

    /* renamed from: e  reason: collision with root package name */
    public b f20315e;

    /* renamed from: f  reason: collision with root package name */
    public TUIBarrageDisplayView f20316f;

    /* renamed from: g  reason: collision with root package name */
    public ITUIBarrageListener f20317g;

    /* renamed from: h  reason: collision with root package name */
    public IHbBarrageManager f20318h;

    /* renamed from: i  reason: collision with root package name */
    public b.e f20319i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f20320j;

    public class a implements ITUIBarrageListener {
        public a() {
        }

        public void onFailed(int i11, String str) {
            IMLog.d(TUIBarrageExtension.KEY_SEND_VIEW, "message is " + str);
            if (i11 == 10016) {
                ToastUtil.toastLongMessage(TUIBarrageButton.this.getContext().getString(R.string.n_im_sensitive_word));
            } else if (i11 == 10017) {
                ToastUtil.toastLongMessage(TUIBarrageButton.this.getContext().getString(R.string.n_im_forbidden));
            } else if (i11 != 10102) {
                ToastUtil.toastLongMessage(str);
            } else {
                ToastUtil.toastLongMessage(TUIBarrageButton.this.getContext().getString(R.string.n_im_forbidden));
            }
        }

        public void onSuccess(int i11, TUIBarrageMessage tUIBarrageMessage) {
            if (tUIBarrageMessage == null) {
                IMLog.d(TUIBarrageExtension.KEY_SEND_VIEW, "message is null");
            } else {
                TUIBarrageButton.this.f20316f.receiveBarrage(tUIBarrageMessage);
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            TUIBarrageButton tUIBarrageButton = TUIBarrageButton.this;
            tUIBarrageButton.h(tUIBarrageButton.f20312b);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements f {
        public c() {
        }

        public void a(String str, String str2) {
            IMLog.d(TUIBarrageExtension.KEY_SEND_VIEW, "atSomeListener id:" + str + " name:" + str2);
            if (TUIBarrageButton.this.f20315e != null) {
                TUIBarrageButton.this.f20315e.d(str, str2);
                Context e11 = md.a.f22950a.e();
                if (e11 == null) {
                    e11 = TUIBarrageButton.this.f20312b;
                }
                TUIBarrageButton.this.h(e11);
            }
        }
    }

    public class d implements b.f {
        public d() {
        }

        public void onTextSend(String str) {
            TUIBarrageButton.this.sendBarrage(str);
        }
    }

    public class e extends TUIBarrageCallBack {
        public e() {
        }

        public void onFailed(int i11, String str) {
            if (TUIBarrageButton.this.f20317g != null) {
                TUIBarrageButton.this.f20317g.onFailed(i11, str);
            }
        }

        public void onTextCallback(int i11, TUIBarrageMessage tUIBarrageMessage) {
            if (TUIBarrageButton.this.f20317g != null) {
                TUIBarrageButton.this.f20317g.onSuccess(i11, tUIBarrageMessage);
            }
        }
    }

    public interface f {
        void a(String str, String str2);
    }

    public TUIBarrageButton(Context context) {
        super(context);
        this.f20314d = 0;
        this.f20320j = false;
    }

    public final void e() {
        HbBarrageManager instance = HbBarrageManager.getInstance();
        this.f20318h = instance;
        instance.init(this.f20313c);
    }

    public void f(Context context) {
        b bVar = new b(context);
        this.f20315e = bVar;
        bVar.i(new d());
        b.e eVar = this.f20319i;
        if (eVar != null) {
            this.f20315e.h(eVar);
        }
    }

    public final void g() {
        LayoutInflater.from(this.f20312b).inflate(R.layout.tuibarrage_view_send, this);
        f(this.f20312b);
        this.f20316f = new TUIBarrageDisplayView(this.f20312b, this.f20313c, this.f20314d);
        setBarrageListener(new a());
        findViewById(R.id.iv_linkto_send_dialog).setOnClickListener(new b());
        this.f20316f.setAtSomeoneListener(new c());
    }

    public TUIBarrageDisplayView getDisplayView() {
        return this.f20316f;
    }

    public void h(Context context) {
        if (this.f20312b != context) {
            this.f20312b = context;
            f(context);
        }
        if (!this.f20315e.isShowing()) {
            Context context2 = this.f20312b;
            if (!(context2 instanceof Activity) || !((Activity) context2).isFinishing()) {
                Window window = this.f20315e.getWindow();
                window.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                window.setAttributes(attributes);
                this.f20315e.getWindow().setSoftInputMode(4);
                this.f20315e.show();
                this.f20315e.e();
            }
        }
    }

    public void sendBarrage(String str) {
        if (this.f20318h == null) {
            e();
        }
        this.f20318h.sendTextBarrage(str, new e());
    }

    public void setBarrageListener(ITUIBarrageListener iTUIBarrageListener) {
        this.f20317g = iTUIBarrageListener;
    }

    public void setSendHideListener(b.e eVar) {
        this.f20319i = eVar;
        this.f20315e.h(eVar);
    }

    public TUIBarrageButton(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public TUIBarrageButton(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f20314d = 0;
        this.f20320j = false;
    }

    public TUIBarrageButton(Context context, String str, int i11) {
        this(context);
        this.f20312b = context;
        this.f20313c = str;
        this.f20314d = i11;
        g();
        e();
    }
}
