package demo.zxhua.daggerdemo.core.dagger.fragment

import dagger.Component
import demo.zxhua.daggerdemo.core.dagger.activity.ActivityComponent
import demo.zxhua.daggerdemo.core.dagger.activity.ActivityMoudel
import demo.zxhua.daggerdemo.core.dagger.application.ApplicationModule
import demo.zxhua.daggerdemo.core.dagger.application.UtilsModule
import demo.zxhua.daggerdemo.core.dagger.application.VMModule
import demo.zxhua.daggerdemo.ui.login.LoginFragment
import demo.zxhua.daggerdemo.ui.refreshedit.EditRefreshFragment
import javax.inject.Scope

/**
 * Created by Zxhua on 2017/10/30 0030.
 */
@Scope
annotation class FragmentScope

interface FragmentComonpentExposes : ActivityMoudel.Expose, ApplicationModule.Exposes, VMModule.Exposes, UtilsModule.Exposes


interface FragmentComponentInject {
    fun inject(loginFragment: LoginFragment)

    fun inject(editRefreshFragment: EditRefreshFragment)

}

@FragmentScope
@Component(dependencies = arrayOf(ActivityComponent::class), modules = arrayOf(FragmentMoudel::class))
interface FragmentComonpent : FragmentComponentInject, ActivityMoudel.Expose, ApplicationModule.Exposes, VMModule.Exposes, UtilsModule.Exposes {
    object Initializer {
        @JvmStatic
        fun init(fragment: DaggerFragment, activityComponent: ActivityComponent): FragmentComonpent ?{
//            return DaggerFragmentComonpent.builder()
//                    .activityComponent(activityComponent)
//                    .fragmentMoudel(FragmentMoudel(fragment))
//                    .build()
            return null
        }
    }
}
