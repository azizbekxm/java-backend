package com.epam.grpc;

import io.grpc.stub.StreamObserver;

public class PingPongServiceImpl extends PingPongServiceGrpc.PingPongServiceImplBase {

    @Override
    public void pingPong(PingPong.PingRequest request, StreamObserver<PingPong.PongResponse> responseObserver) {
        String messageFromClient = request.getMessage();
        PingPong.PongResponse response = PingPong.PongResponse
            .newBuilder()
            .setMessage("Hello from Java GRPC Server! You sent me - " + messageFromClient)
            .setTimestamp(System.currentTimeMillis())
            .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
