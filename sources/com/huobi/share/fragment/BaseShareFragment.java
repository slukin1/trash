package com.huobi.share.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import bh.j;
import cn.sharesdk.telegram.Telegram;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.p;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.invite.bean.InvitePosterListItem;
import com.huobi.invite.bean.InviteSharePlatformListItem;
import com.huobi.invite.ui.AdapterHorizontalScrollView;
import com.huobi.social.share.HBShareHelper;
import com.huobi.social.share.event.ShareBusEvent;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import i6.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rx.Subscription;

public abstract class BaseShareFragment extends BaseDialogFragment implements InviteSharePlatformListItem.a, View.OnClickListener, EasyPermissions.PermissionCallbacks {

    /* renamed from: b  reason: collision with root package name */
    public Map<String, Object> f80868b;

    /* renamed from: c  reason: collision with root package name */
    public AdapterHorizontalScrollView f80869c;

    /* renamed from: d  reason: collision with root package name */
    public f f80870d;

    /* renamed from: e  reason: collision with root package name */
    public HBShareHelper f80871e;

    /* renamed from: f  reason: collision with root package name */
    public String f80872f;

    /* renamed from: g  reason: collision with root package name */
    public ShareBusEvent f80873g;

    /* renamed from: h  reason: collision with root package name */
    public View f80874h;

    /* renamed from: i  reason: collision with root package name */
    public View f80875i;

    /* renamed from: j  reason: collision with root package name */
    public View f80876j;

    /* renamed from: k  reason: collision with root package name */
    public float f80877k = ((float) PixelUtils.a(165.0f));

    /* renamed from: l  reason: collision with root package name */
    public HBShareHelper.HbPlatform f80878l;

    /* renamed from: m  reason: collision with root package name */
    public View f80879m;

    /* renamed from: n  reason: collision with root package name */
    public ViewPager f80880n;

    /* renamed from: o  reason: collision with root package name */
    public List<PreviewFragment> f80881o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    public List<InvitePosterListItem> f80882p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    public InvitePosterListItem f80883q;

    /* renamed from: r  reason: collision with root package name */
    public Subscription f80884r;

    /* renamed from: s  reason: collision with root package name */
    public String f80885s = "";

    /* renamed from: t  reason: collision with root package name */
    public String f80886t = "";

    /* renamed from: u  reason: collision with root package name */
    public String f80887u = "";

    /* renamed from: v  reason: collision with root package name */
    public String f80888v;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            BaseShareFragment.super.doDismiss();
        }
    }

    public class b extends bp.d {
        public b(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public int a(Fragment fragment) {
            return 0;
        }

        public int getCount() {
            return BaseShareFragment.this.f80881o.size();
        }

        public Fragment getItem(int i11) {
            PreviewFragment previewFragment = (PreviewFragment) BaseShareFragment.this.f80881o.get(i11);
            previewFragment.xh(BaseShareFragment.this.f80882p.get(i11));
            return previewFragment;
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
            for (int i12 = 0; i12 < BaseShareFragment.this.f80881o.size(); i12++) {
                if (i12 == i11) {
                    ((PreviewFragment) BaseShareFragment.this.f80881o.get(i12)).vh(true);
                    ((PreviewFragment) BaseShareFragment.this.f80881o.get(i12)).wh(false);
                    BaseShareFragment baseShareFragment = BaseShareFragment.this;
                    baseShareFragment.f80883q = baseShareFragment.f80882p.get(i11);
                } else {
                    ((PreviewFragment) BaseShareFragment.this.f80881o.get(i12)).vh(false);
                    ((PreviewFragment) BaseShareFragment.this.f80881o.get(i12)).wh(true);
                }
            }
        }
    }

    public class d implements MediaScannerConnection.OnScanCompletedListener {
        public d() {
        }

        public void onScanCompleted(String str, Uri uri) {
        }
    }

    public static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f80893a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huobi.social.share.HBShareHelper$HbPlatform[] r0 = com.huobi.social.share.HBShareHelper.HbPlatform.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f80893a = r0
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_WECHAT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f80893a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_WECHAT_MOMENTS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f80893a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_TELEGRAM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f80893a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_FACEBOOK     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f80893a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_TWITTER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f80893a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_COPY_TEXT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f80893a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_MORE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f80893a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.NONE     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.share.fragment.BaseShareFragment.e.<clinit>():void");
        }
    }

    public static class f extends BaseAdapter {

        /* renamed from: h  reason: collision with root package name */
        public static float f80894h = ((float) PixelUtils.a(165.0f));

        /* renamed from: i  reason: collision with root package name */
        public static float f80895i = ((float) PixelUtils.a(8.0f));

        /* renamed from: j  reason: collision with root package name */
        public static int f80896j;

        /* renamed from: b  reason: collision with root package name */
        public List<InviteSharePlatformListItem> f80897b;

        /* renamed from: c  reason: collision with root package name */
        public g6.b f80898c = g6.b.c();

        /* renamed from: d  reason: collision with root package name */
        public Context f80899d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f80900e;

        /* renamed from: f  reason: collision with root package name */
        public String f80901f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Object> f80902g;

        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: b  reason: collision with root package name */
            public float f80903b;

            /* renamed from: c  reason: collision with root package name */
            public float f80904c = 270.0f;

            /* renamed from: d  reason: collision with root package name */
            public float f80905d = ((-(f.f80895i + f.f80894h)) / this.f80904c);

            /* renamed from: e  reason: collision with root package name */
            public float f80906e = f.f80894h;

            /* renamed from: f  reason: collision with root package name */
            public float f80907f = (f.f80895i / this.f80904c);

            /* renamed from: g  reason: collision with root package name */
            public float f80908g = (f.f80895i * -2.0f);

            /* renamed from: h  reason: collision with root package name */
            public float f80909h;

            /* renamed from: i  reason: collision with root package name */
            public float f80910i;

            /* renamed from: j  reason: collision with root package name */
            public float f80911j = (1.0f / this.f80904c);

            /* renamed from: k  reason: collision with root package name */
            public final /* synthetic */ b f80912k;

            public a(b bVar) {
                this.f80912k = bVar;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedValue() instanceof Float) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.f80903b = floatValue;
                    if (Float.compare(floatValue, this.f80904c) <= 0) {
                        float f11 = this.f80911j;
                        float f12 = this.f80903b;
                        this.f80910i = f11 * f12;
                        this.f80909h = this.f80906e + (this.f80905d * f12);
                    } else {
                        this.f80910i = 1.0f;
                        this.f80909h = (this.f80907f * this.f80903b) + this.f80908g;
                    }
                    this.f80912k.f80916c.setAlpha(this.f80910i);
                    this.f80912k.f80916c.setTranslationY(this.f80909h);
                }
            }
        }

        public class b {

            /* renamed from: a  reason: collision with root package name */
            public ImageView f80914a;

            /* renamed from: b  reason: collision with root package name */
            public TextView f80915b;

            /* renamed from: c  reason: collision with root package name */
            public View f80916c;

            /* renamed from: d  reason: collision with root package name */
            public View f80917d;

            public b(View view) {
                this.f80916c = view;
                this.f80914a = (ImageView) view.findViewById(R.id.id_invite_share_platform_list_item_iv);
                this.f80915b = (TextView) view.findViewById(R.id.id_invite_share_platform_list_item_tv);
                this.f80917d = view.findViewById(R.id.id_invite_share_platform_list_item_cover);
            }
        }

        public f(Context context, List<InviteSharePlatformListItem> list, String str) {
            this.f80899d = context;
            this.f80897b = list;
            this.f80901f = str;
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void e(InviteSharePlatformListItem inviteSharePlatformListItem, View view) {
            InviteSharePlatformListItem.a aVar = inviteSharePlatformListItem.callback;
            if (aVar != null) {
                aVar.i0(inviteSharePlatformListItem.type);
                f(inviteSharePlatformListItem);
            } else {
                HuobiToastUtil.k(j.c(), R.string.n_share_not_support_function);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* renamed from: d */
        public InviteSharePlatformListItem getItem(int i11) {
            List<InviteSharePlatformListItem> list = this.f80897b;
            if (list == null) {
                return null;
            }
            return list.get(i11);
        }

        public final void f(InviteSharePlatformListItem inviteSharePlatformListItem) {
            String str;
            try {
                String str2 = "";
                switch (e.f80893a[inviteSharePlatformListItem.type.ordinal()]) {
                    case 1:
                        str2 = "3141";
                        str = "Wechat";
                        break;
                    case 2:
                        str2 = "3142";
                        str = "Moments";
                        break;
                    case 3:
                        str2 = "3143";
                        str = Telegram.NAME;
                        break;
                    case 4:
                        str2 = "5449";
                        str = "Facebook";
                        break;
                    case 5:
                        str = "Twitter";
                        break;
                    case 6:
                        str = "CopyText";
                        break;
                    case 7:
                        str = "More";
                        break;
                    case 8:
                        str2 = "3144";
                        str = "Save";
                        break;
                    default:
                        str = str2;
                        break;
                }
                if (!TextUtils.isEmpty(str2)) {
                    is.a.i(str2, is.a.e());
                }
                if (!TextUtils.isEmpty(str)) {
                    HashMap hashMap = new HashMap();
                    Map<String, Object> map = this.f80902g;
                    if (map != null && map.size() > 0) {
                        for (String next : this.f80902g.keySet()) {
                            hashMap.put(next, this.f80902g.get(next).toString());
                        }
                        hashMap.put("share_way", str);
                        hashMap.put("share_value_content", this.f80901f);
                        g.i("app_share_pop_way_share_bill_click", hashMap);
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        public void g(Map<String, Object> map) {
            this.f80902g = map;
        }

        public int getCount() {
            List<InviteSharePlatformListItem> list = this.f80897b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public long getItemId(int i11) {
            return (long) i11;
        }

        public View getView(int i11, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(this.f80899d).inflate(R.layout.layout_invite_share_platform_list_item, viewGroup, false);
                bVar = new b(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (i11 == 0) {
                f80896j = 0;
            }
            InviteSharePlatformListItem d11 = getItem(i11);
            bVar.f80914a.setImageResource(d11.imgResId);
            bVar.f80916c.setAlpha(0.0f);
            bVar.f80915b.setText(d11.title);
            nb.c.k(bVar.f80917d, new lr.f(this, d11));
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 500.0f});
            ofFloat.addUpdateListener(new a(bVar));
            ofFloat.setDuration(500);
            ofFloat.setInterpolator(new b6.a(0.0d, 0.0d, 0.58d, 1.0d));
            ofFloat.setStartDelay((long) f80896j);
            f80896j += 40;
            ofFloat.start();
            return view;
        }

        public void h(boolean z11) {
            this.f80900e = z11;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ih(int i11, boolean z11, InvitePosterListItem invitePosterListItem) {
        for (int i12 = 0; i12 < this.f80881o.size(); i12++) {
            if (i12 != i11) {
                this.f80881o.get(i12).vh(false);
                this.f80883q = invitePosterListItem;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Jh() {
        if (this.f80881o.size() > 0 && this.f80882p.size() > 0) {
            this.f80880n.setCurrentItem(1);
        }
    }

    public static /* synthetic */ void Kh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        HuobiToastUtil.s(R.string.otc_saveimage_path_faild_text);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Lh(HBDialogFragment hBDialogFragment) {
        if (!isAdded()) {
            hBDialogFragment.dismiss();
            return;
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", j.c().getPackageName(), (String) null));
        startActivity(intent);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f80874h, View.TRANSLATION_Y, new float[]{0.0f, this.f80877k});
        ofFloat.setInterpolator(new b6.a(0.0d, 0.0d, 0.58d, 1.0d));
        ofFloat.addListener(new a());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f80874h, View.ALPHA, new float[]{1.0f, 0.0f});
        ofFloat2.setInterpolator(new DecelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(260);
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.start();
    }

    public void Bh() {
        this.f80874h.setAlpha(1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f80874h, View.TRANSLATION_Y, new float[]{this.f80877k, 0.0f});
        ofFloat.setDuration(270);
        ofFloat.setInterpolator(new b6.a(0.0d, 0.0d, 0.58d, 1.0d));
        ofFloat.start();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Ch(java.lang.String r7, android.graphics.Bitmap r8) {
        /*
            r6 = this;
            if (r8 == 0) goto L_0x00a8
            com.huobi.social.share.HBShareHelper r0 = r6.f80871e
            if (r0 != 0) goto L_0x0008
            goto L_0x00a8
        L_0x0008:
            r0 = 1
            r1 = 0
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x002b }
            java.lang.String r3 = r2.name()     // Catch:{ Exception -> 0x002b }
            com.huobi.social.share.HBShareHelper$HbPlatform r4 = r6.f80878l     // Catch:{ Exception -> 0x002b }
            if (r4 == 0) goto L_0x001f
            com.huobi.social.share.HBShareHelper$HbPlatform r5 = com.huobi.social.share.HBShareHelper.HbPlatform.NONE     // Catch:{ Exception -> 0x002b }
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x002b }
            if (r4 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r4 = r1
            goto L_0x0020
        L_0x001f:
            r4 = r0
        L_0x0020:
            java.io.File r3 = com.hbg.lib.common.utils.FileUtil.f(r3, r4)     // Catch:{ Exception -> 0x002b }
            java.lang.String r8 = com.huobi.utils.ImageUtils.h(r8, r2, r3)     // Catch:{ Exception -> 0x002b }
            r6.f80872f = r8     // Catch:{ Exception -> 0x002b }
            goto L_0x002f
        L_0x002b:
            r8 = move-exception
            i6.d.g(r8)
        L_0x002f:
            com.huobi.social.share.HBShareHelper$HbPlatform r8 = r6.f80878l
            r2 = 0
            if (r8 == 0) goto L_0x0046
            com.huobi.social.share.HBShareHelper$HbPlatform r3 = com.huobi.social.share.HBShareHelper.HbPlatform.NONE
            boolean r8 = r8.equals(r3)
            if (r8 == 0) goto L_0x003d
            goto L_0x0046
        L_0x003d:
            com.huobi.social.share.HBShareHelper r8 = r6.f80871e
            java.lang.String r0 = r6.f80872f
            r8.g(r7, r0, r2)
            goto L_0x00a8
        L_0x0046:
            int r7 = android.os.Build.VERSION.SDK_INT
            r8 = 33
            if (r7 < r8) goto L_0x0053
            java.lang.String r7 = "android.permission.READ_MEDIA_IMAGES"
            java.lang.String[] r7 = new java.lang.String[]{r7}
            goto L_0x005b
        L_0x0053:
            java.lang.String r7 = "android.permission.READ_EXTERNAL_STORAGE"
            java.lang.String r8 = "android.permission.WRITE_EXTERNAL_STORAGE"
            java.lang.String[] r7 = new java.lang.String[]{r7, r8}
        L_0x005b:
            androidx.fragment.app.FragmentActivity r8 = r6.getActivity()
            if (r8 == 0) goto L_0x0087
            androidx.fragment.app.FragmentActivity r8 = r6.getActivity()
            boolean r8 = com.hbg.lib.core.permissions.EasyPermissions.hasPermissions(r8, r7)
            if (r8 == 0) goto L_0x0087
            androidx.fragment.app.FragmentActivity r7 = r6.getActivity()
            java.lang.String[] r8 = new java.lang.String[r0]
            java.lang.String r0 = r6.f80872f
            r8[r1] = r0
            com.huobi.share.fragment.BaseShareFragment$d r0 = new com.huobi.share.fragment.BaseShareFragment$d
            r0.<init>()
            android.media.MediaScannerConnection.scanFile(r7, r8, r2, r0)
            r7 = 2132026486(0x7f142476, float:1.9691506E38)
            com.hbg.lib.widgets.utils.HuobiToastUtil.s(r7)
            r6.dismiss()
            goto L_0x00a8
        L_0x0087:
            int r8 = r7.length
            r2 = r1
            r3 = r2
        L_0x008a:
            if (r2 >= r8) goto L_0x009d
            r4 = r7[r2]
            if (r3 != 0) goto L_0x0099
            boolean r3 = com.hbg.lib.core.permissions.EasyPermissions.shouldShowRequestPermissionRationale(r6, r4)
            if (r3 == 0) goto L_0x0097
            goto L_0x0099
        L_0x0097:
            r3 = r1
            goto L_0x009a
        L_0x0099:
            r3 = r0
        L_0x009a:
            int r2 = r2 + 1
            goto L_0x008a
        L_0x009d:
            if (r3 != 0) goto L_0x00a3
            r6.Rh()
            goto L_0x00a8
        L_0x00a3:
            r8 = 126(0x7e, float:1.77E-43)
            com.hbg.lib.core.permissions.EasyPermissions.requestPermissions(r6, r8, r7)
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.share.fragment.BaseShareFragment.Ch(java.lang.String, android.graphics.Bitmap):void");
    }

    public void Dh(String str, String str2, String str3) {
        HBShareHelper hBShareHelper;
        if (str3 != null && (hBShareHelper = this.f80871e) != null) {
            hBShareHelper.i(str, str2, str3);
        }
    }

    public String Eh(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String lowerCase = p.a(getContext()).toLowerCase();
        return " https://www.huobi.com/" + lowerCase + "/";
    }

    public Subscription Fh() {
        return this.f80884r;
    }

    public void Gh() {
        View view;
        if (AppLanguageHelper.getInstance().isChineseLanguage() && (view = this.f80879m) != null) {
            View view2 = (View) view.getParent();
            if (view2.getVisibility() == 0 && !gj.d.n().D()) {
                view2.setVisibility(8);
            }
        }
    }

    public boolean Hh() {
        int o11 = gj.d.o(getTag());
        if (o11 == 0) {
            return true;
        }
        return gj.d.n().t(o11, true);
    }

    public void Mh(String str) {
        this.f80885s = str;
    }

    public void Nh(String str) {
        this.f80886t = str;
    }

    public void Oh(Map<String, Object> map) {
        this.f80868b = map;
        f fVar = this.f80870d;
        if (fVar != null) {
            fVar.g(map);
        }
    }

    public void Ph(Subscription subscription) {
        this.f80884r = subscription;
    }

    public void Qh(String str) {
        this.f80888v = str;
    }

    public void Rh() {
        if (getActivity() != null) {
            DialogUtils.c0(getActivity(), getResources().getString(R.string.share_content_tip), (String) null, getResources().getString(R.string.share_cancel), getResources().getString(R.string.share_ok), lr.c.f58052a, new lr.b(this));
        }
    }

    public void addEvent(r rVar) {
        this.f80876j.setOnClickListener(this);
        this.f80875i.setOnClickListener(new lr.a(this));
        Bh();
    }

    public void afterInit() {
        EventBus.d().p(this);
        g.i("app_share_pop_expose", (HashMap) null);
        initData();
    }

    public boolean contentViewIsFullScreen() {
        return true;
    }

    public void doContentViewHideAnimation(View view) {
        if (isRunDefaultAnimation()) {
            Ah();
        } else {
            doDismiss();
        }
    }

    public void doDismiss() {
        if (getFragmentManager() != null) {
            super.doDismiss();
        }
    }

    public int getGravity() {
        return 17;
    }

    public void i0(HBShareHelper.HbPlatform hbPlatform) {
        this.f80878l = hbPlatform;
        this.f80871e = new HBShareHelper(getActivity(), hbPlatform);
        if (hbPlatform == HBShareHelper.HbPlatform.NONE) {
            g.i("App_bussiness_share_pop_save_click", (HashMap) null);
        } else if (hbPlatform == HBShareHelper.HbPlatform.TYPE_MORE) {
            g.i("App_bussiness_share_pop_share_now_click", (HashMap) null);
        }
    }

    public final void initData() {
        ArrayList arrayList = new ArrayList();
        boolean Hh = Hh();
        Gh();
        zh(arrayList);
        arrayList.add(new InviteSharePlatformListItem(HBShareHelper.HbPlatform.NONE, R.drawable.screenshot_save_icon, getString(R.string.n_share_save_image), this));
        if (!TextUtils.isEmpty(this.f80886t)) {
            arrayList.add(new InviteSharePlatformListItem(HBShareHelper.HbPlatform.TYPE_COPY_TEXT, R.drawable.copy_img_icon, getString(R.string.n_red_envelope_copy_url), this));
        }
        if (Hh) {
            arrayList.add(new InviteSharePlatformListItem(HBShareHelper.HbPlatform.TYPE_MORE, R.drawable.screenshot_share_icon, getString(R.string.n_share_sys_share), this));
        } else {
            arrayList.add(new InviteSharePlatformListItem(HBShareHelper.HbPlatform.TYPE_MORE, R.drawable.share_more_icon_un_new, getString(R.string.n_share_sys_share), (InviteSharePlatformListItem.a) null));
        }
        f fVar = new f(getActivity(), arrayList, this.f80888v);
        this.f80870d = fVar;
        fVar.h(Hh);
        this.f80869c.setAdapter(this.f80870d);
        Map<String, Object> map = this.f80868b;
        if (map != null) {
            this.f80870d.g(map);
        }
        this.f80881o.clear();
        for (int i11 = 0; i11 < this.f80882p.size(); i11++) {
            PreviewFragment previewFragment = (PreviewFragment) getChildFragmentManager().m0(String.valueOf(i11));
            if (previewFragment == null) {
                previewFragment = PreviewFragment.th(i11);
            }
            previewFragment.xh(this.f80882p.get(i11));
            previewFragment.uh(new lr.d(this));
            this.f80881o.add(previewFragment);
        }
        ViewPager viewPager = this.f80880n;
        if (viewPager != null) {
            viewPager.setAdapter(new b(getChildFragmentManager()));
            this.f80880n.setOffscreenPageLimit(this.f80881o.size() - 1);
            this.f80880n.addOnPageChangeListener(new c());
            this.f80880n.postDelayed(new lr.e(this), 200);
        }
    }

    public void initView(r rVar) {
        i6.d.j("share", "tag =" + getTag());
        this.f80875i = rVar.b(R.id.root_container);
        this.f80874h = rVar.b(R.id.share_container);
        this.f80876j = rVar.b(R.id.id_invite_share_cancel_btn);
        this.f80869c = (AdapterHorizontalScrollView) rVar.b(R.id.id_invite_share_platform_recyclerView);
        this.f80880n = (ViewPager) rVar.b(R.id.id_invite_share_platform_viewpager);
        this.f80879m = rVar.b(R.id.share_img_qrcode);
        setStandardWidth(rVar.b(R.id.share_img_root));
        ViewPager viewPager = this.f80880n;
        if (viewPager != null) {
            viewPager.setPageTransformer(false, new lr.g(getContext(), 0.38f));
        }
        g.i("App_bussiness_share_pop_expose", (HashMap) null);
    }

    public boolean isFullScreen() {
        return true;
    }

    public boolean isTransparent() {
        return true;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        HBShareHelper hBShareHelper = this.f80871e;
        if (hBShareHelper != null) {
            hBShareHelper.b(i11, i12, intent);
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == R.id.id_invite_share_cancel_btn) {
            g.i("app_share_pop_cancel_click", (HashMap) null);
            dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onDestroyView() {
        super.onDestroyView();
        EventBus.d().r(this);
        is.a.y((Map<String, Object>) null);
    }

    public void onResume() {
        super.onResume();
        ShareBusEvent shareBusEvent = this.f80873g;
        if (shareBusEvent != null) {
            if (!TextUtils.isEmpty(shareBusEvent.a())) {
                HuobiToastUtil.r(this.f80873g.a());
            }
            this.f80873g = null;
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onShareEvent(ShareBusEvent shareBusEvent) {
        this.f80873g = shareBusEvent;
    }

    public boolean useWindowBg() {
        return false;
    }

    public void zh(List<InviteSharePlatformListItem> list) {
    }
}
