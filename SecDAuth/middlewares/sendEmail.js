const nodemailer = require("nodemailer");
const jwt = require('jsonwebtoken');
const JWT_SECRET="this_is_top_secret"

const sendMail = (email)=>{
  const transport = nodemailer.createTransport({
    service: "gmail",
    auth: {
      user: "test.duck.mail@gmail.com",
      pass: "gdhgohiwgbuifkbk",
    },
  });

  const token = jwt.sign({email:"dgfbd@gmail.com"},JWT_SECRET,{expiresIn:"10m"})

  // http://localhost:9595/register

  const verificationLink = `http://localhost:9595/verify-email?token=${token}`;

  
  const mail = {
    from: "test.duck.mail@gmail.com",
    to: email ,
    subject: "Account Creation Success",
    text: "",
    html:`<p>Congrats! your account has been created successfully. \nPlease click on the <a href=${verificationLink}>link</a> to verify your account \n \n Regards, \n Team RDEC.</p> <br><br><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR44QCVmeN2KCvKs9H1KBt_cvJZPZqAOaX5NA&s" alt="Image with red border" style="border: 5px solid red;">`
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