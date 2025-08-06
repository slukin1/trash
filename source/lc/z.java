package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.TopicDetailInfo;
import com.hbg.module.content.R$id;

public class z extends y {

    /* renamed from: f0  reason: collision with root package name */
    public static final f.i f19336f0 = null;

    /* renamed from: g0  reason: collision with root package name */
    public static final SparseIntArray f19337g0;

    /* renamed from: d0  reason: collision with root package name */
    public final RelativeLayout f19338d0;

    /* renamed from: e0  reason: collision with root package name */
    public long f19339e0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f19337g0 = sparseIntArray;
        sparseIntArray.put(R$id.coordinatorTabLayout, 1);
        sparseIntArray.put(R$id.appbar_layout, 2);
        sparseIntArray.put(R$id.wrapCollapsingToolbarLayout, 3);
        sparseIntArray.put(R$id.llc_top, 4);
        sparseIntArray.put(R$id.cl_top_layout, 5);
        sparseIntArray.put(R$id.vTopBg, 6);
        sparseIntArray.put(R$id.rlTopicTitle, 7);
        sparseIntArray.put(R$id.ivIcon, 8);
        sparseIntArray.put(R$id.atv_topic_title, 9);
        sparseIntArray.put(R$id.atv_topic_content, 10);
        sparseIntArray.put(R$id.llTopicController, 11);
        sparseIntArray.put(R$id.aiv_topic_visit, 12);
        sparseIntArray.put(R$id.atv_topic_visit, 13);
        sparseIntArray.put(R$id.aiv_topic_article, 14);
        sparseIntArray.put(R$id.atv_topic_article, 15);
        sparseIntArray.put(R$id.aiv_topic_join, 16);
        sparseIntArray.put(R$id.atv_topic_join, 17);
        sparseIntArray.put(R$id.atv_topic_coin_title, 18);
        sparseIntArray.put(R$id.rv_topic_coin_list, 19);
        sparseIntArray.put(R$id.atv_news_title, 20);
        sparseIntArray.put(R$id.rv_topic_news, 21);
        sparseIntArray.put(R$id.bottom_divider, 22);
        sparseIntArray.put(R$id.toolbar, 23);
        sparseIntArray.put(R$id.tabLayout, 24);
        sparseIntArray.put(R$id.vp_topic_detail, 25);
        sparseIntArray.put(R$id.clPublished, 26);
        sparseIntArray.put(R$id.btnPublished, 27);
    }

    public z(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 28, f19336f0, f19337g0));
    }

    public void M(TopicDetailInfo topicDetailInfo) {
        this.f19329c0 = topicDetailInfo;
    }

    public void i() {
        synchronized (this) {
            this.f19339e0 = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.f19339e0 != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.f19339e0 = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public z(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[14], objArr[16], objArr[12], objArr[2], objArr[20], objArr[15], objArr[18], objArr[10], objArr[17], objArr[9], objArr[13], objArr[22], objArr[27], objArr[26], objArr[5], objArr[1], objArr[8], objArr[11], objArr[4], objArr[7], objArr[19], objArr[21], objArr[24], objArr[23], objArr[6], objArr[25], objArr[3]);
        this.f19339e0 = -1;
        RelativeLayout relativeLayout = objArr[0];
        this.f19338d0 = relativeLayout;
        relativeLayout.setTag((Object) null);
        G(view);
        t();
    }
}
