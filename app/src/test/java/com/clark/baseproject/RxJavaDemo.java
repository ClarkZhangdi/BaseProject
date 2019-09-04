package com.clark.baseproject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Clark Zhang
 * @date 2019/9/4.
 * Description :
 */
public class RxJavaDemo {
    public static void main(String[] args) {
//        RxJavaDemo demo = new RxJavaDemo();
//        demo.commonRxJavaObservable();
        System.out.println("Observable emitter 1:" + "\n");

    }

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
}
