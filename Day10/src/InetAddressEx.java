import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressEx {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress iaddr = InetAddress.getLocalHost();
		System.out.printf("호스트 이름 : %s %n", iaddr.getHostName());
		System.out.printf("호스트 IP 주소 : %s %n", iaddr.getHostAddress());
		
		iaddr = InetAddress.getByName("toss.im");
		System.out.printf("호스트 이름 : %s %n", iaddr.getHostName());
		System.out.printf("호스트 IP 주소 : %s %n", iaddr.getHostAddress());
		
		InetAddress sw[] = InetAddress.getAllByName("www.naver.com");
		for (InetAddress temp_sw : sw) {
			System.out.printf("호스트 이름 : %s , ", temp_sw.getHostName());
			System.out.printf("호스트 ip 주소 : %s %n", temp_sw.getHostAddress());
		}

	}

}
