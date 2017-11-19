package test.braycep.javamail;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtil {
    private static Properties properties = null;
    private static User user = null;
    private static String[] mails = null;
    private static MimeMessage message = null;

    /**
     * 创建用户
     * @param account 邮箱账户
     * @param password 邮箱登陆密码
     */
    public static void setUser(String account,String password,String mailHost,String mailProtocol){
        user = new User();
        user.setUsername(account);
        user.setPassword(password);
        user.setMailHost(mailHost);
        user.setMailPtotocol(mailProtocol);
    }

    /**
     * 设置目标邮箱
     * @param mail 目标邮箱的数组
     */
    public static void setDestAddress(String mail[]){
        mails = mail;
    }

    /**
     * 设置邮件内容
     * @param subjet 主题
     * @param content 内容
     */
    public static void setMailContent(String subjet,String content){
        MailContent.subjet = subjet;
        MailContent.content = content;
    }

    /**
     * 根据邮箱主机地址和邮件协议创建配置文件
     * @return 返回配置文件
     * @throws Exception
     */
    public static Properties createPropertiese() throws Exception{
        properties = new Properties();
        properties.setProperty("mail.debug","true");
        properties.setProperty("mail.host",user.getMailHost());
        properties.setProperty("mail.smtp.auth","true");
        properties.setProperty("mail.transport.protocol",user.getMailPtotocol());

        MailSSLSocketFactory ssl = new MailSSLSocketFactory();
        ssl.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.ssl.socketFactory",ssl);

        return properties;
    }

    /**
     * 根据配置创建会话
     * @param properties 配置信息
     * @return 返回会话对象
     * @throws Exception
     */
    public static Session createSession(Properties properties) throws Exception{
        Session session = Session.getDefaultInstance(properties);
        return session;
    }

    /**
     * 根据会话创建传输通道，并使用用户user开启连接
     * @param session 邮件会话
     * @return 返回传输会话
     * @throws Exception
     */
    public static Transport createTransport(Session session) throws Exception{
        Transport transport = session.getTransport();
        transport.connect(user.getMailHost(),user.getUsername(),user.getPassword());
        return transport;
    }

    /**
     * 根据会话，创建简单的消息
     * @param session 会话
     * @return 返回信息message
     * @throws Exception
     */
    public static MimeMessage createSimpleMessage(Session session) throws Exception{
        message = new MimeMessage(session);
        message.setFrom(new InternetAddress(user.getUsername()));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(mails[0]));
        if (MailContent.content != "" && MailContent.subjet != "") {
            message.setSubject(MailContent.subjet);
            message.setContent(MailContent.content,"text/html;charset=utf-8");
        }
        return message;
    }
}
