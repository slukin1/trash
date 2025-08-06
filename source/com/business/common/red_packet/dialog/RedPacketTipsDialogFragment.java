package com.business.common.red_packet.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.v;
import com.business.common.R$drawable;
import com.business.common.R$string;
import com.business.common.R$style;
import com.hbg.lib.network.hbg.core.bean.RedPacketInfoBean;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.helper.SensorsDataHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import i4.e;
import java.util.HashMap;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

public final class RedPacketTipsDialogFragment extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public final RedPacketInfoBean f64343b;

    /* renamed from: c  reason: collision with root package name */
    public e f64344c;

    public RedPacketTipsDialogFragment(RedPacketInfoBean redPacketInfoBean) {
        this.f64343b = redPacketInfoBean;
    }

    @SensorsDataInstrumented
    public static final void sh(RedPacketTipsDialogFragment redPacketTipsDialogFragment, View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("button_name", "open");
        String codeWord = redPacketTipsDialogFragment.f64343b.getCodeWord();
        if (codeWord == null) {
            codeWord = "";
        }
        hashMap.put("code", codeWord);
        SensorsDataHelper.track("webclick_app_activity", hashMap);
        n1 unused = i.d(v.a(redPacketTipsDialogFragment), (CoroutineContext) null, (CoroutineStart) null, new RedPacketTipsDialogFragment$onCreateView$1$1$1(redPacketTipsDialogFragment, (c<? super RedPacketTipsDialogFragment$onCreateView$1$1$1>) null), 3, (Object) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void th(RedPacketTipsDialogFragment redPacketTipsDialogFragment, View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("button_name", "close");
        String codeWord = redPacketTipsDialogFragment.f64343b.getCodeWord();
        if (codeWord == null) {
            codeWord = "";
        }
        hashMap.put("code", codeWord);
        SensorsDataHelper.track("webclick_app_activity", hashMap);
        redPacketTipsDialogFragment.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(false);
        setStyle(1, R$style.CenterDialogFragmentStyle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        e K = e.K(layoutInflater);
        this.f64344c = K;
        e eVar = null;
        if (K == null) {
            K = null;
        }
        AppCompatImageView appCompatImageView = K.F;
        String wholeUrl = this.f64343b.getWholeUrl();
        String str = "";
        if (wholeUrl == null) {
            wholeUrl = str;
        }
        b.N(appCompatImageView, wholeUrl, 16.0f, 0, R$drawable.icon_content_c2c_red_packet);
        AppCompatTextView appCompatTextView = K.J;
        String wishWord = this.f64343b.getWishWord();
        if (wishWord == null) {
            wishWord = str;
        }
        appCompatTextView.setText(wishWord);
        AppCompatTextView appCompatTextView2 = K.I;
        int i11 = R$string.n_c2c_red_packet_from;
        Object[] objArr = new Object[1];
        String userNick = this.f64343b.getUserNick();
        if (userNick != null) {
            str = userNick;
        }
        objArr[0] = str;
        appCompatTextView2.setText(getString(i11, objArr));
        K.H.setText(getString(R$string.n_c2c_red_packet_open));
        K.B.setOnClickListener(new a(this));
        K.G.setOnClickListener(new b(this));
        e eVar2 = this.f64344c;
        if (eVar2 != null) {
            eVar = eVar2;
        }
        return eVar.getRoot();
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    public void onStart() {
        Window window;
        Window window2;
        Window window3;
        Window window4;
        super.onStart();
        Dialog dialog = getDialog();
        if (!(dialog == null || (window4 = dialog.getWindow()) == null)) {
            window4.setGravity(17);
        }
        Dialog dialog2 = getDialog();
        if (!(dialog2 == null || (window3 = dialog2.getWindow()) == null)) {
            window3.setLayout(-1, -2);
        }
        Dialog dialog3 = getDialog();
        if (!(dialog3 == null || (window2 = dialog3.getWindow()) == null)) {
            window2.addFlags(2);
        }
        Dialog dialog4 = getDialog();
        if (!(dialog4 == null || (window = dialog4.getWindow()) == null)) {
            window.setDimAmount(0.5f);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("business_category", "c2chb");
        String codeWord = this.f64343b.getCodeWord();
        if (codeWord == null) {
            codeWord = "";
        }
        hashMap.put("code", codeWord);
        hashMap.put("window_name", "receive_cover");
        SensorsDataHelper.track("pageexposure_app_activity", hashMap);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public final void uh(FragmentManager fragmentManager) {
        show(fragmentManager, "RedPacketTipsDialogFragment");
    }
}
