package test.braycep.javamail;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;

public class Main {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        try{
            //创建包含用户信息和邮件协议的用户体对象
            MailUtil.setUser("braycep@foxmail.com","rkscbxfesaewbcga","smtp.qq.com","smtp");
            //设置目标邮箱
            MailUtil.setDestAddress(new String[]{"1907371801@qq.com"});
            //设置邮件内容
            MailUtil.setMailContent("Hello,Braycep!","Hello,Braycep.Frome Intellij Idea");
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
}
