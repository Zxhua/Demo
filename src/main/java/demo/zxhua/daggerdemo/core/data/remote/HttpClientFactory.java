package demo.zxhua.daggerdemo.core.data.remote;


import java.util.concurrent.TimeUnit;

import demo.zxhua.daggerdemo.BuildConfig;
import demo.zxhua.daggerdemo.core.data.remote.interceptor.HeadersInterceptor;
import demo.zxhua.daggerdemo.core.data.remote.interceptor.LogerInterceptor;
import okhttp3.OkHttpClient;

/**
 * Created by Zxhua on 2017/9/11 0011.
 */

public class HttpClientFactory {
    private static final int DEFAUT_CONNECT_TIMEOUT = 10;
    private static final int DEFAUT_READ_TIMEOUT = 10;
    private static final long DEFAUT_DOWNLOAD_READ_TIMEOUT = 60;
    private static final OkHttpClient.Builder builder;
    private static final OkHttpClient.Builder downloadBuilder;

    static {
        downloadBuilder = new OkHttpClient.Builder()
                .connectTimeout(DEFAUT_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAUT_READ_TIMEOUT, TimeUnit.SECONDS);
        builder = new OkHttpClient.Builder()
                .connectTimeout(DEFAUT_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAUT_READ_TIMEOUT, TimeUnit.SECONDS);
        builder.addInterceptor(new HeadersInterceptor()).hostnameVerifier((s, sslSession) -> true);
        if (BuildConfig.DEBUG){
            builder.addInterceptor(new LogerInterceptor());
        }
    }
    public static OkHttpClient.Builder defaultClientBuilder() {
        return builder;
    }

    public static OkHttpClient.Builder downloadClient() {
        return downloadBuilder.addInterceptor(new HeadersInterceptor());
    }


}
