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
                    for (str = in.readLine(); !str.isEmpty(); str = in.readLine()) {
                        System.out.println(str);
                        if (str.contains("msg=Exit")) {
                            work = false;
                            out.write("Bye \r\n\r\n".getBytes());
                        } else if (str.contains("msg=Hello")) {
                            out.write("Hello, dear friend\r\n\r\n".getBytes());
                        } else if (str.contains("msg=Any")) {
                            out.write("Any \r\n\r\n".getBytes());
                        }
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                }
            }
        }
    }
}
