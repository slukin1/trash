package zendesk.support;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.r;
import com.zendesk.sdk.R$color;
import com.zendesk.sdk.R$drawable;
import com.zendesk.sdk.R$id;
import mz.f;

public class ZendeskAvatarView extends FrameLayout {
    private static final int[] AVATAR_COLORS = {R$color.zs_avatar_view_color_01, R$color.zs_avatar_view_color_02, R$color.zs_avatar_view_color_03, R$color.zs_avatar_view_color_04, R$color.zs_avatar_view_color_05, R$color.zs_avatar_view_color_06, R$color.zs_avatar_view_color_07, R$color.zs_avatar_view_color_08, R$color.zs_avatar_view_color_09, R$color.zs_avatar_view_color_10, R$color.zs_avatar_view_color_11, R$color.zs_avatar_view_color_12, R$color.zs_avatar_view_color_13, R$color.zs_avatar_view_color_14, R$color.zs_avatar_view_color_15, R$color.zs_avatar_view_color_16, R$color.zs_avatar_view_color_17, R$color.zs_avatar_view_color_18, R$color.zs_avatar_view_color_19};
    private boolean enableOutline;
    private ImageView imageView;
    private int strokeColor;
    private int strokeWidth;
    private TextView textView;

    public ZendeskAvatarView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    private Drawable getBackgroundShape(int i11) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(ContextCompat.getColor(getContext(), i11));
        if (!this.enableOutline) {
            return shapeDrawable;
        }
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable2.getPaint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setColor(this.strokeColor);
        paint.setStrokeWidth((float) this.strokeWidth);
        return new LayerDrawable(new Drawable[]{shapeDrawable, new InsetDrawable(shapeDrawable2, this.strokeWidth / 2)});
    }

    private int getColorId(Object obj) {
        int[] iArr = AVATAR_COLORS;
        return iArr[Math.abs(obj.hashCode() % iArr.length)];
    }

    private void initViews() {
        TextView textView2 = new TextView(getContext());
        this.textView = textView2;
        textView2.setId(R$id.zs_avatar_view_text_view);
        this.textView.setTextColor(ContextCompat.getColor(getContext(), R$color.zs_avatar_text_color));
        this.textView.setGravity(17);
        this.textView.setTextSize(2, 16.0f);
        ImageView imageView2 = new ImageView(getContext());
        this.imageView = imageView2;
        imageView2.setId(R$id.zs_avatar_view_image_view);
        addView(this.textView);
        addView(this.imageView);
    }

    private void setTextView(String str) {
        setBackground(getBackgroundShape(getColorId(str)));
        this.textView.setText(String.valueOf(Character.toUpperCase(str.charAt(0))));
    }

    public void setStroke(int i11, int i12) {
        this.strokeColor = i11;
        this.strokeWidth = i12;
        this.enableOutline = true;
    }

    public void showUserWithAvatarImage(Picasso picasso, String str, String str2, int i11) {
        this.imageView.setVisibility(0);
        this.imageView.setImageResource(R$color.zs_color_transparent);
        if (f.c(str2)) {
            this.textView.setVisibility(0);
            setTextView(str2);
        }
        this.imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r l11 = picasso.l(str);
        int i12 = i11 * 2;
        l11.m(i12, i12).a().k().n(PicassoTransformations.getRoundWithBorderTransformation(i11, this.strokeColor, this.strokeWidth)).g(this.imageView);
    }

    public void showUserWithIdentifier(Object obj) {
        if (obj != null) {
            setBackground(getBackgroundShape(getColorId(obj)));
            this.imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.imageView.setImageResource(R$drawable.zs_request_list_account_icon);
            this.textView.setVisibility(4);
            this.imageView.setVisibility(0);
        }
    }

    public void showUserWithName(String str) {
        if (f.c(str)) {
            setTextView(str);
            this.textView.setVisibility(0);
            this.imageView.setVisibility(4);
        }
    }

    public ZendeskAvatarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZendeskAvatarView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.enableOutline = false;
        this.strokeColor = 0;
        this.strokeWidth = 0;
        initViews();
    }
}
