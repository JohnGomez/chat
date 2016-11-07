package server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientChat implements Runnable {

	private String ip;
	private int port;

	public ClientChat(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	public void enviarMensagem() throws UnknownHostException, IOException {
		Socket cliente = new Socket(ip,port);
		System.out.println("Conexão Estabelecida como: "+ ip);
		
		Scanner mensagemParaEnvio = new Scanner(System.in);
		PrintStream saida = new PrintStream(cliente.getOutputStream());
		while (mensagemParaEnvio.hasNextLine()) {
			saida.println(mensagemParaEnvio.nextLine());
		}

		saida.close();
		mensagemParaEnvio.close();
	}

	@Override
	public void run() {
		try {
			enviarMensagem();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
