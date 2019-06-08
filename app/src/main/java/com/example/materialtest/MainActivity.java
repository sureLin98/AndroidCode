package com.example.materialtest;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    NavigationView navigationView;

    Toolbar toolbar;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        ImageView imageView=(ImageView)findViewById(R.id.image);
        navigationView=(NavigationView)findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_call);
      //  imageView.setImageResource(R.mipmap.miku);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_launcher_foreground);
        }
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                drawerLayout.closeDrawers();
                finish();
                Toast.makeText(MainActivity.this,"closeDrawers",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.backup:
                Toast.makeText(this,"backup",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this,"delete",Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting:
                Toast.makeText(this,"setting",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }


    /**
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_call:
                navigationView.setCheckedItem(R.id.nav_call);
                Toast.makeText(this,"call",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_friends:
                navigationView.setCheckedItem(R.id.nav_friends);
                Toast.makeText(this,"friends",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_location:
                navigationView.setCheckedItem(R.id.nav_location);
                Toast.makeText(this,"location",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_mail:
                navigationView.setCheckedItem(R.id.nav_mail);
                Toast.makeText(this,"mail",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_tasks:
                navigationView.setCheckedItem(R.id.nav_tasks);
                Toast.makeText(this,"tasks",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }
     **/
}
