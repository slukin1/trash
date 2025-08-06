package com.hbg.module.livesquare.adapter;

import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.LiveAppointmentData;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import d10.l;
import d9.a;
import kotlin.Unit;
import v7.b;
import we.c;

public final class CategoryListAdapter$llIntoClick$2$4 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LiveDetailBean f26432a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CategoryListAdapter f26433b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f26434c;

    public CategoryListAdapter$llIntoClick$2$4(LiveDetailBean liveDetailBean, CategoryListAdapter categoryListAdapter, int i11) {
        this.f26432a = liveDetailBean;
        this.f26433b = categoryListAdapter;
        this.f26434c = i11;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        a<LiveAppointmentData> K0 = b.a().K0(this.f26432a.f70249id.toString());
        final LiveDetailBean liveDetailBean = this.f26432a;
        final CategoryListAdapter categoryListAdapter = this.f26433b;
        final int i11 = this.f26434c;
        RequestExtKt.d(K0, new l<LiveAppointmentData, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LiveAppointmentData) obj);
                return Unit.f56620a;
            }

            public final void invoke(LiveAppointmentData liveAppointmentData) {
                if (liveAppointmentData != null) {
                    LiveDetailBean liveDetailBean = liveDetailBean;
                    CategoryListAdapter categoryListAdapter = categoryListAdapter;
                    int i11 = i11;
                    liveDetailBean.appointed = 0;
                    liveDetailBean.appointedNum = liveAppointmentData.getAppointedNum();
                    categoryListAdapter.notifyItemChanged(i11);
                    c.v(liveDetailBean);
                }
            }
        }, AnonymousClass2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
    }
}
