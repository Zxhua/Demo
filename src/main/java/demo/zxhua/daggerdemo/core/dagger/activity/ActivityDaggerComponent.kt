package demo.zxhua.daggerdemo.core.dagger.activity

import dagger.Component
import demo.zxhua.daggerdemo.core.dagger.application.ApplicationComponent
import demo.zxhua.daggerdemo.core.dagger.application.ApplicationComponentExposes
import demo.zxhua.daggerdemo.ui.login.LoginActivity
import demo.zxhua.daggerdemo.ui.refreshedit.EditRefreshActivity
import javax.inject.Scope

/**
 * Created by Zxhua on 2017/10/30 0030.
 */

@Scope
annotation class ActivityScope

@Scope
annotation class ForActivity

interface ActivityComponentEpose : ApplicationComponentExposes, ActivityMoudel.Expose

interface ActivityComponentInject {

    fun inject(loginActivity: LoginActivity)

    fun inject(editRefreshActivity: EditRefreshActivity)
}


@ActivityScope
@Component(
        dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(ActivityMoudel::class))
interface ActivityComponent : ActivityComponentInject, ApplicationComponentExposes, ActivityMoudel.Expose {
    companion object Initializer {
        fun init(daggerActivity: DaggerActivity, applicationComponent: ApplicationComponent): ActivityComponent? =null
//                DaggerActivityComponent.builder()
//                .activityMoudel(ActivityMoudel(daggerActivity))
//                .applicationComponent(applicationComponent)
//                .build()
    }
}