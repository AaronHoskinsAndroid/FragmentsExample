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
import android.widget.EditText;

public class PurpleFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private String mParam1;
    private EditText etUserInput;
    private Button btnSendToRedFragment;


    private OnFragmentInteractionListener mListener;

    public PurpleFragment() {
        // Required empty public constructor
    }

    public static PurpleFragment newInstance(String param1) {
        PurpleFragment fragment = new PurpleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etUserInput = view.findViewById(R.id.etUserInput);
        btnSendToRedFragment = view.findViewById(R.id.btnSendToRedFragment);
        btnSendToRedFragment.setOnClickListener(this);
        etUserInput.setHint(mParam1);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSendToRedFragment:
                final String userInput = etUserInput.getText().toString();
                mListener.onFragmentInteraction(userInput);
                break;
        }
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String passedString);
    }
}
