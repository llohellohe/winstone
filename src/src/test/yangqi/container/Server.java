/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package yangqi.container;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 类Server.java的实现描述：TODO 类实现描述 
 * @author yangqi 2013-4-28 上午11:08:25
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8090);

        // server.setSoTimeout(10000);

        int id = 0;
        while (true) {
            id++;
            System.out.println("WAIT " + id);
            Socket socket = server.accept();

            process(socket);



            System.out.println(socket);

        }
    }

    /**
     * @param socket
     * @throws IOException
     */
    private static void process(Socket socket) throws IOException {
        InputStream inp = socket.getInputStream();


        OutputStream out = socket.getOutputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inp));

        String line = reader.readLine();
        System.out.println("read line " + line);

        while (line.length() > 0 && line.contains(":")) {
            System.out.println("read line " + line);
            line = reader.readLine();
        }
        



        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

        writer.write("<a href='www.google.com'>HELLO</a>");

        out.flush();
        writer.close();

    }
}
