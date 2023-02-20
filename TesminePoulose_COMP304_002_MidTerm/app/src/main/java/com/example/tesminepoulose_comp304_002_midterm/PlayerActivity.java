    package com.example.tesminepoulose_comp304_002_midterm;
    import androidx.appcompat.app.AppCompatActivity;

    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;

    public class PlayerActivity extends AppCompatActivity{
        EditText pname1,pname2 ;
        String J;
        public Button button,button1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.player_activity);
            button = (Button) findViewById(R.id.button2);
            button1 = (Button) findViewById(R.id.button3);
            Intent intent = getIntent();
            Bundle b = intent.getExtras();
            if (b != null) {
                J = (String) b.get("personname");
            }
            System.out.println(J);

            TextView display = findViewById(R.id.textViewwelcome);
            display.setText(getString(R.string.welcome) + J);

            pname1 = (EditText) findViewById(R.id.editTextTextPersonName2);
            pname2 = (EditText) findViewById(R.id.editTextTextPersonName3);
            button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view)
            {
                if (pname1.getText().toString().trim().length()>0) {
                    Toast.makeText(getApplicationContext(), "Soccer Player Name Saved!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "DEFAULT!", Toast.LENGTH_SHORT).show();
                }
            }


        });

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (pname2.getText().toString().trim().length() > 0) {
                        Toast.makeText(getApplicationContext(), "BasketBall Player Name Saved!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "DEFAULT!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }
