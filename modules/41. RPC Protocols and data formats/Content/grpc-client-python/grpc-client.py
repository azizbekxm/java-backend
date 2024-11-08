from os import times
from google.protobuf import message
import grpc
import ping_pong_pb2
import ping_pong_pb2_grpc
import time


def send_request():
	with grpc.insecure_channel('localhost:8080') as channel:
		stub = ping_pong_pb2_grpc.PingPongServiceStub(channel)
		request = ping_pong_pb2.PingRequest(
			message = 'Hello from Python GRPC Client',
			timestamp = int(time.time())
		)
		response = stub.pingPong(request)
		print(f'Got a response: "{response.message}" at {response.timestamp}')


if __name__ == '__main__':
	send_request()
