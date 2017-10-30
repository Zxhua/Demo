package demo.zxhua.daggerdemo.core.data.remote.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Zxhua on 2017/9/11 0011.
 */

public class HeadersInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder()
//                .header("User-Agent", "Andorid#" + SystemUtil.getAppVersionName())
                .method(request.method(), request.body());
//        String token = SharedPrefHelper.getInstance().getToken("token");
//        if (!TextUtils.isEmpty(token)) {
//            requestBuilder.header("Authorization", "Bearer " + token);
//        }
        Request newRequest = requestBuilder.build();
        return chain.proceed(newRequest);
    }
}
