package com.jonata.datasource.di;

import android.content.Context;
import com.jonata.datasource.local.preferences.contracts.DataPreferencesManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class DataStoreModule_ProvideDataPreferencesManagerImplFactoryFactory implements Factory<DataPreferencesManager> {
  private final Provider<Context> contextProvider;

  private DataStoreModule_ProvideDataPreferencesManagerImplFactoryFactory(
      Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public DataPreferencesManager get() {
    return provideDataPreferencesManagerImplFactory(contextProvider.get());
  }

  public static DataStoreModule_ProvideDataPreferencesManagerImplFactoryFactory create(
      Provider<Context> contextProvider) {
    return new DataStoreModule_ProvideDataPreferencesManagerImplFactoryFactory(contextProvider);
  }

  public static DataPreferencesManager provideDataPreferencesManagerImplFactory(Context context) {
    return Preconditions.checkNotNullFromProvides(DataStoreModule.INSTANCE.provideDataPreferencesManagerImplFactory(context));
  }
}
