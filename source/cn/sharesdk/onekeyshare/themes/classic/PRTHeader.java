package cn.sharesdk.onekeyshare.themes.classic;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.mob.tools.utils.ResHelper;

public class PRTHeader extends LinearLayout {
    private static final int DESIGN_AVATAR_PADDING = 24;
    private static final int DESIGN_AVATAR_WIDTH = 64;
    private static final int DESIGN_SCREEN_WIDTH = 720;
    private RotateImageView ivArrow;
    private ProgressBar pbRefreshing;
    private TextView tvHeader;

    public PRTHeader(Context context) {
        super(context);
        int[] screenSize = ResHelper.getScreenSize(context);
        float f11 = ((float) (screenSize[0] < screenSize[1] ? screenSize[0] : screenSize[1])) / 720.0f;
        setOrientation(1);
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        addView(linearLayout, layoutParams);
        this.ivArrow = new RotateImageView(context);
        int bitmapRes = ResHelper.getBitmapRes(context, "ssdk_oks_ptr_ptr");
        if (bitmapRes > 0) {
            this.ivArrow.setImageResource(bitmapRes);
        }
        int i11 = (int) (64.0f * f11);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i11, i11);
        layoutParams2.gravity = 16;
        int i12 = (int) (f11 * 24.0f);
        layoutParams2.bottomMargin = i12;
        layoutParams2.topMargin = i12;
        linearLayout.addView(this.ivArrow, layoutParams2);
        this.pbRefreshing = new ProgressBar(context);
        this.pbRefreshing.setIndeterminateDrawable(context.getResources().getDrawable(ResHelper.getBitmapRes(context, "ssdk_oks_classic_progressbar")));
        linearLayout.addView(this.pbRefreshing, layoutParams2);
        this.pbRefreshing.setVisibility(8);
        TextView textView = new TextView(getContext());
        this.tvHeader = textView;
        textView.setTextSize(2, 18.0f);
        this.tvHeader.setPadding(i12, 0, i12, 0);
        this.tvHeader.setTextColor(-16139513);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        linearLayout.addView(this.tvHeader, layoutParams3);
    }

    public void onPullDown(int i11) {
        if (i11 > 100) {
            int i12 = 180;
            int i13 = ((i11 - 100) * 180) / 20;
            if (i13 <= 180) {
                i12 = i13;
            }
            if (i12 < 0) {
                i12 = 0;
            }
            this.ivArrow.setRotation((float) i12);
        } else {
            this.ivArrow.setRotation(0.0f);
        }
        if (i11 < 100) {
            int stringRes = ResHelper.getStringRes(getContext(), "ssdk_oks_pull_to_refresh");
            if (stringRes > 0) {
                this.tvHeader.setText(stringRes);
                return;
            }
            return;
        }
        int stringRes2 = ResHelper.getStringRes(getContext(), "ssdk_oks_release_to_refresh");
        if (stringRes2 > 0) {
            this.tvHeader.setText(stringRes2);
        }
    }

    public void onRequest() {
        this.ivArrow.setVisibility(8);
        this.pbRefreshing.setVisibility(0);
        int stringRes = ResHelper.getStringRes(getContext(), "ssdk_oks_refreshing");
        if (stringRes > 0) {
            this.tvHeader.setText(stringRes);
        }
    }

    public void reverse() {
        this.pbRefreshing.setVisibility(8);
        this.ivArrow.setRotation(180.0f);
        this.ivArrow.setVisibility(0);
    }
}
