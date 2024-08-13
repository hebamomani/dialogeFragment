package com.example.dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DialogFragment extends androidx.fragment.app.DialogFragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_TITLE = "title";
    private static final String ARG_MESSAGE = "message";
    private static final String ARG_ICON = "icon";

    // TODO: Rename and change types of parameters
    private  String title;
    private String message;
    private  int icon;
    private OnPositiveClickListner positiveClickListner;
    private OnNegativeClickListner negativeClickListner;
    private OnNeutralClickListner neutralClickListner;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnPositiveClickListner){
            positiveClickListner= (OnPositiveClickListner) context;
        }
        else throw new RuntimeException("Please Implement Listener:Positive");

        if (context instanceof OnNegativeClickListner){
            negativeClickListner= (OnNegativeClickListner)  context;
        }
        else throw new RuntimeException("Please Implement Listener:Negative");

        if (context instanceof OnNeutralClickListner){
            neutralClickListner= (OnNeutralClickListner) context;
        }
        else throw new RuntimeException("Please Implement Listener:Neutral");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        positiveClickListner=null;
        negativeClickListner=null;
        neutralClickListner=null;
    }

    public DialogFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DialogFragment newInstance(String title, String message,int icon) {
        DialogFragment fragment = new DialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE,title );
        bundle.putString(ARG_MESSAGE, message);
        bundle.putInt(ARG_ICON, icon);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args=getArguments();
        if (args!= null) {
            title = args.getString(ARG_TITLE);
            message = args.getString(ARG_MESSAGE);
            icon=args.getInt(ARG_ICON);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setIcon(icon);
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               positiveClickListner.OnPositiveButtonClicked();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                negativeClickListner.OnNegativeButtonClicked();
            }
        });
        builder.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
  dismiss();
            }
        });
        return builder.create();
    }
    public interface OnPositiveClickListner{
        void OnPositiveButtonClicked();
    }
    public interface OnNegativeClickListner{
        void OnNegativeButtonClicked();
    }
    public interface OnNeutralClickListner{
        void OnNeutralButtonClicked();
    }

}