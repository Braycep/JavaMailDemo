package test.braycep.javamail;

import java.io.*;

public class ReadUserListFile {

    private static String userName;
    private static String userEMail;

    public static void main(String[] args) throws Exception{
        File userListFile = new File("C:\\Users\\Braycep\\Desktop","trg.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(userListFile),"GBK"));
        String line;
        while ((line = br.readLine()) != null) {
            userName = line.split(",")[0];
            userEMail = line.split(",")[1];
            System.out.println("UserName:\n"+userName+"\nEMail:\n"+userEMail+"\n");
            String contents = "尊敬的用户："+userName+", 这是来自您的好友Windsail<1907371801>的邮件：" +
                    "他祝您在即将到来的新的一年里，一帆风顺、二龙腾飞、三羊开泰、四季平安、五福临门、六六大顺、七星高照、八方来财、九九同心、十全十美。" +
                    "以及，新年快乐！d=====(￣▽￣*)b" ;
            Main.start(userName, userEMail, contents);
        }
    }
}
