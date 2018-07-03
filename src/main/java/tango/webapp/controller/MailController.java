package tango.webapp.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tango.webapp.repository.UserRepository;

import javax.mail.internet.MimeMessage;

@ComponentScan
@Controller
public class MailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private Configuration freemarkerConfig;

    @Autowired
    UserController userController;

    @RequestMapping(value = "/confirmation", method = RequestMethod.GET)
    public String confirmation() {
        try {
            sendEmail();
            return "confirmation";
        } catch(Exception ex) {
            return "Error in sending email: " +ex;
        }
    }


    private void sendEmail() throws Exception {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/");
        Template template = freemarkerConfig.getTemplate("mailTemplate.ftl");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, userController.getUserFormModelMap());

        helper.setTo(userController.getUserFormModelMap().get("eMail"));
        helper.setText(text, true);
        helper.setSubject("Autumn Tango Rhapsodies - Registration");
        javaMailSender.send(message);
        userController.getUserFormModelMap().clear();
    }
}
