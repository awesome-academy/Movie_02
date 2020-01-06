package vn.sunasterisk.movie_02.data.source.remote;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import vn.sunasterisk.movie_02.constant.Constant;
import vn.sunasterisk.movie_02.constant.TopRateEntity;
import vn.sunasterisk.movie_02.data.model.TopRate;
import vn.sunasterisk.movie_02.data.source.MovieDataSource;

public class FetchTopRateFromURL extends AsyncTask<String, Void, List<TopRate>> {
    private MovieDataSource.OnFetchDataListener<TopRate> mListener;
    private Exception mException;

    public void setListener(MovieDataSource.OnFetchDataListener<TopRate> listener) {
        mListener = listener;
    }

    @Override
    protected List<TopRate> doInBackground(String... strings) {
        String url = strings[0];
        try {
            String data = getStringDataFromURL(url);
            return getTopRateFromData(data);
        } catch (IOException | JSONException e) {
            mException = e;
        }
        return null;
    }

    private List<TopRate> getTopRateFromData(String data) throws JSONException {
        List<TopRate> topRates = new ArrayList<>();
        JSONObject object = new JSONObject(data);
        JSONArray array = object.getJSONArray(TopRateEntity.TOPRATE);
        for (int i = 0; i < array.length(); i++) {
            JSONObject jsonObject = (JSONObject) array.get(i);
            String popularity = jsonObject.getString(TopRateEntity.POPULARITY);
            String video = jsonObject.getString(TopRateEntity.VIDEO);
            String posterPath = jsonObject.getString(TopRateEntity.POSTERPATH);
            String id = jsonObject.getString(TopRateEntity.ID);
            String backdropPath = jsonObject.getString(TopRateEntity.BACKDROPPATH);
            String title = jsonObject.getString(TopRateEntity.TITLE);
            String voteAverage = jsonObject.getString(TopRateEntity.VOTEAVERAGE);
            String overView = jsonObject.getString(TopRateEntity.OVERVIEW);
            String releaseDate = jsonObject.getString(TopRateEntity.RELEASEDATE);

            TopRate topRate = new TopRate(popularity, video, posterPath, id,
                    backdropPath, title, voteAverage, overView, releaseDate);
            topRates.add(topRate);
        }
        return topRates;
    }

    private String getStringDataFromURL(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(Constant.REQUEST_METHOD_GET);
        connection.setConnectTimeout(Constant.CONNECT_TIME_OUT);
        connection.setReadTimeout(Constant.READ_TIME_OUT);
        connection.setDoOutput(true);

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append(Constant.BREAK_LINE);
        }
        br.close();
        connection.disconnect();
        return sb.toString();
    }

    @Override
    protected void onPostExecute(List<TopRate> topRates) {
        if (mListener == null) {
            return;
        }
        if (mException == null) {
            mListener.onFetchDataSuccess(topRates);
        } else {
            mListener.onFetchDataFailure(mException);
        }
    }
}
