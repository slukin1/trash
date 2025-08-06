package com.hbg.module.content.ui.activity.live;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.LiveGroupUserListData;
import com.hbg.lib.network.hbg.core.bean.SearchLiveGroupUserList;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$style;
import com.hbg.module.content.adapter.l;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import java.util.List;
import kotlin.jvm.internal.r;
import lc.s0;
import rd.s;
import u6.g;

public final class GroupUserSearchDialog extends DialogFragment {

    /* renamed from: f  reason: collision with root package name */
    public static final a f18435f = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public String f18436b = "";

    /* renamed from: c  reason: collision with root package name */
    public int f18437c;

    /* renamed from: d  reason: collision with root package name */
    public l f18438d;

    /* renamed from: e  reason: collision with root package name */
    public LoadingLayout f18439e;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final GroupUserSearchDialog a(FragmentManager fragmentManager, String str, int i11) {
            FragmentTransaction q11;
            Fragment fragment;
            if (fragmentManager == null) {
                return null;
            }
            try {
                q11 = fragmentManager.q();
                fragment = fragmentManager.m0("GroupUserSearchDialog");
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
            GroupUserSearchDialog groupUserSearchDialog = new GroupUserSearchDialog();
            Bundle bundle = new Bundle();
            bundle.putString("groupId", str);
            bundle.putInt("currentUserRole", i11);
            groupUserSearchDialog.setArguments(bundle);
            q11.e(groupUserSearchDialog, "GroupUserSearchDialog");
            q11.k();
            return groupUserSearchDialog;
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18440b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18441c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Dialog f18442d;

        public b(View view, long j11, Dialog dialog) {
            this.f18440b = view;
            this.f18441c = j11;
            this.f18442d = dialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18440b) > this.f18441c || (this.f18440b instanceof Checkable)) {
                sVar.e(this.f18440b, currentTimeMillis);
                if (this.f18442d.isShowing()) {
                    this.f18442d.dismiss();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18443b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18444c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Dialog f18445d;

        public c(View view, long j11, Dialog dialog) {
            this.f18443b = view;
            this.f18444c = j11;
            this.f18445d = dialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18443b) > this.f18444c || (this.f18443b instanceof Checkable)) {
                sVar.e(this.f18443b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f18443b;
                if (this.f18445d.isShowing()) {
                    this.f18445d.dismiss();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GroupUserSearchDialog f18446b;

        public d(GroupUserSearchDialog groupUserSearchDialog) {
            this.f18446b = groupUserSearchDialog;
        }

        public void afterTextChanged(Editable editable) {
            if (!(editable.length() == 0)) {
                this.f18446b.vh(editable.toString());
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public static final class e implements TextView.OnEditorActionListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ s0 f18447b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ GroupUserSearchDialog f18448c;

        public e(s0 s0Var, GroupUserSearchDialog groupUserSearchDialog) {
            this.f18447b = s0Var;
            this.f18448c = groupUserSearchDialog;
        }

        public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
            boolean z11 = false;
            if (i11 != 3 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
                return false;
            }
            Editable text = this.f18447b.B.getText();
            if (text == null || text.length() == 0) {
                z11 = true;
            }
            if (z11) {
                this.f18447b.E.i();
            } else {
                this.f18448c.vh(this.f18447b.B.getText().toString());
            }
            return true;
        }
    }

    public static final class f extends BaseSubscriber<SearchLiveGroupUserList> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GroupUserSearchDialog f18449b;

        public f(GroupUserSearchDialog groupUserSearchDialog) {
            this.f18449b = groupUserSearchDialog;
        }

        /* renamed from: a */
        public void onNext(SearchLiveGroupUserList searchLiveGroupUserList) {
            super.onNext(searchLiveGroupUserList);
            List<LiveGroupUserListData.GroupUser> listData = searchLiveGroupUserList.getListData();
            if (listData == null || listData.isEmpty()) {
                LoadingLayout f12 = this.f18449b.f1();
                if (f12 != null) {
                    f12.i();
                    return;
                }
                return;
            }
            this.f18449b.sh().a(0, searchLiveGroupUserList.getListData());
            LoadingLayout f13 = this.f18449b.f1();
            if (f13 != null) {
                f13.g();
            }
        }

        public void onError(Throwable th2) {
            LoadingLayout f12 = this.f18449b.f1();
            if (f12 != null) {
                f12.i();
            }
        }
    }

    @SensorsDataInstrumented
    public static final void th(s0 s0Var, View view) {
        s0Var.B.setText("");
        s0Var.E.i();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void uh(s0 s0Var, GroupUserSearchDialog groupUserSearchDialog, View view) {
        Editable text = s0Var.B.getText();
        if (text == null || text.length() == 0) {
            s0Var.E.i();
        } else {
            groupUserSearchDialog.vh(s0Var.B.getText().toString());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final LoadingLayout f1() {
        return this.f18439e;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        View decorView;
        s0 K = s0.K(LayoutInflater.from(getActivity()));
        Dialog dialog = new Dialog(requireActivity());
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);
        dialog.requestWindowFeature(1);
        dialog.setContentView(K.getRoot());
        Window window = dialog.getWindow();
        if (!(window == null || (decorView = window.getDecorView()) == null)) {
            decorView.setPadding(0, 0, 0, 0);
        }
        l lVar = null;
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
        View view = K.H;
        view.setOnClickListener(new b(view, 800, dialog));
        ImageView imageView = K.C;
        imageView.setOnClickListener(new c(imageView, 800, dialog));
        K.B.addTextChangedListener(new d(this));
        K.D.setOnClickListener(new y(K));
        K.G.setOnClickListener(new z(K, this));
        K.B.setOnEditorActionListener(new e(K, this));
        String str = this.f18436b;
        if (str != null) {
            lVar = new l(requireActivity(), str, this.f18437c);
        }
        this.f18438d = lVar;
        K.F.setAdapter(lVar);
        K.F.setLayoutManager(com.hbg.module.libkt.base.ext.b.t(requireActivity()));
        this.f18439e = K.E;
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
        super.setArguments(bundle);
        if (!(bundle == null || (string = bundle.getString("groupId")) == null)) {
            this.f18436b = string;
        }
        if (bundle != null) {
            this.f18437c = bundle.getInt("currentUserRole");
        }
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public final l sh() {
        return this.f18438d;
    }

    public final void vh(String str) {
        v7.b.a().h(this.f18436b, str).b().compose(RxJavaHelper.t((g) null)).subscribe(new f(this));
    }
}
