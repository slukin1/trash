package com.jumio.defaultui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.jumio.defaultui.R;
import kotlin.jvm.internal.r;

public final class BulletPointAdapter extends RecyclerView.Adapter<BulletPointViewHolder> {
    private final String bulletPoint;
    private final String[] items;
    private final int layout;

    public static final class BulletPointViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvBulletPoint;

        public BulletPointViewHolder(View view) {
            super(view);
            this.tvBulletPoint = (TextView) view.findViewById(R.id.tv_bullet_point);
        }

        public final TextView getTvBulletPoint() {
            return this.tvBulletPoint;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BulletPointAdapter(String str, String[] strArr, int i11, int i12, r rVar) {
        this(str, strArr, (i12 & 4) != 0 ? R.layout.jumio_fragment_bullet_point_item : i11);
    }

    public int getItemCount() {
        return this.items.length;
    }

    public void onBindViewHolder(BulletPointViewHolder bulletPointViewHolder, int i11) {
        String str = this.items[i11];
        TextView tvBulletPoint = bulletPointViewHolder.getTvBulletPoint();
        String str2 = this.bulletPoint;
        tvBulletPoint.setText(str2 + " " + str);
    }

    public BulletPointViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new BulletPointViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(this.layout, viewGroup, false));
    }

    public BulletPointAdapter(String str, String[] strArr, int i11) {
        this.bulletPoint = str;
        this.items = strArr;
        this.layout = i11;
    }
}
