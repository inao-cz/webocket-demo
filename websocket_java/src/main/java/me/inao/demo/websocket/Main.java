package me.inao.demo.websocket;

public class Main {
    public static void main(String[] args) {
        new Main().start(args);
    }
    public void start(String[] args){
        new WebSocketClientThread("ws://localhost:8080/").run();
    }
}