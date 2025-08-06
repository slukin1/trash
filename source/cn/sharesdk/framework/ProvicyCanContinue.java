package cn.sharesdk.framework;

import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.mob.MobSDK;
import com.mob.OperationCallback;
import com.mob.RHolder;
import com.mob.commons.SHARESDK;
import com.mob.commons.dialog.entity.InternalPolicyUi;
import com.mob.tools.utils.ResHelper;

public class ProvicyCanContinue {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ProvicyCanContinue f13228a;

    public interface OnBusinessListener {
        void onContinue();

        void onError(Throwable th2);

        void onStop();
    }

    private ProvicyCanContinue() {
        b();
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static cn.sharesdk.framework.ProvicyCanContinue a() {
        /*
            java.lang.Class<cn.sharesdk.framework.ProvicyCanContinue> r0 = cn.sharesdk.framework.ProvicyCanContinue.class
            monitor-enter(r0)
            cn.sharesdk.framework.ProvicyCanContinue r1 = f13228a     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0018
            monitor-enter(r0)     // Catch:{ all -> 0x001c }
            cn.sharesdk.framework.ProvicyCanContinue r1 = f13228a     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0013
            cn.sharesdk.framework.ProvicyCanContinue r1 = new cn.sharesdk.framework.ProvicyCanContinue     // Catch:{ all -> 0x0015 }
            r1.<init>()     // Catch:{ all -> 0x0015 }
            f13228a = r1     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r1     // Catch:{ all -> 0x001c }
        L_0x0018:
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            cn.sharesdk.framework.ProvicyCanContinue r0 = f13228a
            return r0
        L_0x001c:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.ProvicyCanContinue.a():cn.sharesdk.framework.ProvicyCanContinue");
    }

    private void b() {
        RHolder.getInstance().setActivityThemeId(ResHelper.getStyleRes(MobSDK.getContext(), "mobcommon_TranslucentTheme")).setDialogThemeId(ResHelper.getStyleRes(MobSDK.getContext(), "mobcommon_DialogStyle")).setDialogLayoutId(ResHelper.getLayoutRes(MobSDK.getContext(), "mob_authorize_dialog"));
        SSDKLog.b().a(OnekeyShare.SHARESDK_TAG, "ProvicyCanContinue initMobCommonView()");
    }

    public void a(final OnBusinessListener onBusinessListener) {
        MobSDK.canIContinueBusiness(new SHARESDK(), new InternalPolicyUi.Builder().setTitleText(MobSDK.getContext().getResources().getString(ResHelper.getStringRes(MobSDK.getContext(), "mobcommon_authorize_dialog_title"))).setContentText(MobSDK.getContext().getResources().getString(ResHelper.getStringRes(MobSDK.getContext(), "mobcommon_authorize_dialog_content"))).build(), new OperationCallback<Boolean>() {
            public void onFailure(Throwable th2) {
                SSDKLog b11 = SSDKLog.b();
                b11.a(OnekeyShare.SHARESDK_TAG, "canIContinueBusiness: onFailure() " + th2);
                OnBusinessListener onBusinessListener = onBusinessListener;
                if (onBusinessListener != null) {
                    onBusinessListener.onError(th2);
                }
            }

            public void onComplete(Boolean bool) {
                SSDKLog b11 = SSDKLog.b();
                b11.a(OnekeyShare.SHARESDK_TAG, "canIContinueBusiness: onComplete(), " + bool);
                if (bool.booleanValue()) {
                    OnBusinessListener onBusinessListener = onBusinessListener;
                    if (onBusinessListener != null) {
                        onBusinessListener.onContinue();
                    }
                    SSDKLog.b().a(OnekeyShare.SHARESDK_TAG, "MobSDK.canIContinueBusiness if ");
                    return;
                }
                OnBusinessListener onBusinessListener2 = onBusinessListener;
                if (onBusinessListener2 != null) {
                    onBusinessListener2.onStop();
                }
                SSDKLog.b().a(OnekeyShare.SHARESDK_TAG, "MobSDK.canIContinueBusiness else ");
            }
        });
    }
}
