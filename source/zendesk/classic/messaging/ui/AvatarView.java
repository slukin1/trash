package zendesk.classic.messaging.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
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
import com.squareup.picasso.Picasso;
import com.squareup.picasso.r;
import zendesk.classic.messaging.R$array;
import zendesk.classic.messaging.R$attr;
import zendesk.classic.messaging.R$color;
import zendesk.classic.messaging.R$dimen;
import zendesk.classic.messaging.R$id;
import zendesk.classic.messaging.R$layout;
import zendesk.classic.messaging.R$styleable;
import zendesk.commonui.UiUtils;
import zendesk.commonui.a;

public class AvatarView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f62639b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f62640c;

    /* renamed from: d  reason: collision with root package name */
    public final int f62641d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f62642e;

    /* renamed from: f  reason: collision with root package name */
    public final int f62643f;

    /* renamed from: g  reason: collision with root package name */
    public final int f62644g;

    public AvatarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final Drawable a(Object obj) {
        int i11 = this.f62642e[Math.abs(obj.hashCode() % this.f62642e.length)];
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(i11);
        if (this.f62643f <= 0) {
            return shapeDrawable;
        }
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable2.getPaint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setColor(this.f62644g);
        paint.setStrokeWidth((float) this.f62643f);
        return new LayerDrawable(new Drawable[]{shapeDrawable, new InsetDrawable(shapeDrawable2, this.f62643f / 2)});
    }

    public void b(int i11, Object obj) {
        setBackground(a(obj));
        this.f62639b.setImageResource(i11);
        this.f62640c.setVisibility(8);
        this.f62639b.setVisibility(0);
    }

    public void c(int i11) {
        setBackground((Drawable) null);
        this.f62639b.setImageResource(i11);
        this.f62640c.setVisibility(8);
        this.f62639b.setVisibility(0);
    }

    public void d(Picasso picasso, String str) {
        if (this.f62641d - this.f62643f > 0) {
            setBackground((Drawable) null);
            this.f62639b.setImageResource(R$color.zui_color_transparent);
            this.f62639b.setVisibility(0);
            this.f62640c.setVisibility(8);
            r l11 = picasso.l(str);
            int i11 = this.f62641d;
            int i12 = this.f62643f;
            l11.m(i11 - i12, i11 - i12).a().k().n(a.a(this.f62641d, this.f62644g, this.f62643f)).g(this.f62639b);
        }
    }

    public void e(String str, Object obj) {
        setBackground(a(obj));
        this.f62640c.setText(str);
        this.f62640c.setVisibility(0);
        this.f62639b.setVisibility(8);
    }

    public AvatarView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        FrameLayout.inflate(context, R$layout.zui_view_avatar, this);
        Resources resources = getResources();
        int color = resources.getColor(R$color.zui_color_white_80);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.zui_avatar_view_outline);
        int c11 = UiUtils.c(R$attr.colorPrimary, context, R$color.zui_color_primary);
        this.f62639b = (ImageView) findViewById(R$id.zui_avatar_image);
        TextView textView = (TextView) findViewById(R$id.zui_avatar_letter);
        this.f62640c = textView;
        this.f62641d = resources.getDimensionPixelSize(R$dimen.zui_avatar_view_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AvatarView);
        this.f62642e = resources.getIntArray(obtainStyledAttributes.getResourceId(R$styleable.AvatarView_colorPalette, R$array.zui_avatar_view__background_color_palette));
        this.f62643f = obtainStyledAttributes.getDimensionPixelSize(R$styleable.AvatarView_outlineSize, dimensionPixelOffset);
        this.f62644g = obtainStyledAttributes.getColor(R$styleable.AvatarView_outlineColor, c11);
        textView.setTextColor(obtainStyledAttributes.getColor(R$styleable.AvatarView_textColor, color));
        obtainStyledAttributes.recycle();
    }
}
