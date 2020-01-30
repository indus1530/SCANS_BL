package edu.aku.hassannaqvi.uen_scans_bl.otherClasses;

import android.app.Activity;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import edu.aku.hassannaqvi.uen_scans_bl.R;

/**
 * Created by ali.azaz on 22/04/2019.
 */

public class SnackUtils {

    public static Snackbar showLoadingSnackbar(Activity ctx, String message) {
        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) ctx.findViewById(android.R.id.content)).getChildAt(0);
        Snackbar bar = Snackbar.make(viewGroup, message, Snackbar.LENGTH_INDEFINITE);
        bar.getView().setBackgroundColor(ctx.getResources().getColor(R.color.colorPrimaryDark));
        bar.show();
        return bar;
    }
}