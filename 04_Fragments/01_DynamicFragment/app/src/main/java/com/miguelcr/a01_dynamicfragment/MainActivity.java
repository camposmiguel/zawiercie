package com.miguelcr.a01_dynamicfragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    boolean loadRedFragment = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new RedFragment())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.fragment_options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_change:
                changeScreen();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void changeScreen() {
        Fragment f = null;
        if(loadRedFragment) {
            f = new RedFragment();
            loadRedFragment = false;
        } else {
            f = new BlueFragment();
            loadRedFragment = true;
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, f)
                .commit();
    }
}
