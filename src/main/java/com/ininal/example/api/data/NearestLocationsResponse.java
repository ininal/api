package com.ininal.example.api.data;

import java.util.List;

/**
 * Created by yaseminbakir on 22.12.2017.
 */
public class NearestLocationsResponse
{
    //List of the nearest locations
    private List<NearestLocation> list;

    public List<NearestLocation> getList()
    {
        return list;
    }

    public void setList(List<NearestLocation> list)
    {
        this.list = list;
    }
}
