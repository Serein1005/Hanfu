package com.myapp.hanfu;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Fragment_Search extends Fragment{
    private Button button;
    private TextView textView;
    public static String API_KEY = "http://apis.juhe.cn/cxdq/brandx";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search,container,false);
        button = (Button) view.findViewById(R.id.bt_car_cearch);
        textView = (TextView) view.findViewById(R.id.tv_car_search);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.bt_car_cearch) {
                    sendRequestWithOkHttp();
                    //sendRequestWithHttpURLConnection();
                    //queryBrand("B");
                }
            }
        });
        return view;
    }
    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://apis.juhe.cn/cxdq/brand?key=f7f3a98d65a4f5bbb107f7cdaf1ac7e4&first_letter=B")
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    showResponse(responseData);
                    //parseJSONWithJSONObject(responseData);
                    parseJSONWithGSON(responseData);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void sendRequestWithHttpURLConnection() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                InputStream in = null;
                try {
                    //通过connection连接，获取输入流
                    URL url = new URL("http://apis.juhe.cn/cxdq/brandx");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");

                    String content = "key=f7f3a98d65a4f5bbb107f7cdaf1ac7e4&first_letter=B";//拼接需要发送的内容；以字节的方式写入到输出流中；
                    OutputStream is = connection.getOutputStream();
                    is.write(content.getBytes());

                    in = connection.getInputStream();
                    //对输入流进行读取
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    //showResponse(response.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        });
    }

    private void showResponse(final String response) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //在这里进行UI操作，将返回数据显示到界面上
                textView.setText(response);
            }
        });
    }

    private void parseJSONWithJSONObject(String jsonData) {
        try {
            JSONObject arr = new JSONObject(jsonData);
            JSONArray jsonArray = arr.getJSONArray("result");
            //JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String brand_name = jsonObject.getString("brand_name");
                String brand_logo = jsonObject.getString("brand_logo");
                String first_letter = jsonObject.getString("first_letter");
                Log.d("all", "id is: " + id);
                Log.d("all", "brand_name is: " + brand_name);
                Log.d("all", "brand_logo is: " + brand_logo);
                Log.d("first_letter", "first_letter is: " + brand_logo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Car parseJSONWithGSON(String jsonData) {
        Gson gson = new Gson();
        /*//TYPE[] enums = gson.fromJson(jsonStr, TYPE[].class);
        Car.mCar[] list = gson.fromJson(jsonData,Car.mCar[].class);
        for (int i = 0; i < list.length; i++) {
            Log.d("all","id is: " + list[i].getId());
            Log.d("all","brand_name is: " + list[i].getBrand_name());
            Log.d("all","brand_logo is: " + list[i].getBrand_logo());
            Log.d("first_letter","first_letter is: " + list[i].getFirst_letter());
        }*/
        Car cars = new Car();
        //List<Car.mCar> carList = gson.fromJson(jsonData,new TypeToken<List<Car.mCar>>(){}.getType());
        cars = gson.fromJson(jsonData, (Type) Car.class);
        for (Car.mCar car: cars.getResult()){
            Log.d("all","id is: " + car.getId());
            Log.d("all","brand_name is: " + car.getBrand_name());
            Log.d("all","brand_logo is: " + car.getBrand_logo());
            Log.d("first_letter","first_letter is: " + car.getFirst_letter());
        }
        return cars;
    }
        /*Gson gson = new Gson();
        //Gson把json字符串解析成对象
        Car mCar = gson.fromJson(jsonData, Car.class);
        //从对象中拿到集合
        List<Car.mCar> CarList = mCar.getResult();
        for (Car.mCar car : CarList) {
            Log.d("all", "id is: " + car.getId());
            Log.d("all", "brand_name is: " + car.getBrand_name());
            Log.d("all", "brand_logo is: " + car.getBrand_logo());
            Log.d("first_letter", "first_letter is: " + car.getFirst_letter());
        }*/
}
