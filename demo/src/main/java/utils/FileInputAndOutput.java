package utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class FileInputAndOutput {
    File file;

    public FileInputAndOutput(String pathName) {
        file = new File(pathName);
    }

    public void createFile() {
        if (file.exists()) {
            file.delete();
            System.out.println("文件已删除");
        } else {
            try {
                file.createNewFile();
                System.out.println("文件创建完成");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void write(String content) {
        try {
            if (file.exists()) {
                FileOutputStream out = new FileOutputStream(file);
                DataOutputStream ds = new DataOutputStream(out);
                ds.writeUTF("UTF写入数据");
                byte[] b = content.getBytes();
                // out.write(b);
                ds.close();
                System.out.println("内容写入文件中");
            } else {
                System.out.println("文件不存在");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void read() {
        StringBuilder str = new StringBuilder();
        try {
            if (file.exists()) {
                FileInputStream fi = new FileInputStream(file);
                BufferedReader in = new BufferedReader(new FileReader(file));
                DataInputStream ds = new DataInputStream(fi);
                String s = "";
                System.out.println();
                while ((s = in.readLine()) != null) {
                    str.append(s);
                }
                in.close();
                System.out.println(ds.readUTF());
                System.out.println("内容是：" + str);
                ds.close();
            } else {
                System.out.println("文件不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void zip() {
        try {
            FileOutputStream fo = new FileOutputStream("hello.zip");
            ZipOutputStream out = new ZipOutputStream(fo);
            if (file.isDirectory()) {
                File[] fl = file.listFiles();
                for (int i = 0; i < fl.length; i++) {

                }
            } else {
                out.putNextEntry(new ZipEntry(""));
                FileInputStream fi = new FileInputStream(file);
                int len = 0;
                byte[] b = new byte[1024];
                while ((len = fi.read(b)) != -1) {
                    out.write(b, 0, len);
                }
                fi.close();
            }
            System.out.println("压缩中......");
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getZip() {
        File file = new File("hello.zip");
        // file.getParentFile().mkdirs()
        try {
            ZipInputStream zis = new ZipInputStream(new FileInputStream(file));
            ZipFile f = new ZipFile();
            ZipEntry ze = zis.getNextEntry();
            while ((ze = zis.getNextEntry()) != null && !ze.isDirectory()) {

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
