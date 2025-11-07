package com.jonata.datasource.remote.retrofit;

import com.jonata.datasource.remote.api.ApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
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
public final class RetrofitBuilder_ProvideAuthApiServiceFactory implements Factory<ApiService> {
  private final Provider<AuthInterceptor> authInterceptorProvider;

  private RetrofitBuilder_ProvideAuthApiServiceFactory(
      Provider<AuthInterceptor> authInterceptorProvider) {
    this.authInterceptorProvider = authInterceptorProvider;
  }

  @Override
  public ApiService get() {
    return provideAuthApiService(authInterceptorProvider.get());
  }

  public static RetrofitBuilder_ProvideAuthApiServiceFactory create(
      Provider<AuthInterceptor> authInterceptorProvider) {
    return new RetrofitBuilder_ProvideAuthApiServiceFactory(authInterceptorProvider);
  }

  public static ApiService provideAuthApiService(AuthInterceptor authInterceptor) {
    return Preconditions.checkNotNullFromProvides(RetrofitBuilder.INSTANCE.provideAuthApiService(authInterceptor));
  }
}
