package com.huochat.community;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.hbg.lib.common.BaseApplication;
import com.huochat.community.CommunityThemeColor;
import com.huochat.community.base.CommunityConstants;
import com.huochat.community.base.CommunityListTheme;
import com.huochat.community.enums.CommunityMenuItems;
import com.huochat.community.enums.SymbolParamType;
import com.huochat.community.eventbus.EventCode;
import com.huochat.community.eventbus.EventMessage;
import com.huochat.community.listener.CheckStateCallback;
import com.huochat.community.network.CommunityApiManager;
import com.huochat.community.network.domain.CommunityDomainHelper;
import com.huochat.community.network.domain.CommunityDomainSPTool;
import com.huochat.community.network.domain.CommunityDomainSelector;
import i6.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import org.greenrobot.eventbus.EventBus;

public class CommunityManager {
    public static final Companion Companion = new Companion((r) null);
    /* access modifiers changed from: private */
    public static HashMap<String, CommunityThemeColor> defThemeColorMap = new HashMap<>();
    /* access modifiers changed from: private */
    public static CommunityManager instance = new CommunityManager();
    /* access modifiers changed from: private */
    public static Context mContext;
    private String baseServerUrl;
    private String baseWebSiteUrl;
    private boolean isCommentListShow;
    private boolean isNightMode;
    private HashMap<String, CommunityThemeColor> themeColorMap;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        private final void initDefCommunityThemeColor(Context context) {
            CommunityManager.defThemeColorMap.clear();
            HashMap access$getDefThemeColorMap$cp = CommunityManager.defThemeColorMap;
            String str = CommunityListTheme.LIGHT.toString();
            CommunityThemeColor.Companion companion = CommunityThemeColor.Companion;
            access$getDefThemeColorMap$cp.put(str, companion.getDefLightColor(context));
            CommunityManager.defThemeColorMap.put(CommunityListTheme.NIGHT.toString(), companion.getDefNightColor(context));
        }

        public final CommunityManager getInstance() {
            return CommunityManager.instance;
        }

        public final Context getMContext() {
            return CommunityManager.mContext;
        }

        public final void init(Context context) {
            setMContext(context);
            initDefCommunityThemeColor(context);
            CommunityManager instance = getInstance();
            if (instance != null) {
                instance.setBaseUrl(CommunityDomainSPTool.Companion.getCommunityApiDomain());
            }
            CommunityManager instance2 = getInstance();
            if (instance2 != null) {
                instance2.setBaseWebSiteUrl(CommunityDomainSPTool.Companion.getCommunityWebUrlDomain());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("#### community_manager apiDomain: ");
            CommunityDomainSPTool.Companion companion = CommunityDomainSPTool.Companion;
            sb2.append(companion.getCommunityApiDomain());
            d.b(sb2.toString());
            d.b("#### community_manager webUrlDomain: " + companion.getCommunityWebUrlDomain());
        }

        public final void onDestroy() {
            setMContext((Context) null);
        }

        public final void requestCommunityDomain() {
            CommunityDomainHelper.Companion companion = CommunityDomainHelper.Companion;
            companion.getGlobalCommunityUrls();
            companion.getGlobalCommunityWebUrls();
        }

        public final void resetCommunityDomain(Map<String, List<String>> map, Map<String, List<String>> map2) {
            CommunityDomainSelector.Companion companion = CommunityDomainSelector.Companion;
            companion.getInstance().setApiDomains(map);
            companion.getInstance().setWebUrlDomains(map2);
        }

        public final void setInstance(CommunityManager communityManager) {
            CommunityManager.instance = communityManager;
        }

        public final void setMContext(Context context) {
            CommunityManager.mContext = context;
        }
    }

    private CommunityManager() {
        this.baseServerUrl = CommunityConstants.BASE_SERVER_URL;
        this.baseWebSiteUrl = "https://www.huotalk.com?&from=huobi";
        this.themeColorMap = new HashMap<>();
        this.baseServerUrl = CommunityConstants.BASE_SERVER_URL;
        this.baseWebSiteUrl = "https://www.huotalk.com?&from=huobi";
    }

    private final boolean isHuobiChatInstalled() {
        try {
            if (BaseApplication.b().getPackageManager().getPackageInfo("com.huochat.im", 8192) != null) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final void checkCommunityState(String str, SymbolParamType symbolParamType, CheckStateCallback checkStateCallback) {
        if (str == null || str.length() == 0) {
            checkStateCallback.onState(false);
        } else {
            CommunityApiManager.Companion.getInstance().getCommunityListbySymbol(str, symbolParamType, -1, -1L, CommunityMenuItems.DEFAULT.getType()).d(new CommunityManager$checkCommunityState$1(checkStateCallback));
        }
    }

    public final int getAvatarBackgroundResId() {
        if (isNightModel()) {
            return R.drawable.ic_community_def_circle_stroke_night;
        }
        return R.drawable.ic_community_def_circle_stroke_light;
    }

    public final String getBaseUrl() {
        return this.baseServerUrl;
    }

    public final String getBaseWebsiteUrl() {
        return this.baseWebSiteUrl;
    }

    public final CommunityThemeColor getCommunityThemeColor() {
        String str = CommunityListTheme.NIGHT.toString();
        String str2 = CommunityListTheme.LIGHT.toString();
        if (this.isNightMode) {
            if (this.themeColorMap.containsKey(str)) {
                return this.themeColorMap.get(str);
            }
            if (defThemeColorMap.containsKey(str)) {
                return defThemeColorMap.get(str);
            }
            defThemeColorMap.put(str, CommunityThemeColor.Companion.getDefNightColor(BaseApplication.b().getApplicationContext()));
            return defThemeColorMap.get(str);
        } else if (this.themeColorMap.containsKey(str2)) {
            return this.themeColorMap.get(str2);
        } else {
            if (defThemeColorMap.containsKey(str2)) {
                return defThemeColorMap.get(str2);
            }
            defThemeColorMap.put(str2, CommunityThemeColor.Companion.getDefLightColor(BaseApplication.b().getApplicationContext()));
            return defThemeColorMap.get(str2);
        }
    }

    public final int getDefaultAvatarResId() {
        if (isNightModel()) {
            return R.drawable.ic_community_def_circle_night;
        }
        return R.drawable.ic_community_def_circle_light;
    }

    public final void initCommunityThemeColor(CommunityThemeColor communityThemeColor, CommunityThemeColor communityThemeColor2) {
        this.themeColorMap.clear();
        this.themeColorMap.put(CommunityListTheme.LIGHT.toString(), communityThemeColor);
        this.themeColorMap.put(CommunityListTheme.NIGHT.toString(), communityThemeColor2);
    }

    public final boolean isCommentListShow() {
        return this.isCommentListShow;
    }

    public final boolean isNightModel() {
        return this.isNightMode;
    }

    public final void openHuobiChat(Context context, String str, String str2) {
        if (isHuobiChatInstalled()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(CommunityConstants.HUOBICHAT_URL_SCHEME);
            boolean z11 = false;
            if (!(str == null || str.length() == 0)) {
                sb2.append("?router=" + str);
            }
            if (str2 == null || str2.length() == 0) {
                z11 = true;
            }
            if (!z11) {
                sb2.append("&param=" + str2);
            }
            intent.setData(Uri.parse(sb2.toString()));
            if (context != null) {
                context.startActivity(intent);
                return;
            }
            return;
        }
        try {
            Uri parse = Uri.parse(this.baseWebSiteUrl);
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(parse);
            if (context != null) {
                context.startActivity(intent2);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void pullToRefresh() {
        EventBus.d().k(new EventMessage(EventCode.REFRESH_COMMUNITY_LIST));
    }

    public final void setBaseUrl(String str) {
        if (!(str == null || str.length() == 0)) {
            this.baseServerUrl = str;
        }
    }

    public final void setBaseWebSiteUrl(String str) {
        if (!(str == null || str.length() == 0)) {
            this.baseWebSiteUrl = str;
        }
    }

    public final void setCommentListShow(boolean z11) {
        this.isCommentListShow = z11;
    }

    public final void setNightMode(boolean z11) {
        if (this.isNightMode != z11) {
            this.isNightMode = z11;
            EventBus.d().k(new EventMessage(EventCode.SWITCH_THEME));
        }
    }
}
