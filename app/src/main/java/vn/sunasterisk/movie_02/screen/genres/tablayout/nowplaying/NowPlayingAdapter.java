package vn.sunasterisk.movie_02.screen.genres.tablayout.nowplaying;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.sunasterisk.movie_02.R;
import vn.sunasterisk.movie_02.data.model.NowPlaying;

public class NowPlayingAdapter extends RecyclerView.Adapter<NowPlayingAdapter.ViewHolder> {
    private List<NowPlaying> mNowPlayings;

    public NowPlayingAdapter(List<NowPlaying> nowPlayings) {
        mNowPlayings = nowPlayings;
    }

    @NonNull
    @Override
    public NowPlayingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_trailer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NowPlaying playing = mNowPlayings.get(position);
        holder.mTextTitle.setText(playing.getTitle());
    }

    @Override
    public int getItemCount() {
        return mNowPlayings == null ? 0 : mNowPlayings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextTitle = itemView.findViewById(R.id.text_title);
        }
    }
}
