package com.douglas.game.database.schema;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Represents a star system on the galactic map.
 */
@Entity ( name = "Systems" )
public class System {
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

    private void setId(int id) {
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

        System system = (System) o;

        if (id != system.id) return false;
        if (xCoord != system.xCoord) return false;
        if (yCoord != system.yCoord) return false;

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
