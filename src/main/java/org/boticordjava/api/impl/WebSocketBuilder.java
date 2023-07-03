package org.boticordjava.api.impl;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

class WebSocketBuilder extends WebSocketClient {

    private final BoticordWebSocket boticordWebSocket;

    WebSocketBuilder(BoticordWebSocket boticordWebSocket) throws URISyntaxException {
        super(new URI("wss://gateway.boticord.top/websocket/"));
        this.boticordWebSocket = boticordWebSocket;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {

    }

    @Override
    public void onMessage(String message) {
        boticordWebSocket.handle(message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        if (code == 1006) {
            String format = String.format("onClose | code: %s | reason: %s | remote: %s", code, reason, remote);
            System.out.println(format);
            this.close(1006, "Token invalid");
            return;
        }

        // Переподключение в отдельном потоке
        Thread reconnectThread = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(5000); // Пауза перед повторным подключением (примерно 5 секунд)
                    boticordWebSocket.reconnect(); // Повторное подключение
                    if (this.isOpen()) {
                        return;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        reconnectThread.start();
    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
    }
}