package cn.sharesdk.onekeyshare.themes.classic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.sharesdk.onekeyshare.themes.classic.FriendAdapter;
import com.huobi.view.roundimg.RoundedDrawable;
import com.mob.tools.gui.AsyncImageView;
import com.mob.tools.gui.BitmapProcessor;
import com.mob.tools.utils.ResHelper;

public class FriendListItem extends LinearLayout {
    private static final int DESIGN_AVATAR_PADDING = 24;
    private static final int DESIGN_AVATAR_WIDTH = 64;
    private static final int DESIGN_ITEM_HEIGHT = 96;
    private static final int DESIGN_ITEM_PADDING = 20;
    private AsyncImageView aivIcon;
    private Bitmap bmChd;
    private Bitmap bmUnch;
    private ImageView ivCheck;
    private TextView tvName;

    public FriendListItem(Context context, float f11) {
        super(context);
        int i11 = (int) (20.0f * f11);
        setPadding(i11, 0, i11, 0);
        setMinimumHeight((int) (96.0f * f11));
        setBackgroundColor(-1);
        this.ivCheck = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        addView(this.ivCheck, layoutParams);
        this.aivIcon = new AsyncImageView(context);
        int i12 = (int) (64.0f * f11);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i12, i12);
        layoutParams2.gravity = 16;
        int i13 = (int) (f11 * 24.0f);
        layoutParams2.setMargins(i13, 0, i13, 0);
        addView(this.aivIcon, layoutParams2);
        TextView textView = new TextView(context);
        this.tvName = textView;
        textView.setTextColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        this.tvName.setTextSize(2, 18.0f);
        this.tvName.setSingleLine();
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        layoutParams3.weight = 1.0f;
        addView(this.tvName, layoutParams3);
        int bitmapRes = ResHelper.getBitmapRes(context, "ssdk_oks_classic_check_checked");
        if (bitmapRes > 0) {
            this.bmChd = BitmapFactory.decodeResource(context.getResources(), bitmapRes);
        }
        int bitmapRes2 = ResHelper.getBitmapRes(getContext(), "ssdk_oks_classic_check_default");
        if (bitmapRes2 > 0) {
            this.bmUnch = BitmapFactory.decodeResource(context.getResources(), bitmapRes2);
        }
    }

    public void update(FriendAdapter.Following following, boolean z11) {
        this.tvName.setText(following.screenName);
        this.ivCheck.setImageBitmap(following.checked ? this.bmChd : this.bmUnch);
        AsyncImageView asyncImageView = this.aivIcon;
        if (asyncImageView == null) {
            return;
        }
        if (z11) {
            Bitmap bitmapFromCache = BitmapProcessor.getBitmapFromCache(following.icon);
            if (bitmapFromCache == null || bitmapFromCache.isRecycled()) {
                this.aivIcon.execute((String) null, 0);
            } else {
                this.aivIcon.setImageBitmap(bitmapFromCache);
            }
        } else {
            asyncImageView.execute(following.icon, 0);
        }
    }
}
