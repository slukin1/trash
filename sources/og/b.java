package og;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.bean.PersonalcenterActivityInfoBean;
import dw.a;
import gs.g;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;

public class b extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f47662a;

    /* renamed from: b  reason: collision with root package name */
    public int f47663b;

    /* renamed from: c  reason: collision with root package name */
    public List<PersonalcenterActivityInfoBean> f47664c;

    public b(Context context, int i11, List<PersonalcenterActivityInfoBean> list) {
        this.f47662a = context;
        this.f47663b = i11;
        this.f47664c = list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(PersonalcenterActivityInfoBean personalcenterActivityInfoBean, Void voidR) {
        String jump_url = personalcenterActivityInfoBean.getJump_url();
        if (!TextUtils.isEmpty(jump_url)) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", "活动中心");
            hashMap.put("business_category", personalcenterActivityInfoBean.getBusinessCategory());
            hashMap.put("type", "normal");
            g.i("box_Me_click", hashMap);
            Intent intent = new Intent();
            intent.putExtra("url", jump_url);
            Context context = this.f47662a;
            intent.putExtra("title_back", context == null ? "" : context.getString(R.string.head_return));
            intent.setClass(this.f47662a, HBBaseWebActivity.class);
            this.f47662a.startActivity(intent);
        }
    }

    public void destroyItem(ViewGroup viewGroup, int i11, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public int getCount() {
        List<PersonalcenterActivityInfoBean> list = this.f47664c;
        if (list == null) {
            return 0;
        }
        return (int) Math.ceil((double) ((((float) list.size()) * 1.0f) / ((float) this.f47663b)));
    }

    public Object instantiateItem(ViewGroup viewGroup, int i11) {
        LinearLayout linearLayout = new LinearLayout(this.f47662a);
        linearLayout.setOrientation(1);
        linearLayout.setWeightSum(2.0f);
        viewGroup.addView(linearLayout);
        int i12 = this.f47663b * i11;
        while (true) {
            int i13 = i11 + 1;
            if (i12 >= Math.min(this.f47663b * i13, this.f47664c.size())) {
                return linearLayout;
            }
            PersonalcenterActivityInfoBean personalcenterActivityInfoBean = this.f47664c.get(i12);
            View inflate = LayoutInflater.from(this.f47662a).inflate(R.layout.part_home_account_box_activity_center_item, (ViewGroup) null, false);
            linearLayout.addView(inflate, new LinearLayout.LayoutParams(-1, 0, 1.0f));
            String img_night_url = NightHelper.e().g() ? personalcenterActivityInfoBean.getImg_night_url() : personalcenterActivityInfoBean.getImg_url();
            if (!TextUtils.isEmpty(img_night_url)) {
                g6.b.c().h((ImageView) inflate.findViewById(R.id.item_activity_image), img_night_url);
            }
            ((TextView) inflate.findViewById(R.id.item_activity_title)).setText(personalcenterActivityInfoBean.getTitle());
            ((TextView) inflate.findViewById(R.id.item_activity_introduction)).setText(personalcenterActivityInfoBean.getIntroduction());
            if (i12 == (i13 * this.f47663b) - 1) {
                inflate.findViewById(R.id.line).setVisibility(4);
            } else {
                inflate.findViewById(R.id.line).setVisibility(0);
            }
            a.a(inflate).throttleFirst(1, TimeUnit.SECONDS).subscribe(new a(this, personalcenterActivityInfoBean));
            i12++;
        }
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
