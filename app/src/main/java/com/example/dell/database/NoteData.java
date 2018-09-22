package com.example.dell.database;

import org.litepal.crud.DataSupport;

public class NoteData extends DataSupport{
    public String databody;
    public String datatime;

    public String getDatabody() {
        return databody;
    }

    public void setDatabody(String databody) {
        this.databody = databody;
    }

    public String getDatatime() {
        return datatime;
    }

    public void setDatatime(String datatime) {
        this.datatime = datatime;
    }
}
