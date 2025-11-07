package com.jonata.datasource.remote.retrofit;

import com.jonata.datasource.remote.api.ApiAuthService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class RetrofitAuth_ProvideRefreshRetrofitFactory implements Factory<ApiAuthService> {
  @Override
  public ApiAuthService get() {
    return provideRefreshRetrofit();
  }

  public static RetrofitAuth_ProvideRefreshRetrofitFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ApiAuthService provideRefreshRetrofit() {
    return Preconditions.checkNotNullFromProvides(RetrofitAuth.INSTANCE.provideRefreshRetrofit());
  }

  private static final class InstanceHolder {
    static final RetrofitAuth_ProvideRefreshRetrofitFactory INSTANCE = new RetrofitAuth_ProvideRefreshRetrofitFactory();
  }
}
