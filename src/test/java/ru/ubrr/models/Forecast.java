package ru.ubrr.models;

import java.util.ArrayList;

public class Forecast {
    public String date;
    public int date_ts;
    public int week;
    public String sunrise;
    public String sunset;
    public String rise_begin;
    public String set_end;
    public int moon_code;
    public String moon_text;
    public Parts parts;
    public ArrayList<Hour> hours;
    public Biomet biomet;
}
