const nodemailer = require("nodemailer");
const jwt = require('jsonwebtoken');
const JWT_SECRET="this_is_top_secret"

const sendMail = (email, userName)=>{
  const transport = nodemailer.createTransport({
    service: "gmail",
    auth: {
      user: "test.duck.mail@gmail.com",
      pass: "gdhgohiwgbuifkbk",
    },
  });

  const token = jwt.sign({email},JWT_SECRET,{expiresIn:"5m"})
  console.log(token)


  const verificationLink = `http://localhost:9595/verify-email?token=${token}`;

  
  const mail = {
    from: "test.duck.mail@gmail.com",
    to: email ,
    subject: "Account Creation Success",
    text: "",
    html:`<p style="font-family: Arial, sans-serif; font-size: 16px; color: #333; line-height: 1.5;">
  <strong style="font-size: 18px; color: #4CAF50;">Congrats! ${userName}</strong> Your account has been created successfully.<br><br>
  Please click on the <a href="${verificationLink}" style="color: #007bff; text-decoration: none; font-weight: bold;">link</a> to verify your account.<br><br>
  <div style="margin-top: 20px;">
    <p style="font-size: 14px; color: #666;">If you did not create an account, please ignore this message.</p>
  </div>
  <br>
  <div style="font-size: 14px; color: #333;">
    <p>Regards,</p>
    <p style="font-weight: bold; color: #4CAF50;">Team RDEC</p>
  </div>
</p>
`
  };
  
  transport.sendMail(mail, (err) => {
    if (err) {
      console.log("Email not sent", err);
    } else {
      console.log("Email sent success");
    }
  });  
}

module.exports = sendMail;