package vn.sunasterisk.movie_02.screen.genres.tablayout.upcoming;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.sunasterisk.movie_02.R;
import vn.sunasterisk.movie_02.data.model.UpComing;

public class UpComingAdapter extends RecyclerView.Adapter<UpComingAdapter.ViewHolder> {
    private List<UpComing> mUpComings;

    public UpComingAdapter(List<UpComing> upComings) {
        mUpComings = upComings;
    }

    @NonNull
    @Override
    public UpComingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_trailer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UpComing upComing = mUpComings.get(position);
        holder.mTextTitle.setText(upComing.getTitle());
    }

    @Override
    public int getItemCount() {
        return mUpComings == null ? 0 : mUpComings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextTitle = itemView.findViewById(R.id.text_title);
        }
    }
}
