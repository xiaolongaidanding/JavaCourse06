package week2;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class httpclient {
    private OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        String url = "http://localhost:8801";
        try {
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                System.out.println(response.body().string());
            } else {
                System.out.println("连接失败");
            }
        } catch (IOException e) {
            StringWriter sw=new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            System.out.println(sw.getBuffer().toString());
        }
    }

}

