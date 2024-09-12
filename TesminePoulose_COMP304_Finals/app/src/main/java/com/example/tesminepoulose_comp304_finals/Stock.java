package com.example.tesminepoulose_comp304_finals;



import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Stock {

    @PrimaryKey(autoGenerate = true)
    private int Stockid;
    private String Stockname;
    private int Stockvalue;

    public int getStockid() {
        return Stockid;
    }
    public void setStockid(int Stockid) {
        this.Stockid = Stockid;
    }

    public String getStockname() {
        return Stockname;
    }
    public void setStockname(String Stockname) {
        this.Stockname = Stockname;
    }

    public int getStockvalue() {return Stockvalue;}
    public void setStockvalue(int Stockvalue) {this.Stockvalue=Stockvalue;}
}

