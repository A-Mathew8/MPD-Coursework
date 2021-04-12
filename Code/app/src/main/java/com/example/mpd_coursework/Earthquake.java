package com.example.mpd_coursework;

import java.io.Serializable;

public class Earthquake implements Serializable
{
    private String title;
    private String location;
    private String magnitude;
    private String description;
    private String link;
    private String pubDate;
    private String category;
    private String latitude;
    private String longitude;
    private String dateTime;

    public String getTitle ()
    {
        return title;
    }

    public String getLocation(){return location;}

    public String getMagnitude(){return magnitude;}

    public String getDescription()
    {
        return description;
    }

    public String getLink() { return link; }

    public String getPubDate()
    {
        return pubDate;
    }

    public String getCategory()
    {
        return category;
    }

    public String getLatitude()
    {
        return latitude;
    }

    public String getLongitude()
    {
        return longitude;
    }

    public String getDateTime(){return dateTime;}

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public void setMagnitude(String magnitude)
    {
        this.magnitude = magnitude;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    public void setPubDate(String pubDate)
    {
        this.pubDate = pubDate;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public void setLatitude(String Latitude)
    {
        this.latitude = latitude;
    }

    public void setLongitude(String Longitude)
    {
        this.longitude = longitude;
    }

    public void setDateTime(String dateTime) {this.dateTime = dateTime;}

    public Earthquake()
    {
        title = "";
        description = "";
        link = "";
        pubDate = "";
        category = "";
        latitude = "";
        longitude = "";
    }


}
