const e = require("express");
const app = e();
const path = require("path");
const { userRegister, userLogin } = require("./controller/userController");
const db = require("./config/databaseConn");
db();
app.use(e.urlencoded({ extended: true }));

app.get("/", (request, response) => {
  response.sendFile(path.join(__dirname, "public", "index.html"));
});
app.get("/login", (request, response) => {
  response.sendFile(path.join(__dirname, "public", "login.html"));
});
app.get("/register", (request, response) => {
  response.sendFile(path.join(__dirname, "public", "register.html"));
});
app.get("/verify-email", (request, response) => {
  console.log("Token has been rec")
  console.log(request.query.token)
});
app.post("/create-new-user", async (request, response) => {
  const { firstname, lastname, email, password } = request.body;
  userRegister(firstname, lastname, email, password);
});
app.post("/login-user", async (request, response) => {
  const { email, password } = request.body;
  userLogin(email, password);
});

app.listen(9595, () => {
  console.log("Server Started");
});
