import { WebSocketServer } from 'ws';

const wss = new WebSocketServer({ port: 8080 });

wss.on('connection', function connection(ws) {
    ws.on('message', function message(data) {
        //password check, etc.. can be here before broadcast
        wss.broadcast("" + data, ws._sender._socket);
    });
    ws.on('close', function close() {
        console.log('Client disconnected %s %s', ws._sender._socket.remoteAddress, ws._sender._socket.remotePort);
    })

    ws.send('1');
});

wss.broadcast = function broadcast(msg, sender) {
    wss.clients.forEach(function each(client) {
        if(client._socket.remotePort !== sender.remotePort){
            client.send(msg);
        }
    });
};