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
    /**
     * Main запрос ответ к серверу.
     *
     * @param args String[]
     * @throws IOException Exeption
     */
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    str = in.readLine();
                    System.out.println(str);
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    if (str.contains("msg=Exit")) {
                        out.write("Bye".getBytes());
                        break;
                    } else if (str.contains("msg=Hello")) {
                        out.write("Hello, dear friend.".getBytes());
                    } else if (!(str.contains("msg=Exit") || str.contains("msg=Hello")) && str.contains("msg=")) {
                        String[] tmp = str.split("[ |=]", 4);
                        out.write(tmp[2].getBytes());
                    }
                }
            }
        }
    }
}
