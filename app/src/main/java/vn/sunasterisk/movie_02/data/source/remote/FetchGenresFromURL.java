package vn.sunasterisk.movie_02.data.source.remote;

import android.os.AsyncTask;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import vn.sunasterisk.movie_02.constant.Constant;
import vn.sunasterisk.movie_02.data.model.TrailerMovie;
import vn.sunasterisk.movie_02.data.source.MovieDataSource;
import vn.sunasterisk.movie_02.utils.ParseMovieFromJson;

public class FetchGenresFromURL extends AsyncTask<String, Void, List<TrailerMovie>> {
    private MovieDataSource.OnFetchDataListener<TrailerMovie> mListener;
    private Exception mException;

    public FetchGenresFromURL(MovieDataSource.OnFetchDataListener<TrailerMovie> listener) {
        mListener = listener;
    }

    @Override
    protected List<TrailerMovie> doInBackground(String... strings) {
        String url = strings[0];
        try {
            String data = getStringDataFromURL(url);
            ParseMovieFromJson parseMovieFromJson = new ParseMovieFromJson(data);
            return parseMovieFromJson.getGenresFromData();
        } catch (IOException | JSONException e) {
            mException = e;
        }
        return null;
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
    protected void onPostExecute(List<TrailerMovie> nowPlayings) {
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
