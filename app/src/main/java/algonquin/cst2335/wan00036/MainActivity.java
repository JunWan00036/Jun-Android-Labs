package algonquin.cst2335.wan00036;

/*
public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";
    @Override  //1 )  This starts the application
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());


        //loads buttons / text on screen
        setContentView(binding.getRoot());
        //R means res
        //layout is the folder
        //activity_main is the file

        SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= prefs.edit();
        String found = prefs.getString("Name", "missing data");

        found = prefs.getString("FGHEUIGFHEU", "feuigfheui");
        editor.putString("Name", "d;fghmjl'kdsnfmhlkdstoilk");

        editor.apply();


        binding.button.setOnClickListener( btn -> {
            //1) Where you are, 2) Which activity do you want next



            Intent intent = new Intent( MainActivity.this , SecondActivity.class  );
            String whatWasTyped = binding.email.getText().toString();
            //pass some data:
            intent.putExtra("Name", whatWasTyped);
           // intent.putExtra("Age", 30);

            //actually makes the transition, send the table to SecondActivity
            startActivity( intent );
        }  );

    }

    @Override  // 2)   Activity is now visible
    protected void onStart() {
        super.onStart();

        Log.w(TAG, "Now visible");
        //Your code here
    }

    @Override //  3)  Now responds to touch input
    protected void onResume() {
        super.onResume();


        Log.e(TAG , "Now listens for touch");
    }

    @Override //no longer listening to touches
    protected void onPause() {
        super.onPause();
    }

    @Override  // no longer visible
    protected void onStop() {
        super.onStop();
    }

    @Override  // memory is garbage collected
    protected void onDestroy() {
        super.onDestroy();
    }
}*/


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import algonquin.cst2335.wan00036.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";
    private ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.w( "MainActivity", "In onCreate() - Loading Widgets" );
        Log.d( TAG, "Message");

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String emailAddress = prefs.getString("LoginName", "");
        binding.email.setText(emailAddress);

        binding.button.setOnClickListener(btn -> {
            String login = binding.email.getText().toString();
            Intent nextPage = new Intent(MainActivity.this, SecondActivity.class);
            nextPage.putExtra( "EmailAddress", login );
            startActivity(nextPage);

            SharedPreferences.Editor editor = prefs.edit();
            editor.putString( "LoginName",login );
            editor.apply();
        });
    }







    @Override
    protected void onStart() {
        super.onStart();
        Log.w( "MainActivity", "In onStart() - The application is now visible on screen." );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w( "MainActivity", "In onResume() - The application is now responding to user input" );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w( "MainActivity", "In onPause() - The application no longer responds to user input" );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w( "MainActivity", "In onStop() - The application is no longer visible." );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w( "MainActivity", "In onDestroy() - Any memory used by the application is freed" );
    }
}
