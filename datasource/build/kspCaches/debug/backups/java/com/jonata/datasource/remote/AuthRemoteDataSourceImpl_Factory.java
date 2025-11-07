package com.jonata.datasource.remote;

import com.jonata.datasource.remote.api.ApiAuthService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
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
public final class AuthRemoteDataSourceImpl_Factory implements Factory<AuthRemoteDataSourceImpl> {
  private final Provider<ApiAuthService> apiAuthServiceProvider;

  private AuthRemoteDataSourceImpl_Factory(Provider<ApiAuthService> apiAuthServiceProvider) {
    this.apiAuthServiceProvider = apiAuthServiceProvider;
  }

  @Override
  public AuthRemoteDataSourceImpl get() {
    return newInstance(apiAuthServiceProvider.get());
  }

  public static AuthRemoteDataSourceImpl_Factory create(
      Provider<ApiAuthService> apiAuthServiceProvider) {
    return new AuthRemoteDataSourceImpl_Factory(apiAuthServiceProvider);
  }

  public static AuthRemoteDataSourceImpl newInstance(ApiAuthService apiAuthService) {
    return new AuthRemoteDataSourceImpl(apiAuthService);
  }
}
