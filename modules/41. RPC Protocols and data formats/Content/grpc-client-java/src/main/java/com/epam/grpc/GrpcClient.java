package com.epam.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.epam.grpc.PingPongServiceGrpc;
import com.epam.grpc.PingPong;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
            .forTarget("localhost:8080")
            .usePlaintext()
            .build();
        PingPongServiceGrpc.PingPongServiceBlockingStub stub = PingPongServiceGrpc.newBlockingStub(channel);
        PingPong.PingRequest request = PingPong.PingRequest.newBuilder()
            .setMessage("Hello from Java GRPC Client")
            .setTimestamp(System.currentTimeMillis())
            .build();
        PingPong.PongResponse response = stub.pingPong(request);
        System.out.println("Got a response: '" + response.getMessage() + "' at " +response.getTimestamp());
        channel.shutdownNow();
    }
}
