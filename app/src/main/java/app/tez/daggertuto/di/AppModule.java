package app.tez.daggertuto.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Terence Zafindratafa on 29/10/2018
 */

@Module
public class AppModule {

    private final Context mContext;

    public AppModule(Context context){
        mContext = context;
    }

    @Provides
    public Context providesApplicationContext(){ return mContext; }
}
