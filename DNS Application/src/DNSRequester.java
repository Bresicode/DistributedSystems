import java.net.InetAddress;
import java.net.UnknownHostException;

public class DNSRequester {

    public static void main(String[] args) {
        InetAddress ia;
        if(args.length == 0){
            System.out.println("Es wurde keine DNS-Host-Name eingegeben!");
        }else{
            try {
                ia = InetAddress.getByName(args[0]);
                System.out.println("Ip Adresse: "+ia.getHostAddress() + " DNS-Host-Name: " + ia.getHostName());
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }
}