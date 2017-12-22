package com.ininal.example.api.data;

/**
 * Created by yaseminbakir on 22.12.2017.
 */
public class NearestLocation
{
    //Y coordinate of point.
    private String coordinateY;

    //X coordinate of point.
    private String coordinateX;

    //Type of the point. For example; SALES POINT
    private String type;

    //Name of the location.
    private String name;

    //description of the location
    private String description;

    //address of the location
    private String address;

    //icon of the location
    private String icon;

    public String getCoordinateY()
    {
        return coordinateY;
    }

    public void setCoordinateY(String coordinateY)
    {
        this.coordinateY = coordinateY;
    }

    public String getCoordinateX()
    {
        return coordinateX;
    }

    public void setCoordinateX(String coordinateX)
    {
        this.coordinateX = coordinateX;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getIcon()
    {
        return icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon;
    }
}
