package net.sparkworks.resource.template.configuration;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

@Configuration
public class SslConfiguration {
    
    public static final String SSL_NAME = "SSL";
    
    @PostConstruct
    public void init() throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[]{trustEverythingX509TrustManager()};
        SSLContext sc = SSLContext.getInstance(SSL_NAME);
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
    }
    
    private X509TrustManager trustEverythingX509TrustManager() {
        return new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
            
            public void checkClientTrusted(X509Certificate[] certs, String authType) { }
            
            public void checkServerTrusted(X509Certificate[] certs, String authType) { }
        };
    }
    
}
