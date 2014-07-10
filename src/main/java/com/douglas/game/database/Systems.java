package com.douglas.game.database;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Table;

import javax.persistence.*;

/**
 * Created by Douglas on 7/6/2014.
 */
@Entity ( name = "Systems" )
public class Systems {
    private int id;
    private int xCoord;
    private int yCoord;

    @Id
    @GeneratedValue( generator = "increment" )
    @GenericGenerator( name = "increment", strategy = "increment" )
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "x_coord", nullable = false, insertable = true, updatable = true)
    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    @Basic
    @Column(name = "y_coord", nullable = false, insertable = true, updatable = true)
    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Systems systems = (Systems) o;

        if (id != systems.id) return false;
        if (xCoord != systems.xCoord) return false;
        if (yCoord != systems.yCoord) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + xCoord;
        result = 31 * result + yCoord;
        return result;
    }
}
