package androidx.viewpager2.adapter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.h0;
import androidx.recyclerview.widget.RecyclerView;

public final class FragmentViewHolder extends RecyclerView.ViewHolder {
    private FragmentViewHolder(FrameLayout frameLayout) {
        super(frameLayout);
    }

    public static FragmentViewHolder create(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setId(h0.n());
        frameLayout.setSaveEnabled(false);
        return new FragmentViewHolder(frameLayout);
    }

    public FrameLayout getContainer() {
        return (FrameLayout) this.itemView;
    }
}
