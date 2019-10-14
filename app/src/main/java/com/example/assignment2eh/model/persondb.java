package com.example.assignment2eh.model;

import java.util.ArrayList;

public class persondb {
    private static final persondb ourInstance = new persondb();

    private ArrayList<person> mPersonList;

    public static persondb getOurInstance() {
        return ourInstance;
    }

    private persondb(){

    }

    public ArrayList<person> getPersonList() {
        return mPersonList;
    }

    public void setPersonList(ArrayList<person> personList) {
        mPersonList = personList;
    }
}
