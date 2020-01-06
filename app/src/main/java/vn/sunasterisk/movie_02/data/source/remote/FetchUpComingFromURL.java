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
import vn.sunasterisk.movie_02.constant.UpComingEntity;
import vn.sunasterisk.movie_02.data.model.UpComing;
import vn.sunasterisk.movie_02.data.source.MovieDataSource;

public class FetchUpComingFromURL extends AsyncTask<String, Void, List<UpComing>> {
    private MovieDataSource.OnFetchDataListener mListener;
    private Exception mException;

    public void setListener(MovieDataSource.OnFetchDataListener<UpComing> listener) {
        mListener = listener;
    }

    @Override
    protected List<UpComing> doInBackground(String... strings) {
        String url = strings[0];
        try {
            String data = getStringDataFromURL(url);
            return getUpComingFromData(data);
        } catch (IOException | JSONException e) {
            mException = e;
        }
        return null;
    }

    private List<UpComing> getUpComingFromData(String data) throws JSONException {
        List<UpComing> comings = new ArrayList<>();
        JSONObject object = new JSONObject(data);
        JSONArray array = object.getJSONArray(UpComingEntity.UPCOMING);
        for (int i = 0; i < array.length(); i++) {
            JSONObject jsonObject = (JSONObject) array.get(i);
            String popularity = jsonObject.getString(UpComingEntity.POPULARITY);
            String video = jsonObject.getString(UpComingEntity.VIDEO);
            String posterPath = jsonObject.getString(UpComingEntity.POSTERPATH);
            String id = jsonObject.getString(UpComingEntity.ID);
            String backdropPath = jsonObject.getString(UpComingEntity.BACKDROPPATH);
            String title = jsonObject.getString(UpComingEntity.TITLE);
            String voteAverage = jsonObject.getString(UpComingEntity.VOTEAVERAGE);
            String overView = jsonObject.getString(UpComingEntity.OVERVIEW);
            String releaseDate = jsonObject.getString(UpComingEntity.RELEASEDATE);

            UpComing upComing = new UpComing(popularity, video, posterPath, id,
                    backdropPath, title, voteAverage, overView, releaseDate);
            comings.add(upComing);
        }
        return comings;
    }

    public String getStringDataFromURL(String urlString) throws IOException {
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
    protected void onPostExecute(List<UpComing> upComings) {
        if (mListener == null) {
            return;
        }
        if (mException == null) {
            mListener.onFetchDataSuccess(upComings);
        } else {
            mListener.onFetchDataFailure(mException);
        }
    }
}
