package com.jonata.datasource.local.preferences;

import android.content.Context;
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
public final class DefaultDataStore_Factory implements Factory<DefaultDataStore> {
  private final Provider<Context> contextProvider;

  private final Provider<String> fileNameProvider;

  private DefaultDataStore_Factory(Provider<Context> contextProvider,
      Provider<String> fileNameProvider) {
    this.contextProvider = contextProvider;
    this.fileNameProvider = fileNameProvider;
  }

  @Override
  public DefaultDataStore get() {
    return newInstance(contextProvider.get(), fileNameProvider.get());
  }

  public static DefaultDataStore_Factory create(Provider<Context> contextProvider,
      Provider<String> fileNameProvider) {
    return new DefaultDataStore_Factory(contextProvider, fileNameProvider);
  }

  public static DefaultDataStore newInstance(Context context, String fileName) {
    return new DefaultDataStore(context, fileName);
  }
}
