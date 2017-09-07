package io.github.rajdeep1008.wishfietest.network;

import io.github.rajdeep1008.wishfietest.model.ResponseModel;
import io.github.rajdeep1008.wishfietest.model.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by rajdeep1008 on 4/9/17.
 */

public interface ApiService {
    @GET()
    Call<ResponseModel<Post>> getData(@Url String url);
}
