package vn.sunasterisk.movie_02.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import vn.sunasterisk.movie_02.constant.MovieEntity;
import vn.sunasterisk.movie_02.data.model.TrailerMovie;

public class ParseMovieFromJson {
    private String mJson;

    public ParseMovieFromJson(String json) {
        mJson = json;
    }

    public ParseMovieFromJson() {

    }

    public List<TrailerMovie> getGenresFromData() throws JSONException {
        List<TrailerMovie> genress = new ArrayList<>();
        JSONObject object = new JSONObject(mJson);
        JSONArray array = object.getJSONArray(MovieEntity.MOVIE);
        for (int i = 0; i < array.length(); i++) {
            JSONObject jsonObject = (JSONObject) array.get(i);
            String popularity = jsonObject.getString(MovieEntity.POPULARITY);
            String video = jsonObject.getString(MovieEntity.VIDEO);
            String posterPath = jsonObject.getString(MovieEntity.POSTERPATH);
            String id = jsonObject.getString(MovieEntity.ID);
            String backdropPath = jsonObject.getString(MovieEntity.BACKDROPPATH);
            String title = jsonObject.getString(MovieEntity.TITLE);
            String voteAverage = jsonObject.getString(MovieEntity.VOTEAVERAGE);
            String overView = jsonObject.getString(MovieEntity.OVERVIEW);
            String releaseDate = jsonObject.getString(MovieEntity.RELEASEDATE);

            TrailerMovie genres = new TrailerMovie(popularity, video, posterPath, id,
                    backdropPath, title, voteAverage, overView, releaseDate);
            genress.add(genres);
        }
        return genress;
    }
}
