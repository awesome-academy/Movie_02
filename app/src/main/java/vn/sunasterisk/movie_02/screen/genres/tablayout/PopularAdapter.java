package vn.sunasterisk.movie_02.screen.genres.tablayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.sunasterisk.movie_02.R;
import vn.sunasterisk.movie_02.data.model.Popular;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    private List<Popular> mPopulars;

    public PopularAdapter(List<Popular> populars) {
        mPopulars = populars;
    }

    @NonNull
    @Override
    public PopularAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_popular, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.ViewHolder holder, int position) {
        Popular popular = mPopulars.get(position);
        holder.mTextTitle.setText(popular.getTitle());
    }

    @Override
    public int getItemCount() {
        return mPopulars == null ? 0 : mPopulars.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageFilm;
        private TextView mTextTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageFilm = itemView.findViewById(R.id.image_film);
            mTextTitle = itemView.findViewById(R.id.text_title);
        }
    }
}
