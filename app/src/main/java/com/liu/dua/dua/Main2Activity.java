package com.liu.dua.dua;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    static int count = 0;
    static Random r = new Random();
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

      FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
      fab.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                      .setAction("Action", null).show();
          }
      });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            Log.e("LIUYQ", "======SectionsPagerAdapter ====getItem===============tabIndex====== " + position);
//            return PlaceholderFragment.newInstance(position + 1);
            switch (position) {
                case 0:
                    return new NumberFragment();
                case 1:
                    return new RandomNumberFragment();
                case 2:
                    return new MathIn20Fragment();
                case 3:
                    return new MathIn100Fragment();
            }

            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Number";
                case 1:
                    return "Randome Number";
                case 2:
                    return "MathIn20";
                case 3:
                    return "MathI100";
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            Log.e("LIUYQ", "==========PlaceholderFragment newInstanc===============tabIndex====== " + sectionNumber);
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            int tabIndex = getArguments().getInt(ARG_SECTION_NUMBER);
            Log.e("LIUYQ", "========PlaceholderFragment onCreateView=================tabIndex====== " + tabIndex);
            View rootView = null;
            switch (tabIndex) {
                case 1:
                    rootView = inflater.inflate(R.layout.fragment_number, container, false);
                case 2:
                    rootView = inflater.inflate(R.layout.fragment_random_number, container, false);
                case 3:
                    rootView = inflater.inflate(R.layout.fragment_mathin20, container, false);
                case 4:
                    rootView = inflater.inflate(R.layout.fragment_mathin100, container, false);
            }
            //rootView = inflater.inflate(R.layout.fragment_number, container, false);
//            View rootView = inflater.inflate(R.layout.fragment_main2, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, tabIndex));
            return rootView;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class NumberFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_number, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.show_message_number);
            textView.setText("" + count);
            return rootView;
        }
    }
    public static class RandomNumberFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_random_number, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.show_message_random_number);
            textView.setText("" + r.nextInt(100));

            EditText inputNumberEditText = (EditText) rootView.findViewById(R.id.random_next_number);
            inputNumberEditText.setText("");

            TextView statisicTextView = (TextView) rootView.findViewById(R.id.random_number_statistic);
            statisicTextView.setText(String.format("Total: %d, Pass:%d Fail:%d",randomNumberTotal++, randomNumberPass++, randomNumberFail));

            return rootView;
        }
    }
    public static class MathIn100Fragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_mathin100, container, false);
            return rootView;
        }
    }
    public static class MathIn20Fragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_mathin20, container, false);
            return rootView;
        }
    }


    public void number(View view) {
        TextView textView = (TextView) findViewById(R.id.show_message_number);
        if(textView != null) {
            textView.setText("" + count++);
            textView.setOnLongClickListener(null);
        }else{
            Log.e("LIUYQ", "Show message component not found");
        }
    }

    static int randomNumberTotal=0, randomNumberPass=0, randomNumberFail=0;
    public void randomNumber(View view) {
        TextView textView = (TextView) findViewById(R.id.show_message_random_number);
        EditText inputNumberEditText = (EditText) findViewById(R.id.random_next_number);

        if(textView == null || inputNumberEditText == null) {
            Log.e("LIUYQ", "Random show or input component does not found");
        }

        String textViewStr =textView.getText().toString();
        int randomNumber = Integer.parseInt(textViewStr);

        String inputNumberStr = inputNumberEditText.getText().toString();
        int inputNumber = inputNumberStr.length() != 0 ? Integer.parseInt(inputNumberStr) : 0;

        if((inputNumber - randomNumber) != 1){
            Toast.makeText(view.getContext(), "Wrong!", Toast.LENGTH_SHORT).show();
            randomNumberFail++;
            TextView statisicTextView = (TextView) findViewById(R.id.random_number_statistic);
            statisicTextView.setText(String.format("Total: %d, Pass:%d Fail:%d",randomNumberTotal++, randomNumberPass++, randomNumberFail));
            return;
        }
        Toast.makeText(view.getContext(), "Great, let's play again!", Toast.LENGTH_SHORT).show();
        textView.setText("" + r.nextInt(100));
        inputNumberEditText.setText("");
        textView.setOnLongClickListener(null);

        TextView statisicTextView = (TextView) findViewById(R.id.random_number_statistic);
        statisicTextView.setText(String.format("Total: %d, Pass:%d Fail:%d",randomNumberTotal++, randomNumberPass++, randomNumberFail));
    }

    public void mathIn100(View view) {
        TextView textView = (TextView) findViewById(R.id.show_message_mathin100);
        if(textView != null) {
            boolean isAddition = r.nextBoolean();
            int operand1 = r.nextInt(100);
            String output = "";
            int result = 0;
            if (isAddition) {
                int operand2 = r.nextInt(100 - operand1);
                output = operand1 + " + " + operand2 + " = ";
                result = operand1 + operand2;
            } else {
                int operand2 = operand1 == 0 ? 0 : r.nextInt(operand1);
                output = operand1 + " - " + operand2 + " = ";
                result = operand1 - operand2;
            }
            textView.setText(output + "?");
            textView.setHint(result + "");
            final String finalOutput = output;
            final int finalResult = result;
            textView.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View v) {
                    Toast.makeText(v.getContext(), finalOutput + finalResult, Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }else{
            Log.e("LIUYQ", "Show message component not found");
        }
    }

    public void additionIn20(View view) {
        TextView textView = (TextView) findViewById(R.id.show_message_mathin20);
        int scope = 10;
        if(textView != null) {
            //boolean isAddition = r.nextBoolean();
            boolean isAddition = true;
            int operand1 = r.nextInt(scope);
            String output = "";
            int result = 0;
            if (isAddition) {
                int operand2 = r.nextInt(scope);
                output = operand1 + " + " + operand2 + " = ";
                result = operand1 + operand2;
            } else {
                int operand2 = operand1 == 0 ? 0 : r.nextInt(operand1);
                output = operand1 + " - " + operand2 + " = ";
                result = operand1 - operand2;
            }
            textView.setText(output + "?");
            textView.setHint(result + "");
            final String finalOutput = output;
            final int finalResult = result;
            textView.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View v) {
                    Toast.makeText(v.getContext(), finalOutput + finalResult, Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }else{
            Log.e("LIUYQ", "Show message component not found");
        }
    }
}
