package me.inao.demo.websocket;

import jakarta.websocket.*;

import java.net.URI;

@ClientEndpoint
public class WebSocketClientThread{
    private final String serverUrl;

    public WebSocketClientThread(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public void run() {
        WebSocketContainer c = ContainerProvider.getWebSocketContainer();
        try(Session s = c.connectToServer(this, URI.create(serverUrl))){
            s.getBasicRemote().sendText("Hello World 1337");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(String message){
        System.out.println("Got message: " + message);
    }
}
