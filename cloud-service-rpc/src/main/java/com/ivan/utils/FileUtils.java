package com.ivan.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hylu.ivan
 * @date 2022/2/9 下午8:00
 * @description
 */
public class FileUtils {

    /**
     * 按行读取文件
     * @param path
     * @return
     */
    public static List<String> readFileByLines(String path) {
        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = null;
        BufferedReader bufferedReader = null;
        List<String> list = new ArrayList<>();
        try {
            inputStream = new FileInputStream(path);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String str = null;
            while((str = bufferedReader.readLine()) != null)
            {
                list.add(str);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            //close
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != bufferedReader) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return list;
        }
    }

    /**
     * 将对象写入文件
     * @param path
     * @param list
     */
    public static void writeFilesByObject(String path, List<Object> list) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(list);
            System.out.println("output over");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 从文件中读取对象
     * @param path
     * @return 可以转换为List<T></>的Object对象
     */
    public static Object readFilesByObject(String path) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(path));
            Object obj= ois.readObject();
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(null != ois) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
