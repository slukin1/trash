package com.hbg.module.content.ui.activity.live;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.rxjava.RxJavaHelper;
import com.hbg.lib.widgets.R$dimen;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.R$string;
import com.hbg.module.content.R$style;
import com.huochat.community.R;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import com.tencent.android.tpush.common.Constants;
import java.util.HashMap;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.r;
import lc.o0;
import rd.s;

public final class GroupUserInfoDialog extends DialogFragment {

    /* renamed from: t  reason: collision with root package name */
    public static final a f18403t = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public String f18404b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f18405c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f18406d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f18407e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f18408f = "";

    /* renamed from: g  reason: collision with root package name */
    public int f18409g;

    /* renamed from: h  reason: collision with root package name */
    public int f18410h;

    /* renamed from: i  reason: collision with root package name */
    public int f18411i;

    /* renamed from: j  reason: collision with root package name */
    public int f18412j;

    /* renamed from: k  reason: collision with root package name */
    public int f18413k;

    /* renamed from: l  reason: collision with root package name */
    public int f18414l;

    /* renamed from: m  reason: collision with root package name */
    public LinearLayout f18415m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f18416n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f18417o;

    /* renamed from: p  reason: collision with root package name */
    public int f18418p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f18419q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f18420r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f18421s;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final GroupUserInfoDialog a(FragmentManager fragmentManager, String str, String str2, String str3, String str4, String str5, int i11, int i12, int i13, int i14, int i15, int i16, boolean z11, boolean z12, int i17) {
            FragmentTransaction q11;
            Fragment fragment;
            if (fragmentManager == null) {
                return null;
            }
            try {
                q11 = fragmentManager.q();
                fragment = fragmentManager.m0("GroupUserInfoDialog");
            } catch (NullPointerException e11) {
                e11.printStackTrace();
                fragment = null;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return null;
            }
            if (fragment != null) {
                q11.s(fragment);
            }
            GroupUserInfoDialog groupUserInfoDialog = new GroupUserInfoDialog();
            Bundle bundle = new Bundle();
            String str6 = str3;
            bundle.putString("avatar", str3);
            String str7 = str4;
            bundle.putString("nickName", str4);
            String str8 = str5;
            bundle.putString("uidUnique", str5);
            String str9 = str;
            bundle.putString("groupId", str);
            String str10 = str2;
            bundle.putString(Constants.FLAG_ACCOUNT, str2);
            int i18 = i11;
            bundle.putInt("focusNum", i11);
            int i19 = i12;
            bundle.putInt("fansNum", i12);
            bundle.putInt("dynamicNum", i13);
            bundle.putInt("focusStatus", i15);
            bundle.putInt("accessChat", i14);
            bundle.putInt("role", i16);
            bundle.putInt("currentUserRole", i17);
            bundle.putBoolean("isSelf", z11);
            bundle.putBoolean("isForbidden", z12);
            groupUserInfoDialog.setArguments(bundle);
            q11.e(groupUserInfoDialog, "GroupUserInfoDialog");
            q11.k();
            return groupUserInfoDialog;
        }
    }

    public static final class b extends BaseSubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GroupUserInfoDialog f18422b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f18423c;

        public b(GroupUserInfoDialog groupUserInfoDialog, FragmentActivity fragmentActivity) {
            this.f18422b = groupUserInfoDialog;
            this.f18423c = fragmentActivity;
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            if (th2 instanceof APIStatusErrorException) {
                this.f18422b.ii(this.f18423c, ((APIStatusErrorException) th2).getErrCode());
            } else if (th2 instanceof NullPointerException) {
                GroupUserInfoDialog groupUserInfoDialog = this.f18422b;
                FragmentActivity fragmentActivity = this.f18423c;
                groupUserInfoDialog.ii(fragmentActivity, fragmentActivity.getString(R$string.n_live_manage_user_been_kicked));
                Dialog dialog = this.f18422b.getDialog();
                if (dialog != null) {
                    dialog.dismiss();
                }
            } else {
                GroupUserInfoDialog groupUserInfoDialog2 = this.f18422b;
                groupUserInfoDialog2.ii(this.f18423c, groupUserInfoDialog2.getActivity().getResources().getString(R$string.n_service_error));
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
        }
    }

    public static final class c extends BaseSubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GroupUserInfoDialog f18424b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f18425c;

        public c(GroupUserInfoDialog groupUserInfoDialog, FragmentActivity fragmentActivity) {
            this.f18424b = groupUserInfoDialog;
            this.f18425c = fragmentActivity;
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            if (th2 instanceof APIStatusErrorException) {
                this.f18424b.ii(this.f18425c, ((APIStatusErrorException) th2).getErrCode());
            } else if (th2 instanceof NullPointerException) {
                GroupUserInfoDialog groupUserInfoDialog = this.f18424b;
                FragmentActivity fragmentActivity = this.f18425c;
                groupUserInfoDialog.ii(fragmentActivity, fragmentActivity.getString(R$string.n_live_manage_user_been_blacklist));
                Dialog dialog = this.f18424b.getDialog();
                if (dialog != null) {
                    dialog.dismiss();
                }
            } else {
                GroupUserInfoDialog groupUserInfoDialog2 = this.f18424b;
                groupUserInfoDialog2.ii(this.f18425c, groupUserInfoDialog2.getActivity().getResources().getString(R$string.n_service_error));
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
        }
    }

    public static final class d extends BaseSubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GroupUserInfoDialog f18426b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f18427c;

        public d(GroupUserInfoDialog groupUserInfoDialog, FragmentActivity fragmentActivity) {
            this.f18426b = groupUserInfoDialog;
            this.f18427c = fragmentActivity;
        }

        public void onError(Throwable th2) {
            CharSequence text;
            super.onError(th2);
            if (th2 instanceof APIStatusErrorException) {
                this.f18426b.ii(this.f18427c, ((APIStatusErrorException) th2).getErrCode());
            } else if (th2 instanceof NullPointerException) {
                TextView Vh = this.f18426b.Vh();
                boolean z11 = true;
                if (Vh == null || (text = Vh.getText()) == null || !text.equals(this.f18427c.getString(R$string.n_im_forbin_send_cancel))) {
                    z11 = false;
                }
                if (z11) {
                    GroupUserInfoDialog groupUserInfoDialog = this.f18426b;
                    FragmentActivity fragmentActivity = this.f18427c;
                    groupUserInfoDialog.ii(fragmentActivity, fragmentActivity.getString(R$string.n_live_manage_user_been_un_forbidden));
                    TextView Vh2 = this.f18426b.Vh();
                    if (Vh2 != null) {
                        Vh2.setText(this.f18426b.getActivity().getResources().getString(R$string.n_im_forbin_send));
                        return;
                    }
                    return;
                }
                GroupUserInfoDialog groupUserInfoDialog2 = this.f18426b;
                FragmentActivity fragmentActivity2 = this.f18427c;
                groupUserInfoDialog2.ii(fragmentActivity2, fragmentActivity2.getString(R$string.n_live_manage_user_been_forbidden));
                TextView Vh3 = this.f18426b.Vh();
                if (Vh3 != null) {
                    Vh3.setText(this.f18426b.getActivity().getResources().getString(R$string.n_im_forbin_send_cancel));
                }
            } else {
                GroupUserInfoDialog groupUserInfoDialog3 = this.f18426b;
                groupUserInfoDialog3.ii(this.f18427c, groupUserInfoDialog3.getActivity().getResources().getString(R$string.n_service_error));
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
        }
    }

    public static final class e extends BaseSubscriber<Boolean> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GroupUserInfoDialog f18428b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f18429c;

        public e(GroupUserInfoDialog groupUserInfoDialog, int i11) {
            this.f18428b = groupUserInfoDialog;
            this.f18429c = i11;
        }

        public void a(boolean z11) {
            String str;
            String str2;
            super.onNext(Boolean.valueOf(z11));
            if (z11) {
                if (this.f18429c == 1) {
                    str = this.f18428b.getActivity().getResources().getString(R$string.n_content_communityList_attentioned);
                } else {
                    str = this.f18428b.getActivity().getResources().getString(R$string.n_content_live_unfollow_confirm);
                }
                GroupUserInfoDialog groupUserInfoDialog = this.f18428b;
                groupUserInfoDialog.ii(groupUserInfoDialog.getActivity(), str);
                TextView Wh = this.f18428b.Wh();
                if (Wh != null) {
                    if (this.f18429c == 0) {
                        str2 = this.f18428b.getActivity().getResources().getString(com.hbg.module.huobi.im.R$string.n_content_community_userinfo_focus);
                    } else {
                        str2 = this.f18428b.getActivity().getResources().getString(com.hbg.module.huobi.im.R$string.n_content_live_unfollow);
                    }
                    Wh.setText(str2);
                }
                TextView Wh2 = this.f18428b.Wh();
                if (Wh2 != null) {
                    Wh2.setBackgroundResource(this.f18429c == 0 ? R$drawable.follow_selector : R$drawable.cancel_follow_selector);
                }
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            if (th2 instanceof APIStatusErrorException) {
                GroupUserInfoDialog groupUserInfoDialog = this.f18428b;
                groupUserInfoDialog.ii(groupUserInfoDialog.getActivity(), ((APIStatusErrorException) th2).getErrCode());
                return;
            }
            GroupUserInfoDialog groupUserInfoDialog2 = this.f18428b;
            groupUserInfoDialog2.ii(groupUserInfoDialog2.getActivity(), this.f18428b.getActivity().getResources().getString(R$string.n_service_error));
        }

        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            a(((Boolean) obj).booleanValue());
        }
    }

    public static final class f extends BaseSubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GroupUserInfoDialog f18430b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f18431c;

        public f(GroupUserInfoDialog groupUserInfoDialog, FragmentActivity fragmentActivity) {
            this.f18430b = groupUserInfoDialog;
            this.f18431c = fragmentActivity;
        }

        public void onError(Throwable th2) {
            CharSequence text;
            super.onError(th2);
            if (th2 instanceof APIStatusErrorException) {
                this.f18430b.ii(this.f18431c, ((APIStatusErrorException) th2).getErrCode());
            } else if (th2 instanceof NullPointerException) {
                TextView Xh = this.f18430b.Xh();
                boolean z11 = true;
                if (Xh == null || (text = Xh.getText()) == null || !text.equals(this.f18431c.getString(R$string.n_live_manage_set_as_manager))) {
                    z11 = false;
                }
                if (z11) {
                    GroupUserInfoDialog groupUserInfoDialog = this.f18430b;
                    FragmentActivity fragmentActivity = this.f18431c;
                    groupUserInfoDialog.ii(fragmentActivity, fragmentActivity.getString(R$string.n_live_manage_user_been_manager));
                    TextView Xh2 = this.f18430b.Xh();
                    if (Xh2 != null) {
                        Xh2.setText(this.f18430b.getActivity().getResources().getString(R$string.n_im_cancel_manager));
                        return;
                    }
                    return;
                }
                GroupUserInfoDialog groupUserInfoDialog2 = this.f18430b;
                FragmentActivity fragmentActivity2 = this.f18431c;
                groupUserInfoDialog2.ii(fragmentActivity2, fragmentActivity2.getString(R$string.n_live_manage_user_been_un_manager));
                TextView Xh3 = this.f18430b.Xh();
                if (Xh3 != null) {
                    Xh3.setText(this.f18430b.getActivity().getResources().getString(R$string.n_live_manage_set_as_manager));
                }
            } else {
                GroupUserInfoDialog groupUserInfoDialog3 = this.f18430b;
                groupUserInfoDialog3.ii(this.f18431c, groupUserInfoDialog3.getActivity().getResources().getString(R$string.n_service_error));
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
        }
    }

    public static final class g implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18432b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18433c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Dialog f18434d;

        public g(View view, long j11, Dialog dialog) {
            this.f18432b = view;
            this.f18433c = j11;
            this.f18434d = dialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18432b) > this.f18433c || (this.f18432b instanceof Checkable)) {
                sVar.e(this.f18432b, currentTimeMillis);
                if (this.f18434d.isShowing()) {
                    this.f18434d.dismiss();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final void Ih(GroupUserInfoDialog groupUserInfoDialog, FragmentActivity fragmentActivity, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        if (groupUserInfoDialog.f18407e != null && groupUserInfoDialog.f18408f != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("groupId", groupUserInfoDialog.f18407e);
            hashMap.put(Constants.FLAG_ACCOUNT, groupUserInfoDialog.f18408f);
            v7.b.a().removeUserInGroup(hashMap).b().compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new b(groupUserInfoDialog, fragmentActivity));
        }
    }

    public static final void Jh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
    }

    public static final void Kh(Ref$ObjectRef ref$ObjectRef) {
        TextView B0 = ((DialogUtils.b) ref$ObjectRef.element).B0();
        if (B0 != null) {
            B0.setTextColor(BaseApplication.a(R$color.global_main_text_color_light));
        }
        Button D0 = ((DialogUtils.b) ref$ObjectRef.element).D0();
        if (D0 != null) {
            D0.setTextSize(1, 14.0f);
        }
        Button E0 = ((DialogUtils.b) ref$ObjectRef.element).E0();
        if (E0 != null) {
            E0.setTextSize(1, 14.0f);
        }
        Button E02 = ((DialogUtils.b) ref$ObjectRef.element).E0();
        if (E02 != null) {
            E02.setTextColor(BaseApplication.a(R$color.white));
        }
    }

    public static final void Nh(GroupUserInfoDialog groupUserInfoDialog, FragmentActivity fragmentActivity, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        if (groupUserInfoDialog.f18407e != null && groupUserInfoDialog.f18408f != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("groupId", groupUserInfoDialog.f18407e);
            hashMap.put(Constants.FLAG_ACCOUNT, groupUserInfoDialog.f18408f);
            v7.b.a().blockUserInGroup(hashMap).b().compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new c(groupUserInfoDialog, fragmentActivity));
        }
    }

    public static final void Oh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
    }

    public static final void Ph(Ref$ObjectRef ref$ObjectRef) {
        TextView B0 = ((DialogUtils.b) ref$ObjectRef.element).B0();
        if (B0 != null) {
            B0.setTextColor(BaseApplication.a(R$color.global_main_text_color_light));
        }
        Button D0 = ((DialogUtils.b) ref$ObjectRef.element).D0();
        if (D0 != null) {
            D0.setTextSize(1, 14.0f);
        }
        Button E0 = ((DialogUtils.b) ref$ObjectRef.element).E0();
        if (E0 != null) {
            E0.setTextSize(1, 14.0f);
        }
        Button E02 = ((DialogUtils.b) ref$ObjectRef.element).E0();
        if (E02 != null) {
            E02.setTextColor(BaseApplication.a(R$color.white));
        }
    }

    public static final void Rh(GroupUserInfoDialog groupUserInfoDialog, Ref$IntRef ref$IntRef, FragmentActivity fragmentActivity, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        if (groupUserInfoDialog.f18407e != null && groupUserInfoDialog.f18408f != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("groupId", groupUserInfoDialog.f18407e);
            hashMap.put("memberAccount", groupUserInfoDialog.f18408f);
            if (ref$IntRef.element == 0) {
                hashMap.put("shutUpTime", 0);
            }
            v7.b.a().forbidInGroup(hashMap).b().compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new d(groupUserInfoDialog, fragmentActivity));
        }
    }

    public static final void Sh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
    }

    public static final void Th(DialogUtils.b bVar) {
        TextView B0 = bVar.B0();
        if (B0 != null) {
            B0.setTextColor(BaseApplication.a(R$color.global_main_text_color_light));
        }
        Button D0 = bVar.D0();
        if (D0 != null) {
            D0.setTextSize(1, 14.0f);
        }
        Button E0 = bVar.E0();
        if (E0 != null) {
            E0.setTextSize(1, 14.0f);
        }
        Button E02 = bVar.E0();
        if (E02 != null) {
            E02.setTextColor(BaseApplication.a(R$color.white));
        }
    }

    public static final void Zh(GroupUserInfoDialog groupUserInfoDialog, FragmentActivity fragmentActivity, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        if (groupUserInfoDialog.f18407e != null && groupUserInfoDialog.f18408f != null) {
            String str = groupUserInfoDialog.f18414l == 2 ? "0" : "1";
            HashMap hashMap = new HashMap();
            hashMap.put("groupId", groupUserInfoDialog.f18407e);
            hashMap.put(Constants.FLAG_ACCOUNT, groupUserInfoDialog.f18408f);
            hashMap.put("status", str);
            v7.b.a().setGroupManager(hashMap).b().compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new f(groupUserInfoDialog, fragmentActivity));
        }
    }

    public static final void ai(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
    }

    public static final void bi(Ref$ObjectRef ref$ObjectRef) {
        TextView B0 = ((DialogUtils.b) ref$ObjectRef.element).B0();
        if (B0 != null) {
            B0.setTextColor(BaseApplication.a(R$color.global_main_text_color_light));
        }
        Button D0 = ((DialogUtils.b) ref$ObjectRef.element).D0();
        if (D0 != null) {
            D0.setTextSize(1, 14.0f);
        }
        Button E0 = ((DialogUtils.b) ref$ObjectRef.element).E0();
        if (E0 != null) {
            E0.setTextSize(1, 14.0f);
        }
        Button E02 = ((DialogUtils.b) ref$ObjectRef.element).E0();
        if (E02 != null) {
            E02.setTextColor(BaseApplication.a(R$color.white));
        }
    }

    @SensorsDataInstrumented
    public static final void ci(GroupUserInfoDialog groupUserInfoDialog, View view) {
        groupUserInfoDialog.Uh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void di(GroupUserInfoDialog groupUserInfoDialog, View view) {
        dd.b.f22740a.h(groupUserInfoDialog.requireContext(), groupUserInfoDialog.f18408f, groupUserInfoDialog.f18405c);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void ei(GroupUserInfoDialog groupUserInfoDialog, View view) {
        groupUserInfoDialog.Qh(groupUserInfoDialog.requireActivity());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void fi(GroupUserInfoDialog groupUserInfoDialog, View view) {
        groupUserInfoDialog.Mh(groupUserInfoDialog.requireActivity());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void gi(GroupUserInfoDialog groupUserInfoDialog, View view) {
        groupUserInfoDialog.Hh(groupUserInfoDialog.requireActivity());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void hi(GroupUserInfoDialog groupUserInfoDialog, View view) {
        groupUserInfoDialog.Yh(groupUserInfoDialog.requireActivity());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Hh(FragmentActivity fragmentActivity) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        DialogUtils.b.d L0 = new DialogUtils.b.d(fragmentActivity).C0(fragmentActivity.getString(R$string.n_live_manage_confirm_kick)).c1(fragmentActivity.getString(R$string.n_all_cancel_title)).P0(fragmentActivity.getString(R$string.n_sure)).Q0(new u(this, fragmentActivity)).s0(fragmentActivity.getString(R$string.n_cancel)).q0(true).N0(j.f18647a).L0(Integer.valueOf(R$drawable.dialog_live_user));
        int i11 = R$color.baseColorPrimaryText;
        T m02 = L0.e1(Integer.valueOf(BaseApplication.a(i11))).d1(true).h1(Float.valueOf(getContext().getResources().getDimension(R$dimen.dimen_16))).r0(Integer.valueOf(BaseApplication.a(i11))).p0(Integer.valueOf(R.drawable.dialog_cancel_btn_selector)).B0(Integer.valueOf(R.drawable.dialog_confirm_btn_selector)).m0();
        ref$ObjectRef.element = m02;
        m02.y0(new m(ref$ObjectRef)).show(fragmentActivity.getSupportFragmentManager(), "");
    }

    public final void Mh(FragmentActivity fragmentActivity) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        DialogUtils.b.d L0 = new DialogUtils.b.d(fragmentActivity).L0(Integer.valueOf(R$color.white)).C0(fragmentActivity.getString(R$string.n_live_manage_confirm_blacklist)).c1(fragmentActivity.getString(R$string.n_all_cancel_title)).P0(fragmentActivity.getString(R$string.n_sure)).Q0(new w(this, fragmentActivity)).s0(fragmentActivity.getString(R$string.n_cancel)).q0(true).N0(k.f18650a).L0(Integer.valueOf(R$drawable.dialog_live_user));
        int i11 = R$color.baseColorPrimaryText;
        T m02 = L0.e1(Integer.valueOf(BaseApplication.a(i11))).d1(true).h1(Float.valueOf(getContext().getResources().getDimension(R$dimen.dimen_16))).r0(Integer.valueOf(BaseApplication.a(i11))).p0(Integer.valueOf(R.drawable.dialog_cancel_btn_selector)).B0(Integer.valueOf(R.drawable.dialog_confirm_btn_selector)).m0();
        ref$ObjectRef.element = m02;
        m02.y0(new n(ref$ObjectRef)).show(fragmentActivity.getSupportFragmentManager(), "");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0013, code lost:
        r3 = r3.getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Qh(androidx.fragment.app.FragmentActivity r7) {
        /*
            r6 = this;
            kotlin.jvm.internal.Ref$IntRef r0 = new kotlin.jvm.internal.Ref$IntRef
            r0.<init>()
            r1 = 1
            r0.element = r1
            int r2 = com.hbg.module.content.R$string.n_live_manage_confirm_forbidden_chat
            java.lang.String r2 = r7.getString(r2)
            android.widget.TextView r3 = r6.f18420r
            r4 = 0
            if (r3 == 0) goto L_0x0027
            java.lang.CharSequence r3 = r3.getText()
            if (r3 == 0) goto L_0x0027
            int r5 = com.hbg.module.content.R$string.n_im_forbin_send_cancel
            java.lang.String r5 = r7.getString(r5)
            boolean r3 = r3.equals(r5)
            if (r3 != r1) goto L_0x0027
            r3 = r1
            goto L_0x0028
        L_0x0027:
            r3 = r4
        L_0x0028:
            if (r3 == 0) goto L_0x0032
            int r2 = com.hbg.module.content.R$string.n_live_manage_confirm_un_forbidden_chat
            java.lang.String r2 = r7.getString(r2)
            r0.element = r4
        L_0x0032:
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r3 = new com.hbg.lib.widgets.dialog.DialogUtils$b$d
            r3.<init>(r7)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r2 = r3.C0(r2)
            int r3 = com.hbg.module.content.R$string.n_all_cancel_title
            java.lang.String r3 = r7.getString(r3)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r2 = r2.c1(r3)
            int r3 = com.hbg.module.content.R$string.n_sure
            java.lang.String r3 = r7.getString(r3)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r2 = r2.P0(r3)
            com.hbg.module.content.ui.activity.live.x r3 = new com.hbg.module.content.ui.activity.live.x
            r3.<init>(r6, r0, r7)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r2.Q0(r3)
            int r2 = com.hbg.module.content.R$string.n_cancel
            java.lang.String r2 = r7.getString(r2)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.s0(r2)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.q0(r1)
            com.hbg.module.content.ui.activity.live.h r2 = com.hbg.module.content.ui.activity.live.h.f18641a
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.N0(r2)
            int r2 = com.hbg.module.content.R$drawable.dialog_live_user
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.L0(r2)
            int r2 = com.hbg.module.content.R$color.baseColorPrimaryText
            int r3 = com.hbg.lib.common.BaseApplication.a(r2)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.e1(r3)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.d1(r1)
            android.content.Context r1 = r6.getContext()
            android.content.res.Resources r1 = r1.getResources()
            int r3 = com.hbg.lib.widgets.R$dimen.dimen_16
            float r1 = r1.getDimension(r3)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.h1(r1)
            int r1 = com.hbg.lib.common.BaseApplication.a(r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.r0(r1)
            int r1 = com.huochat.community.R.drawable.dialog_cancel_btn_selector
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.p0(r1)
            int r1 = com.huochat.community.R.drawable.dialog_confirm_btn_selector
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.B0(r1)
            com.hbg.lib.widgets.dialog.DialogUtils$b r0 = r0.m0()
            com.hbg.module.content.ui.activity.live.l r1 = new com.hbg.module.content.ui.activity.live.l
            r1.<init>(r0)
            com.hbg.lib.widgets.dialog.HBDialogFragment r0 = r0.y0(r1)
            androidx.fragment.app.FragmentManager r7 = r7.getSupportFragmentManager()
            java.lang.String r1 = ""
            r0.show(r7, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.content.ui.activity.live.GroupUserInfoDialog.Qh(androidx.fragment.app.FragmentActivity):void");
    }

    public final void Uh() {
        int i11 = this.f18413k == 0 ? 1 : 0;
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(i11));
        hashMap.put("uidUnique", this.f18406d);
        v7.b.a().requestCommunityAttention(hashMap).b().compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new e(this, i11));
    }

    public final TextView Vh() {
        return this.f18420r;
    }

    public final TextView Wh() {
        return this.f18421s;
    }

    public final TextView Xh() {
        return this.f18419q;
    }

    public final void Yh(FragmentActivity fragmentActivity) {
        CharSequence text;
        String string = fragmentActivity.getString(R$string.n_live_manage_confirm_manager);
        TextView textView = this.f18419q;
        boolean z11 = false;
        if (!(textView == null || (text = textView.getText()) == null || !text.equals(fragmentActivity.getString(R$string.n_im_cancel_manager)))) {
            z11 = true;
        }
        if (z11) {
            string = fragmentActivity.getString(R$string.n_live_manage_confirm_un_manager);
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        DialogUtils.b.d L0 = new DialogUtils.b.d(fragmentActivity).L0(Integer.valueOf(R$color.white)).C0(string).c1(fragmentActivity.getString(R$string.n_all_cancel_title)).P0(fragmentActivity.getString(R$string.n_sure)).Q0(new v(this, fragmentActivity)).s0(fragmentActivity.getString(R$string.n_cancel)).q0(true).N0(i.f18644a).L0(Integer.valueOf(R$drawable.dialog_live_user));
        int i11 = R$color.baseColorPrimaryText;
        T m02 = L0.e1(Integer.valueOf(BaseApplication.a(i11))).d1(true).h1(Float.valueOf(getContext().getResources().getDimension(R$dimen.dimen_16))).r0(Integer.valueOf(BaseApplication.a(i11))).p0(Integer.valueOf(R.drawable.dialog_cancel_btn_selector)).B0(Integer.valueOf(R.drawable.dialog_confirm_btn_selector)).m0();
        ref$ObjectRef.element = m02;
        m02.y0(new o(ref$ObjectRef)).show(fragmentActivity.getSupportFragmentManager(), "");
    }

    public final void ii(FragmentActivity fragmentActivity, String str) {
        na.b.e(fragmentActivity.getApplicationContext(), str, 1, R$layout.layout_live_toast, R$id.tv_live_toast, true).show();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        String str;
        LinearLayout linearLayout;
        View decorView;
        o0 K = o0.K(LayoutInflater.from(getActivity()));
        Dialog dialog = new Dialog(requireActivity());
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);
        dialog.requestWindowFeature(1);
        dialog.setContentView(K.getRoot());
        Window window = dialog.getWindow();
        if (!(window == null || (decorView = window.getDecorView()) == null)) {
            decorView.setPadding(0, 0, 0, 0);
        }
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (attributes != null) {
            attributes.height = -1;
        }
        if (attributes != null) {
            attributes.width = -1;
        }
        if (window != null) {
            window.setAttributes(attributes);
        }
        if (window != null) {
            window.setBackgroundDrawableResource(R$color.transparent);
        }
        if (window != null) {
            window.setWindowAnimations(R$style.bottom_dialog_animation);
        }
        s sVar = s.f23381a;
        View view = K.P;
        view.setOnClickListener(new g(view, 800, dialog));
        try {
            K.B.w(this.f18404b, com.hbg.module.huobi.im.R$drawable.icon_community_user_header);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        K.N.setText(this.f18405c);
        K.F.setText(String.valueOf(this.f18409g));
        K.K.setText(String.valueOf(this.f18410h));
        K.J.setText(String.valueOf(this.f18411i));
        this.f18415m = K.C;
        TextView textView = K.L;
        if (this.f18413k == 0) {
            str = getActivity().getResources().getString(com.hbg.module.huobi.im.R$string.n_content_community_userinfo_focus);
        } else {
            str = getActivity().getResources().getString(com.hbg.module.huobi.im.R$string.n_content_live_unfollow);
        }
        textView.setText(str);
        K.L.setBackgroundResource(this.f18413k == 0 ? R$drawable.follow_selector : R$drawable.cancel_follow_selector);
        K.L.setOnClickListener(new r(this));
        if (this.f18412j == 0) {
            K.H.setVisibility(8);
        } else {
            K.H.setVisibility(0);
            K.H.setOnClickListener(new p(this));
        }
        if (this.f18417o) {
            K.I.setText(getActivity().getResources().getString(R$string.n_im_forbin_send_cancel));
        } else {
            K.I.setText(getActivity().getResources().getString(R$string.n_im_forbin_send));
        }
        if (this.f18414l == 2) {
            K.O.setText(getActivity().getResources().getString(R$string.n_im_cancel_manager));
        } else {
            K.O.setText(getActivity().getResources().getString(R$string.n_live_manage_set_as_manager));
        }
        K.I.setOnClickListener(new s(this));
        K.G.setOnClickListener(new t(this));
        K.M.setOnClickListener(new g(this));
        K.O.setOnClickListener(new q(this));
        if (this.f18416n) {
            K.H.setVisibility(8);
            K.L.setVisibility(8);
        }
        if ((this.f18416n || this.f18414l == 3) && (linearLayout = this.f18415m) != null) {
            linearLayout.setVisibility(8);
        }
        this.f18420r = K.I;
        this.f18419q = K.O;
        this.f18421s = K.L;
        return dialog;
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

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setArguments(Bundle bundle) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        super.setArguments(bundle);
        if (!(bundle == null || (string5 = bundle.getString("avatar")) == null)) {
            this.f18404b = string5;
        }
        if (!(bundle == null || (string4 = bundle.getString("nickName")) == null)) {
            this.f18405c = string4;
        }
        if (!(bundle == null || (string3 = bundle.getString("uidUnique")) == null)) {
            this.f18406d = string3;
        }
        if (!(bundle == null || (string2 = bundle.getString("groupId")) == null)) {
            this.f18407e = string2;
        }
        if (!(bundle == null || (string = bundle.getString(Constants.FLAG_ACCOUNT)) == null)) {
            this.f18408f = string;
        }
        if (bundle != null) {
            this.f18409g = bundle.getInt("focusNum");
        }
        if (bundle != null) {
            this.f18410h = bundle.getInt("fansNum");
        }
        if (bundle != null) {
            this.f18411i = bundle.getInt("dynamicNum");
        }
        if (bundle != null) {
            this.f18412j = bundle.getInt("accessChat");
        }
        if (bundle != null) {
            this.f18413k = bundle.getInt("focusStatus");
        }
        if (bundle != null) {
            this.f18414l = bundle.getInt("role");
        }
        if (bundle != null) {
            this.f18416n = bundle.getBoolean("isSelf");
        }
        if (bundle != null) {
            this.f18417o = bundle.getBoolean("isForbidden");
        }
        if (bundle != null) {
            this.f18418p = bundle.getInt("currentUserRole");
        }
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }
}
