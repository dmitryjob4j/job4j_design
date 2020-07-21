package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.2.Socket
 * 4. Slf4j - вывод exception. [#288999]
 *
 * @since 17.07.2020
 */
public class EchoServer {
    /**
     * приватная константа loggera
     */
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

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
                    throw new Exception("Not supported code");
                } catch (Exception e) {
                    LOG.error("Exception in log example", e);
                }
            }
        }
    }
}
