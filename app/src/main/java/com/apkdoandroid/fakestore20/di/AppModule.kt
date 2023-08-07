package com.apkdoandroid.fakestore20.di

import br.com.apkdoandroid.fakestore.adapter.ProdutoAdapter
import com.apkdoandroid.fakestore20.data.remote.FakeStoreAPI
import com.apkdoandroid.fakestore20.data.repository.ProdutoRepositoryImpl
import com.apkdoandroid.fakestore20.domain.repository.ProdutoRepository
import com.apkdoandroid.fakestore20.domain.usecase.ProdutoUseCase
import com.apkdoandroid.fakestore20.presentation.adapter.interfaces.ProdutoAdapterInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory( GsonConverterFactory.create() )
            .build()

    }

    @Provides
    fun providesFakeStore(retrofit: Retrofit) : FakeStoreAPI {
        return retrofit.create(FakeStoreAPI::class.java)
    }

    @Provides
    fun providesProdutoUseCAse(produtoRepository: ProdutoRepository) : ProdutoUseCase{
        return ProdutoUseCase(produtoRepository)
    }
    @Provides
    fun providesProdutoRepository(fakeStoreAPI: FakeStoreAPI) : ProdutoRepository{
        return ProdutoRepositoryImpl(fakeStoreAPI)
    }

}

@Module
@InstallIn(ActivityComponent::class)
object AppModuleActivity{

    @Provides
    fun providesProdutoAdapter() : ProdutoAdapterInterface {
        return ProdutoAdapter()
    }

}