package com.blink.dagger.democache;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by lucky on 2017/4/14.
 */
public interface GirlService
{
    @GET("random/data/福利/1")
    Observable<GirlBean> getMeiZhi();
}
