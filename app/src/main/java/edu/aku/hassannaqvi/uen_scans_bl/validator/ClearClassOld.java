package edu.aku.hassannaqvi.uen_scans_bl.validator;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.cardview.widget.CardView;

/**
 * Created by ali.azaz on 03/19/18.
 */

public class ClearClassOld {

    public static void ClearRadioButton(RadioGroup rdGrp, boolean flag) {

        rdGrp.clearCheck();
        rdGrp.setEnabled(flag);

        for (int i = 0; i < rdGrp.getChildCount(); i++) {
            View v = rdGrp.getChildAt(i);
            if (v instanceof RadioButton) {
                v.setEnabled(flag);
            }
        }
    }

    public static void ClearRadioButton(LinearLayout container, RadioGroup rdGrp, EditText othertxt) {
        if (rdGrp.getCheckedRadioButtonId() == -1) {

            rdGrp.clearCheck();
            othertxt.setText(null);

            for (int i = 0; i < container.getChildCount(); i++) {
                View v = container.getChildAt(i);
                if (v instanceof RadioButton) {
                    v.setEnabled(false);
                }
            }
        }
    }

    public static void ClearCheckBoxes(LinearLayout container) {
        for (int i = 0; i < container.getChildCount(); i++) {
            View v = container.getChildAt(i);
            if (v instanceof CheckBox) {
                ((CheckBox) v).setChecked(false);
                v.setEnabled(false);
            }
        }
    }

    public static void ClearCheckBoxes(LinearLayout container, EditText othertxt) {

        othertxt.setText(null);

        for (int i = 0; i < container.getChildCount(); i++) {
            View v = container.getChildAt(i);
            if (v instanceof CheckBox) {
                ((CheckBox) v).setChecked(false);
                v.setEnabled(false);
            }
        }
    }

/*    public static void ClearAllFields(LinearLayout container, Boolean flag) {
        for (int i = 0; i < container.getChildCount(); i++) {
            View v = container.getChildAt(i);
            if (v instanceof CheckBox) {
                ((CheckBox) v).setChecked(false);
                ((CheckBox) v).setError(null);
            } else if (v instanceof RadioGroup) {
                ((RadioGroup) v).clearCheck();
            } else if (v instanceof EditText) {
                ((EditText) v).setText(null);
                ((EditText) v).setError(null);
                v.clearFocus();
            } else if (v instanceof CardView) {
                ClearAllCardFields((CardView) v, flag);
            } else if (v instanceof LinearLayout) {
                ClearAllFields((LinearLayout) v, flag);
            }
        }
    }*/

    private static void ClearAllCardFields(CardView container, Boolean flag) {
        for (int i = 0; i < container.getChildCount(); i++) {
            View v = container.getChildAt(i);
            if (v instanceof CheckBox) {
                ((CheckBox) v).setChecked(false);
                ((CheckBox) v).setError(null);
            } else if (v instanceof RadioGroup) {
                ((RadioGroup) v).clearCheck();
            } else if (v instanceof EditText) {
                ((EditText) v).setText(null);
                ((EditText) v).setError(null);
                v.clearFocus();
            } else if (v instanceof LinearLayout) {
                ClearAllFields(v, null);
            }
        }
    }

    public static void ClearAllFields(View container, Boolean flag) {
        for (int i = 0; i < ((ViewGroup) container).getChildCount(); i++) {
            View v = ((ViewGroup) container).getChildAt(i);
            if (v instanceof CheckBox) {
                ((CheckBox) v).setChecked(false);
                ((CheckBox) v).setError(null);
                if (flag != null)
                    v.setEnabled(flag);

            } else if (v instanceof RadioGroup) {
                ((RadioGroup) v).clearCheck();
                if (flag != null) {
                    for (int j = 0; j < ((RadioGroup) v).getChildCount(); j++) {
                        ((RadioGroup) v).getChildAt(j).setEnabled(flag);
                    }
                }

            } else if (v instanceof EditText) {
                ((EditText) v).setText(null);
                ((EditText) v).setError(null);
                v.clearFocus();

                if (flag != null)
                    v.setEnabled(flag);

            } else if (v instanceof RadioButton) {
                ((RadioButton) v).setChecked(false);
                if (flag != null)
                    v.setEnabled(flag);

            } else if (v instanceof CardView) {
                ClearAllFields(v, flag);
            } else if (v instanceof LinearLayout) {
                ClearAllFields(v, flag);
            }

        }
    }


}
