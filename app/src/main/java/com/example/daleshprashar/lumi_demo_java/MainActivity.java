package com.example.daleshprashar.lumi_demo_java;

import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText editText, maineditText;
    private TextView textView, texflagA,texflagB,texflagC,texflagD,texflagE , strongText;
    private View view1, view2, view3;
   private View grey100, red25, green100, grey50,grey75, yellow50 ;
    private ImageView check1,check2 ,check3,check4, check5,cross1, cross2,cross3,cross4,cross5;
    private TextInputLayout textInputLayout;
    private TextInputEditText textInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar();

        initViews();
        editChangesDem();

      //  editChanges();


    }

    private void initViews()
    {
        maineditText = (EditText) findViewById(R.id.etPassword);

        check1 = (ImageView)findViewById(R.id.checkmark1);
        check2 = (ImageView)findViewById(R.id.checkmark2);
        check3 = (ImageView)findViewById(R.id.checkmark3);
        check4 = (ImageView)findViewById(R.id.checkmark4);
        check5 = (ImageView)findViewById(R.id.checkmark5);

        cross1 = (ImageView)findViewById(R.id.cross1);
        cross2 = (ImageView)findViewById(R.id.cross2);
        cross3 = (ImageView)findViewById(R.id.cross3);
        cross4 = (ImageView)findViewById(R.id.cross4);
        cross5 = (ImageView)findViewById(R.id.cross5);

        texflagA = (TextView)findViewById(R.id.flagA650);
        texflagB = (TextView)findViewById(R.id.flagBletter1);
        texflagC = (TextView)findViewById(R.id.flagCNumber1);
        texflagD = (TextView)findViewById(R.id.flagDCharsTwoplus);
        texflagE = (TextView)findViewById(R.id.flagESpecialChars);


        red25= (View)findViewById(R.id.linered25);
        grey75= (View)findViewById(R.id.lineBl75);
        grey50= (View)findViewById(R.id.lineBl50);
        yellow50= (View)findViewById(R.id.lineyellow50);
        grey100= (View)findViewById(R.id.lineBl100);
        green100= (View)findViewById(R.id.linegreen100);

        strongText= (TextView)findViewById(R.id.strongText);

    }

private void editChangesDem() {
    maineditText.addTextChangedListener(new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {



            int strength = 0;
            boolean isUnique = true;
            float commonChars = 0;
            int[] dataUnique = new int[256];
            for (int i=0; i<s.length(); i++)
            {
                int val = s.charAt(i);
                if(dataUnique[val] == 1)
                {
                    commonChars++;
                    isUnique = false;
                }
                dataUnique[val] = 1;
            }

            if (isUnique)
            {
                strength = strength + 35;

            }else {
                strength += (s.length() - commonChars / s.length()) * 35;
            }
            if (strength>40)
            {
//gg
            }
            else
            {
//hhh
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });
}

    private void editChanges() {

        maineditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {



            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {



                if(f1between6and50(s))
                {
                   check1.setVisibility(View.VISIBLE);
                   cross1.setVisibility(View.INVISIBLE);
                }else {
                    check1.setVisibility(View.INVISIBLE);
                    cross1.setVisibility(View.VISIBLE);
                }


                if(f2checkContainsStrings(s))
                {

                    check2.setVisibility(View.VISIBLE);
                    cross2.setVisibility(View.INVISIBLE);
                }else {
                    check2.setVisibility(View.INVISIBLE);
                    cross2.setVisibility(View.VISIBLE);
                }


                if(f3stringContainsNumber(s))
                {

                    check3.setVisibility(View.VISIBLE);
                    cross3.setVisibility(View.INVISIBLE);
                }else {
                    check3.setVisibility(View.INVISIBLE);
                    cross3.setVisibility(View.VISIBLE);
                }


                if(f4specialMoreThanTwice(s))
                {


                    check4.setVisibility(View.VISIBLE);
                    cross4.setVisibility(View.INVISIBLE);
                }
                else {
                    check4.setVisibility(View.INVISIBLE);
                    cross4.setVisibility(View.VISIBLE);
                }


                if(f5stringContainsSpecialChars(s))
                {

                    check5.setVisibility(View.VISIBLE);
                    cross5.setVisibility(View.INVISIBLE);
                }else {
                    check5.setVisibility(View.INVISIBLE);
                    cross5.setVisibility(View.VISIBLE);
                }


                int cxx = Xbooleantruecount(s);


                if (cxx ==1 || cxx == 2) {

red25.setVisibility(View.VISIBLE);
grey75.setVisibility(View.VISIBLE);


                    grey50.setVisibility(View.INVISIBLE);
                    yellow50.setVisibility(View.INVISIBLE);
                    grey100.setVisibility(View.INVISIBLE);
                    grey100.setVisibility(View.INVISIBLE);
                    strongText.setText("Weak");

                } else if (cxx == 3 || cxx == 4) {
                    yellow50.setVisibility(View.VISIBLE);
                    grey50.setVisibility(View.VISIBLE);

                    red25.setVisibility(View.INVISIBLE);
                    grey75.setVisibility(View.INVISIBLE);
                    green100.setVisibility(View.INVISIBLE);

                    strongText.setText("Average");



                } else if (cxx == 5) {

                    green100.setVisibility(View.VISIBLE);

                    grey75.setVisibility(View.INVISIBLE);
                    grey50.setVisibility(View.INVISIBLE);
                    yellow50.setVisibility(View.INVISIBLE);
                    red25.setVisibility(View.INVISIBLE);
                    grey100.setVisibility(View.INVISIBLE);
                    strongText.setText("Strong");

                    }


                if (s.length() ==0)
                {
                    red25.setVisibility(View.INVISIBLE);
                    grey100.setVisibility(View.VISIBLE);

                    grey75.setVisibility(View.INVISIBLE);
                    grey50.setVisibility(View.INVISIBLE);
                    yellow50.setVisibility(View.INVISIBLE);
                    green100.setVisibility(View.INVISIBLE

                    );

                }

                //  f4specialMoreThanTwice
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    // flag A
    private static boolean f1between6and50(CharSequence ss) {
        boolean good = false;
        if (ss.length() > 5 && ss.length() < 51) {
            good = true;
        }
        return good;
    }


    // flag B
    private boolean f2checkContainsStrings(CharSequence ss) {
        Pattern p = Pattern.compile("[A-Z]");
        Matcher m = p.matcher(ss);
        Pattern p1 = Pattern.compile("[a-z]");
        Matcher m1 = p1.matcher(ss);
        boolean k = m.find();
        boolean k1 = m1.find();
        boolean t = k || k1;
        return t;
    }


    //flag C
    public boolean f3stringContainsNumber(CharSequence ss) {
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(ss);
        return m.find();
    }

    // Flag D-0
    public int countOccurancesOfPattern(String pattern, CharSequence input) {
        Matcher m = Pattern.compile(pattern).matcher(input);
        int count = 0;
        while (m.find()) {
            count++;
        }
        return count;
    }

    // flag D full
    private boolean f4specialMoreThanTwice(CharSequence sss) {
        boolean acceptable = false;
        int n1 = countOccurancesOfPattern("_", sss);
        int n2 = countOccurancesOfPattern("!", sss);
        int n3 = countOccurancesOfPattern("@", sss);
        int n4 = countOccurancesOfPattern("$", sss);
        if (n1 > 2 || n2 > 2 || n3 > 2 || n4 > 2) {
            acceptable = true;// bad case
        } else {
            acceptable = false; // good case
        }
        return acceptable;

    }


    // Flag E
    public boolean f5stringContainsSpecialChars(CharSequence ss) {
        Pattern p = Pattern.compile("[_!@$]");
        Matcher m = p.matcher(ss);
        return m.find();
    }

// flag X0

    public int Xbooleantruecount(CharSequence ss) {
        boolean[] fiinal = {f1between6and50(ss), f2checkContainsStrings(ss), f3stringContainsNumber(ss), f4specialMoreThanTwice(ss), f5stringContainsSpecialChars(ss)};
        int count = 0;
        for (int i = 0; i < fiinal.length; i++) {
            if (fiinal[i]) {
                count++;
            }
        }
        return count;
    }


    // flag Xfull    red green yellow
    private void XXTraffic(CharSequence ss) {
        if (Xbooleantruecount(ss) == 1 || Xbooleantruecount(ss) == 2) {

        } else if (Xbooleantruecount(ss) == 3 || Xbooleantruecount(ss) == 4) {

        } else if (Xbooleantruecount(ss) == 5) {

        }
    }


    private void actionBar()
    {

        final ViewGroup actionBarLayout = (ViewGroup) getLayoutInflater().inflate(
                R.layout.action_bar,
                null);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(actionBarLayout);

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


    }


}

// Make the stuff tick/ true when length is greater than one and if that boolean is false,
   // but , when that is true , Make it croos again....
// and also update the same in the XX cross...
// EditText1 should be absolutley equal to edittext2
    // else there must be some sort of an error for that.
    // if(e1.getText().toString().equals( e2.getText().toString()))
    // String jj = String.valueOf(booleantruecount());

// Those are just for enable and disable, they must meet their match.
