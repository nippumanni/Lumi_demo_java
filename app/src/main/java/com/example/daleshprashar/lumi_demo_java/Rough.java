package com.example.daleshprashar.lumi_demo_java;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rough extends AppCompatActivity {



        private EditText editText, editText2;
        private TextView textView;
        private View view1, view2, view3;

        private TextInputLayout textInputLayout;
        private TextInputEditText textInputEditText;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            String jj = String.valueOf(booleantruecount());

            textView = (TextView) findViewById(R.id.change1);
            textView.setText(jj);



            final ViewGroup actionBarLayout = (ViewGroup) getLayoutInflater().inflate(
                    R.layout.action_bar,
                    null);

            // Set up your ActionBar
            // Toolbar toolbar =
            ActionBar actionBar1 = getSupportActionBar();

            //android.support.v7.widget.Toolbar tb = (android.support.v7.widget.Toolbar) findViewById(R.id.too);
            //setSupportActionBar(tb);

            android.support.v7.app.ActionBar actionBar = getSupportActionBar();


//setActionBar(toolbar);
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setCustomView(actionBarLayout);

            //  final int actionBarColor = getResources().getColor(R.color.lightcolor);
            //  actionBar.setBackgroundDrawable(new ColorDrawable(actionBarColor));


            final TextView textt = (TextView) findViewById(R.id.headd);
            textt.setText("Index(2)");

            final Button actionBarSent = (Button) findViewById(R.id.action_bar_sent);
            actionBarSent.setText("Sent");

            actionBarSent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textt.setText("jjjjjjjjj");

                }
            });


//ActionBar now became a special kind of Toolbar. This is an

            editText = (EditText) findViewById(R.id.line);
            editText2 = (EditText) findViewById(R.id.etPassword);


            view1 = (View) findViewById(R.id.lineAA);
            view2 = (View) findViewById(R.id.lineAB);
            view3 = (View) findViewById(R.id.lineAC);

            textInputLayout = (TextInputLayout) findViewById(R.id.etPasswordLayout);
            textInputEditText = (TextInputEditText) findViewById(R.id.etPassword);

            editTextChanges();
        }

        private void editTextChanges() {
            //editText = findViewById(R.id.line);
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
/*
                if(stringContainsSpecialChars(s)) {
    textView.setText("it had special chars");
}
    else
    {
        textView.setText("NOT");

    }
    */
                    int n1 = countOccurancesOfPattern("a", s);
                    int n2 = countOccurancesOfPattern("b", s);
                    int n3 = countOccurancesOfPattern("c", s);
                    int n4 = countOccurancesOfPattern("d", s);
                    if (n1 > 2 || n2 > 2 || n3 > 2 || n4 > 2) {
                        // String jj = String.valueOf(nn);
                        textView.setText("TOO MUCH");
                        view2.setVisibility(View.INVISIBLE);
                        view3.setVisibility(View.VISIBLE);

                    } else {
                        textView.setText("count is good");
                        view2.setVisibility(View.VISIBLE);
                        view3.setVisibility(View.VISIBLE);


                    }
                }


                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }

        private boolean checkContainsStrings(CharSequence ss) {
            Pattern p = Pattern.compile("[A-Z]");
            Matcher m = p.matcher(ss);
            Pattern p1 = Pattern.compile("[a-z]");
            Matcher m1 = p1.matcher(ss);
            boolean k = m.find();
            boolean k1 = m1.find();
            boolean t = k || k1;
            return t;
        }

        public boolean stringContainsNumber(String s) {
            Pattern p = Pattern.compile("[0-9]");
            Matcher m = p.matcher(s);

            return m.find();
        }

        public boolean stringContainsSpecialChars(CharSequence ss) {
            Pattern p = Pattern.compile("[_!@$]");
            Matcher m = p.matcher(ss);
            return m.find();
        }

        public int countOccurancesOfPattern(String pattern, CharSequence input) {
            Matcher m = Pattern.compile(pattern).matcher(input);
            int count = 0;
            while (m.find()) {
                count++;
            }
            return count;
        }


        // 6-10 charcters
        // include 1 letter
        // include 1 number
        // special charcters  _ ! @ $
        // special charcters repeat more than twice

    /*
    public static int countOccurances(char c, String input) {
    return countOccurancesOfPattern(Pattern.quote(Character.toString(c)), input);
}

public static int countOccurances(String s, String input) {
    return countOccurancesOfPattern(Pattern.quote(s), input);
}

public static int countOccurancesOfPattern(String pattern, String input) {
    Matcher m = Pattern.compile(pattern).matcher(input);
    int count = 0;
    while (m.find()) {
        count++;
    }
    return count;
}
     */


        // EditText1 should be absolutley equal to edittext2
        // else there must be some sort of an error for that.

        private void editText2Changes() {
            editText2.addTextChangedListener(new TextWatcher() {

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
// if s>0    password is visible

                    //if 3 conditions are good- if 3 booleans are good colors will be changed.
                    // also, weak and average and strong will be changed.

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }


        public boolean a() {
            return false;
        }

        public static boolean b() {
            return false;
        }

        public static boolean c() {
            return false;
        }

        public static boolean d() {
            return false;
        }

        public int booleantruecount() {
            boolean[] fiinal = {a(), b(), c(), d()};
            int count = 0;
            for (int i = 0; i < fiinal.length; i++) {
                if (fiinal[i]) {
                    count++;
                }
            }
            return count;
        }

        boolean between6and50(CharSequence ss)
        {

            if(ss.length()>6 && ss.length()<50)
            {

            }
            return false;
        }

        // if(e1.getText().toString().equals( e2.getText().toString()))

    private void CustomActionBar() {
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();


//setActionBar(toolbar);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
      //  actionBar.setCustomView(actionBarLayout);


    }


}


