package com.nara.narayana;

import java.io.*;
import java.util.ArrayList;

public class ListController
{
    private static File rootPathFile;
    private static File pathToSaveData;
    private static ArrayList<File> imgFilesList = new ArrayList<>();

    public static void main(String[] args) throws IOException, InterruptedException
    {
        setPath();
        setOutputFilePath();
        digPath(rootPathFile, new ImagesFilter());
        writeAllToHTMLFile(new ImageTemplate());

        System.out.println("Создание файла завершено, количество добавленных фото: " + imgFilesList.size());
        System.out.print("Нажмите Enter для завершения работы");
        InputStreamReader is = new InputStreamReader(System.in);
        is.read();
        is.close();

    }

    public static void digPath(File path, FileFilter filter)
    {
        File[] list = path.listFiles(filter);
        ListController.getImagesFromList(list);
        try
        {
            for (File f : list)
            {
                if (f.isDirectory())
                    digPath(f, filter);
            }
        } catch (NullPointerException ignore)
        {
            /*NOP*/
        }
    }

    public static void getImagesFromList(File[] files)
    {
        for (File f : files)
        {
            if (f.isFile())
            {
                ListController.imgFilesList.add(f);
            }
        }
    }

    public static void writeAllToHTMLFile(Template template) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathToSaveData.toString()), "CP1251"));

        writer.write(template.getHtmlHeader());

        for (File f : imgFilesList)
        {
            String line = "<p><a href=\"";
            line = line.concat(f.toString());
            line = line.concat("\" download><img src=\"");
            line = line.concat(f.toString());
            line = line.concat("\" alt=\"logo\"></a></p>\r\n");

            writer.write(line);
        }

        writer.write(template.getHtmlFooter());
        writer.flush();
        writer.close();
    }

    public static void setPath() throws IOException
    {
        System.out.print("Пожалуйста, введите путь к папке, для поиска в ней картинок: ");
        BufferedReader readPath = new BufferedReader(new InputStreamReader(System.in, "cp866"));

        while (true)
        {
            String rootPath = readPath.readLine();
            rootPathFile = new File(rootPath);
            if (rootPathFile.exists() && rootPathFile.isDirectory())
                break;
            System.out.print("Введенный путь (" + rootPathFile.toString() + ") неверен, пожалуйста повторите ввод: ");
        }
    }

    public static void setOutputFilePath() throws IOException
    {
        System.out.print("Пожалуйста, введите имя файла куда сохранить результат: ");
        BufferedReader readPath = new BufferedReader(new InputStreamReader(System.in, "cp866"));

        while (true)
        {
            String rootPath = readPath.readLine();
            pathToSaveData = new File(rootPath);
            if (rootPathFile.exists() && rootPathFile.isDirectory())
                break;
            System.out.print("Введенный путь (" + rootPathFile.toString() + ") неверен, пожалуйста повторите ввод: ");
        }
    }


}
