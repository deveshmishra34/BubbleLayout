package cordova.plugin.bubblelayout;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.content.Context;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import in.dcreators.bubblehead.BubbleHead;
import in.dcreators.bubblehead.FloatingViewService;

public class NewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String package_name = getApplication().getPackageName();

        setContentView(getApplication().getResources().getIdentifier("activity_new", "layout", package_name));
        // TextView textView = (TextView) findViewById(R.id.textView);
        // textView.setText("Cordova Hello World");
        Toast.makeText(this, "Some Message", Toast.LENGTH_LONG).show();

        
    }
}