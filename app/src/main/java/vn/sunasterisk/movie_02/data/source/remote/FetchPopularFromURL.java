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
import vn.sunasterisk.movie_02.constant.PopularEntity;
import vn.sunasterisk.movie_02.data.model.Popular;
import vn.sunasterisk.movie_02.data.source.PopularDataSource;

public class FetchPopularFromURL extends AsyncTask<String, Void, List<Popular>> {
    private PopularDataSource.OnFetchDataListener<Popular> mListener;
    private Exception mException;

    public void setListener(PopularDataSource.OnFetchDataListener<Popular> listener) {
        mListener = listener;
    }

    @Override
    protected List<Popular> doInBackground(String... strings) {
        String url = strings[0];
        try {
            String data = getStringDataFromUrl(url);
            return getPopularFromStringData(data);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Popular> getPopularFromStringData(String data)
            throws JSONException {
        List<Popular> populars = new ArrayList<>();
        JSONObject object = new JSONObject(data);
        JSONArray jsonArray =
                object.getJSONArray(PopularEntity.POPULAR);
        for (int i = 0; i <= jsonArray.length(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            String popularity =
                    jsonObject.getString(PopularEntity.POPULARITY);
            String video =
                    jsonObject.getString(PopularEntity.VIDEO);
            String posterPath =
                    jsonObject.getString(PopularEntity.POSTERPATH);
            String id =
                    jsonObject.getString(PopularEntity.ID);
            String backdropPath =
                    jsonObject.getString(PopularEntity.BACKDROPPATH);
            String title =
                    jsonObject.getString(PopularEntity.TITLE);
            String voteAverage =
                    jsonObject.getString(PopularEntity.VOTEAVERAGE);
            String overView =
                    jsonObject.getString(PopularEntity.OVERVIEW);
            String releaseDate =
                    jsonObject.getString(PopularEntity.RELEASEDATE);

            Popular popular = new Popular(popularity, video,
                    posterPath, id, backdropPath,
                    title, voteAverage,
                    overView, releaseDate);
            populars.add(popular);
        }
        return null;
    }

    private String getStringDataFromUrl(String urlString)
            throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(Constant.REQUEST_METHOD_GET);
        connection.setConnectTimeout(Constant.CONNECT_TIME_OUT);
        connection.setReadTimeout(Constant.READ_TIME_OUT);
        connection.setDoOutput(true);

        BufferedReader br =
                new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append(Constant.BREAK_LINE);
        }

        return sb.toString();
    }

    @Override
    protected void onPostExecute(List<Popular> populars) {
        if (mListener == null) {
            return;
        }
        if (mException == null) {
            mListener.onFetchDataSuccess(populars);
        } else
            mListener.onFetchDataFailure(mException);
    }
}
