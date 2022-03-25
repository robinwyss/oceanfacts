package com.dynatrace.demo.oceanfacts.entities;

import java.util.ArrayList;
import java.util.Date;

public class Fact {
    public String _id;
    public String value;
    public ArrayList<String> categories;
    public String factPath;
    public boolean success;
    public Date createdAt;
    public Date updatedAt;

}
