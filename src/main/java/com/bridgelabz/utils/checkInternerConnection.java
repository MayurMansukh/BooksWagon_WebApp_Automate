/**
 * Description : add check internet connection before test excutions
 * Author      : Mayur Mansukh
 * Date        : 9/6/21
 */
package com.bridgelabz.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class checkInternerConnection {

    public void check_internet_connectivity() {
        try {
            final URL url = new URL("");
            Thread.sleep(1000);
            final URLConnection conn = url.openConnection();
            conn.connect();
            conn.getInputStream().close();
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
