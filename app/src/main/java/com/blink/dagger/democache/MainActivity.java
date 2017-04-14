package com.blink.dagger.democache;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    ImageView girlPic;
    TextView tvCommit;
    TextView tvUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        girlPic = (ImageView) findViewById(R.id.iv_girl);
        tvCommit = (TextView) findViewById(R.id.tv_commit);
        tvUrl = (TextView) findViewById(R.id.tv_url);

        tvCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitClient.singletonGank(MainActivity.this).getMeiZhi()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<GirlBean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(GirlBean girlBean) {
                                tvUrl.setText(girlBean.getResults().get(0).getUrl());
                                Log.d("luck","pic url :"+girlBean.getResults().get(0).getUrl());
                                Log.d("luck","current time :"+TimeUtils.getTime(System.currentTimeMillis()));
                                Glide.with(MainActivity.this).load(girlBean.getResults().get(0).getUrl()).into(girlPic);
                            }
                        });
            }
        });
    }
}
