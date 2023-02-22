package algonquin.cst2335.wan00036;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    /**
     * A TextView object known as "textView" is employed to display text.
     */

    private TextView textView =null;
    /**
     * An EditText object named "editText" enables the user to input text.
     */
    private EditText editText =null;
    /**
     *The object called "button" is utilized to react to user input as a Button.
     */
    private Button button =null;

    @Override // initialize an activity and to set up its user interface.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set the user interface layout for the activity.
        setContentView(R.layout.activity_main);
        // R stands for res folder
        // layout is the folder
        // activity_main: XML layout file that defines the user interface (UI) for the main activity of an application.

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);


        button.setOnClickListener(clk -> {
            String password = editText.getText().toString();

            // looking for UpperCase, LowerCase, Number and Special character,
            if (checkPasswordComplexity(password)) {

                textView.setText("Your password meets the requirements");
            } else {
                textView.setText("You shall not pass!");

            }

        });
    }

    /**
     * The purpose of this function is to verify the complexity of the password.
     *
     * @param pw The String password object that are being checked
     * @return This function will return a Boolean value of true if the input password contains at least
     * one uppercase letter, one lowercase letter, one number, and one special character,
     * and false otherwise.
     */
    boolean checkPasswordComplexity(String pw) {

        boolean foundUpperCase, foundLowerCase, foundNumber, foundSpecial;
        foundUpperCase = foundLowerCase = foundNumber = foundSpecial = false;

        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);

            if (Character.isUpperCase(c)) {
                foundUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                foundLowerCase = true;
            } else if (Character.isDigit(c)) {

                foundNumber = true;
            } else if (isSpecialCharacter(c)) {
                foundSpecial = true;
            }

        }

        if (!foundUpperCase) {
            Toast.makeText(this, "an upper case letter is missing", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundLowerCase) {
            Toast.makeText(this, "  a lower case letter is missing", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundNumber) {
            Toast.makeText(this, "  missing a a number", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundSpecial) {
            Toast.makeText(this, "  missing a special character", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            Toast.makeText(this, "Congratulation,  password meets all the requirements", Toast.LENGTH_SHORT).show();
            return true; //only if they're all true
        }
    }

    /**
     * This function verifies whether a given character is a special character or not.
     *
     * @param c determine whether a specific character contains a special character or not.
     * @return This function will return a Boolean value of true
     * if the input character is a special character,
     * and false otherwise.
     */
    boolean isSpecialCharacter(char c) {
        switch (c) {
            case '#':
            case '?':
            case '*':
            case '$':
            case '^':
            case '@':
            case '!':
            case '%':
            case '&':
                return true;
            default:
                return false;
        }
    }
}