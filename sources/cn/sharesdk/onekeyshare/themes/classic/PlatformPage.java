package cn.sharesdk.onekeyshare.themes.classic;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.sharesdk.framework.CustomPlatform;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.onekeyshare.CustomerLogo;
import cn.sharesdk.onekeyshare.OnekeySharePage;
import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import com.mob.tools.gui.MobViewPager;
import com.mob.tools.utils.ResHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class PlatformPage extends OnekeySharePage {
    private Animation animHide;
    private Animation animShow;
    /* access modifiers changed from: private */
    public Runnable beforeFinish;
    /* access modifiers changed from: private */
    public boolean finished;
    /* access modifiers changed from: private */
    public ClassicTheme impl;
    private LinearLayout llPanel;

    public PlatformPage(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        super(onekeyShareThemeImpl);
        this.impl = (ClassicTheme) ResHelper.forceCast(onekeyShareThemeImpl);
    }

    private void initAnims() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        this.animShow = translateAnimation;
        translateAnimation.setDuration(300);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        this.animHide = translateAnimation2;
        translateAnimation2.setDuration(300);
    }

    private boolean isCanShare(Platform platform) {
        String name = platform.getName();
        return !"Cmcc".equals(name) && !"Accountkit".equals(name) && !"Telecom".equals(name) && !"GooglePlus".equals(name) && !"HWAccount".equals(name);
    }

    public ArrayList<Object> collectCells() {
        ArrayList<Object> arrayList = new ArrayList<>();
        Platform[] platformList = ShareSDK.getPlatformList();
        if (platformList == null) {
            platformList = new Platform[0];
        }
        HashMap<String, String> hiddenPlatforms = getHiddenPlatforms();
        if (hiddenPlatforms == null) {
            hiddenPlatforms = new HashMap<>();
        }
        for (Platform platform : platformList) {
            if (!hiddenPlatforms.containsKey(platform.getName()) && isCanShare(platform)) {
                arrayList.add(platform);
            }
        }
        ArrayList<CustomerLogo> customerLogos = getCustomerLogos();
        if (customerLogos != null && customerLogos.size() > 0) {
            arrayList.addAll(customerLogos);
        }
        return arrayList;
    }

    public abstract PlatformPageAdapter newAdapter(ArrayList<Object> arrayList);

    public void onCreate() {
        this.activity.getWindow().setBackgroundDrawable(new ColorDrawable(1275068416));
        initAnims();
        LinearLayout linearLayout = new LinearLayout(this.activity);
        linearLayout.setOrientation(1);
        OnekeySharePage.setViewFitsSystemWindows(linearLayout);
        this.activity.setContentView(linearLayout);
        TextView textView = new TextView(this.activity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.weight = 1.0f;
        textView.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                PlatformPage.this.finish();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        linearLayout.addView(textView, layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(this.activity);
        this.llPanel = linearLayout2;
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        this.llPanel.setAnimation(this.animShow);
        linearLayout.addView(this.llPanel, layoutParams2);
        MobViewPager mobViewPager = new MobViewPager(this.activity);
        PlatformPageAdapter newAdapter = newAdapter(collectCells());
        this.llPanel.addView(mobViewPager, new LinearLayout.LayoutParams(-1, newAdapter.getPanelHeight()));
        IndicatorView indicatorView = new IndicatorView(this.activity);
        this.llPanel.addView(indicatorView, new LinearLayout.LayoutParams(-1, newAdapter.getBottomHeight()));
        indicatorView.setScreenCount(newAdapter.getCount());
        indicatorView.onScreenChange(0, 0);
        newAdapter.setIndicator(indicatorView);
        mobViewPager.setAdapter(newAdapter);
    }

    public boolean onFinish() {
        if (this.finished) {
            this.finished = false;
            return false;
        }
        this.animHide.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                if (PlatformPage.this.beforeFinish == null) {
                    ShareSDK.logDemoEvent(2, (Platform) null);
                } else {
                    PlatformPage.this.beforeFinish.run();
                    Runnable unused = PlatformPage.this.beforeFinish = null;
                }
                boolean unused2 = PlatformPage.this.finished = true;
                PlatformPage.this.finish();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        this.llPanel.clearAnimation();
        this.llPanel.setAnimation(this.animHide);
        this.llPanel.setVisibility(8);
        return true;
    }

    public final void performCustomLogoClick(final View view, final CustomerLogo customerLogo) {
        this.beforeFinish = new Runnable() {
            public void run() {
                customerLogo.listener.onClick(view);
            }
        };
        finish();
    }

    public final void showEditPage(final Platform platform) {
        this.beforeFinish = new Runnable() {
            public void run() {
                final boolean access$000 = PlatformPage.this.isSilent();
                Platform platform = platform;
                final boolean z11 = platform instanceof CustomPlatform;
                PlatformPage.this.isUseClientToShare(platform, new ShareSDKCallback<Boolean>() {
                    public void onCallback(Boolean bool) {
                        if (access$000 || z11 || bool.booleanValue()) {
                            AnonymousClass2 r32 = AnonymousClass2.this;
                            PlatformPage.this.shareSilently(platform);
                            return;
                        }
                        AnonymousClass2 r33 = AnonymousClass2.this;
                        PlatformPage.this.formateShareData(platform, new ShareSDKCallback<Platform.ShareParams>() {
                            public void onCallback(Platform.ShareParams shareParams) {
                                if (shareParams != null) {
                                    ShareSDK.logDemoEvent(3, platform);
                                    shareParams.setOpenCustomEven(true);
                                    if (PlatformPage.this.getCustomizeCallback() != null) {
                                        PlatformPage.this.getCustomizeCallback().onShare(platform, shareParams);
                                    }
                                    PlatformPage.this.impl.showEditPage(PlatformPage.this.activity, platform, shareParams);
                                }
                            }
                        });
                    }
                });
            }
        };
        finish();
    }
}
