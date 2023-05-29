package com.svmdev.appmovies.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import android.view.MenuItem;
import android.widget.Toast;

import com.svmdev.appmovies.R;
import com.svmdev.appmovies.help.Variables;
import com.svmdev.appmovies.view.popular.PopularFragment;
import com.svmdev.appmovies.view.upcomming.UpcommingFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;
    public static Fragment popularFragment;
    public static Fragment upcommingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Variables.init();

        navigationView = findViewById(R.id.menu_navigation);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        popularFragment = PopularFragment.newInstance();
        openFragment(popularFragment);
        openFragment(popularFragment);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int selected = item.getItemId();
            int popId = R.id.navigation_popular;

            if(selected == popId) {
                if(popularFragment == null){
                    popularFragment = PopularFragment.newInstance();
                }
                openFragment(popularFragment);
            } else {
                if(upcommingFragment == null){
                    upcommingFragment = UpcommingFragment.newInstance();
                }
                openFragment(upcommingFragment);
            }
            return true;
        }
    };

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.menu_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }

    @Override
    public void onActivityResult(int codigo, int resultado, Intent dados) {
        try {
            if(resultado == Activity.RESULT_OK){


            }
        } catch (Exception e) {
            Toast.makeText(this.getApplicationContext(), "Atenção: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }


}
