package com.hbg.module.content.ui.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.hbg.module.content.R$string;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import ld.e;
import ld.f;

public class LiveGroupUserListView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public String f18279b;

    /* renamed from: c  reason: collision with root package name */
    public f f18280c;

    /* renamed from: d  reason: collision with root package name */
    public final int f18281d;

    /* renamed from: e  reason: collision with root package name */
    public int f18282e;

    public class a implements kd.a<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f18283a;

        public a(boolean z11) {
            this.f18283a = z11;
        }

        public void onFailed(int i11, String str) {
            ToastUtil.toastShortMessage(LiveGroupUserListView.this.getContext().getString(R$string.n_im_operation_fail));
        }

        public void onSuccess(Object obj) {
            if (this.f18283a) {
                ToastUtil.toastShortMessage(LiveGroupUserListView.this.getContext().getString(R$string.n_im_forbin_send_success));
            } else {
                ToastUtil.toastShortMessage(LiveGroupUserListView.this.getContext().getString(R$string.n_im_forbin_send_canceled));
            }
        }
    }

    public LiveGroupUserListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void setAllForbid(boolean z11) {
        this.f18280c.A(this.f18279b, z11 ? 1 : 0, new a(z11));
    }

    public void a() {
        setVisibility(8);
    }

    public boolean b() {
        return getVisibility() != 8;
    }

    public LiveGroupUserListView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f18280c = new f((e) null);
        this.f18281d = 1;
        this.f18282e = 1;
    }
}
