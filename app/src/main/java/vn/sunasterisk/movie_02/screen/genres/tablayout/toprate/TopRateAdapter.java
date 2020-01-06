package vn.sunasterisk.movie_02.screen.genres.tablayout.toprate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.sunasterisk.movie_02.R;
import vn.sunasterisk.movie_02.data.model.TopRate;

public class TopRateAdapter extends RecyclerView.Adapter<TopRateAdapter.ViewHolder> {
    private List<TopRate> mTopRates;

    public TopRateAdapter(List<TopRate> topRates) {
        mTopRates = topRates;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_trailer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TopRate topRate = mTopRates.get(position);
        holder.mTextTitle.setText(topRate.getTitle());
    }

    @Override
    public int getItemCount() {
        return mTopRates == null ? 0 : mTopRates.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextTitle = itemView.findViewById(R.id.text_title);
        }
    }
}
