package io.tohure.graphqlwithdaggerkotlin.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import io.tohure.graphqlwithdaggerkotlin.app.GraphApplication
import io.tohure.graphqlwithdaggerkotlin.di.anotation.PerActivity
import io.tohure.graphqlwithdaggerkotlin.di.module.ActivityBuilder
import io.tohure.graphqlwithdaggerkotlin.di.module.AppModule
import io.tohure.graphqlwithdaggerkotlin.di.module.GraphModule
import javax.inject.Singleton

@PerActivity
@Singleton
@Component(modules = [
    (AndroidSupportInjectionModule::class),
    (AppModule::class),
    (GraphModule::class),
    (ActivityBuilder::class)])
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(app: GraphApplication)

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}