package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.2.Socket
 * 1. Бот [#289019]
 *
 * @since 17.07.2020
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean work = true;
            while (work) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String result;
                    for (str = in.readLine(); !str.isEmpty(); str = in.readLine()) {
                        System.out.println(str);
                        if (str.contains("msg=Exit")) {
                            work = false;
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write("Bye".getBytes());
                            break;
                        } else if (str.contains("msg=Hello")) {
                            result = "Hello, dear friend";
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write(result.getBytes());
                        } else if (!(str.contains("msg=Exit") || str.contains("msg=Hello")) && str.contains("msg=")) {
                            String[] tmp = str.split("[ |=]", 4);
                            result = tmp[2];
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write(result.getBytes());
                        }
                    }
                }
            }
        }
    }
}
