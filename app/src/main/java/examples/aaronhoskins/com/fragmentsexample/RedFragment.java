package examples.aaronhoskins.com.fragmentsexample;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class RedFragment extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;
    private TextView tvInputFromPurpleFragment;
    private Button btnPopFragment;

    public RedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_red, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvInputFromPurpleFragment = view.findViewById(R.id.tvInputFromPurpleFragment);
        btnPopFragment = view.findViewById(R.id.btnPopFragment);
        btnPopFragment.setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void setTextForTextView(String string){
        tvInputFromPurpleFragment.setText(string);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnPopFragment:
                mListener.popFragment();
                break;
        }
    }

    public interface OnFragmentInteractionListener {
        void popFragment();
    }
}
