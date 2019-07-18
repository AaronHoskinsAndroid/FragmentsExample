package examples.aaronhoskins.com.fragmentsexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements PurpleFragment.OnFragmentInteractionListener,
                    RedFragment.OnFragmentInteractionListener{
    private FragmentManager fragmentManager;
    private PurpleFragment purpleFragment;
    private RedFragment redFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        setupAndAddPurpleFragment();
        setupAndAddRedFragment();
    }

    private void setupAndAddPurpleFragment() {
        purpleFragment = PurpleFragment.newInstance("Please enter user Name");
        fragmentManager.beginTransaction()
                .add(R.id.frmPurpleFragment, purpleFragment)
                .addToBackStack("PURPLE_FRAGMENT")
                .commit();
    }

    private void setupAndAddRedFragment() {
        redFragment = new RedFragment();
        fragmentManager.beginTransaction()
                .add(R.id.frmRedFragment, redFragment)
                .addToBackStack("RED_FRAGMENT")
                .commit();
    }

    @Override
    public void onFragmentInteraction(String passedString) {
        //Toast.makeText(this, passedString, Toast.LENGTH_SHORT).show();
        redFragment.setTextForTextView(passedString);
    }

    @Override
    public void popFragment() {
        //fragmentManager.popBackStack(); //Remove one fragment at a time
        //fragmentManager.popBackStack("PURPLE_FRAGMENT", FragmentManager.POP_BACK_STACK_INCLUSIVE);
        fragmentManager.beginTransaction().remove(purpleFragment).commit();

        //replace fragment in stack
        //RedFragment redFragment1 = new RedFragment();
        //fragmentManager.beginTransaction().add(R.id.frmPurpleFragment, redFragment1).commit();

    }
}
