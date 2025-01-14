package structural.proxy;
/**
 * Proxy is an object that represent another object
 * and all operators to that object must be redirected to proxy then proxy call that object
 * Type of proxy:
 * + Virtual proxy: created immediate whenever has request execute app
 * + Protection proxy: client scope are different, checking access permission when has a request
 * + Remote proxy: reference to an object is protected from factors outside application
 * + Monitor proxy: establish security on object need to protect, prevent client access significant fields of object. Can track, monitor, write log, use object
 * + Firewall proxy: protect object by reject request form trustless clients
 * + Cache proxy: Provide temp storage space for response result form someone obj. It can share to clients with same request. Same Flyweight pattern
 * + Smart Reference proxy: control additional activities when object is referenced
 * + Synchronization proxy: Ensure multiple clients access without conflict. When a client hold lock to long, queue still grow bigger. Leading to bottleneck
 * + Copy on write proxy: Ensure no one have to wait forever. This design is very complicated
 */

public class VirtualProxy {
    public static void main(String[] args) {
        System.out.println("Init proxy image: ");
        ProxyImage proxyImage = new ProxyImage("http://alibaba.com/xu-chieng.jpeg");

        System.out.println("---");
        System.out.println("Call real service 1st: ");
        proxyImage.showImage();

        System.out.println("---");
        System.out.println("Call real service 2nd: ");
        proxyImage.showImage();
    }
}
interface Image {
    void showImage();
}
class RealImage implements Image {
    private String url;
    public RealImage(String url) {
        this.url = url;
    }
    @Override
    public void showImage() {
        System.out.println("It is real image!, Url: " + url);
    }
}
class ProxyImage implements Image {
    private RealImage realImage;
    private String url;
    public ProxyImage(String url) {
        this.url = url;
    }
    @Override
    public void showImage() {
        if (realImage == null) {
            realImage = new RealImage(url);
        } else {
            System.out.println("Image already existed");
        }
        realImage.showImage();
    }
}
