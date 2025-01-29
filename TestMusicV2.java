package com.trishawrites;
/**
 * Purpose: The purpose of this program is to understand the binary search method
 * for various elements in the Music Array (of 10 music objects). We use
 * insertion, selection, or merge sort to attain values for the title, year, and artist.
 *
 * @author Trisha Ganesh
 * @version 6/27/2021
 *
 */

public class TestMusicV2 {

    public static void main(String[] args)
    {
        //music array
        Music[] music = new Music[10];

        music[0] = new Music("Butter", 2021, "BTS");
        music[1] = new Music("Good 4 U", 2021, "Olivia Rodrigo");
        music[2] = new Music("Save Your Tears", 2021, "The Weekend & Ariana Grande");
        music[3] = new Music("Astronaut In The Ocean ", 2019, "Masked Wolf");
        music[4] = new Music("Counting Stars", 2013, "One Republic");
        music[5] = new Music("Happier", 2018, "Marshmello & Bastille");
        music[6] = new Music("Believer", 2017, "Imagine Dragons");
        music[7] = new Music("I Wanna Hold Your Hand", 1964, "The Beatles");
        music[8] = new Music("Moonlight Sonata", 1801, "Beethoven");
        music[9] = new Music("Für Elise", 1867, "Beethoven");

        int search;

        printMusic(music);

        System.out.println("\n\nSearching for Happier: ");
        System.out.println("---------------------------");
        selectionSortTitle(music);
        search = binaryTitle(music, "Happier");
        if(search != -1)
            System.out.println("Found: " + music[search]);
        else
            System.out.println("Not found. " );

        System.out.println("\n\nSearching for Come As You Are: ");
        System.out.println("-----------------------------------");
        search = binaryTitle(music, "Come As You Are");
        if(search != -1)
            System.out.println("Found: " + music[search]);
        else
            System.out.println("Song not found. " );

        System.out.println("\n\nSearching for 2021 Songs: ");
        selectionSortYear(music);
        binaryYear(music, 2021);

        System.out.println("\n\nSearching for songs in 2000: ");
        System.out.println("-----------------------------------");
        selectionSortYear(music);
        binaryYear(music, 2000);

        System.out.println("\n\nSearching for Beethoven Songs: ");
        System.out.println("-----------------------------------");
        selectionSortArtist(music);
        binaryArtist(music, "Beethoven");

        System.out.println("\n\nSearching for The Beatles: ");
        System.out.println("---------------------------");
        selectionSortArtist(music);
        binaryArtist(music, "The Beatles");

        System.out.println("\n\nSearching for Metallica: ");
        System.out.println("-----------------------------");
        selectionSortArtist(music);
        binaryArtist(music, "Metallica");

    }

    //selection sort method for title
    public static void selectionSortTitle(Music[] element) {
        int index;
        int k;
        int posMax;
        Music music;

        for (index = element.length - 1; index >= 0; index--) {
            posMax = 0;
            for (k = 0; k <= index; k++) {
                if (element[k].getTitle().compareTo(element[posMax].getTitle()) > 0) {
                    posMax = k;
                }
                music = element[index];
                element[index] = element[posMax];
                element[posMax] = music;
            }
        }
    }

    //binary method for Title
    public static int binaryTitle(Music[] element, String toFind)
    {
        int high = element.length;
        int low = -1;
        int probe;

        while( high - low > 1 )
        {
            probe = ( high + low ) / 2;
            if( element[probe].getTitle().compareTo(toFind) > 0)
                high = probe;
            else
                low = probe;
        }

        if( (low >= 0) && (element[low].getTitle().compareTo(toFind) == 0))
            return low;
        else
            return -1;
    }

    //selection sort method for Year
    public static void selectionSortYear(Music[] element) {
        int index;
        int k;
        int posMax;
        Music music;

        for(index = element.length - 1; index >= 0; index--)
        {
            posMax = 0;
            for(k = 0; k <= index; k++)
            {
                if(element[k].getYear() > element[posMax].getYear())
                    posMax = k;
            }
            music = element[index];
            element[index] = element[posMax];
            element[posMax] = music;
        }
    }

    //binary method for year
    public static void binaryYear(Music[] element, int toFind)
    {
        int high = element.length;
        int low = -1;
        int probe;

        while( high - low > 1 )
        {
            probe = ( high + low ) / 2;

            if(element[probe].getYear() > toFind)
                high = probe;
            else
            {
                low = probe;
                if(element[probe].getYear() == toFind)
                {
                    break;
                }
            }
        }
        if( (low >= 0) && (element[low].getYear() == toFind))
        {
            linearPrintYear(element, low, toFind);
        }
        else
            System.out.println("Not found: " + toFind);
    }

    //linear method for years
    public static void linearPrintYear(Music[] element, int lowEnd, int toFind)
    {
        int i;
        int start = lowEnd;
        int end = lowEnd;

        // find starting point of matches
        i = lowEnd - 1;
        while((i >= 0) && (element[i].getYear() == toFind))
        {
            start = i;
            i--;
        }
        // find ending point of matches
        i = lowEnd + 1;
        while((i < element.length) && (element[i].getYear() == toFind))
        {
            end = i;
            i++;
        }
        // now print out the matches
        for(i = start; i <= end; i++)
            System.out.println(element[i]);
    }

    //selection sort method for Artist
    public static void selectionSortArtist(Music[] element) {
        int index;
        int k;
        int posMax;
        Music music;

        for (index = element.length - 1; index >= 0; index--) {
            posMax = 0;
            for (k = 0; k <= index; k++) {
                if (element[k].getArtist().compareTo(element[posMax].getArtist()) > 0) {
                    posMax = k;
                }
                music = element[index];
                element[index] = element[posMax];
                element[posMax] = music;
            }
        }
    }

    //binary method for Artist
    public static void binaryArtist(Music[] element, String toFind)
    {
        int high = element.length;
        int low = -1;
        int probe;

        while( high - low > 1 )
        {
            probe = ( high + low ) / 2;

            if(element[probe].getArtist().compareTo(toFind) > 0)
                high = probe;
            else
            {
                low = probe;
                if(element[probe].getArtist().compareTo(toFind) == 0)
                {
                    break;
                }
            }
        }

        if( (low >= 0) && (element[low].getArtist().compareTo(toFind) == 0))
        {
            linearPrintArtist(element, low, toFind);
        }
        else
            System.out.println("NOT found: " + toFind);
    }

    //linear method for Artist
    public static void linearPrintArtist(Music[] element, int lowEnd, String toFind)
    {
        int i;
        int start = lowEnd;
        int end = lowEnd;

        // find starting point of matches
        i = lowEnd - 1;
        while((i >= 0) && (element[i].getArtist().compareTo(toFind) == 0))
        {
            start = i;
            i--;
        }
        // find ending point of matches
        i = lowEnd + 1;
        while((i < element.length) && (element[i].getArtist().compareTo(toFind) == 0))
        {
            end = i;
            i++;
        }
        // now print out the matches
        for(i = start; i <= end; i++)
            System.out.println(element[i]);
    }

    //print results
    public static void printMusic(Music[] element)
    {
        System.out.println("                   Music PlayList                      ");
        System.out.println();
        System.out.println("Title                          Year   Artist           ");
        System.out.println("-------------------------------------------------------");
        for (Music music : element)
            System.out.printf("%-30s %4d   %-20s \n", music.getTitle(), music.getYear(), music.getArtist());
    }
}