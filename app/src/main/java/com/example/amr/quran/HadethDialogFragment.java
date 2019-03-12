package com.example.amr.quran;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

public class HadethDialogFragment extends DialogFragment {
    public HadethDialogFragment() {
    }
    com.example.amr.quran.AhadethModel ahadethModel;

    public void setAhadethModel(AhadethModel ahadethModel) {
        this.ahadethModel = ahadethModel;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog= super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.ahadeth_item,container,false);
        TextView title=v.findViewById(R.id.titleAhadeth);
        TextView content=v.findViewById(R.id.contentAhadeth);

        title.setText(ahadethModel.getTitle());
        content.setText(ahadethModel.getContent());
        return v;
    }
}
