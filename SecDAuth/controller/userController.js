const sendMail = require("../middlewares/sendEmail");
const userModel = require("../models/userModel");
const bcrypt = require("bcrypt");

const userRegister = async (firstname, lastname, email, password) => {
  try {
    const exist = await userModel.findOne({ email: email });
    if (exist) {
      console.log("Email Already in use");
    } else {
      const salt = await bcrypt.genSalt(10);

      const encodedPass = await bcrypt.hash(password, salt);
      const newUser = await new userModel({
        firstName: firstname,
        lastName: lastname,
        email: email,
        password: encodedPass,
        isActive: false,
      });

      await newUser.save();
      sendMail(email)
      console.log("Account creation success");
    }
  } catch (error) {
    console.log("issue in newuser", error);
  }
};
const userLogin = async (email, password) => {
  try {
    const loginUser = await userModel.findOne({ email: email });

    if (!loginUser) {
      console.log("User does not exist");
    } else if (
      (await bcrypt.compare(password, loginUser.password)) &&
      loginUser.isActive
    ) {
      console.log("Login Success");
    } else if (
      (await bcrypt.compare(password, loginUser.password)) &&
      !loginUser.isActive
    ) {
      console.log("Please verify your to login");
    } else if (!(await bcrypt.compare(password, loginUser.password))) {
      console.log("The password is invalid");
    }
  } catch (error) {
    console.log("Issue in login", error);
  }
};

function A(email, password){
    
}

module.exports = {
  userRegister,
  userLogin,
  A
};
