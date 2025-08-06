package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.tweetui.internal.GalleryImageView;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener;
import java.util.ArrayList;
import java.util.List;

class GalleryAdapter extends PagerAdapter {
    public final SwipeToDismissTouchListener.Callback callback;
    public final Context context;
    public final List<MediaEntity> items = new ArrayList();

    public GalleryAdapter(Context context2, SwipeToDismissTouchListener.Callback callback2) {
        this.context = context2;
        this.callback = callback2;
    }

    public void addAll(List<MediaEntity> list) {
        this.items.addAll(list);
        notifyDataSetChanged();
    }

    public void destroyItem(ViewGroup viewGroup, int i11, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public int getCount() {
        return this.items.size();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i11) {
        GalleryImageView galleryImageView = new GalleryImageView(this.context);
        galleryImageView.setSwipeToDismissCallback(this.callback);
        viewGroup.addView(galleryImageView);
        Picasso.with(this.context).l(this.items.get(i11).mediaUrlHttps).i(galleryImageView);
        return galleryImageView;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
