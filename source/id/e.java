package id;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.gift.bean.Prize;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.timcommon.component.impl.GlideEngine;
import java.util.List;

public final class e extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f22808a;

    /* renamed from: b  reason: collision with root package name */
    public final List<Prize> f22809b;

    /* renamed from: c  reason: collision with root package name */
    public final int f22810c = 3;

    public final class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final ImageView f22811a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f22812b;

        public a(View view) {
            super(view);
            this.f22811a = (ImageView) view.findViewById(R$id.ivItemBottomGift);
            this.f22812b = (TextView) view.findViewById(R$id.tvItemBottomGift);
        }

        public final ImageView e() {
            return this.f22811a;
        }

        public final TextView f() {
            return this.f22812b;
        }
    }

    public e(Context context, List<Prize> list) {
        this.f22808a = context;
        this.f22809b = list;
    }

    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i11) {
        GlideEngine.loadCornerImageWithoutPlaceHolder(aVar.e(), this.f22809b.get(i11).getPrizeUrl(), (com.bumptech.glide.request.e) null, (float) ScreenUtil.dip2px(33.0f));
        aVar.f().setText(this.f22809b.get(i11).getDetail());
    }

    /* renamed from: c */
    public a onCreateViewHolder(ViewGroup viewGroup, int i11) {
        View inflate = View.inflate(this.f22808a, R$layout.im_item_live_gift_bottom_pop, (ViewGroup) null);
        if (getItemCount() > 0) {
            inflate.setLayoutParams(new ConstraintLayout.LayoutParams(ScreenUtil.getScreenWidth(this.f22808a) / getItemCount(), -2));
        }
        return new a(inflate);
    }

    public int getItemCount() {
        int size = this.f22809b.size();
        int i11 = this.f22810c;
        return size > i11 ? i11 : this.f22809b.size();
    }
}
