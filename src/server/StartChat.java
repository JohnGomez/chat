package server;

import java.io.FileInputStream;
import java.util.Properties;

public class StartChat {
	
	private static String ip;
    private static String name;
	private static int portclient;
	private static int portServer;

	
    public static void loadProperties() {
		try {
			Properties prop = new Properties();
			FileInputStream file = new FileInputStream("C:/Users/Temp/workspace/config.properties");
			
			prop.load(file);
			ip = prop.getProperty("ip");
			name = prop.getProperty("nome");
			portServer = Integer.parseInt(prop.getProperty("server-port"));
			portclient = Integer.parseInt(prop.getProperty("port"));
		
		} catch (Exception e) {
			System.out.println("Arquivo de configuração não encontrado:"
					+ "\nC:/Users/Temp/workspace/config.properties");
		}

	}

	public static void main(String[] args) {
      
		loadProperties();
		ServerChat sc = new ServerChat(portServer, name);
		Thread threadServer = new Thread(sc);
		threadServer.start();

		ClienteChat cc = new ClienteChat(ip,portclient);
		Thread threadCliente = new Thread(cc);
		threadCliente.start();
	}

}
