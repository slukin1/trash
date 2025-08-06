package com.huochat.community.widget;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cpiz.android.bubbleview.BubbleTextView;
import com.cpiz.android.bubbleview.b;
import com.cpiz.android.bubbleview.d;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.huochat.community.R;
import com.huochat.community.util.DisplayTool;
import java.util.ArrayList;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.i;
import kotlin.jvm.internal.r;

public final class CommunityBubbleHintHelper {
    private static final String BUBBLE_HINT_COMMUNITY_TAB = "BUBBLE_HINT_COMMUNITY_TAB";
    public static final Companion Companion = new Companion((r) null);
    /* access modifiers changed from: private */
    public static final i<CommunityBubbleHintHelper> instance$delegate = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.SYNCHRONIZED, CommunityBubbleHintHelper$Companion$instance$2.INSTANCE);
    /* access modifiers changed from: private */
    public static boolean isBubbleShowing;
    /* access modifiers changed from: private */
    public static DialogInterface.OnDismissListener onDismissListener;
    /* access modifiers changed from: private */
    public static final List<b> showingPopups = new ArrayList();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final CommunityBubbleHintHelper create() {
            return new CommunityBubbleHintHelper();
        }

        public final void dismiss() {
            for (b bVar : CommunityBubbleHintHelper.showingPopups) {
                if (bVar != null && bVar.isShowing()) {
                    bVar.dismiss();
                }
            }
            CommunityBubbleHintHelper.showingPopups.clear();
            setBubbleShowing(false);
            setOnDismissListener((DialogInterface.OnDismissListener) null);
        }

        public final CommunityBubbleHintHelper getInstance() {
            return (CommunityBubbleHintHelper) CommunityBubbleHintHelper.instance$delegate.getValue();
        }

        public final DialogInterface.OnDismissListener getOnDismissListener() {
            return CommunityBubbleHintHelper.onDismissListener;
        }

        public final boolean isBubbleShowing() {
            return CommunityBubbleHintHelper.isBubbleShowing;
        }

        public final void setBubbleShowing(boolean z11) {
            CommunityBubbleHintHelper.isBubbleShowing = z11;
        }

        public final void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            CommunityBubbleHintHelper.onDismissListener = onDismissListener;
        }
    }

    /* access modifiers changed from: private */
    public static final void showCommunityTips$lambda$1(View view) {
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.community_dialog_bubble_hint, (ViewGroup) null);
        BubbleTextView bubbleTextView = (BubbleTextView) inflate.findViewById(R.id.community_hint_bubble);
        bubbleTextView.setText(R.string.community_tab_tips);
        b bVar = new b(inflate, bubbleTextView);
        d dVar = new d(3, 1);
        bVar.l(PixelUtils.a(50.0f));
        bVar.h(PixelUtils.a(23.0f));
        bVar.setSoftInputMode(16);
        bVar.m(view, dVar, PixelUtils.a(15.0f), PixelUtils.a(DisplayTool.checkNavigationBarShow(view.getContext()) ? -50.0f : -10.0f));
        bVar.setOnDismissListener(new a(bVar));
        showingPopups.add(bVar);
    }

    /* access modifiers changed from: private */
    public static final void showCommunityTips$lambda$1$lambda$0(b bVar) {
        isBubbleShowing = false;
        showingPopups.remove(bVar);
        ConfigPreferences.n("user_config", BUBBLE_HINT_COMMUNITY_TAB, true);
        DialogInterface.OnDismissListener onDismissListener2 = onDismissListener;
        if (onDismissListener2 != null) {
            onDismissListener2.onDismiss((DialogInterface) null);
        }
    }

    public final boolean showCommunityTips(View view) {
        if (view.getWindowToken() == null || ConfigPreferences.c("user_config", BUBBLE_HINT_COMMUNITY_TAB, false) || isBubbleShowing) {
            return false;
        }
        isBubbleShowing = true;
        view.post(new b(view));
        return true;
    }
}
