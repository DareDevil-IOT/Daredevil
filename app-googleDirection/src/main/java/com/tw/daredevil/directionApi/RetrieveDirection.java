package com.tw.daredevil.directionApi;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

public class RetrieveDirection {
    private static Logger LOGGER = Logger.getLogger("InfoLogging");

    public void downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            LOGGER.info("Reading data from url....");
            iStream = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();
            br.close();
            LOGGER.info("data is writing into direction.json file..");
            PrintWriter printWriter = new PrintWriter("data/direction.json");
            printWriter.print(data);

        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
    }

}
