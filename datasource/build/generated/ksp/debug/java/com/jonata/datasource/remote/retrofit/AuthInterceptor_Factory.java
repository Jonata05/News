package com.jonata.datasource.remote.retrofit;

import android.content.Context;
import com.jonata.datasource.local.localdatasourceimpl.AuthLocalDataSourceImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class AuthInterceptor_Factory implements Factory<AuthInterceptor> {
  private final Provider<Context> contextProvider;

  private final Provider<AuthLocalDataSourceImpl> authLocalDataSourceImplProvider;

  private AuthInterceptor_Factory(Provider<Context> contextProvider,
      Provider<AuthLocalDataSourceImpl> authLocalDataSourceImplProvider) {
    this.contextProvider = contextProvider;
    this.authLocalDataSourceImplProvider = authLocalDataSourceImplProvider;
  }

  @Override
  public AuthInterceptor get() {
    return newInstance(contextProvider.get(), authLocalDataSourceImplProvider.get());
  }

  public static AuthInterceptor_Factory create(Provider<Context> contextProvider,
      Provider<AuthLocalDataSourceImpl> authLocalDataSourceImplProvider) {
    return new AuthInterceptor_Factory(contextProvider, authLocalDataSourceImplProvider);
  }

  public static AuthInterceptor newInstance(Context context,
      AuthLocalDataSourceImpl authLocalDataSourceImpl) {
    return new AuthInterceptor(context, authLocalDataSourceImpl);
  }
}
