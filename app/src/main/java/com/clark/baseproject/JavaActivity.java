package com.clark.baseproject;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.clark.baseproject.retrofitdemo.GitHubService;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class JavaActivity extends AppCompatActivity {

    private String TAG = "JavaActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        retrofitRequest();
//        commonRxJavaObservable();
//        commonRxJavamapAndNull();

        Single<String> just = Single.just("test");
        just.subscribeOn();
        just.subscribe(new SingleObserver<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG,"Disposable: "+ d);
            }

            @Override
            public void onSuccess(String s) {
                Log.d(TAG,"onSuccess: "+ s);

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

//    private void retrofitRequest() {
//        Retrofit retrofit = new Retrofit
//                .Builder()
//                .baseUrl("https://api.github.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        GitHubService gitHubService = retrofit.create(GitHubService.class);
//
//        Call<Object> obj = gitHubService.listReposOBJ("octocat");
//        obj.enqueue(new Callback<Object>() {
//            @Override
//            public void onResponse(Call<Object> call, Response<Object> response) {
//                System.out.println("响应: " + response.body());
//
//            }
//
//            @Override
//            public void onFailure(Call<Object> call, Throwable t) {
//
//            }
//        });
//    }

    /**
     * Lesson 01 简单的RxJava2的使用
     */
    public void commonRxJavaObservable() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                System.out.println("Observable emitter 1:" + "\n");
                emitter.onNext(1);
                System.out.println("Observable emitter 2:" + "\n");
                emitter.onNext(2);
                System.out.println("Observable emitter 3:" + "\n");
                emitter.onNext(3);
                System.out.println("Observable emitter 4:" + "\n");
                emitter.onNext(4);
                System.out.println("Observable emitter 5:" + "\n");
                emitter.onNext(5);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    private int i;
                    private Disposable mDisposable;


                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                        System.out.println("Observer onSubscribe :" + d);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        i++;
                        if (i == 3) {
                            mDisposable.dispose();
                        }
                        System.out.println("Observer onNext :" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("Observer onError :" + e);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Observer onComplete :");

                    }
                });

    }

    public void commonRxJavamapAndNull() {
        Observable.create(new ObservableOnSubscribe<Response>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Response> e) throws Exception {
                Request.Builder builder = new Request.Builder()
                        .url("http://api.avatardata.cn/MobilePlace/LookUp?key=ec47b85086be4dc8b5d941f5abd37a4e&mobileNumber=13021671512")
                        .get();
                Request request = builder.build();
                Call call = new OkHttpClient().newCall(request);
                Response response = call.execute();
                e.onNext(response);
            }
        }).map(new Function<Response, MobileAddress>() {
            @Override
            public MobileAddress apply(@NonNull Response response) throws Exception {


                if (response.isSuccessful()) {
                    ResponseBody body = response.body();
                    if (body != null) {
                        Log.e(TAG, "map:转换前:" + response.body());
                        return null/*new Gson().fromJson(body.string(), MobileAddress.class)*/;
                    }
                }
                return null;
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<MobileAddress>() {
                    @Override
                    public void accept(@NonNull MobileAddress s) throws Exception {
                        Log.e(TAG, "doOnNext: 保存成功：" + s.toString() + "\n");
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MobileAddress>() {
                    @Override
                    public void accept(@NonNull MobileAddress data) throws Exception {
                        Log.e(TAG, "成功:" + data.toString() + "\n");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Log.e(TAG, "失败：" + throwable.getMessage() + "\n");
                    }

                });
    }

    public void test() {


        Flowable.interval(1, TimeUnit.SECONDS)
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        Log.e(TAG, "accept: doOnNext : " + aLong);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        Log.e(TAG, "accept: 设置文本 ：" + aLong);
//                        mRxOperatorsText.append("accept: 设置文本 ："+aLong +"\n");
                    }
                });
    }

}
