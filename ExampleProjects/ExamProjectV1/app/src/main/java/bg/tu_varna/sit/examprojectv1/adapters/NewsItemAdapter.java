package bg.tu_varna.sit.examprojectv1.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import bg.tu_varna.sit.examprojectv1.R;
import bg.tu_varna.sit.examprojectv1.models.News;
import bg.tu_varna.sit.examprojectv1.views.NewsItemHolder;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class NewsItemAdapter extends RecyclerView.Adapter<NewsItemHolder> {

    private ArrayList<News> news;

    public NewsItemAdapter(ArrayList<News> news) {
        this.news = news;
    }

    @NonNull
    @Override
    public NewsItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item, parent, false);
        return new NewsItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsItemHolder holder, int position) {
        News item = news.get(position);
        holder.setTittle(item.getTitle());
        holder.setContent(item.getContent());
        holder.setOnLongClickListener(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public void addNews(News news) {
        this.news.add(0, news);
        //notifyItemChanged(0);
        notifyDataSetChanged();
    }
}
