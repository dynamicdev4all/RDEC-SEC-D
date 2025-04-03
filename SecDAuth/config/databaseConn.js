const mongoose = require("mongoose");

const db = () => {
  mongoose
    .connect(
      "mongodb+srv://piebytwo014:piebytwo014@cluster0.wjqex.mongodb.net/SEC-D?retryWrites=true&w=majority&appName=Cluster0"
    )
    .then(() => {
      console.log("Database connection Success");
    })
    .catch((err) => {
      console.log("Some issue in database ", err);
    });
};

module.exports = db;
