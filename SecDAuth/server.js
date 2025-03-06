const e = require("express");

const app = e();

app.get("/", (request, response) => {
  //   console.log("This is the Root Route");
  // response.send("This is the Root Route")
  response.json({ name: "Shubham" });
});
app.get("/login", (request, response) => {
  //   console.log("This is the Login Route");
  response.send("This is the Login Route");
});
app.get("/logout", (request, response) => {
  //   console.log("This is the Logout Route");
  response.send("This is the Logout Route");
});
app.get("/password_reset", (request, response) => {
  //   console.log("This is the Password Reset Route");
  response.send("This is the Password Reset Route Route");
});

app.listen(9595, () => {
  console.log("Server Started");
});
