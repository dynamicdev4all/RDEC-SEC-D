const e = require("express");

const app = e();

const path = require("path");

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
app.post("/create-new-user", (request, response) => {
  console.log(request.body);
});
app.post("/login-user", (request, response) => {
  console.log("Login is here");
});

app.listen(9595, () => {
  console.log("Server Started");
});
