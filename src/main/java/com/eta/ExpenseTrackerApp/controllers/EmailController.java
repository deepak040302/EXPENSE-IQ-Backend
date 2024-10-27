package com.eta.ExpenseTrackerApp.controllers;

import com.eta.ExpenseTrackerApp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/send-email")
    public ResponseEntity<String> sendMail(){

        //add name,message etc thing in the string
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Welcome to Your Expense Tracker</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            background-color: #f4f4f4;\n" +
                "            color: #333;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "        .container {\n" +
                "            max-width: 600px;\n" +
                "            margin: 50px auto;\n" +
                "            background-color: #ffffff;\n" +
                "            border-radius: 10px;\n" +
                "            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\n" +
                "            overflow: hidden;\n" +
                "        }\n" +
                "        .header {\n" +
                "            background-color: #4CAF50;\n" +
                "            color: white;\n" +
                "            padding: 20px;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "        .header h1 {\n" +
                "            margin: 0;\n" +
                "            font-size: 24px;\n" +
                "        }\n" +
                "        .content {\n" +
                "            padding: 20px;\n" +
                "        }\n" +
                "        .content p {\n" +
                "            font-size: 18px;\n" +
                "            line-height: 1.6;\n" +
                "        }\n" +
                "        .content a {\n" +
                "            color: #4CAF50;\n" +
                "            text-decoration: none;\n" +
                "            font-weight: bold;\n" +
                "        }\n" +
                "        .footer {\n" +
                "            background-color: #f4f4f4;\n" +
                "            color: #888;\n" +
                "            text-align: center;\n" +
                "            padding: 10px;\n" +
                "            font-size: 14px;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"container\">\n" +
                "        <div class=\"header\">\n" +
                "            <h1>Welcome Back, Deepak!</h1>\n" +
                "        </div>\n" +
                "        <div class=\"content\">\n" +
                "            <p>Hello,</p>\n" +
                "            <p>We're excited to have you back on <strong>Your Expense Tracker</strong>! \uD83C\uDF89</p>\n" +
                "            <p>Your dashboard is ready to help you track your expenses, income, and stay on top of your financial goals. If you need any help or have any questions, feel free to <a href=\"#\">contact us</a>.</p>\n" +
                "            <p>Let's make managing finances fun and easy!</p>\n" +
                "            <p>Best regards,<br>\n" +
                "            Your Expense Tracker Team</p>\n" +
                "        </div>\n" +
                "        <div class=\"footer\">\n" +
                "            <p>&copy; 2024 Your Expense Tracker. All rights reserved.</p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>\n";

        emailService.sendEmailWithHtmlContents("er.deepak040302@gmail.com","checking confirmation mail template",html);

        return new ResponseEntity<>("Email send successull", HttpStatus.OK);
    }

}
