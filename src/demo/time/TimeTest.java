package demo.time;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class TimeTest {

    static void testDate(){
        //获取日期
        Date date = new Date();
        System.out.println(date);
        //获取从1900年加某日期的日期
        Date d2 = new Date(10,0,10);
        System.out.println(d2);
        //用prinntf来格式化日期
        //c的使用
        System.out.printf("全部日期和时间信息：%tc%n",date);
        //f的使用
        System.out.printf("年-月-日格式：%tF%n",date);
        //d的使用
        System.out.printf("月/日/年格式：%tD%n",date);
        //r的使用
        System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);
        //t的使用
        System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);
        //R的使用
        System.out.printf("HH:MM格式（24时制）：%tR",date);
        System.out.println("----------");
        //date转String
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s1 = sdf.format(date);
        System.out.println(s1);
    }

    static void testCalendar(){
        //获取日历
        Calendar c = Calendar.getInstance();
        //获取日历中的Date
        System.out.println("Date"+c.getTime());
        System.out.println(""+c.getFirstDayOfWeek());
    }

    static void testLocalDateTime(){
        //获取日期时间
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        //LocaDateTime转String
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String s1= dtf.format(ldt);
        System.out.println(s1);
    }

    static void testSystemTime(){
        //获取
        long time = System.currentTimeMillis();
        System.out.println(time);
        //转字符串
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String s1= sdf.format(time);
        System.out.println(s1);
    }

    static void transfer(){
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(date);
    }

    static void getTime(){
        long nowTimeMills = System.currentTimeMillis();
        LocalDate date = LocalDate.now();
        LocalDateTime time = LocalDateTime.now();
        System.out.println(nowTimeMills);
        System.out.println(date);
        System.out.println(time);

    }

    public static void main(String[] args) {
        //getTime();
        //testDate();
        //testCalendar();
        //testLocalDateTime();
        testSystemTime();
    }
}
