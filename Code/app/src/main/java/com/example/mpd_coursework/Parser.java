package com.example.mpd_coursework;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Parser
{
    ArrayList<Earthquake> parseData(String dataToParse)
    {
        Earthquake eq = new Earthquake();
        ArrayList<Earthquake> eList = null;

        try
        {
            Log.e("MyTag", "Inside Parse Data");
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(dataToParse));
            int eventType = xpp.getEventType();
            eList = new ArrayList<>();
            while (eventType != XmlPullParser.END_DOCUMENT)
            {
                if (eventType == XmlPullParser.START_TAG)
                {
                    if (xpp.getName().equalsIgnoreCase("item"))
                    {
                        eq = new Earthquake();
                    }
                    else if (xpp.getName().equalsIgnoreCase("title"))
                    {
                        String temp = xpp.nextText();
                        Log.e("MyTag", "EQ Title: " + temp );
                        eq.setTitle(temp);
                    }
                    else if (xpp.getName().equalsIgnoreCase("description"))
                    {
                        String temp = xpp.nextText();
                        String[] descArray = temp.split(";");
                        for (String a: descArray)
                        {
                            if (a.contains("Location"))
                            {
                                eq.setLocation(a);
                                Log.e("MyTag", "Location is: " + a);
                            }
                            if (a.contains("Magnitude"))
                            {
                                eq.setMagnitude(a);
                                Log.e("MyTag", "Magnitude is: " + a);
                            }
                            if (a.contains("Origin date/time"))
                            {
                                eq.setDateTime(a);
                                Log.e("MyTag", "DT: " + a);
                            }
                        }
                        Log.e("MyTag", "Description is: " + temp);
                        eq.setDescription(temp);

                    }
                    else if (xpp.getName().equalsIgnoreCase("link"))
                    {
                        String temp = xpp.nextText();
                        Log.e("MyTag", "EQ Link: " + temp);
                        eq.setLink(temp);
                    }
                    else if (xpp.getName().equalsIgnoreCase("pubDate"))
                    {
                        String temp = xpp.nextText();
                        Log.e("MyTag", "EQ Published Date: " + temp);
                        eq.setPubDate(temp);
                    }
                    else if (xpp.getName().equalsIgnoreCase("category"))
                    {
                        String temp = xpp.nextText();
                        Log.e("MyTag", "EQ Category: " + temp);
                        eq.setCategory(temp);
                    }
                    else if (xpp.getName().equalsIgnoreCase("lat"))
                    {
                        String temp = xpp.nextText();
                        Log.e("MyTag", "EQ Lat: " + temp);
                        eq.setLatitude(temp);
                    }
                    else if (xpp.getName().equalsIgnoreCase("long"))
                    {
                        String temp = xpp.nextText();
                        Log.e("MyTag", "EQ Long: " + temp);
                        eq.setLongitude(temp);
                    }
                }
                else if (eventType == XmlPullParser.END_TAG)
                {
                    if (xpp.getName().equalsIgnoreCase("item"))
                    {
                        Log.e("MyTag", "" + eq.toString());
                        eList.add(eq);

                    }
                    else if (xpp.getName().equalsIgnoreCase("rss"))
                    {
                        int size;
                        size = eList.size();
                        Log.e("MyTag", "EQ size is " + size);
                    }
                }
                eventType = xpp.next();
            } //End of while
        }
        catch (XmlPullParserException e)
        {
            Log.e("MyTag", "Parsing Error" + e.toString());
        }
        catch (IOException e)
        {
            Log.e("MyTag", "IO error during parsing");
        }
        Log.e("MyTag", "End Document");
        return eList;
    }
}
