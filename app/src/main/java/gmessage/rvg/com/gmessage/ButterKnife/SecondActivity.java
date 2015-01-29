package gmessage.rvg.com.gmessage.ButterKnife;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import gmessage.rvg.com.gmessage.R;

public class SecondActivity extends ActionBarActivity {
    
    private String TAG =SecondActivity.class.getSimpleName();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
    }

}