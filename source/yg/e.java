package yg;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

public class e extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<View> f48108a;

    public e(List<View> list) {
        this.f48108a = list;
    }

    public void destroyItem(ViewGroup viewGroup, int i11, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public int getCount() {
        List<View> list = this.f48108a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i11) {
        viewGroup.addView(this.f48108a.get(i11), 0);
        return this.f48108a.get(i11);
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i11, Object obj) {
        super.setPrimaryItem(viewGroup, i11, obj);
    }

    public void startUpdate(ViewGroup viewGroup) {
        super.startUpdate(viewGroup);
    }
}
