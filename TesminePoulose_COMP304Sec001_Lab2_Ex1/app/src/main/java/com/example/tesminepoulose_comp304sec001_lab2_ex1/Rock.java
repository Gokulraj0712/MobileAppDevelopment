package com.example.tesminepoulose_comp304sec001_lab2_ex1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Rock extends AppCompatActivity {
    Set<String> setValues = new HashSet<String>();
    //preferences data variable
    SharedPreferences myPref;
    //variable to modify preference data
    SharedPreferences.Editor prefEditor;
    //
    String songType;
    String[] rock1;
    String[] rock2;
    String[] rock3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rock_activity);

        rock1 = getResources().getStringArray(R.array.available_rock1);
        rock2 = getResources().getStringArray(R.array.available_rock2);
        rock3 = getResources().getStringArray(R.array.available_rock3);
        TextView textView1=(TextView) findViewById(R.id.textView1);
        textView1.setText(Arrays.toString(rock1).replace("["," ").replace("]"," ").trim());
        TextView textView2=(TextView) findViewById(R.id.textView2);
        textView2.setText(Arrays.toString(rock2).replace("["," ").replace("]"," ").trim());
        TextView textView3=(TextView) findViewById(R.id.textView3);
        textView3.setText(Arrays.toString(rock3).replace("["," ").replace("]"," ").trim());

        //retrieving from shared preferences
        myPref = getSharedPreferences("info", MODE_PRIVATE);
        //check what's in shared preferences named courses
        songType = myPref.getString("songType","Rock");
        setValues = myPref.getStringSet("value",new HashSet<String>());
        for( String setValue : setValues ){
            // restore the state of check boxes according to shared preferences values
            if(setValue.equals("Song 1"))
            {
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBoxSong1);
                checkBox1.setChecked(true);

            }
            if(setValue.equals("Song 2"))
            {
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBoxSong2);
                checkBox1.setChecked(true);
            }
        }

        String myString = myPref.getString("Song","");
        Toast.makeText(this, "Retrieving from shared preferences: "+myString, Toast.LENGTH_SHORT).show();
        prefEditor= myPref.edit();
    }
    //
    public void onCheckboxClicked(View view)
    {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBoxSong1:
                if (checked) { //add it to the set
                    setValues.add(Arrays.toString(rock1));

                }
                else //remove it from the set
                {
                    setValues.remove(Arrays.toString(rock1));
                }
                break;

            case R.id.checkBoxSong2:
                if (checked) {
                    setValues.add(Arrays.toString(rock2));
                }
                else
                {
                    setValues.remove(Arrays.toString(rock2));
                }
                break;

            case R.id.checkBoxSong3:
                if (checked){
                    setValues.add(Arrays.toString(rock3));
                }

                else{
                    setValues.remove(Arrays.toString(rock3));
                }

                break;
            default:
                break;
        }

    }

    public void onClickNext(View view) {
        //add the selected values to shared preferences variable named courses
        TextView error = (TextView) findViewById(R.id.error);
        if (setValues.size() > 0) {
            prefEditor.putStringSet("selected", setValues);
            prefEditor.putInt("size", setValues.size());
            prefEditor.commit();
            Intent intent = new Intent(this, Song_checkout.class);
            startActivity(intent);
        } else {
            error.setText("Please choose one " + songType + "");
        }
    }

}
