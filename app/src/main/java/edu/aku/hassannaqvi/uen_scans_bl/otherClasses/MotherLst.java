package edu.aku.hassannaqvi.uen_scans_bl.otherClasses;

import android.database.Cursor;

/**
 * Created by ali.azaz on 5/8/2017.
 */

public class MotherLst {
    String child_name, child_id, mother_name, mother_id, date_of_birth, serial, serialm, agey, agem, aged, gender;

    public MotherLst(MotherLst m) {
        this.child_name = m.child_name;
        this.child_id = m.child_id;
        this.mother_name = m.mother_name;
        this.mother_id = m.mother_id;
        this.date_of_birth = m.date_of_birth;
        this.serial = m.serial;
        this.serialm = m.serialm;
        this.agey = m.agey;
        this.agem = m.agem;
        this.aged = m.aged;
        this.gender = m.gender;
    }

    public MotherLst() {
    }

    public String getChild_name() {
        return child_name;
    }

    public String getChild_id() {
        return child_id;
    }

    public String getMother_name() {
        return mother_name;
    }

    public String getMother_id() {
        return mother_id;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public String getSerial() {
        return serial;
    }

    public String getSerialm() {
        return serialm;
    }

    public String getAgey() {
        return agey;
    }

    public String getAgem() {
        return agem;
    }

    public String getAged() {
        return aged;
    }

    public String getGender() {
        return gender;
    }

    public MotherLst Hydrate(Cursor cursor) {
        this.child_name = cursor.getString(cursor.getColumnIndex("child_name"));
        this.child_id = cursor.getString(cursor.getColumnIndex("child_id"));
        this.mother_name = cursor.getString(cursor.getColumnIndex("mother_name"));
        this.mother_id = cursor.getString(cursor.getColumnIndex("mother_id"));
        this.date_of_birth = cursor.getString(cursor.getColumnIndex("date_of_birth"));
        this.serial = cursor.getString(cursor.getColumnIndex("serial"));
        this.serialm = cursor.getString(cursor.getColumnIndex("serialm"));
        this.agey = cursor.getString(cursor.getColumnIndex("cy"));
        this.agem = cursor.getString(cursor.getColumnIndex("cm"));
        this.aged = cursor.getString(cursor.getColumnIndex("cd"));
        this.gender = cursor.getString(cursor.getColumnIndex("gender"));

        return this;
    }
}
