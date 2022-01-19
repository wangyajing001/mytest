package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Test{
    /**
     * 功能：Java读取txt文件的内容
     * 步骤：1：先获得文件句柄
     * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
     * 3：读取到输入流后，需要读取生成字节流
     * 4：一行一行的输出。readline()。
     * 备注：需要考虑的是异常情况
     * @param filePath
     */
    public static void readTxtFile(String filePath){
        try {
            String encoding="GBk";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);//字节流
                String lineTxt = null;
                //List<Integer> list = new ArrayList<Integer>();
                while((lineTxt = bufferedReader.readLine()) != null){
                   // lineTxt = lineTxt.substring(0, 3);
                    System.out.println(lineTxt);
                    //list.add(Integer.parseInt(lineTxt));
                }
//                if (!list.isEmpty()) {
//                    int[] intArray = new int[list.size()];
//                    for (int i = 0; i < intArray.length; i++) {
//                        intArray[i] = list.get(i);
//                    }
//                    for (int temp : intArray) {
//                        System.out.println(temp);
//                    }
//                }

                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

    }

    public static void main(String argv[]){
        String filePath = "E:\\test.txt";

        readTxtFile(filePath);
    }

}
