package algonquin.cst2335.wan00036.ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import algonquin.cst2335.wan00036.data.MainViewModel;
import algonquin.cst2335.wan00036.databinding.ActivityMainBinding;


//public class MainActivity extends AppCompatActivity {
//    private ActivityMainBinding variableBinding;
//    private MainViewModel model;
//
//    @Override
////    public void onCheckedChanged(CompoundButton,boolean b){};
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        model = new ViewModelProvider(this).get(MainViewModel.class);
//
//        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(variableBinding.getRoot());
//
//
////        setContentView(R.layout.activity_main);
//
//       /* TextView mytext = findViewById(R.id.textview);
//        Button btn = findViewById(R.id.mybutton);
//        EditText myedit = findViewById(R.id.myedittext);
//        */
//
//        TextView textview = variableBinding.textview;
//        Button btn = variableBinding.mybutton;
//        EditText myedit = findViewById(R.id.myedittext);
//
//         String editString = myedit.getText().toString();
//        myedit.setText( "Your edit text has: " + editString);
//
////        mybutton.setOnClickListener(  (View v) -> { myedittext.setText("Your edit text has: " + editString); }  );
////        mybutton.setOnClickListener(  ( vw ) -> { myedittext.setText("Your edit text has: " + editString); }  );
////        btn.setOnClickListener(  vw -> myedit.setText("Your edit text has: " + editString)  );
//        btn.setOnClickListener( ( vw ) -> { myedit.setText("Your edit text has: " + editString); } );
//
//        variableBinding.mybutton.setOnClickListener(click -> {
//            model.editString.postValue(variableBinding.myedittext.getText().toString());
//            variableBinding.myedittext.setText("Your edit text has " + model.editString);
//
//        });
//
//        model.editString.observe(this, s -> {
//            variableBinding.myedittext.setText("Your edit text has " + s);
//
//
////            binding=ActivityMainBinding.inflate()
//
//
//        });
//    }
//}
//
//




public class MainActivity extends AppCompatActivity {
    private MainViewModel model;
    private ActivityMainBinding variableBinding;
    private String isChecked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(this).get(MainViewModel.class);

        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());

        variableBinding.mybutton.setOnClickListener(click ->
        {
            model.editString.postValue(variableBinding.myedittext.getText().toString());

        });

        model.isSelected.observe(this, selected -> {
            boolean isSelected=false;
            variableBinding.checkboxMassage.setChecked(isSelected);
            variableBinding.radiobuttonMassage.setChecked( selected);
            variableBinding.mySwitch.setChecked( selected);
            variableBinding.tv.setText("The value is now: " + isChecked);



            Context context = getApplicationContext();
            CharSequence text = "Hello toast!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        });

        variableBinding.checkboxMassage.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            model.isSelected.postValue(isChecked);
        });



        variableBinding.radiobuttonMassage.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            model.isSelected.postValue(isChecked);
        });


        variableBinding.mySwitch.setOnCheckedChangeListener( (compoundButton, isChecked) -> {
            model.isSelected.postValue(isChecked);
        } );

        variableBinding.myimagebutton.setOnClickListener(click ->{
            Context context = getApplicationContext();
            CharSequence text = "The width = " + variableBinding.myimagebutton.getWidth() + " and height = " + variableBinding.myimagebutton.getHeight();
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        });






    }
}