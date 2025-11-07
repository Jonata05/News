package com.jonata.datasource.local.localdatasourceimpl;

import android.content.Context;
import com.jonata.datasource.local.preferences.contracts.DataPreferencesManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
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
public final class AuthLocalDataSourceImpl_Factory implements Factory<AuthLocalDataSourceImpl> {
  private final Provider<Context> contextProvider;

  private final Provider<DataPreferencesManager> preferenceManagerProvider;

  private AuthLocalDataSourceImpl_Factory(Provider<Context> contextProvider,
      Provider<DataPreferencesManager> preferenceManagerProvider) {
    this.contextProvider = contextProvider;
    this.preferenceManagerProvider = preferenceManagerProvider;
  }

  @Override
  public AuthLocalDataSourceImpl get() {
    return newInstance(contextProvider.get(), preferenceManagerProvider.get());
  }

  public static AuthLocalDataSourceImpl_Factory create(Provider<Context> contextProvider,
      Provider<DataPreferencesManager> preferenceManagerProvider) {
    return new AuthLocalDataSourceImpl_Factory(contextProvider, preferenceManagerProvider);
  }

  public static AuthLocalDataSourceImpl newInstance(Context context,
      DataPreferencesManager preferenceManager) {
    return new AuthLocalDataSourceImpl(context, preferenceManager);
  }
}
