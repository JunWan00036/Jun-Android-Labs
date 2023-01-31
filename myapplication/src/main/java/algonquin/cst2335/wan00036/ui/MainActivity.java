package algonquin.cst2335.wan00036.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import algonquin.cst2335.wan00036.data.MainViewModel;
import algonquin.cst2335.wan00036.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding variableBinding;
    private MainViewModel model;
    private String choiced;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new ViewModelProvider(this).get(MainViewModel.class);

        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());

        variableBinding.mybutton.setOnClickListener(click -> {
            model.editString.postValue(variableBinding.myedittext.getText().toString());
            model.editString.observe(this, s -> {
                variableBinding.textview.setText("Your edit text has: " + s);
            });
        });

        model.isSelected.observe(this, isChecked -> {
            variableBinding.checkBox.setChecked(isChecked);
            variableBinding.radioButton.setChecked(isChecked);
            variableBinding.switch1.setChecked(isChecked);
            Toast.
                    makeText(MainActivity.this, "The value is now: "+ isChecked,
                            Toast.LENGTH_SHORT).show();
        });

        variableBinding.checkBox.setOnCheckedChangeListener( (checkBox, isChecked) -> {
            model.isSelected.postValue(variableBinding.checkBox.isChecked());
        });
        variableBinding.switch1.setOnCheckedChangeListener( (switch1, isChecked) -> {
            model.isSelected.postValue(variableBinding.switch1.isChecked());
        });
        variableBinding.radioButton.setOnCheckedChangeListener( (radioButton, isChecked) -> {
            model.isSelected.postValue(variableBinding.radioButton.isChecked());
        });

        variableBinding.myimagebutton.setOnClickListener(click -> {
            double width = variableBinding.myimagebutton.getWidth();
            double height = variableBinding.myimagebutton.getHeight();
            Toast.
                    makeText(MainActivity.this, "The width = " + width +
                            " and height = " + height, Toast.LENGTH_SHORT).show();
        });
    };
}