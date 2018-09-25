package Util;/**
 * Created by Administrator on 2018/9/18 0018.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 文件转json
 * @Author: yangjin
 * @CreateDate: 2018/9/18 0018$ 21:48$
 * @Version: 1.0
 */
public class FileToJson {
    public static void fileToJson(String path){
        List<Map<String,String>> list=new ArrayList<Map<String, String>>();
        FileInputStream is=null;
        BufferedReader br=null;
        StringBuilder sb=null;
        byte[] bytes=null;
        String s=null;
        int count=0;
        String[] split=null;
        HashMap<String, String> map=null;
        try {
            is = new FileInputStream(path);
            br = new BufferedReader(new InputStreamReader(is));
            while((s=br.readLine())!=null){
                 if(count!=0){
                   split = s.split("\t");
                   for(int i=0;i<split.length;i++){
                       System.out.println(split[i]+"****"+i);
                   }
                     System.out.println(split.length);
                     map = new HashMap<String, String>();
                     map.put("md5",split[0]);
                     System.out.println(split[0]+"**"+"0");
                     map.put("filename",split[1]+"**"+"1");
                     System.out.println(split[1]+"**"+"1");
                     map.put("thname",split[2]+"**"+"2");
                     System.out.println(split[2]+"**"+"2");
                     list.add(map);

                 }
                 count++;
            }
            JSONArray ja = JSONArray.parseArray(JSON.toJSONString(list));
            //System.out.println(ja);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        fileToJson("C:\\Users\\Administrator\\Desktop\\20180917_readme.txt");
    }
}
