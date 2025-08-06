package com.huobi.sharev2.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.gson.Gson;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.network.hbg.core.bean.ShareConfig;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.invite.bean.InvitePosterItem;
import com.huobi.invite.bean.InvitePosterListItem;
import com.huobi.invite.bean.SharePlatformItem;
import com.huobi.invite.viewhandler.InvitePosterItemHandler;
import com.huobi.sharev2.bean.ShareInfo;
import com.huobi.sharev2.helper.NewShareChannelHelper;
import com.huobi.sharev2.helper.NewShareHelper;
import com.huobi.sharev2.helper.NewShareStatisticsUtils;
import com.huobi.sharev2.presenter.NewCommonSharePresenter;
import com.huobi.social.share.HBShareHelper;
import com.huobi.social.share.event.ShareBusEvent;
import com.huobi.utils.ImageUtils;
import com.huochat.community.util.ClipManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.imsdk.v2.V2TIMConversation;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import d10.l;
import i6.r;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import lr.j;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import sr.f;
import xr.i;

public class NewCommonShareFragment extends NewBaseShareFragment {
    public or.a A;
    public ScrollView B;
    public ImageView C;
    public ImageView D;
    public RelativeLayout E;
    public TextView F;
    public TextView G;
    public View H;
    public TextView I;
    public TextView J;
    public List<InvitePosterListItem> K = new ArrayList();
    public List<NewPreviewFragment> L = new ArrayList();
    public InvitePosterListItem M;
    public DialogInterface.OnDismissListener N;
    public long O = 0;
    public String P;
    public String Q;
    public NewCommonSharePresenter R;
    public HBShareHelper.HbPlatform S;
    public Bitmap T;
    public sr.f U;
    public Bitmap V;
    public boolean W;
    public TextView X;
    public TextView Y;
    public LinearLayout Z;

    /* renamed from: a0  reason: collision with root package name */
    public String f81072a0 = "";

    /* renamed from: b0  reason: collision with root package name */
    public String f81073b0 = "";

    /* renamed from: c0  reason: collision with root package name */
    public String f81074c0 = "";

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f81075d;

    /* renamed from: d0  reason: collision with root package name */
    public String f81076d0 = "";

    /* renamed from: e  reason: collision with root package name */
    public TextView f81077e;

    /* renamed from: e0  reason: collision with root package name */
    public String f81078e0 = "img";

    /* renamed from: f  reason: collision with root package name */
    public EasyRecyclerView<SharePlatformItem> f81079f;

    /* renamed from: f0  reason: collision with root package name */
    public int f81080f0 = 0;

    /* renamed from: g  reason: collision with root package name */
    public List<SharePlatformItem> f81081g;

    /* renamed from: g0  reason: collision with root package name */
    public SharePlatformItem.a f81082g0 = new rr.d(this);

    /* renamed from: h  reason: collision with root package name */
    public String f81083h;

    /* renamed from: h0  reason: collision with root package name */
    public InvitePosterItemHandler.a f81084h0 = new a();

    /* renamed from: i  reason: collision with root package name */
    public List<String> f81085i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public List<Bitmap> f81086j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public ShareInfo f81087k;

    /* renamed from: l  reason: collision with root package name */
    public Bitmap f81088l;

    /* renamed from: m  reason: collision with root package name */
    public String f81089m;

    /* renamed from: n  reason: collision with root package name */
    public String f81090n;

    /* renamed from: o  reason: collision with root package name */
    public String f81091o;

    /* renamed from: p  reason: collision with root package name */
    public String f81092p;

    /* renamed from: q  reason: collision with root package name */
    public String f81093q;

    /* renamed from: r  reason: collision with root package name */
    public String f81094r;

    /* renamed from: s  reason: collision with root package name */
    public String f81095s;

    /* renamed from: t  reason: collision with root package name */
    public ShareInfo.ShareType f81096t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f81097u;

    /* renamed from: v  reason: collision with root package name */
    public int f81098v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f81099w = false;

    /* renamed from: x  reason: collision with root package name */
    public boolean f81100x = true;

    /* renamed from: y  reason: collision with root package name */
    public View f81101y;

    /* renamed from: z  reason: collision with root package name */
    public ViewPager f81102z;

    public class a implements InvitePosterItemHandler.a {
        public a() {
        }

        public void a(InvitePosterListItem invitePosterListItem) {
            if (b(invitePosterListItem)) {
                InvitePosterListItem unused = NewCommonShareFragment.this.M = null;
            } else {
                InvitePosterListItem unused2 = NewCommonShareFragment.this.M = invitePosterListItem;
            }
        }

        public boolean b(InvitePosterListItem invitePosterListItem) {
            return NewCommonShareFragment.this.M != null && NewCommonShareFragment.this.M == invitePosterListItem;
        }
    }

    public class b implements z<String> {
        public b() {
        }

        /* renamed from: a */
        public void onChanged(String str) {
            NewShareStatisticsUtils.e(NewCommonShareFragment.this.f81072a0, str);
            if (!TextUtils.equals("fail", str)) {
                NewCommonShareFragment.this.dismiss();
                ToastUtil.toastShortMessage(NewCommonShareFragment.this.getString(R.string.n_share_result_success));
                return;
            }
            ToastUtil.toastShortMessage(NewCommonShareFragment.this.getString(R.string.n_share_result_fail));
        }
    }

    public class c implements ViewPager.OnPageChangeListener {
        public c() {
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            NewCommonShareFragment newCommonShareFragment = NewCommonShareFragment.this;
            InvitePosterListItem unused = newCommonShareFragment.M = (InvitePosterListItem) newCommonShareFragment.K.get(i11);
            Bitmap unused2 = NewCommonShareFragment.this.T = ((NewPreviewFragment) NewCommonShareFragment.this.L.get(i11)).qh();
        }
    }

    public class d implements ViewPager.OnPageChangeListener {
        public d() {
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            NewCommonShareFragment.this.ki(i11);
        }
    }

    public class e implements ViewTreeObserver.OnGlobalLayoutListener {
        public e() {
        }

        public void onGlobalLayout() {
            int lineCount = NewCommonShareFragment.this.f81077e.getLineCount();
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) NewCommonShareFragment.this.f81075d.getLayoutParams();
            if (lineCount <= 1) {
                layoutParams.height = NewCommonShareFragment.this.getResources().getDimensionPixelOffset(R.dimen.dimen_32);
            } else {
                layoutParams.height = NewCommonShareFragment.this.getResources().getDimensionPixelOffset(R.dimen.dimen_39);
            }
            NewCommonShareFragment.this.f81075d.setLayoutParams(layoutParams);
            NewCommonShareFragment.this.f81077e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public class f implements Action1<String> {
        public f() {
        }

        /* renamed from: a */
        public void call(String str) {
            String unused = NewCommonShareFragment.this.f81074c0 = i.r().I(NewCommonShareFragment.this.getActivity().getApplication(), com.huobi.sharev2.createimage.create.c.f81058a.b(NewCommonShareFragment.this.f81073b0, NewCommonShareFragment.this.getActivity().getApplication(), 0, 0), true);
            i6.d.i("shareThumbImageFile---=" + NewCommonShareFragment.this.f81074c0);
        }
    }

    public class g implements Action1<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f81109b;

        public g(String str) {
            this.f81109b = str;
        }

        /* renamed from: a */
        public void call(String str) {
            String unused = NewCommonShareFragment.this.f81076d0 = i.r().I(NewCommonShareFragment.this.getActivity().getApplication(), com.huobi.sharev2.createimage.create.c.f81058a.b(this.f81109b, NewCommonShareFragment.this.getActivity().getApplication(), 0, 0), true);
        }
    }

    public static class h implements f.c {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<NewCommonShareFragment> f81111a;

        public h(WeakReference<NewCommonShareFragment> weakReference) {
            this.f81111a = weakReference;
        }

        public void a(View view) {
            if (this.f81111a.get() != null) {
                ((NewCommonShareFragment) this.f81111a.get()).Xh();
            }
        }

        public void b(boolean z11) {
            ((NewCommonShareFragment) this.f81111a.get()).ii(z11);
        }

        public void c(View view) {
            if (this.f81111a.get() != null) {
                ((NewCommonShareFragment) this.f81111a.get()).Yh();
            }
        }

        public void d(View view) {
            SharePlatformItem sharePlatformItem = new SharePlatformItem();
            sharePlatformItem.setPlatform(HBShareHelper.HbPlatform.TYPE_COPY_TEXT);
            sharePlatformItem.setTitle(NewShareChannelHelper.d(sharePlatformItem.getPlatform(), view.getContext()));
            sharePlatformItem.setResourceId(NewShareChannelHelper.c(sharePlatformItem.getPlatform()));
            sharePlatformItem.setMain(true);
            if (this.f81111a.get() != null) {
                ((NewCommonShareFragment) this.f81111a.get()).f81082g0.i0(sharePlatformItem.getPlatform());
                NewShareStatisticsUtils.b(((NewCommonShareFragment) this.f81111a.get()).f81072a0, ((NewCommonShareFragment) this.f81111a.get()).f81078e0, -1);
            }
        }

        public void e(View view) {
            SharePlatformItem sharePlatformItem = new SharePlatformItem();
            sharePlatformItem.setPlatform(HBShareHelper.HbPlatform.TYPE_SAVE);
            sharePlatformItem.setTitle(NewShareChannelHelper.d(sharePlatformItem.getPlatform(), view.getContext()));
            sharePlatformItem.setResourceId(NewShareChannelHelper.c(sharePlatformItem.getPlatform()));
            sharePlatformItem.setMain(true);
            if (this.f81111a.get() != null) {
                ((NewCommonShareFragment) this.f81111a.get()).f81082g0.i0(sharePlatformItem.getPlatform());
                NewShareStatisticsUtils.b(((NewCommonShareFragment) this.f81111a.get()).f81072a0, ((NewCommonShareFragment) this.f81111a.get()).f81078e0, ((NewCommonShareFragment) this.f81111a.get()).f81102z.getCurrentItem());
            }
        }

        public void f(View view) {
            SharePlatformItem sharePlatformItem = new SharePlatformItem();
            sharePlatformItem.setPlatform(HBShareHelper.HbPlatform.TYPE_POSTER);
            sharePlatformItem.setTitle(NewShareChannelHelper.d(sharePlatformItem.getPlatform(), view.getContext()));
            sharePlatformItem.setResourceId(NewShareChannelHelper.c(sharePlatformItem.getPlatform()));
            sharePlatformItem.setMain(false);
            if (this.f81111a.get() != null) {
                ((NewCommonShareFragment) this.f81111a.get()).f81082g0.i0(sharePlatformItem.getPlatform());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void gi() {
        if (this.L.size() > 0 && this.K.size() > 0) {
            ShareInfo shareInfo = this.f81087k;
            int i11 = 0;
            if (shareInfo != null && shareInfo.getDefaultTab() == 0) {
                this.H.setVisibility(0);
            }
            if (this.L.size() > 2 && this.K.size() > 2) {
                i11 = 1;
            }
            this.f81102z.setCurrentItem(i11);
            ki(i11);
            NewPreviewFragment newPreviewFragment = this.L.get(i11);
            if (newPreviewFragment != null) {
                this.M = this.K.get(i11);
                this.T = newPreviewFragment.qh();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void hi(HBShareHelper.HbPlatform hbPlatform) {
        if (fi()) {
            NewShareStatisticsUtils.d(hbPlatform, this.f81072a0, this.f81078e0);
            l<? super Integer, Unit> shareCallback = this.f81087k.getShareCallback();
            if (shareCallback != null) {
                shareCallback.invoke(Integer.valueOf(hbPlatform.ordinal()));
            }
            String a11 = NewShareChannelHelper.a(!NewShareHelper.p(this.f81090n) ? this.f81090n : this.f81091o, this.f81089m);
            String m11 = NewShareHelper.j().m(!NewShareHelper.p(this.f81091o) ? this.f81091o : this.f81090n);
            ShareInfo.ShareType shareType = this.f81096t;
            if (shareType != ShareInfo.ShareType.SHARE_IMAGE_WITH_BASE64) {
                ShareInfo.ShareType shareType2 = ShareInfo.ShareType.SHARE_IMAGE_WITH_URLS;
                if (shareType == shareType2 || shareType == ShareInfo.ShareType.SHARE_IMAGE_WITH_BITMAPS) {
                    if (hbPlatform.equals(HBShareHelper.HbPlatform.TYPE_COPY_TEXT)) {
                        ClipManager.copy(Zh(hbPlatform));
                        HuobiToastUtil.r(requireContext().getString(R.string.n_replicated));
                    } else if (hbPlatform.equals(HBShareHelper.HbPlatform.TYPE_POSTER)) {
                        if (this.f81096t == shareType2) {
                            oi(hbPlatform, m11);
                        } else {
                            ni(hbPlatform, m11);
                        }
                    } else if (hbPlatform.equals(HBShareHelper.HbPlatform.TYPE_SAVE)) {
                        if (this.f81096t == ShareInfo.ShareType.SHARE_IMAGE_WITH_BITMAPS) {
                            if (this.f81097u) {
                                i.r().J(requireContext(), this.M, m11, this.V);
                            } else {
                                i.r().L(requireContext(), this.T, this.V);
                            }
                        } else if (this.f81097u) {
                            i.r().M(requireContext(), this.M, m11);
                        } else {
                            i.r().N(requireContext(), this.M, m11);
                        }
                    } else if (this.f81099w) {
                        if (this.f81096t == ShareInfo.ShareType.SHARE_IMAGE_WITH_BITMAPS) {
                            i.r().A(requireContext(), this.f81097u, hbPlatform, this.M, m11, this.V, ai(hbPlatform));
                        } else {
                            i.r().E(requireContext(), this.f81097u, hbPlatform, this.M, m11, this.V, ai(hbPlatform));
                        }
                    } else if (hbPlatform.equals(HBShareHelper.HbPlatform.TYPE_MORE)) {
                        i.r().G(requireContext(), hbPlatform, Zh(hbPlatform), this.f81074c0);
                    } else if (TextUtils.isEmpty(ai(hbPlatform))) {
                        i.r().H(requireContext(), hbPlatform, this.f81092p, Zh(hbPlatform), a11);
                    } else {
                        i.r().F(requireContext(), hbPlatform, Zh(hbPlatform), a11, ai(hbPlatform));
                    }
                } else if (shareType != ShareInfo.ShareType.SHARE_CONTENT) {
                } else {
                    if (hbPlatform.equals(HBShareHelper.HbPlatform.TYPE_COPY_TEXT)) {
                        ClipManager.copy(Zh(hbPlatform));
                        HuobiToastUtil.r(requireContext().getString(R.string.n_replicated));
                    } else if (hbPlatform.equals(HBShareHelper.HbPlatform.TYPE_MORE)) {
                        i.r().G(requireContext(), hbPlatform, Zh(hbPlatform), this.f81074c0);
                    } else if (TextUtils.isEmpty(ai(hbPlatform))) {
                        i.r().H(requireContext(), hbPlatform, this.f81092p, Zh(hbPlatform), a11);
                    } else {
                        i.r().F(requireContext(), hbPlatform, Zh(hbPlatform), a11, ai(hbPlatform));
                    }
                }
            } else if (hbPlatform.equals(HBShareHelper.HbPlatform.TYPE_SAVE)) {
                if (this.f81097u) {
                    i r11 = i.r();
                    Context requireContext = requireContext();
                    ShareInfo shareInfo = this.f81087k;
                    r11.K(requireContext, shareInfo, m11, shareInfo.getBase64Bitmap());
                    return;
                }
                wh(this.f81088l);
            } else if (hbPlatform.equals(HBShareHelper.HbPlatform.TYPE_COPY_TEXT)) {
                ClipManager.copy(Zh(hbPlatform));
                HuobiToastUtil.r(requireContext().getString(R.string.n_replicated));
            } else if (hbPlatform.equals(HBShareHelper.HbPlatform.TYPE_POSTER)) {
                this.f81099w = true;
                ShareInfo shareInfo2 = this.f81087k;
                if (shareInfo2 == null || shareInfo2.getBase64Bitmap() == null) {
                    this.S = hbPlatform;
                    NewCommonSharePresenter newCommonSharePresenter = this.R;
                    if (newCommonSharePresenter != null) {
                        newCommonSharePresenter.g(requireContext(), this.f81087k);
                        return;
                    }
                    return;
                }
                this.C.setImageBitmap(this.f81087k.getBase64Bitmap());
                this.B.setVisibility(0);
            } else if (this.f81099w) {
                i.r().u(requireContext(), hbPlatform, this.f81088l, ai(hbPlatform));
            } else if (hbPlatform.equals(HBShareHelper.HbPlatform.TYPE_MORE)) {
                i.r().G(requireContext(), hbPlatform, Zh(hbPlatform), this.f81074c0);
            } else if (TextUtils.isEmpty(ai(hbPlatform))) {
                i.r().H(requireContext(), hbPlatform, this.f81092p, Zh(hbPlatform), a11);
            } else if (TextUtils.isEmpty(this.f81076d0)) {
                i.r().F(requireContext(), hbPlatform, Zh(hbPlatform), a11, ai(hbPlatform));
            } else {
                i.r().C(requireContext(), hbPlatform, this.f81076d0, ai(hbPlatform));
            }
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void H9(Bitmap bitmap) {
        Log.d("NewBaseShareFragment", "loadImageSuccess");
        this.f81087k.setBase64Bitmap(bitmap);
        this.f81087k.setBase64BitmapRatio(((float) bitmap.getHeight()) / ((float) bitmap.getWidth()));
        is.a.y(this.f81087k.getExtend());
        this.f81101y.setVisibility(8);
        this.H.setVisibility(8);
        this.C.setImageBitmap(bitmap);
        if (this.f81097u) {
            if (!NewShareHelper.p(this.f81095s)) {
                this.F.setText(this.f81095s);
            }
            String str = !NewShareHelper.p(this.f81091o) ? this.f81091o : this.f81090n;
            Bitmap d11 = NewShareHelper.j().d(requireContext(), str);
            if (d11 != null) {
                this.D.setImageBitmap(d11);
            }
            if (TextUtils.isEmpty(this.f81089m)) {
                try {
                    Uri parse = Uri.parse(str);
                    String queryParameter = parse.getQueryParameter("inviteCode");
                    this.f81089m = queryParameter;
                    if (TextUtils.isEmpty(queryParameter)) {
                        this.f81089m = parse.getQueryParameter("invite_code");
                    }
                } catch (Throwable unused) {
                }
            }
            if (!TextUtils.isEmpty(this.f81089m)) {
                this.G.setText(String.format(getResources().getString(R.string.n_content_im_group_invitation_code), new Object[]{this.f81089m}));
                this.G.setVisibility(0);
            } else {
                this.G.setVisibility(8);
            }
            this.E.setVisibility(0);
            this.f81088l = ImageUtils.b(this.B);
        } else {
            this.f81088l = bitmap;
            this.E.setVisibility(8);
        }
        if (this.S.equals(HBShareHelper.HbPlatform.TYPE_POSTER)) {
            this.f81099w = true;
            ViewUtil.n(this.B, true);
        }
        if (this.f81080f0 == 0) {
            Xh();
        } else {
            Yh();
        }
    }

    public void M7(String str) {
        Log.d("NewBaseShareFragment", "loadImageFailure failure --> " + str);
    }

    public final void Vh() {
        this.f81077e.getViewTreeObserver().addOnGlobalLayoutListener(new e());
    }

    public final void Wh(List<String> list) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (NewShareHelper.o(this.f81100x, NewShareChannelHelper.b(list.get(i11)))) {
                arrayList.add(list.get(i11));
            }
        }
        ShareInfo shareInfo = this.f81087k;
        if (!(shareInfo == null || shareInfo.getExtendChannelList() == null)) {
            for (int i12 = 0; i12 < this.f81087k.getExtendChannelList().size(); i12++) {
                String str = this.f81087k.getExtendChannelList().get(i12);
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        ShareInfo shareInfo2 = this.f81087k;
        if (!(shareInfo2 == null || shareInfo2.getExtendMap() == null)) {
            wf.a aVar = wf.a.f40622a;
            if (aVar.d() && !arrayList.contains(V2TIMConversation.CONVERSATION_GROUP_TYPE) && this.f81087k.getExtendMap().get(V2TIMConversation.CONVERSATION_GROUP_TYPE) != null) {
                arrayList.add(V2TIMConversation.CONVERSATION_GROUP_TYPE);
            }
            if (aVar.c() && !arrayList.contains("community") && this.f81087k.getExtendMap().get("community") != null) {
                arrayList.add("community");
            }
        }
        this.f81081g = new ArrayList(arrayList.size());
        for (String str2 : arrayList) {
            if (NewShareChannelHelper.b(str2) != HBShareHelper.HbPlatform.NONE) {
                SharePlatformItem sharePlatformItem = new SharePlatformItem();
                sharePlatformItem.setPlatform(NewShareChannelHelper.b(str2));
                sharePlatformItem.setTitle(NewShareChannelHelper.d(sharePlatformItem.getPlatform(), getContext()));
                sharePlatformItem.setResourceId(NewShareChannelHelper.c(sharePlatformItem.getPlatform()));
                sharePlatformItem.setMain(true);
                sharePlatformItem.setCallback(this.f81082g0);
                sharePlatformItem.setClickCount(NewShareHelper.j().i(sharePlatformItem.getPlatform().toString()));
                this.f81081g.add(sharePlatformItem);
            }
        }
        SharePlatformItem sharePlatformItem2 = new SharePlatformItem();
        sharePlatformItem2.setPlatform(HBShareHelper.HbPlatform.TYPE_MORE);
        sharePlatformItem2.setTitle(NewShareChannelHelper.d(sharePlatformItem2.getPlatform(), getContext()));
        sharePlatformItem2.setResourceId(NewShareChannelHelper.c(sharePlatformItem2.getPlatform()));
        sharePlatformItem2.setMain(true);
        sharePlatformItem2.setCallback(this.f81082g0);
        this.f81081g.add(sharePlatformItem2);
        for (SharePlatformItem count : this.f81081g) {
            count.setCount(this.f81081g.size());
        }
        Collections.sort(this.f81081g);
        this.f81079f.setData(this.f81081g);
    }

    public final void Xh() {
        this.f81080f0 = 0;
        this.f81099w = true;
        this.f81100x = true;
        this.f81102z.setVisibility(0);
        PagerAdapter adapter = this.f81102z.getAdapter();
        if (adapter != null && adapter.getCount() > 0) {
            this.H.setVisibility(0);
        }
        if (this.f81088l != null) {
            this.B.setVisibility(0);
        }
        this.f81078e0 = "img";
        NewShareStatisticsUtils.f(this.f81072a0, "img");
        ShareInfo shareInfo = this.f81087k;
        if (shareInfo != null) {
            Wh(shareInfo.getChannelList());
        }
    }

    public final void Yh() {
        this.f81080f0 = 1;
        this.f81099w = false;
        this.f81100x = false;
        this.f81102z.setVisibility(8);
        this.H.setVisibility(8);
        this.B.setVisibility(8);
        this.f81078e0 = "url";
        NewShareStatisticsUtils.f(this.f81072a0, "url");
        ShareInfo shareInfo = this.f81087k;
        if (shareInfo != null) {
            Wh(shareInfo.getChannelList());
        }
    }

    public final String Zh(HBShareHelper.HbPlatform hbPlatform) {
        String str;
        String str2 = this.f81092p;
        if (NewShareHelper.p(str2)) {
            str2 = getString(R.string.n_share_default_ten_year);
        }
        if (!NewShareHelper.p(this.f81093q)) {
            if (NewShareHelper.l(this.f81093q) > 100.0d) {
                str = this.f81093q.substring(0, 100) + "...";
            } else {
                str = this.f81093q;
            }
            str2 = str2 + " " + str;
        }
        if (hbPlatform.equals(HBShareHelper.HbPlatform.TYPE_GROUP) || hbPlatform.equals(HBShareHelper.HbPlatform.TYPE_COMMUNITY) || hbPlatform.equals(HBShareHelper.HbPlatform.TYPE_TWITTER)) {
            return str2;
        }
        String a11 = NewShareChannelHelper.a(!NewShareHelper.p(this.f81090n) ? this.f81090n : this.f81091o, this.f81089m);
        StringBuilder sb2 = new StringBuilder();
        if (!NewShareHelper.p(str2)) {
            sb2.append(str2);
            sb2.append("\n");
        }
        sb2.append(a11);
        return sb2.toString();
    }

    public void addEvent(r rVar) {
        rVar.b(R.id.iv_share_close).setOnClickListener(new rr.c(this));
    }

    public void afterInit() {
        NewCommonSharePresenter newCommonSharePresenter = this.R;
        if (newCommonSharePresenter != null) {
            newCommonSharePresenter.e(this);
            this.R.h(this.f81087k);
            initView();
        }
    }

    public final String ai(HBShareHelper.HbPlatform hbPlatform) {
        ShareInfo shareInfo = this.f81087k;
        if (shareInfo == null || shareInfo.getExtendMap() == null) {
            return "";
        }
        if (hbPlatform == HBShareHelper.HbPlatform.TYPE_COMMUNITY) {
            return bi("community");
        }
        return hbPlatform == HBShareHelper.HbPlatform.TYPE_GROUP ? bi(V2TIMConversation.CONVERSATION_GROUP_TYPE) : "";
    }

    public final String bi(String str) {
        Object obj = this.f81087k.getExtendMap().get(str);
        if (obj == null) {
            return "";
        }
        if (!(obj instanceof Map)) {
            return obj.toString();
        }
        if (obj instanceof HashMap) {
            HashMap hashMap = (HashMap) obj;
            if (this.f81099w) {
                hashMap.put("fromPoster", 1);
            } else {
                hashMap.put("fromPoster", 0);
            }
        }
        return new Gson().toJson(obj);
    }

    public final void ci() {
        this.L.clear();
        for (int i11 = 0; i11 < this.K.size(); i11++) {
            NewPreviewFragment newPreviewFragment = (NewPreviewFragment) getChildFragmentManager().m0(String.valueOf(i11));
            if (newPreviewFragment == null) {
                newPreviewFragment = NewPreviewFragment.th(i11);
            }
            newPreviewFragment.vh(this.f81096t, this.K.get(i11), this.K.size());
            this.L.add(newPreviewFragment);
        }
    }

    public void da(ShareConfig shareConfig) {
        if (shareConfig.getState() == 0) {
            HuobiToastUtil.j(R.string.n_share_not_support_now);
            dismiss();
            return;
        }
        mi(this.f81087k);
        initView();
        di();
        i6.d.i("yangzhinan  shareConfig=" + shareConfig.toString());
        Wh(this.f81070b);
        int needLogin = shareConfig.getNeedLogin();
        boolean F0 = tg.r.x().F0();
        if (needLogin == 1 && !F0) {
            rn.c.i().d(requireActivity(), (kn.a) null);
        }
    }

    public void di() {
        Object obj;
        if (this.W) {
            ShareInfo shareInfo = this.f81087k;
            if (shareInfo == null || shareInfo.getTailBitmap() == null) {
                this.V = com.blankj.utilcode.util.ImageUtils.a(R.drawable.share_float_image);
            } else {
                this.V = this.f81087k.getTailBitmap();
            }
        }
        sr.f fVar = this.U;
        if (fVar != null) {
            fVar.m(this.f81087k);
        }
        if (!NewShareHelper.p(this.f81073b0)) {
            Observable.just("2222222").subscribeOn(Schedulers.io()).subscribe(new f());
        }
        ShareInfo shareInfo2 = this.f81087k;
        if (shareInfo2 != null && shareInfo2.getExtendMap() != null && (obj = this.f81087k.getExtendMap().get("community")) != null && (obj instanceof HashMap)) {
            String str = (String) ((HashMap) obj).get("shareBase64Image");
            if (!TextUtils.isEmpty(str)) {
                Observable.just("3333333").subscribeOn(Schedulers.io()).subscribe(new g(str));
            }
        }
    }

    public void dismiss() {
        super.dismiss();
    }

    public final void ei() {
        ci();
        if (this.f81102z != null) {
            this.A.b(this.f81096t, this.L, this.K);
            this.A.notifyDataSetChanged();
            this.f81102z.postDelayed(new rr.e(this), 20);
        }
    }

    public final boolean fi() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.O <= com.sumsub.sns.internal.ml.autocapture.a.f34923p) {
            return false;
        }
        this.O = currentTimeMillis;
        return true;
    }

    public int getContentViewResId() {
        return R.layout.fragment_common_share_new;
    }

    public int getGravity() {
        return 17;
    }

    public final void ii(boolean z11) {
        this.f81100x = !z11;
        this.Z.setVisibility(z11 ? 0 : 8);
    }

    public void initView(r rVar) {
        this.Z = (LinearLayout) rVar.b(R.id.show_content_layout);
        this.f81075d = (LinearLayout) rVar.b(R.id.banner_layout);
        this.f81077e = (TextView) rVar.b(R.id.banner_title);
        this.X = (TextView) rVar.b(R.id.show_share_content);
        this.Y = (TextView) rVar.b(R.id.show_share_link);
        EasyRecyclerView<SharePlatformItem> easyRecyclerView = (EasyRecyclerView) rVar.b(R.id.view_recycler_share_main);
        this.f81079f = easyRecyclerView;
        easyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.f81101y = rVar.b(R.id.viewpager_root);
        this.f81102z = (ViewPager) this.viewFinder.b(R.id.id_invite_share_platform_viewpager);
        this.B = (ScrollView) this.viewFinder.b(R.id.base64_Image_preview_layout);
        this.C = (ImageView) this.viewFinder.b(R.id.pine_image);
        this.D = (ImageView) this.viewFinder.b(R.id.share_img_qrcode);
        this.E = (RelativeLayout) this.viewFinder.b(R.id.share_img_bottom);
        this.F = (TextView) this.viewFinder.b(R.id.share_img_subtitle);
        this.G = (TextView) this.viewFinder.b(R.id.share_tv_invicode);
        this.H = this.viewFinder.b(R.id.pager_progress_bar);
        this.I = (TextView) this.viewFinder.b(R.id.pager_current_index_txt);
        this.J = (TextView) this.viewFinder.b(R.id.pager_count_txt);
        initViewPager();
        this.U = new sr.f(rVar.b(R.id.share_change_view));
        this.U.s(new h(new WeakReference(this)));
        we.b.l("share_event_back", String.class).observe(this, new b());
    }

    public final void initViewPager() {
        if (this.f81102z != null) {
            or.a aVar = new or.a(getChildFragmentManager());
            this.A = aVar;
            this.f81102z.setAdapter(aVar);
            ViewPager viewPager = this.f81102z;
            if (viewPager != null) {
                viewPager.setPageTransformer(false, new j(viewPager, 0.9f));
            }
            this.f81102z.setOffscreenPageLimit(this.L.size() - 1);
            this.f81102z.addOnPageChangeListener(new c());
            this.f81102z.addOnPageChangeListener(new d());
        }
    }

    public boolean isTransparent() {
        return true;
    }

    public void ji(DialogInterface.OnDismissListener onDismissListener) {
        this.N = onDismissListener;
    }

    public final void ki(int i11) {
        ViewPager viewPager = this.f81102z;
        if (viewPager != null && viewPager.getAdapter() != null) {
            TextView textView = this.I;
            textView.setText((i11 + 1) + "");
            TextView textView2 = this.J;
            textView2.setText(File.separator + this.f81102z.getAdapter().getCount());
        }
    }

    public void li(List<InvitePosterItem> list) {
        if (list != null && !list.isEmpty()) {
            this.K.clear();
            for (int i11 = 0; i11 < list.size(); i11++) {
                InvitePosterListItem invitePosterListItem = new InvitePosterListItem();
                invitePosterListItem.f(list.get(i11));
                invitePosterListItem.e(this.f81084h0);
                if (i11 == 1) {
                    this.M = invitePosterListItem;
                }
                this.K.add(invitePosterListItem);
            }
        }
    }

    public void mi(ShareInfo shareInfo) {
        this.f81087k = shareInfo;
        this.f81089m = shareInfo.getInviteCode();
        this.f81090n = shareInfo.getSource().equals("liveGroup") ? shareInfo.getQrUrl() : shareInfo.getShareUrl();
        this.f81091o = shareInfo.getQrUrl();
        this.f81092p = shareInfo.getShareText();
        this.f81093q = shareInfo.getShareContent();
        this.f81094r = shareInfo.getPosterTitle();
        this.f81095s = shareInfo.getPosterSubtitle();
        this.f81096t = shareInfo.getShareType();
        this.f81097u = !shareInfo.getSource().equals("liveGroup") && shareInfo.isShowNativeQr();
        this.P = shareInfo.getPageId();
        this.Q = shareInfo.getButtonId();
        this.f81083h = shareInfo.getFloatContent();
        this.f81085i = shareInfo.getImageUrls();
        this.f81098v = shareInfo.getIsInvite();
        this.f81070b = shareInfo.getChannelList();
        this.W = shareInfo.isShowTail();
        this.f81072a0 = shareInfo.getSource();
        this.f81073b0 = shareInfo.getShareThumbImage();
    }

    public final void ni(HBShareHelper.HbPlatform hbPlatform, String str) {
        this.S = hbPlatform;
        List<Bitmap> imageBitmaps = this.f81087k.getImageBitmaps();
        this.f81086j = imageBitmaps;
        if (imageBitmaps != null && imageBitmaps.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < this.f81086j.size(); i11++) {
                InvitePosterItem invitePosterItem = new InvitePosterItem();
                if (this.f81086j.get(i11) != null) {
                    invitePosterItem.setBytesFromBitmap(NewShareHelper.j().h(this.f81086j.get(i11)));
                }
                if (this.V != null) {
                    invitePosterItem.setBytesFloatBitmap(NewShareHelper.j().h(this.V));
                }
                String str2 = "";
                invitePosterItem.setMainTitle(!NewShareHelper.p(this.f81094r) ? this.f81094r : str2);
                invitePosterItem.setShowNativeQr(this.f81097u ? "true" : com.sumsub.sns.internal.core.analytics.d.f31895b);
                invitePosterItem.setQrUrl(str);
                invitePosterItem.setInviteCode(this.f81089m);
                if (!NewShareHelper.p(this.f81095s)) {
                    str2 = this.f81095s;
                }
                invitePosterItem.setSubTitle(str2);
                arrayList.add(invitePosterItem);
            }
            pi(arrayList);
        }
    }

    public final void oi(HBShareHelper.HbPlatform hbPlatform, String str) {
        this.S = hbPlatform;
        List<String> list = this.f81085i;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < this.f81085i.size(); i11++) {
                InvitePosterItem invitePosterItem = new InvitePosterItem();
                invitePosterItem.setImg(this.f81085i.get(i11));
                invitePosterItem.setShowNativeQr(this.f81097u ? "true" : com.sumsub.sns.internal.core.analytics.d.f31895b);
                invitePosterItem.setQrUrl(str);
                invitePosterItem.setInviteCode(this.f81089m);
                if (this.V != null) {
                    invitePosterItem.setBytesFloatBitmap(NewShareHelper.j().h(this.V));
                }
                String str2 = "";
                invitePosterItem.setMainTitle(!NewShareHelper.p(this.f81094r) ? this.f81094r : str2);
                if (!NewShareHelper.p(this.f81095s)) {
                    str2 = this.f81095s;
                }
                invitePosterItem.setSubTitle(str2);
                arrayList.add(invitePosterItem);
            }
            pi(arrayList);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f81101y.setVisibility(8);
        this.B.setVisibility(8);
        this.H.setVisibility(8);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.R = new NewCommonSharePresenter();
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    public void onBackShare(ShareBusEvent shareBusEvent) {
    }

    public void onDestroy() {
        super.onDestroy();
        NewCommonSharePresenter newCommonSharePresenter = this.R;
        if (newCommonSharePresenter != null) {
            newCommonSharePresenter.b();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.N;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    public void onPermissionsDenied(int i11, List<String> list) {
        Log.d("NewBaseShareFragment", "onPermissionsDenied --> requestCode:" + i11 + " permissions:" + list);
    }

    public void onPermissionsGranted(int i11, List<String> list) {
        Log.d("NewBaseShareFragment", "onPermissionsGranted --> requestCode:" + i11 + " permissions:" + list);
    }

    public void onResume() {
        super.onResume();
        NewShareStatisticsUtils.g(this.f81072a0);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public final void pi(ArrayList<InvitePosterItem> arrayList) {
        li(arrayList);
        ei();
        this.f81101y.setVisibility(0);
        this.H.setVisibility(0);
        if (this.S.equals(HBShareHelper.HbPlatform.TYPE_POSTER)) {
            boolean z11 = !this.f81099w;
            this.f81099w = z11;
            ViewUtil.n(this.f81101y, z11);
            ViewUtil.n(this.H, this.f81099w);
        }
    }

    public void v3(String str) {
        Log.d("NewBaseShareFragment", "request failure --> " + str);
        di();
        if (NewShareHelper.p(this.f81083h)) {
            this.f81075d.setVisibility(8);
        }
        Wh(this.f81070b);
    }

    public void xh() {
        super.xh();
    }

    public final void initView() {
        if (this.f81087k != null) {
            if (this.f81070b.size() <= 0) {
                xh();
            }
            if (NewShareHelper.p(this.P)) {
                Wh(this.f81070b);
            }
            if (!NewShareHelper.p(this.f81083h)) {
                this.f81075d.setVisibility(0);
                Vh();
                this.f81077e.setText(this.f81083h);
            } else {
                this.f81075d.setVisibility(8);
            }
            if (!NewShareHelper.p(this.f81092p)) {
                this.X.setText(this.f81092p);
            } else {
                this.X.setText(getString(R.string.n_share_default_ten_year));
            }
            if (!NewShareHelper.p(this.f81090n)) {
                this.Y.setText(this.f81090n);
            }
        }
    }
}
