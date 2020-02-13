package com.july.admin.vo;

import com.july.admin.util.DateUtil;
import org.apache.commons.lang.time.DateUtils;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: july
 * @date: 2020/2/12 13:30
 * @description:
 */
public class ComputeDuration {

    List<Node> container = new LinkedList<>();

    private static long ONE_DAY=1000*3600*24;

    public boolean contains(Date start ,Date end){

        if(start.compareTo(end)>0){
            throw new RuntimeException("开始时间不能大于结束时间");
        }

        start = DateUtil.formatDate(start);
        end = DateUtil.formatDate(end);

        Node node = new Node(start,end);
        for (Node exist :container){
            if(node.start.compareTo(exist.start)>=0 && node.end.compareTo(exist.end)<0){
                return true;
            }
        }
        return false;
    }

    private void add (Date start ,Date end ){

        if(start.compareTo(end)>0){
            throw new RuntimeException("开始时间不能大于结束时间");
        }

        start = DateUtil.formatDate(start);
        end = DateUtil.formatDate(end);

        Node node = new Node(start,end);

        container= merge(node,container);
    }

    private List<Node> merge(Node node, List<Node> list) {
        for (Node exist: list){
            List<Node> others = list.stream().filter(x->!x.equals(exist)).collect(Collectors.toList());
            if(node.start.compareTo(exist.start)>=0 && node.end.compareTo(exist.end)<=0){
                return list;
            }
            if(node.start.compareTo(exist.start)<0 && node.end.compareTo(exist.start)>=0 && node.end.compareTo(exist.end)<=0){
                exist.start = node.start;
                return merge(exist,others);
            }
            if(node.start.compareTo(exist.start)>0 && node.start.compareTo(exist.end)<=0 && node.end.compareTo(exist.end)>=0){
                exist.end=node.end;
                return merge(exist,others);
            }
            if(node.start.compareTo(exist.start)<0 && node.end.compareTo(exist.end)>=0){
                exist.start = node.start;
                exist.end = node.end;
                return merge(exist,others);
            }
            if(node.start.getTime()-exist.end.getTime()>=0 && node.start.getTime()-exist.end.getTime()<=ONE_DAY){
                exist.end= node.end;
                return merge(exist,others);
            }


            if(exist.start.getTime()-node.end.getTime()>=0 && exist.start.getTime()-node.end.getTime()<=ONE_DAY){
                exist.start= node.start;
                return merge(exist,others);
            }
        }
        list.add(node);
        return list;
    }

    public static class Node{

        private Date start;
        private Date end;

        public Node(Date start, Date end) {
            this.start = start;
            this.end = end;
        }
    }


    public static void main(String[] args) {
        Date data1 =DateUtil.stringToDate("2020-01-01 12:01:00",DateUtil.DATE_TIME_PATTERN);
        Date data2 =DateUtil.stringToDate("2020-01-02 12:02:00",DateUtil.DATE_TIME_PATTERN);
        Date data3 =DateUtil.stringToDate("2020-01-03 12:03:00",DateUtil.DATE_TIME_PATTERN);
        Date data4 =DateUtil.stringToDate("2020-01-04 12:04:00",DateUtil.DATE_TIME_PATTERN);
        Date data5 =DateUtil.stringToDate("2020-01-05 12:05:00",DateUtil.DATE_TIME_PATTERN);
        Date data6 =DateUtil.stringToDate("2020-01-06 12:06:00",DateUtil.DATE_TIME_PATTERN);
        Date data7 =DateUtil.stringToDate("2020-01-07 12:07:00",DateUtil.DATE_TIME_PATTERN);
        Date data8 =DateUtil.stringToDate("2020-01-08 12:08:00",DateUtil.DATE_TIME_PATTERN);

        ComputeDuration duration = new ComputeDuration();
        duration.add(data1,data2);
        duration.add(data4,data6);
        duration.add(data5,data7);
        duration.add(data1,data2);

        System.out.println(duration.contains(data1,data7));
        System.out.println();
    }
}
