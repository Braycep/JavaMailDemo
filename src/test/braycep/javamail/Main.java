package test.braycep.javamail;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        start();
    }

    protected static void start(String userName, String userEMail, String contents){
        try{
            //创建包含用户信息和邮件协议的用户体对象
            MailUtil.setUser("braycep@foxmail.com","rkscbxfesaewbcga","smtp.qq.com","smtp");
            //设置目标邮箱
            MailUtil.setDestAddress(new String[]{userEMail});
            //设置邮件内容
            MailUtil.setMailContent(userName, contents);
            //创建会话，会先创建配置，在创建会话
            Session session = MailUtil.createSession(MailUtil.createPropertiese());
            //创建信息
            Message message = MailUtil.createSimpleMessage(session);
            //创建传输通道，已经连接
            Transport transport = MailUtil.createTransport(session);
            //使用传输通道发送邮箱
            transport.sendMessage(message,message.getAllRecipients());
            //关闭传输通道
            transport.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void start() {
        Scanner scanner = new Scanner(System.in);
        String destMailAddr = "";
        String mailTitle = "";
        String mailContent = "";
        System.out.println("Input The Dest Mail Address:");
        destMailAddr = scanner.nextLine();
        System.out.println("Input The Dest Mail Title:");
        mailTitle = scanner.nextLine();
        System.out.println("Input The Dest Mail Content:");
        mailContent = scanner.nextLine();
        scanner.close();
        int i = 1;
        while(i > 0) {
            try{
                //创建包含用户信息和邮件协议的用户体对象
                MailUtil.setUser("braycep@foxmail.com","rkscbxfesaewbcga","smtp.qq.com","smtp");
                //设置目标邮箱
                MailUtil.setDestAddress(new String[]{destMailAddr});
                //设置邮件内容
                MailUtil.setMailContent(mailTitle,mailContent);
                //创建会话，会先创建配置，在创建会话
                Session session = MailUtil.createSession(MailUtil.createPropertiese());
                //创建信息
                Message message = MailUtil.createSimpleMessage(session);
                //创建传输通道，已经连接
                Transport transport = MailUtil.createTransport(session);
                //使用传输通道发送邮箱
                transport.sendMessage(message,message.getAllRecipients());
                //关闭传输通道
                transport.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            i--;
            System.out.println("----------------------"+i);
        }
    }
}
