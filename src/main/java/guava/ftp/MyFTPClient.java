package guava.ftp;

import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/5/28.
 *
 * @author 张小虎
 * @version 1.0
 */
public class MyFTPClient {

    private static FTPClient client;

    static String hostName = "127.0.0.1";
    //String port = "21";
    static String username = "OneLazyFox";
    static String password = "a8jk370mp";

    public static void main(String[] args) {
        client = new FTPClient();

        String fileName = "hp_M1530_MFP_Basic_usb_n_w.exe";

        File file = new File("E://" + fileName);

        long fileSize = file.length();
        long transferredSize = 0;

        int bufferSize = 1024 * 2;

        byte[] buffer = new byte[bufferSize];

        FileInputStream fileInputStream = null;

        try {
            client.connect(hostName);
            System.out.println(client.getReplyString());

            client.login(username,password);
            System.out.println(client.getReplyString());

            client.setFileType(FTPClient.BINARY_FILE_TYPE);

            fileInputStream = new FileInputStream(file);

            OutputStream outputStream = client.storeFileStream(fileName);

            int n = -1;

            System.out.println("File size: " + fileSize);

            while ((n = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer);
                transferredSize += n;
                System.out.println("进度： " + (transferredSize * 100 / fileSize) + "%");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("Clone Input Stream");
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (client.isConnected()) {
                try {
                    System.out.println("Clone FTP Client");
                    client.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
