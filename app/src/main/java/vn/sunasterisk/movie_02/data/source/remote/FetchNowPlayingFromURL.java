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
import vn.sunasterisk.movie_02.constant.NowPlayingEntity;
import vn.sunasterisk.movie_02.data.model.NowPlaying;
import vn.sunasterisk.movie_02.data.source.MovieDataSource;

public class FetchNowPlayingFromURL extends AsyncTask<String, Void, List<NowPlaying>> {
    private MovieDataSource.OnFetchDataListener<NowPlaying> mListener;
    private Exception mException;

    public void setListener(MovieDataSource.OnFetchDataListener<NowPlaying> listener) {
        mListener = listener;
    }

    @Override
    protected List<NowPlaying> doInBackground(String... strings) {
        String url = strings[0];
        try {
            String data = getStringDataFromURL(url);
            return getNowPlayingFromData(data);
        } catch (IOException | JSONException e) {
            mException = e;
        }
        return null;
    }

    private List<NowPlaying> getNowPlayingFromData(String data) throws JSONException {
        List<NowPlaying> playings = new ArrayList<>();
        JSONObject object = new JSONObject(data);
        JSONArray array = object.getJSONArray(NowPlayingEntity.NOWPLAYING);
        for (int i = 0; i < array.length(); i++) {
            JSONObject jsonObject = (JSONObject) array.get(i);
            String popularity = jsonObject.getString(NowPlayingEntity.POPULARITY);
            String video = jsonObject.getString(NowPlayingEntity.VIDEO);
            String posterPath = jsonObject.getString(NowPlayingEntity.POSTERPATH);
            String id = jsonObject.getString(NowPlayingEntity.ID);
            String backdropPath = jsonObject.getString(NowPlayingEntity.BACKDROPPATH);
            String title = jsonObject.getString(NowPlayingEntity.TITLE);
            String voteAverage = jsonObject.getString(NowPlayingEntity.VOTEAVERAGE);
            String overView = jsonObject.getString(NowPlayingEntity.OVERVIEW);
            String releaseDate = jsonObject.getString(NowPlayingEntity.RELEASEDATE);

            NowPlaying playing = new NowPlaying(popularity, video, posterPath, id,
                    backdropPath, title, voteAverage, overView, releaseDate);
            playings.add(playing);
        }
        return playings;
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
    protected void onPostExecute(List<NowPlaying> nowPlayings) {
        if (mListener == null) {
            return;
        }
        if (mException == null) {
            mListener.onFetchDataSuccess(nowPlayings);
        } else {
            mListener.onFetchDataFailure(mException);
        }
    }
}
