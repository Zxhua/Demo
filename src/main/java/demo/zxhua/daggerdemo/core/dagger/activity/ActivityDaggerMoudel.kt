package demo.zxhua.daggerdemo.core.dagger.activity

import android.app.Activity
import android.content.Context
import android.support.v4.app.FragmentManager
import dagger.Provides

/**
 * Created by Zxhua on 2017/10/30 0030.
 */


class ActivityMoudel(activity: DaggerActivity) {
    val daggerAvtivity: DaggerActivity = activity

    @Provides
    @ActivityScope
    @ForActivity
    fun provideActivityCodext(): Context = daggerAvtivity

    @Provides
    @ActivityScope
    fun provideActivity(): Activity = daggerAvtivity

    @Provides
    @ActivityScope
    fun provideFragmentManagerV4() = daggerAvtivity.supportFragmentManager

    interface Expose {
        @ForActivity
        fun provideActivityContext(): Context

        fun provideActivity(): Activity

        fun provideFragmentManagerV4(): FragmentManager
    }
}
