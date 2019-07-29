package com.wuxg.ex.util;

import com.wuxg.ex.domain.LogStatistics;
import com.wuxg.ex.mapper.LogStatisticsMapper;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wuxianguang
 */
public class ReadFile {
    @Autowired
    private LogStatisticsMapper logStatisticsMapper;

    private List statisticsList = new ArrayList();
    public static void main(String[] args) {

//        //统计
//        HashMap<String, HashMap<String, Long>> statistics = readFile.statistics(list);
//        Set<Map.Entry<String, HashMap<String, Long>>> entries = statistics.entrySet();
//        Iterator<Map.Entry<String, HashMap<String, Long>>> iterator = entries.iterator();
//        //插入数据
//        while (iterator.hasNext()){
//
//        }
    }

    /**
     * 读取文件file
     */
    public  List readFile(){
        String path = "C:\\Users\\wuxianguang\\Desktop\\java实操题\\数据文件\\file.txt";
        List<String> list = new ArrayList<>();
        try {
            list= FileUtils.readLines(new File(path));
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    public HashMap<String,HashMap<String,Long>> statistics(List list){
        HashMap<String,HashMap<String,Long>> hashMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i).toString();
            String timeStr = getTime(s);
            if (!hashMap.containsKey(timeStr)){
                String version = getVersion(s);
                HashMap<String, Long> temp = new HashMap<>();
                //不存在
                if (!temp.containsKey(version)){
                    temp.put(version,1L);
                }else{
                    //版本已存在 开始计数
                    Long total = temp.get(version);
                    total++;
                    temp.put(version,total);
                }
                hashMap.put(timeStr,temp);
            }else{
                HashMap<String, Long> stringLongHashMap = hashMap.get(timeStr);
                String version = getVersion(s);
                if (!stringLongHashMap.containsKey(version)){
                    stringLongHashMap.put(version,1L);
                }else{
                    Long total = stringLongHashMap.get(version);
                    total++;
                    stringLongHashMap.put(version,total);
                }
            }
        }

        return hashMap;
    }

    /**
     * 截取时间
     * @param s
     * @return
     */
    public String getTime(String s){
        return s.substring(0,s.indexOf(","));
    }

    /**
     * 获取版本号
     * @param s
     * @return
     */
    public String getVersion(String s){
        return s.substring(s.indexOf(",")+1,s.indexOf(",")+6);
    }

    /**
     * 字符串转为时间
     * @param str
     * @return
     */
    public Date strToDate(String str){
        Date date=null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMhh");
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
