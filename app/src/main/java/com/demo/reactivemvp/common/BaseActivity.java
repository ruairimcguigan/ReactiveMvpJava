package com.demo.reactivemvp.common;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.demo.reactivemvp.App;
import com.demo.reactivemvp.R;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected final <T extends Fragment> void showFragment(@IdRes int fragmentPlaceholder, Class<T> fragmentClass, boolean addToBackStack) {
        showFragment(fragmentPlaceholder, fragmentClass, null, addToBackStack);
    }

    protected final <T extends Fragment> void showFragmentAddBackStack(@IdRes int fragmentPlaceholder, Fragment fragmentClass) {
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(fragmentPlaceholder, fragmentClass).addToBackStack("tag").commit();
    }

    @SuppressLint("StringFormatInvalid")
    public final <T extends Fragment> void showFragment(@IdRes int fragmentPlaceholder, Class<T> fragmentClass, Bundle bundle, boolean addToBackStack) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(fragmentClass.getSimpleName());

        if (fragment == null) {
            try {
                fragment = fragmentClass.newInstance();

                fragment.setArguments(bundle);
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(getApplicationContext().getString(R.string.fragment_not_created_message, e));
            }
        }

        addCustomTransition(fragmentPlaceholder, fragmentClass, fragmentTransaction, fragment);

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
    }

    private  <T extends Fragment> void addCustomTransition(@IdRes int fragmentPlaceholder,
                                                            Class<T> fragmentClass,
                                                            FragmentTransaction fragmentTransaction,
                                                            Fragment fragment) {

        fragmentTransaction.replace(fragmentPlaceholder, fragment, fragmentClass.getSimpleName());
    }

//    protected void setInjector(BaseActivity activity) {
//        App.getInstance().getComponent().inject(activity);
//    }

    protected abstract int getLayout();

}
