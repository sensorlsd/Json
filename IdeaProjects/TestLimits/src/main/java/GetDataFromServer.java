import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;


class GetDataFromServer {
    public static String arg = System.getProperty("game");


    private static String GetAdminToken() throws IOException {

        String urlParameters = "secretKey=MASTER_KEY-swftest_ENTITY-swftest_BRAND&username=swftest_USER&password=swftest_QaZ321!";
        String request = "http://api.cd2.d.skywind-tech.com/v1/login";
        URL url = new URL(request);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        return conn.getHeaderField("x-access-token");

    }

    static JSONObject GetJson() throws IOException {
        String x_access_token;
        x_access_token = GetAdminToken();
        String request = "http://api.cd2.d.skywind-tech.com/v1/games/" + arg;
        URL url = new URL(request);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("x-access-token", x_access_token);

        BufferedReader reader;

        // read json
        InputStream inputStream = conn.getInputStream();
        StringBuilder buffer = new StringBuilder();

        reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        return new JSONObject(buffer.toString());

    }

    static JSONObject GetLocalJson() throws Exception {
        String file = new String(Files.readAllBytes(Paths.get("src/main/resources/" + arg +".json")));

        return new JSONObject(file);

    }

}
