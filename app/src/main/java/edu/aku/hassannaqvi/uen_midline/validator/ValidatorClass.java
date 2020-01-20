package edu.aku.hassannaqvi.uen_midline.validator;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.edittextpicker.aliazaz.EditTextPicker;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.lang.reflect.Field;

import edu.aku.hassannaqvi.uen_midline.R;


/**
 * Created by ali.azaz on 12/04/17.
 * modified by ramsha.seed on 7/8/2018
 */

public abstract class ValidatorClass {

    public static boolean EmptyTextBox(Context context, EditText txt, String msg) {
        if (TextUtils.isEmpty(txt.getText().toString())) {
            FancyToast.makeText(context, "ERROR(empty): " + msg, FancyToast.LENGTH_SHORT, FancyToast.ERROR, false).show();
            txt.setError("This data is Required! ");    // Set Error on last radio button
            txt.setFocusableInTouchMode(true);
            txt.requestFocus();
            Log.i(context.getClass().getName(), context.getResources().getResourceEntryName(txt.getId()) + ": This data is Required!");
            return false;
        } else {
            txt.setError(null);
            txt.clearFocus();
            return true;
        }

    }

    private static boolean EmptyEditTextPicker(Context context, EditText txt, String msg) {
        String messageConv = "";
        boolean flag = true;
        if (!((EditTextPicker) txt).isEmptyTextBox()) {
            flag = false;
            messageConv = "ERROR(empty)";
        } else if (!((EditTextPicker) txt).isRangeTextValidate()) {
            flag = false;
            messageConv = "ERROR(range)";
        } else if (!((EditTextPicker) txt).isTextEqualToPattern()) {
            flag = false;
            messageConv = "ERROR(pattern)";
        }

        if (!flag) {
            FancyToast.makeText(context, messageConv + ": " + msg, FancyToast.LENGTH_SHORT, FancyToast.ERROR, false).show();
            Log.i(context.getClass().getName(), context.getResources().getResourceEntryName(txt.getId()) + ": " + messageConv);
            return flag;
        } else {
            txt.setError(null);
            txt.clearFocus();
            return flag;
        }

    }

    public static boolean EmptyCardCheckBox(Context context, CardView container, CheckBox cbx, String msg) {

        Boolean flag = false;
        for (int i = 0; i < container.getChildCount(); i++) {
            View v = container.getChildAt(i);
            if (v instanceof LinearLayout) {
                for (int j = 0; j < ((LinearLayout) v).getChildCount(); j++) {
                    View view = ((LinearLayout) v).getChildAt(j);
                    if (view instanceof CheckBox) {
                        CheckBox cb = (CheckBox) view;
                        if (cb.isChecked()) {
                            flag = true;
                            break;
                        }
                    }

                }
            }
        }
        if (flag) {
            return true;
        } else {
            FancyToast.makeText(context, "ERROR(empty): " + msg, FancyToast.LENGTH_SHORT, FancyToast.ERROR, false).show();
            cbx.setError("This data is Required!");    // Set Error on last radio button

            Log.i(context.getClass().getName(), context.getResources().getResourceEntryName(cbx.getId()) + ": This data is Required!");
            return false;
        }
    }

    public static boolean EmptyTextBox(Context context, TextView txt, String msg) {
        if (TextUtils.isEmpty(txt.getText().toString())) {
            FancyToast.makeText(context, "ERROR(empty): " + msg, FancyToast.LENGTH_SHORT, FancyToast.ERROR, false).show();
            txt.setError("This data is Required! ");    // Set Error on last radio button
            txt.setFocusableInTouchMode(true);
            txt.requestFocus();
            Log.i(context.getClass().getName(), context.getResources().getResourceEntryName(txt.getId()) + ": This data is Required!");
            return false;
        } else {
            txt.setError(null);
            txt.clearFocus();
            return true;
        }

    }

    public static boolean EmptyCustomeTextBox(Context context, TextView txt, String msg) {
        FancyToast.makeText(context, "ERROR: " + msg, FancyToast.LENGTH_SHORT, FancyToast.ERROR, false).show();
        txt.setError(msg);
        txt.setFocusableInTouchMode(true);
        txt.requestFocus();
        Log.i(context.getClass().getName(), context.getResources().getResourceEntryName(txt.getId()) + ": " + msg);
        return false;
    }

    public static boolean EmptyCustomRadio(Context context, RadioButton rd, String msg) {
        FancyToast.makeText(context, "ERROR: " + msg, FancyToast.LENGTH_SHORT, FancyToast.ERROR, false).show();
        rd.setError(msg);
        rd.setFocusableInTouchMode(true);
        rd.requestFocus();
        Log.i(context.getClass().getName(), context.getResources().getResourceEntryName(rd.getId()) + ": " + msg);
        return false;
    }

    public static boolean RangeTextBox(Context context, EditText txt, int min, int max, String msg, String type) {

        if (Integer.valueOf(txt.getText().toString()) < min || Integer.valueOf(txt.getText().toString()) > max) {
            FancyToast.makeText(context, "ERROR(invalid): " + msg, FancyToast.LENGTH_SHORT, FancyToast.ERROR, false).show();
            txt.setError("Range is " + min + " to " + max + type + " ... ");    // Set Error on last radio button
            txt.setFocusableInTouchMode(true);
            txt.requestFocus();
            Log.i(context.getClass().getName(), context.getResources().getResourceEntryName(txt.getId()) + ": Range is " + min + " to " + max + " times...  ");
            return false;
        } else {
            txt.setError(null);
            txt.clearFocus();
            return true;
        }
    }


    public static boolean RangeTextBox(Context context, EditText txt, double min, double max, String msg, String type) {

        if (Double.valueOf(txt.getText().toString()) < min || Double.valueOf(txt.getText().toString()) > max) {
            FancyToast.makeText(context, "ERROR(invalid): " + msg, FancyToast.LENGTH_SHORT, FancyToast.ERROR, false).show();
            txt.setError("Range is " + min + " to " + max + type + " ... ");    // Set Error on last radio button
            txt.setFocusableInTouchMode(true);
            txt.requestFocus();
            Log.i(context.getClass().getName(), context.getResources().getResourceEntryName(txt.getId()) + ": Range is " + min + " to " + max + " times...  ");
            return false;
        } else {
            txt.setError(null);
            txt.clearFocus();
            return true;
        }
    }

    public static boolean EmptySpinner(Context context, Spinner spin, String msg) {
        if (spin.getSelectedItemPosition() == 0) {
            FancyToast.makeText(context, "ERROR(Empty)" + msg, FancyToast.LENGTH_SHORT, FancyToast.ERROR, false).show();
            ((TextView) spin.getSelectedView()).setText("This Data is Required");
            ((TextView) spin.getSelectedView()).setTextColor(Color.RED);
            spin.setFocusableInTouchMode(true);
            spin.requestFocus();
            Log.i(context.getClass().getName(), context.getResources().getResourceEntryName(spin.getId()) + ": This data is Required!");
            return false;
        } else {
            ((TextView) spin.getSelectedView()).setError(null);
            return true;
        }
    }

    public static boolean EmptyRadioButton(Context context, RadioGroup rdGrp, RadioButton rdBtn, String msg) {
        if (rdGrp.getCheckedRadioButtonId() == -1) {
            FancyToast.makeText(context, "ERROR(empty): " + msg, FancyToast.LENGTH_SHORT, FancyToast.ERROR, false).show();
            rdBtn.setError("This data is Required!");    // Set Error on last radio button
            rdBtn.setFocusable(true);
            rdBtn.setFocusableInTouchMode(true);
            rdBtn.requestFocus();
            Log.i(context.getClass().getName(), context.getResources().getResourceEntryName(rdGrp.getId()) + ": This data is Required!");
            return false;
        } else {
            boolean rdbFlag = true;
            for (int j = 0; j < rdGrp.getChildCount(); j++) {
                View innerV = rdGrp.getChildAt(j);

                if (innerV instanceof RadioButton) {
                    if (!((RadioButton) innerV).isChecked()) continue;
                }

                if (innerV instanceof EditText) {
                    if (getIDComponent(rdGrp.findViewById(rdGrp.getCheckedRadioButtonId())).equals(innerV.getTag()))
                        if (innerV instanceof EditTextPicker)
                            rdbFlag = EmptyEditTextPicker(context, (EditText) innerV, getString(context, getIDComponent(innerV)));
                        else
                            rdbFlag = EmptyTextBox(context, (EditText) innerV, getString(context, getIDComponent(innerV)));
                }
                if (!rdbFlag) break;
            }

            if (rdbFlag) {
                rdBtn.setError(null);
                rdBtn.clearFocus();
                return rdbFlag;
            } else
                return rdbFlag;

        }
    }

    public static boolean EmptyRadioButton(Context context, RadioGroup rdGrp, RadioButton rdBtn, EditText txt, String msg) {
        if (rdGrp.getCheckedRadioButtonId() == -1) {
            FancyToast.makeText(context, "ERROR(empty): " + msg, FancyToast.LENGTH_SHORT, FancyToast.ERROR, false).show();
            rdBtn.setError("This data is Required!");    // Set Error on last radio button
            rdBtn.setFocusable(true);
            rdBtn.setFocusableInTouchMode(true);
            rdBtn.requestFocus();
            Log.i(context.getClass().getName(), context.getResources().getResourceEntryName(rdGrp.getId()) + ": This data is Required!");
            return false;
        } else {
            rdBtn.setError(null);
            rdBtn.clearFocus();
            if (rdBtn.isChecked()) {
                return EmptyTextBox(context, txt, msg);
            } else {
                txt.clearFocus();
                txt.setError(null);
                return true;
            }
        }
    }

    public static boolean EmptyCheckBox(Context context, LinearLayout container, CheckBox cbx, String msg) {

        Boolean flag = false;
        for (int i = 0; i < container.getChildCount(); i++) {
            View v = container.getChildAt(i);
            if (v instanceof CheckBox) {
                CheckBox cb = (CheckBox) v;
                cb.setError(null);

                if (!cb.isEnabled()) {
                    flag = true;
                    continue;
                } else {
                    if (!flag)
                        flag = false;
                }

                if (cb.isChecked()) {
                    flag = true;

                    for (int j = 1; j < container.getChildCount(); j++) {
                        View innerV = container.getChildAt(j);
                        if (innerV instanceof EditText) {
                            if (getIDComponent(cb).equals(innerV.getTag())) {
                                if (innerV instanceof EditTextPicker)
                                    flag = EmptyEditTextPicker(context, (EditText) innerV, getString(context, getIDComponent(innerV)));
                                else
                                    flag = EmptyTextBox(context, (EditText) innerV, getString(context, getIDComponent(innerV)));
                            }
                        }
                        if (!flag) break;
                    }
                    if (!flag) break;
                }
            }
        }
        if (!flag) {
            FancyToast.makeText(context, "ERROR(empty): " + msg, FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
            cbx.setError("This data is Required!");    // Set Error on last radio button

            Log.i(context.getClass().getName(), context.getResources().getResourceEntryName(cbx.getId()) + ": This data is Required!");
            return false;
        }
        return true;
    }

    public static boolean EmptyCheckBox(Context context, LinearLayout container, CheckBox cbx, EditText txt, String msg) {

        Boolean flag = false;
        for (int i = 0; i < container.getChildCount(); i++) {
            View v = container.getChildAt(i);
            if (v instanceof CheckBox) {
                CheckBox cb = (CheckBox) v;
                if (cb.isChecked()) {
                    flag = true;
                    break;
                }
            }
        }
        if (flag) {
            cbx.setError(null);
            //Changed According to J2ME Lint
            return !cbx.isChecked() || EmptyTextBox(context, txt, msg);
        } else {
            FancyToast.makeText(context, "ERROR(empty): " + msg, FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
            cbx.setError("This data is Required!");    // Set Error on last radio button

            Log.i(context.getClass().getName(), context.getResources().getResourceEntryName(cbx.getId()) + ": This data is Required!");
            return false;
        }
    }

    public static boolean EmptyCheckingContainer(Context context, ViewGroup lv) {

        for (int i = 0; i < lv.getChildCount(); i++) {
            View view = lv.getChildAt(i);

            if (view.getVisibility() == View.GONE || !view.isEnabled())
                continue;

            // use tag for some situations
            if (view.getTag() != null && view.getTag().equals("-1")) {
                if (view instanceof EditText)
                    ((EditText) view).setError(null);
                else if (view instanceof LinearLayout)
                    ClearClass.ClearAllFields(view, null);
                else if (view instanceof CheckBox)
                    ((CheckBox) view).setError(null);

                continue;

            }

            if (view instanceof CardView) {
                if (!EmptyCheckingContainer(context, (ViewGroup) view)) {
                    return false;
                }
            } else if (view instanceof RadioGroup) {

                boolean radioFlag = false;
                View v = null;
                for (byte j = 0; j < ((RadioGroup) view).getChildCount(); j++) {
                    if (((RadioGroup) view).getChildAt(j) instanceof RadioButton) {
                        v = ((RadioGroup) view).getChildAt(j);
                        radioFlag = true;
                        break;
                    }
                }

                if (!radioFlag) continue;

                if (v != null) {

                    String asNamed = getString(context, getIDComponent(view));

                    if (!EmptyRadioButton(context, (RadioGroup) view, (RadioButton) v, asNamed)) {
                        return false;
                    }
                }

            } else if (view instanceof Spinner) {
                if (!EmptySpinner(context, (Spinner) view, getString(context, getIDComponent(view)))) {
                    return false;
                }
            } else if (view instanceof EditText) {
                if (view instanceof EditTextPicker) {
                    if (!EmptyEditTextPicker(context, (EditText) view, getString(context, getIDComponent(view))))
                        return false;
                } else {
                    if (!EmptyTextBox(context, (EditText) view, getString(context, getIDComponent(view)))) {
                        return false;
                    }
                }
            } else if (view instanceof CheckBox) {
                if (!((CheckBox) view).isChecked()) {
                    ((CheckBox) view).setError(getString(context, getIDComponent(view)));
                    FancyToast.makeText(context, "ERROR(empty): " + getString(context, getIDComponent(view)), FancyToast.LENGTH_SHORT, FancyToast.ERROR, false).show();
                    return false;
                }
            } else if (view instanceof LinearLayout) {

                if (view.getTag() != null && view.getTag().equals("0")) {
                    if (!EmptyCheckBox(context, ((LinearLayout) view),
                            (CheckBox) ((LinearLayout) view).getChildAt(0),
                            getString(context, getIDComponent(((LinearLayout) view).getChildAt(0))))) {
                        return false;
                    }
                } else {
                    if (!EmptyCheckingContainer(context, (LinearLayout) view)) {
                        return false;
                    }
                }
            } else if (view instanceof ViewGroup) {
                if (!EmptyCheckingContainer(context, (ViewGroup) view)) {
                    return false;
                }
            }

        }
        return true;
    }

    public static String getIDComponent(View view) {
        String[] idName = (view).getResources().getResourceName((view).getId()).split("id/");

        return idName[1];
    }

    private static String getString(Context context, String idName) {

        Field[] fields = R.string.class.getFields();
        for (final Field field : fields) {

            if (field.getName().split("R$string.")[0].equals(idName)) {
                try {
                    int id = field.getInt(R.string.class); //id of string

                    return context.getString(id);

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }
}
