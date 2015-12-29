package com.rodico.duke0808.tobuy;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.rodico.duke0808.tobuy.recyclerview.RecyclerFragment;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks {

    public static final String P_NAME_LABEL = "label";
    public static final String P_NAME_CHECKED = "checked";
    public static Context context;
    DrawerLayout drawer;
    public final static String fileName = "ToBuySavedData.txt";
    Toolbar toolbar = null;
    //google sign in vars
    GoogleApiClient googleApiClient;
    protected static final int REQUEST_CODE_RESOLUTION = 1;
    boolean isConnectedToDrive;
    private static final String sharedPrefStr = "com.rodico.duke0808.tobuy.SHARED_PREF";
    private static SharedPreferences sharedPref;
    //after remake

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.navig_ic);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        firstInit();
    }
    public void firstInit() {
        context = getApplicationContext();
        sharedPref = getSharedPreferences(sharedPrefStr, Context.MODE_PRIVATE);
        googlepiClientInit();
        RecyclerFragment fragment = new RecyclerFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container,fragment).commit();
    }
    public void googlepiClientInit() {
        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(com.google.android.gms.drive.Drive.API)
                .addScope(com.google.android.gms.drive.Drive.SCOPE_APPFOLDER)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        googleApiClient.connect();
    }
    private String getAccountName() {

        String accountName = null;

        AccountManager manager = (AccountManager) getSystemService(ACCOUNT_SERVICE);
        Account[] list = manager.getAccounts();
        for (Account account : list) {
            if (account.type.equalsIgnoreCase("com.google")) {
                accountName = account.name;
                break;
            }
        }
        return accountName;
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
        Toast.makeText(MainActivity.this, ""+ id, Toast.LENGTH_SHORT).show();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sort_checked) {
        }
        if (id == 16908332){
            drawer.openDrawer(GravityCompat.START);
        }
        if (id == R.id.rename_list){
        }
        if (id == R.id.delete_list){
        }
        if (id == R.id.log_out){
            googleApiClient.disconnect();
            //TODO: Add revoke code here !!!
        }
        if (id == R.id.save_to_drive){
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void showMessage(String s) {
        Toast.makeText(MainActivity.this, "" + s, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onConnectionFailed(ConnectionResult result) {
        if (!result.hasResolution()) {
            // show the localized error dialog.
            GoogleApiAvailability.getInstance().getErrorDialog(this, result.getErrorCode(), 0).show();
            return;
        }
        try {
            result.startResolutionForResult(this, REQUEST_CODE_RESOLUTION);
        } catch (IntentSender.SendIntentException e) {
            Log.e("Drive API", "Exception while starting resolution activity", e);
        }
    }
    @Override
    public void onConnected(Bundle bundle) {
        String name = getAccountName();
        showMessage("Connected as ... "+name);
        if (googleApiClient.isConnected()) {
        }
    }
    @Override
    public void onConnectionSuspended(int i) {
        showMessage("Connection suspended");
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_RESOLUTION && resultCode == RESULT_OK) {
            googleApiClient.connect();
        }
    }
}

