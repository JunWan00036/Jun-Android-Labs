package algonquin.cst2335.wan00036.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import algonquin.cst2335.wan00036.R;
import algonquin.cst2335.wan00036.data.MainViewModel;
import algonquin.cst2335.wan00036.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding variableBinding;
    private MainViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(this).get(MainViewModel.class);

        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());


        setContentView(R.layout.activity_main);

       /* TextView mytext = findViewById(R.id.textview);
        Button btn = findViewById(R.id.mybutton);
        EditText myedit = findViewById(R.id.myedittext);
        */

        TextView textview = variableBinding.textview;
        Button btn = variableBinding.mybutton;
        EditText myedit = findViewById(R.id.myedittext);

         String editString = myedit.getText().toString();
        myedit.setText( "Your edit text has: " + editString);

//        mybutton.setOnClickListener(  (View v) -> { myedittext.setText("Your edit text has: " + editString); }  );
//        mybutton.setOnClickListener(  ( vw ) -> { myedittext.setText("Your edit text has: " + editString); }  );
//        btn.setOnClickListener(  vw -> myedit.setText("Your edit text has: " + editString)  );
        btn.setOnClickListener( ( vw ) -> { myedit.setText("Your edit text has: " + editString); } );

        variableBinding.mybutton.setOnClickListener(click -> {
            model.editString.postValue(variableBinding.myedit.getText().toString()); });


    }
}


