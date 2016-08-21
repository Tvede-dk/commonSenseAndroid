package com.tvede.CommonSenseAndroid.internet;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;

/**
 * Created by kasper on 21-08-2016.
 * purpose of this class is to help with various ssl purposes:
 * - enabling TLS 1.2 for android 16-19 where this is not activated by default. [and disable the old onces, for safty]
 * - SSL pining ? (VIA OKHTTP)
 * -
 */
public class SSLHelper {


    /**
     * @param builder
     * @param forceSet if true, will set it non the less if the android api version is >= 21 (LOLLIPOP)
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     */
    public static void enableTls(@NonNull OkHttpClient.Builder builder, boolean forceSet) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        if (forceSet || Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            TrustManagerFactory trustInstance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustInstance.init((KeyStore) null);
            TrustManager[] managers = trustInstance.getTrustManagers();
            if (managers != null && managers.length > 0 && managers[0] != null) {
                X509TrustManager manager = (X509TrustManager) managers[0];
                builder.sslSocketFactory(new TLSSecureSocketFactory(), manager);
            }
        }
    }


    private static class TLSSecureSocketFactory extends SSLSocketFactory {
        @NonNull
        private SSLSocketFactory factory;

        public TLSSecureSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, null, null);
            factory = context.getSocketFactory();
        }

        @Nullable
        @Override
        public String[] getDefaultCipherSuites() {
            return factory.getDefaultCipherSuites();
        }

        @Nullable
        @Override
        public String[] getSupportedCipherSuites() {
            return factory.getSupportedCipherSuites();
        }

        @Nullable
        @Override
        public Socket createSocket(Socket socket, String s, int i, boolean b) throws IOException {
            return handleSocket(factory.createSocket(socket, s, i, b));
        }


        /**
         * changes the protocols on the given socket iff its an SSLsocket. (enables tls.1.1, and 1.2)
         *
         * @param socket
         * @return the socket input
         */
        @Nullable
        private Socket handleSocket(@Nullable Socket socket) {
            if ((socket instanceof SSLSocket)) {
                ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.1", "TLSv1.2"});
            }
            return socket;
        }

        @Nullable
        @Override
        public Socket createSocket(String s, int i) throws IOException {
            return handleSocket(factory.createSocket(s, i));
        }

        @Nullable
        @Override
        public Socket createSocket(String s, int i, InetAddress inetAddress, int i1) throws IOException {
            return handleSocket(factory.createSocket(s, i, inetAddress, i1));
        }

        @Nullable
        @Override
        public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
            return handleSocket(factory.createSocket(inetAddress, i));
        }

        @Nullable
        @Override
        public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress1, int i1) throws IOException {
            return handleSocket(factory.createSocket(inetAddress, i, inetAddress1, i1));
        }
    }

}
