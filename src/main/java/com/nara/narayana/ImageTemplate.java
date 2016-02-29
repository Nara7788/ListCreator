package com.nara.narayana;

import java.util.ArrayList;

public class ImageTemplate implements Template
{
    private static String htmlHeader = "";
    private static String htmlFooter = "";

    static
    {
        htmlHeader = htmlHeader.concat("<!DOCTYPE html>\n <head>\n  <style>\n");
        htmlHeader = htmlHeader.concat("  img{\n  max-width:30%;\n  float:left;\n  margin: 1%;}\n");
        htmlHeader = htmlHeader.concat("  </style>\n  <meta charset=\"cp1251\">\n");
        htmlHeader = htmlHeader.concat("  <title>Фотобаза</title>\n");
        htmlHeader = htmlHeader.concat(" </head>\n <body>\n\n");

        htmlFooter = htmlFooter.concat("\n </body>\n</html>");
    }

    public String getHtmlHeader()
    {
        return htmlHeader;
    }

    public String getHtmlFooter()
    {
        return htmlFooter;
    }
}
