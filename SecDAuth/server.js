const e = require("express");

const app = e();

const path = require("path");

const mongoose = require("mongoose");

app.use(e.urlencoded({ extended: true }));

mongoose
  .connect(
    "mongodb+srv://piebytwo014:piebytwo014@cluster0.wjqex.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"
  )
  .then(() => {
    console.log("Database connection Success");
  })
  .catch((err) => {
    console.log("Some issue in database ", err);
  });

const userSchema = mongoose.Schema({
  firstName: String,
  lastName: String,
  email: String,
  password: String,
  isActive: Boolean,
});

const userModel = mongoose.model("user", userSchema);

app.get("/", (request, response) => {
  response.sendFile(path.join(__dirname, "public", "index.html"));
});
app.get("/login", (request, response) => {
  response.sendFile(path.join(__dirname, "public", "login.html"));
});
app.get("/register", (request, response) => {
  response.sendFile(path.join(__dirname, "public", "register.html"));
});
app.post("/create-new-user", async (request, response) => {
  const { firstname, lastname, email, password } = request.body;

  try {
    const exist = await userModel.findOne({ email: email });
    if (exist) {
      console.log("Email Already in use");
    } else {
      const newUser = await new userModel({
        firstName: firstname,
        lastName: lastname,
        email: email,
        password: password,
        isActive: false,
      });

      await newUser.save();
      console.log("Account creation success");
    }
  } catch (error) {
    console.log("issue in newuser", error);
  }
});
app.post("/login-user", async (request, response) => {
  try {
    const { email, password } = request.body;
    const loginUser = await userModel.findOne({ email: email });
    if (!loginUser) {
      console.log("User does not exist");
    } else if (loginUser.password == password && loginUser.isActive) {
      console.log("Login Success");
    } else if (loginUser.password == password && !loginUser.isActive) {
      console.log("Please verify your to login");
    } else if (loginUser.password != password) {
      console.log("The password is invalid");
    }
  } catch (error) {
    console.log("Issue in login", error);
  }
});

app.listen(9595, () => {
  console.log("Server Started");
});
