package com.example.a812044.test51;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        private static final int CM_DELETE_ID=1;

        final  String ATTRIBUTE_NAME_TEXT="text";
        final  String ATTRIBUTE_NAME_IMAGE="image";
        ListView lvList;
        SimpleAdapter sAdapter;
        ArrayList<Map<String,Object>> data;
        Map<String,Object> m;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        data=new ArrayList<Map<String, Object>>();
        for(int i=1;i<5;i++){
            m=new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_TEXT,"sometext"+i);
            m.put(ATTRIBUTE_NAME_IMAGE,R.drawable.cat);
            data.add(m);
        }

        String[] from={ATTRIBUTE_NAME_TEXT,ATTRIBUTE_NAME_IMAGE};
        int[] to={R.id.tvText,R.id.ivImg};

        sAdapter=new SimpleAdapter(this,data,R.layout.item,from,to);

        lvList=(ListView)findViewById(R.id.lvSimple);
        lvList.setAdapter(sAdapter);
        registerForContextMenu(lvList);

    }
    public void onButtonClick(View view){
            m=new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_TEXT,"Text"+data.size()+1);
            m.put(ATTRIBUTE_NAME_IMAGE,R.drawable.cat);
            data.add(m);

            sAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,CM_DELETE_ID,0,"Удалить");
        menu.add(0,CM_DELETE_ID,0,"Применить");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==CM_DELETE_ID){
            AdapterView.AdapterContextMenuInfo acmi=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
            data.remove(acmi.position);
            Log.d("myLog", acmi.targetView + " " + acmi.id);
            sAdapter.notifyDataSetChanged();
            return  true;
        }
        return super.onContextItemSelected(item);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
