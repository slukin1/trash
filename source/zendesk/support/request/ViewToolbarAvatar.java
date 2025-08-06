package zendesk.support.request;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.util.c;
import com.squareup.picasso.Picasso;
import com.zendesk.sdk.R$attr;
import com.zendesk.sdk.R$color;
import com.zendesk.sdk.R$dimen;
import com.zendesk.sdk.R$id;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mz.a;
import mz.f;
import zendesk.support.UiUtils;
import zendesk.support.ZendeskAvatarView;

class ViewToolbarAvatar extends FrameLayout {
    private static final int[] IMAGE_VIEW_IDS = {R$id.zs_request_toolbar_avatar_1, R$id.zs_request_toolbar_avatar_2, R$id.zs_request_toolbar_avatar_3, R$id.zs_request_toolbar_avatar_4, R$id.zs_request_toolbar_avatar_5};
    public static final int MAX_IMAGES = 5;
    private final List<ZendeskAvatarView> avatarViews;
    private int imageRadius;
    private int strokeColor;
    private int strokeWidth;
    private List<c<String, String>> userInfo;

    public ViewToolbarAvatar(Context context) {
        this(context, (AttributeSet) null);
    }

    private void bindData(Picasso picasso) {
        for (int i11 = 0; i11 < this.avatarViews.size(); i11++) {
            ZendeskAvatarView zendeskAvatarView = this.avatarViews.get(i11);
            if (i11 < this.userInfo.size()) {
                c cVar = this.userInfo.get(i11);
                if (f.c((String) cVar.f8468a)) {
                    zendeskAvatarView.showUserWithAvatarImage(picasso, (String) cVar.f8468a, (String) cVar.f8469b, this.imageRadius);
                } else {
                    zendeskAvatarView.showUserWithName((String) cVar.f8469b);
                }
                zendeskAvatarView.setVisibility(0);
            } else {
                zendeskAvatarView.setVisibility(8);
            }
        }
    }

    private ZendeskAvatarView createAndAddView(int i11) {
        ZendeskAvatarView zendeskAvatarView = new ZendeskAvatarView(getContext());
        zendeskAvatarView.setId(IMAGE_VIEW_IDS[i11]);
        zendeskAvatarView.setStroke(this.strokeColor, this.strokeWidth);
        int i12 = this.imageRadius * 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i12, i12);
        layoutParams.gravity = 8388613;
        layoutParams.setMarginEnd(i11 * 2 * (i12 / 3));
        addView(zendeskAvatarView, layoutParams);
        return zendeskAvatarView;
    }

    public void setImageUrls(Picasso picasso, List<c<String, String>> list) {
        if (list.size() > 5) {
            this.userInfo = list.subList(0, 5);
        } else {
            this.userInfo = a.c(list);
        }
        Collections.reverse(this.userInfo);
        bindData(picasso);
    }

    public ViewToolbarAvatar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewToolbarAvatar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.avatarViews = new ArrayList(5);
        this.userInfo = new ArrayList(5);
        this.imageRadius = context.getResources().getDimensionPixelOffset(R$dimen.zs_request_toolbar_avatar_radius);
        this.strokeWidth = context.getResources().getDimensionPixelOffset(R$dimen.zs_request_toolbar_avatar_stroke_width);
        this.strokeColor = UiUtils.themeAttributeToColor(R$attr.colorPrimary, getContext(), R$color.zs_request_fallback_color_primary);
        for (int i12 = 0; i12 < 5; i12++) {
            ZendeskAvatarView createAndAddView = createAndAddView(i12);
            createAndAddView.setVisibility(8);
            this.avatarViews.add(createAndAddView);
        }
    }
}
