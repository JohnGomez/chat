package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerChat implements Runnable {

	private int port;
	private String name;

	public ServerChat(int port, String name) {
		this.port = port;
		this.name =name;
	}

	public void serverStart() throws IOException {
		ServerSocket server = new ServerSocket(port);
		System.out.println("Servidor inicializado na porta: "+ port);
		
		Socket cliente = server.accept();
		Scanner mensagem = new Scanner(cliente.getInputStream());

		while (mensagem.hasNextLine()) {
			System.out.println(name + ": " + mensagem.nextLine());
		}

	}

	@Override
	public void run() {
		try {
			serverStart();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
