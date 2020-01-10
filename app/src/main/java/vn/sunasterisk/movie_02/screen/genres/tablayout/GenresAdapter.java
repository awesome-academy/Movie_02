package vn.sunasterisk.movie_02.screen.genres.tablayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.sunasterisk.movie_02.R;
import vn.sunasterisk.movie_02.data.model.TrailerMovie;

public class GenresAdapter extends RecyclerView.Adapter<GenresAdapter.ViewHolder> {
    private List<TrailerMovie> mGenres;
    private OnClickNowPlayingListener mNowPlayingListener;
    private OnClickPoplarsListener mPoplarsListener;
    private OnClickTopRateListener mTopRateListener;
    private OnClickUpComingListener mUpComingListener;

    public void setData(List<TrailerMovie> data) {
        mGenres = data;
    }

    public GenresAdapter(OnClickPoplarsListener onClickPoplarsListener) {
        mPoplarsListener = onClickPoplarsListener;
    }

    public GenresAdapter(OnClickNowPlayingListener onClickNowPlayingListener) {
        mNowPlayingListener = onClickNowPlayingListener;
    }

    public GenresAdapter(OnClickTopRateListener onClickTopRateListener) {
        mTopRateListener = onClickTopRateListener;
    }

    public GenresAdapter(OnClickUpComingListener onClickUpComingListener) {
        mUpComingListener = onClickUpComingListener;
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
        TrailerMovie nowPlaying = mGenres.get(position);
        String url = nowPlaying.getMovieImageApi();
        holder.mTextTitle.setText(nowPlaying.getTitle());
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextTitle = itemView.findViewById(R.id.text_title);
            mImageMovie = itemView.findViewById(R.id.image_movie);
        }
    }

    public interface OnClickNowPlayingListener {
        void onClickNowPlayingListener(TrailerMovie nowPlaying);
    }

    public interface OnClickPoplarsListener {
        void onPoplarsClickListener(TrailerMovie popular);
    }

    public interface OnClickTopRateListener {
        void onTopRateClickListener(TrailerMovie toprate);
    }

    public interface OnClickUpComingListener {
        void onUpComingClickListener(TrailerMovie upcoming);
    }
}
