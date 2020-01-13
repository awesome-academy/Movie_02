package vn.sunasterisk.movie_02.screen.genres.tablayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.sunasterisk.movie_02.R;
import vn.sunasterisk.movie_02.data.model.TrailerMovie;

public class GenresAdapter extends RecyclerView.Adapter<GenresAdapter.ViewHolder> {
    private List<TrailerMovie> mGenres;
    private OnClickGenresListener mGenresListener;

    public void setData(List<TrailerMovie> data) {
        mGenres = data;
    }

    public GenresAdapter(OnClickGenresListener onClickNowPlayingListener) {
        mGenresListener = onClickNowPlayingListener;
    }

    public GenresAdapter(List<TrailerMovie> data) {
        mGenres = data;
    }

    @NonNull
    @Override
    public GenresAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_trailer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TrailerMovie genres = mGenres.get(position);
        String url = genres.getMovieImageApi();
        holder.mTextTitle.setText(genres.getTitle());
        Glide.with(holder.itemView.getContext()).load(url)
                .placeholder(R.drawable.loading_shape)
                .into(holder.mImageMovie);
    }

    @Override
    public int getItemCount() {
        return mGenres == null ? 0 : mGenres.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextTitle;
        private ImageView mImageMovie;
        private LinearLayout mLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initCoponents();
            registerListener();
        }

        private void registerListener() {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    mGenresListener.onClickGenresListener(mGenres.get(position));
                }
            });
        }

        private void initCoponents() {
            mTextTitle = itemView.findViewById(R.id.text_title);
            mImageMovie = itemView.findViewById(R.id.image_movie);
            mLayout = itemView.findViewById(R.id.view_movie);
        }
    }

    public interface OnClickGenresListener {
        void onClickGenresListener(TrailerMovie genres);
    }
}
