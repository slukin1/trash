package zendesk.support.guide;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.zendesk.guide.sdk.R$id;
import com.zendesk.guide.sdk.R$layout;
import com.zendesk.guide.sdk.R$string;
import com.zendesk.logger.Logger;
import com.zendesk.service.ZendeskCallback;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import lz.a;
import mz.c;
import zendesk.support.HelpCenterProvider;
import zendesk.support.SearchArticle;

class HelpSearchRecyclerViewAdapter extends RecyclerView.Adapter {
    private static final int TYPE_ARTICLE = 531;
    private static final int TYPE_NO_RESULTS = 441;
    private static final int TYPE_PADDING = 423;
    /* access modifiers changed from: private */
    public final HelpCenterProvider helpCenterProvider;
    /* access modifiers changed from: private */
    public final HelpCenterConfiguration helpCenterUiConfig;
    /* access modifiers changed from: private */
    public String query;
    private boolean resultsCleared = false;
    private List<SearchArticle> searchArticles;

    public class HelpSearchViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        private TextView subtitleTextView;
        private TextView titleTextView;

        public HelpSearchViewHolder(View view, Context context2) {
            super(view);
            this.titleTextView = (TextView) view.findViewById(R$id.title);
            this.subtitleTextView = (TextView) view.findViewById(R$id.subtitle);
            this.context = context2;
        }

        public void bindTo(final SearchArticle searchArticle) {
            int i11;
            if (searchArticle == null || searchArticle.getArticle() == null) {
                Logger.d(HelpCenterActivity.LOG_TAG, "The article was null, cannot bind the view.", new Object[0]);
                return;
            }
            String title = searchArticle.getArticle().getTitle() != null ? searchArticle.getArticle().getTitle() : "";
            if (HelpSearchRecyclerViewAdapter.this.query == null) {
                i11 = -1;
            } else {
                i11 = title.toLowerCase(Locale.getDefault()).indexOf(HelpSearchRecyclerViewAdapter.this.query.toLowerCase(Locale.getDefault()));
            }
            if (i11 != -1) {
                SpannableString spannableString = new SpannableString(title);
                spannableString.setSpan(new StyleSpan(1), i11, HelpSearchRecyclerViewAdapter.this.query.length() + i11, 18);
                this.titleTextView.setText(spannableString);
            } else {
                this.titleTextView.setText(title);
            }
            this.subtitleTextView.setText(this.context.getString(R$string.help_search_subtitle_format, new Object[]{searchArticle.getCategory().getName(), searchArticle.getSection().getName()}));
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    HelpSearchRecyclerViewAdapter.this.helpCenterProvider.submitRecordArticleView(searchArticle.getArticle(), c.c(searchArticle.getArticle().getLocale()), new ZendeskCallback<Void>() {
                        public void onError(a aVar) {
                            Logger.d(HelpCenterActivity.LOG_TAG, "Error submitting Help Center reporting: [reason] %s [isNetworkError] %s [status] %d", aVar.getReason(), Boolean.valueOf(aVar.b()), Integer.valueOf(aVar.getStatus()));
                        }

                        public void onSuccess(Void voidR) {
                        }
                    });
                    ViewArticleActivity.builder(searchArticle.getArticle()).show(HelpSearchViewHolder.this.itemView.getContext(), HelpSearchRecyclerViewAdapter.this.helpCenterUiConfig.getConfigurations());
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
        }
    }

    public class NoResultsViewHolder extends RecyclerView.ViewHolder {
        public NoResultsViewHolder(View view) {
            super(view);
        }
    }

    public class PaddingViewHolder extends RecyclerView.ViewHolder {
        public PaddingViewHolder(View view) {
            super(view);
        }
    }

    public HelpSearchRecyclerViewAdapter(List<SearchArticle> list, String str, HelpCenterConfiguration helpCenterConfiguration, HelpCenterProvider helpCenterProvider2) {
        this.searchArticles = list;
        this.query = str;
        this.helpCenterUiConfig = helpCenterConfiguration;
        this.helpCenterProvider = helpCenterProvider2;
    }

    private int getPaddingExtraItem() {
        return this.helpCenterUiConfig.isContactUsButtonVisible() ? 1 : 0;
    }

    public void clearResults() {
        this.resultsCleared = true;
        this.searchArticles = Collections.emptyList();
        this.query = "";
        notifyDataSetChanged();
    }

    public int getItemCount() {
        if (this.resultsCleared) {
            return 0;
        }
        return Math.max(this.searchArticles.size() + getPaddingExtraItem(), 1);
    }

    public int getItemViewType(int i11) {
        if (i11 == 0 && this.searchArticles.size() == 0) {
            return 441;
        }
        return (i11 <= 0 || i11 != this.searchArticles.size()) ? TYPE_ARTICLE : TYPE_PADDING;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        if (TYPE_ARTICLE == getItemViewType(i11)) {
            ((HelpSearchViewHolder) viewHolder).bindTo(this.searchArticles.get(i11));
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        if (i11 == TYPE_PADDING) {
            return new PaddingViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.zs_row_padding, viewGroup, false));
        }
        if (i11 == 441) {
            return new NoResultsViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.zs_row_no_articles_found, viewGroup, false));
        }
        if (i11 != TYPE_ARTICLE) {
            return null;
        }
        return new HelpSearchViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.zs_row_search_article, viewGroup, false), viewGroup.getContext());
    }

    public void update(List<SearchArticle> list, String str) {
        this.resultsCleared = false;
        this.searchArticles = list;
        this.query = str;
        notifyDataSetChanged();
    }
}
